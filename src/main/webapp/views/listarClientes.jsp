<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ucv.model.Cliente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Clientes</title>
</head>
<body>
    <h2>Gestión de Clientes</h2>

    <a href="views/nuevoCliente.jsp"> + Registrar Nuevo Cliente</a>
    <br><br>

    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>DNI</th>
                <th>Apellidos</th>
                <th>Nombres</th>
                <th>Email</th>
                <th>Celular</th>
                <th>Dirección</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Cliente> lista = (List<Cliente>) request.getAttribute("listaClientes");
                if (lista != null && !lista.isEmpty()) {
                    for (Cliente c : lista) {
            %>
            <tr>
                <td><%= c.getId() %></td>
                <td><%= c.getDni() %></td>
                <td><%= c.getApellidos() %></td>
                <td><%= c.getNombres() %></td>
                <td><%= c.getEmail() %></td>
                <td><%= c.getCelular() %></td>
                <td><%= c.getDireccion() %></td>
                <td>
                    <a href="ClienteController?accion=editar&id=<%= c.getId() %>">Editar</a> |
                    <a href="ClienteController?accion=eliminar&id=<%= c.getId() %>" onclick="return confirm('¿Eliminar cliente?');">Eliminar</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="8">No hay clientes registrados.</td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>