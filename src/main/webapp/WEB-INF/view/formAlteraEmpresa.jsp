<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada?acao=alteraEmpresa&" var="linkServletAlteraEmpresa"></c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<c:import url="logout-parcial.jsp"/>
		<h1>Alterar Empresa</h1>
		<form action="${linkServletAlteraEmpresa}id=${empresa.id}" method="post">
			Nome: <input type="text" name="nome" value="${empresa.nome }"/> 
			Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>" />
			<input type="submit" value="Ok"/>
		</form>
	</body>
</html>