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
    
    private UsuarioDAO usuarioDAO;

    public Controladora(UsuarioDAO usuario) {
        this.usuarioDAO = usuario;
    }
    
    public boolean login(String username,String password){
        List<Usuario> usuarios = new ArrayList<>();
        boolean valida=false;
        usuarios = usuarioDAO.obtenerTodos();
        
        
        for (Usuario usern:usuarios){
            valida = username.equals(usern.getUsername()) && password.equals(usern.getPassword());
            if(valida)
                break;
        }
        
        return valida;
    }
    
}
