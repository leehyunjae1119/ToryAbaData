<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade bd-example-modal-lg" id="reportModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="c-modal-header">
				<div id="navbarNav">
					<ul class="tablist">
						<li class="tablist-item active" id="monthlyReport">
							<a href="javascript:void(0);">
								<span class="h5">Monthly Report</span>
							</a>
						</li>
						<li class="tablist-item" id="quarterlyReport">
							<a href="javascript:void(0);">
								<span class="h5">Quarterly Report</span>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="modal-body">
				<input type="hidden" id="printFlag" value="monthlyReportPage">
				<div id="monthlyReportPage">
					<div class="report-title">
						<span>월간 보고서</span>
					</div>
					<div class="report-info m-5">
						<div>
							<ul>
								<li><span class="span-width">이름</span> : <input class="reportName clear-input" type="text"></li>
								<li><span class="span-width">생년월일</span> : <span class="reportBirth"></span></li>
								<li><span class="span-width">프로그램 기간</span> : <span class="reportProgramDt"></span></li>
							</ul>
						</div>
						<div style="text-align: left;">
							<span class="reportRegDt"></span>
							<hr class="sidebar-divider d-md-block">
							<div class="c-row c-cb">
								<span class="white-space-nowrap">작성자 : </span>
								<input class="reportRegName clear-input" type="text" style="width: 9rem;">
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
						<span>분기 보고서</span>
					</div>
					<div class="report-info m-5">
						<div>
							<ul>
								<li><span class="span-width">이름</span> : <input class="reportName clear-input" type="text"></li>
								<li><span class="span-width">생년월일</span> : <span class="reportBirth"></span></li>
								<li><span class="span-width">프로그램 기간</span> : <span class="reportProgramDt"></span></li>
							</ul>
						</div>
						<div style="text-align: left;">
							<span class="reportRegDt"></span>
							<hr class="sidebar-divider d-md-block">
							<div class="c-row c-cb">
								<span class="white-space-nowrap">작성자 : </span>
								<input class="reportRegName clear-input" type="text" style="width: 9rem;">
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
							<tbody id="reportTableBody2">
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" onclick="$.printReport();">인쇄</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>

<script src="../script/dct/dctReport.js"></script>
<script src="../js/printThis/printThis.js"></script>
