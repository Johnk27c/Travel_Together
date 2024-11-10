package Entidades;

import java.util.Objects;

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

    public Ciudad() {
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

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.codCiudad;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ciudad other = (Ciudad) obj;
        if (this.codCiudad != other.codCiudad) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }
}
