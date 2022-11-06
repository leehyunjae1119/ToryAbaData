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
	
	<sitemesh:write property="head"></sitemesh:write>

	<%
		SessionManager s = new SessionManager();
		lgnVO vo = (lgnVO) s.getSession(request);
		
		String authId = "";
		String authName = "";
		
		if(vo == null){
			response.sendRedirect("../lgn/login");
		} else {
			authId = vo.getMemberId();
			authName = vo.getMemberName();
		}
	%>

<c:set var="authId" value="<%=authId %>" scope="request" />
<c:set var="authName" value="<%=authName %>" scope="request" />

</head>
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
				
				<sitemesh:write property="body"></sitemesh:write>
				
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
			<!-- End of Footer -->

		</div>
	</div>
</body>
</html>