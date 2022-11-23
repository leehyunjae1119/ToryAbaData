$(document).ready(function () {
	
	$("#datePickerModal").on('show.bs.modal', function() {
		$.selectDatePicker();
	});
	
	$("#datePickerModal").on('hidden.bs.modal', function() {
		$("div[name=datePickArea]").remove();
	});
	
	$("#saveDatePicker").on("click", function() {
		var datePick = '';
		
		$("input[name=datePick]").each(function(index, item) {
			if($(item).val() == ''){
				$(item).parent().remove();
			};
		});
		$("input[name=datePick]").each(function(index, item) {
			if(index != 0 ){ datePick += '||'; }
			datePick += $(item).val();
		});
		
		var params = {
				pickerTarget : $("#studentSeq").val(),
				pickerDt : datePick
			};
		
		$.ajax({
            type : "POST",
            url : "/dct/dctDatePickerUpdate.ajax",
            data : params,
            success : function(res){
            	$("#datePickerModal").modal("hide");
            	$.selectDomainChartData();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	});
	
	$.selectDatePicker = function() {
		
		var params = {
				pickerTarget : $("#studentSeq").val()
			};
		
		$.ajax({
            type : "POST",
            url : "/dct/dctDatePickerSelect.ajax",
            data : params,
            success : function(res){
            	if(res.dataList.length > 0){
            		res.dataList.forEach(function(item) {
            			addDatePicker(item.pickerDt);
					});
            	} else {
            		addDatePicker();
            	}
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.selectDomainChartData = function() {
		var params = {
				pickerTarget : $("#studentSeq").val()
			};
		
		$.ajax({
            type : "POST",
            url : "/dct/dctDomainChartDataSelect.ajax",
            data : params,
            success : function(res){
            	console.log(res.dataList);
            	if(res.dataList.length > 0){
            		_dc_dataList = res.dataList;
            		
            		_dc_setLabels(res.dataList);
            		_dc_setDatasets(res.dataList);
            		_dc_setConfig();
            		
            		_dc_setChartWidth();
            		_dc_createChart("domainChart");
            		
            		$("#domainChartLabel").show();
            		$("#domainEmptyLabel").hide();
            		
            	} else {
            		$("#domainChartLabel").hide();
            		$("#domainEmptyLabel").show();
            	}
            	
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.selectDomainChartData();
	
});

$(document).on("click", "button[name=dateRemoveBtn]", function() {
	$(this).parent().remove();
});
$(document).on("click", "button[name=datePickAddBtn]", function() {
	var datePickerCnt = $("div[name=datePickArea]").length;
	
	if(datePickerCnt < 5) {
		addDatePicker();
	} else {
		alert("최대 5개까지 설정할 수 있습니다.")
	}
});

function addDatePicker(pickDate) {

	var dateString = pickDate ? pickDate : '';
	var html = '';
	
	html += '<div class="c-row c-cb mb-2" name="datePickArea">';
	html += '	<input type="date" class="form-control" name="datePick" value="'+dateString+'">';
	html += '	<button type="button" class="btn m-0" name="dateRemoveBtn">';
	html += '		<i class="fas fa-times"></i>';
	html += '	</button>';
	html += '</div>';
	
	$("#datePickerModalBody").append(html);
};
var CHART_COLORS = {
	red: 'rgb(255, 99, 132)',
	orange: 'rgb(255, 159, 64)',
	yellow: 'rgb(255, 205, 86)',
	green: 'rgb(75, 192, 192)',
	blue: 'rgb(54, 162, 235)',
	purple: 'rgb(153, 102, 255)',
	grey: 'rgb(201, 203, 207)'
};
var NAMED_COLORS = [
	CHART_COLORS.red,
	CHART_COLORS.orange,
	CHART_COLORS.yellow,
	CHART_COLORS.green,
	CHART_COLORS.blue,
	CHART_COLORS.purple
];

var domainChart;
var _dc_dataList = new Array();
var _dc_labels = new Array();
var _dc_datasets = new Array();
var _dc_chartWidth = 0;
var _dc_config = {
		type: 'line',
		data: {},
		options: {
			responsive: true,
			interaction: {
				mode: 'index',
		    },
			layout: {
				padding: 30
			},
			plugins : {
				legend : {
					display : true,
					position : 'bottom',
					align : 'start',
					labels : {
						boxWidth : 15,
						boxHeight : 15,
						padding : 20,
						font : {
							size : 15
						}
					},
				},
				tooltip : {
					enabled : false,
				},
			},
			scales: {
				x: {
					title : {
						display: true,
						text: 'area of ​​development',
						padding: 10,
						font: {
							size: 18,
						}
					},
					ticks: {
						autoSkip : false,
					}
			
				},
				y: {
					stacked: true,
					title : {
						display: true,
						text: 'LTO Unit',
						padding: 10,
						font: {
							size: 18,
						}
					},
					suggestedMin:0,
					suggestedMax:5,
					ticks: {
						stepSize : 1,
				    }
				}
			},
		}
};

function namedColor(index) {
	return NAMED_COLORS[index % NAMED_COLORS.length];
}

function _dc_setLabels(dataList) {
	var labels = new Array();
	
	dataList[0].forEach(function(item) {
		labels.push(item.domainName);
	});
	
	_dc_labels = labels;
}

function _dc_setDatasets(dataList) {
	var datasets = new Array();
	var fsDataset = {
		      label: '',
		      stack: 'combined',
		      type: 'bar',
		      hidden : true
	    };
	
	datasets.push(fsDataset);

	dataList.forEach(function(itemList, index) {
		
		var data = new Array();
		var label = itemList[0].pickerDt;
		
		itemList.forEach(function(item) {
			data.push(item.cmpLtoCnt);
		});
		
		var dataset = {
				label: label,
				data : data,
				pointRadius: 5,
				borderColor: namedColor(index),
				backgroundColor: namedColor(index),
				fill: false,
				tension: false,
				stack: 'combined',
			};
		
		datasets.push(dataset);
		
	});

	_dc_datasets = datasets;
}

function _dc_setConfig() {
	_dc_config.data.labels = _dc_labels;
	_dc_config.data.datasets = _dc_datasets;
	
	console.log(_dc_config);
};

function _dc_setChartWidth() {
	var idx = _dc_labels.length;
	_dc_chartWidth = idx*60 + 180;
};

function _dc_createChart(id) {
	var ctx = document.getElementById(id);
	
	if(Chart.getChart(id)){
		domainChart.destroy();
	}
	$("#"+id).attr("width", _dc_chartWidth)
	domainChart = new Chart(ctx, _dc_config);
};
