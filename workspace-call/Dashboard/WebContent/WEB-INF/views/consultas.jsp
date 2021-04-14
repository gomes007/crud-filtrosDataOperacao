
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Portal Operacional</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" ></script>
</head>
<body>
<%@ include file="cabecalho.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	<div class="container">
		<h3>busca por atendimentos</h3>
		
		<form action="consulta" method = "get">
		
			<div class="row">
			
			<div class="col-sm-4">			
				<div class="mb-3">
					<label for="inicio" class="form-label">data inicio</label> 
					<input type="date" class="form-control" id="inicio" name="inicio">
				</div>								
			</div>
			
			<div class="col-sm-4">			
				<div class="mb-3">
					<label for="fim" class="form-label">data fim</label> 
					<input type="date" class="form-control" id="fim" name="fim">
				</div>								
			</div>
			
			<div class="col-sm-4">			
			<div class="mb-3">
				<label for="fim" class="form-label">Serviço</label> 
				<select class="form-select" id="servico" name="servico">
					<option>TODOS</option>
					<option>PRE</option>
					<option>POS</option>
					<option>RET</option>
				</select>
				</div>			
			</div>
						
			<div class="mb-3">
				<input type="submit" class="btn btn-info" value="buscar">
			</div>			
			
			</div>
		
		<table class="table">
			<thead>
				<tr>
					<th scope="col">NOME OPERADOR</th>
					<th scope="col">NOME SUPERVISOR</th>
					<th scope="col">CHAMADAS</th>
					<th scope="col">TMA</th>
					<th scope="col">SHORT CALL</th>
					<th scope="col">DATA ATENDIMENTO</th>
					<th scope="col">SERVICO ATENDIDO</th>
				</tr>
			</thead>
						
			<tbody>
			<c:forEach var="chamada" items="${atendimentos}">
				<tr>
					<td>${chamada.nomeOperador}</td>
					<td>${chamada.nomeSupervisor}</td>
					<td>${chamada.chamadas}</td>
					<td>${chamada.tma}</td>
					<td>${chamada.shortc}</td>
					<td>${chamada.data}</td>
					<td>${chamada.servico}</td>
				</tr>
			</c:forEach>									
			</tbody>
			
		</table>
		
		
		</form>
		
		
	</div>
	

</body>
</html>