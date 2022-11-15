<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">

	<h1 class="h3 mb-0 text-gray-800 mb-4">Completion List</h1>
	<p class="mb-2">${studentData.centerName } > ${studentData.className } > ${studentData.studentName } </p>

	<form class="form-inline mr-auto w-100 navbar-search justify-content-between" onsubmit="return false;">
		<div class="input-group mr-3">
			<select class="form-control c-w-150" id="domainSeq" name="domainSeq" style="width: 15rem;">
				<option value="" selected>발달영역 선택</option>
			</select>
		</div>
		<div class="c-input-group mr-0">
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
		</div>
	</form>	

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">준거도달 완료목록</h6>
		</div>
		<div class="card-body p-0">
			<div class="table-responsive">
				<table class="table c-table-hover">
					<colgroup>
						<col width="10%" />
						<col width="15%" />
						<col width="15%" />
						<col width="40%" />
						<col width="20%" />
					</colgroup>
					<thead>
					<!-- 번호 발달영역 LTO STO 준거도달일자  -->
						<tr>
							<th scope="col" class="text-center">No</th>
							<th scope="col">발달영역</th>
							<th scope="col">LTO</th>
							<th scope="col">STO</th>
							<th scope="col">준거도달일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${dataList }" var="item" >
							<tr class="tr-vertical-align">
								<th scope="row" class="text-center">${item.rownum }</th>
								<td>${item.domainName }</td>
								<td>${item.ltoName }</td>
								<td>${item.stoName }</td>
								<td>${item.stoArrDt }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item disabled">
					<a class="page-link" href="#" tabindex="-1">
						<span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
					</a>
				</li>
				
				<li class="page-item active"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				
				<li class="page-item">
					<a class="page-link" href="#">
						<span aria-hidden="true">&raquo;</span>
						<span class="sr-only">Next</span>
					</a>
				</li>
			</ul>
		</nav>
	</div>
</div>


<!-- <script src="../script/mbr/mbrMain.js"></script> -->

