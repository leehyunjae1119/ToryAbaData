$(document).ready(function () {
	
	$.goSearch = function(pageNum) {
		var params = {
				searchText1 : $("#searchText1").val(),
				pageNum : pageNum
			};
		$.ajax({
            type : "POST",
            url : "/mbr/mbrMemberListSelect.ajax",
            data : params,
            success : function(res){
            	$.makeMemberDataRow(res.dataList);
            	_pagination("mbrPaging", res.pagingVO);
            	$("#pageNum").val(pageNum);
            	
            	_checkAuth();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.makeMemberDataRow = function(dataList) {
		$("#memberTableBody").empty();
		dataList.forEach(function(item) {
			$("#memberTableBody").append($.memberTemplateRow(item));
		});
		
		$('.approvalYnToggle').bootstrapToggle();
	};
	
	$.memberTemplateRow = function(item) {
		var flag = item.approvalYn == "Y" ? "checked" : "";
		var authFlag = '';
		var apprFlag = '';
		
		if(authCd == 'level3'){
			authFlag = 'disabled';
			apprFlag = 'disabled';
		} else if (authCd == 'level2') {
			authFlag = 'disabled';
		}
		
		var html = '';
		html += '<tr class="tr-vertical-align">';
		html += '	<th scope="row" class="text-center">'+item.rownum+'</th>';
		html += '	<td>'+item.memberId+'</td>';
		html += '	<td>'+item.memberName+'</td>';
		html += '	<td>'+item.memberEmail+'</td>';
		html += '	<td>'+item.memberCp+'</td>';
		html += '	<td>';
		html += '		<select onchange="$.onChangeMemberAuthCd(this, '+item.memberSeq+')" '+authFlag+'>';
		html += '			<option value="level1" '+(item.memberAuthCd=="level1"?'selected':'')+'>LEVEL1</option>';
		html += '			<option value="level2" '+(item.memberAuthCd=="level2"?'selected':'')+'>LEVEL2</option>';
		html += '			<option value="level3" '+(item.memberAuthCd=="level3"?'selected':'')+'>LEVEL3</option>';
		html += '		</select>';
		html += '	</td>';
		html += '	<td>';
		html += '		<input type="checkbox" class="approvalYnToggle" data-toggle="toggle" data-size="sm" onchange="$.onChangeApprovalYn(this, '+item.memberSeq+')" '+flag+' '+apprFlag+'>';
		html += '	</td>';
		html += '	<td data-auth="level1">';
		html += '		<a href="javascript:void(0);" class="card-link" onclick="$.onClickPwReset('+item.memberSeq+')">초기화</a>';
		html += '	</td>';
		html += '</tr>';
		
		return html;
	};
	
	$.onChangeApprovalYn = function(obj, memberSeq) {
		var approvalYn = obj.checked ? "Y" : "N";
		var params = {
				memberSeq : memberSeq,
				approvalYn : approvalYn
		};
		$.ajax({
            type : "POST",
            url : "/mbr/mbrApprovalYnUpdate.ajax",
            data : params,
            success : function(res){
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.onChangeMemberAuthCd = function(obj, memberSeq) {
		var memberAuthCd = obj.value;
		var params = {
				memberSeq : memberSeq,
				memberAuthCd : memberAuthCd
		};
		
		$.ajax({
            type : "POST",
            url : "/mbr/mbrMemberAuthCdUpdate.ajax",
            data : params,
            success : function(res){
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.onClickPwReset = function(memberSeq) {
		if(!confirm("해당 계정의 비밀번호를 초기화 하시겠습니까?\n* 초기 비밀번호 : toryABA123!")){
			return ;
		}
		
		var params = {
				memberSeq : memberSeq
		};
		
		$.ajax({
            type : "POST",
            url : "/mbr/mbrMemberPwReset.ajax",
            data : params,
            success : function(res){
            	alert("해당 계정의 비밀번호를 초기화 하였습니다.")
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.centerListSelect = function() {
		$.ajax({
            type : "POST",
            url : "/mbr/centerListSelect.ajax",
            success : function(res){
            	$.makeCenterCard(res.dataList);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                console.log("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	$.makeCenterCard = function(dataList) {
		$("#centerCardBoard").empty();
		dataList.forEach(function(item) {
			var html = '';
			html += '<div class="card border-left-warning py-1 m-2 center-card">';
			html += '	<input type="hidden" value="'+item.centerSeq+'">';
			html += '	<div class="card-body custom-cursor-pointer py-2">';
			html += '		<div class="row no-gutters align-items-center">';
			html += '			<div class="col mr-2">';
			html += '				<div class="h5 mb-0 font-weight-bold text-gray-800">'+item.centerName+'</div>';
			html += '			</div>';
			html += '		</div>';
			html += '	</div>';
			html += '</div>';
			
			$("#centerCardBoard").append(html);
		});
	};
	
	$.teachListSelect = function() {
		var params = {
				centerSeq : $("#centerSeq").val()
			};
		
		$.ajax({
            type : "POST",
            url : "/mbr/teachListSelect.ajax",
            data : params,
            success : function(res){
            	console.log(res.dataList);
            	
            	$("#teachList").empty();
            	$("#teachList").append('<option value="0" selected>선택하기...</option>');
            	
            	res.dataList.forEach(function(item) {
					var html = '';
					html += '<option value="'+item.memberSeq+'" selected>'+item.memberName+'</option>';
					$("#teachList").append(html);
				});
            	
            	$("#teachList").val(0);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                console.log("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.authTeachListSelect = function() {
		var params = {
				centerSeq : $("#centerSeq").val()
			};
		
		$.ajax({
            type : "POST",
            url : "/mbr/authTeachListSelect.ajax",
            data : params,
            success : function(res){
            	console.log(res.dataList);
            	
            	$("#authTeachList").empty();
            	
            	res.dataList.forEach(function(item) {
					var html = '';
					html += '<li class="list-group-item c-row c-cb py-1">';
					html += '	<input type="hidden" class="auth-mamber-seq" value="'+item.memberSeq+'">';
					html += '	<span>'+item.memberName+'</span>';
					html += '	<div class="remove-btn">';
					html += '		<button class="btn" type="button" onclick="$.deleteSubAuth(\''+item.memberSeq+'\')"><i class="fas fa-times-circle"></i></button>';
					html += '	</div> ';
					html += '</li>';
					$("#authTeachList").append(html);
				});
            	
            	if(res.dataList.length == 0){
            		
            	}
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                console.log("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$(".add-btn").on('click', function() {
		var isThisCenter = false;
		$(".auth-mamber-seq").each(function() {
			if($(this).val() == authSeq){
				isThisCenter = true;
			}
		});
		
		if(authCd == 'level2' && !isThisCenter){
			alert("소속된 지점의 권한만 부여가능합니다.");
			return;
		} else if(authCd == 'level3') {
			alert("권한이 없습니다.");
			return;
		}
		
		
		var memberSeq = $("#teachList").val();
		
		if(memberSeq == 0){
			return;
		}
		
		var params = {
				memberSeq : memberSeq,
				centerSeq : $("#centerSeq").val()
			};
		
		$.ajax({
            type : "POST",
            url : "/mbr/subAuthInsert.ajax",
            data : params,
            success : function(res){
            	$.teachListSelect();
            	$.authTeachListSelect();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                console.log("서버오류. 담당자에게 연락하세요.");
            }
        });
	});
	
	$.deleteSubAuth = function(memberSeq) {
		var isThisCenter = false;
		$(".auth-mamber-seq").each(function() {
			if($(this).val() == authSeq){
				isThisCenter = true;
			}
		});
		
		if(authCd == 'level2' && !isThisCenter){
			alert("소속된 지점의 권한만 삭제가 가능합니다.");
			return;
		} else if(authCd == 'level3') {
			alert("권한이 없습니다.");
			return;
		}
		
		var params = {
				memberSeq : memberSeq,
				centerSeq : $("#centerSeq").val()
			};
		
		$.ajax({
            type : "POST",
            url : "/mbr/subAuthDelete.ajax",
            data : params,
            success : function(res){
            	$.teachListSelect();
            	$.authTeachListSelect();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                console.log("서버오류. 담당자에게 연락하세요.");
            }
        });
	};
	
	$.init = function() {
		$.goSearch(1);
		$('.approvalYnToggle').bootstrapToggle();
		
		$.centerListSelect();
	};
	
	$.init();
});

$(document).on("click", ".center-card", function() {
	$(".center-card").removeClass("bg-primary");
	$(this).addClass("bg-primary");
	var centerSeq = $(this).children('input').val();
	
	$("#centerSeq").val(centerSeq);
	
	$("#teachList").prop("disabled", false);
	$(".add-btn").prop("disabled", false);
	
	$.teachListSelect();
	$.authTeachListSelect();
});

$(document).on("click", ".toggle", function() {
	if($(this).children("input").attr("disabled") == "disabled"){
		alert("권한이 없습니다.");
	}
});

function enterkey() {
	if (window.event.keyCode == 13) {
		$.goSearch();
	}
};