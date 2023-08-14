<%@ page import="dao.ProductDAO, java.util.ArrayList , model.Product"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">

<title>Market - Products</title>
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	width: 100%;
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}

.btn-bd-primary {
	--bd-violet-bg: #712cf9;
	--bd-violet-rgb: 112.520718, 44.062154, 249.437846;
	--bs-btn-font-weight: 600;
	--bs-btn-color: var(--bs-white);
	--bs-btn-bg: var(--bd-violet-bg);
	--bs-btn-border-color: var(--bd-violet-bg);
	--bs-btn-hover-color: var(--bs-white);
	--bs-btn-hover-bg: #6528e0;
	--bs-btn-hover-border-color: #6528e0;
	--bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
	--bs-btn-active-color: var(--bs-btn-hover-color);
	--bs-btn-active-bg: #5a23c8;
	--bs-btn-active-border-color: #5a23c8;
}

.bd-mode-toggle {
	z-index: 1500;
}
</style>
</head>
<body>
	<%
	String cadastro = (String) request.getAttribute("cadastro");
	if (cadastro != null) {
	%>
	<div class="alert alert-success" role="alert">Cadastro realizado
		com sucesso!</div>
	<%
	}
	%>
	<header data-bs-theme="dark">
		<div class="collapse text-bg-dark" id="navbarHeader">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-md-7 py-4 nav">
						<li><a
							class="nav-link link-primary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
							href="admin">Ir para a Administração</a> <a
							class="nav-link link-primary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
							href="login.jsp">Fazer Login Cliente</a> <a
							class="nav-link link-primary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
							href="cadastro_usuario.jsp">Fazer Cadastro Cliente</a></li>
					</div>

				</div>
			</div>
		</div>
		<div class="navbar navbar-dark bg-dark shadow-sm">
			<div class="container">
				<a href="login_client?action=close"
					class="navbar-brand d-flex align-items-center"><strong>Market
						<%
				String name = (String) session.getAttribute("name");
				if (name != null) {
					out.print("- Cliente - " + name + " - (Sair)");
				}
				%>


				</strong> </a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarHeader"
					aria-controls="navbarHeader" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
		</div>
	</header>
	<main>
		<section class="py-5 text-center container">
			<div class="row py-lg-5">
				<div class="col-lg-6 col-md-8 mx-auto">
					<h1 class="fw-light">Market - Venda de sapatos</h1>
					<p class="lead text-body-secondary">A loja de sapatos oferece
						uma ampla variedade de estilos e tamanhos para atender a todos os
						gostos e necessidades. Com produtos de qualidade e um atendimento
						especializado, a loja de sapatos é o destino perfeito para
						encontrar o calçado ideal.</p>
				</div>
			</div>
		</section>

		<div class="d-flex align-items-center flex-row gap-3 mx-5 flex-wrap">
			<%
			ProductDAO productDAO = new ProductDAO();
			ArrayList<Product> products = productDAO.readProducts();
			for (Product product : products) {
			%>

			<div class="card" style="width: 18rem;">
				<img src="<%=product.getLinkImg()%>" class="card-img-top" alt="carregando...">
				<div class="card-body">
					<p class="card-text">
						<strong>Produto:</strong>
						<%=product.getName()%></p>
					<p class="card-text">
						<strong>Valor:</strong> R$
						<%=Double.toString(product.getValor()).replace(".", ",")%></p>
					<p class="card-text">
						<strong>Quantidade:</strong>
						<%=product.getQuantidade()%></p>
				</div>

			</div>
			<%
			}
			%>
		</div>

	</main>

	<footer class="text-body-secondary py-5">
		<div class="container">
			<p class="float-end mb-1">
				<a href="#">Voltar ao topo</a>
			</p>
			<p>Market Loja de Sapatos</p>
		</div>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>


</html>