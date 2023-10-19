/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author alons
 */
public class Controladora {

    public Controladora() {
    }
    
    public boolean login(String user,String pass){
        return user.equals("admin") && pass.equals("admin");
    }
}
