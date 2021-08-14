<%--
  Created by IntelliJ IDEA.
  User: brian
  Date: 14-08-21
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Empleado</title>
</head>
<body>
    <h1>Empleado</h1>
    <h2><c:out value="${e.getNombre()}"/> <c:out value="${e.getApellido()}"/></h2>
    <p>Email: <c:out value="${e.getEmail()}"/></p>
    <p>Tel: <c:out value="${e.getTel()}"/></p>
    <p>Fecha de Contratación: <f:formatDate value="${e.getFechaContratacion()}" pattern="dd/MM/yyyy"/></p>
    <p>Jefe: <c:out value="${e.getJefe()}"/></p>
    <p>Cargo: <c:out value="${e.getCargo()}"/></p>
</body>
</html>
