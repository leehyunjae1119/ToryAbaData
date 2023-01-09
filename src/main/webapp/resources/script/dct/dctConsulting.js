var flag = true; // true = insert | false = update

$(document).ready(function () {
	
	$(".search-item").on('change', function() {
		$.selectDataList();
	});
	
	$("#consultingSaveBtn").on('click', function() {
		$.saveConsulting();
	});
	
	$("#consultingUpdateBtn").on('click', function() {
		$.saveConsulting();
	});
	
	$("#addConsultingBtn").on('click', function() {
		flag = true;
		$("#consultingSeq").val("0");
		$("#consultingContents").val("");
		$("#onlyMyPostYn").prop("checked", false);
		
		$("#consultingSaveBtn").show();
		$("#consultingUpdateBtn").hide();
		$("#consultingRegistModal").modal("show");
	});
	
	$.selectDataList = function() {
		$("#noDataCard").hide();
		
		var consultingRegDt = $("#allItemViewYn").prop("checked") ? '' : selectDay;
		var onlyMyPostYn = $("#myItemViewYn").prop("checked") ? 'Y' : 'N';
		
		var params = {
				memberSeq : $("#memberSeq").val(),
				studentSeq : $("#studentSeq").val(),
				onlyMyPostYn : onlyMyPostYn,
				consultingRegDt : consultingRegDt
			};
		
		$.ajax({
            type : "POST",
            url : "/dct/dctConsultingListSelect.ajax",
            data : params,
            success : function(res){
            	$.makeDataCard(res.dataList);
            	
            	if(res.dataList.length == 0){
            		$("#noDataCard").show();
            	}
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.makeDataCard = function(dataList) {
		
		$("#consultingCardList").empty();
		dataList.forEach(function(item) {
			$("#consultingCardList").append($.templateCard(item));
		});
	};
	
	$.templateCard = function(item) {
		var cardColor = item.memberSeq == authSeq ? 'border-bottom-primary' : 'border-bottom-dark';
		
		var html = '';
		
		html += '<div class="card mb-3 '+cardColor+'">                                                     		';
		html += '	<div class="card-body">                                                                		';
		html += '		<div class="c-row c-cb mb-2">                                                      		';
		html += '			<div class="c-row">                                                            		';
		html += '				<p class="m-0 small">작성자 : '+item.memberName+'</p>                        		';
		html += '				<span class="separator"></span>                                            		';
		html += '				<p class="m-0 small">작성일 : '+$.getDateFormat2(item.consultingRegDt, '.')+'</p> 		';
		if(item.onlyMyPostYn == 'Y'){
			html += '				<span class="ml-2 badge badge-secondary">나만보는 글</span>                    		';
		}
		html += '			</div>                                                                         		';
		if(item.memberSeq == authSeq){
			html += '			<div class="custom-card-link">                                                 	';
			html += '				<a href="javascript:void(0);" class="card-link small" onclick="$.onclickUpdateBtn('+item.consultingSeq+')">수정</a>    ';
			html += '				<a href="javascript:void(0);" class="card-link small" onclick="$.onclickDeleteBtn('+item.consultingSeq+')">삭제</a>    ';
			html += '			</div>                                                                         	';
		}
		html += '		</div>                                                                             		';
		html += '		<div class="c-row">'+item.consultingContents+'</div>                                	';
		html += '	</div>                                                                                 		';
		html += '</div>                                                                                     	';
		
		return html;
	};
	
	$.onclickUpdateBtn = function(seq) {
		flag = false;
		
		var params = {
			consultingSeq : seq
		};
		
		$.ajax({
            type : "POST",
            url : "/dct/dctConsultingOneSelect.ajax",
            data : params,
            success : function(res){
            	
            	$("#consultingSeq").val(res.data.consultingSeq);
            	$("#consultingContents").val(res.data.consultingContents.replaceAll("<br>", "\r\n").replaceAll("&nbsp;", "\u0020"));
            	if(res.data.onlyMyPostYn == 'Y'){
            		$("#onlyMyPostYn").prop("checked", true);
            	} else {
            		$("#onlyMyPostYn").prop("checked", false);
            	}
            	
            	$("#consultingSaveBtn").hide();
        		$("#consultingUpdateBtn").show();
            	
            	$("#consultingRegistModal").modal("show");
            	
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.onclickDeleteBtn = function(seq) {
		if(!confirm("정말 삭제하시겠습니까?")){
			return ;
		}
		
		var params = {
			consultingSeq : seq
		};
		
		$.ajax({
            type : "POST",
            url : "/dct/dctConsultingDelete.ajax",
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
		var url = "";
		if(flag){
			//insert
			url = "/dct/dctConsultingInsert.ajax";
		} else {
			//update
			url = "/dct/dctConsultingUpdate.ajax";
		}
		
		if($("#consultingContents").val().trim() == "") {
			alert("상담 내용을 입력하세요.");
			return;
		}
		
		var onlyMyPostYn = $("#onlyMyPostYn").prop("checked") ? 'Y' : 'N';
		var params = {
				consultingSeq : $("#consultingSeq").val(),
				memberSeq : $("#memberSeq").val(),
				studentSeq : $("#studentSeq").val(),
				consultingContents : $("#consultingContents").val().replace(/\n/g, "<br>").replaceAll("\u0020", "&nbsp;"),
				onlyMyPostYn : onlyMyPostYn
			};
		
		$.ajax({
            type : "POST",
            url : url,
            data : params,
            success : function(res){
            	$("#consultingRegistModal").modal("hide");
            	$.selectDataList();
            	
            	if(flag){
            		renderCalender(thisMonth);
            	}
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.setDataDtList = function(selectMonth) {
		var params = {
				consultingRegDt : selectMonth,
			};
		
		$.ajax({
            type : "POST",
            url : "/dct/dctConsultingDataDtlist.ajax",
            async : false,
            data : params,
            success : function(res){
            	var tmpList = [];
            	res.dataList.forEach(function(item) {
            		tmpList.push(item.consultingRegDt);
        		});
            	dataDtList = tmpList;
            	
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                console.log("서버오류. 담당자에게 연락하세요.");
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
	$('#allItemViewYn').prop("checked", false);
	$('.current').removeClass('today');
	$(this).addClass('today');
	selectDay = $(this).attr("data-value");
	$.selectDataList();
});

/*
 * 시퀀스		회원번호(작성자)	학생번호(아동)	내용	작성일	
 */
