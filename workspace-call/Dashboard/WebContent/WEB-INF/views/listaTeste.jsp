
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

	<jsp:useBean id="bean" class="br.com.dashboard.beans.TestesBean" />


	<div class="container">
		<h3>listar testes</h3>
		<input type="hidden" name="id" value="${teste.id}">



		<table class="table">
			<thead>
				<tr>
					<th scope="col">NOME</th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="teste" items="${bean.listaTeste}">
					<tr>
						<td>${teste.nome}</td>
						<td><a href="teste?opcao=alterar&id=${teste.id}" class="btn btn-primary">Editar</a></td>
						<td>
							<!-- Button trigger modal -->
							<button type="button" class="btn btn-danger"
								data-bs-toggle="modal" data-bs-target="#myModal">
								Excluir</button> <!-- Modal -->
							<div class="modal fade" id="myModal" tabindex="-1"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="myModalLabel">Delete</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">Are you sure?</div>
										<div class="modal-footer">
											<a href="teste?opcao=remover&id=${teste.id}"
												class="btn btn-danger">Delete</a>
											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">Cancel</button>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>


	</div>


</body>
</html>