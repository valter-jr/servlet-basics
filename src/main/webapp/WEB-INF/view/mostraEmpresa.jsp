<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<c:url value="/entrada" var="linkEntradaServlet"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />
<form action="${linkEntradaServlet}" method="post">
    Nome: <input type="text" name="nome" value="${empresa.nome}"/>
    Data Abertura: <input type="text" name="data" value=<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> />
    <input type="hidden" name="id" value="${empresa.id}">
    <input type="hidden" name="acao" value="EditaEmpresa">
    <input type="submit">
</form>

</body>
</html>
