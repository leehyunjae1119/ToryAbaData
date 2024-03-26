<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<link href="../js/bootstrap4-toggle/css/bootstrap4-toggle.min.css" rel="stylesheet">  
<script src="../js/bootstrap4-toggle/js/bootstrap4-toggle.min.js"></script>

<div class="container-fluid">

	<h1 class="h3 mb-0 text-gray-800">Curriculum</h1>

	<jsp:include page="/WEB-INF/views/crc/domainBoard.jsp"/>
	
	<jsp:include page="/WEB-INF/views/crc/LTOBoard.jsp"/>
	
	<jsp:include page="/WEB-INF/views/crc/STOBoard.jsp"/>
	
</div>


<script src="../script/crc/crcDomain.js?ver=20240327"></script>
<script src="../script/crc/crcLTO.js?ver=20240327"></script>
<script src="../script/crc/crcSTO.js?ver=20240327"></script>
<script src="../script/crc/crcMain.js?ver=20240327"></script>

