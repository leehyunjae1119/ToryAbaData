<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div class="container-fluid">

	<h1 class="h3 mb-0 text-gray-800">${className }</h1>
	<p class="mb-4">센터 > 반 > 아동</p>

	<!-- 센터 선택 -->
	<div class="row" id="studentBoard">
	</div>

	<!-- Modal -->
	<!-- Modal -->
	<div class="modal fade" id="studentRegistModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="studentRegistModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="studentRegistModalLabel">아동 등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="dctStudentForm" name="dctStudentForm" onsubmit="return false;">
						<input type="hidden" id="classSeq" name="classSeq" value="${classSeq }" />
						<input type="hidden" id="studentSeq" name="studentSeq" value="0">
						<div class="form-group">
							<label for="studentName" class="col-form-label"><font style="vertical-align: inherit;">아동 이름</font></label>
							<input type="text" class="form-control" id="studentName" name="studentName">
							
							<label for="studentBirth" class="col-form-label"><font style="vertical-align: inherit;">아동 생년월일</font></label>
							<input type="date" class="form-control" id="studentBirth" name="studentBirth" min="1900-01-01" max="9999-12-31">
							
							<label for="studentEtc" class="col-form-label"><font style="vertical-align: inherit;">아동 특징</font></label>
							<textarea class="form-control" id="studentEtc" name="studentEtc" rows="3"></textarea>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="studentStartDt" class="col-form-label"><font style="vertical-align: inherit;">프로그램시작일</font></label>
								<input type="date" class="form-control" id="studentStartDt" name="studentStartDt" min="1900-01-01" max="9999-12-31">
							</div>
							<div class="form-group col-md-6">
								<label for="studentEndDt" class="col-form-label"><font style="vertical-align: inherit;">프로그램종료일</font></label>
								<input type="date" class="form-control" id="studentEndDt" name="studentEndDt" min="1900-01-01" max="9999-12-31">
							</div>
						</div>
						<div class="form-row">
<!-- 							<div class="form-group col-md-6"> -->
<!-- 								<label for="teacherSeq" class="col-form-label"><font style="vertical-align: inherit;">담당선생님</font></label> -->
<!-- 								<select class="form-control" id="teacherSeq" name="teacherSeq"> -->
<!-- 								</select> -->
<!-- 							</div> -->
							<div class="form-group col-md-12">
								<label for="parentName" class="col-form-label"><font style="vertical-align: inherit;">부모님</font></label>
								<input type="text" class="form-control" id="parentName" name="parentName">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="studentSaveBtn">등록</button>
					<button type="button" class="btn btn-success" id="studentUpdateBtn">수정</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="../script/dct/dctStudent.js"></script>
