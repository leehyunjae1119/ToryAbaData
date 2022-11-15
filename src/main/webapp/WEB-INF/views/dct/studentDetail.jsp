<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div class="container-fluid">

	<div class="d-flex flex-row align-items-center justify-content-between pb-3">
		<h1 class="h3 mb-0 text-gray-800 align-items-center" id="h1StudentName">${date.studentName }</h1>
		<a class="btn" href="javascript:void(0);" onclick="$.toggleProfile();">
			<span id="profileToggleBtnText"></span>
			<i id="profileToggleIcon" class="fas"></i>
		</a>
	</div>

	<div class="row flex-nowrap custom-card-h-280 mb-4" id="profileBody">
		<div class="col-lg-6 c-h-100">
			<div class="card mb-4 c-h-100">
				<div class="card-body">
					<div class="pb-2">
						<span class="small text-warning">이름</span></br>
						<span class="">${date.studentName }</span>
					</div>
					<div class="pb-2">
						<span class="small text-warning">생년월일</span></br>
						<span class="">${date.studentBirth }</span>
					</div>
					<div class="pb-2">
						<span class="small text-warning">프로그램 기간</span></br>
						<span class="">${date.studentStartDt } ~ ${date.studentEndDt }</span>
					</div>
					<div class="pb-2">
						<span class="small text-warning">특징</span></br>
						<span class="">${date.studentEtc }</span>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-3 c-h-100">
			<div class="card bg-primary c-h-100">
				<div class="card-body custom-align-item-center-flex justify-content-center p-0">
					<button type="button" class="btn btn-primary c-fill-up" onclick="$.openPgbEditModal(${studentSeq });" id="">프로그램 편집<br>&<br>데일리</button>
				</div>
			</div>
		</div>
		<div class="col-lg-3 column c-h-100">
			<div class="pb-3">
				<div class="card bg-success text-white c-h-58">
					<div class="card-body custom-align-item-center-flex justify-content-center p-0">
						<button type="button" class="btn btn-success c-fill-up" onclick="$.goCompletionBoard(${studentSeq });" id="">완료목록</button>
					</div>
				</div>
			</div>
			<div class="pb-3">
				<div class="card bg-dark text-white c-h-58">
					<div class="card-body custom-align-item-center-flex justify-content-center p-0">
						<button type="button" class="btn btn-dark c-fill-up" onclick="$.goRunUnitBoard(${studentSeq });" id="">런유닛 그래프</button>
					</div>
				</div>
			</div>
			<div class="pb-3">
				<div class="card bg-dark text-white c-h-58">
					<div class="card-body custom-align-item-center-flex justify-content-center p-0">
						<button type="button" class="btn btn-dark c-fill-up" id="">크리테리아 그래프</button>
					</div>
				</div>
			</div>
			<div class="pb-3">
				<div class="card bg-dark text-white c-h-58">
					<div class="card-body custom-align-item-center-flex justify-content-center p-0">
						<button type="button" class="btn btn-dark c-fill-up" id="">보고서</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<div class="card shadow mb-4">
				<a href="#collapseCardExample" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardExample">
					<h6 class="m-0 font-weight-bold text-primary">커리큘럼</h6>
				</a>
				<div class="collapse show" id="collapseCardExample">
					<input type="hidden" id="studentSeq" name="studentSeq" value="${studentSeq }">
					<div class="card-body">
						<div class="row flex-nowrap align-items-end contents-over-scroll" id="curriculumBoard">
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- modal -->
	<jsp:include page="/WEB-INF/views/pgb/pgbEditModal.jsp"/>
</div>

<script src="../script/dct/dctStudentDetail.js"></script>