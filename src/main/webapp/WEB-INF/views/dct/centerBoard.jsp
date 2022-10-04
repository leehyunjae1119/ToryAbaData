<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div class="container-fluid">

	<h1 class="h3 mb-0 text-gray-800">Data Control</h1>
	<p class="mb-4">센터</p>

	<!-- 센터 선택 -->
	<div class="row" id="centerBoard">
	</div>

	<!-- Modal -->
	<div class="modal fade" id="centerRegistModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="centerRegistModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="centerRegistModalLabel">센터 등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="dctCenterForm" name="dctCenterForm" onsubmit="return false;">
						<div class="form-group">
							<input type="hidden" id="centerSeq" name="centerSeq" value="0">
							<label for="centerName" class="col-form-label"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">센터 이름</font></font></label>
							<input type="text" class="form-control" id="centerName" name="centerName">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="centerSaveBtn">등록</button>
					<button type="button" class="btn btn-success" id="centerUpdateBtn">수정</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="../script/dct/dctCenter.js"></script>
