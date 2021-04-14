<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<%@ include file="cabecalho.jsp"%>
	
	<div class="container">

			<div>
				<label>Data Início:</label>
				<input type="date" name="dinicio" id="dinicio">

				<label>Data Fim:</label>
				<input type="date" name="dfim" id="dfim">
				
				<button type="button" id="btnMostrar">Mostrar</button>
				
				<div class="container">
					<canvas id="myChart"></canvas>
				</div>				
			</div>		

	</div>
	
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js"></script>
    
	<script>
		data = [];
		labels = [];
	
		function renderChart(data, labels) {
		    var ctx = document.getElementById("myChart").getContext('2d');
		    var myChart = new Chart(ctx, {
		        type: 'bar',
		        data: {
		            labels: labels,
		            datasets: [{
		                    label: 'Esta semana',
		                    data: data,
		                },

		            ]
		        },
		    });
		}
		
		$("#btnMostrar").click(function(){
			var resposta = [];
           
			fetch('http://localhost:8080/DashBoard/wschamadas/' + $("#dinicio").val() + '/df/' + $("#dfim").val())
				.then(res => {
					let x = res.json();
					return x;
				})
				.then(valor => {
					resposta = valor;
					$.each(resposta, function (k, v) {
                        //console.log(v.rua + " - " + v.cidade);
                        labels.push(v.data);
                        data.push(v.chamadas);
                    });
					
					renderChart(data, labels);
				});
			
			
			
// 			$.AJAX({
//                 DATATYPE: 'JSON',
//                 URL: 'HTTP://LOCALHOST:8080/DASHBOARD/WSCHAMADAS/' + $("#DINICIO").VAL() + '/DF/' + $("#DFIM").VAL(),
//                // URL: 'HTTP://LOCALHOST:8080/DASHBOARD/WSCHAMADAS/2021-01-18/DF/2021-01-19',
//                 METHOD: 'GET',
//                 SUCCESS: FUNCTION (RESPOSTA) {
//                     $.EACH(RESPOSTA, FUNCTION (K, V) {
//                         //CONSOLE.LOG(V.RUA + " - " + V.CIDADE);
//                         LABELS.PUSH(V.DATA);
//                         DATA.PUSH(V.CHAMADAS);
//                     });
                    
//                     RENDERCHART(DATA, LABELS);
//                 },
//                 ERROR: FUNCTION (ERRO) {
//                     CONSOLE.LOG('ERRO: ' + ERRO.RESPONSETEXT);
//                 }
//             });
		});
	
	</script>    
</body>
</html>