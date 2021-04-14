
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@ include file="cabecalho.jsp"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="container">

		<div class="row">

			<div class="col-sm-6">

				<h2>ALTERACAO DE TESTES</h2>

				<form action="teste" method="post">
				
				<input type="hidden" name="id" value="${teste.id}">
				<input type="hidden" name="modo" value="alteracao">
				
				<div class="mb-3">
					<label for="nome" class="form-label">Nome</label> 
					<input type="text" class="form-control" value="${teste.nome}" id="nome" name="nome">
				</div>
				
				<div class="mb-3">
					<button type="submit" class="btn btn-primary">Alterar</button>
				</div>
				
				</form>

			</div>
		</div>
	</div>



</body>
</html>