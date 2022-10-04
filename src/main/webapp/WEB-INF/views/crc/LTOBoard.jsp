<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

	<div class="row">
		<div class="col-lg-12">
			<div class="card shadow">
				<a href="#collapseCardLTO" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardLTO">
					<h6 class="m-0 font-weight-bold text-primary">LTO 관리<span id="spanLTOName"></span></h6>
				</a>
				<div class="table-responsive collapse" id="collapseCardLTO">
					<div class="card-body p-0">
						<div class="table-responsive">
							<table class="table c-table-hover">
								<colgroup>
									<col width="5%" />
									<col width="25%" />
									<col width="30%" />
									<col width="25%" />
									<col width="15%" />
								</colgroup>
								<thead>
									<tr>
										<th scope="col" class="text-center">#</th>
										<th scope="col">LTO 이름</th>
										<th scope="col">LTO 내용</th>
										<th scope="col">준거도달타입</th>
										<th scope="col">설정</th>
									</tr>
								</thead>
								<tbody id="LTOTablemBody">
								</tbody>
							</table>
						</div>
						<div class="d-flex flex-row align-items-center justify-content-end">
							<a href="#" class="btn btn-secondary mb-3 mr-3" onclick="$.openLTOSaveModal();">
								<span class="icon">
									<i class="fas fa-plus"></i>
									<span class="text pl-2">LTO 추가</span>
								</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="LTORegistModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="LTORegistModalLabel" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="LTORegistModalLabel">LTO 등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="LTOForm" name="LTOForm" onsubmit="return false;">
						<input type="hidden" id="ltoSeq" name="ltoSeq" value="0">
						<input type="hidden" id="ltoDomainSeq" name="ltoDomainSeq" value="0">
						<div class="form-row">
							<div class="form-group col-md-12">
								<label for="ltoName" class="col-form-label"><font style="vertical-align: inherit;">LTO 이름</font></label>
								<input type="text" class="form-control" id="ltoName" name="ltoName">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-12">
								<label for="ltoContents" class="col-form-label"><font style="vertical-align: inherit;">LTO 내용</font></label>
								<input type="text" class="form-control" id="ltoContents" name="ltoContents">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-12">
								<label for="ltoArrTpCd" class="col-form-label"><font style="vertical-align: inherit;">준거도달 타입</font></label>
								<select class="form-control" id="ltoArrTpCd" name="ltoArrTpCd">
									<option value="PER" selected>일반 (Percentage / Counting)</option>
									<option value="ACC">누적 (Accumulation)</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="LTOSaveBtn">등록</button>
					<button type="button" class="btn btn-success" id="LTOUpdateBtn">수정</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>

