$(document).ready(function () {
	
	$.goSearch = function() {
		var params = {
				searchText1 : $("#searchText1").val()
			};
		$.ajax({
            type : "POST",
            url : "/mbr/mbrMemberListSelect.ajax",
            data : params,
            success : function(res){
            	$.makeMemberDataRow(res.dataList);
            	
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
		console.log(item.memberAuthCd);
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
	
	$.init = function() {
		$.goSearch();
		$('.approvalYnToggle').bootstrapToggle();
	};
	
	$.init();
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