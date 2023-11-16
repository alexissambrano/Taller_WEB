
package persistencia;

public class Cita {
    // Atributos
    private int id_cita;
    private String fecha_turno;
    private String hora_turno;
    private String afeccion;
    private Odontologo odontologo; // Referencia a la clase Odontologo
    private Paciente paciente;     // Referencia a la clase Paciente

    // Constructor
    public Cita(int id_cita, String fecha_turno, String hora_turno, String afeccion, Odontologo odontologo, Paciente paciente) {
        this.id_cita = id_cita;
        this.fecha_turno = fecha_turno;
        this.hora_turno = hora_turno;
        this.afeccion = afeccion;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    // Métodos getter y setter para acceder a los atributos
    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public String getFecha_turno() {
        return fecha_turno;
    }

    public void setFecha_turno(String fecha_turno) {
        this.fecha_turno = fecha_turno;
    }

    public String getHora_turno() {
        return hora_turno;
    }

    public void setHora_turno(String hora_turno) {
        this.hora_turno = hora_turno;
    }

    public String getAfeccion() {
        return afeccion;
    }

    public void setAfeccion(String afeccion) {
        this.afeccion = afeccion;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    // Otros métodos que puedas necesitar para la clase Cita
}
