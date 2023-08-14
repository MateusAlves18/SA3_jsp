<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<style>
html, body {
	height: 100%;
	width: 100%;
}
</style>
<title>Deletar Produto - Market</title>
</head>

<body
	class="d-flex justify-content-center align-items-center bg-body-secondary flex-column gap-4">
	<h2 class="text-info">Digite o ID do produto para Deletar</h2>
	<%
	String id = (String) request.getAttribute("id");
	if (id != null) {
	%>
	<div class="alert alert-danger" role="alert">Id ${id} inválido!</div>
	<%
	}
	%>
	<a class="btn btn-primary" href="/senai/admin" role="button">Retornar a Administração</a>
	<form method="get" action="/senai/delete_product">
		<div
			class="d-flex justify-content-center align-items-center flex-column border border-5 rounded-3 border-secondary-subtle border-black p-5">

			<div class="mb-3">
				<label for="id" class="form-label">Id do Produto</label> <input
					name="id" type="number" class="form-control" id="id">
			</div>

			<button type="submit" class="btn btn-primary">Buscar Produto</button>
		</div>
	</form>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>

</html>