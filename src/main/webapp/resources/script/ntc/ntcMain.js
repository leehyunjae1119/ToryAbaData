$(document).ready(function () {
	
	var flag = true; // true = insert | false = update
	
	$("#noticeUpdateBtn").on("click", function() {
		$("#detailTitle").hide();
		$("#inputTitle").show();
		$("#detailContents").hide();
		$("#inputContents").show();

		$("#noticeSaveBtn").show();
		$("#noticeCancelBtn").show();
		
		$("#noticeUpdateBtn").hide();
		$("#noticeDeleteBtn").hide();
		$("#noticeCloseBtn").hide();
		
		flag = false;
	});
	
	$("#noticeSaveBtn").on("click", function() {
		
		$.saveNotice();
		
		$("#detailTitle").show();
		$("#inputTitle").hide();
		$("#detailContents").show();
		$("#inputContents").hide();

		$("#noticeSaveBtn").hide();
		$("#noticeCancelBtn").hide();
		
		$("#noticeUpdateBtn").show();
		$("#noticeDeleteBtn").show();
		$("#noticeCloseBtn").show();
		
	});
	
	$("#noticeCancelBtn").on("click", function() {
		$("#detailTitle").show();
		$("#inputTitle").hide();
		$("#detailContents").show();
		$("#inputContents").hide();
		
		$("#noticeSaveBtn").hide();
		$("#noticeCancelBtn").hide();
		
		$("#noticeUpdateBtn").show();
		$("#noticeDeleteBtn").show();
		$("#noticeCloseBtn").show();
		
	});
	
	$("#noticeDeleteBtn").on("click", function() {
		
		if(!confirm("정말 삭제하시겠습니까?")){
			return ;
		}
		
		var params = {
				noticeSeq : $("#noticeSeq").val()
			};
		
		$.ajax({
            type : "POST",
            url : "/ntc/ntcNoticeDelete.ajax",
            data : params,
            success : function(res){
            	$('#noticeDetailModal').modal('hide');
            	$.goSearch($("#pageNum").val());
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	});
	
	$.onclickRegBtn = function() {
		$("#inputTitle").val("");
		$("#inputContents").val("");
		$("#detailRegName").text(authName);
		$("#detailRegDt").text($.getToday());
		
		$("#detailTitle").hide();
		$("#inputTitle").show();
		$("#detailContents").hide();
		$("#inputContents").show();
		
		$("#noticeSaveBtn").show();
		$("#noticeCloseBtn").show();
		
		$("#noticeUpdateBtn").hide();
		$("#noticeDeleteBtn").hide();
		$("#noticeCancelBtn").hide();
		
		flag = true;
		$("#noticeSeq").val(0);
		
		$('#noticeDetailModal').modal('show');
	};
	
	$.goSearch = function(pageNum) {
		
		var params = {
				searchText1 : $("#searchText1").val(),
				pageNum : pageNum
			};
		
		$.ajax({
            type : "POST",
            url : "/ntc/ntcNoticeListSelect.ajax",
            data : params,
            success : function(res){
            	$.makeNoticeDataRow(res.dataList);
            	_pagination("ntcPaging", res.pagingVO);
            	
            	$("#pageNum").val(pageNum);
//            	_checkAuth();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.makeNoticeDataRow = function(dataList) {
		
		$("#noticeTableBody").empty();
		dataList.forEach(function(item) {
			$("#noticeTableBody").append($.noticeTemplateRow(item));
		});
	};
	
	$.noticeTemplateRow = function(item) {
		var html = '';
		
		html += '<tr class="tr-vertical-align" onclick="$.detailNotice('+item.noticeSeq+')">  	';
		html += '	<th scope="row" class="text-center">'+item.rownum+'</th>   					';
		html += '	<td>'+item.noticeTitle+'</th>                               				';
		html += '	<td>'+item.memberName+'</th>                               					';
		html += '	<td>'+$.getDateFormat(item.noticeRegDt, 'YYYY-MM-DD')+'</th>				';
		html += '</tr>                                             								';
		
		return html;
	};
	
	$.detailNotice = function(noticeSeq) {
		
		var params = {
				noticeSeq : noticeSeq
			};
		
		$.ajax({
            type : "POST",
            url : "/ntc/ntcNoticeOneSelect.ajax",
            data : params,
            success : function(res){
            	console.log(res.data);
            	
            	var contents = res.data.noticeContents.replaceAll("<br>", "\r\n").replaceAll("&nbsp;", "\u0020");
            	
            	$("#detailRegName").text(res.data.memberName);
            	$("#detailRegDt").text($.getDateFormat(res.data.noticeRegDt, 'YYYY-MM-DD'));
            	$("#detailTitle").text(res.data.noticeTitle);
            	$("#detailContents").html(res.data.noticeContents);
            	$("#inputTitle").val(res.data.noticeTitle);
            	$("#inputContents").val(contents);
            	
            	$("#detailTitle").show();
        		$("#inputTitle").hide();
        		$("#detailContents").show();
        		$("#inputContents").hide();
            	
        		$("#noticeUpdateBtn").hide();
        		$("#noticeDeleteBtn").hide();
        		$("#noticeSaveBtn").hide();
        		$("#noticeCancelBtn").hide();
        		$("#noticeCloseBtn").show();
            	if(authSeq == res.data.noticeRegMbrSeq || authCd == 'master'){
            		$("#noticeUpdateBtn").show();
            		$("#noticeDeleteBtn").show();
            	} else {
            		$("#noticeUpdateBtn").hide();
            		$("#noticeDeleteBtn").hide();
            	}
            	
            	$("#noticeSeq").val(noticeSeq)
            	$('#noticeDetailModal').modal('show');
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.saveNotice = function() {
		var url = "";
		if(flag){
			//insert
			url = "/ntc/ntcNoticeInsert.ajax";
		} else {
			//update
			url = "/ntc/ntcNoticeUpdate.ajax";
		}
		
		var params = {
				noticeSeq : $("#noticeSeq").val(),
				noticeTitle : $("#inputTitle").val(),
				noticeContents : $("#inputContents").val().replace(/\n/g, "<br>").replaceAll("\u0020", "&nbsp;")
			};
		
		$.ajax({
            type : "POST",
            url : url,
            data : params,
            success : function(res){
            	$("#detailTitle").text($("#inputTitle").val());
            	$("#detailContents").html($("#inputContents").val().replace(/\n/g, "<br>").replaceAll("\u0020", "&nbsp;"));
            	
            	$.goSearch($("#pageNum").val());
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.init = function() {
		$.goSearch(1);
	};
	
	$.init();
});

function enterkey() {
	if (window.event.keyCode == 13) {
		$.goSearch(1);
	}
};