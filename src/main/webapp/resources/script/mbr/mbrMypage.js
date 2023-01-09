$(document).ready(function () {
	$("#saveProfile").on('click', function() {
		$("#memberPw").val($("#memberPw").val().trim());
		
		var seq = $("#memberSeq").val();
		var pw = $("#memberPw").val();
		var name = $("#memberName").val();
		var cp = $("#memberCp").val();
		var email = $("#memberEmail").val();
		
		if($.onValidation(pw, name, cp, email)){
			return;
		};
		
		var params = {
				memberSeq : seq,
				memberPw : pw,
				memberName : name,
				memberEmail : email,
				memberCp : cp
			};
		
		$.ajax({
            type : "POST",
            url : "/mbr/mbrProfileUpdate.ajax",
            async : false,
            data : params,
            success : function(res){
            	alert("저장 하였습니다.");
            	
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                console.log("서버오류. 담당자에게 연락하세요.");
            }
        });
	});
	
	
	$.onValidation = function(pw, name, cp, email) {
		var defaultPattern2	= /^[0-9a-zA-Z!%&@#$^*?_~]{8,20}$/;
		var emailPattern 	= /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var cpPattern 		= /^[0-9]{8,12}$/;

		if(nullCheck(pw)){
			if(pw.match(defaultPattern2) == null){
				alert("비밀번호는 영문 대소문자와 숫자 8~20자리로 입력해야합니다.\n *허용 특수문자 ( ! % & @ # $ ^ * ? _ ~ )");
				$("#memberPw").focus();
				return true;
			}
		}
		
		if(!nullCheck(name)){
			alert("이름을 입력하세요.");
			$("#memberName").focus();
			return true;
		}

		if(!nullCheck(email)){
			alert("이메일을 입력하세요.");
			$("#memberEmail").focus();
			return true;
		}
		
		if(email.match(emailPattern) == null){
			alert("올바른 이메일 주소를 입력해주세요.");
			$("#memberEmail").focus();
			return true;
		}
		
		if(!nullCheck(cp)){
			alert("연락처를 입력하세요.");
			$("#memberCp").focus();
			return true;
		}

		if(cp.match(cpPattern) == null){
			alert("올바른 연락처를 입력해주세요.");
			$("#memberCp").focus();
			return true;
		}
		
		return false;
	};
	
	$.init = function() {
	};
	
	$.init();
});

