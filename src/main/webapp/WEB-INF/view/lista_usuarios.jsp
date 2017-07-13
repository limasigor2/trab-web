<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url_base" value="/" />
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Lista Usuarios</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">

	<h1>Lista de Usuarios</h1>
	<c:if test="${not empty msg}">
		<div class="alert alert-success alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<p>${msg}</p>
		</div>
	</c:if>
	<a href="/usuarios/add" class="btn btn-primary">Novo usuario</a>
	<c:if test="${not empty usuarios}">
	<table id="tabela_usuarios" class="table table-hover">
		<thead>
			<tr><th>Nome</th><th>Login</th><th>Altera</th><th>Delatação</th></tr>
		</thead>
		<tbody>
		<c:forEach var="u" items="${usuarios}">
			<tr><td>${u.nome}</td><td>${u.login}</td>
			<td><a href="${url_base}usuarios/${u.id}/update" class="btn btn-primary">Altera</a></td>
			<td><a href="${url_base}usuarios/${u.id}/delete" class="btn btn-danger" onclick="return confirm('Confirma remoção?')" >Deleta</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</c:if>
</div>
<script src="${url_base}js/jquery-3.2.1.min.js"></script>
<script src="${url_base}js/bootstrap.min.js"></script>
<script>
</script>
</body>
</html>