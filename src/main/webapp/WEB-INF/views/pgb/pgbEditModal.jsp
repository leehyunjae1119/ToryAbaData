<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="../js/bootstrap4-toggle/css/bootstrap4-toggle.min.css" rel="stylesheet">	
<script src="../js/bootstrap4-toggle/js/bootstrap4-toggle.min.js"></script>

<!-- Button trigger modal -->
<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong"> -->
<!--	 Launch demo modal -->
<!-- </button> -->

<!-- Modal -->
<div class="modal fade" id="pgbEditModal" data-backdrop="static" data-keyboard="false" role="dialog" aria-labelledby="pgbEditModalTitle" aria-hidden="true">
	<div class="modal-dialog c-modal-fullscreen" role="document">
		<div class="modal-content c-modal-content">
			<div class="modal-header bg-dark">
				<h5 class="modal-title text-white" id="pgbEditModalTitle"><span id="mt_center"></span> > <span id="mt_class"></span> > <span id="mt_student"></span></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body p-0 bg-gray-100">
				<div class="d-flex align-items-center bg-gray-300">
					<label class="item-label">발달영역 ITEM</label>
					<div class="d-flex flex-nowrap align-items-center contents-over-scroll" id="dtoBtnGroup">
					</div>
				</div>
				<div class="c-row bg-gray-200">
					<label class="item-label">LTO ITEM</label>
					<button type="button" class="btn btn-outline-purple btn-sm m-2" onclick="$.openLtoRegistModal(0);">
						<i class="fas fa-plus"></i>
						<span>추가</span>
					</button>
					<div class="d-flex flex-nowrap align-items-center contents-over-scroll" id="ltoBtnGroup">
					</div>
				</div>
				<div class="bg-gray-200 p-3 collapse" id="ltoCard">
					<div class="card card-body color-black">
						<div class="c-row c-cb">
							<div class="d-flex align-items-center">
								<h6 class="item-label">LTO Details</h6>
								<button type="button" class="btn btn-outline-dark btn-sm mr-3" onclick="$.openLtoRegistModal(1);">
									<i class="fas fa-edit" style="font-size: 1.275rem;"></i>
								</button>
								<button type="button" class="btn btn-outline-dark btn-sm mr-3" onclick="$.collapseLtoChart();">
									<i class="fas fa-chart-line" style="font-size: 1.275rem;"></i>
								</button>
							</div>
							<a href="javascript:void(0);" id="closeLtoCardBtn"><i class="fas fa-caret-up mr-2"></i>접기</a>
						</div>
						<div class="c-row c-cb">
							<input type="hidden" id="ltoSeq" value="0"/>
							<div class="m-3">
								<p class="m-0 h2"><span id="labelLtoName"></span></p>
