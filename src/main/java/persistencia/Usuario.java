
package persistencia;

public class Usuario {
    private int id_usuario;
    private String nombre_usuario;
    private String contrasenia;
    private String rol;
    private String id_odontologo;
    private String id_secretario;

    public Usuario(){
    }

    public Usuario(int id_usuario, String nombre_usuario, String contrasenia, String rol, String id_odontologo, String id_secretario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.id_odontologo = id_odontologo;
        this.id_secretario = id_secretario;
    }
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getId_odontologo() {
        return id_odontologo;
    }

    public void setId_odontologo(String id_odontologo) {
        this.id_odontologo = id_odontologo;
    }

    public String getId_secretario() {
        return id_secretario;
    }

    public void setId_secretario(String id_secretario) {
        this.id_secretario = id_secretario;
    }
    
    
}
