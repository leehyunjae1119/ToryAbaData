$(document).ready(function () {
	
	$("#addCalenderBtn").on('click', function() {
		$("#calenderRegDt").val(selectDay);
		$("#calenderRegDtLabel").text($.getDateFormat2(selectDay, '.'));
		$("#calenderContents").val("");
		
		$("#calenderRegistModal").modal("show");
	});
	
	$("#calenderSaveBtn").on('click', function() {
		$.saveConsulting();
	});
	
	$.setDataDtList = function(selectMonth) {
		var params = {
				calenderRegDt : selectMonth,
			};
		
		$.ajax({
            type : "POST",
            url : "/mai/maiCalenderDataDtlist.ajax",
            async : false,
            data : params,
            success : function(res){
            	var tmpList = [];
            	res.dataList.forEach(function(item) {
            		tmpList.push(item.calenderRegDt);
        		});
            	dataDtList = tmpList;
            	
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                console.log("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.selectDataList = function() {
		var calenderRegDt = selectDay;
		
		var params = {
				memberSeq : $("#memberSeq").val(),
				calenderRegDt : calenderRegDt
			};
		
		$.ajax({
            type : "POST",
            url : "/mai/maiCalenderListSelect.ajax",
            data : params,
            success : function(res){
            	$.makeDataRow(res.dataList);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.makeDataRow = function(dataList) {
		
		$("#calenderDataList").empty();
		dataList.forEach(function(item) {
			$("#calenderDataList").append($.templateRow(item));
		});
		
		if(dataList.length == 0){
			$("#calenderDataList").append('<tr><td>작성된 내용이 없습니다.</td></tr>')
    	}
	};
	
	$.templateRow = function(item) {
		
		var html = '';
		
		html += '<tr>';
		html += '	<td>';
		html += '		<div class="c-row" style="align-items: flex-start;">';
		html += '			<div class="c-row c-cb">';
		html += '				<span class="writer">'+item.memberName+'</span>';
		html += '				<span class="separator"></span>';
		html += '			</div>';
		html += '			<div class="c-row c-cb custom-width-100">';
		html += '				<span class="contents">'+item.calenderContents+'</span>';
		if(item.memberSeq == authSeq){
			html += '				<button type="button" class="btn btn-sm m-0" onclick="$.onclickDeleteBtn('+item.calenderSeq+')">';
			html += '					<i class="fas fa-trash"></i>';
			html += '				</button>';
		}
		html += '			</div>';
		html += '		</div>';
		html += '	</td>';
		html += '</tr>';
		
		return html;
	};
	
	$.onclickDeleteBtn = function(seq) {
		if(!confirm("정말 삭제하시겠습니까?")){
			return ;
		}
		
		var params = {
			calenderSeq : seq
		};
		
		$.ajax({
            type : "POST",
            url : "/mai/maiCalenderDelete.ajax",
            data : params,
            success : function(res){
            	$.selectDataList();
            	renderCalender(thisMonth);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	

	$.saveConsulting = function() {
		
		if($("#calenderContents").val().trim() == "") {
			alert("내용을 입력하세요.");
			$("#calenderContents").focus();
			return;
		}
		
		var params = {
				memberSeq : $("#memberSeq").val(),
				calenderRegDt : $("#calenderRegDt").val(),
				calenderContents : $("#calenderContents").val()
			};
		
		$.ajax({
            type : "POST",
            url : "/mai/maiCalenderInsert.ajax",
            data : params,
            success : function(res){
            	$("#calenderRegistModal").modal("hide");
            	$.selectDataList();
            	
        		renderCalender(thisMonth);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
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
            	
            	$("#detailRegName").text(res.data.memberName);
            	$("#detailRegDt").text($.getDateFormat(res.data.noticeRegDt, 'YYYY-MM-DD'));
            	$("#detailTitle").text(res.data.noticeTitle);
            	$("#detailContents").html(res.data.noticeContents);
            	
            	$('#noticeDetailModal').modal('show');
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.init = function() {
		$("#memberSeq").val(authSeq);
		calendarInit();
		$.selectDataList();
	};
	
	$.init();
});


$(document).on('click', '.current', function() {
	$('.current').removeClass('today');
	$(this).addClass('today');
	selectDay = $(this).attr("data-value");
	$.selectDataList();
});