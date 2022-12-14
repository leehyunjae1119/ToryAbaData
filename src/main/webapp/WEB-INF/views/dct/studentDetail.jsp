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
		<div class="col-lg-5 c-h-100">
			<div class="card mb-4 c-h-100">
				<div class="card-body">
					<div class="pb-2">
						<span class="small text-warning">이름</span></br>
						<span class="profileName">${date.studentName }</span>
					</div>
					<div class="pb-2">
						<span class="small text-warning">생년월일</span></br>
						<span class="profileBirth">${date.studentBirth }</span>
					</div>
					<div class="pb-2">
						<span class="small text-warning">프로그램 기간</span></br>
						<span class="profileProgramDt">${date.studentStartDt } ~ ${date.studentEndDt }</span>
					</div>
					<div class="pb-2">
						<span class="small text-warning">특징</span></br>
						<span class="profileEtc">${date.studentEtc }</span>
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
		
		<div class="col-lg-2 column c-h-100">
			<div class="pb-3">
				<div class="card bg-info text-white c-h-83">
					<div class="card-body custom-align-item-center-flex justify-content-center p-0">
						<button type="button" class="btn btn-info c-fill-up" onclick="$.goConsultingBoard(${studentSeq });" id="">상담일지</button>
					</div>
				</div>
			</div>
			<div class="pb-3">
				<div class="card bg-info text-white c-h-83">
					<div class="card-body custom-align-item-center-flex justify-content-center p-0">
						<button type="button" class="btn btn-info c-fill-up" onclick="$.goVideoBoard(${studentSeq });" id="">아동영상</button>
					</div>
				</div>
			</div>
			<div class="pb-3">
				<div class="card bg-dark text-white c-h-83">
					<div class="card-body custom-align-item-center-flex justify-content-center p-0">
						<button type="button" class="btn btn-dark c-fill-up" onclick="$.openReport(${studentSeq });" id="">보고서</button>
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-lg-2 c-h-100">
			<div class="pb-3">
				<div class="card bg-success text-white c-h-83">
					<div class="card-body custom-align-item-center-flex justify-content-center p-0">
						<button type="button" class="btn btn-success c-fill-up" onclick="$.goCompletionBoard(${studentSeq });" id="">완료목록</button>
					</div>
				</div>
			</div>
			<div class="pb-3">
				<div class="card bg-dark text-white c-h-83">
					<div class="card-body custom-align-item-center-flex justify-content-center p-0">
						<button type="button" class="btn btn-dark c-fill-up" onclick="$.goRunUnitBoard(${studentSeq });" id="">런유닛 그래프</button>
					</div>
				</div>
			</div>
			<div class="pb-3">
				<div class="card bg-dark text-white c-h-83">
					<div class="card-body custom-align-item-center-flex justify-content-center p-0">
						<button type="button" class="btn btn-dark c-fill-up" onclick="$.goCriteriaBoard(${studentSeq });" id="">크리테리아 그래프</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<div class="card shadow mb-4">
				<a href="#collapseCardCurriculurm" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardCurriculurm">
					<h6 class="m-0 font-weight-bold text-primary">커리큘럼</h6>
				</a>
				<div class="collapse show" id="collapseCardCurriculurm">
					<input type="hidden" id="studentSeq" name="studentSeq" value="${studentSeq }">
					<div class="card-body" style="overflow: overlay;">
						<div class="row flex-nowrap align-items-end" id="curriculumBoard">
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<div class="card shadow mb-4">
				<a href="#collapseCardDomainChart" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="#collapseCardDomainChart">
					<h6 class="m-0 font-weight-bold text-primary">영역별 발달지표</h6>
				</a>
				<div class="collapse show" id="collapseCardDomainChart">
					<div class="card-body">
						<div class="c-row" id="domainChartLabel" style="overflow: auto;">
							<div class="chart-container" style="position: relative; height:50vh; width:80vw">
								<canvas id="domainChart"></canvas>
							</div>
						</div>
						<div class="c-row" id="domainEmptyLabel" style="display:none;">
							<span class="p-4">설정된 데이터가 없습니다.</span>
						</div>
						<div class="c-row c-cr">
							<a class="btn btn-primary" data-toggle="modal" data-target="#datePickerModal">그래프 불러오기</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- modal -->
	<jsp:include page="/WEB-INF/views/pgb/pgbEditModal.jsp"/>
	
	<!-- Modal -->
	<div class="modal fade" id="datePickerModal" tabindex="-1" role="dialog" aria-labelledby="datePickerModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="datePickerModalLabel">그래프 불러오기</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" id="datePickerModalBody">
					<div class="c-row c-cb mb-3">
						<p class="m-0">불러올 날짜를 선택하세요. (최대 5개)</p>
						<button type="button" class="btn btn-outline-purple btn-sm m-0" name="datePickAddBtn">
							<i class="fas fa-plus"></i>
							<span>추가</span>
						</button>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" id="saveDatePicker">확인</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<jsp:include page="/WEB-INF/views/dct/reportModal.jsp"/>
</div>

<script src="../script/dct/dctStudentDetail.js"></script>
<script src="../script/dct/domainChart.js"></script>