<!-- 								<p class="m-0">LTO 내용 : <span id="labelLtoContents"></span></p> -->
							</div>
							<div class="">
								<div class="btn-group btn-group-toggle btn-group-lg" data-toggle="buttons">
									<label class="btn btn-outline-primary" name="labelLtoStatus" id="labelLtoStatus_ING">
										<input type="radio" name="btnLtoStatus" id="btnLtoStatus_ING" value="ING" autocomplete="off"> 진행중
									</label>
									<label class="btn btn-outline-danger" name="labelLtoStatus" id="labelLtoStatus_STP">
										<input type="radio" name="btnLtoStatus" id="btnLtoStatus_STP" value="STP" autocomplete="off"> 중지
									</label>
									<label class="btn btn-outline-success" name="labelLtoStatus" id="labelLtoStatus_CMP">
										<input type="radio" name="btnLtoStatus" id="btnLtoStatus_CMP" value="CMP" autocomplete="off"> 완료
									</label>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="c-row bg-gray-100">
					<label class="item-label">STO ITEM</label>
					<button type="button" class="btn btn-outline-purple btn-sm m-2" onclick="$.openStoRegistModal(0);">
						<i class="fas fa-plus"></i>
						<span>추가</span>
					</button>
					<div class="d-flex flex-nowrap align-items-center contents-over-scroll" id="stoBtnGroup">
					</div>
				</div>
				<div class="bg-gray-100 p-3 collapse" id="stoCard">
					<div class="card card-body color-black">
						<div class="c-row c-cb">
							<div class="d-flex align-items-center">
								<h6 class="item-label">STO Details</h6>
								<button type="button" class="btn btn-outline-dark btn-sm mr-3" onclick="$.openStoRegistModal(1);">
									<i class="fas fa-edit" style="font-size: 1.275rem;"></i>
								</button>
								<div class="btn-group btn-group-toggle btn-group-sm" data-toggle="buttons">
									<label class="btn btn-outline-primary active" name="labelStoStatus" id="labelStoStatus_ING">
										<input type="radio" name="btnStoStatus" id="btnStoStatus_ING" value="ING" autocomplete="off" checked> 진행중
									</label>
									<label class="btn btn-outline-success" name="labelStoStatus" id="labelStoStatus_CMP">
										<input type="radio" name="btnStoStatus" id="btnStoStatus_CMP" value="CMP" autocomplete="off"> 준거 도달
									</label>
									<label class="btn btn-outline-danger" name="labelStoStatus" id="labelStoStatus_STP">
										<input type="radio" name="btnStoStatus" id="btnStoStatus_STP" value="STP" autocomplete="off"> 중지
									</label>
								</div>
							</div>
							<a href="javascript:void(0);" id="closeStoCardBtn"><i class="fas fa-caret-up mr-2"></i>접기</a>
						</div>
						<div class="row">
							<div class="col-lg-7 p-3">
								<div class="table-border">
									<table class="table table-bordered m-0">
										<input type="hidden" id="stoSeq" value="0"/>
										<input type="hidden" id="pointRound" value="1"/>
										<colgroup>
											<col width="20%" />
											<col width="80%" />
										</colgroup>
										<tbody>
											<tr>
												<th scope="row">STO 이름</th>
												<td><span id="labelStoName"></span></td>
											</tr>
											<tr>
												<th scope="row">STO 내용</th>
												<td><span id="labelStoContents"></span></td>
											</tr>
											<tr>
												<th scope="row">시도 수</th>
												<td><span id="labelStoTrialCnt"></span> 시도</td>
											</tr>
											<tr>
												<th scope="row">준거도달 기준</th>
												<td><span id="labelStoArrStdPst"></span>%</td>
											</tr>
											<tr>
												<th scope="row">촉구방법</th>
												<td><span id="labelStoUrgeContents"></span></td>
											</tr>
											<tr>
												<th scope="row">강화스케줄</th>
												<td><span id="labelStoEnforceContents"></span></td>
											</tr>
											<tr>
												<th scope="row">메모</th>
												<td><span id="labelStoMemoContents"></span></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div class="col-lg-5 p-3">
								<div class="point-border" id="pointBorder">
								</div>
								<div class="btn-group point-btn-group" role="group">
									<button type="button" class="btn btn-primary point-btn-group-item2" name="roundAddBtn" onclick="$.addPointRound();" style="display:none;">회차 추가</button>
									<button type="button" class="btn btn-outline-success point-btn-group-item" name="pointAddBtn" onclick="$.insertPoint('+');"><i class="fas fa-plus"></i></button>
									<button type="button" class="btn btn-outline-warning point-btn-group-item" name="pointAddBtn" onclick="$.insertPoint('P');"><i class="fas fa-p"></i></button>
									<button type="button" class="btn btn-outline-danger point-btn-group-item" name="pointAddBtn" onclick="$.insertPoint('-');"><i class="fas fa-minus"></i></button>
									<button type="button" class="btn btn-outline-secondary point-btn-group-item" onclick="$.deletePoint();">삭제</button>
<!-- 									<button type="button" class="btn btn-outline-primary point-btn-group-item">완료</button> -->
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="bg-gray-100 p-3 collapse" id="ltoChart">
					<div class="card card-body color-black">
						<div class="c-row">
