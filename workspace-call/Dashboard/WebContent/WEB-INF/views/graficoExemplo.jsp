
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@ include file="cabecalho.jsp"%>

	<div class="container">
		<button id="renderBtn">Render</button>
		<button id="changeBtn">Change</button>
		<div class="container">
			<canvas id="myChart"></canvas>
		</div>
	</div>



 <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js"></script>
 <script>
 data = [18000, 12000, 20000, 15000, 10000, 23000, 20000];
 labels = ["domingo", "segunda", "terça", "quarta", "quinta", "sexta", "sábado"];

 data2 = [20000, 14000, 12000, 15000, 18000, 19000, 22000];



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
                 {
                     label: 'Semana seguinte',
                     data: data2,
                 },
             ]
         },
     });
 }

 $("#renderBtn").click(
     function () {
         //data = [20000, 14000, 12000, 15000, 18000, 19000, 22000];
         //labels = ["domingo", "segunda", "terça", "quarta", "quinta", "sexta", "sábado"];
         renderChart(data, labels);
     }
 );

 $("#changeBtn").click(
     function () {
         data[4] = 12000;
         renderChart(data, labels);
     }
 );
 </script>
</body>
</html>