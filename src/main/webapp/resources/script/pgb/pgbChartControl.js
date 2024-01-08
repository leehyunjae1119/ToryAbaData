$(document).ready(function () {
	
	$.selectLtoChartData = function() {
		$("#ltoChartTitle").text($("#labelLtoName").text())
		
		var ltoSeq = $('button[name=ltoItemBtn].active').attr('data-value');
		
		var params = {
				ltoSeq : ltoSeq
			};
		
		$.ajax({
            type : "POST",
            url : "/pgb/pgbLtoChartDataSelect.ajax",
            data : params,
            success : function(res){
            	if(Chart.getChart("myChart")){
        			myChart.destroy();
        		}
            	
        		_setLabels(res.dataList);
            	_setDatasets(res.dataList);
            	_setAnnotations(res.dataList);
            	_setConfig();
            	
            	_setChartWidth(res.dataList);
            	
            	createChart('myChart');
            	
            	createLegendItem(res.dataList);
            	
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};

});

function createLegendItem(dataList) {
	var listIdx = 0;
	
	var startWidth = myChart.chartArea.left;
	var chartWidth = Math.round(myChart.chartArea.width);
	var itemWidth = chartWidth/(_labels.length-1);
	
	$("#stoChartItem").css("margin-left", startWidth);
	
	$("#stoChartItem").empty();
	dataList.forEach(function(stoDataList) {
		if(stoDataList.length > 0){
			var width = 0;
			width = stoDataList.length * itemWidth - 4;
			
			if(listIdx == 0 && stoDataList.length > 1){
				width = width - (itemWidth/2);
			}
			var tooltipContents = 'STO : ' + $.convertHtmlText(stoDataList[0].stoName) + '<br>'
			                    + '준거도달 기준 : ' + stoDataList[0].stoArrStdPst +' %';
				
			var html = '<button '
					 + 'type="button" '
					 + 'name="" '
					 + 'class="btn btn-primary active chart-item" '
					 + 'style="width:'+width+'px;" '
					 + 'data-toggle="tooltip" '
					 + 'data-html="true" '
					 + 'data-placement="bottom" '
					 + 'title="'+tooltipContents+'"'
					 + '>'+stoDataList[0].stoName+'</button>';
			$("#stoChartItem").append(html);
			
			listIdx++;
		}
	});
	$('[data-toggle="tooltip"]').tooltip();
}


var myChart;
var _labels = new Array();
var _datasetsList = new Array();
var _annotations = new Object();
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
			plugins : {
				legend : {
					display : false,
				},
				autocolors : false,
				annotation : {
					annotations : {}
				},
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
	                    	var x = context.parsed.x;
	                    	
	                        var memberName = _dataList[x].memberName;
	                        var stoTrialCnt = _dataList[x].stoTrialCnt;
	                        var reaCnt = _dataList[x].reaCnt;
	                        var reaRatio = _dataList[x].reaRatio;
	                        var urgCnt = _dataList[x].urgCnt;
	                        var urgRatio = _dataList[x].urgRatio;
	                        
	                        if(context.datasetIndex%2 == 0){
	                        	return [
//	                        	        ' 지시자 : ' + memberName,
	                        	        ' 시도수 : ' + stoTrialCnt,
	                        	        ' 정반응 : ' + reaCnt + ' (' + reaRatio + '%)',
	                        	        ' 촉구 : ' + urgCnt + ' (' + urgRatio + '%)'
	                        	        ];
	                        } else {
	                        	return;
	                        }
	                    }
	                }
				},
			},
			
			scales: {
				y: {
					suggestedMin: 0,
		            suggestedMax: 100,
					stepSize : 10,
					ticks: {
						callback: function(value, index, values) {
					        return value + '%';
					    }
					}
				}
			}
		}
	};

function _setLabels(dataList) {
	_labels = new Array();
	dataList.forEach(function(stoDataList) {
		stoDataList.forEach(function(stoData) {
			_labels.push(stoData.pointDt);
		});
	});
	_labels.push('');
};

function _setDatasets(dataList) {
	
	_datasetsList = new Array();
	
	var idx = 0;
	var listIdx = 0;
	dataList.forEach(function(stoDataList) {
		
		if(stoDataList.length > 0){
			var reaDatasets = new Object();	//정반응
			var urgDatasets = new Object();	//촉구
			
			var reaData = new Array();
			var urgData = new Array();
			
			reaDatasets = {
				backgroundColor: "rgba(0,0,0,1)",
				borderColor: "rgba(0,0,0,0.7)",
				pointRadius: 5,
				fill: false,
				tension: false,
			};
			urgDatasets = {
				backgroundColor: "rgba(255,255,255,1)",
				borderColor: "rgba(0,0,0,0.7)",
				borderDash: [10,5],
				pointRadius: 5,
				fill: false,
				tension: false,
			};
			
			//이전데이터 인덱스 빈값 설정
			for(var i = 0; i<idx; i++){
				reaData.push(null);
				urgData.push(null);
			}
			//데이터 세팅
			stoDataList.forEach(function(stoData) {
				reaData.push(stoData.reaRatio);
				urgData.push(stoData.urgRatio);
				idx++;
				
				_dataList.push(stoData);
			});
			//경계 데이터 빈값설정
			reaData.push(null);
			urgData.push(null);
			
			reaDatasets.data = reaData;
			urgDatasets.data = urgData;
			
			_datasetsList.push(reaDatasets);
			_datasetsList.push(urgDatasets);
			
			listIdx++;
		}
	});
	console.log(_datasetsList);
};

