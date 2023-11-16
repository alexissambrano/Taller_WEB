/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

public class Secretario {
    // Atributos
    private int id_secretario;
    private String sector;
    private Usuario usuario; // Referencia a la clase Usuario

    // Constructor
    public Secretario(int id_secretario, String sector, Usuario usuario) {
        this.id_secretario = id_secretario;
        this.sector = sector;
        this.usuario = usuario;
    }

    // Métodos getter y setter para acceder a los atributos
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Otros métodos que puedas necesitar para la clase Secretario
}
