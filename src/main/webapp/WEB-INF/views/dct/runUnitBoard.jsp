<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">

	<h1 class="h3 mb-0 text-gray-800 mb-4">Rununit Graph</h1>
	<p class="mb-2">${studentData.centerName } > ${studentData.className } > ${studentData.studentName } </p>

	<form id="runUnitForm" name="runUnitForm" class="form-inline mr-auto w-100 navbar-search justify-content-end" onsubmit="return false;">
		<input type="hidden" name="studentSeq" value="${studentData.studentSeq }">
		<div class="input-group mr-2">
			<input type="date" class="form-control" id="startDt" name="startDt" min="1900-01-01" max="9999-12-31">
		</div>
		<span class="h2 mr-2">~</span>
		<div class="input-group mr-3">
			<input type="date" class="form-control" id="endDt" name="endDt" min="1900-01-01" max="9999-12-31">
		</div>
		<div class="input-group mr-0">
			<button class="btn btn-primary" type="button" onclick="$.goSearch();">
				<i class="fas fa-search fa-sm"></i>
				<span>검색</span>
			</button>
		</div>
	</form>	

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">런유닛 그래프</h6>
		</div>
		<div class="card-body p-0">
			<div class="c-row" id="chartLabel" style="overflow: auto;">
				<div class="">
					<canvas id="myChart" width="500" height="500"></canvas>
				</div>
			</div>
			<div class="c-row" id="emptyLabel" style="display:none;">
				<span class="p-4">데이터가 없습니다.</span>
			</div>
			<div class="c-row pb-4" style="padding-left:6rem;">
				<img class="mr-2" alt="" src="../image/unfill_point.png" style="width: 2rem;">
				<span class="mr-4" >런유닛</span>
				<img class="mr-2"  alt="" src="../image/fill_point.png" style="width: 2rem;">
				<span class="mr-4" >정반응</span>
			</div>
		</div>
	</div>
</div>


<script src="../script/dct/runUnitChart.js"></script>

