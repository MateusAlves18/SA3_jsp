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
<title>Login - Market</title>
</head>

<body
	class="d-flex justify-content-center align-items-center bg-body-secondary flex-column gap-4">
	<h2 class="text-info">Faça login ao Market</h2>
	<h4 class="text-danger">${messageError}</h4>
	<h4 class="text-warning">${message}</h4>
	<form method="post" action="loginmarket">
		<div
			class="d-flex justify-content-center align-items-center flex-column border border-5 rounded-3 border-secondary-subtle border-black p-5">

			<div class="mb-3">
				<label for="user" class="form-label">Usuario</label> <input
					name="user" type="text" class="form-control" id="user" value="${user}">
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Senha</label> <input
					name="password" type="password" class="form-control" value="${password}" id="password">
			</div>
			<button type="submit" class="btn btn-primary">Fazer Login</button>
		</div>
	</form>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>

</html>