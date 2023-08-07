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
      crossorigin="anonymous"
    />
    <title>Cadastro de produto - Market</title>
    <style>

        body{
            background-color: #F5F5F5 ;
        }
        .custom-form {
          width: 50%;
          max-width: 400px;
          margin: 0 auto;
          background-color: #FFFFFF ;
          
        }
        #Btn-cadastro{
            background-color: #FF5A5F;
            color: #f5f5f5
        }
      </style>
  </head>

  <body class="d-flex justify-content-center align-items-center flex-column gap-4">
    <h2 class="text-info">Cadastro de produto</h2>
    <h4 class="text-danger">${messageError}</h4>
    <h4 class="text-warning">${message}</h4>
    <form method="post" action="loginmarket" class="custom-form">
      <div class="card border-secondary-subtle">
        <div class="card-body">
          <div class="mb-3">
            <label for="produto" class="form-label">Nome do produto</label>
            <input name="user" type="text" class="form-control" id="produto" value="">
          </div>
          <div class="mb-3">
            <label for="value" class="form-label">Valor:</label>
            <input name="user" type="text" class="form-control" id="value" value="">
          </div>
          <div class="mb-3">
            <label for="QtdEstoque" class="form-label">Qtd em estoque</label>
            <input name="user" type="text" class="form-control" id="QtdEstoque" value="">
          </div>
          <div class="mb-3">
            <label for="linkImg" class="form-label">Link da imagem</label>
            <input name="password" type="url" class="form-control" id="linkImg">
          </div>
          <button type="submit" id="Btn-cadastro" class="btn">Cadastrar</button>
        </div>
      </div>
    </form>
  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
      crossorigin="anonymous"></script>
  </body>
</html>
