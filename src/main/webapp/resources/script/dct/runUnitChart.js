$(document).ready(function () {
	
	$.goSearch = function() {
		$.selectLtoChartData();
	};
	
	$.selectLtoChartData = function() {
		var params = $("#runUnitForm").serialize();
		
		$.ajax({
            type : "POST",
            url : "/dct/dctRunUnitListSelect.ajax",
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
var _totData = new Array();
var _cmpData = new Array();
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
	                    	
	                    	var totCnt = 0;
	                    	var cmpCnt = 0;
	                    	
	                    	_dataList.forEach(function(item) {
								if(context.label == item.dtm){
									totCnt += Number(item.totCnt);
									cmpCnt += Number(item.cmpCnt);
								};
							});
	                    	
	                    	var totStr = 'Total Learn Unit : ' + cmpCnt + ' / ' + totCnt;
	                    	strArray.push(totStr);
	                    	
	                    	_dataList.forEach(function(item) {
	                    		
								if(context.label == item.dtm){
									var str = item.domainName + ' : ' + item.cmpCnt + ' / ' + item.totCnt;
									strArray.push(str);
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
					title : {
						display: true,
						text: 'Learn unit & Forward reaction',
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
		labels.push(item.dtm);
	});
	
	_labels = labels.filter(function(element, index) {
		return labels.indexOf(element) === index;
	});
}

function _setData(dataList) {
	var totData = new Array();
	var cmpData = new Array();
	
	_labels.forEach(function(item) {
		var totCnt = 0;
		var cmpCnt = 0;
		dataList.forEach(function(obj) {
			if(item == obj.dtm){
				totCnt += Number(obj.totCnt);
				cmpCnt += Number(obj.cmpCnt);
			}
		});
		totData.push(totCnt);
		cmpData.push(cmpCnt);
	});
	
	_totData = totData;
	_cmpData = cmpData;
	
}

function _setDatasets() {
	
	var datasets = new Array();
	var totDataset = new Object();
	var cmpDataset = new Object();
	
	totDataset = {
			data : _totData,
			backgroundColor: "rgba(255,255,255,1)",
			borderColor: "rgba(0,0,0,0.7)",
			borderDash: [10,5],
			pointRadius: 5,
			fill: false,
			tension: false,
		};
	
	cmpDataset = {
			data : _cmpData,
			backgroundColor: "rgba(0,0,0,1)",
			borderColor: "rgba(0,0,0,0.7)",
			pointRadius: 5,
			fill: false,
			tension: false,
		};
	
	datasets.push(totDataset);
	datasets.push(cmpDataset);
	
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