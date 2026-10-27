<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ucv.model.Cliente" %>
<%
    Cliente c = (Cliente) request.getAttribute("cliente");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Cliente</title>
</head>
<body>
    <h2>Modificar Datos de Cliente</h2>

    <form action="ClienteController" method="post">
        <input type="hidden" name="accion" value="actualizar">
        <input type="hidden" name="id" value="<%= c != null ? c.getId() : "" %>">

        <label>DNI:</label><br>
        <input type="text" name="dni" value="<%= c != null ? c.getDni() : "" %>" required><br><br>

        <label>Apellidos:</label><br>
        <input type="text" name="apellidos" value="<%= c != null ? c.getApellidos() : "" %>" required><br><br>

        <label>Nombres:</label><br>
        <input type="text" name="nombres" value="<%= c != null ? c.getNombres() : "" %>" required><br><br>

        <label>Email:</label><br>
        <input type="email" name="email" value="<%= c != null ? c.getEmail() : "" %>"><br><br>

        <label>Celular:</label><br>
        <input type="text" name="celular" value="<%= c != null ? c.getCelular() : "" %>"><br><br>

        <label>Dirección:</label><br>
        <input type="text" name="direccion" value="<%= c != null ? c.getDireccion() : "" %>"><br><br>

        <button type="submit">Actualizar Cliente</button>
        <a href="ClienteController?accion=listar">Cancelar</a>
    </form>
</body>
</html>