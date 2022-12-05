$(document).ready(function () {
	

	$("#studentSaveBtn").on("click", function() {
		var studentName = $("#studentName").val();
		
		if(!$.onValidation(studentName)){
			$.goStudentSave();
		};
	});
	
	$("#studentUpdateBtn").on("click", function() {
		var studentName = $("#studentName").val();
		
		if(!$.onValidation(studentName)){
			$.goStudentUpdate();
		};
	});
	
	$.onclickStudentRemove = function(seq) {
		if(!confirm("삭제 하시겠습니까?")) return;
		
		$("#studentSeq").val(seq);
		$.goStudentRemove();
	};
	
	$.selectStudentList = function() {
		var params = $("#dctStudentForm").serialize();
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/dct/dctStudentListSelect.ajax",
            data : params,
            success : function(res){
            	$("#studentBoard").empty();
            	$.makeStudentCard(res.dataList);
            	
            	_checkAuth();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.makeStudentCard = function(dataList) {
		dataList.forEach(function(item) {
			$("#studentBoard").append($.templateCard(item));
		});
		$.makeAddBtn();
	};
	
	$.templateCard = function(data) {
		html = '<div class="col-xl-3 col-md-6 mb-4">'
			+ '<div class="card border-left-warning shadow h-100 py-2" style="min-height: 9rem;">'
			+ '<div class="card-body custom-cursor-pointer" onclick="$.enterStudent(\''+data.studentSeq+'\');">'
			+ '<div class="row no-gutters align-items-center">'
			+ '<div class="col mr-2">'
			+ '<div class="text-xs font-weight-bold text-primary text-uppercase mb-1">'+$.getDateFormat(data.studentBirth, "YYYY-MM-DD")+'</div>'
			+ '<div class="h2 mb-0 font-weight-bold text-gray-800">'+data.studentName+'</div>'
			+ '</div>'
			+ '</div>'
			+ '</div>'
			+ '<div class="custom-card-link">'
			+ '<a href="javascript:void(0);" class="card-link" data-auth="level2" onclick="$.openUpdateModal(\''+data.studentSeq+'\');">수정</a>'
			+ '<a href="javascript:void(0);" class="card-link" data-auth="level2" onclick="$.onclickStudentRemove(\''+data.studentSeq+'\');">삭제</a>'
			+ '</div>'
			+ '</div>'
			+ '</div>';
		return html;
	};
	
	$.makeAddBtn = function() {
		var html = '<div class="col-xl-3 col-md-6 mb-4" data-auth="level2">'
				 + '<div class="card border-dashed-line shadow h-100 py-2 align-items-center justify-content-center" id="studentAddBtn" onclick="$.openSaveModal();" style="min-height: 9rem;">'
				 + '<i class="fas fa-plus-square fa-2x"></i>'
				 + '</div>'
				 + '</div>';
		
		$("#studentBoard").append(html);
	
	};

	$.openSaveModal = function() {
		$("#studentRegistModalLabel").text("아동 등록");
		$("#studentSaveBtn").show();
		$("#studentUpdateBtn").hide();
		
		$.setOneStudentData("0");
		$('#studentRegistModal').modal('toggle');
	};
	
	$.openUpdateModal = function(seq) {
		$("#studentRegistModalLabel").text("아동 수정");
		$("#studentSaveBtn").hide();
		$("#studentUpdateBtn").show();
		
		$.setOneStudentData(seq);
		$('#studentRegistModal').modal('toggle');
	};
	
	$.setOneStudentData = function(seq) {
		$("#studentSeq").val(seq);
		var params = $("#dctStudentForm").serialize();
		
		if(seq == "0"){
			$("#studentName").val("");
        	$("#studentBirth").val("");
        	$("#studentEtc").val("");
        	$("#studentStartDt").val("");
        	$("#studentEndDt").val("");
        	
		} else {
			$.ajax({
	            type : "POST",
	            url : "/dct/dctStudentOneSelect.ajax",
	            async: false,
	            data : params,
	            success : function(res){
            		$("#studentName").val(res.data.studentName);
                	$("#studentBirth").val(res.data.studentBirth);
                	$("#studentEtc").val(res.data.studentEtc);
                	$("#studentStartDt").val(res.data.studentStartDt);
                	$("#studentEndDt").val(res.data.studentEndDt);

	            },
	            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
	                alert("서버오류. 담당자에게 연락하세요.")
	            }
	        });
		}
		
	};
	
	$.onValidation = function(studentName) {
		if(!$("#studentName").val()){
			alert("아동 이름을 입력하세요.");
			$("#studentName").focus();
			return true;
		}
		
		if(!$("#studentBirth").val()){
			alert("아동 생년월일을 입력하세요.");
			$("#studentBirth").focus();
			return true;
		}
		
		if(!$("#studentEtc").val()){
			alert("아동 특징을 입력하세요.");
			$("#studentEtc").focus();
			return true;
		}
		
		if(!$("#studentStartDt").val()){
			alert("프로그램 시작일을 입력하세요.");
			$("#studentStartDt").focus();
			return true;
		}
		
		if(!$("#studentEndDt").val()){
			alert("프로그램 종료일을 입력하세요.");
			$("#studentEndDt").focus();
			return true;
		}
		
		return false;
	};
	
	$.goStudentSave = function() {
		var params = $("#dctStudentForm").serialize();

		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/dct/dctStudentInsert.ajax",
            data : params,
            success : function(res){
            	$('#studentRegistModal').modal('toggle');
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goStudentUpdate = function() {
		var params = $("#dctStudentForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/dct/dctStudentUpdate.ajax",
            data : params,
            success : function(res){
            	$('#studentRegistModal').modal('toggle');
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goStudentRemove = function() {
		var params = $("#dctStudentForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/dct/dctStudentDelete.ajax",
            data : params,
            success : function(res){
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.enterStudent = function(studentSeq, studentName) {
		var form = $('<form></form>');
		form.attr("id", "studentForm");
		form.attr("name", "studentForm");
		form.attr("method", "GET");
		form.attr("action", "../dct/studentDetail");
		
		var hiddenField_1 = $('<input/>', {type: 'hidden', name: 'studentSeq', value: studentSeq});
		form.append(hiddenField_1);
		
		form.appendTo('body');
		form.submit();
		form.remove();
	};

	//초기 동작
	$.init = function() {
		$.selectStudentList();
	};
	
	$.init();
});