function _setAnnotations(dataList) {
	
	_annotations = new Object();
	
	var idx = 0;
	var listIdx = 0;
	dataList.forEach(function(stoDataList) {
		
		if(stoDataList.length > 0 ){
			idx = idx + stoDataList.length;
			
			//임계치 주석 생성
			var tmpAnnotation_h = new Object();
			tmpAnnotation_h.type = 'line';
			tmpAnnotation_h.borderColor = 'rgb(255, 10, 30, 0.7)';
			tmpAnnotation_h.borderWidth = 1;
			tmpAnnotation_h.xMin = listIdx==0 ? 0 : idx - stoDataList.length - 0.5;
			tmpAnnotation_h.xMax = idx - 0.5;
			tmpAnnotation_h.yMin = stoDataList[0].stoArrStdPst;
			tmpAnnotation_h.yMax = stoDataList[0].stoArrStdPst;
			
			var label = {
					display : true,
					content : stoDataList[0].stoArrStdPst + " %",
					backgroundColor : 'rgb(255, 10, 30, 0.7)'
				};
			tmpAnnotation_h.label = label;
			_annotations["h_line_"+listIdx] = tmpAnnotation_h;
			
			//상태 경계 주석 생성
			var tmpAnnotation_v = new Object();
			tmpAnnotation_v.type = 'line';
			tmpAnnotation_v.xMin = idx - 0.5;
			tmpAnnotation_v.xMax = idx - 0.5;
			tmpAnnotation_v.borderColor = 'rgb(22, 22, 22, 0.7)';
			tmpAnnotation_v.borderWidth = 5;
			if(stoDataList[0].stoArrYn == 'N'){
				tmpAnnotation_v.borderDash = [10,5];
			}
			
			_annotations["v_line_"+listIdx] = tmpAnnotation_v;
			
			listIdx++;
		}
	});
	
	console.log(_annotations);
}

function _setConfig() {
	_config.data.labels = _labels;
	_config.data.datasets = _datasetsList;
	_config.options.plugins.annotation.annotations = _annotations;

	console.log(_config);
};

function _setChartWidth(dataList) {
	var idx = 1;
	dataList.forEach(function(stoDataList) {
		stoDataList.forEach(function(stoData) {
			idx++;
		});
	});
	_chartWidth = idx*50 + 60;
	console.log("_chartWidth : " + _chartWidth);
}

function createChart(id) {
	var ctx = document.getElementById(id);
	
	if(Chart.getChart("myChart")){
		myChart.destroy();
	}
	$("#myChart").attr("width", _chartWidth)
	myChart = new Chart(ctx, _config);
}


//var config = {
//		type: 'line',
//		data: {
//			labels: _labels,
//			datasets: _datasetsList,
//			
//		},
//		options: {
//			responsive: false,
//			plugins : {
//				legend : {
//					display : false,
//				},
//				autocolors : false,
//				annotation : {
//					annotations : {
//						h_line_1 : {
//							type : 'line',
//							xMin : 0,
//							xMax : 4.5,
//							yMin : 90,
//							yMax : 90,
//							borderColor : 'rgb(255, 10, 30, 0.7)',
//							borderWidth : 1,
//							label : {
//								display : true,
////								position : "end",
//								content : "90 %",
//								backgroundColor : 'rgb(255, 10, 30, 0.7)'
//							}
//						},
//						h_line_2 : {
//							type : 'line',
//							xMin : 4.5,
//							xMax : 9.5,
//							yMin : 80,
//							yMax : 80,
//							borderColor : 'rgb(255, 10, 30, 0.7)',
//							borderWidth : 1,
//							label : {
//								display : true,
////								position : "end",
//								content : "80 %",
//								backgroundColor : 'rgb(255, 10, 30, 0.7)'
//							}
//						},
//						v_line_1 : {
//							type : 'line',
//							xMin : 4.5,
//							xMax : 4.5,
//							borderColor : 'rgb(22, 22, 22, 0.7)',
//							borderWidth : 5,
//						},
//						v_line_2 : {
//							type : 'line',
//							xMin : 9.5,
//							xMax : 9.5,
//							borderColor : 'rgb(22, 22, 22, 0.7)',
//							borderWidth : 5,
//							borderDash: [10,5],
//						},
//					}
//				}
//			},
//			scales: {
//				y: {
//					min:0,
//					max:100,
//					stepSize : 10,
//					ticks: {
//						callback: function(value, index, values) {
//					        return value + '%';
//					    }
//					}
//				}
//			}
//		}
//	};


