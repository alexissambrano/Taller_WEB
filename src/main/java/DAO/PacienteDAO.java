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
import persistencia.Paciente;

public class PacienteDAO implements DAO<Paciente> {
    private Connection conexion;

    // Constructor que recibe la conexión a la base de datos
    public PacienteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregar(Paciente paciente) {
        String query = "INSERT INTO pacientes (id_paciente, seguro, tipo_sangre, responsable_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, paciente.getId_paciente());
            pst.setString(2, paciente.getSeguro());
            pst.setString(3, paciente.getTipo_sangre());
            pst.setInt(4, paciente.getResponsable().getId_responsable());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Paciente obtenerPorId(int id) {
        Paciente paciente = null;
        String query = "SELECT * FROM pacientes WHERE id_paciente = ?";

        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                paciente = new Paciente(
                        rs.getInt("id_paciente"),
                        rs.getString("seguro"),
                        rs.getString("tipo_sangre"),
                        null // Aquí deberías obtener el Responsable correspondiente por su ID
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente;
    }

    @Override
    public List<Paciente> obtenerTodos() {
        List<Paciente> pacientes = new ArrayList<>();
        String query = "SELECT * FROM pacientes";

        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente(
                        rs.getInt("id_paciente"),
                        rs.getString("seguro"),
                        rs.getString("tipo_sangre"),
                        null // Aquí deberías obtener el Responsable correspondiente por su ID
                );
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pacientes;
    }

    @Override
    public void actualizar(Paciente paciente) {
        String query = "UPDATE pacientes SET seguro=?, tipo_sangre=?, responsable_id=? WHERE id_paciente=?";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setString(1, paciente.getSeguro());
            pst.setString(2, paciente.getTipo_sangre());
            pst.setInt(3, paciente.getResponsable().getId_responsable());
            pst.setInt(4, paciente.getId_paciente());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM pacientes WHERE id_paciente=?";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

