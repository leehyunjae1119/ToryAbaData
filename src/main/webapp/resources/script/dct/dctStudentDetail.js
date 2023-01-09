$(document).ready(function () {
	
	$.goConsultingBoard = function(studentSeq) {
		var form = document.createElement("form");
        form.setAttribute("charset", "UTF-8");
        form.setAttribute("method", "GET");  //Post 방식
        form.setAttribute("action", "/dct/consultingBoard"); //요청 보낼 주소

        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "studentSeq");
        hiddenField.setAttribute("value", studentSeq);
        form.appendChild(hiddenField);
        
        document.body.appendChild(form);
        form.submit();
	};
	
	$.goVideoBoard = function(studentSeq) {
		var form = document.createElement("form");
        form.setAttribute("charset", "UTF-8");
        form.setAttribute("method", "GET");  //Post 방식
        form.setAttribute("action", "/dct/videoBoard"); //요청 보낼 주소

        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "studentSeq");
        hiddenField.setAttribute("value", studentSeq);
        form.appendChild(hiddenField);
        
        document.body.appendChild(form);
        form.submit();
	};
	
	$.openReport = function() {
		$("#reportDateModal").modal("show");
	};
	
	$('[data-toggle="tooltip"]').tooltip();
	
	var isToggleProfile = false;
	
	$.toggleProfile = function() {
		isToggleProfile = !isToggleProfile;
		
		$.setProfileToggleBtn();
	};
	
	$.setProfileToggleBtn = function() {
		if(!isToggleProfile){
			$("#profileToggleBtnText").text("프로필 접기");
			$("#profileToggleIcon").removeClass("fa-angle-down");
			$("#profileToggleIcon").addClass("fa-angle-up");
			$("#profileBody").slideDown();
		} else {
			$("#profileToggleBtnText").text("프로필 펼치기");
			$("#profileToggleIcon").removeClass("fa-angle-up");
			$("#profileToggleIcon").addClass("fa-angle-down");
			$("#profileBody").slideUp();
		}
	};
	
	$.selectCurriculumList = function() {
        
        var params = {
        	studentSeq : $("#studentSeq").val()
		};
		$.ajax({
            type : "POST",
            url : "/dct/dctCurriculumListSelect.ajax",
            data : params,
            success : function(res){
            	$.makeCurriculumBoard(res.dataList);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.makeCurriculumBoard = function(dataList) {
		
		$("#curriculumBoard").empty();
		dataList.forEach(function(data) {
			var domainScsClass = data[0].domainStatus == 'CMP' ? 'bg-success text-white' : '';
			
			html = '<ul class="c-list-group col-lg-2">';
			
			//LTO
			data.forEach(function(item) {
				if(data[0].ltoName){
					var ltoScsClass = '';
					
					if(item.ltoStatus == 'CMP') {
						ltoScsClass = 'bg-success text-white';
					} else if (item.ltoStatus == 'STP') {
						ltoScsClass = 'bg-danger text-white';
					} else if (item.ltoStatus == 'ING') {
						ltoScsClass = 'bg-blue text-white';
					} else {
						ltoScsClass = '';
					}
					
					html += '<li name="" data-value="'+item.ltoSeq+'" data-code="'+item.ltoStatus+'" class="c-list-group-item d-flex justify-content-between align-items-center '+ltoScsClass+'">';
					html += item.ltoName;
					html += '</li>';
				}
			});
			
			html += '	<li class="c-li-sidebar-divider"></li>';
			//domain
			html += '	<li data-value="'+data[0].domainSeq+'" data-code="'+data[0].domainStatus+'" class="c-list-group-item one-line d-flex justify-content-between align-items-center '+domainScsClass+'">';
			html += 	data[0].domainName;
			html += '	</li>';
			html += '</ul>';
			
			$("#curriculumBoard").append(html);
		});
	};
	
	$.openPgbEditModal = function() {
		$("#pgbEditModal").modal("show");
	};
	
	$.goCompletionBoard = function(studentSeq) {
		var form = document.createElement("form");
        form.setAttribute("charset", "UTF-8");
        form.setAttribute("method", "GET");  //Post 방식
        form.setAttribute("action", "/dct/completionBoard"); //요청 보낼 주소

        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "studentSeq");
        hiddenField.setAttribute("value", studentSeq);
        form.appendChild(hiddenField);
        
        document.body.appendChild(form);
        form.submit();
	};
	
	$.goRunUnitBoard = function(studentSeq) {
		var form = document.createElement("form");
		form.setAttribute("charset", "UTF-8");
		form.setAttribute("method", "GET");  //Post 방식
		form.setAttribute("action", "/dct/runUnitBoard"); //요청 보낼 주소
		
		var hiddenField = document.createElement("input");
		hiddenField.setAttribute("type", "hidden");
		hiddenField.setAttribute("name", "studentSeq");
		hiddenField.setAttribute("value", studentSeq);
		form.appendChild(hiddenField);
		
		document.body.appendChild(form);
		form.submit();
	};
	$.goCriteriaBoard = function(studentSeq) {
		var form = document.createElement("form");
		form.setAttribute("charset", "UTF-8");
		form.setAttribute("method", "GET");  //Post 방식
		form.setAttribute("action", "/dct/criteriaBoard"); //요청 보낼 주소
		
		var hiddenField = document.createElement("input");
		hiddenField.setAttribute("type", "hidden");
		hiddenField.setAttribute("name", "studentSeq");
		hiddenField.setAttribute("value", studentSeq);
		form.appendChild(hiddenField);
		
		document.body.appendChild(form);
		form.submit();
	};

	//초기 동작
	$.init = function() {
		$.setProfileToggleBtn();
		$.selectCurriculumList();
		
	};
	
	$.init();
	
	$("#pgbEditModal").on('hidden.bs.modal', function() {
		$.selectCurriculumList();
		$.selectDomainChartData();
	});
	
});



