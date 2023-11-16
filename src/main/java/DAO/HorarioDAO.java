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
import persistencia.Horario;

public class HorarioDAO implements DAO<Horario> {
    private Connection conexion;

    // Constructor que recibe la conexión a la base de datos
    public HorarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregar(Horario horario) {
        String query = "INSERT INTO horarios (id_horario, horario_inicio, horario_fin) VALUES (?, ?, ?)";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, horario.getId_horario());
            pst.setString(2, horario.getHorario_inicio());
            pst.setString(3, horario.getHorario_fin());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Horario obtenerPorId(int id) {
        Horario horario = null;
        String query = "SELECT * FROM horarios WHERE id_horario = ?";

        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                horario = new Horario(
                        rs.getInt("id_horario"),
                        rs.getString("horario_inicio"),
                        rs.getString("horario_fin")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return horario;
    }

    @Override
    public List<Horario> obtenerTodos() {
        List<Horario> horarios = new ArrayList<>();
        String query = "SELECT * FROM horarios";

        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Horario horario = new Horario(
                        rs.getInt("id_horario"),
                        rs.getString("horario_inicio"),
                        rs.getString("horario_fin")
                );
                horarios.add(horario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return horarios;
    }

    @Override
    public void actualizar(Horario horario) {
        String query = "UPDATE horarios SET horario_inicio=?, horario_fin=? WHERE id_horario=?";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setString(1, horario.getHorario_inicio());
            pst.setString(2, horario.getHorario_fin());
            pst.setInt(3, horario.getId_horario());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM horarios WHERE id_horario=?";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
