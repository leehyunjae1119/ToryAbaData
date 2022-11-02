<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">

	<h1 class="h3 mb-0 text-gray-800 mb-4">Completion List</h1>
	<p class="mb-4">${studentData.centerName } > ${studentData.className } > ${studentData.studentName } </p>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">준거도달 완료목록</h6>
		</div>
		<div class="card-body p-0">
			<div class="table-responsive">
				<table class="table">
					<colgroup>
						<col width="5%" />
						<col width="25%" />
						<col width="25%" />
						<col width="25%" />
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
							<tr>
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
	</div>
</div>


<!-- <script src="../script/mbr/mbrMain.js"></script> -->

