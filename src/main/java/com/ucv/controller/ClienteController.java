package com.ucv.controller;

import com.ucv.dao.ClienteDAO;
import com.ucv.model.Cliente;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ClienteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClienteDAO dao = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null || accion.isEmpty() || accion.equals("listar")) {
            listar(request, response);
        } else if (accion.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Cliente c = dao.buscarPorId(id);
            request.setAttribute("cliente", c);
            request.getRequestDispatcher("views/editarCliente.jsp").forward(request, response);
        } else if (accion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
            response.sendRedirect("ClienteController?accion=listar");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            if (accion.equals("registrar")) {
                Cliente c = new Cliente();
                c.setDni(request.getParameter("dni"));
                c.setApellidos(request.getParameter("apellidos"));
                c.setNombres(request.getParameter("nombres"));
                c.setEmail(request.getParameter("email"));
                c.setCelular(request.getParameter("celular"));
                c.setDireccion(request.getParameter("direccion"));
                dao.agregar(c);
                response.sendRedirect("ClienteController?accion=listar");
            } else if (accion.equals("actualizar")) {
                Cliente c = new Cliente();
                c.setId(Integer.parseInt(request.getParameter("id")));
                c.setDni(request.getParameter("dni"));
                c.setApellidos(request.getParameter("apellidos"));
                c.setNombres(request.getParameter("nombres"));
                c.setEmail(request.getParameter("email"));
                c.setCelular(request.getParameter("celular"));
                c.setDireccion(request.getParameter("direccion"));
                dao.actualizar(c);
                response.sendRedirect("ClienteController?accion=listar");
            }
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> lista = dao.listar();
        request.setAttribute("listaClientes", lista);
        request.getRequestDispatcher("views/listarClientes.jsp").forward(request, response);
    }
}