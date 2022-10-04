<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div class="container-fluid">
	
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
	</div>
	
	<div class="row">
		<!-- Earnings (Monthly) Card Example -->	
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-primary shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
								Scheduled daily</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">3 / 7</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-calendar fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Earnings (Monthly) Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-success shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-success text-uppercase mb-1">
								Completed daily</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">89건</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Earnings (Monthly) Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-info shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-info text-uppercase mb-1">Today Tasks
							</div>
							<div class="row no-gutters align-items-center">
								<div class="col-auto">
									<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">50%</div>
								</div>
								<div class="col">
									<div class="progress progress-sm mr-2">
										<div class="progress-bar bg-info" role="progressbar"
											style="width: 50%" aria-valuenow="50" aria-valuemin="0"
											aria-valuemax="100"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Pending Requests Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-warning shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
								Notice</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">18건</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-comments fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">

		<!-- Content Column -->
		<div class="col-lg-7 mb-4">

			<!-- Project Card Example -->
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">Progress by child</h6>	
				</div>
				<div class="card-body">
					<h4 class="small font-weight-bold">이순신 <span
							class="float-right">20%</span></h4>
					<div class="progress mb-4">
						<div class="progress-bar bg-danger" role="progressbar" style="width: 20%"
							aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
					</div>
					<h4 class="small font-weight-bold">세종대왕 <span
							class="float-right">40%</span></h4>
					<div class="progress mb-4">
						<div class="progress-bar bg-warning" role="progressbar" style="width: 40%"
							aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
					</div>
					<h4 class="small font-weight-bold">이현재 <span
							class="float-right">60%</span></h4>
					<div class="progress mb-4">
						<div class="progress-bar" role="progressbar" style="width: 60%"
							aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
					</div>
					<h4 class="small font-weight-bold">이종오 <span
							class="float-right">80%</span></h4>
					<div class="progress mb-4">
						<div class="progress-bar bg-info" role="progressbar" style="width: 80%"
							aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
					</div>
					<h4 class="small font-weight-bold">김선혜 <span
							class="float-right">Complete!</span></h4>
					<div class="progress">
						<div class="progress-bar bg-success" role="progressbar" style="width: 100%"
							aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- Pie Chart -->
		<div class="col-xl-4 col-lg-5">
			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div
					class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h6 class="m-0 font-weight-bold text-primary">Today Tasks Rate</h6>
					<div class="dropdown no-arrow">
						<a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
						</a>
						<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
							aria-labelledby="dropdownMenuLink">
							<div class="dropdown-header">Dropdown Header:</div>
							<a class="dropdown-item" href="#">Action</a>
							<a class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div>
					</div>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<div class="chart-pie pt-4 pb-2">
						<canvas id="myPieChart"></canvas>
					</div>
					<div class="mt-4 text-center small">
						<span class="mr-2">
							<i class="fas fa-circle text-primary"></i> 이한국
						</span>
						<span class="mr-2">
							<i class="fas fa-circle text-success"></i> 김미래
						</span>
						<span class="mr-2">
							<i class="fas fa-circle text-info"></i> 박은행
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Content Row -->
	<div class="row">
		<!-- Area Chart -->
		<div class="col-xl-8 col-lg-7">
			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div
					class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h6 class="m-0 font-weight-bold text-primary">Tasks Overview</h6>
					<div class="dropdown no-arrow">
						<a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
						</a>
						<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
							aria-labelledby="dropdownMenuLink">
							<div class="dropdown-header">Dropdown Header:</div>
							<a class="dropdown-item" href="#">Action</a>
							<a class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div>
					</div>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<div class="chart-area">
						<canvas id="myAreaChart"></canvas>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	<!-- Page level plugins -->
	<script src="../js/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="../js/demo/chart-area-demo.js"></script>
	<script src="../js/demo/chart-pie-demo.js"></script>