<!-- 						왼쪽 Y축 30 나머지 50 -->
							<div class="">
								<canvas id="myChart" width="600" height="400"></canvas>
							</div>
						</div>
					</div>
				</div>
			</div>
				
		</div>
	</div>
</div>

<!-- LTO 등록 수정 모달 -->
<div class="modal c-bg-fade" id="LTORegistModal" >
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="LTORegistModalLabel"></h5>
<!-- 				<button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
				<button type="button" class="close" onclick="$.customModal('LTORegistModal', 'hide');">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="LTOForm" name="LTOForm" onsubmit="return false;">
					<input type="hidden" name="ltoSeq" value="0">
					<input type="hidden" name="domainSeq" value="0">
					<div class="form-row">
						<div class="form-group col-md-12">
							<label for="ltoName" class="col-form-label"><font style="vertical-align: inherit;">LTO 이름</font></label>
							<input type="text" class="form-control" name="ltoName">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-12">
							<label for="ltoContents" class="col-form-label"><font style="vertical-align: inherit;">LTO 내용</font></label>
							<input type="text" class="form-control" name="ltoContents">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="LTOSaveBtn" onclick="$.registLto(0)" style="display:none;">등록</button>
				<button type="button" class="btn btn-success" id="LTOUpdateBtn" onclick="$.registLto(1)" style="display:none;">수정</button>
				<button type="button" class="btn btn-secondary" onclick="$.customModal('LTORegistModal', 'hide');">취소</button>
			</div>
		</div>
	</div>
</div>

<!-- STO 등록, 수정 모달 -->
<div class="modal c-bg-fade" id="STORegistModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="STORegistModalLabel"></h5>
<!-- 				<button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
				<button type="button" class="close" onclick="$.customModal('STORegistModal', 'hide');">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="STOForm" name="STOForm" onsubmit="return false;">
					<input type="hidden" name="stoSeq" value="0">
					<input type="hidden" name="ltoSeq" value="0">
					<div class="form-row">
						<div class="form-group col-md-12">
							<label for="stoName" class="col-form-label"><font style="vertical-align: inherit;">STO 이름</font></label>
							<select class="form-control" name="stoNameTmpl">
								<option value="">직접입력</option>
							</select>
							<input type="text" class="form-control" name="stoName" style="display:none;">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="stoArrStdPst" class="col-form-label"><font style="vertical-align: inherit;">도달 기준 비율</font></label>
							<select class="form-control" name="stoArrStdPst">
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
							<label for="stoTrialCnt" class="col-form-label"><font style="vertical-align: inherit;">시도 수</font></label>
							<input type="number" class="form-control" name="stoTrialCnt">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-12">
							<label for="stoContents" class="col-form-label"><font style="vertical-align: inherit;">STO 내용</font></label>
							<input type="text" class="form-control" name="stoContents">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-12">
							<label for="stoUrgeContents" class="col-form-label"><font style="vertical-align: inherit;">촉구방법</font></label>
							<input type="text" class="form-control" name="stoUrgeContents">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-12">
							<label for="stoEnforceContents" class="col-form-label"><font style="vertical-align: inherit;">강화스케줄</font></label>
							<input type="text" class="form-control" name="stoEnforceContents">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-12">
							<label for="stoMemoContents" class="col-form-label"><font style="vertical-align: inherit;">메모</font></label>
							<input type="text" class="form-control" name="stoMemoContents">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="STOSaveBtn" onclick="$.registSto(0)" >등록</button>
				<button type="button" class="btn btn-success" id="STOUpdateBtn" onclick="$.registSto(1)" >수정</button>
				<button type="button" class="btn btn-secondary" onclick="$.customModal('STORegistModal', 'hide');">취소</button>
			</div>
		</div>
	</div>
</div>

<script src="../script/pgb/pgbEditModal.js"></script>
<script src="../script/pgb/pgbPointControl.js"></script>
<script src="../script/pgb/pgbChartControl.js"></script>
