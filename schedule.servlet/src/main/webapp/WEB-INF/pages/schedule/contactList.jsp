<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de contatos</title>
</head>
<body>
	<h3>Lista de contatos</h3>
	<p style="color: red;">${errorMsg}</p>
	<table border="1" cellpadding="5" cellspacing="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Data Nascimento</th>
				<th>Telefone</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contactList}" var="contact">
				<tr>
					<td>${contact.name}</td>
					<td>${contact.birth}</td>
					<td>${contact.phone}</td>
					<td>
						<a href="${pageContext.request.contextPath}/agenda/editar?id=${contact.id}">Editar</a> | 
						<a href="${pageContext.request.contextPath}/agenda/excluir?id=${contact.id}">Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/agenda/incluir">Criar novo contato...</a>
</body>
</html>