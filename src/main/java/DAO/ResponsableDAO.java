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
import persistencia.Responsable;

public class ResponsableDAO implements DAO<Responsable> {
    private Connection conexion;

    // Constructor que recibe la conexión a la base de datos
    public ResponsableDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregar(Responsable responsable) {
        String query = "INSERT INTO responsables (id_responsable, tipo_resp) VALUES (?, ?)";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, responsable.getId_responsable());
            pst.setString(2, responsable.getTipo_resp());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Responsable obtenerPorId(int id) {
        Responsable responsable = null;
        String query = "SELECT * FROM responsables WHERE id_responsable = ?";

        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                responsable = new Responsable(
                        rs.getInt("id_responsable"),
                        rs.getString("tipo_resp")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return responsable;
    }

    @Override
    public List<Responsable> obtenerTodos() {
        List<Responsable> responsables = new ArrayList<>();
        String query = "SELECT * FROM responsables";

        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Responsable responsable = new Responsable(
                        rs.getInt("id_responsable"),
                        rs.getString("tipo_resp")
                );
                responsables.add(responsable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return responsables;
    }

    @Override
    public void actualizar(Responsable responsable) {
        String query = "UPDATE responsables SET tipo_resp=? WHERE id_responsable=?";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setString(1, responsable.getTipo_resp());
            pst.setInt(2, responsable.getId_responsable());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM responsables WHERE id_responsable=?";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
