/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import DAO.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import persistencia.Usuario;

/**
 *
 * @author alons
 */
public class Controladora {
    
    UsuarioDAO usuario = new UsuarioDAO();
    
    public Controladora() {
    }
    
    public boolean login(String user,String pass){
        List<Usuario> usuarios = new ArrayList<>();
        boolean valida=false;
        usuarios = usuario.obtenerUsuarios();
        
        
        for (Usuario usern:usuarios){
            valida = user.equals(usern.getNombre_usuario()) && pass.equals(usern.getContrasenia());
        }
        
        return valida;
    }
    
}
