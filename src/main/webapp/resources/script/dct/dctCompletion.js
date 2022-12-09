$(document).ready(function () {
	
	$.goSearch = function(pageNum) {
		
		var params = {
				pageNum : pageNum,
				studentSeq : $("#studentSeq").val(),
				startDt : $("#startDt").val(),
				endDt : $("#endDt").val(),
				domainSeq : Number($("#domainSeq").val())
			};
		
		console.log(params);
		
		$.ajax({
            type : "POST",
            url : "/dct/dctCompletionListSelect.ajax",
            data : params,
            success : function(res){
            	$.makeCompletionDataRow(res.dataList);
            	_pagination("cmpPaging", res.pagingVO);
            	
            	$("#pageNum").val(pageNum);
//            	_checkAuth();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.makeCompletionDataRow = function(dataList) {
		
		$("#ncompletionTableBody").empty();
		dataList.forEach(function(item) {
			$("#ncompletionTableBody").append($.completionTemplateRow(item));
		});
	};
	
	$.completionTemplateRow = function(item) {
		var html = '';
		
		html += '<tr class="tr-vertical-align">  	';
		html += '	<th scope="row" class="text-center">'+item.rownum+'</th>   					';
		html += '	<td>'+item.domainName+'</td>                              				';
		html += '	<td>'+item.ltoName+'</td>                              					';
		html += '	<td>'+item.stoName+'</td>				';
		html += '	<td>'+$.getDateFormat(item.stoArrDt, 'YYYY-MM-DD')+'</th>				';
		html += '</tr>                                             								';
		
		return html;
	};
	
	$.init = function() {
		$.goSearch(1);
	};
	
	$.init();
});
