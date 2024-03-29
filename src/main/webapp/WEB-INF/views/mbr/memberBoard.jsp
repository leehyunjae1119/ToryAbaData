<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<link href="../js/bootstrap4-toggle/css/bootstrap4-toggle.min.css" rel="stylesheet">  
<script src="../js/bootstrap4-toggle/js/bootstrap4-toggle.min.js"></script>

<div class="container-fluid">
	<input type="hidden" id="pageNum" value="1"/>

	<h1 class="h3 mb-0 text-gray-800 mb-4">Member management</h1>
<!-- 	<p class="mb-4">회원 가입 승인 및 계정 권한 설정</p> -->

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">계정 관리</h6>
		</div>
		<div class="card-body">
			<div class="d-flex flex-row align-items-center justify-content-start">
				<form class="form-inline mr-auto w-100 navbar-search" onsubmit="return false;">
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
				<table class="table">
					<colgroup>
						<col width="5%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" data-auth="level1" />
					</colgroup>
					<thead>
<!-- 								번호 아이디 이름 이메일 연락처 권한레벨 승인유무 가입일자 -->
						<tr>
							<th scope="col" class="text-center">No</th>
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Email</th>
							<th scope="col">TEL</th>
							<th scope="col">Level</th>
							<th scope="col">Approval</th>
							<th scope="col" data-auth="level1">PW Reset</th>
						</tr>
					</thead>
					<tbody id="memberTableBody">
					</tbody>
				</table>
			</div>
			<nav aria-label="Page navigation" id="mbrPaging">
			</nav>
		</div>
	</div>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">지점 권한 관리</h6>
		</div>
		<div class="card-body">
			<div class="d-flex flex-row justify-content-start">
				<input type="hidden" value="0" id="centerSeq">
				<div class="col-md-6" style="border-right: 1px solid #f1f1f1;" id="centerCardBoard">
					
				</div>
				<div class="col-md-6" style="border-left: 1px solid #f1f1f1;">
					<div class="form-group mt-2 mb-0">
						<div class="input-group mb-2">
							<select class="custom-select" id="teachList" disabled>
								<option value="0" selected>선택하기...</option>
							</select>
							<div class="input-group-append">
								<button class="btn btn-outline-secondary add-btn" data-value="N" type="button" disabled>추가</button>
							</div>
						</div>
					</div>
					<div class="">
						<ul class="list-group" id="authTeachList">
						</ul>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>


<script src="../script/mbr/mbrMain.js?ver=20240108"></script>

