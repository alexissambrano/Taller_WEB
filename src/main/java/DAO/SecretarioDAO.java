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
import persistencia.Secretario;

public class SecretarioDAO implements DAO<Secretario> {
    private Connection conexion;

    // Constructor que recibe la conexión a la base de datos
    public SecretarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregar(Secretario secretario) {
        String query = "INSERT INTO secretarios (id_secretario, sector, usuario_id) VALUES (?, ?, ?)";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, secretario.getId_secretario());
            pst.setString(2, secretario.getSector());
            pst.setInt(3, secretario.getUsuario().getId_usuario());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Secretario obtenerPorId(int id) {
        Secretario secretario = null;
        String query = "SELECT * FROM secretarios WHERE id_secretario = ?";

        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                secretario = new Secretario(
                        rs.getInt("id_secretario"),
                        rs.getString("sector"),
                        null // Aquí deberías obtener el Usuario correspondiente por su ID
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return secretario;
    }

    @Override
    public List<Secretario> obtenerTodos() {
        List<Secretario> secretarios = new ArrayList<>();
        String query = "SELECT * FROM secretarios";

        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Secretario secretario = new Secretario(
                        rs.getInt("id_secretario"),
                        rs.getString("sector"),
                        null // Aquí deberías obtener el Usuario correspondiente por su ID
                );
                secretarios.add(secretario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return secretarios;
    }

    @Override
    public void actualizar(Secretario secretario) {
        String query = "UPDATE secretarios SET sector=?, usuario_id=? WHERE id_secretario=?";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setString(1, secretario.getSector());
            pst.setInt(2, secretario.getUsuario().getId_usuario());
            pst.setInt(3, secretario.getId_secretario());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM secretarios WHERE id_secretario=?";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
