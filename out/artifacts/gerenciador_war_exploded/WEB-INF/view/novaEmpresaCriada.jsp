<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />
    <c:if test="${empty empresa}">
        Nenhuma empresa cadastrada!
    </c:if>
</body>
</html>
