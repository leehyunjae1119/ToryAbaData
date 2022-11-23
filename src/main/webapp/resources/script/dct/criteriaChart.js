$(document).ready(function () {
	
	$.goSearch = function() {
		$.selectCriteriaChartData();
	};
	
	$.selectCriteriaChartData = function() {
		var params = $("#criteriaForm").serialize();
		
		$.ajax({
            type : "POST",
            url : "/dct/dctCriteriaListSelect.ajax",
            data : params,
            success : function(res){
            	_dataList = res.dataList;
            	console.log(_dataList);
            	
            	if(res.dataList.length > 0){
            		$("#chartLabel").show();
            		$("#emptyLabel").hide();
            	} else {
            		$("#chartLabel").hide();
            		$("#emptyLabel").show();
            	}
            	_setLabels(res.dataList);
            	_setData(res.dataList);
            	_setChartWidth(res.dataList);
            	_setDatasets();
            	_setConfig();
            	createChart("myChart")
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.init = function() {
		$("#startDt").val(getDateStr(-30));
		$("#endDt").val(getDateStr(0));
		
		$.goSearch();
	};
	
	$.init();
});

var myChart;
var _labels = new Array();
var _data = new Array();
var _datasets = new Array();
var _chartWidth = 0;
var _dataList = new Array();
var _config = {
		type: 'line',
		data: {},
		options: {
			responsive: false,
			interaction: {
				mode: 'index',
		    },
			layout: {
				padding: 30
			},
			plugins : {
				legend : {
					display : false,
				},
				autocolors : true,
				tooltip : {
					titleFont: {
						size: 20,
						weight: 'bold',
					},
					bodyFont: {
						size: 16,
						lineHeight:1.6,
					},
					padding: 20,
					displayColors: false,
					callbacks: {
	                    label: function(context) {
	                    	
	                    	var strArray = new Array();
	                    	
	                    	_dataList.forEach(function(item) {
	                    		
								if(context.label == item.weekEnd){
									var str1 = '총 런유닛 : ' + item.rununit;
									var str2 = '준거도달 : ' + item.arrCnt;
									var str3 = 'Criterion : ' + item.criterion;
									strArray.push(str1);
									strArray.push(str2);
									strArray.push(str3);
								};
							});
	                    	
	                        if(context.datasetIndex%2 == 0){
	                        	return strArray;
	                        } else {
	                        	return;
	                        }
	                    }
	                }
				},
			},
			scales: {
				x: {
					ticks: {
						autoSkip : false,
						minRotation : 45,
						maxRotation : 45,
					}
				},
				y: {
					suggestedMin:0,
					stepSize : 10,
					beginAtZero: true,
					title : {
						display: true,
						text: 'Criterion',
						padding: 10,
						font: {
							size: 18,
						}
					}
				}
			}
		}
	};

function _setLabels(dataList) {
	var labels = new Array();
	dataList.forEach(function(item) {
		labels.push(item.weekEnd);
	});
	_labels = labels;
}

function _setData(dataList) {
	var data = new Array();
	dataList.forEach(function(item) {
		data.push(item.criterion);
	});
	_data = data;
}

function _setDatasets() {
	var datasets = new Array();
	dataset = {
			data : _data,
			backgroundColor: "rgba(0,0,0,1)",
			borderColor: "rgba(0,0,0,0.7)",
			borderDash: [10,5],
			pointRadius: 5,
			fill: false,
			tension: false,
		};
	
	datasets.push(dataset);
	_datasets = datasets;
}

function _setConfig() {
	_config.data.labels = _labels;
	_config.data.datasets = _datasets;
	
	console.log(_config);
};

function _setChartWidth() {
	var idx = _labels.length;
	_chartWidth = idx*60 + 120;
}

function createChart(id) {
	var ctx = document.getElementById(id);
	
	if(Chart.getChart(id)){
		myChart.destroy();
	}
	$("#"+id).attr("width", _chartWidth)
	myChart = new Chart(ctx, _config);
}

function getDateStr(day) {
	var today = new Date();
	today.setDate(today.getDate() + day);
	
	var year = today.getFullYear();
	var month = ('0' + (today.getMonth() + 1)).slice(-2);
	var day = ('0' + today.getDate()).slice(-2);
	
	return year + '-' + month  + '-' + day;
}