<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="post" modelAttribute="anotacao" action="${url_base}/anotacoes">
	<form:input path="id" type="hidden"  />

	<spring:bind path="nome">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="nome">Nome</form:label>
		<form:input path="nome" type="text" cssClass="form-control" />
		<form:errors path="nome" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="descricao">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="descricao">Descricao</form:label>
		<form:input path="descricao" type="text" cssClass="form-control" />
		<form:errors path="descricao" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="estado">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="estado">Estado</form:label>
		<form:input path="estado" type="text" cssClass="form-control" />
		<form:errors path="estado" class="control-label" />
	</div>
	</spring:bind>
	<button type="submit" class="btn btn-primary">Salvar</button>
</form:form>