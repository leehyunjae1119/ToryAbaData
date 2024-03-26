$(document).ready(function () {
	
	var isPgb = true;
	
	$("#pgbEditModal").on('show.bs.modal', function() {
		$.settingDto();
		$.setModalTitle();
	});

	$("#pgbEditModal").on('shown.bs.modal', function() {
		$(".modal-backdrop").css("z-index", "799");
		$("#pgbEditModal").css("z-index", "800");
		
		if(!isPgb){
			alert("등록된 프로그램이 없습니다. 프로그램을 등록해주세요.");
    		$("#pgbEditModal").modal("hide");
		}
	});
	
	$("#pgbEditModal").on('hide.bs.modal', function() {
		$("#dtoCard").collapse("hide");
		$("#ltoCard").collapse("hide");
		$("#stoCard").collapse("hide");
	});
	
	$(".add-btn").on("click", function() {
		var ltoName = "";
		var ltoSeq = 0;
		var ltoContents = "";
		var hasChoose = false;
		var dataType = $(this).attr("data-value")=='Y' ? true : false;
		
		if(dataType){
			ltoName = $("#ltoNameText").val();
			$("#ltoNameText").val("");
			if(ltoName.trim() === ""){
				alert("LTO 이름을 선택 또는 입력 하세요.");
				return;
			}
		} else {
			ltoSeq = $("#ltoTempletList").val();
			ltoName = $("#ltoTempletList option:checked").text();
			ltoContents = $("#ltoTempletList option:checked").data("value");
			
			if(ltoSeq == 0){
				alert("LTO 이름을 선택 또는 입력 하세요.");
				return;
			}
			
			$("input[name=insertLtoSeq]").each(function(i) {
				if($(this).val() == ltoSeq){
					hasChoose = true;
				}
			});
			
			if(hasChoose){
				alert("이미 선택된 LTO 입니다.");
				return
			}
		}
		
		var html = '';
		html += '<div class="input-group mb-3">                                                                                 ';
		html += '	<input type="text" class="form-control" name="insertLtoName" value="'+$.convertHtmlText(ltoName)+'" readonly="readonly">              ';
		html += '	<input type="hidden" name="insertLtoSeq" value="'+ltoSeq+'" >              			   						';
		html += '	<input type="hidden" name="insertLtoContents" value="'+$.convertHtmlText(ltoContents)+'" >    				';
		html += '	<div class="input-group-append remove-btn">                                                                 ';
		html += '		<button class="btn btn-outline-secondary" type="button"><i class="fas fa-times-circle"></i></button>    ';
		html += '	</div>                                                                                                      ';
		html += '</div>                                                                                                         ';
		
		$("#ltoNameGroup").append(html);
	});
	
	$(".add-btn2").on("click", function() {
		var stoName = "";
		var stoContents = $("input[name=stoContents]").val();
		var stoSeq = 0;
		var hasChoose = false;
		var dataType = $(this).attr("data-value")=='Y' ? true : false;
		
		if(dataType){
			stoName = $("#stoNameText").val();
			$("#stoNameText").val("");
			if(stoName.trim() === ""){
				alert("STO 이름을 선택 또는 입력 하세요.");
				return;
			}
		} else {
			stoSeq = $("#stoTempletList").val();
			stoName = $("#stoTempletList option:checked").text();
			
			if(stoContents != "" && $("#stoTempletList option:checked").data("value") != "") {
				stoContents += ", ";
			}
			stoContents += $("#stoTempletList option:checked").data("value");
			
			if(stoSeq == 0){
				alert("STO 이름을 선택 또는 입력 하세요.");
				return;
			}
			
			$("input[name=insertStoSeq]").each(function(i) {
				if($(this).val() == stoSeq){
					hasChoose = true;
				}
			});
			
			if(hasChoose){
				alert("이미 선택된 STO 입니다.");
				return
			}
		}
		
		var html = '';
		html += '<div class="input-group mb-3">                                                                                 ';
		html += '	<input type="text" class="form-control" name="insertStoName" value="'+$.convertHtmlText(stoName)+'"readonly="readonly">              ';
		html += '	<input type="hidden" name="insertStoSeq" value="'+stoSeq+'" >              			   							';
		html += '	<div class="input-group-append remove-btn">                                                                 ';
		html += '		<button class="btn btn-outline-secondary" type="button"><i class="fas fa-times-circle"></i></button>    ';
		html += '	</div>                                                                                                      ';
		html += '</div>                                                                                                         ';
		
		$("#stoNameGroup").append(html);
		$("input[name=stoContents]").val(stoContents);
		
	});
	
	$("#templetSelectYn").on("change", function() {
		if($(this).prop("checked")){
			$("#ltoNameText").show();
			$("#ltoTempletList").hide();
			$(".add-btn").attr("data-value", 'Y');
		} else {
			$("#ltoTempletList").show();
			$("#ltoNameText").hide();
			$(".add-btn").attr("data-value", 'N');
			
		}
	});
	
	$("#templetSelectYn2").on("change", function() {
		if($(this).prop("checked")){
			$("#stoNameText").show();
			$("#stoTempletList").hide();
			$(".add-btn2").attr("data-value", 'Y');
		} else {
			$("#stoTempletList").show();
			$("#stoNameText").hide();
			$(".add-btn2").attr("data-value", 'N');
			
		}
	});
	
	$.collapseLtoChart = function() {
		if($("#ltoChart").hasClass("show")){
			$("#ltoChart").collapse("hide");
		} else {
			$.selectLtoChartData();
			$("#ltoChart").collapse("show");
		}
	};

	$.getBtnStyle = function(status) {
		var className = '';
		if(status == "CMP"){
			className = 'btn-outline-success';
		} else if(status == "STP") {
			className = 'btn-outline-danger';
		} else if(status == "ING") {
			className = 'btn-outline-primary';
		} else if(status == "WIT") {
			className = 'btn-outline-dark';
		} else {
			className = 'btn-outline-dark btn-outline-success btn-outline-danger btn-outline-primary';
		}
		return className;
	};
	
	$.settingDto = function() {
		var params = {
				studentSeq : $("#studentSeq").val()
			};
		$.ajax({
            type : "POST",
            url : "/pgb/pgbDtoListSelect.ajax",
            data : params,
            success : function(res){
            	if(res.dataList.length > 0 ){
            		isPgb = true;
            		$.makeDtoItem(res.dataList);
            		$.settingLto(res.dataList[0].domainSeq);
            	} else {
            		isPgb = false;
            	}
            	
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.makeDtoItem = function(dataList) {
		$("#dtoBtnGroup").empty();
		dataList.forEach(function(item, index) {
			var btnStyle = $.getBtnStyle(item.domainStatus);
			if(index == 0) { btnStyle += ' active'; }
			var html = '<button type="button" name="dtoItemBtn" class="btn '+btnStyle+' item-btn" data-value="'+item.domainSeq+'" data-status="'+item.domainStatus+'">'+item.domainName+'</button>'
			$("#dtoBtnGroup").append(html);
		});
	};
	
	$.settingLto = function(domainSeq, ltoSeq) {
		var params = {
				domainSeq : domainSeq
			};
		$.ajax({
            type : "POST",
            url : "/pgb/pgbLtoListSelect.ajax",
            data : params,
            success : function(res){
            	if(res.dataList.length > 0 ){
            		if(ltoSeq){
            			$.makeLtoItem(res.dataList, ltoSeq);
            			$.settingLtoDetail(ltoSeq);
            			$.settingSto(ltoSeq);
            		} else {
            			$.makeLtoItem(res.dataList);
            			$.settingLtoDetail(res.dataList[0].ltoSeq);
            			$.settingSto(res.dataList[0].ltoSeq);
            		}
            		$("#ltoCard").collapse("show");
            	} else {
            		$("#ltoBtnGroup").empty();
                	$("#ltoCard").collapse("hide");
                	
                	$("#stoBtnGroup").empty();
                	$("#stoCard").collapse("hide");
            	}
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.makeLtoItem = function(dataList, ltoSeq) {
		$("#ltoBtnGroup").empty();
		dataList.forEach(function(item, index) {
			var btnStyle = $.getBtnStyle(item.ltoStatus);
			if(ltoSeq){
				if(ltoSeq == item.ltoSeq) { btnStyle += ' active'; }
			} else {
				if(index == 0) { btnStyle += ' active'; }
			}
			
			var html = '<button type="button" name="ltoItemBtn" class="btn '+btnStyle+' item-btn" data-value="'+item.ltoSeq+'">'+item.ltoName+'</button>';
			$("#ltoBtnGroup").append(html);
		});
	};
	
	$.settingLtoDetail = function(ltoSeq) {
		var params = {
				ltoSeq : ltoSeq
			};
		$.ajax({
            type : "POST",
            url : "/pgb/pgbLtoOneSelect.ajax",
            data : params,
            success : function(res){
            	$("label[name=labelLtoStatus]").removeClass("active");
            	$("input[name=btnLtoStatus]").removeAttr("checked");
            	
            	$("#ltoSeq").val(res.data.ltoSeq);
            	$("#labelLtoName").text(res.data.ltoName);
            	$("#labelLtoContents").text(res.data.ltoContents);
            	$("#labelLtoStatus_"+res.data.ltoStatus).addClass("active");
            	$("#btnLtoStatus_"+res.data.ltoStatus).attr("checked", true);
            	
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.settingSto = function(ltoSeq, stoSeq) {
		var params = {
				ltoSeq : ltoSeq
			};
		$.ajax({
            type : "POST",
            url : "/pgb/pgbStoListSelect.ajax",
            data : params,
            success : function(res){
            	
            	if(res.dataList.length > 0){
            		if(stoSeq){
                		$.makeStoItem(res.dataList, stoSeq);
                		$.settingStoDetail(stoSeq);
                	} else {
                		$.makeStoItem(res.dataList, res.dataList[0].stoSeq);
                		$.settingStoDetail(res.dataList[0].stoSeq);
                	}
            		$("#stoCard").collapse("show");
            	} else {
            		$("#stoBtnGroup").empty();
                	$("#stoCard").collapse("hide");
            	}
            	
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.makeStoItem = function(dataList, stoSeq) {
		$("#stoBtnGroup").empty();
		dataList.forEach(function(item, index) {
			var btnStyle = $.getBtnStyle(item.stoStatus);
			if(stoSeq){
				if(stoSeq == item.stoSeq) { btnStyle += ' active'; }
			} else {
				if(index == 0) { btnStyle += ' active'; }
			}
			var html = '<button type="button" name="stoItemBtn" class="btn '+btnStyle+' item-btn" data-value="'+item.stoSeq+'">'+item.stoName+'</button>';
			$("#stoBtnGroup").append(html);
		});
	};
	
	$.settingStoDetail = function(stoSeq) {
		var params = {
				stoSeq : stoSeq
			};
		$.ajax({
            type : "POST",
            url : "/pgb/pgbStoOneSelect.ajax",
            data : params,
            success : function(res){
            	$("label[name=labelStoStatus]").removeClass("active");
            	$("input[name=btnStoStatus]").removeAttr("checked");
            	$("#pointRound").val(res.data.stoArrStdCnt);
            	
            	$("#stoSeq").val(res.data.stoSeq);
            	$("#labelStoName").text(res.data.stoName);
            	$("#labelStoContents").text(res.data.stoContents);
            	$("#labelStoTrialCnt").text(res.data.stoTrialCnt);
            	$("#labelStoArrStdPst").text(res.data.stoArrStdPst);
            	$("#labelStoUrgeContents").text(res.data.stoUrgeContents);
            	$("#labelStoEnforceContents").text(res.data.stoEnforceContents);
            	$("#labelStoMemoContents").text(res.data.stoMemoContents);
            	
            	$("#labelStoStatus_"+res.data.stoStatus).addClass("active");
            	$("#btnStoStatus_"+res.data.stoStatus).attr("checked", true);
            	
            	$.setPointBorder();
            	if(res.data){
            		$("#stoCard").collapse("show");
            	}
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.openLtoRegistModal = function(flag) {
		var domainSeq = $('button[name=dtoItemBtn].active').attr('data-value');
		$("input[name=domainSeq]").val(domainSeq);
		$("input[name=ltoSeq]").val($("#ltoSeq").val());
		
		$("#ltoNameGroup").empty();
		
		if(flag == 0){
			//등록
			$("#templetSelectYn").prop("checked", false);
			$("#ltoTempletList").show();
			$("#ltoNameText").hide();
			$("#ltoNameText").val("");
			$(".add-btn").attr("data-value", 'N');
			
			$.setLtoTmplList();
			$("#LTORegistModalLabel").text("LTO 등록");
			$("#LTOSaveBtn").show();
			$("#LTOUpdateBtn").hide();
			$("input[name=ltoName]").val("");
			$("input[name=ltoContents]").val("");
			$("input[name=ltoContents]").prop("disabled", true);
			
			$(".modify-input").hide();
			$(".regist-input").show();
			
		} else {
			//수정
			$("#LTORegistModalLabel").text("LTO 수정");
			$("#LTOSaveBtn").hide();
			$("#LTOUpdateBtn").show();
			$("#updateLtoName").val($("#labelLtoName").text());
			$("input[name=ltoContents]").val($("#labelLtoContents").text());
			$("input[name=ltoContents]").prop("disabled", false);
			
			$(".modify-input").show();
			$(".regist-input").hide();
			
		}
		
		$.customModal("LTORegistModal", "show");
	};
	
	$.registLto = function(flag) {
		var ltoSeq = "";
		var ltoName = "";
		var ltoContents = "";
		
		if(flag == 0){
			$("input[name=insertLtoSeq]").each(function(index) {
				if(index != 0 ){
					ltoSeq += '||';
				}
				ltoSeq += $(this).val();
			});
			$("input[name=insertLtoName]").each(function(index) {
				if(index != 0 ){
					ltoName += '||';
				}
				ltoName += $(this).val();
			});
			$("input[name=insertLtoContents]").each(function(index) {
				if(index != 0 ){
					ltoContents += '||';
				}
				ltoContents += ' ' + $(this).val();
			});
			
			if(ltoSeq == ""){
				alert("LTO를 추가하세요.");
				return;
			}
			
			$("input[name=ltoName]").val(ltoName);
			$("input[name=ltoSeqList]").val(ltoSeq);
			$("input[name=ltoContentsList]").val(ltoContents);
			
		} else {
			ltoName = $("#updateLtoName").val();
			if(ltoName.trim() == ""){
				alert("LTO를 입력해주세요.");
				return;
			}
			$("input[name=ltoName]").val(ltoName);
		}
		
		var params = $("#LTOForm").serialize();
		var url = (flag == 0) ? "/pgb/pgbLtoInsert.ajax" : "/pgb/pgbLtoUpdate.ajax";
		
		$.ajax({
            type : "POST",
            url : url,
            data : params,
            success : function(res){
            	if(flag == 0){
            		$.settingLto($("input[name=domainSeq]").val());
            	} else {
            		$.settingLto($("input[name=domainSeq]").val(), $("input[name=ltoSeq]").val());
            	}
            	$.customModal("LTORegistModal", "hide");
            	$("#stoCard").collapse("hide");
            	
            	$.stautsAutoUpdate("DTO");
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	

	$.openStoRegistModal = function(flag) {
		var ltoSeq = $('button[name=ltoItemBtn].active').attr('data-value');
		var stoSeq = $('button[name=stoItemBtn].active').attr('data-value');
		stoSeq = stoSeq ? stoSeq : 0;
		$("input[name=ltoSeq]").val(ltoSeq);
		$("input[name=stoSeq]").val(stoSeq);
		
		$("#stoNameGroup").empty();
		
		if(flag == 0){
			//등록
			$("#templetSelectYn2").prop("checked", false);
			$("#stoTempletList").show();
			$("#stoNameText").hide();
			$("#stoNameText").val("");
			$(".add-btn2").attr("data-value", 'N');
			
			$.setStoTmplList();
			$("#STORegistModalLabel").text("STO 등록");
			$("#STOSaveBtn").show();
			$("#STOUpdateBtn").hide();
			$("select[name=stoArrStdPst]").val("90");
			$("input[name=stoTrialCnt]").val("15");
			$("input[name=stoName]").val("");
			$("input[name=stoContents]").val("");
			$("input[name=stoUrgeContents]").val("");
			$("input[name=stoEnforceContents]").val("");
			$("input[name=stoMemoContents]").val("");
			
			$(".modify-input").hide();
			$(".regist-input").show();
			
		} else {
			//수정
			$("#STORegistModalLabel").text("STO 수정");
			$("#STOSaveBtn").hide();
			$("#STOUpdateBtn").show();
			$("#updateStoName").val($("#labelStoName").text());
			$("select[name=stoArrStdPst]").val($("#labelStoArrStdPst").text());
			$("input[name=stoTrialCnt]").val($("#labelStoTrialCnt").text());
//			$("input[name=stoName]").val($("#labelStoName").text());
			$("input[name=stoContents]").val($("#labelStoContents").text());
			$("input[name=stoUrgeContents]").val($("#labelStoUrgeContents").text());
			$("input[name=stoEnforceContents]").val($("#labelStoEnforceContents").text());
			$("input[name=stoMemoContents]").val($("#labelStoMemoContents").text());

			$(".modify-input").show();
			$(".regist-input").hide();
		}
		
		$.customModal("STORegistModal", "show");
	};
	
	$.customModal = function(id, option) {
		if(option == "show"){
			$("#"+id).addClass('show');
			$("#"+id).show();
		} else if(option == "hide"){
			$("#"+id).removeClass('show');
			$("#"+id).hide();
		}
	};
	
	$.registSto = function(flag) {
		if($("input[name=stoTrialCnt]").val() == 0){
			$("input[name=stoTrialCnt]").focus();
			alert("도달 기준 횟수를 입력하세요.");
			return;
		}
		
		var stoName = "";
		
		if(flag == 0){
			$("input[name=insertStoName]").each(function(index) {
				if(index != 0 ){
					stoName += ', ';
				}
				stoName += $(this).val();
			});
			
			if(stoName == ""){
				alert("STO를 추가하세요.");
				return;
			}
			
			$("input[name=stoName]").val(stoName);
			
		} else {
			stoName = $("#updateStoName").val();
			if(stoName.trim() == ""){
				alert("STO를 입력해주세요.");
				return;
			}
			$("input[name=stoName]").val(stoName);
		}
		
		var params = $("#STOForm").serialize();
		var url = (flag == 0) ? "/pgb/pgbStoInsert.ajax" : "/pgb/pgbStoUpdate.ajax";

		$.ajax({
            type : "POST",
            url : url,
            data : params,
            success : function(res){
            	if(flag==0){
            		$.settingSto($("input[name=ltoSeq]").val());
            	} else {
            		$.settingSto($("input[name=ltoSeq]").val(), $("input[name=stoSeq]").val());
            	}
            	$.customModal("STORegistModal", "hide");
            	$("#stoCard").collapse("show");
            	
            	$.stautsAutoUpdate("LTO");
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$("input[name=btnDtoStatus]").on('click', function() {
		$("input[name=btnDtoStatus]").removeAttr("checked");
		$(this).attr("checked", true);
		
		var domainSeq = $('button[name=dtoItemBtn].active').attr('data-value');
		var domainStatus = $(this).val();
		
		var params = {
				domainSeq : domainSeq ,
				domainStatus : domainStatus 
		};
		
		$.ajax({
			type : "POST",
			url : "/pgb/pgbDtoStautsUpdate.ajax",
			data : params,
			success : function(res){
            	$('button[name=dtoItemBtn].active').removeClass($.getBtnStyle("ALL"));
            	$('button[name=dtoItemBtn].active').addClass($.getBtnStyle(domainStatus));
			},
			error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
				alert("서버오류. 담당자에게 연락하세요.")
			}
		});
	});
	
	$("input[name=btnLtoStatus]").on('click', function() {
		$("input[name=btnLtoStatus]").removeAttr("checked");
		$(this).attr("checked", true);
		
		var ltoSeq = $('button[name=ltoItemBtn].active').attr('data-value');
		var domainSeq = $('button[name=dtoItemBtn].active').attr('data-value');
		var ltoStatus = $(this).val();
		 
		var params = {
				domainSeq : domainSeq ,
				ltoSeq : ltoSeq ,
				ltoStatus : ltoStatus
		};
		
		$.ajax({
            type : "POST",
            url : "/pgb/pgbLtoStautsUpdate.ajax",
            data : params,
            success : function(res){
//            	$('button[name=dtoItemBtn].active').removeClass($.getBtnStyle("ALL"));
//            	$('button[name=dtoItemBtn].active').addClass($.getBtnStyle(res.data));
            	
            	$('button[name=ltoItemBtn].active').removeClass($.getBtnStyle("ALL"));
            	$('button[name=ltoItemBtn].active').addClass($.getBtnStyle(ltoStatus));
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	});
	
	$("input[name=btnStoStatus]").on('click', function() {
		$("input[name=btnStoStatus]").removeAttr("checked");
		$(this).attr("checked", true);
		
		var domainSeq = $('button[name=dtoItemBtn].active').attr('data-value');
		var ltoSeq = $('button[name=ltoItemBtn].active').attr('data-value');
		var stoSeq = $('button[name=stoItemBtn].active').attr('data-value');
		var stoStatus = $(this).val();
		
		var params = {
				domainSeq : domainSeq ,
				ltoSeq : ltoSeq ,
				stoSeq : stoSeq ,
				stoStatus : stoStatus
		};
		
		$.ajax({
            type : "POST",
            url : "/pgb/pgbStoStautsUpdate.ajax",
            data : params,
            success : function(res){
            	
//            	$('button[name=dtoItemBtn].active').removeClass($.getBtnStyle("ALL"));
//            	$('button[name=dtoItemBtn].active').addClass($.getBtnStyle(res.dtoStatus));
//            	
//            	$('button[name=ltoItemBtn].active').removeClass($.getBtnStyle("ALL"));
//            	$('button[name=ltoItemBtn].active').addClass($.getBtnStyle(res.ltoStatus));
//            	
//            	$("input[name=btnLtoStatus]").removeAttr("checked");
//            	$("label[name=labelLtoStatus]").removeClass("active");
//        		$("#btnLtoStatus_"+res.ltoStatus).attr("checked", true);
//        		$("#labelLtoStatus_"+res.ltoStatus).addClass("active");
            	
        		$('button[name=stoItemBtn].active').removeClass($.getBtnStyle("ALL"));
            	$('button[name=stoItemBtn].active').addClass($.getBtnStyle(stoStatus));
            	
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	});
	
	$.setModalTitle = function() {
		var studentSeq = $("#studentSeq").val();
		
		var params = {
				studentSeq : studentSeq 
		};
		
		$.ajax({
            type : "POST",
            url : "/pgb/pgbModalTitleSelect.ajax",
            data : params,
            success : function(res){
            	$("#mt_center").text(res.data.centerName);
            	$("#mt_class").text(res.data.className);
            	$("#mt_student").text(res.data.studentName);
            }
		});
	};
	
	$.setStoTmplList = function() {
		var ltoSeq = $('button[name=ltoItemBtn].active').attr('data-value');
		
		var params = {
				ltoSeq : ltoSeq
			};
		
		$.ajax({
            type : "POST",
            url : "/pgb/pgbStoTmplListSelect.ajax",
            data : params,
            success : function(res){
            	$("#stoTempletList").empty();
				$("#stoTempletList").append('<option value="0" selected>선택하기</option>');
				
				if(res.dataList.length > 0){
					res.dataList.forEach(function(item) {
						var opt = '<option value="'+item.stoSeq+'" data-value="'+item.stoContents+'" >'+item.stoName+'</option>';
						$("#stoTempletList").append(opt);
					});
				} else {
					
				}
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.setLtoTmplList = function() {
		var dtoSeq = $('button[name=dtoItemBtn].active').attr('data-value');
		
		var params = {
				domainSeq : dtoSeq
		};

		$.ajax({
			type : "POST",
			url : "/pgb/pgbLtoTmplListSelect.ajax",
			data : params,
			success : function(res){
				$("#ltoTempletList").empty();
				$("#ltoTempletList").append('<option value="0" selected>선택하기</option>');
				
				if(res.dataList.length > 0){
					res.dataList.forEach(function(item) {
						var opt = '<option value="'+item.ltoSeq+'" data-value="'+item.ltoContents+'">'+item.ltoName+'</option>';
						console.log(opt);
						$("#ltoTempletList").append(opt);
					});
				} else {
					
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
				alert("서버오류. 담당자에게 연락하세요.")
			}
		});
	};
	
	$.deleteSto = function() {

		if(!confirm("STO를 삭제하시겠습니까?")){
			return ;
		}
		
		var stoSeq = $('button[name=stoItemBtn].active').attr('data-value');
		var ltoSeq = $('button[name=ltoItemBtn].active').attr('data-value');
		var params = {
				stoSeq : stoSeq
			};
		
		$.ajax({
            type : "POST",
            url : "/pgb/pgbStoDelete.ajax",
            data : params,
            success : function(res){
            	$.settingSto(ltoSeq);
            	$.stautsAutoUpdate("LTO");
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.deleteLto = function() {
		
		if(!confirm("LTO를 삭제하시겠습니까?\n해당 STO도 모두 삭제됩니다.")){
			return ;
		}
		
		var ltoSeq = $('button[name=ltoItemBtn].active').attr('data-value');
		var dtoSeq = $('button[name=dtoItemBtn].active').attr('data-value');
		var params = {
				ltoSeq : ltoSeq
		};
		
		$.ajax({
			type : "POST",
			url : "/pgb/pgbLtoDelete.ajax",
			data : params,
			success : function(res){
				$.settingLto(dtoSeq);
				$.stautsAutoUpdate("DTO");
			},
			error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
				alert("서버오류. 담당자에게 연락하세요.")
			}
		});
	};
	
	$.settingDtoDetails = function() {
		var dtoSeq = $('button[name=dtoItemBtn].active').attr('data-value');
		var dtoName = $('button[name=dtoItemBtn].active').text();
		var dtoStatus = $('button[name=dtoItemBtn].active').attr('data-status');
		
		$("#labelDtoName").text(dtoName);
		
		$("label[name=labelDtoStatus]").removeClass("active");
    	$("input[name=btnDtoStatus]").removeAttr("checked");
    	$("#labelDtoStatus_"+dtoStatus).addClass("active");
    	$("#btnDtoStatus_"+dtoStatus).attr("checked", true);
	};
});

$(document).on("click", "button[name=dtoItemBtn]", function() {
	if(!$(this).hasClass("active")){
		$("button[name=dtoItemBtn]").removeClass("active")
		$(this).addClass("active");
		
		$.settingLto($(this).attr("data-value"));
		
		$("#ltoChart").collapse("hide");
		$("#dtoCard").collapse("hide");
	} else {
		$("#dtoCard").collapse("toggle");
		$.settingDtoDetails();
	}
});

$(document).on("click", "button[name=ltoItemBtn]", function() {
	if(!$(this).hasClass("active")){
		$("button[name=ltoItemBtn]").removeClass("active")
		$(this).addClass("active");
		
		$.settingLtoDetail($(this).attr("data-value"));
		
		$.settingSto($(this).attr("data-value"));
		
		$("#ltoCard").collapse("show");
		$("#ltoChart").collapse("hide");
	} else {
		$("#ltoCard").collapse("toggle");
	}
});

$(document).on("click", "button[name=stoItemBtn]", function() {
	if(!$(this).hasClass("active")){
		$("button[name=stoItemBtn]").removeClass("active");
    	$(this).addClass("active");
    	
    	$.settingStoDetail($(this).attr("data-value"));
	} else {
		$("#stoCard").collapse("toggle");
	}
});

$(document).on("keyup", "input[name=stoName]", function() {
	if($(this).attr("data-code") == 0){
		if($(this).val() == ""){
			if($("input[name=stoName]").length > 1){
				$(this).remove();
			}
		} else {
			if($("input[name=stoName]:last").val() != ""){
				var input = $(this).clone().val("");
				$("#stoNameList").append(input);
			}
		}
	}
});

$(document).on("keyup", "input[name=ltoName]", function() {
	if($(this).attr("data-code") == 0){
		if($(this).val() == ""){
			if($("input[name=ltoName]").length > 1){
				$(this).remove();
			}
		} else {
			if($("input[name=ltoName]:last").val() != ""){
				var input = $(this).clone().val("");
				$("#ltoNameList").append(input);
			}
		}
	}
});

$(document).on("click", ".remove-btn", function() {
	$(this).parent().remove();
});

