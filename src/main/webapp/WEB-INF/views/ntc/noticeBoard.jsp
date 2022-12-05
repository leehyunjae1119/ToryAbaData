<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<link href="../js/bootstrap4-toggle/css/bootstrap4-toggle.min.css" rel="stylesheet">	
<script src="../js/bootstrap4-toggle/js/bootstrap4-toggle.min.js"></script>

<div class="container-fluid">
	<input type="hidden" id="pageNum" value="1"/>
	<input type="hidden" id="noticeSeq" value="0"/>

	<h1 class="h3 mb-0 text-gray-800 mb-4">Notice</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
		</div>
		<div class="card-body">
			<div class="d-flex flex-row align-items-center justify-content-between mb-4">
				<form class="form-inline mr-auto w-100 navbar-search m-0" onsubmit="return false;">
					<div class="input-group mr-3">
						<input type="text" id="searchText1" name="searchText1" onkeyup="enterkey();" class="form-control bg-light border-0 small" placeholder="검색어 입력" aria-label="Search" aria-describedby="basic-addon2">
						<div class="input-group-append">
							<button class="btn btn-primary" type="button" onclick="$.goSearch(1);">
								<i class="fas fa-search fa-sm"></i>
							</button>
						</div>
					</div>
				</form>	
				<button type="button" class="btn btn-outline-purple m-0" onclick="$.onclickRegBtn();" data-auth="level1">
					<i class="fas fa-plus"></i>
					<span>등록</span>
				</button>
			</div>
			<div class="table-responsive">
				<table class="table c-table-hover">
					<colgroup>
						<col width="10%" />
						<col width="50%" />
						<col width="20%" />
						<col width="20%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col" class="text-center">No</th>
							<th scope="col">Title</th>
							<th scope="col">Writer</th>
							<th scope="col">Date</th>
						</tr>
					</thead>	
					<tbody id="noticeTableBody">
					</tbody>
				</table>
			</div>
			<nav aria-label="Page navigation" id="ntcPaging">
			</nav>
		</div>
	</div>
</div>

<div class="modal fade bd-example-modal-lg" id="noticeDetailModal" tabindex="-1" role="dialog" aria-labelledby="noticeDetailModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header bg-secondary">
				<h5 class="modal-title text-white" id="noticeDetailModalLabel">Notice Detail</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="c-row c-cb ml-4 mr-4">
					<p class="h4 m-0">제목 : 
						<span id="detailTitle"></span>
						<input type="text" class="c-form-control" id="inputTitle" style="display:none;" />
					</p>
					<div>
						<p class="m-0 small">작성자 : <span id="detailRegName"></span></p>
						<p class="m-0 small">작성일 : <span id="detailRegDt"></span></p>
					</div>
				</div>
				<hr class="sidebar-divider d-none d-md-block">
				<div class="m-4" style="min-height: 300px">
					<p id="detailContents"></p>
					<textarea class="form-control" id="inputContents" rows="20" style="display:none;" ></textarea>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success" id="noticeUpdateBtn" style="display:none;">수정</button>
				<button type="button" class="btn btn-danger" id="noticeDeleteBtn" style="display:none;">삭제</button>
				
				<button type="button" class="btn btn-primary" id="noticeSaveBtn" style="display:none;">저장</button>
				<button type="button" class="btn btn-secondary" id="noticeCancelBtn" style="display:none;">취소</button>
				
				<button type="button" class="btn btn-secondary" id="noticeCloseBtn"  data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>


<script src="../script/ntc/ntcMain.js"></script>

