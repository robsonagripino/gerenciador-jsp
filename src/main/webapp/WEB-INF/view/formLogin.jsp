<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada?acao=login" var="linkEntradaServlet"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="${linkEntradaServlet}" method="post">
		Login: <input type="text" name="login"/>
		Senha: <input type="password" name="senha"/>
		<input type="submit" value="Ok"/>
	</form>
</body>
</html>