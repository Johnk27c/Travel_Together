package Entidades;

/**
 *
 * @author Usuario
 */
public class Ciudad {

    private int codCiudad;
    private String nombre;

    public Ciudad(int codCiudad, String nombre) {
        this.codCiudad = codCiudad;
        this.nombre = nombre;
    }

    public int getCodCiudad() {
        return codCiudad;
    }
    
    public void setCodCiudad(int codCiudad) {
        this.codCiudad = codCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
