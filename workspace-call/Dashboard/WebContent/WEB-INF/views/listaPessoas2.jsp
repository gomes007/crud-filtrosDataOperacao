
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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

	<jsp:useBean id="bean" class="br.com.dashboard.beans.PessoasBean" />

	<div class="container">
		<h1>Lista de pessoas</h1>
		<input type="hidden" name="id" value="${pessoa.id}">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">NOME</th>
					<th scope="col">CARGO</th>
					<th scope="col">EMAIL</th>
					<th scope="col">STATUS</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pessoa" items="${bean.listaPessoa}">
					<tr>
						<td>${pessoa.nome}</td>
						<td>${pessoa.cargo}</td>
						<td>${pessoa.email}</td>
						<td>${pessoa.status}</td>
						<td><a href="cadpessoas?opcao=alterar&id=${pessoa.id}" class="btn btn-primary">Editar</a> 
							<!-- Button trigger modal -->
							<button type="button" class="btn btn-danger remove" data-id="${pessoa.id}" data-bs-toggle="modal" data-bs-target="#modal"> Excluir</button>														
							
						</td>
					</tr>

				</c:forEach>
			</tbody>

		</table>
	</div>
	
					<!-- Modal -->
				    <div class="modal fade" id="modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"> 
				        <div class="modal-dialog"> 
				            <div class="modal-content"> 
				                <div class="modal-header"> 
				                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5> 
				                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> 
				                </div> 
				                
				                <div class="modal-body"> 
				                    <p>hi</p>
				                    <div id="conteudo"></div> 
				                </div>
				                 
				                <div class="modal-footer"> 
				                    <button type="button" id="btnConfirmar" class="btn btn-danger" data-bs-dismiss="modal">Confirm delete</button> 
				                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
				                </div> 
				            </div> 
				        </div> 
				    </div>

					<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

					<script>
						$(document).ready(function(){
							var id;
							$('.remove').click(function(){
								id = $(this).attr("data-id");
								var texto = '<p>Codigo a ser removido: ' + id + '</p>';
								$("#conteudo").html(texto);
							})
							
							$('#btnConfirmar').click(function(){
								var url = 'cadpessoas?opcao=remover&id=' + id;
								$(location).attr('href', url);
							})
						})
																		
					</script>




</body>
</html>