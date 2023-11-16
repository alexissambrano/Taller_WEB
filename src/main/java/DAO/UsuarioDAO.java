/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.Usuario;

public class UsuarioDAO implements DAO<Usuario> {
    private Connection conexion;

    // Constructor que recibe la conexión a la base de datos
    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregar(Usuario usuario) {
        String query = "INSERT INTO usuario (id_usuario, username, password, rol) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, usuario.getId_usuario());
            pst.setString(2, usuario.getUsername());
            pst.setString(3, usuario.getPassword());
            pst.setString(4, usuario.getRol());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerPorId(int id) {
        Usuario usuario = null;
        String query = "SELECT * FROM usuario WHERE id_usuario = ?";

        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("rol")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario";

        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("rol")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    @Override
    public void actualizar(Usuario usuario) {
        String query = "UPDATE usuario SET username=?, password=?, rol=? WHERE id_usuario=?";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setString(1, usuario.getUsername());
            pst.setString(2, usuario.getPassword());
            pst.setString(3, usuario.getRol());
            pst.setInt(4, usuario.getId_usuario());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM usuario WHERE id_usuario=?";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
