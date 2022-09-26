<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="./resources/css/styles.css"/>'>
<title>Alunos</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp"/>
	</div>
	<br />
	<div align="center">
		<form action="aluno" method="post">
			<table>
				<tr>
					<td>
						<input class="id_input_data" type="number" min="0"
							step="1" id="cod" name="cod" placeholder="COD">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Consultar">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" id="botao" name="botao" value="Listar">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
	<div align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty alunos }">
			<table class="table_round">
				<thead>
					<tr>
						<th>Código</th>
						<th>Nome</th>
						<th>Altura</th>
						<th>Peso</th>
						<th>IMC</th>
						<th>Situação</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="al" items="${alunos }">
						<tr>
							<td><c:out value="${al.cod }"/></td>
							<td><c:out value="${al.nome }"/></td>
							<td><c:out value="${al.altura }"/></td>
							<td><c:out value="${al.peso }"/></td>
							<td><c:out value="${al.imc }"/></td>
							<td><c:out value="${al.situacao }"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty aluno }">
			<table class="table_round">
				<thead>
					<tr>
						<th>Código</th>
						<th>Nome</th>
						<th>Altura</th>
						<th>Peso</th>
						<th>IMC</th>
						<th>Situação</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><c:out value="${aluno.cod }"/></td>
						<td><c:out value="${aluno.nome }"/></td>
						<td><c:out value="${aluno.altura }"/></td>
						<td><c:out value="${aluno.peso }"/></td>
						<td><c:out value="${aluno.imc }"/></td>
						<td><c:out value="${aluno.situacao }"/></td>
					</tr>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>