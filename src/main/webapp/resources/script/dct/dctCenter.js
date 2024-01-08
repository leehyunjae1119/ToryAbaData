var dctAuthList = new Array();

$(document).ready(function () {
	
	$("#centerSaveBtn").on("click", function() {
		var centerName = $("#centerName").val();
		
		if(!$.onValidation(centerName)){
			$.goCenterSave();
		};
	});
	
	$("#centerUpdateBtn").on("click", function() {
		var centerName = $("#centerName").val();
		
		if(!$.onValidation(centerName)){
			$.goCenterUpdate();
		};
	});
	
	$.onclickCenterRemove = function(seq) {
		if(!confirm("삭제 하시겠습니까?")) return;
		
		$("#centerSeq").val(seq);
		$.goCenterRemove();
	};
	
	$.selectCenterList = function() {
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/dct/dctCenterListSelect.ajax",
            success : function(res){
            	res.authList.forEach(function(item) {
            		dctAuthList.push(item.centerSeq);
				});
            	
            	$("#centerBoard").empty();
            	$.makeCenterCard(res.dataList);
            	
            	_checkAuth();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.makeCenterCard = function(dataList) {
		dataList.forEach(function(item) {
			$("#centerBoard").append($.templateCard(item));
		});
		$.makeAddBtn();
	};
	
	$.templateCard = function(data) {
		html = '<div class="col-xl-3 col-md-6 mb-4">'
			+ '<div class="card border-left-warning shadow h-100 py-2" style="min-height: 9rem;">'
			+ '<div class="card-body custom-cursor-pointer" onclick="$.enterCenter(\''+data.centerSeq+'\', \''+data.centerName+'\');">'
			+ '<div class="row no-gutters align-items-center">'
			+ '<div class="col mr-2">'
			+ '<div class="h2 mb-0 font-weight-bold text-gray-800">'+data.centerName+'</div>'
			+ '</div>'
			+ '</div>'
			+ '</div>'
			+ '<div class="custom-card-link">'
			+ '<a href="javascript:void(0);" class="card-link" data-auth="level1" onclick="$.openUpdateModal(\''+data.centerSeq+'\', \''+data.centerName+'\');">수정</a>'
			+ '<a href="javascript:void(0);" class="card-link" data-auth="level1" onclick="$.onclickCenterRemove(\''+data.centerSeq+'\');">삭제</a>'
			+ '</div>'
			+ '</div>'
			+ '</div>';
		return html;
	};
	
	$.makeAddBtn = function() {
		var html = '<div class="col-xl-3 col-md-6 mb-4" data-auth="level1">'
				 + '<div class="card border-dashed-line shadow h-100 py-2 align-items-center justify-content-center" id="centerAddBtn" onclick="$.openSaveModal();" style="min-height: 9rem;">'
				 + '<i class="fas fa-plus-square fa-2x"></i>'
				 + '</div>'
				 + '</div>';
		
		$("#centerBoard").append(html);
	
	};

	$.openSaveModal = function() {
		$("#centerRegistModalLabel").text("센터 등록");
		$("#centerSaveBtn").show();
		$("#centerUpdateBtn").hide();
		
		$("#centerName").val("");
		$('#centerRegistModal').modal('toggle');
	};
	
	$.openUpdateModal = function(seq, name) {
		$("#centerRegistModalLabel").text("센터 수정");
		$("#centerSaveBtn").hide();
		$("#centerUpdateBtn").show();
		
		$("#centerSeq").val(seq);
		$("#centerName").val(name);
		$('#centerRegistModal').modal('toggle');
		
	};
	
	$.onValidation = function(centerName) {
		if(!nullCheck(centerName)){
			alert("센터 이름을 입력하세요.");
			$("#centerName").focus();
			return true;
		}
		
		return false;
	};
	
	$.goCenterSave = function() {
		var params = $("#dctCenterForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/dct/dctCenterInsert.ajax",
            data : params,
            success : function(res){
            	$('#centerRegistModal').modal('toggle');
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goCenterUpdate = function() {
		var params = $("#dctCenterForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/dct/dctCenterUpdate.ajax",
            data : params,
            success : function(res){
            	$('#centerRegistModal').modal('toggle');
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goCenterRemove = function() {
		var params = $("#dctCenterForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/dct/dctCenterDelete.ajax",
            data : params,
            success : function(res){
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.enterCenter = function(centerSeq, centerName) {
		if(dctAuthList.indexOf(Number(centerSeq)) >= 0 || authCd !== 'level3'){
			
			var form = $('<form></form>');
			form.attr("id", "centerForm");
			form.attr("name", "centerForm");
			form.attr("method", "GET");
			form.attr("action", "../dct/classBoard");
			
			var hiddenField_1 = $('<input/>', {type: 'hidden', name: 'centerSeq', value: centerSeq});
			form.append(hiddenField_1);
			
			var hiddenField_2 = $('<input/>', {type: 'hidden', name: 'centerName', value: centerName});
			form.append(hiddenField_2);
			
			form.appendTo('body');
			form.submit();
			form.remove();
			
		} else {
			alert("접근권한이 없습니다.")
		}
	};

	//초기 동작
	$.init = function() {
		$.selectCenterList();
	};
	
	$.init();
});