$(document).ready(function () {
	
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
	
	$.printReport = function() {
		var id = $("#printFlag").val();
		$('#'+id).printThis({
			beforePrint: beforePrint(),                
	        afterPrint: afterPrint()  
		});
	};
	
	$.dctReportCrcListSelect = function() {
		var params = {
				studentSeq : $("#studentSeq").val()
			};
		$.ajax({
            type : "POST",
            url : "/dct/dctReportCrcListSelect.ajax",
            data : params,
            success : function(res){
            	$.setReportCurriculurm(res.dataList);
            	$.setReportDomain(res.dataList);
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
			html+='<td><span>설명 : </span><textarea class="explanation" rows="1"></textarea></td>';
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
			html+='<td><span>설명 : </span><textarea class="explanation" rows="1"></textarea></td>';
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
		$(".reportBirth").text($(".profileBirth").text());
		$(".reportProgramDt").text($(".profileProgramDt").text());
		
		$(".reportRegDt").text($.getToday());
		$(".reportRegName").val(authName);
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