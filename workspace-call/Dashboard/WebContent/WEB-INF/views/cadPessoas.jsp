
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@ include file="cabecalho.jsp"%>

	<div class="container">
	
	<div class="row">	
	
	<div class="col-sm-6">
	
	<h2>CADASTRO DE PESSOAS</h2>

		<form action="cadpessoas" method="post">

			<div class="mb-3">
				<label for="nome" class="form-label">Nome</label> <input type="text"
					class="form-control" id="nome" name="nome">
			</div>

			<div class="mb-3">
				<label for="email" class="form-label">Email</label> <input
					type="email" class="form-control" id="email" name="email">
			</div>

			<div class="mb-3">
				<label for="cargo" class="form-label">Cargo</label> 
				<select class="form-select" id="cargo" name="cargo">
					<option value="GERENTE">GERENTE</option>
					<option value="COORDENADOR">COORDENADOR</option>
					<option value="SUPERVISOR">SUPERVISOR</option>
					<option value="OPERADOR">OPERADOR</option>
				</select>
			</div>

			<div class="mb-3">
				<label for="status" class="form-label">Status</label> <select
					class="form-select" id="status" name="status">
					<option value="ATIVO">ATIVO</option>
					<option value="FERIAS">FERIAS</option>
					<option value="DESLIGADO">DESLIGADO</option>
				</select>
			</div>
			
			<div class="mb-3">
				<button type="submit" class="btn btn-primary">Incluir Pessoa</button>
			</div>
			
			<div class="mb-3">
				${mensagem}
			</div>


		</form>
	
	
	</div>
	</div>
	
	

	</div>


</body>
</html>