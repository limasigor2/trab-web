<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url_base" value="/" />
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Lista Anotacoes</title>
	<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
</head>
<body>
<jsp:include page="navbar.jsp"/>

<div class="container">
	<h1>Lista Anotacoes</h1>
	<c:if test="${not empty msg}">
		<div class="alert alert-success alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<p>${msg}</p>
		</div>
	</c:if>
	<a href="/anotacoes/add" class="btn btn-primary">Novo anotacao</a>
	<c:if test="${not empty anotacoes}">
	<table id="tabela_anotacoes" class="table table-hover">
		<thead>
			<tr><th>Nome</th><th>Descricao</th><th>Estado</th><th>Alterar</th><th>Deletar</th></tr>
		</thead>
		<tbody>
		<c:forEach var="a" items="${anotacoes}">
			<tr><td>${a.nome}</td><td>${a.descricao}</td><td>${a.estado}</td>
			<td><a href="${url_base}anotacoes/${a.id}/update" class="btn btn-primary">Altera</a></td>
			<td><a href="${url_base}anotacoes/${a.id}/delete" class="btn btn-danger" onclick="return confirm('Confirma remoção?')" >Deleta</a></td>
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