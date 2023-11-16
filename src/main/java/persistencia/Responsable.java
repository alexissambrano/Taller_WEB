/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;


/**
 *
 * @author noroot
 */
public class Responsable {
    // Atributos
    private int id_responsable;
    private String tipo_resp;

    // Constructor
    public Responsable(int id_responsable, String tipo_resp) {
        this.id_responsable = id_responsable;
        this.tipo_resp = tipo_resp;
    }

    // Métodos getter y setter para acceder a los atributos
    public int getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }

    public String getTipo_resp() {
        return tipo_resp;
    }

    public void setTipo_resp(String tipo_resp) {
        this.tipo_resp = tipo_resp;
    }

    // Otros métodos que puedas necesitar para la clase Responsable
}

