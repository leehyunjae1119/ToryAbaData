<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

	<div class="row mt-4">
		<div class="col-lg-12">
			<div class="card shadow">
				<a href="#collapseCardDomain" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardDomain">
					<h6 class="m-0 font-weight-bold text-primary">영역 관리<span id="spanDomainName"></span></h6>
				</a>
				<div class="table-responsive collapse show" id="collapseCardDomain">
					<div class="card-body p-0">
						<div class="table-responsive">
							<table class="table c-table-hover">
								<colgroup>
									<col width="5%" />
									<col width="25%" />
									<col width="40%" />
									<col width="15%" />
									<col width="15%" />
								</colgroup>
								<thead>
									<tr>
										<th scope="col" class="text-center">#</th>
										<th scope="col">도메인 이름</th>
										<th scope="col">도메인 내용</th>
										<th scope="col">사용유무</th>
										<th scope="col">설정</th>
									</tr>
								</thead>
								<tbody id="domainTableBody">
								</tbody>
							</table>
						</div>
						<div class="d-flex flex-row align-items-center justify-content-end">
							<a href="#" class="btn btn-secondary mb-3 mr-3" onclick="$.openDomainSaveModal();">
								<span class="icon">
									<i class="fas fa-plus"></i>
									<span class="text pl-2">영역 추가</span>
								</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="domainRegistModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="domainRegistModalLabel" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="domainRegistModalLabel">영역 등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="domainForm" name="domainForm" onsubmit="return false;">
						<input type="hidden" id="domainSeq" name="domainSeq" value="0">
						<input type="hidden" id="domainUseYn" name="domainUseYn">
						<div class="form-row">
							<div class="form-group col-md-12">
								<label for="" class="col-form-label"><font style="vertical-align: inherit;">영역 이름</font></label>
								<input type="text" class="form-control" id="domainName" name="domainName">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-12">
								<label for="" class="col-form-label"><font style="vertical-align: inherit;">영역 내용</font></label>
								<input type="text" class="form-control" id="domainContents" name="domainContents">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="domainSaveBtn">등록</button>
					<button type="button" class="btn btn-success" id="domainUpdateBtn">수정</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
