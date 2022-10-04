<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div class="container-fluid">

	<h1 class="h3 mb-0 text-gray-800">${centerName }</h1>
	<p class="mb-4">센터 > 반</p>

	<!-- 반 선택 -->
	<div class="row" id="classBoard">
	</div>

	<!-- Modal -->
	<div class="modal fade" id="classRegistModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="classRegistModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="classRegistModalLabel">반 등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="dctClassForm" name="dctClassForm" onsubmit="return false;">
						<input type="hidden" name="centerSeq" id="centerSeq" value="${centerSeq }" />
						<div class="form-group">
							<input type="hidden" id="classSeq" name="classSeq" value="0">
							<label for="className" class="col-form-label"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">반 이름</font></font></label>
							<input type="text" class="form-control" id="className" name="className">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="classSaveBtn">등록</button>
					<button type="button" class="btn btn-success" id="classUpdateBtn">수정</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="../script/dct/dctClass.js"></script>
