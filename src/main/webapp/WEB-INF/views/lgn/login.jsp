<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>토리 ABA - 로그인</title>
    
    <!-- Custom fonts for this template-->
    <link href="../js/fontawesome-free/css/all.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="../css/sb-admin-2.css" rel="stylesheet">
    <link href="../css/custom-css.css" rel="stylesheet">
    
</head>

<body class="bg-gradient-customOatmeal">
	<div class="container custom-align-item-center">
        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-3">
                        <!-- Nested Row within Card Body -->
                        <div class="row custom-align-item-center-flex" >
                            <div class="col-lg-6 d-none d-lg-block">
                            	<img class="custom-width-100" alt="메인로고" src="../image/tad_login_img.PNG" id="asd">
                            </div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">&nbsp;</h1>
                                    </div>
                                    <form id="lgnForm" name="lgnForm" class="user">
                                        <div class="form-group">
											<input id="memberId" name="memberId" type="text" class="form-control form-control-user" placeholder="아이디">
										</div>
										<div class="form-group">
											<input id="memberPw" name="memberPw" type="password" class="form-control form-control-user" placeholder="비밀번호">
										</div>
                                        <div class="form-group">
											<div class="custom-control custom-checkbox small">
												<input id="rememberMe" type="checkbox" class="custom-control-input">
												<label class="custom-control-label" for="rememberMe">Remember Me</label>
											</div>
										</div>
                                        <a href="javascript:void(0);" id="loginBtn" class="btn custom-btn-primary btn-user btn-block">로그인</a>
										<hr>
										<a href="../lgn/join" class="btn custom-btn-primary btn-user btn-block">회원가입</a>
                                    </form>
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">&nbsp;</h1>
                                    </div>
                                </div>
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
    <script src="../script/lgn/lgnMain.js"></script>

</body>
</html>
