/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.Date;

/**
 *
 * @author noroot
 */
public class Secretario extends Persona{
    private int id_secretario;
    private String sector;
    private Usuario unUsuario;

    public Secretario() {
    }

    public Secretario(int id_secretario, String sector, Usuario unUsuario, String dni, String apellido, String telefono, String direccion, String fecha_nac) {
        super(dni, apellido, telefono, direccion, fecha_nac);
        this.id_secretario = id_secretario;
        this.sector = sector;
        this.unUsuario = unUsuario;
    }

    public int getId_secretario() {
        return id_secretario;
    }

    public void setId_secretario(int id_secretario) {
        this.id_secretario = id_secretario;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }
    
    
}
