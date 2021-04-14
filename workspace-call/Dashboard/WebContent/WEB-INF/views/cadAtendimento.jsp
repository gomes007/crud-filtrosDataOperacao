
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atendimento</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@ include file="cabecalho.jsp"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<div class="container">

		<div class="row">

			<div class="col-sm-6">

				<h2>CADASTRO DE ATENDIMENTO</h2>

				<form action="atendimento" method="post">

					<div class="mb-3 col-sm-6">
						<label for="operador" class="form-label">Operador</label> 
						<select	class="form-select" id="operador" name="operador">
							<c:forEach var="operador" items="${listaOperadores}">
								<option value="${operador.id}">${operador.nome}</option>
							</c:forEach>
						</select>
					</div>


					<div class="mb-3 col-sm-4">
						<label for="chamadas" class="form-label">Chamadas atendidas</label> 
						<input type="number" class="form-control" id="chamadas"	name="chamadas">
					</div>

					<div class="mb-3 col-sm-3">
						<label for="tma" class="form-label">TMA</label> <input
							type="number" class="form-control" id="tma" name="tma">
					</div>


					<div class="mb-3 col-sm-3">
						<label for="shortc" class="form-label">ShortCall</label> <input
							type="number" class="form-control" id="shortc" name="shortc">
					</div>


					<div class="mb-3 col-sm-5">
						<label for="data" class="form-label">Data</label> <input
							type="date" class="form-control" id="data" name="data">
					</div>



					<div class="mb-3 col-sm-4">
						<label for="servico" class="form-label">Servico atendido</label> 
						<select class="form-select" id="operador" name="servico">
						
							<c:forEach var="servico" items="${listaServicos}">
								<option value="${servico.tipo}">${servico.tipo}</option>
							</c:forEach>
							
						</select>
					</div>


					<div class="mb-3">
						<button type="submit" class="btn btn-primary">Incluir Chamada</button>
					</div>

					<div class="mb-3">${mensagem}</div>


				</form>


			</div>
		</div>



	</div>




</body>
</html>