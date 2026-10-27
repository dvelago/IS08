package com.ucv.dao;

import com.ucv.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setDni(rs.getString("dni"));
                c.setApellidos(rs.getString("apellidos"));
                c.setNombres(rs.getString("nombres"));
                c.setEmail(rs.getString("email"));
                c.setCelular(rs.getString("celular"));
                c.setDireccion(rs.getString("direccion"));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println(">>> ERROR EN CLIENTEDAO.LISTAR <<<");
            e.printStackTrace();
        }
        return lista;
    }

    public void agregar(Cliente c) {
        String sql = "INSERT INTO cliente(dni, apellidos, nombres, email, celular, direccion) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getDni());
            ps.setString(2, c.getApellidos());
            ps.setString(3, c.getNombres());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getCelular());
            ps.setString(6, c.getDireccion());

            int filas = ps.executeUpdate();
            System.out.println(">>> FILAS INSERTADAS EN REGISTRO: " + filas);
        } catch (Exception e) {
            System.out.println(">>> ERROR EN CLIENTEDAO.AGREGAR <<<");
            e.printStackTrace();
        }
    }

    public Cliente buscarPorId(int id) {
        Cliente c = new Cliente();
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c.setId(rs.getInt("id"));
                    c.setDni(rs.getString("dni"));
                    c.setApellidos(rs.getString("apellidos"));
                    c.setNombres(rs.getString("nombres"));
                    c.setEmail(rs.getString("email"));
                    c.setCelular(rs.getString("celular"));
                    c.setDireccion(rs.getString("direccion"));
                }
            }
        } catch (Exception e) {
            System.out.println(">>> ERROR EN CLIENTEDAO.BUSCARPORID <<<");
            e.printStackTrace();
        }
        return c;
    }

    public void actualizar(Cliente c) {
        String sql = "UPDATE cliente SET dni=?, apellidos=?, nombres=?, email=?, celular=?, direccion=? WHERE id=?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getDni());
            ps.setString(2, c.getApellidos());
            ps.setString(3, c.getNombres());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getCelular());
            ps.setString(6, c.getDireccion());
            ps.setInt(7, c.getId());

            int filas = ps.executeUpdate();
            System.out.println(">>> FILAS ACTUALIZADAS: " + filas);
        } catch (Exception e) {
            System.out.println(">>> ERROR EN CLIENTEDAO.ACTUALIZAR <<<");
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            System.out.println(">>> FILAS ELIMINADAS: " + filas);
        } catch (Exception e) {
            System.out.println(">>> ERROR EN CLIENTEDAO.ELIMINAR <<<");
            e.printStackTrace();
        }
    }
}