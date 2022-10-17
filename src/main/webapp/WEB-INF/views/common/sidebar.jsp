<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
		<!-- Sidebar - Brand -->
		<a class="sidebar-brand d-flex align-items-center justify-content-center" href="/mai/main">
			<div class="sidebar-brand-icon rotate-n-15">
				<i class="fas fa-laugh-wink"></i>
			</div>
			<div class="sidebar-brand-text mx-3">TORY ABA</div>
		</a>

		<!-- Divider -->
		<hr class="sidebar-divider my-0">

		<!-- Nav Item -->
		<!-- 해당페이지 온 오프는  active 클래스 추 -->
		<li class="nav-item">
			<a class="nav-link" href="javascript:void(0);" id="_maiMenu" >
				<span>Dashboard</span>
			</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="javascript:void(0);" id="_dctMenu" >
				<span>Data control</span>
			</a>
		</li>
		<li class="nav-item">
			<a class="nav-link collapsed" href="javascript:void(0);" data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo">
				<span>Curriculum</span>
			</a>
			<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Curriculum</h6>
<!-- 					<a class="collapse-item" href="javascript:void(0);" id="_crcMenuProgramBook">프로그램 편집</a> -->
					<a class="collapse-item" href="javascript:void(0);" id="_crcMenuCurriculum">커리큘럼 관리</a>
				</div>
			</div>
		</li>
		<!-- Heading -->
		<!-- <div class="sidebar-heading">메뉴제목</div> -->

		<!-- Nav Item - Pages Collapse Menu -->
<!-- 		<li class="nav-item"> -->
<!-- 			<a class="nav-link collapsed" href="javascript:void(0);" data-toggle="collapse" data-target="#collapseTwo" -->
<!-- 				aria-expanded="true" aria-controls="collapseTwo"> -->
<!-- 				<span>메뉴1</span> -->
<!-- 			</a> -->
<!-- 			<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar"> -->
<!-- 				<div class="bg-white py-2 collapse-inner rounded"> -->
<!-- 					<h6 class="collapse-header">대메뉴 제목</h6> -->
<!-- 					<a class="collapse-item" href="javascript:void(0);">서브메뉴1</a> -->
<!-- 					<a class="collapse-item" href="javascript:void(0);">서브메뉴2</a> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</li> -->
		
		<!-- Divider -->
		<hr class="sidebar-divider d-none d-md-block">

		<!-- Sidebar Toggler (Sidebar) -->
		<div class="text-center d-none d-md-inline">
			<button class="rounded-circle border-0" id="sidebarToggle" onclick="isSideBarToggle();"></button>
		</div>

		<!-- Sidebar Message -->
		<!--  <div class="sidebar-card d-none d-lg-flex"> -->
		<!-- 	 <img class="sidebar-card-illustration mb-2" src="img/undraw_rocket.svg" alt="..."> -->
		<!-- 	 <p class="text-center mb-2"><strong>SB Admin Pro</strong> is packed with premium features, components, and more!</p> -->
		<!-- 	 <a class="btn btn-success btn-sm" href="https://startbootstrap.com/theme/sb-admin-pro">Upgrade to Pro!</a> -->
		<!--  </div> -->

	</ul>
	<!-- End of Sidebar -->
