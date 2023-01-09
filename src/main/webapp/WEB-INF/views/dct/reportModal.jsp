<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="reportDateModal" tabindex="-1" role="dialog" aria-labelledby="reportDateModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="reportDateModalLabel">보고서 날짜 설정</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			
			<div class="modal-body" id="">
				<div class="input-group custom-align-item-center">
					<input type="date" class="form-control" id="startDt" name="startDt" min="1900-01-01" max="9999-12-31">
					<span class="p-2">~</span>
					<input type="date" class="form-control" id="endDt" name="endDt" min="1900-01-01" max="9999-12-31">
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="setReportDateBtn">확인</button>
			</div>
		</div>
	</div>
</div>


<div class="modal fade bd-example-modal-lg" id="reportModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="c-modal-header">
				<div id="navbarNav">
					<ul class="tablist">
						<li class="tablist-item active" id="monthlyReport">
							<a href="javascript:void(0);">
								<span class="h5">주간 보고서</span>
							</a>
						</li>
						<li class="tablist-item" id="quarterlyReport">
							<a href="javascript:void(0);">
								<span class="h5">분기 보고서</span>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="modal-body">
				<input type="hidden" id="printFlag" value="monthlyReportPage">
				<div id="monthlyReportPage">
					<div class="report-title">
						<div class="c-row title">
							<img class="rogo-img" alt="메인로고" src="../image/sidebar_logo.png" id="sidebarLogo" >
							<div>
								<p style="margin-bottom: -10px; font-size: 20px;">토리발달교실</p>
								<p class="m-1">주간 보고서</p>
							</div>
						</div>
					</div>
					<div class="report-info m-5">
						<div>
							<ul>
								<li><span class="span-width">이름</span> : 
									<input class="reportName clear-input" style="display:none;" type="text">
									<span class="reportNameLabel"></span>
								</li>
								<li><span class="span-width">생년월일</span> : 
									<input class="reportBirth clear-input" style="display:none;" type="text">
									<span class="reportBirthLabel"></span>
								</li>
								<li><span class="span-width">프로그램 기간</span> : <span class="reportProgramDt"></span></li>
							</ul>
						</div>
						<div style="text-align: left;">
							<span class="reportRegDt"></span>
							<hr class="sidebar-divider d-md-block">
							<div class="c-row" style="width: 100%;">
								<span class="white-space-nowrap">작성자 : </span>
								<input class="reportRegName clear-input" type="text" style="width: 9rem; display:none;">
								<span class="reportRegNameLabel"></span>
							</div>
						</div>
					</div>
					<div class="report-table m-5">
						<table class="table" style="table-layout: fixed;">
							<colgroup>
								<col width="30%" />
								<col width="70%" />
							</colgroup>
							<tbody id="reportTableBody">
							</tbody>
						</table>
					</div>
				</div>
				<div id="quarterlyReportPage" style="display:none;">
					<div class="report-title">
						<div class="c-row title">
							<img class="rogo-img" alt="메인로고" src="../image/sidebar_logo.png" id="sidebarLogo" >
							<div>
								<p style="margin-bottom: -10px; font-size: 20px;">토리발달교실</p>
								<p class="m-1">분기 보고서</p>
							</div>
						</div>
					</div>
					<div class="report-info m-5">
						<div>
							<ul>
								<li><span class="span-width">이름</span> : 
									<input class="reportName clear-input" style="display:none;" type="text">
									<span class="reportNameLabel"></span>
								</li>
								<li><span class="span-width">생년월일</span> : 
									<input class="reportBirth clear-input" style="display:none;" type="text">
									<span class="reportBirthLabel"></span>
								</li>
								<li><span class="span-width">프로그램 기간</span> : <span class="reportProgramDt"></span></li>
							</ul>
						</div>
						<div style="text-align: left;">
							<span class="reportRegDt"></span>
							<hr class="sidebar-divider d-md-block">
							<div class="c-row" style="width: 100%;">
								<span class="white-space-nowrap">작성자 : </span>
								<input class="reportRegName clear-input" type="text" style="width: 9rem; display:none;">
								<span class="reportRegNameLabel"></span>
							</div>
						</div>
					</div>
					<div class="report-chart">
						<div class="chart-container">
							<canvas id="domainChart2"></canvas>
						</div>
					</div>
					<div class="report-table m-5">
						<table class="table" style="table-layout: fixed;">
							<colgroup>
								<col width="30%" />
								<col width="70%" />
							</colgroup>
							<thead>
								<tr class="tr-vertical-align">
									<th style="background-color: #e5c99f !important;">발달 영역</th>
									<th style="background-color: #e5c99f !important;">현재 수준</th>
								</tr>
							</thead>
							<tbody id="reportTableBody2">
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" onclick="$.downPdf();">PDF로 저장</button>
				<button type="button" class="btn btn-primary" onclick="$.downImg();">JPG로 저장</button>
				<button type="button" class="btn btn-primary" onclick="$.printReport();">인쇄</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>



<script src="../script/dct/dctReport.js"></script>
<script src="../js/printThis/printThis.js"></script>
