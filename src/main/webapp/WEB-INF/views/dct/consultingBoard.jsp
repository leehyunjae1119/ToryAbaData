<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
	<input type="hidden" id="pageNum" value="1"/>
	<input type="hidden" id="memberSeq" value=""/>
	<input type="hidden" id="studentSeq" value="${studentData.studentSeq }"/>
	<h1 class="h3 mb-0 text-gray-800 mb-4">Consulting Memo</h1>
	<p class="mb-2">${studentData.centerName } > ${studentData.className } > ${studentData.studentName } </p>

	<div class="row">
		<div class="col-lg-5">
			<div class="card shadow mb-4">
				<!-- Card Body -->
				<div class="card-body">
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
			</div>
		</div>

		<!-- Content Column -->
		<div class="col-lg-7 mb-4">

			<div class="card mb-3 bg-gray-200">
				<div class="card-body p-1 c-cb">
					<div class="c-row c-cb">
						<div class="input-group">
							<input type="checkbox" class="ml-3 search-item" id="allItemViewYn">
							<label for="allItemViewYn" class="m-0 mx-2" >모든글보기</label>
							<input type="checkbox" class="ml-3 search-item" id="myItemViewYn">
							<label for="myItemViewYn" class="m-0 mx-2" >내글만보기</label>
						</div>
						<button type="button" class="btn btn-outline-purple m-0" id="addConsultingBtn" data-auth="level3">
							<i class="fas fa-plus"></i>
							<span>작성</span>
						</button>
					</div>
				</div>
			</div>
			<div id="consultingCardList">
			</div>
			<div id="noDataCard" style="display:none;">
				<div class="card mb-3 bg-gray-100">
					<div class="card-body">
						작성된 글이 없습니다.
					</div>
				</div>
			</div>
		</div>
		
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="consultingRegistModal" tabindex="-1" aria-labelledby="consultingRegistModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="consultingRegistModalLabel">상담 일지</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="dctConsultingForm" name="dctConsultingForm" onsubmit="return false;">
						<input type="hidden" id="consultingSeq" name="consultingSeq" value="0">
						<div class="input-group">
							<input type="checkbox" class="" name="onlyMyPostYn" id="onlyMyPostYn">
							<label for="onlyMyPostYn" class="m-0 mx-2" >나만보기</label>
						</div>
						<div class="form-group">
							<label for="" class="col-form-label"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">상담 내용</font></font></label>
							<textarea rows="10" class="form-control" name="consultingContents" id="consultingContents"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="consultingSaveBtn">등록</button>
					<button type="button" class="btn btn-success" id="consultingUpdateBtn">수정</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="../script/mai/calender.js"></script>
<script src="../script/dct/dctConsulting.js"></script>

