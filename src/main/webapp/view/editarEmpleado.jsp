<%--
  Created by IntelliJ IDEA.
  User: brian
  Date: 14-08-21
  Time: 12:56
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
<c:url var="action" value="/EmpleadoController">
    <c:param name="accion" value="editar"/>
</c:url>
<form action="${action}" method="post">
    <input type="hidden" value="${e.getId()}" name="id">
    <p>Nombre: <input type="text" value="${e.getNombre()}" name="nombre"> </p>
    <p>Apellido: <input type="text" value="${e.getApellido()}" name="apellido"/></p>
    <p>Email: <input type="email" value="${e.getEmail()}" name="email"/></p>
    <p>Tel: <input type="tel" value="${e.getTel()}" name="tel"/></p>
    <p>Fecha de Contratación: <input type="date" value="${e.getFechaContratacion()}" name="fechaContratacion"/></p>
    <p>Jefe: <input type="number" value="${e.getJefe()}" name="jefe"/></p>
    <p>Cargo: <input type="text" value="${e.getCargo()}" name="cargo"/></p>
    <p><button type="submit">Enviar</button> <button type="Reset">Reset</button>
</body>
</html>
