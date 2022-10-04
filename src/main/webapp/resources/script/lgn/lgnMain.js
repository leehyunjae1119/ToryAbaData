$(document).ready(function () {
	$("#lgnForm").keydown(function(e) {
		if(e.keyCode == 13){
			$.login();
		}
	});
	$("#joinForm").keydown(function(e) {
		if(e.keyCode == 13){
			$.join();
		}
	});
	
	$("#loginBtn").on("click", function() {
		$.login();
	});
	
	$("#joinBtn").on("click", function() {
		$.join();
	});
	
	$.login = function() {
		var id = $("#memberId").val();
		var pw = $("#memberPw").val();
		
		if(!$.onLoginValidation(id, pw)){
			$.goLogin();
		};
	};
	
	$.onLoginValidation = function(id, pw) {
		if(!id){
			alert("아이디를 입력하세요.");
			$("#memberId").focus();
			return true;
		}
		
		if(!pw){
			alert("비밀번호를 입력하세요.");
			$("#memberPw").focus();
			return true;
		}
		
		return false;
	};
	
	$.goLogin = function() {
		var params = $("#lgnForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/lgn/login.ajax",
            data : params,
            success : function(res){
            	if(res.loginCd == '0'){
            		location.href = "../mai/main";
            	} else if(res.loginCd == '1'){
            		alert("승인되지 않은 계정입니다.");
            	} else if(res.loginCd == '2'){
            		alert("비밀번호가 일치하지 않습니다.");
            		$("#memberPw").focus();
            	} else {
            		alert("존재하지 않는 계정입니다.");
            		$("#memberId").focus();
            	}
                console.log(res);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.join = function() {
		var id = $("#memberId").val();
		var pw = $("#memberPw").val();
		var pwChk = $("#memberPwChk").val();
		var name = $("#memberName").val();
		var cp = $("#memberCp").val();
		var email = $("#memberEmail").val();
		
		if(!$.onjoinValidation(id, pw, pwChk, name, cp, email)){
			$.goJoin();
		};
	};
	
	$.onjoinValidation = function(id, pw, pwChk, name, cp, email) {
		var defaultPattern 	= /^[0-9a-zA-Z_]{4,20}$/;
		var defaultPattern2	= /^[0-9a-zA-Z!%&@#$^*?_~]{8,20}$/;
		var emailPattern 	= /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var cpPattern 		= /^[0-9]{8,12}$/;

		if(!id){
			alert("아이디를 입력하세요.");
			$("#memberId").focus();
			return true;
		}
		if(id.match(defaultPattern) == null){
			alert("아이디는 영문 대소문자와 숫자 4~20자리로 입력해야합니다.");
			$("#memberId").focus();
			return true;
		}
		
		if(!pw){
			alert("비밀번호를 입력하세요.");
			$("#memberPw").focus();
			return true;
		}
		if(pw.match(defaultPattern2) == null){
			alert("비밀번호는 영문 대소문자와 숫자 8~20자리로 입력해야합니다.\n *허용 특수문자 ( ! % & @ # $ ^ * ? _ ~ )");
			$("#memberPw").focus();
			return true;
		}
		
		if(pw != pwChk){
			alert("비밀번호가 일치하지 않습니다.\n 비밀번호를 확인하세요.");
			$("#memberPwChk").focus();
			return true;
		}
		
		if(!name){
			alert("이름을 입력하세요.");
			$("#memberName").focus();
			return true;
		}
		
		if(!cp){
			alert("연락처를 입력하세요.");
			$("#memberCp").focus();
			return true;
		}

		if(cp.match(cpPattern) == null){
			alert("올바른 연락처를 입력해주세요.");
			$("#memberCp").focus();
			return true;
		}

		if(!email){
			alert("이메일을 입력하세요.");
			$("#memberEmail").focus();
			return true;
		}
		
		if(email.match(emailPattern) == null){
			alert("올바른 이메일 주소를 입력해주세요.");
			$("#memberEmail").focus();
			return true;
		}
		
		return false;
	};
	

	$.goJoin = function() {
		var params = $("#joinForm").serialize();
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/lgn/join.ajax",
            data : params,
            success : function(res){
                console.log(res);
                if(res.joinCd == "0"){
                	alert("가입신청이 완료되었습니다.");
                	location.href = "../lgn/login";
                } else if(res.joinCd == "4") {
                	alert("이미가입된 아이디가 있습니다.");
                	$("#memberId").focus();
                } else {
                	alert("회원가입에 실패했습니다.");
                }
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ 
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
});