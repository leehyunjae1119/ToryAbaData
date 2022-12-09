$(document).ready(function () {
	
	$("#LTOSaveBtn").on("click", function() {
		if(!$.onLTOValidation()){
			$.goLTOSave();
		};
	});
	$("#LTOUpdateBtn").on("click", function() {
		if(!$.onLTOValidation()){
			$.goLTOUpdate();
		};
	});

	$.onLTOValidation = function() {
		
		var ltoName = $("#ltoName").val();
		
		if(!nullCheck(ltoName)){
			alert("LTO 이름을 입력하세요.");
			$("#ltoName").focus();
			return true;
		}
		
		return false;
	};
	
	$.makeLTODataRow = function(dataList) {
		dataList.forEach(function(item) {
			$("#LTOTablemBody").append($.LTOTemplateRow(item));
		});
	};
	
	$.openLTOSaveModal = function() {
		if($("#ltoDomainSeq").val() == 0){
			alert("영역을 먼저 선택하세요.");
			return;
		}
		
		$("#LTORegistModalLabel").text("LTO 등록");
		$("#LTOSaveBtn").show();
		$("#LTOUpdateBtn").hide();
		
		$.setLTOModalData(0);
		$('#LTORegistModal').modal('toggle');
	};
	
	$.openLTOUpdateModal = function(obj) {
		$("#LTORegistModalLabel").text("LTO 수정");
		$("#LTOSaveBtn").hide();
		$("#LTOUpdateBtn").show();

		var ltoSeq = $.getCurriculumSeq(obj);
		$.setLTOModalData(ltoSeq);
		$('#LTORegistModal').modal('toggle');
		
	};
	
	$.onclickLTOItem = function(obj) {
		var ltoSeq = $.getCurriculumSeq(obj);
		
		var str = " - "+$.getCurriculumName(obj);
		$("#spanLTOName").text(str);
		$("#stoLtoSeq").val(ltoSeq);
		
		$.goSTOListSelect();
	};
	
	$.setLTOModalData = function(seq) {
		if(seq == 0){
			$("#ltoName").val("");
		} else {
			$("#ltoSeq").val(seq);
			var params = $("#LTOForm").serialize();
			// ajax 통신
	        $.ajax({
	            type : "POST",
	            url : "/crc/crcLTOOneSelect.ajax",
	            data : params,
//	            async: false,
	            success : function(res){
	            	$("#ltoName").val(res.data.ltoName);
	            },
	            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
	                alert("서버오류. 담당자에게 연락하세요.")
	            }
	        });
		}
	};
	
	$.onclickLTORemove = function(obj) {
		if(!confirm("삭제 하시겠습니까?")) return;
		
		var ltoSeq = $.getCurriculumSeq(obj);
		
		$("#ltoSeq").val(ltoSeq);
		$.goLTORemove();
	};
	
	$.LTOTemplateRow = function(data) {
		
		html = ''
			 + '<tr class="tr-vertical-align">'
			 + '	<input type="hidden" class="crcSeq" value="'+ data.ltoSeq +'"/>'
			 + '	<th scope="row" class="text-center">'+ data.rownum +'</th>'
			 + '	<td onclick="$.onclickLTOItem(this);" class="crcName">'+ data.ltoName +'</td>'
//			 + '	<td onclick="" class="crcName">'+ data.ltoName +'</td>'
			 + '	<td data-auth="level1">'
			 + '		<a href="javascript:void(0);" class="btn btn-primary btn-circle btn-sm mr-2" onclick="$.openLTOUpdateModal(this);">' 
			 + '			<i class="fas fa-edit"></i>'
			 + '		</a>'
			 + '		<a href="javascript:void(0);" class="btn btn-primary btn-circle btn-sm" onclick="$.onclickLTORemove(this)">'
			 + '			<i class="fas fa-trash-alt"></i>'
			 + '		</a>'
			 + '	</td>'
			 + '</tr>';
		
		return html;
	};
	
	$.goLTOListSelect = function() {
		$("#spanLTOName").text("");
		$("#collapseCardDomain").collapse('hide');
		$("#collapseCardSTO").collapse('hide');
//		$("#STOTablemBody").empty();
//		$("#stoLtoSeq").val(0);
		
		var params = $("#LTOForm").serialize();
		
        $.ajax({
            type : "POST",
            url : "/crc/crcLTOListSelect.ajax",
            data : params,
            success : function(res){
            	console.log(res.dataList);
            	$("#LTOTablemBody").empty();
            	$.makeLTODataRow(res.dataList);
            	
            	$("#collapseCardLTO").collapse('show');
            	
            	_checkAuth();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goLTOSave = function() {
		var params = $("#LTOForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcLTOInsert.ajax",
            data : params,
            success : function(res){
            	$('#LTORegistModal').modal('toggle');
            	$.goLTOListSelect();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goLTOUpdate = function() {
		var params = $("#LTOForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcLTOUpdate.ajax",
            data : params,
            success : function(res){
            	$('#LTORegistModal').modal('toggle');
            	$.goLTOListSelect();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goLTORemove = function() {
		var params = $("#LTOForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcLTODelete.ajax",
            data : params,
            success : function(res){
            	$.goLTOListSelect();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
});