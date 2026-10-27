<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nuevo Cliente</title>
</head>
<body>
    <h2>Registrar Nuevo Cliente</h2>

    <form action="../ClienteController" method="post">
        <input type="hidden" name="accion" value="registrar">

        <label>DNI:</label><br>
        <input type="text" name="dni" required><br><br>

        <label>Apellidos:</label><br>
        <input type="text" name="apellidos" required><br><br>

        <label>Nombres:</label><br>
        <input type="text" name="nombres" required><br><br>

        <label>Email:</label><br>
        <input type="email" name="email"><br><br>

        <label>Celular:</label><br>
        <input type="text" name="celular"><br><br>

        <label>Dirección:</label><br>
        <input type="text" name="direccion"><br><br>

        <button type="submit">Guardar Cliente</button>
        <a href="../ClienteController?accion=listar">Cancelar</a>
    </form>
</body>
</html>