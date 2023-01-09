<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page import="com.tad.common.util.*" %>
<%@ page import="com.tad.lgn.vo.*" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>

<html lang="en">
<head>
	<link rel="apple-touch-icon" sizes="180x180" href="/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="/favicon-16x16.png">
	<link rel="manifest" href="/site.webmanifest">
	<link rel="mask-icon" href="/safari-pinned-tab.svg" color="#5bbad5">
	<meta name="apple-mobile-web-app-title" content="토리 ABA"> 
	<meta name="apple-mobile-web-app-capable" content="yes"> 
	<meta name="apple-mobile-web-app-status-bar-style" content="black | black-translucent">
	<meta name="msapplication-TileColor" content="#da532c">
	<meta name="theme-color" content="#ffffff">
	
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>토리 ABA - TORY ABA</title>
	
	<!-- Custom fonts for this template-->
	<link href="../js/fontawesome-free/css/all.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

	<!-- Custom styles for this template-->
	<link href="../css/sb-admin-2.css" rel="stylesheet">
	<link href="../css/custom-css.css" rel="stylesheet">
	<link href="../css/Chart.css" rel="stylesheet">
	<link href="../css/calender.css" rel="stylesheet">
	
	<sitemesh:write property="head"></sitemesh:write>

	<%
		SessionManager s = new SessionManager();
		lgnVO vo = (lgnVO) s.getSession(request);
		
		int authSeq = 0;
		String authId = "";
		String authName = "";
		String authCd = "";
		
		if(vo == null){
			response.sendRedirect("../lgn/login");
		} else {
			authSeq = vo.getMemberSeq();
			authId = vo.getMemberId();
			authName = vo.getMemberName();
			authCd = vo.getMemberAuthCd();
		}
		
		int authCenterSeq = 0;
		int authClassSeq = 0;
		int authStudentSeq = 0;
		
		if(request.getAttribute("centerSeq") != null){
			authCenterSeq = Integer.parseInt((String)request.getAttribute("centerSeq"));
		}
		if(request.getAttribute("classSeq") != null){
			authClassSeq = Integer.parseInt((String)request.getAttribute("classSeq"));
		}
		if(request.getAttribute("studentSeq") != null){
			authStudentSeq = Integer.parseInt((String)request.getAttribute("studentSeq"));
		}
	%>

<c:set var="authSeq" value="<%=authSeq %>" scope="request" />
<c:set var="authId" value="<%=authId %>" scope="request" />
<c:set var="authName" value="<%=authName %>" scope="request" />
<c:set var="authCd" value="<%=authCd %>" scope="request" />

<c:set var="authCenterSeq" value="<%=authCenterSeq %>" scope="request" />
<c:set var="authClassSeq" value="<%=authClassSeq %>" scope="request" />
<c:set var="authStudentSeq" value="<%=authStudentSeq %>" scope="request" />

</head>

<script type="text/javascript">
	var authSeq = "${authSeq}";
	var authName = "${authName}";
	var authCd = "${authCd}";
	
	var authCenterSeq = "${authCenterSeq}";
	var authClassSeq = "${authClassSeq}";
	var authStudentSeq = "${authStudentSeq}";
	
	var path = window.location.pathname;
</script> 

<body>
	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- 사이드바 인클루드 -->
		<jsp:include page="/WEB-INF/views/common/sidebar.jsp"/>
			

		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<!-- topbar -->
				<jsp:include page="/WEB-INF/views/common/topbar.jsp"/>
				
				<!-- Bootstrap core JavaScript-->
				<script src="../js/jquery/jquery.min.js"></script>
				<script src="../js/bootstrap/js/bootstrap.bundle.min.js"></script>
			
				<!-- Core plugin JavaScript-->
				<script src="../js/jquery-easing/jquery.easing.min.js"></script>
			
				<script src="../js/sb-admin-2.min.js"></script>
				<script src="../script/common/common.js"></script>
				
				<!-- Chart.js plugin JavaScript -->
				<script src="../js/chart.js/chart.min.js"></script>
				<script src="../js/chart.js/chartjs-plugin-datalabels.min.js"></script>
				<script src="../js/chart.js/chartjs-plugin-annotation.min.js"></script>
				
				<!-- html2canvas.js plugin JavaScript -->
				<script src="../js/html2canvas/html2canvas.js"></script>
				
				<!-- jspdf.js plugin JavaScript -->
				<script src="../js/jspdf/jspdf.min.js"></script>
				
				<!-- smarteditor plugin JavaScript -->
				<script type="text/javascript" src="/smarteditor2/js/HuskyEZCreator.js" charset="utf-8"></script>
	
				
				<sitemesh:write property="body"></sitemesh:write>
				
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
			<!-- End of Footer -->

		</div>
	</div>
</body>
<!-- <script> -->
<!-- 	$(document).ready(function () { -->
<!-- 		var asdasdasdasd; -->
			
<!-- 		var oEditors = []; -->
		
<!-- 		nhn.husky.EZCreator.createInIFrame({ -->
<!-- 				oAppRef : oEditors, -->
<!-- 				elPlaceHolder : "form-control", -->
<!-- 				sSkinURI : "/smarteditor2/SmartEditor2Skin.html", -->
<!-- 				fCreator : "createSEditor2" -->
<!-- 			}); -->
<!-- 	}); -->
<!-- </script> -->
</html>

