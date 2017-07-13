<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<title>Trolle</title>
<c:url var="url_base" value="/" />

</head>
<body>

	<section id="menu-principal">
		<div class="container">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel">
					<div class="panel-heading">
						<h1 class="text-center">
							<strong>Trolle</strong>
						</h1>
					</div>
					<div class="panel-body">
						<c:if test="${not empty msg_login}">
							<div class="alert alert-d/anger alert-dismissible" role="alert">
								<p>${msg_login}</p>
							</div>
						</c:if>

						<form action="login" method="post">
							<div>
								<label for="login">Nome do usuário</label>
								<input id="login" type="text" placeholder="exemplo123" name="login" class="form-control"></input>
							</div>
							<div>
								<label for="senha">Senha</label>
								<input id="senha" type="password" class="form-control" name="senha"></input>
							</div>
							<button id="loginButton" class="form-control btn btn-primary"  >Login</button>
						</form>
						
					</div>
				</div>
				<!--  div class="panel">
					<div class="panel-body">
						<p class="text-center">
							Você não tem conta? <a href="/usuario/add">Cadastre-se</a>
						</p>
					</div>
				</div-->
			</div>
		</div>
	</section>

</body>
</html>