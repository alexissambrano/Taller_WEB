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

public class UsuarioDAO {

    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public UsuarioDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void insertarUsuario(Usuario usuario) {
        try {
            String sql = "INSERT INTO usuarios (id_usuario, nombre_usuario, contrasenia, rol, id_odontologo, id_secretario) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, usuario.getId_usuario());
            statement.setString(2, usuario.getNombre_usuario());
            statement.setString(3, usuario.getContrasenia());
            statement.setString(4, usuario.getRol());
            statement.setString(5, usuario.getId_odontologo());
            statement.setString(6, usuario.getId_secretario());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM usuarios";
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int idUsuario = result.getInt("id_usuario");
                String nombreUsuario = result.getString("nombre_usuario");
                String contrasenia = result.getString("contrasenia");
                String rol = result.getString("rol");
                String idOdontologo = result.getString("id_odontologo");
                String idSecretario = result.getString("id_secretario");
                usuarios.add(new Usuario(idUsuario, nombreUsuario, contrasenia, rol, idOdontologo, idSecretario));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void eliminarUsuario(int idUsuario) {
        try {
            String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, idUsuario);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarUsuario(Usuario usuario) {
        try {
            String sql = "UPDATE usuarios SET nombre_usuario = ?, contrasenia = ?, rol = ?, id_odontologo = ?, id_secretario = ? WHERE id_usuario = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, usuario.getNombre_usuario());
            statement.setString(2, usuario.getContrasenia());
            statement.setString(3, usuario.getRol());
            statement.setString(4, usuario.getId_odontologo());
            statement.setString(5, usuario.getId_secretario());
            statement.setInt(6, usuario.getId_usuario());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario obtenerUsuarioPorId(int idUsuario) {
        try {
            String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, idUsuario);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String nombreUsuario = result.getString("nombre_usuario");
                String contrasenia = result.getString("contrasenia");
                String rol = result.getString("rol");
                String idOdontologo = result.getString("id_odontologo");
                String idSecretario = result.getString("id_secretario");
                return new Usuario(idUsuario, nombreUsuario, contrasenia, rol, idOdontologo, idSecretario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Devuelve null si no se encuentra el usuario
    }
}