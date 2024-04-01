<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

	<div class="row mt-4">
		<div class="col-lg-12">
			<div class="card shadow">
				<a href="#collapseCardDomain" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardDomain">
					<h6 class="m-0 font-weight-bold text-primary">발달영역 관리<span id="spanDomainName"></span></h6>
				</a>
				<div class="table-responsive collapse show" id="collapseCardDomain">
					<div class="card-body p-0">
						<div class="table-responsive">
							<table class="table c-table-hover">
								<colgroup>
									<col width="10%" />
									<col width="15%" />
									<col width="45%" />
									<col width="15%" data-auth="level1" />
									<col width="15%" data-auth="level1" />
								</colgroup>
								<thead>
									<tr>
										<th scope="col" class="text-center">No</th>
										<th scope="col">그룹</th>
										<th scope="col">발달영역 이름</th>
										<th scope="col" data-auth="level1">사용유무</th>
										<th scope="col" data-auth="level1">설정</th>
									</tr>
								</thead>
								<tbody id="domainTableBody">
								</tbody>
							</table>
						</div>
						<div class="d-flex flex-row align-items-center justify-content-end" data-auth="level1">
							<a href="#" class="btn btn-secondary mb-3 mr-3" onclick="$.openDomainSaveModal();" >
								<span class="icon">
									<i class="fas fa-plus"></i>
									<span class="text pl-2">발달영역 추가</span>
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
					<h5 class="modal-title" id="domainRegistModalLabel">발달영역 등록</h5>
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
								<label for="" class="col-form-label"><font style="vertical-align: inherit;">발달영역 이름</font></label>
								<input type="text" class="form-control" id="domainName" name="domainName">
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
	<div class="modal fade" id="groupEditModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="groupEditModalLabel" aria-hidden="false">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="groupEditModalLabel">그룹 관리</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<ul class="nav nav-tabs nav-fill" id="groupEditTab">
						<li class="nav-item">
							<a class="nav-link active" href="javascript:void(0);" data-value="groupEdit">그룹 설정</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="javascript:void(0);" data-value="groupItemEdit">발당영역 그룹화</a>
						</li>
					</ul>
					<div class="group-contents-box">
						<div class="form-group m-2 mb-0 groupContents" id="groupEdit">
							<div class="input-group mb-2">
								<input type="text" id="insertGroupName" class="form-control c-border-left-radius" style="border-radius: 0.35rem 0px 0px 0.35rem;" placeholder="추가 할 그룹명을 입력하세요.">
								<div class="input-group-append">
									<button class="btn btn-outline-secondary" id="addGroupBtn" type="button">추가</button>
								</div>
							</div>
							<div class="table-responsive" style="max-height: 25rem; ">
								<table class="table c-table-hover">
									<colgroup>
										<col width="55%" />
										<col width="15%" />
										<col width="15%" />
										<col width="15%" />
									</colgroup>
									<thead>
										<tr>
											<th scope="col">그룹 이름</th>
											<th scope="col" class="text-center">발달영역 수</th>
											<th scope="col" class="text-center">사용 여부</th>
											<th scope="col" class="text-center">삭제</th>
										</tr>
									</thead>
									<tbody id="groupTableBody">
										<tr class="tr-vertical-align">
											<td class="">그룹 1</td>
											<td class="text-center">3</td>
											<td class="text-center">
												<a href="javascript:void(0);" class="btn btn-primary btn-sm" onclick="">
													ON
												</a>
												<a href="javascript:void(0);" class="btn btn-primary btn-sm" onclick="">
													OFF
												</a>
											</td>
											<td class="text-center">
												<a href="javascript:void(0);" class="btn btn-primary btn-circle btn-sm" onclick="">
													<i class="fas fa-trash-alt"></i>
												</a>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="form-group m-2 mb-0 groupContents" id="groupItemEdit" style="display:none;">
							<select class="custom-select mb-2" id="groupSelect" >
							</select>
							<div class="table-responsive" style="max-height: 25rem; ">
								<table class="table c-table-hover">
									<colgroup>
										<col width="15%" />
										<col width="20%" />
										<col width="65%" />
									</colgroup>
									<thead>
										<tr>
											<th scope="col" class="text-center">선택</th>
											<th scope="col">그룹 이름</th>
											<th scope="col">발달영역 이름</th>
										</tr>
									</thead>
									<tbody id="groupItemTableBody">
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
