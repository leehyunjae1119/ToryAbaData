<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


	<div class="row">
		<div class="col-lg-12">
			<div class="card shadow mb-4">
				<a href="#collapseCardSTO" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardSTO">
					<h6 class="m-0 font-weight-bold text-primary">STO 관리</h6>
				</a>
				<div class="table-responsive collapse" id="collapseCardSTO">
					<div class="card-body p-0">
						<div class="table-responsive">
							<table class="table c-table-hover">
								<colgroup>
									<col width="5%" />
									<col width="25%" />
									<col width="30%" />
									<col width="15%" />
									<col width="10%" />
									<col width="15%" />
								</colgroup>
								<thead>
									<tr>
										<th scope="col" class="text-center">#</th>
										<th scope="col">STO 이름</th>
										<th scope="col">STO 내용</th>
										<th scope="col">준거도달기준</th>
										<th scope="col">시도 수</th>
										<th scope="col">설정</th>
									</tr>
								</thead>
								<tbody id="STOTableBody">
								</tbody>
							</table>
						</div>
						<div class="d-flex flex-row align-items-center justify-content-end">
							<a href="#" class="btn btn-secondary mb-3 mr-3" onclick="$.openSTOSaveModal();">
								<span class="icon">
									<i class="fas fa-plus"></i>
									<span class="text pl-2">STO 추가</span>
								</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="STORegistModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="STORegistModalLabel" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="STORegistModalLabel">STO 등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="STOForm" name="STOForm" onsubmit="return false;">
						<input type="hidden" id="stoSeq" name="stoSeq" value="0">
						<input type="hidden" id="stoLtoSeq" name="stoLtoSeq" value="0">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="stoArrStdPst" class="col-form-label"><font style="vertical-align: inherit;">도달 기준 비율</font></label>
								<select class="form-control" id="stoArrStdPst" name="stoArrStdPst">
									<option value="70">70%</option>
									<option value="75">75%</option>
									<option value="80">80%</option>
									<option value="85">85%</option>
									<option value="90" selected>90%</option>
									<option value="95">95%</option>
									<option value="100">100%</option>
								</select>
							</div>
							<div class="form-group col-md-6">
								<label for="stoArrStdCnt" class="col-form-label"><font style="vertical-align: inherit;">시도 수</font></label>
								<input type="number" class="form-control" id="stoTrialCnt" name="stoTrialCnt" value="15">
<!-- 								<select class="form-control" id="stoArrStdCnt" name="stoArrStdCnt"> -->
<!-- 									<option value="1" selected>1</option> -->
<!-- 									<option value="2">2</option> -->
<!-- 									<option value="3">3</option> -->
<!-- 									<option value="4">4</option> -->
<!-- 									<option value="5">5</option> -->
<!-- 								</select> -->
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-12">
								<label for="stoName" class="col-form-label"><font style="vertical-align: inherit;">STO 이름</font></label>
								<input type="text" class="form-control" id="stoName" name="stoName">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-12">
								<label for="stoContents" class="col-form-label"><font style="vertical-align: inherit;">STO 내용</font></label>
								<input type="text" class="form-control" id="stoContents" name="stoContents">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="STOSaveBtn">등록</button>
					<button type="button" class="btn btn-success" id="STOUpdateBtn">수정</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>

