
package persistencia;

public class Usuario {
    // Atributos
    private int id_usuario;
    private String username;
    private String password;
    private String rol;

    // Constructor
    public Usuario(int id_usuario, String username, String password, String rol) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    // Métodos getter y setter para acceder a los atributos
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Otros métodos que puedas necesitar para la clase Usuario
}

