package persistencia;


public class Odontologo extends Persona{
    // Atributos
    private int id_odontologo;
    private String especialidad;
    private Horario horario;
    private Usuario usuario; // Referencia a la clase Usuario

    // Constructor

    public Odontologo(int id_persona, String dni, String nombre, String apellido, int edad, String telefono, String direccion, String fecha_nac) {
        super(id_persona, dni, nombre, apellido, edad, telefono, direccion, fecha_nac);
    }

    public Odontologo(int id_odontologo, String especialidad, Horario horario, Usuario usuario, int id_persona, String dni, String nombre, String apellido, int edad, String telefono, String direccion, String fecha_nac) {
        super(id_persona, dni, nombre, apellido, edad, telefono, direccion, fecha_nac);
        this.id_odontologo = id_odontologo;
        this.especialidad = especialidad;
        this.horario = horario;
        this.usuario = usuario;
    }

    public Odontologo(String especialidad, Horario horario, Usuario usuario, int id_persona, String dni, String nombre, String apellido, int edad, String telefono, String direccion, String fecha_nac) {
        super(id_persona, dni, nombre, apellido, edad, telefono, direccion, fecha_nac);
        this.especialidad = especialidad;
        this.horario = horario;
        this.usuario = usuario;
    }
    
    // Métodos getter y setter para acceder a los atributos
    public int getId_odontologo() {
        return id_odontologo;
    }

    public void setId_odontologo(int id_odontologo) {
        this.id_odontologo = id_odontologo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Otros métodos que puedas necesitar para la clase Odontologo
}
