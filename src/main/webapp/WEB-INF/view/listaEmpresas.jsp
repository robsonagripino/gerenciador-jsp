<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ page import="java.util.List, br.com.alura.gerenciador.modelo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<c:import url="logout-parcial.jsp"/>
		
		 
		Usuario logado: ${ usuarioLogado.login }
		<br/><br/>
		<c:if test="${not empty empresa}">
			Empresa ${ empresa } cadastrada com sucesso!
		</c:if>
		<br/>
		Lista de empresas: 
		<br/>
		
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				
				<li>
					${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>  
					<a href="/gerenciador_jsp/entrada?acao=mostraEmpresa&id=${empresa.id }">editar</a> 
					<a href="/gerenciador_jsp/entrada?acao=removeEmpresa&id=${empresa.id }">excluir</a> 
				</li>
			</c:forEach>
		</ul>
	
	</body>
</html>