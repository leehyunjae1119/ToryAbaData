<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<link href="../js/bootstrap4-toggle/css/bootstrap4-toggle.min.css" rel="stylesheet">  
<script src="../js/bootstrap4-toggle/js/bootstrap4-toggle.min.js"></script>

<div class="container-fluid">

	<h1 class="h3 mb-0 text-gray-800 mb-4">My Page</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">나의 정보</h6>
		</div>
		<div class="card-body">
			<input type="hidden" id="memberSeq" value="${result.memberSeq }" >
			<table class="table">
				<thead>
				</thead>
				<tbody>
					<tr>
						<th>ID</th>
						<td><input type="text" id="memberId" class="form-control" value="${result.memberId }" readonly="readonly"></td>
					</tr>
					<tr>
						<th>PW</th>
						<td><input type="password" id="memberPw" class="form-control" placeholder="입력후 저장 시 비밀번호가 변경됩니다."></td>
					</tr>
					<tr>
						<th>Name</th>
						<td><input type="text" id="memberName" class="form-control" value="${result.memberName }"></td>
					</tr>
					<tr>
						<th>Email</th>
						<td><input type="email" id="memberEmail" class="form-control" value="${result.memberEmail }"></td>
					</tr>
					<tr>
						<th>Tel</th>
						<td><input type="text" id="memberCp" class="form-control" value="${result.memberCp }"></td>
					</tr>
				</tbody>
			</table>
			
			<div class="c-row c-cr">
				<button type="button" class="btn btn-primary" id="saveProfile">저장</button>
			</div>
		</div>
	</div>
</div>



<script src="../script/mbr/mbrMypage.js"></script>

