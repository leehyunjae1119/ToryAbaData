$(document).ready(function () {
	

	$("#classSaveBtn").on("click", function() {
		var className = $("#className").val();
		
		if(!$.onValidation(className)){
			$.goClassSave();
		};
	});
	
	$("#classUpdateBtn").on("click", function() {
		var className = $("#className").val();
		
		if(!$.onValidation(className)){
			$.goClassUpdate();
		};
	});
	
	$.onclickClassRemove = function(seq) {
		if(!confirm("삭제 하시겠습니까?")) return;
		
		$("#classSeq").val(seq);
		$.goClassRemove();
	};
	
	$.selectClassList = function() {
		var params = $("#dctClassForm").serialize();
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/dct/dctClassListSelect.ajax",
            data : params,
            success : function(res){
            	$("#classBoard").empty();
            	$.makeClassCard(res.dataList);
            	
            	_checkAuth();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.makeClassCard = function(dataList) {
		dataList.forEach(function(item) {
			$("#classBoard").append($.templateCard(item));
		});
		$.makeAddBtn();
	};
	
	$.templateCard = function(data) {
		html = '<div class="col-xl-3 col-md-6 mb-4">'
			+ '<div class="card border-left-warning shadow h-100 py-2" style="min-height: 9rem;">'
			+ '<div class="card-body custom-cursor-pointer" onclick="$.enterClass(\''+data.classSeq+'\', \''+data.className+'\');">'
			+ '<div class="row no-gutters align-items-center">'
			+ '<div class="col mr-2">'
			+ '<div class="h2 mb-0 font-weight-bold text-gray-800">'+data.className+'</div>'
			+ '</div>'
			+ '</div>'
			+ '</div>'
			+ '<div class="custom-card-link">'
			+ '<a href="javascript:void(0);" class="card-link" data-auth="level2" onclick="$.openUpdateModal(\''+data.classSeq+'\', \''+data.className+'\');">수정</a>'
			+ '<a href="javascript:void(0);" class="card-link" data-auth="level2" onclick="$.onclickClassRemove(\''+data.classSeq+'\');">삭제</a>'
			+ '</div>'
			+ '</div>'
			+ '</div>';
		return html;
	};
	
	$.makeAddBtn = function() {
		var html = '<div class="col-xl-3 col-md-6 mb-4" data-auth="level2">'
				 + '<div class="card border-dashed-line shadow h-100 py-2 align-items-center justify-content-center" id="classAddBtn" onclick="$.openSaveModal();" style="min-height: 9rem;">'
				 + '<i class="fas fa-plus-square fa-2x"></i>'
				 + '</div>'
				 + '</div>';
		
		$("#classBoard").append(html);
	
	};

	$.openSaveModal = function() {
		$("#classRegistModalLabel").text("반 등록");
		$("#classSaveBtn").show();
		$("#classUpdateBtn").hide();
		
		$("#className").val("");
		$('#classRegistModal').modal('toggle');
	};
	
	$.openUpdateModal = function(seq, name) {
		$("#classRegistModalLabel").text("반 수정");
		$("#classSaveBtn").hide();
		$("#classUpdateBtn").show();
		
		$("#classSeq").val(seq);
		$("#className").val(name);
		$('#classRegistModal').modal('toggle');
		
	};
	
	$.onValidation = function(className) {
		if(!className){
			alert("센터 이름을 입력하세요.");
			$("#className").focus();
			return true;
		}
		
		return false;
	};
	
	$.goClassSave = function() {
		var params = $("#dctClassForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/dct/dctClassInsert.ajax",
            data : params,
            success : function(res){
            	$('#classRegistModal').modal('toggle');
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goClassUpdate = function() {
		var params = $("#dctClassForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/dct/dctClassUpdate.ajax",
            data : params,
            success : function(res){
            	$('#classRegistModal').modal('toggle');
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goClassRemove = function() {
		var params = $("#dctClassForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/dct/dctClassDelete.ajax",
            data : params,
            success : function(res){
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.enterClass = function(classSeq, className) {
		var form = $('<form></form>');
		form.attr("id", "classForm");
		form.attr("name", "classForm");
		form.attr("method", "GET");
		form.attr("action", "../dct/studentBoard");
		
		var hiddenField_1 = $('<input/>', {type: 'hidden', name: 'classSeq', value: classSeq});
		form.append(hiddenField_1);
		
		var hiddenField_2 = $('<input/>', {type: 'hidden', name: 'className', value: className});
		form.append(hiddenField_2);
		
		form.appendTo('body');
		form.submit();
		form.remove();
	};

	//초기 동작
	$.init = function() {
		$.selectClassList();
	};
	
	$.init();
});