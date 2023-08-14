<%@ page import="dao.ProductDAO, java.util.ArrayList , model.Product"
	language="java" contentType="text/html; charset=UTF-8"
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
						<li class="nav-item"><a class="nav-link"
							href="/senai/admin/cadastro_produto.jsp">Adicionar Produto</a> <a
							class="nav-link" href="/senai/admin/alterar_id.jsp">Alterar
								Produto</a> <a class="nav-link" href="/senai/admin/deletar_id.jsp">Deletar
								Produto</a></li>
						<a class="nav-link" href="/senai">Ir para o Market</a>
						</li>
						</li>
						<a class="nav-link" href="/senai/loginmarket?action=close">Sair
							do usuário ${user} </a>
						</li>

					</ul>
				</div>
			</div>
		</div>
	</nav>
	<div class="py-3"></div>
	<%
	String action = (String) request.getAttribute("action");
	if (action != null) {
	%>
	<div class="alert alert-success mt-5" role="alert">${action} do
		produto realizado com sucesso!</div>
	<%
	}
	%>

	<div class="d-flex align-items-center flex-column"
		style="margin: 40px 5% 0 5%; height: 100%; width: 90%;">

		<table class="table">
			<thead>
				<tr class="text-center">
					<th scope="col">Id Produto</th>
					<th scope="col">Nome</th>
					<th scope="col">Quantidade</th>
					<th scope="col">Valor</th>
					<th scope="col">Link Imagem</th>
				</tr>
			</thead>
			<tbody>
				<%
				ProductDAO productDAO = new ProductDAO();
				ArrayList<Product> products = productDAO.readProducts();
				for (Product product : products) {
				%>

				<tr class="text-center">
					<th scope="row"><%=product.getIdProduto()%></th>
					<td><%=product.getName()%></td>
					<td><%=product.getQuantidade()%></td>
					<td>R$ <%=product.getValor()%></td>
					<td><%=product.getLinkImg()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous">
		
	</script>
</body>

</html>