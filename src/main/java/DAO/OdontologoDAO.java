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
import persistencia.Odontologo;

public class OdontologoDAO {

    private Connection conexion;

    public OdontologoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertarOdontologo(Odontologo odontologo) {
        try {
            String sql = "INSERT INTO odontologos (id_odontologo, especialidad, dni, apellido, telefono, direccion, fecha_nac) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, odontologo.getId_odontologo());
            statement.setString(2, odontologo.getEspecialidad());
            statement.setString(3, odontologo.getDni());
            statement.setString(4, odontologo.getApellido());
            statement.setString(5, odontologo.getTelefono());
            statement.setString(6, odontologo.getDireccion());
            statement.setString(7, odontologo.getFecha_nac());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Odontologo> obtenerOdontologos() {
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM odontologos";
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int idOdontologo = result.getInt("id_odontologo");
                String especialidad = result.getString("especialidad");
                String dni = result.getString("dni");
                String apellido = result.getString("apellido");
                String telefono = result.getString("telefono");
                String direccion = result.getString("direccion");
                String fechaNac = result.getString("fecha_nac");
                odontologos.add(new Odontologo(idOdontologo, especialidad, null, null, null, dni, apellido, telefono, direccion, fechaNac));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return odontologos;
    }

    public void eliminarOdontologo(int idOdontologo) {
    try {
        String sql = "DELETE FROM odontologos WHERE id_odontologo = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setInt(1, idOdontologo);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void editarOdontologo(Odontologo odontologo) {
    try {
        String sql = "UPDATE odontologos SET especialidad = ?, dni = ?, apellido = ?, telefono = ?, direccion = ?, fecha_nac = ? WHERE id_odontologo = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, odontologo.getEspecialidad());
        statement.setString(2, odontologo.getDni());
        statement.setString(3, odontologo.getApellido());
        statement.setString(4, odontologo.getTelefono());
        statement.setString(5, odontologo.getDireccion());
        statement.setString(5, odontologo.getFecha_nac());
        statement.setInt(7, odontologo.getId_odontologo());
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public Odontologo visualizarOdontologo(int idOdontologo) {
    try {
        String sql = "SELECT * FROM odontologos WHERE id_odontologo = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setInt(1, idOdontologo);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            String especialidad = result.getString("especialidad");
            String dni = result.getString("dni");
            String apellido = result.getString("apellido");
            String telefono = result.getString("telefono");
            String direccion = result.getString("direccion");
            String fechaNac = result.getString("fecha_nac");
            return new Odontologo(idOdontologo, especialidad, null, null, null, dni, apellido, telefono, direccion, fechaNac);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null; // Devuelve null si no se encuentra el odontólogo
}
}