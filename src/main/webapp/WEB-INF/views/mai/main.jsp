<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
	<input type="hidden" id="memberSeq" value=""/>
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
	</div>
	
	<div class="row">
		<!-- Earnings (Monthly) Card Example -->	
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-primary shadow h-100 py-2">
				<div class="card-body py-2">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-primary text-uppercase mb-1">지점 수</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">${centerCnt }</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-school fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Earnings (Monthly) Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-success shadow h-100 py-2">
				<div class="card-body py-2">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-success text-uppercase mb-1">수퍼바이저 수</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">${superCnt }</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-user-secret fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Earnings (Monthly) Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-info shadow h-100 py-2">
				<div class="card-body py-2">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-info text-uppercase mb-1">교사 수</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">${teachCnt }</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-chalkboard-teacher fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Pending Requests Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-warning shadow h-100 py-2">
				<div class="card-body py-2">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-warning text-uppercase mb-1">아동 수</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">${studentCnt }</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-child fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">

		<div class="col-lg-8 mb-4">
			<div class="card shadow mb-4">
				<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h6 class="m-0 font-weight-bold text-primary">Calender</h6>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-lg-5 mb-4">
							<div class="sec_cal">
								<div class="cal_nav">
									<a href="javascript:;" class="nav-btn go-prev">prev</a>
									<div class="year-month"></div>
									<a href="javascript:;" class="nav-btn go-next">next</a>
								</div>
								<div class="cal_wrap">
									<div class="days">
										<div class="day">MON</div>
										<div class="day">TUE</div>
										<div class="day">WED</div>
										<div class="day">THU</div>
										<div class="day">FRI</div>
										<div class="day">SAT</div>
										<div class="day">SUN</div>
									</div>
									<div class="dates"></div>
								</div>
							</div>
						</div>
						<div class="col-lg-7 mb-4">
							<table class="table">
								<thead class="thead-dark">
									<tr>
										<th scope="col">
											<div class="c-row c-cb">
												<span>todoList</span>
												<button type="button" class="btn btn-light m-0 btn-sm" id="addCalenderBtn" data-auth="level2">
													<i class="fas fa-plus"></i>
													<span>작성</span>
												</button>
											</div>
										</th>
									</tr>
								</thead >
								<tbody id="calenderDataList">
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-lg-4 mb-4">
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">공지사항</h6>	
				</div>
					<table class="table c-table-hover">
						<colgroup>
							<col width="20%" />
							<col width="80%" />
						</colgroup>
						<tbody>
							<c:forEach items="${notice }" var="item" varStatus="status">
								<tr onclick="$.detailNotice(${item.noticeSeq })">
									<td>#${item.rownum }</td>
									<td>${item.noticeTitle }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
		</div>
		
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="calenderRegistModal" tabindex="-1" aria-labelledby="calenderRegistModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="calenderRegistModalLabel">내용 작성</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="dctConsultingForm" name="dctConsultingForm" onsubmit="return false;">
					<input type="hidden" id="calenderSeq" name="calenderSeq" value="0">
					<input type="hidden" id="calenderRegDt" name="calenderRegDt" value="0">
					<p>작성일 : <span id="calenderRegDtLabel"></span></p>
					<div class="form-group">
						<input type="text" class="form-control" name="calenderContents" id="calenderContents">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="calenderSaveBtn">등록</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="noticeDetailModal" tabindex="-1" role="dialog" aria-labelledby="noticeDetailModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header bg-secondary">
				<h5 class="modal-title text-white" id="noticeDetailModalLabel">Notice Detail</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="c-row c-cb ml-4 mr-4">
					<p class="h4 m-0 custom-width-80">제목 : 
						<span id="detailTitle"></span>
					</p>
					<div>
						<p class="m-0 small">작성자 : <span id="detailRegName"></span></p>
						<p class="m-0 small">작성일 : <span id="detailRegDt"></span></p>
					</div>
				</div>
				<hr class="sidebar-divider d-none d-md-block">
				<div class="m-4" style="min-height: 300px">
					<p id="detailContents"></p>
				</div>
			</div>
		</div>
	</div>
</div>
	<!-- Page level plugins -->
	<script src="../js/chart.js/Chart.min.js"></script>
	<script src="../script/mai/calender.js"></script>
	<script src="../script/mai/main.js"></script>
	