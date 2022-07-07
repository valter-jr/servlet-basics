<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
    <title>Java Standard Taglib</title>
</head>
<body>
    <c:import url="logout-parcial.jsp" />
    Usuario Logado: ${usuarioLogado.login}
    <br>
    <br>
    <br>

<c:if test="${not empty empresa}">
    Empresa ${empresa} cadastrada com sucesso!
    <br />
</c:if>
    Lista de empresas: <br />
    <ul>
        <jsp:useBean id="lista" scope="request" type="java.util.List"/>
        <c:forEach items="${lista}" var="empresa">
            <li>${empresa.nome} -  <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
                <a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">edita</a>
                <a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remove</a></li>
        </c:forEach>
    </ul>
</body>
</html>
