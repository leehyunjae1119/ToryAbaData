$(document).ready(function () {
	var isExcute = "";
	var isTooltip = false;
	
	$('#videoRegistModal').on('hidden.bs.modal', function (e) {
		$(".help-guide").hide();
	});
	
	$('#videoModal').on('hidden.bs.modal', function (e) {
		$("#youtubeBox").prop("src", "");
		$("#youtubeBox").prop("title", "" );
		$("#youtubeBox").prop("frameborder", "");
		$("#youtubeBox").prop("allow", "");
		$("#youtubeBox").prop("allowfullscreen", false);
	});
	
	$("#consultingSaveBtn").on("click", function() {
		isExcute = "insert";
		$.excuteAjaxVideo();
	});
	
	$("#consultingUpdateBtn").on("click", function() {
		isExcute = "update";
		$.excuteAjaxVideo();
	});
	
	$(".help-tooltip").on('click', function() {
		if(!isTooltip) {
			$(".help-guide").show();
		} else {
			$(".help-guide").hide();
		}
		isTooltip = !isTooltip;
	});
	
	$(".help-guide").on('click', function() {
		$(".help-guide").hide();
	});
	
	$.selectVideoList = function() {
		$("#noDataCard").hide();
		var params = {
				studentSeq : $("#studentSeq").val()
			};
		
		$.ajax({
            type : "POST",
            url : "/dct/dctVideoListSelect.ajax",
            data : params,
            success : function(res){
            	console.log(res.dataList);
            	$.makeDataCard(res.dataList);
            	
            	if(res.dataList.length == 0){
            		$("#noDataCard").show();
            	}
            	
            	_checkAuth();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                console.log("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.makeDataCard = function(dataList) {
		
		$("#videoCardList").empty();
		dataList.forEach(function(item) {
			$("#videoCardList").append($.templateCard(item));
		});
	};
	
	$.templateCard = function(item) {
		var id = $.getYoutubeId(item.videoAddress);
		var imgUrl = $.getThumnailUrl(id);
		var html = '';
		
		html += '		<div class="col p-3">';
		html += '			<div class="card shadow-sm">';
		html += '				<img class="bd-placeholder-img card-img-top thumnail" alt="썸네일" src="'+imgUrl+'" width="100%" height="225" data-value="'+id+'">';
		html += '				<div class="card-body">';
		html += '					<p class="card-text">'+item.videoContents+'</p>';
		html += '					<div class="d-flex c-cr">';
		html += '						<div class="btn-group">';
		html += '							<button type="button" class="btn btn-sm btn-outline-secondary" onclick="$.openRegModal('+item.videoSeq+')" data-auth="level3">Edit</button>';
		html += '							<button type="button" class="btn btn-sm btn-outline-secondary" onclick="$.removeVideo('+item.videoSeq+')" data-auth="level3">Remove</button>';
		html += '						</div>';
		html += '					</div>';
		html += '				</div>';
		html += '			</div>';
		html += '		</div>';
		
		return html;
	};
	
	$.getThumnailUrl = function(id) {
		var imgUrl = "";
		
		imgUrl += 'https://img.youtube.com/vi/'+id+'/mqdefault.jpg';
		
		return imgUrl;
	};
	
	$.getYoutubeId = function(url) {
		var start = url.lastIndexOf("/")+1;
		var end = url.length;
		var id = url.substring(start, end);
		
		return id;
	};
	
	$.excuteAjaxVideo = function() {
		var url = "";
		
		if(isExcute == "insert"){
			//insert
			url = "/dct/dctVideoInsert.ajax";
		} else if (isExcute == "update"){
			//update
			url = "/dct/dctVideoUpdate.ajax";
		} else if (isExcute == "delete"){
			//delete
			url = "/dct/dctVideoDelete.ajax";
		} else {
			return;
		}
		
		if($("#videoAddress").val().trim() === "" ){
			alert("영상 주소를 입력하세요.");
			$("#videoAddress").focus();
			return;
		}
		if($("#videoAddress").val().indexOf("https://youtu.be/") !== 0 ){
			alert("영상 주소를 알맞게 입력하세요.");
			$("#videoAddress").focus();
			return;
		}
		if($("#videoContents").val().trim() === "" ){
			alert("영상 내용을 입력하세요.");
			$("#videoContents").focus();
			return;
		}
		
		var params = {
				videoSeq : $("#videoSeq").val(),
				studentSeq : $("#studentSeq").val(),
				videoContents : $("#videoContents").val(),
				videoAddress : $("#videoAddress").val()
			};
		
		$.ajax({
            type : "POST",
            url : url,
            data : params,
            success : function(res){
            	$("#videoRegistModal").modal("hide");
            	$.selectVideoList();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                console.log("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.openRegModal = function(seq) {
		if(!seq){
			$("#videoSeq").val("0");
			$("#videoAddress").val("");
			$("#videoContents").val("");
			
			$("#consultingSaveBtn").show();
			$("#consultingUpdateBtn").hide();
		} else {
			$.setDate(seq);
			
			$("#consultingSaveBtn").hide();
			$("#consultingUpdateBtn").show();
		}
		
		$("#videoRegistModal").modal("show");
	};
	
	$.setDate = function(seq) {
		var params = {
				videoSeq : seq
			};
		$.ajax({
            type : "POST",
            url : "/dct/dctVideoOneSelect.ajax",
            data : params,
            success : function(res){
            	$("#videoSeq").val(res.data.videoSeq);
    			$("#videoAddress").val(res.data.videoAddress);
    			$("#videoContents").val(res.data.videoContents);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                console.log("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.removeVideo = function(seq) {
		if(!confirm("정말 삭제하시겠습니까?")){
			return ;
		}
		$("#videoSeq").val(seq);
		isExcute = "delete";
		
		$.excuteAjaxVideo();
	};
	
	$.init = function() {
		$.selectVideoList();
		
	};
	
	$.init();
});

$(document).on('click', '.thumnail', function() {
	var id = $(this).attr("data-value");
	var videoUrl = 'https://www.youtube.com/embed/'+id;
	$("#youtubeBox").prop("src", videoUrl);
	$("#youtubeBox").prop("title", "YouTube video player" );
	$("#youtubeBox").prop("frameborder", "0");
	$("#youtubeBox").prop("allow", "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture");
	$("#youtubeBox").prop("allowfullscreen", true);
	
	$('#videoModal').modal("show");
});
 