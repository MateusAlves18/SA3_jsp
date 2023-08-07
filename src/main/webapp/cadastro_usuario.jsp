<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
<style>
html, body {
	height: 100%;
	width: 100%;
	background-color: #f5f5f5;
}

.custom-form {
	width: 50%;
	max-width: 400px;
	margin: 0 auto;
	background-color: #ffffff;
}

.user-icon {
	display: flex;
	justify-content: center;
}

.max-width-form {
	max-width: 600px;
	width: 100%;
}

#Btn-cadastro {
	width: 25%;
	background-color: #ff5a5f;
	color: #f5f5f5;
	transition: background-color 0.3s ease;
}

#Btn-cadastro:hover {
	background-color: #ff888c; /* Cor clareada no hover */
}
</style>
<title>Cadastro Usuário - Market</title>
</head>
<body
	class="d-flex justify-content-center align-items-center flex-column gap-4">
	<!-- Ãcone de usuÃ¡rio com tamanho 4x -->
	<div class="user-icon">
		<i class="fas fa-user-circle fa-4x"></i>
	</div>
	<form method="post" action="loginmarket"
		class="custom-form col-md-6 max-width-form">
		<div class="card border-secondary-subtle">
			<div class="card-body">
				<div class="mb-3">
					<label for="nome" class="form-label">Nome</label> <input
						name="nome" type="text" class="form-control" id="nome" value="" />
				</div>
				<div class="mb-3">
					<label for="matricula" class="form-label">MatrÃ­cula</label> <input
						name="matricula" type="text" class="form-control" id="matricula" />
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">E-mail</label> <input
						name="email" type="email" class="form-control" id="email" />
				</div>
				<div class="mb-3">
					<label for="senha" class="form-label">Senha</label> <input
						name="senha" type="password" class="form-control" id="senha" />
				</div>
				<div class="mb-3">
					<label for="endereco" class="form-label">EndereÃ§o</label> <input
						name="endereco" type="text" class="form-control" id="endereco" />
				</div>
				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="tipoCadastro" class="form-label">Tipo
							de Cadastro:</label> <select name="tipoCadastro" class="form-select"
							id="tipoCadastro">
							<option value="cnpj">Com CNPJ</option>
							<option value="sem_cnpj">Sem CNPJ</option>
						</select>
					</div>
					<div class="col-md-6 mb-3">
						<label for="linkImg" class="form-label">Link da imagem</label> <input
							name="linkImg" type="url" class="form-control" id="linkImg" />
					</div>
				</div>
				<div class="button-container text-center">
					<button type="submit" id="Btn-cadastro" class="btn">
						Cadastrar</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
