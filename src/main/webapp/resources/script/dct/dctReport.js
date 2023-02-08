
$(document).ready(function () {
	
	var isReport = false;
	
	var date = new Date(); // 현재 날짜(로컬 기준) 가져오기
	var utc = date.getTime() + (date.getTimezoneOffset() * 60 * 1000); // uct 표준시 도출
	var kstGap = 9 * 60 * 60 * 1000; // 한국 kst 기준시간 더하기
	var today = new Date(utc + kstGap); // 한국 시간으로 date 객체 만들기(오늘)
	
	var currentYear = today.getFullYear(); 
	var currentMonth = today.getMonth(); 
	var currentDate = today.getDate(); 
	
	var oneMonthAgo = new Date(today.setMonth(today.getMonth()-1));
	
	var agoYear = oneMonthAgo.getFullYear(); 
	var agoMonth = oneMonthAgo.getMonth(); 
	var agoDate = oneMonthAgo.getDate(); 

	var startDay = agoYear + '-' + numFormat(agoMonth+1) + '-' + numFormat(agoDate);
	var endDay = currentYear + '-' + numFormat(currentMonth+1) + '-' + numFormat(currentDate);
	
	$("#startDt").val(startDay);
	$("#endDt").val(endDay);
	
	$(".tablist-item").on("click", function() {
		$(".tablist-item").removeClass("active");
		$(this).addClass("active");
		
		var id = $(this).attr("id");
		
		if(id == 'monthlyReport'){
			//월간보고서 클릭
			$("#printFlag").val("monthlyReportPage");
			$("#monthlyReportPage").show();
			$("#quarterlyReportPage").hide();
		} else {
			//분기보고서 클릭
			_dc_createChart2("domainChart2");
			$("#printFlag").val("quarterlyReportPage");
			$("#monthlyReportPage").hide();
			$("#quarterlyReportPage").show();
			
		}
	});
	
	$(".reportNameLabel").parent().on("click", function() {
		$(".reportNameLabel").hide();
		$(".reportName").show();
		$(".reportName").focus();
	});
	
	$(".reportName").on("focusout", function() {
		$(".reportNameLabel").text($(".reportName").val());
		$(".reportName").hide();
		$(".reportNameLabel").show();
	});
	
	$(".reportBirthLabel").parent().on("click", function() {
		$(".reportBirthLabel").hide();
		$(".reportBirth").show();
		$(".reportBirth").focus();
	});
	
	$(".reportBirth").on("focusout", function() {
		$(".reportBirthLabel").text($(".reportBirth").val());
		$(".reportBirth").hide();
		$(".reportBirthLabel").show();
	});

	$(".reportRegNameLabel").parent().on("click", function() {
		$(".reportRegNameLabel").hide();
		$(".reportRegName").show();
		$(".reportRegName").focus();
	});
	
	$(".reportRegName").on("focusout", function() {
		$(".reportRegNameLabel").text($(".reportRegName").val());
		$(".reportRegName").hide();
		$(".reportRegNameLabel").show();
	});
	
	$("#setReportDateBtn").on('click', function() {
		if($("#startDt").val() == '' || $("#endDt").val() == ''){
			alert("보고서 작성 날짜를 입력하세요.");
			return;
		}
		
		$("#reportDateModal").modal("hide");
		
		isReport = true;
	});
	
	$('#reportDateModal').on('hidden.bs.modal', function (e) {
		if(isReport){
			$("#reportModal").modal("show");
		}
	});
	
	$('#reportModal').on('hidden.bs.modal', function (e) {
		isReport = false;
	});
	
	//이미지(png)로 다운로드
	$.downImg = function() {
		var id = $("#printFlag").val();
		
		html2canvas($("#"+id).parent()[0]).then(function(canvas) {
			var myImage = canvas.toDataURL();
			downloadURI(myImage, id+".png")
		});
	};

	function downloadURI(uri, name) {
		var link = document.createElement("a")
		link.download = name;
		link.href = uri;
		document.body.appendChild(link);
		link.click();
	}
	
	$.downPdf = function() {	
		var id = $("#printFlag").val();
	    html2canvas($("#"+id).parent()[0]).then(function(canvas) { //저장 영역 div id
		
		    // 캔버스를 이미지로 변환
		    var imgData = canvas.toDataURL('image/png');
			     
		    var imgWidth = 210; // 이미지 가로 길이(mm) / A4 기준 210mm
		    var pageHeight = imgWidth * 1.414;  // 출력 페이지 세로 길이 계산 A4 기준
		    var imgHeight = canvas.height * imgWidth / canvas.width;
		    var heightLeft = imgHeight;
		    var margin = 0; // 출력 페이지 여백설정
		    var doc = new jsPDF('p', 'mm', 'a4');
		    var position = 0;
		       
		    // 첫 페이지 출력
		    doc.addImage(imgData, 'PNG', margin, position, imgWidth, imgHeight);
		    heightLeft -= pageHeight;
		         
		    // 한 페이지 이상일 경우 루프 돌면서 출력
		    while (heightLeft >= 20) {
		        position = heightLeft - imgHeight;
		        doc.addPage();
		        doc.addImage(imgData, 'PNG', margin, position, imgWidth, imgHeight);
		        heightLeft -= pageHeight;
		    }
		 
		    // 파일 저장
		    doc.save(id+".pdf");
		});

	};
	
	$.printReport = function() {
		var id = $("#printFlag").val();
		$('#'+id).parent().printThis({
			beforePrint: beforePrint(),                
	        afterPrint: afterPrint()  
		});
	};
	
	$.dctReportCrcListSelect = function() {
		var params = {
				studentSeq : $("#studentSeq").val(),
				startDt : 	$("#startDt").val(),
				endDt : $("#endDt").val()
			};
		
		$.ajax({
            type : "POST",
            url : "/dct/dctReportCrcListSelect.ajax",
            data : params,
            success : function(res){
            	$.setReportCurriculurm(res.dataList);
            	$.setReportDomain(res.dataList);
            	
        		
        		$(".explanationLabel").parent().parent().on("click", function() {
        			var idx = $(".explanationLabel").index($(this).find(".explanationLabel"));
        			
        			$(".explanationLabel:eq("+idx+")").hide();
        			
        			$(".explanation:eq("+idx+")").show();
        			$(".explanation:eq("+idx+")").focus();
        		});

        		$(".explanation").on("focusout", function() {
        			var idx = $(".explanation").index($(this));
        			var text = $(this).val().replace(/(?:\r\n|\r|\n)/g, '<br/>').replace(/\s/g,"&nbsp;");
        			$(".explanationLabel:eq("+idx+")").html(text);
        			$(".explanationLabel:eq("+idx+")").show();
        			$(this).hide();
        		});
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.setReportCurriculurm = function(dataList) {
		$("#reportTableBody").empty();
		var html = '';
		dataList.forEach(function(dtoItem) {
			var dtoCmp = (dtoItem.domainStatus == 'CMP') ? '<span class="badge badge-success">완료</span> ' : '';
			html+='<tr class="tr-vertical-align report-tr">';
			html+='<th rowspan="2">'+dtoCmp+dtoItem.domainName+'</th>';
			html+='<td>';
			dtoItem.ltoList.forEach(function(ltoItem) {
				var ltoCmp = (ltoItem.ltoStatus == 'CMP') ? '<span class="badge badge-success">완료</span> ' : '';
				var ltoNm = ltoItem.ltoName != null ? ltoItem.ltoName : '';
				html+='<div>LTO : '+ltoCmp+ltoNm+'</div>';
				html+='<ul>';
				ltoItem.stoList.forEach(function(stoItem) {
					if(stoItem.stoName != null){
						var stoCmp = (stoItem.stoStatus == 'CMP') ? '<span class="badge badge-success">완료</span> ' : '';
						html+='<li>STO : '+stoCmp+stoItem.stoName+'</li>';
					} 
				});
				html+='</ul>';
			});
			html+='</td>';
			html+='</tr>';
			html+='<tr class="tr-vertical-align">';
			html+='<td>';
			html+='<div class="d-flex">';
			html+='<span>설명 : </span>';
			html+='<textarea class="explanation custom-width-100" rows="1" style="display:none;"></textarea>';
			html+='<span class="explanationLabel ml-1"></span>';
			html+='</div>';
			html+='</td>';
			html+='</tr>';
		});
		$("#reportTableBody").append(html);
		
	};
	
	$.setReportDomain = function(dataList) {
		$("#reportTableBody2").empty();
		var html = '';
		dataList.forEach(function(dtoItem) {
			var dtoCmp = (dtoItem.domainStatus == 'CMP') ? '<span class="badge badge-success">완료</span> ' : '';
			html+='<tr class="tr-vertical-align">';
			html+='<th>'+dtoCmp+dtoItem.domainName+'</th>';
			html+='<td>';
			html+='<div class="d-flex">';
			html+='<textarea class="explanation custom-width-100" rows="1" style="display:none;"></textarea>';
			html+='<span class="explanationLabel ml-1"></span>';
			html+='</div>';
			html+='</td>';
			html+='</tr>';
		});
		
		$("#reportTableBody2").append(html);
	};
	
	function beforePrint() {
		if($("#printFlag").val() == "quarterlyReportPage"){
			$(".report-chart").css("display", "flex");
			$(".report-chart").css("justify-content", "center");
		}
	}
	function afterPrint() {
	}
	
	$("#reportModal").on("show.bs.modal", function() {
		$.dctReportCrcListSelect();
		
		$(".reportName").val($(".profileName").text());
		$(".reportBirth").val($(".profileBirth").text());
		$(".reportNameLabel").text($(".profileName").text());
		$(".reportBirthLabel").text($(".profileBirth").text());
		
		var reportProgramDt = $("#startDt").val() + " ~ " + $("#endDt").val();
		$(".reportProgramDt").text(reportProgramDt.replace(/-/g, '.'));
		
		$(".reportRegDt").text($.getToday());
		$(".reportRegName").val(authName);
		$(".reportRegNameLabel").text(authName);

	});
	
	$("#reportModal").on("hidden.bs.modal", function() {
		$(".report-chart").css("display", "");
		$(".report-chart").css("justify-content", "");
	});
	
});

$(document).on("keyup", "textarea.explanation", function() {
	$(this).css("height", "auto");
	$(this).height(this.scrollHeight);
});
