$(document).ready(function () {
	
	$("#STOSaveBtn").on("click", function() {
		if(!$.onSTOValidation()){
			$.goSTOSave();
		};
	});
	$("#STOUpdateBtn").on("click", function() {
		if(!$.onSTOValidation()){
			$.goSTOUpdate();
		};
	});
	
	$.onSTOValidation = function() {
		
		var stoName = $("#stoName").val();
		
		if(!stoName){
			alert("STO 이름을 입력하세요.");
			$("#stoName").focus();
			return true;
		}
		
		return false;
	};
	
	$.openSTOSaveModal = function() {
		if($("#stoLtoSeq").val() == 0){
			alert("장기목표를 먼저 선택하세요.");
			return;
		}
		
		$("#STORegistModalLabel").text("STO 등록");
		$("#STOSaveBtn").show();
		$("#STOUpdateBtn").hide();
		
		$.setSTOModalData(0);
		$('#STORegistModal').modal('toggle');
	};
	
	$.openSTOUpdateModal = function(obj) {
		$("#STORegistModalLabel").text("STO 수정");
		$("#STOSaveBtn").hide();
		$("#STOUpdateBtn").show();

		var stoSeq = $.getCurriculumSeq(obj);
		$.setSTOModalData(stoSeq);
		$('#STORegistModal').modal('toggle');
		
	};
	
	$.setSTOModalData = function(seq) {
		if(seq == 0){
			$("#stoArrStdPst").val("90");
			$("#stoTrialCnt").val("15");
//			$("#stoArrStdCnt").val("1");
			$("#stoName").val("");
			$("#stoContents").val("");
			
		} else {
			$("#stoSeq").val(seq);
			var params = $("#STOForm").serialize();
			// ajax 통신
	        $.ajax({
	            type : "POST",
	            url : "/crc/crcSTOOneSelect.ajax",
	            data : params,
//	            async: false,
	            success : function(res){
	            	
	            	$("#stoArrStdPst").val(res.data.stoArrStdPst);
	            	$("#stoTrialCnt").val(res.data.stoTrialCnt);
//	            	$("#stoArrStdCnt").val(res.data.stoArrStdCnt);
	            	$("#stoName").val(res.data.stoName);
	    			$("#stoContents").val(res.data.stoContents);
	            },
	            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
	                alert("서버오류. 담당자에게 연락하세요.")
	            }
	        });
		}
	};
	
	$.onclickSTORemove = function(obj) {
		if(!confirm("삭제 하시겠습니까?")) return;
		
		var stoSeq = $.getCurriculumSeq(obj);
		
		$("#stoSeq").val(stoSeq);
		$.goSTORemove();
	};
	
	$.makeSTODataRow = function(dataList) {
		dataList.forEach(function(item) {
			$("#STOTableBody").append($.STOTemplateRow(item));
		});
	};
	
	$.STOTemplateRow = function(data) {
		html = ''
			 + '<tr class="tr-vertical-align">'
			 + '	<input type="hidden" class="crcSeq" value="'+ data.stoSeq +'"/>'
			 + '	<th scope="row" class="text-center">'+ data.rownum +'</th>'
			 + '	<td>'+ data.stoName +'</td>'
			 + '	<td>'+ data.stoContents +'</td>'
//			 + '	<td>'+ data.stoArrStdPst +'%</td>'
//			 + '	<td>'+ data.stoTrialCnt +'</td>'
//			 + '	<td>'+ data.stoArrStdCnt +'</td>'
			 + '	<td>'
			 + '		<a href="javascript:void(0);" class="btn btn-primary btn-circle btn-sm mr-2" onclick="$.openSTOUpdateModal(this);">' 
			 + '			<i class="fas fa-edit"></i>'
			 + '		</a>'
			 + '		<a href="javascript:void(0);" class="btn btn-primary btn-circle btn-sm" onclick="$.onclickSTORemove(this)">'
			 + '			<i class="fas fa-trash-alt"></i>'
			 + '		</a>'
			 + '	</td>'
			 + '</tr>';
		
		return html;
	};
	
	$.goSTOListSelect = function() {
		$("#collapseCardDomain").collapse('hide');
		$("#collapseCardLTO").collapse('hide');
		$("#collapseCardSTO").collapse('show');
		
		var params = $("#STOForm").serialize();
		
        $.ajax({
            type : "POST",
            url : "/crc/crcSTOListSelect.ajax",
            data : params,
            success : function(res){
            	console.log(res.dataList);
            	$("#STOTableBody").empty();
            	$.makeSTODataRow(res.dataList);
            	
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goSTOSave = function() {
		var params = $("#STOForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcSTOInsert.ajax",
            data : params,
            success : function(res){
            	$('#STORegistModal').modal('toggle');
            	$.goSTOListSelect();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goSTOUpdate = function() {
		var params = $("#STOForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcSTOUpdate.ajax",
            data : params,
            success : function(res){
            	$('#STORegistModal').modal('toggle');
            	$.goSTOListSelect();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goSTORemove = function() {
		var params = $("#STOForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcSTODelete.ajax",
            data : params,
            success : function(res){
            	$.goSTOListSelect();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
});