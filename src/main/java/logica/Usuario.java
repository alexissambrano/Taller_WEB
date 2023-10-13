
package logica;

public class Usuario {
    private int id_usuario;
    private String contresenia;
    private String rol;

    public Usuario(){
    }
    
    public Usuario(int id_usuario, String contresenia, String rol) {
        this.id_usuario = id_usuario;
        this.contresenia = contresenia;
        this.rol = rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getContresenia() {
        return contresenia;
    }

    public void setContresenia(String contresenia) {
        this.contresenia = contresenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
}
