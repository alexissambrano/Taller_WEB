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

public class OdontologoDAO implements DAO<Odontologo> {
    private Connection conexion;

    // Constructor que recibe la conexión a la base de datos
    public OdontologoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregar(Odontologo odontologo) {
        String query = "INSERT INTO odontologos (id_odontologo, especialidad, horario_id, usuario_id, id_persona, dni, nombre, apellido, edad, telefono, direccion, fecha_nac) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, odontologo.getId_odontologo());
            pst.setString(2, odontologo.getEspecialidad());
            pst.setInt(3, odontologo.getHorario().getId_horario());
            pst.setInt(4, odontologo.getUsuario().getId_usuario());
            pst.setInt(5, odontologo.getId_persona());
            pst.setString(6, odontologo.getDni());
            pst.setString(7, odontologo.getNombre());
            pst.setString(8, odontologo.getApellido());
            pst.setInt(9, odontologo.getEdad());
            pst.setString(10, odontologo.getTelefono());
            pst.setString(11, odontologo.getDireccion());
            pst.setString(12, odontologo.getFecha_nac());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Odontologo obtenerPorId(int id) {
        Odontologo odontologo = null;
        String query = "SELECT * FROM odontologos WHERE id_odontologo = ?";

        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                odontologo = new Odontologo(
                        rs.getInt("id_odontologo"),
                        rs.getString("especialidad"),
                        null, // Aquí deberías obtener el Horario correspondiente por su ID
                        null, // Aquí deberías obtener el Usuario correspondiente por su ID
                        rs.getInt("id_persona"),
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("fecha_nac")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> obtenerTodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        String query = "SELECT * FROM odontologos";

        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Odontologo odontologo = new Odontologo(
                        rs.getInt("id_odontologo"),
                        rs.getString("especialidad"),
                        null, // Aquí deberías obtener el Horario correspondiente por su ID
                        null, // Aquí deberías obtener el Usuario correspondiente por su ID
                        rs.getInt("id_persona"),
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("fecha_nac")
                );
                odontologos.add(odontologo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return odontologos;
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        String query = "UPDATE odontologos SET especialidad=?, horario_id=?, usuario_id=?, id_persona=?, dni=?, nombre=?, apellido=?, edad=?, telefono=?, direccion=?, fecha_nac=? WHERE id_odontologo=?";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setString(1, odontologo.getEspecialidad());
            pst.setInt(2, odontologo.getHorario().getId_horario());
            pst.setInt(3, odontologo.getUsuario().getId_usuario());
            pst.setInt(4, odontologo.getId_persona());
            pst.setString(5, odontologo.getDni());
            pst.setString(6, odontologo.getNombre());
            pst.setString(7, odontologo.getApellido());
            pst.setInt(8, odontologo.getEdad());
            pst.setString(9, odontologo.getTelefono());
            pst.setString(10, odontologo.getDireccion());
            pst.setString(11, odontologo.getFecha_nac());
            pst.setInt(12, odontologo.getId_odontologo());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM odontologos WHERE id_odontologo=?";
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import persistencia.Odontologo;

public class OdontologoDAO {

    private Connection conexion;
    private static int id;

    public OdontologoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertarOdontologo(Odontologo odontologo) {
        try {
            String sql = "INSERT INTO odontologo (id_odontologo, especialidad, dni, apellido, telefono, direccion, fecha_nac) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
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
            String sql = "SELECT * FROM odontologo";
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String especialidad = result.getString("especialidad");
                String dni = result.getString("dni");
                String apellido = result.getString("apellido");
                String telefono = result.getString("telefono");
                String direccion = result.getString("direccion");
                String fechaNac = result.getString("fecha_nac");
                odontologos.add(new Odontologo( especialidad, null, null, null, dni, apellido, telefono, direccion, fechaNac));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return odontologos;
    }

    public void eliminarOdontologo(int idOdontologo) {
    try {
        String sql = "DELETE FROM odontologo WHERE id_odontologo = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setInt(1, idOdontologo);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void editarOdontologo(Odontologo odontologo) {
    try {
        String sql = "UPDATE odontologo SET especialidad = ?, dni = ?, apellido = ?, telefono = ?, direccion = ?, fecha_nac = ? WHERE id_odontologo = ?";
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
        String sql = "SELECT * FROM odontologo WHERE id_odontologo = ?";
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

public static int obtenerUltimoIdInsertado(Connection conexion) throws Exception {
        int ultimoId = -1;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conexion.createStatement();
            String query = "SELECT LAST_INSERT_ID()"; // Esto es para MySQL, adapta para tu sistema de gestión de bases de datos
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                ultimoId = rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }

        return ultimoId;
    }
}
*/