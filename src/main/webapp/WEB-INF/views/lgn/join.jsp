<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>
<html lang="en">
<head>

	<link rel="apple-touch-icon" sizes="180x180" href="/icon/apple-touch-icon.png?v=2024021801">
	<link rel="icon" type="image/png" sizes="32x32" href="/icon/favicon-32x32.png?v=2024021801">
	<link rel="icon" type="image/png" sizes="16x16" href="/icon/favicon-16x16.png?v=2024021801">
	<link rel="icon" type="image/png" sizes="192x192" href="/icon/android-chrome-192x192.png?v=2024021801">
	<link rel="manifest" href="/icon/site.webmanifest?v=2024021801">
	<link rel="mask-icon" href="/icon/safari-pinned-tab.svg?v=2024021801" color="#5bbad5">
	<link rel="shortcut icon" href="/icon/favicon.ico?v=2024021801">
	<meta name="apple-mobile-web-app-title" content="링크아이 Link-i">
	<meta name="application-name" content="링크아이 Link-i">
	<meta name="msapplication-TileColor" content="#da532c">
	<meta name="theme-color" content="#ffffff">
	<meta name="apple-mobile-web-app-capable" content="yes"> 
	
	<!-- iOS -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>링크아이 Link-i</title>
	
	<!-- Custom fonts for this template-->
	<link href="../js/fontawesome-free/css/all.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

	<!-- Custom styles for this template-->
	<link href="../css/sb-admin-2.css" rel="stylesheet">
	<link href="../css/custom-css.css" rel="stylesheet">
	
</head>

<body class="bg-gradient-customOatmeal custom-align-item-center">
	<div class="container">
	   <div class="card o-hidden border-0 shadow-lg my-5">
		   <div class="card-body p-0">
				<div class="row custom-align-item-center" >
					<div class="col-lg-5 d-none d-lg-block">
						<img class="custom-width-100" alt="메인로고" src="../image/tad_login_img.PNG">	
					</div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">&nbsp;</h1>
							</div>
							<form class="user" id="joinForm" name="joinForm">
								<div class="form-group">
									<input type="text" class="form-control form-control-user" id="memberId" name="memberId" placeholder="아이디">
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="password" class="form-control form-control-user" id="memberPw" name="memberPw" placeholder="비밀번호">
									</div>
									<div class="col-sm-6">
										<input type="password" class="form-control form-control-user" id="memberPwChk" placeholder="비밀번호 확인">
									</div>
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-user" id="memberName" name="memberName" placeholder="이름">
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-user" id="memberCp" name="memberCp" placeholder="연락처" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
								</div>
								<div class="form-group">
									<input type="email" class="form-control form-control-user" id="memberEmail" name="memberEmail" placeholder="이메일">
								</div>
								<hr>
								<a href="javascript:void(0);" id="joinBtn" class="btn custom-btn-primary btn-user btn-block">
									가입신청
								</a>
							</form>
							<div class="text-center">
								<a class="small" href="../lgn/login">로그인하러가기</a>
							</div>
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">&nbsp;</h1>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="../js/jquery/jquery.min.js"></script>
	<script src="../js/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="../js/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="../js/sb-admin-2.min.js"></script>
	<script src="../script/common/common.js"></script>
	<script src="../script/lgn/lgnMain.js"></script>
</body>
</html>
