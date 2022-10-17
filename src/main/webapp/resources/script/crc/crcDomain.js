$(document).ready(function () {
	
	$("#domainSaveBtn").on("click", function() {
		if(!$.onDomainValidation()){
			$.goDomainSave();
		};
	});
	$("#domainUpdateBtn").on("click", function() {
		if(!$.onDomainValidation()){
			$.goDomainUpdate();
		};
	});
	
	$.onDomainValidation = function() {
		
		var domainName = $("#domainName").val();
		
		if(!domainName){
			alert("발달영역 이름을 입력하세요.");
			$("#domainName").focus();
			return true;
		}
		
		return false;
	};
	
	$.openDomainSaveModal = function() {
		$("#domainRegistModalLabel").text("발달영역 등록");
		$("#domainSaveBtn").show();
		$("#domainUpdateBtn").hide();
		
		$.setModalDomainData(0);
		$('#domainRegistModal').modal('toggle');
	};
	
	$.openDomainUpdateModal = function(obj) {
		$("#domainRegistModalLabel").text("발달영역 수정");
		$("#domainSaveBtn").hide();
		$("#domainUpdateBtn").show();

		var domainSeq = $.getCurriculumSeq(obj);
		$.setModalDomainData(domainSeq);
		$('#domainRegistModal').modal('toggle');
		
	};
	
	$.setModalDomainData = function(seq) {
		if(seq == 0){
			$("#domainName").val("");
			
		} else {
			$("#domainSeq").val(seq);
			var params = $("#domainForm").serialize();
			// ajax 통신
	        $.ajax({
	            type : "POST",
	            url : "/crc/crcDomainOneSelect.ajax",
	            data : params,
//	            async: false,
	            success : function(res){
	            	
	            	$("#domainName").val(res.data.domainName);
	            },
	            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
	                alert("서버오류. 담당자에게 연락하세요.")
	            }
	        });
		}
	};
	
	$.onclickDomainRemove = function(obj) {
		if(!confirm("삭제 하시겠습니까?")) return;
		
		var domainSeq = $.getCurriculumSeq(obj);
		
		$("#domainSeq").val(domainSeq);
		$.goDomainRemove();
	};
	

	$.useYnToggleChange = function(obj) {
		var domainSeq = $.getCurriculumSeq(obj);
		var domainUseYn = $(obj).prop('checked') == true ? "Y" : "N";
		
		$("#domainSeq").val(domainSeq);
		$("#domainUseYn").val(domainUseYn);
		$.goDomainUseYnUpdate();
		
	};
	
	$.onclickDomainItem = function(obj) {
		var domainSeq = $.getCurriculumSeq(obj);
		
		var str = " - "+$.getCurriculumName(obj);
		$("#spanDomainName").text(str);
		$("#ltoDomainSeq").val(domainSeq);
		
		$.goLTOListSelect();
	};
	
	$.makeDomainDataRow = function(dataList) {
		dataList.forEach(function(item) {
			$("#domainTableBody").append($.domainTemplateRow(item));
		});
	};
	
	$.domainTemplateRow = function(data) {
		var flag = data.domainUseYn == "Y" ? "checked" : "";
		html = ''
			 + '<tr class="tr-vertical-align">'
			 + '	<input type="hidden" class="crcSeq" value="'+ data.domainSeq +'"/>'
			 + '	<th scope="row" class="text-center">'+ data.rownum +'</th>'
			 + '	<td onclick="$.onclickDomainItem(this)" class="crcName">'+ data.domainName +'</td>'
			 + '	<td>'
			 + '		<input type="checkbox" class="useYnToggle" data-toggle="toggle" data-size="sm" onchange="$.useYnToggleChange(this);" '+ flag +'>'
			 + '	</td>'
			 + '	<td>'
			 + '		<a href="javascript:void(0);" class="btn btn-primary btn-circle btn-sm mr-2" onclick="$.openDomainUpdateModal(this);">' 
			 + '			<i class="fas fa-edit"></i>'
			 + '		</a>'
			 + '		<a href="javascript:void(0);" class="btn btn-primary btn-circle btn-sm" onclick="$.onclickDomainRemove(this)">'
			 + '			<i class="fas fa-trash-alt"></i>'
			 + '		</a>'
			 + '	</td>'
			 + '</tr>';
		
		return html;
	};
	
	$.goDomainListSelect = function() {
		var params = $("#domainForm").serialize();
		
        $.ajax({
            type : "POST",
            url : "/crc/crcDomainListSelect.ajax",
            data : params,
            success : function(res){
            	console.log(res.dataList);
            	$("#domainTableBody").empty();
            	$.makeDomainDataRow(res.dataList);
            	$('.useYnToggle').bootstrapToggle();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goDomainSave = function() {
		var params = $("#domainForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcDomainInsert.ajax",
            data : params,
            success : function(res){
            	$('#domainRegistModal').modal('toggle');
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goDomainUpdate = function() {
		var params = $("#domainForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcDomainUpdate.ajax",
            data : params,
            success : function(res){
            	$('#domainRegistModal').modal('toggle');
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goDomainRemove = function() {
		var params = $("#domainForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcDomainDelete.ajax",
            data : params,
            success : function(res){
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goDomainUseYnUpdate = function() {
		var params = $("#domainForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcDomainUseYnUpdate.ajax",
            data : params,
            success : function(res){
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
});