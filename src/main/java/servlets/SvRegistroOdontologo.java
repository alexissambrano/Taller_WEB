
package servlets;
import DAO.Conexion;
import DAO.OdontologoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import persistencia.Odontologo;


@WebServlet(name = "SvRegistroOdontologo", urlPatterns = {"/SvRegistroOdontologo"})
public class SvRegistroOdontologo extends HttpServlet {
    
    // Obtén una conexión válida
    Connection conexion = Conexion.obtenerConexion();
    
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
        // Obtiene los datos del formulario
        String especialidad = request.getParameter("especialidad");
        String dni = request.getParameter("dni");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String fecha_nac = request.getParameter("fecha_nac");
        
        
        
        // Crea un nuevo objeto Odontologo con los datos
        Odontologo odontologo = new Odontologo();
        odontologo.setId_odontologo(11);
        odontologo.setEspecialidad(especialidad);
        odontologo.setDni(dni);
        odontologo.setApellido(apellido);
        odontologo.setTelefono(telefono);
        odontologo.setDireccion(direccion);
        odontologo.setFecha_nac(fecha_nac);
        
        
        // Inserta el odontólogo en la base de datos
        OdontologoDAO odontologoDAO = new OdontologoDAO(conexion); // Asegúrate de que tu DAO esté correctamente configurado
        odontologoDAO.insertarOdontologo(odontologo);
        
        // Obtiene la lista de odontólogos de la base de datos
        List<Odontologo> listaOdontologos = odontologoDAO.obtenerOdontologos();
        
        // Establece la lista en el ámbito de la solicitud
        request.setAttribute("listaOdontologos", listaOdontologos);
        
        // Redirige a la página ver_odontologos.jsp
        request.getRequestDispatcher("ver_odontologos.jsp").forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}