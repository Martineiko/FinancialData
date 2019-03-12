<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<html lang="es">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="title" content="Vass IT">

<title>Financial Data</title>

<link rel="shortcut icon" type="image/x-icon"
	href="resources/images/favicon.ico">

<!-- CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="resources/css/font-awesome.min.css" />
<link rel="stylesheet" href="resources/fonts/fonts.googleapis.com.css" />
<link rel="stylesheet" href="resources/css/ace.min.css" />
<link rel="stylesheet" href="resources/css/ace-part2.min.css" />
<link rel="stylesheet" href="resources/css/ace-ie.min.css" />
<link rel="stylesheet" href="resources/css/jquery-ui.custom.min.css" />

<link href='https://fonts.googleapis.com/css?family=Roboto+Condensed'
	rel='stylesheet' type='text/css'>

<!-- Alerts -->
<link rel="stylesheet" type="text/css"
	href="resources/css/sweetalert/sweetalert.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/sweetalert/twitter.css">

<!-- Estilo  -->
<link rel="stylesheet" href="resources/css/General/general.css" />


</head>

<body>
	<div id="navbar" class="navbar navbar-default"
		style="border-bottom: 4px solid #1D3B6E;">

		<!-- TILES HEADER -->

		<div class="col-md-12" style="border-bottom: 7px solid #fff;">
			<div class="navbar-header pull-left">
				<div class="navbar-header pull-left">
					<a href="financial.html" class="navbar-brand"> Financial Data</a>
				</div>
			</div>
		</div>
	</div>
	<div class="main-container" id="main-container">

		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div id="bodyContainer" class="contenedorLogin">							
								<canvas id="myChart" width="500px" height="500px"></canvas> 
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="jumbotron">
								 <p id="txtJson"></p>
							</div>							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.bundle.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/chartjs-plugin-zoom/0.6.6/chartjs-plugin-zoom.min.js"></script>
	<script src="resources/js/jquery.2.1.1.min.js"></script>
	<script src="resources/js/html5shiv.min.js"></script>
	<script src="resources/js/respond.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/ace.min.js"></script>
	<script src="resources/js/ace-elements.min.js"></script>
	<script src="resources/js/ace-extra.min.js"></script>
	<script src="resources/js/jquery-ui.custom.min.js"></script>
	<script src="resources/css/sweetalert/sweetalert.min.js"></script>
	<script src="resources/Scripts/financial.js"></script>

</body>
</html>