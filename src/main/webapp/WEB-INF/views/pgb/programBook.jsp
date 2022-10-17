<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="../js/bootstrap4-toggle/css/bootstrap4-toggle.min.css" rel="stylesheet">  
<script src="../js/bootstrap4-toggle/js/bootstrap4-toggle.min.js"></script>

<div class="container-fluid">

	<h1 class="h3 mb-0 text-gray-800">Program Book</h1>
	
	<div class="row mt-4">
		<div class="col-lg-12">
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">프로그램 편집</h6>
				</div>
				<div class="table-responsive" >
					<div class="card-body">
						<div class="d-flex flex-row align-items-center justify-content-start">
							<form class="form-inline mr-auto w-100 navbar-search" onsubmit="return false;">
								<div class="input-group mr-3">
									<select class="form-control" id="searchField1" name="searchField1">
										<option value="" selected>센터 선택</option>
										<c:forEach var="centerList" items="${centerList}" varStatus="status" >
											<option value="${centerList.centerSeq }">${centerList.centerName }</option>
										</c:forEach>
									</select>
								</div>
								<div class="input-group mr-3">
									<select class="form-control" id="searchField2" name="searchField2">
										<option value="" selected>반 선택</option>
										<c:forEach var="classList" items="${classList}" varStatus="status" >
											<option value="${classList.classSeq }">${classList.className }</option>
										</c:forEach>
									</select>
								</div>
								<div class="input-group mr-3">
									<input type="text" id="searchText1" name="searchText1" onkeyup="enterkey();" class="form-control bg-light border-0 small" placeholder="검색어 입력" aria-label="Search" aria-describedby="basic-addon2">
									<div class="input-group-append">
										<button class="btn btn-primary" type="button" onclick="$.goSearch();">
											<i class="fas fa-search fa-sm"></i>
										</button>
									</div>
								</div>
							</form>	
						</div>
						<div class="table-responsive">
							<table class="table" id="accordion">
								<colgroup>
									<col width="5%" />
									<col width="15%" />
									<col width="15%" />
									<col width="50%" />
									<col width="15%" />
								</colgroup>
								<thead>
									<tr>
										<th scope="col" class="text-center">No</th>
										<th scope="col">센터</th>
										<th scope="col">반</th>
										<th scope="col">아동</th>
										<th scope="col">영역 추가</th>
									</tr>
								</thead>
								<tbody id="studentTableBody">
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal : domainRegist -->
	<div class="modal fade" id="domainRegistModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="domainRegistModalLabel" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="domainRegistModalLabel">발달영역 추가</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="domainForm" name="domainForm" onsubmit="return false;">
						<input type="hidden" id="studentSeq" name="studentSeq"/>
						<div class="form-row">
							<div class="form-group col-md-12">
								<div class="c-row c-cb">
									<label for="" class="col-form-label"><font style="vertical-align: inherit;">발달영역 선택</font></label>
									<div class="custom-control custom-checkbox">
										<input type="checkbox" class="custom-control-input" id="allDomain">
										<label class="custom-control-label" for="allDomain">모든 발당영역 추가</label>
									</div>
								</div>
								<select class="form-control" id="selectDomainSeq" name="selectDomainSeq">
									<option value="0" selected>선택</option>
									<c:forEach var="domainList" items="${domainList}" varStatus="status" >
										<option value="${domainList.domainSeq }">${domainList.domainName }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="domainRegistBtn">등록</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal : managerEdit-->
	<div class="modal fade" id="managerUpdateModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="managerUpdateModalLabel" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
			
				<div class="modal-header">
					<h5 class="modal-title" id="managerUpdateModalLabel">담당자 수정</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<input type="hidden" id="domainSeq" name="domainSeq"/>
				<div class="modal-body">
					<div class="form-row">
						<div class="form-group col-md-12">
							<label for="" class="col-form-label"><font style="vertical-align: inherit;">담당자</font></label>
							<select class="form-control" id="memberSeq" name="memberSeq">
								<c:forEach var="memberList" items="${memberList}" varStatus="status" >
									<option value="${memberList.memberSeq }">${memberList.memberName } (${memberList.memberCp })</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" id="managerUpdateBtn">수정</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/pgb/pgbEditModal.jsp"/>
</div>


<script src="../script/pgb/programBook.js"></script>

