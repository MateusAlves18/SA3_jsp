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
<title>Administração - Market</title>
</head>

<body class="bg-body-secondary">
	<nav class="navbar navbar-dark bg-dark fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Administração do Market</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar"
				aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1"
				id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
				<div class="offcanvas-header">
					<h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Market
						Panel</h5>
					<button type="button" class="btn-close btn-close-white"
						data-bs-dismiss="offcanvas" aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Visualização dos Produtos</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Adiconar
								Produto</a> <a class="nav-link" href="#">Alterar Produto</a> <a
							class="nav-link" href="#">Deletar Produto</a></li>
						<a class="nav-link" href="/senai">Ir para o Market</a>
						</li>
						</li>
						<a class="nav-link" href="/senai/loginmarket?action=close">Sair do usuário ${user} </a>
						</li>

					</ul>
				</div>
			</div>
		</div>
	</nav>

	<div class="d-flex align-items-center flex-column"
		style="margin-top: 80px; height: 100%; width: 100%;">

		<ul
			class=" list-group list-group-horizontal border-3 border border-black">
			<li class="list-group-item text-center" style="width: 250px;">Id
				Produto</li>
			<li class="list-group-item text-center" style="width: 250px">Nome</li>
			<li class="list-group-item text-center" style="width: 250px">Quantidade
				em Estoque</li>
			<li class="list-group-item text-center" style="width: 250px">Valor
				R$</li>
			<li class="list-group-item text-center" style="width: 250px">Link
				img</li>
		</ul>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous">
		
	</script>
</body>

</html>