<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
	<input type="hidden" id="pageNum" value="1"/>
	<input type="hidden" id="studentSeq" value="${studentData.studentSeq }"/>
	<h1 class="h3 mb-0 text-gray-800 mb-4">Video Board</h1>
	<div class="c-row c-cb">
		<p class="mb-2">${studentData.centerName } > ${studentData.className } > ${studentData.studentName } </p>
		<button type="button" class="btn btn-outline-purple m-0" onclick="$.openRegModal();" data-auth="level3">
			<i class="fas fa-plus"></i>
			<span>영상 추가</span>
		</button>
	</div>

	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3" id="videoCardList">
		<div class="col p-3">
		</div>
	</div>
	
	<div id="noDataCard" class="mt-4" style="display:none;">
		<div class="card mb-3 bg-gray-100">
			<div class="card-body">
				등록된 영상이 없습니다.
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="videoRegistModal" tabindex="-1" aria-labelledby="videoRegistModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="videoRegistModalLabel">영상 등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="" name="" onsubmit="return false;">
						<input type="hidden" id="videoSeq" name="videoSeq" value="0">
						<div class="form-group">
							<label for="" class="col-form-label help-tooltip"><font style="vertical-align: inherit;">영상 주소</font><i class="ml-2 far fa-question-circle"></i></label>
							<input type="text" class="form-control" id="videoAddress" name="videoAddress">
						</div>
						<div class="form-group">
							<label for="videoContents" class="col-form-label"><font style="vertical-align: inherit;">영상 내용</font></label>
							<input type="text" class="form-control" id=videoContents name="videoContents">
						</div>
					</form>
					<img class="help-guide" alt="" src="../image/video_guide.png" width="100%" style="display:none;">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="consultingSaveBtn">등록</button>
					<button type="button" class="btn btn-success" id="consultingUpdateBtn">수정</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="videoModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content"  style="height: 65%;">
					<iframe id="youtubeBox" width="100%" height="100%"></iframe>
			</div>
		</div>
	</div>
</div>

<script src="../script/dct/dctVideo.js"></script>

