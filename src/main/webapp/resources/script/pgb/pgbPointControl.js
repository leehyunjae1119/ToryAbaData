$(document).ready(function () {
	
	$.insertPoint = function(pointRsltCd) {
		var ltoSeq = $('button[name=ltoItemBtn].active').attr('data-value');
		var stoSeq = $('button[name=stoItemBtn].active').attr('data-value');
		
		var params = {
				stoSeq : stoSeq ,
				pointRsltCd : pointRsltCd
			};
		$.ajax({
            type : "POST",
            url : "/pgb/pgbPointInsert.ajax",
            data : params,
            success : function(res){
            	$.stautsAutoUpdate("STO");
            	$.setPointBorder();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.deletePoint = function() {
		var stoSeq = $('button[name=stoItemBtn].active').attr('data-value');
		
		var params = {
				stoSeq : stoSeq
			};
		$.ajax({
            type : "POST",
            url : "/pgb/pgbPointDelete.ajax",
            data : params,
            success : function(res){
            	$.stautsAutoUpdate("STO");
            	$.setPointBorder();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.setPointBorder = function() {
		var stoSeq = $('button[name=stoItemBtn].active').attr('data-value');
		
		var params = {
				stoSeq : stoSeq
			};
		$.ajax({
            type : "POST",
            url : "/pgb/pgbPointListSelect.ajax",
            data : params,
            success : function(res){
            	$.makePoint(res.dataList);
            	$.checkPoint();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.makePoint = function(dataList) {
		var stoTrialCnt = $("#labelStoTrialCnt").text();
    	var rowCnt = parseInt(stoTrialCnt / 5) + (stoTrialCnt % 5 > 0 ? 1 : 0);
    	var html = '';
    	
    	for(var i = 1; i <= rowCnt; i++){
    		html += '<ul class="point-list-group">';
    		
    		var rowItemCnt = (stoTrialCnt - (5*(i-1)) < 5) ? (stoTrialCnt % 5) : 5;
    		for(var j = 1; j <= rowItemCnt; j++){
    			var idx = 5*(i-1) + j-1;
    			var data = dataList[idx];

    			if(data){
    				if(data.pointRsltCd == '+'){
    					html += '<li class="point-list-item bg-success"><i class="fas fa-plus"></i></li>';
    				} else if(data.pointRsltCd == '-') {
    					html += '<li class="point-list-item bg-danger"><i class="fas fa-minus"></i></li>';
    				} else if(data.pointRsltCd == 'P') {
    					html += '<li class="point-list-item bg-warning"><i class="fas fa-p"></i></li>';
    				} else {
    					html += '<li class="point-list-item"></li>';
    				}
    			} else {
    				html += '<li class="point-list-item"></li>';
    			}
    			
    		}
    		
    		html += '</ul>';
    	}
    	
    	$("#pointBorder").empty();
    	$("#pointBorder").append(html);
	};
	
	$.stautsAutoUpdate = function(flag) {
		var dtoSeq = $('button[name=dtoItemBtn].active').attr('data-value');
		var ltoSeq = $('button[name=ltoItemBtn].active').attr('data-value');
		var stoSeq = $('button[name=stoItemBtn].active').attr('data-value');
		
		var params = {
				domainSeq : dtoSeq,
				ltoSeq : ltoSeq,
				stoSeq : stoSeq,
				updateFlag : flag
			};
		
		$.ajax({
            type : "POST",
            url : "/pgb/pgbStautsAutoUpdate.ajax",
            data : params,
            success : function(res){
            	if(flag == "STO" || flag == "LTO" || flag == "DTO"){
            		$('button[name=dtoItemBtn].active').removeClass($.getBtnStyle("ALL"));
                	$('button[name=dtoItemBtn].active').addClass($.getBtnStyle(res.dtoStatus));
            	}
            	
            	if(flag == "STO" || flag == "LTO"){
            		$('button[name=ltoItemBtn].active').removeClass($.getBtnStyle("ALL"));
                	$('button[name=ltoItemBtn].active').addClass($.getBtnStyle(res.ltoStatus));
                	
                	$("input[name=btnLtoStatus]").removeAttr("checked");
                	$("label[name=labelLtoStatus]").removeClass("active");
            		$("#btnLtoStatus_"+res.ltoStatus).attr("checked", true);
            		$("#labelLtoStatus_"+res.ltoStatus).addClass("active");
            	}
        		
        		if(flag == "STO"){
        			$('button[name=stoItemBtn].active').removeClass($.getBtnStyle("ALL"));
                	$('button[name=stoItemBtn].active').addClass($.getBtnStyle(res.stoStatus));

                	$("input[name=btnStoStatus]").removeAttr("checked");
            		$("label[name=labelStoStatus]").removeClass("active");
            		$("#btnStoStatus_"+res.stoStatus).attr("checked", true);
            		$("#labelStoStatus_"+res.stoStatus).addClass("active");
            	}
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.checkPoint = function() {
		if($(".point-list-item:last").is(".bg-success, .bg-warning, .bg-danger")){
			$("button[name=pointAddBtn]").attr("disabled", true);
			$("button[name=pointAddBtn]").addClass("disabled");
		} else {
			$("button[name=pointAddBtn]").attr("disabled", false);
			$("button[name=pointAddBtn]").removeClass("disabled");
		}
	}
	
});