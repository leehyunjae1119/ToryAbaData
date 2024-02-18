<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Topbar -->
<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

	<!-- Sidebar Toggle (Topbar) -->
	<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
		<i class="fa fa-bars"></i>
	</button>

	<!-- Topbar Search -->
	<div class="d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100">
		<span>Link-i Controller</span>
	</div>

	<!-- Topbar Navbar -->
	<ul class="navbar-nav ml-auto">

<!-- 		<div class="topbar-divider d-none d-sm-block"></div> -->

		<!-- Nav Item - User Information -->
		<li class="nav-item dropdown no-arrow">
			<a class="nav-link dropdown-toggle" href="javascript:void(0);" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<span class="mr-2 d-lg-inline text-gray-600 small"><c:out value="${authId}" /> (<c:out value="${authName}" />)</span>
				<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
			</a>
			<!-- Dropdown - User Information -->
			<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
<!-- 				<a class="dropdown-item" href="javascript:void(0);"> -->
<!-- 					<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> -->
<!-- 					Profile -->
<!-- 				</a> -->
				<a class="dropdown-item" href="../mbr/mypage">
					<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
					my page
				</a>
				<a class="dropdown-item" href="../mbr/memberBoard">
					<i class="fas fa-user-check fa-sm fa-fw mr-2 text-gray-400"></i>
					Member Management
				</a>
				<div class="dropdown-divider"></div>
				<a id="_logoutBtn" class="dropdown-item" href="javascript:void(0);" data-toggle="modal" data-target="#logoutModal">
					<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
					Logout
				</a>
			</div>
		</li>

	</ul>

</nav>
<!-- End of Topbar -->