$(document).ready(function () {
	
	$("#domainSaveBtn").on("click", function() {
		if(!$.onDomainValidation()){
			$.goDomainSave();
		};
	});
	$("#domainUpdateBtn").on("click", function() {
		if(!$.onDomainValidation()){
			$.goDomainUpdate();
		};
	});
	
	$.onDomainValidation = function() {
		
		var domainName = $("#domainName").val();
		
		if(!nullCheck(domainName)){
			alert("발달영역 이름을 입력하세요.");
			$("#domainName").focus();
			return true;
		}
		
		return false;
	};
	
	$.openGroupEditModal = function() {
		$.selectGroupList();
		$('#groupEditModal').modal('toggle');
	};
	
	$.openDomainSaveModal = function() {
		$("#domainRegistModalLabel").text("발달영역 등록");
		$("#domainSaveBtn").show();
		$("#domainUpdateBtn").hide();
		
		$.setModalDomainData(0);
		$('#domainRegistModal').modal('toggle');
	};
	
	$.openDomainUpdateModal = function(obj) {
		$("#domainRegistModalLabel").text("발달영역 수정");
		$("#domainSaveBtn").hide();
		$("#domainUpdateBtn").show();

		var domainSeq = $.getCurriculumSeq(obj);
		$.setModalDomainData(domainSeq);
		$('#domainRegistModal').modal('toggle');
		
	};
	
	$.setModalDomainData = function(seq) {
		if(seq == 0){
			$("#domainName").val("");
			
		} else {
			$("#domainSeq").val(seq);
			var params = $("#domainForm").serialize();
			// ajax 통신
	        $.ajax({
	            type : "POST",
	            url : "/crc/crcDomainOneSelect.ajax",
	            data : params,
//	            async: false,
	            success : function(res){
	            	
	            	$("#domainName").val(res.data.domainName);
	            },
	            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
	                alert("서버오류. 담당자에게 연락하세요.")
	            }
	        });
		}
	};
	
	$.onclickDomainRemove = function(obj) {
		if(!confirm("삭제 하시겠습니까?")) return;
		
		var domainSeq = $.getCurriculumSeq(obj);
		
		$("#domainSeq").val(domainSeq);
		$.goDomainRemove();
	};
	

	$.useYnToggleChange = function(obj) {
		var domainSeq = $.getCurriculumSeq(obj);
		var domainUseYn = $(obj).prop('checked') == true ? "Y" : "N";
		
		$("#domainSeq").val(domainSeq);
		$("#domainUseYn").val(domainUseYn);
		$.goDomainUseYnUpdate();
		
	};
	
	$.onclickDomainItem = function(obj) {
		var domainSeq = $.getCurriculumSeq(obj);
		
		var str = " - "+$.getCurriculumName(obj);
		$("#spanDomainName").text(str);
		$("#ltoDomainSeq").val(domainSeq);
		
		$.goLTOListSelect();
	};
	
	$.makeGroupItemRow = function(dataList) {
		var html = '';
		var groupSeq = $("#groupSelect > option:selected").val();
		
		dataList.forEach(function(item) {
			html += '<tr class="tr-vertical-align groupItemTr">                                                   ';
			html += '	<td class="text-center"><input class="groupItemChkBox" type="checkbox" value="'+ item.domainSeq + '"';
			
			console.log(groupSeq)
			if( groupSeq == 0 ) {
				html += 'disabled';
			} else {
				if(item.groupSeq > 0 && groupSeq == item.groupSeq){
					html += 'checked';
				} else if (item.groupSeq > 0 && groupSeq != item.groupSeq) {
					html += 'disabled';
				} else {
					
				}
			}
			
			html += '	></td>    ';
			html += '	<td class="groupItem-groupName">'+ item.groupName +'</td>                                                          ';
			html += '	<td class="">'+ item.domainName +'</td>                                                          ';
			html += '</tr>                                                                                        ';
		});
		
		$("#groupItemTableBody").empty();
		$("#groupItemTableBody").append(html);
	};
	
	$.makeDomainDataRow = function(dataList) {
		dataList.forEach(function(item) {
			$("#domainTableBody").append($.domainTemplateRow(item));
		});
	};
	
	$.domainTemplateRow = function(data) {
		var flag = data.domainUseYn == "Y" ? "checked" : "";
		html = ''
			 + '<tr class="tr-vertical-align">'
			 + '	<input type="hidden" class="crcSeq" value="'+ data.domainSeq +'"/>'
			 + '	<th scope="row" class="text-center">'+ data.rownum +'</th>'
			 + '	<td onclick="$.onclickDomainItem(this)" class="crcGroupName">'+ data.groupName +'</td>'
			 + '	<td onclick="$.onclickDomainItem(this)" class="crcName">'+ data.domainName +'</td>'
			 + '	<td data-auth="level1">'
			 + '		<input type="checkbox" class="useYnToggle" data-toggle="toggle" data-size="sm" onchange="$.useYnToggleChange(this);" '+ flag +'>'
			 + '	</td>'
			 + '	<td data-auth="level1">'
			 + '		<a href="javascript:void(0);" class="btn btn-primary btn-circle btn-sm mr-2" onclick="$.openDomainUpdateModal(this);">' 
			 + '			<i class="fas fa-edit"></i>'
			 + '		</a>'
			 + '		<a href="javascript:void(0);" class="btn btn-primary btn-circle btn-sm" onclick="$.onclickDomainRemove(this)">'
			 + '			<i class="fas fa-trash-alt"></i>'
			 + '		</a>'
			 + '	</td>'
			 + '</tr>';
		
		return html;
	};
	
	$.goDomainListSelect = function() {
		var params = $("#domainForm").serialize();
		
        $.ajax({
            type : "POST",
            url : "/crc/crcDomainListSelect.ajax",
            data : params,
            success : function(res){
            	console.log(res.dataList);
            	$("#domainTableBody").empty();
            	$.makeDomainDataRow(res.dataList);
            	$('.useYnToggle').bootstrapToggle();
            	
            	$.makeGroupItemRow(res.dataList);
            	
            	_checkAuth();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goDomainSave = function() {
		var params = $("#domainForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcDomainInsert.ajax",
            data : params,
            success : function(res){
            	$('#domainRegistModal').modal('toggle');
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goDomainUpdate = function() {
		var params = $("#domainForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcDomainUpdate.ajax",
            data : params,
            success : function(res){
            	$('#domainRegistModal').modal('toggle');
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goDomainRemove = function() {
		var params = $("#domainForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcDomainDelete.ajax",
            data : params,
            success : function(res){
            	$.init();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goDomainUseYnUpdate = function() {
		var params = $("#domainForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcDomainUseYnUpdate.ajax",
            data : params,
            success : function(res){
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$("#groupEditTab .nav-link").on("click", function() {
		var contentsId = $(this).data("value")
		
		$("#groupEditTab .nav-link").removeClass("active");
		$(this).addClass("active");
		
		$(".groupContents").hide();
		$("#"+contentsId).show();
		$.selectGroupList();
		
		if(contentsId == 'groupEdit') {
		} else {
			
		}
	});
	
	$.selectGroupList = function() {
		var params = {};
		
        $.ajax({
            type : "POST",
            url : "/crc/crcGroupListSelect.ajax",
            data : params,
            success : function(res){
            	$("#groupTableBody").empty();
            	$("#groupSelect").empty();
            	
            	var html = '';
            	var selectOptionHtml = '';
            	
            	selectOptionHtml += '<option value="0"> 설정할 그룹을 선택하세요.</option>';
            	
            	res.dataList.forEach(function(item) {
            		
            		html += '<tr class="tr-vertical-align">                                                                 ';
            		html += '	<input type="hidden" name="groupSeq" value="'+item.groupSeq+'">                             ';
            		html += '	<td class="pt-0 pb-0">                                                       				';
            		html += '		<div class="input-group group-name-edit-area">																';
            		html += '			<input type="text" class="form-control c-border-left-radius" name="groupName" value="'+item.groupName+'" style="border-radius: 0.35rem 0px 0px 0.35rem;">';
            		html += '			<div class="input-group-append">													';
            		html += '				<button class="btn btn-outline-secondary group-update-btn" type="button">저장</button>';
            		html += '			</div>																				';
            		html += '		</div>																					';
            		html += '	</td>                                                        								';
            		html += '	<td class="text-center">'+item.domainCnt+'</td>                                             ';
            		html += '	<td class="text-center">                                                                    ';
            		html += '		<a href="javascript:void(0);" class="btn btn-primary btn-sm group-yn-btn" data-value="Y">ON</a>      ';
            		html += '		<a href="javascript:void(0);" class="btn btn-light btn-sm group-yn-btn" data-value="N">OFF</a>     ';
            		html += '	</td>                                                                                       ';
            		html += '	<td class="text-center">                                                                    ';
            		html += '		<a href="javascript:void(0);" class="btn btn-primary btn-circle btn-sm group-remove-btn">';
            		html += '			<i class="fas fa-trash-alt"></i>                                                    ';
            		html += '		</a>                                                                                    ';
            		html += '	</td>                                                                                       ';
            		html += '</tr>                                                                                          ';
            		
            		selectOptionHtml += '<option value="'+item.groupSeq+'">'+item.groupName+'</option>';
        			
        		});
            	$("#groupTableBody").append(html);
            	$("#groupSelect").append(selectOptionHtml);
            	
        		$.goDomainListSelect();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$("#addGroupBtn").on("click", function() {
		var groupName = $("#insertGroupName").val().trim();
		var params = {
				groupName : groupName
		};
		
		if(!groupName){
			alert("추가 할 그룹명을 입력하세요.");
			return;
		}
		
		$.ajax({
            type : "POST",
            url : "/crc/crcGroupInsert.ajax",
            data : params,
            success : function(res){
            	$("#insertGroupName").val("");
            	$.selectGroupList();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	});
	
	$("#groupSelect").on("change", function() {
		$.goDomainListSelect();
	});
	
});

$(document).on("click", ".group-yn-btn", function() {
	var params = {
			groupSeq : $(this).parent().parent().find("input[name=groupSeq]").val(),
			domainUseYn : $(this).data("value")
	};
	
	$.ajax({
		type : "POST",
		url : "/crc/crcGroupUseYnUpdate.ajax",
		data : params,
		success : function(res){
			$.goDomainListSelect();
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
			alert("서버오류. 담당자에게 연락하세요.")
		}
	});
});

$(document).on("click", ".group-remove-btn", function() {
	
	if(!confirm("삭제 하시겠습니까?")) return;
	
	var params = {
			groupSeq : $(this).parent().parent().find("input[name=groupSeq]").val()
	};
	
	$.ajax({
		type : "POST",
		url : "/crc/crcGroupDelete.ajax",
		data : params,
		success : function(res){
			$.selectGroupList();
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
			alert("서버오류. 담당자에게 연락하세요.")
		}
	});
});

$(document).on("click", ".group-update-btn", function() {
	
	var params = {
			groupSeq : $(this).parent().parent().parent().parent().find("input[name=groupSeq]").val(),
			groupName : $(this).parent().parent().find("input[name=groupName]").val()
	};
	
	$.ajax({
		type : "POST",
		url : "/crc/crcGroupUpdate.ajax",
		data : params,
		success : function(res){
			$.goDomainListSelect();
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
			alert("서버오류. 담당자에게 연락하세요.")
		}
	});
});

$(document).on("click", ".groupItemTr", function(e) {
	
	if($(this).find("input.groupItemChkBox").is(':disabled')){
		return;
	}
	
	if( !$(e.target).is('input:checkbox') ) {
		$(this).find("input.groupItemChkBox").prop('checked', !$(this).find("input.groupItemChkBox").is(':checked'));
	}
	
	var chkFlag = $(this).find("input.groupItemChkBox").is(':checked');
	var domainSeq = $(this).find("input.groupItemChkBox").val();
	var groupSeq = $("#groupSelect > option:selected").val();
	var groupName = $("#groupSelect > option:selected").text();
	
	var params = {
			domainSeq : domainSeq,
			groupSeq : chkFlag ? groupSeq : 0
	};
	
	if(chkFlag){
		$(this).find("td.groupItem-groupName").text(groupName);
	} else {
		$(this).find("td.groupItem-groupName").text("");
	}
	
	$.ajax({
		type : "POST",
		url : "/crc/crcGroupItemUpdate.ajax",
		data : params,
		success : function(res){
			$.goDomainListSelect();
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
			alert("서버오류. 담당자에게 연락하세요.")
		}
	});
});





