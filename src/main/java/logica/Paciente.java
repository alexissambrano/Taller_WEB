package logica;

import java.util.Date;
import java.util.List;

public class Paciente extends Persona{
    private int id_paciente;
    private boolean tiene_OS;
    private String tipoSangre;
    private Responsable unResponsable;
    private List<Turno> listaTurnos;

    public Paciente() {
    }

    public Paciente(int id_paciente, boolean tiene_OS, String tipoSangre, Responsable unResponsable, List<Turno> listTurnos, String dni, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(dni, apellido, telefono, direccion, fecha_nac);
        this.id_paciente = id_paciente;
        this.tiene_OS = tiene_OS;
        this.tipoSangre = tipoSangre;
        this.unResponsable = unResponsable;
        this.listaTurnos = listaTurnos;
    }

    public Responsable getUnResponsable() {
        return unResponsable;
    }

    public void setUnResponsable(Responsable unResponsable) {
        this.unResponsable = unResponsable;
    }

    public List<Turno> getListTurnos() {
        return listaTurnos;
    }

    public void setListTurnos(List<Turno> listTurnos) {
        this.listaTurnos = listTurnos;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public boolean isTiene_OS() {
        return tiene_OS;
    }

    public void setTiene_OS(boolean tiene_OS) {
        this.tiene_OS = tiene_OS;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    
    
    
}
