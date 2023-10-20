
package servlets;

import DAO.Conexion;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Controladora;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {
    
    // Obtén una conexión válida
    Connection conexion = Conexion.obtenerConexion();

    // Crea una instancia de UsuarioDAO y proporciona la conexión
    UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);

    // Crea una instancia de Controladora y proporciona la instancia de UsuarioDAO
    Controladora control = new Controladora(usuarioDAO);
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Obtenemos los valores del formulario
        String username = request.getParameter("username");
        String password = request.getParameter("contrasenia");
        
        // Aquí debes agregar la lógica de autenticación.
        // Comprueba si las credenciales son válidas, por ejemplo, comparándolas con una base de datos de usuarios.
        boolean isAuthenticated = control.login(username, password);

        
        
        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedIn", true);
            // Autenticación exitosa, redirige a la página de inicio.
            response.sendRedirect("registrar_cita.jsp");
        } else {
            // Autenticación fallida, redirige nuevamente a la página de inicio de sesión con un mensaje de error.
            response.sendRedirect("login_error.jsp");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean yourAuthenticationLogic(String username, String password) {
        // Compara las credenciales con un usuario y contraseña por defecto.
        // Cambia estos valores por los que desees.
        //String usuarioPorDefecto = "admin";
        //String contraseniaPorDefecto = "admin";
        //return username.equals(usuarioPorDefecto) && password.equals(contraseniaPorDefecto);
        String dbUrl = "jdbc:mysql://localhost:3306/clinica_odonto"; // Cambia esto por la URL de tu base de datos
        String dbUser = "root"; // Cambia esto por tu usuario de base de datos
        String dbPassword = "kira123"; // Cambia esto por tu contraseña de base de datos

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        // Cargar el controlador JDBC
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establecer la conexión a la base de datos
        conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

        // Consulta para verificar las credenciales
        String sql = "SELECT * FROM usuarios WHERE username ='kira' AND contrasenia ='kira'";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        rs = pstmt.executeQuery();

        // Si la consulta devuelve resultados, las credenciales son válidas
        return rs.next();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
        // Manejo de errores
        return false;
    } finally {
        // Cerrar recursos
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

}
