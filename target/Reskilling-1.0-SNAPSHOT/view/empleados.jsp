<%--
  Created by IntelliJ IDEA.
  User: brian
  Date: 14-08-21
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Empleados</title>
</head>
<body>
    <h1>Lista de Empleados</h1>
    <table>
        <thead>
            <tr>
                <th>#</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Email</th>
                <th>Teléfono</th>
                <th>Fecha de Contratación</th>
                <th>Jefe</th>
                <th>Cargo</th>
                <th>Acción!</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="e" items="${empleados}">
                <tr>
                    <th>
                        <c:url var="verEmpleado" value="/EmpleadoController">
                            <c:param name="id" value="${e.getId()}"/>
                            <c:param name="accion" value="verUno"/>
                        </c:url>
                        <a href="${verEmpleado}"><c:out value="${e.getId()}"/></a></th>
                    <td><c:out value="${e.getNombre()}"/></td>
                    <td><c:out value="${e.getApellido()}"/></td>
                    <td><c:out value="${e.getEmail()}"/></td>
                    <td><c:out value="${e.getTel()}"/></td>
                    <td><c:out value="${e.getFechaContratacion()}"/></td>
                    <td>
                        <c:url var="verJefe" value="/EmpleadoController">
                            <c:param name="id" value="${e.getJefe()}"/>
                            <c:param name="accion" value="verUno"/>
                        </c:url>
                        <a href="${verJefe}"><c:out value="${e.getJefe()}"/></a></td>
                    <td><c:out value="${e.getCargo()}"/></td>
                    <td>
                        <c:url var="editar" value="/EmpleadoController">
                            <c:param name="id" value="${e.getId()}"/>
                            <c:param name="accion" value="editar"/>
                        </c:url>
                        <c:url var="borrar" value="/EmpleadoController">
                            <c:param name="id" value="${e.getId()}"/>
                            <c:param name="accion" value="borrar"/>
                        </c:url>

                        <a href="${editar}">Editar</a> | <a href="${borrar}">Borrar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
