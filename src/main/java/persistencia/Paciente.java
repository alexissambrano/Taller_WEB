package persistencia;


public class Paciente {
    // Atributos
    private int id_paciente;
    private String seguro;
    private String tipo_sangre;
    private Responsable responsable; // Referencia a la clase Responsable

    // Constructor
    public Paciente(int id_paciente, String seguro, String tipo_sangre, Responsable responsable) {
        this.id_paciente = id_paciente;
        this.seguro = seguro;
        this.tipo_sangre = tipo_sangre;
        this.responsable = responsable;
    }

    // Métodos getter y setter para acceder a los atributos
    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    // Otros métodos que puedas necesitar para la clase Paciente
}
