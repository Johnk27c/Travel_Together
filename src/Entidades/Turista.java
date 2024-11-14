
package Entidades;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Franco
 */
public class Turista {   
    private int dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;

    public Turista(int dni, String nombre, String apellido, LocalDate fechaNac) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }

    public Turista() {
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

        public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
    public int calcularEdad() {
    if (fechaNac != null) {
        return Period.between(fechaNac, LocalDate.now()).getYears();
    }
    return 0; 
}
    @Override
    public String toString() {
        return "Turista{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "fechaNacimiento=" + fechaNac + '}';
    }

    
}
