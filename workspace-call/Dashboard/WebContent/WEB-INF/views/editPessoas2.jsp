
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
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="container">

		<div class="row">

			<div class="col-sm-6">

				<h2>ALTERACAO DE PESSOAS</h2>

				<form action="cadpessoas" method="post">
				
				<input type="hidden" name="id" value="${pessoa.id}">
				<input type="hidden" name="modo" value="alteracao">

					<div class="mb-3">
						<label for="nome" class="form-label">Nome</label> 
						<input type="text" class="form-control" value="${pessoa.nome}" id="nome"
							name="nome">
					</div>

					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" value="${pessoa.email}"
							id="email" name="email">
					</div>

					<div class="mb-3">
						<label for="cargo" class="form-label">Cargo</label> 
						<select	class="form-select" id="cargo" name="cargo">

							<c:forEach var="cargo" items="${cargos}">
								<c:choose>
									<c:when test="${cargo eq pessoa.cargo}">
										<option value="${cargo}" selected="selected">${cargo}</option>
									</c:when>
									<c:otherwise>
										<option value="${cargo}">${cargo}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							
						</select>
					</div>

					<div class="mb-3">
						<label for="status" class="form-label">Status</label> 
						<select	class="form-select" id="status" name="status">
							
							<c:forEach var="st" items="${status}">
								<c:choose>
									<c:when test="${st eq pessoa.status}">
										<option value="${st}" selected="selected">${st}</option>
									</c:when>
									<c:otherwise>
										<option value="${st}">${st}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>	
													
						</select>
					</div>

					<div class="mb-3">
						<button type="submit" class="btn btn-primary">Alterar</button>
					</div>

					<div class="mb-3">${mensagem}</div>


				</form>


			</div>
		</div>



	</div>


</body>
</html>