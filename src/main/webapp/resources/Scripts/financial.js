$(document).ready(function() {
	$("#reporteVentiApp").hide();
	FinancialData();
});

function FinancialData() {

	$.ajax({
		url : "consultaAPI.html",
		data : JSON.stringify({}),
		method : "POST",
		contentType : "application/json; charset=UTF-8;",
		success : function(data) {
			document.getElementById("txtJson").innerHTML = "Response of API: "+data;
			datos = JSON.parse(data);
			datosTime = datos["Time Series (5min)"];

			var label = [];
			var open = [];
			var high = [];
			var low = [];
			var close = [];
			for (key in datosTime) {
				label.push(key);
				open.push(datosTime[key]["1. open"]);
				high.push(datosTime[key]["2. high"]);
				low.push(datosTime[key]["3. low"]);
				close.push(datosTime[key]["4. close"]);
			}
			// llenaGrafica(data);
			var ctx = document.getElementById('myChart').getContext('2d');
			var chart = new Chart(ctx, {
				// The type of chart we want to create
				type : 'line',

				// The data for our dataset
				data : {
					labels : label,
					datasets : [ {
						label : "Low",
						backgroundColor : 'rgb(225, 22, 22)',
						borderColor : 'rgb(225, 22, 22)',
						fill : false,
						data : low
					}, {
						label : "Close",
						backgroundColor : 'rgb(243, 255, 51)',
						borderColor : 'rgb(243, 255, 51)',
						fill : false,
						data : close
					}, {
						label : "Open",
						backgroundColor : 'rgb(22, 36, 225)',
						borderColor : 'rgb(22, 36, 225)',
						data : open,
						fill : false
					}, {
						label : "High",
						backgroundColor : 'rgb(145, 255, 51)',
						borderColor : 'rgb(145, 255, 51)',
						data : high,
						fill : false
					} ]
				},

				// Configuration options go here
				options : {
					responsive : true,
					maintainAspectRatio: false,
					pan : {
						enabled : true,
						mode : 'xy'
					},
					zoom : {
						enabled : true,
						mode : 'xy'
					}
				}
			});
		},
		error : function(e) {
			swal('Error', error.responseText, 'error');
		}
	});
}

function llenaGrafica(data) {
	var d1 = [];
	for (var i = 0; i < Math.PI * 2; i += 0.5) {
		d1.push([ i, Math.sin(i) ]);
	}

	var d2 = [];
	for (var i = 0; i < Math.PI * 2; i += 0.5) {
		d2.push([ i, Math.cos(i) ]);
	}

	var d3 = [];
	for (var i = 0; i < Math.PI * 2; i += 0.2) {
		d3.push([ i, Math.tan(i) ]);
	}

	var sales_charts = $('#sales-charts').css({
		'width' : '100%',
		'height' : '220px'
	});
	$.plot("#sales-charts", [ {
		label : "Open",
		data : d1
	}, {
		label : "Hosting",
		data : d2
	}, {
		label : "Services",
		data : d3
	} ], {
		hoverable : true,
		shadowSize : 0,
		series : {
			lines : {
				show : true
			},
			points : {
				show : true
			}
		},
		xaxis : {
			tickLength : 0
		},
		yaxis : {
			ticks : 10,
			min : -2,
			max : 2,
			tickDecimals : 3
		},
		grid : {
			backgroundColor : {
				colors : [ "#fff", "#fff" ]
			},
			borderWidth : 1,
			borderColor : '#555'
		}
	});

}

function inicializaTablaTareasStatus(data) {
	$("#tblListaTareasActualizaciones").DataTable().destroy();
	$("#tblListaTareasActualizaciones").DataTable({
		dom : crearDom(2),
		language : crearLenguaje(),
		data : data,
		columns : crearColumnasTareasStatus(),
		initComplete : function() {
			$('#tblListaTareasActualizaciones').css('width', '');
		}
	});
}

function crearColumnasTareasStatus() {
	return [ {
		data : 'NOMBRE'
	}, {
		data : 'JOBID'
	}, {
		data : 'FECHA'
	} ];
}