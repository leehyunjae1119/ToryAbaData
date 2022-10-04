$(document).ready(function () {
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
		dataList.forEach(function(data) {
			console.log(data)
			var domainScsClass = data[0].domainStatus == 'CMP' ? 'bg-success' : '';
			
			html = '<ul class="c-list-group col-lg-2">';
			
			//LTO
			data.forEach(function(item) {
				if(data[0].ltoName){
					console.log(data[0].ltoName )
					var ltoScsClass = item.ltoStatus == 'CMP' ? 'bg-success' : '';
					
					html += '<li data-value="'+item.ltoSeq+'" data-code="'+item.ltoStatus+'" class="c-list-group-item d-flex justify-content-between align-items-center '+ltoScsClass+'">';
					html += item.ltoName;
					html += '</li>';
					
				}
			});
			
			html += '	<li class="li-sidebar-divider"></li>';
			//domain
			html += '	<li data-value="'+data[0].domainSeq+'" data-code="'+data[0].domainStatus+'" class="c-list-group-item d-flex justify-content-between align-items-center active '+domainScsClass+'">';
			html += 	data[0].domainName;
			html += '	</li>';
			html += '</ul>';
			
			$("#curriculumBoard").append(html);
		});
	};

	//초기 동작
	$.init = function() {
		$.setProfileToggleBtn();
		$.selectCurriculumList();
	};
	
	$.init();
});