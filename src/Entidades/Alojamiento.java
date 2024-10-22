/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;


/**
 *
 * @author Santiago Lara
 */
public class Alojamiento {
    private int codAlojam;
    private String nombreAlojamiento;
    private String tipo;
    private int capacidad;
    private int habitaciones;
    private int banios;
    private double precioNoche;

    public Alojamiento(int codAlojam, String nombreAlojamiento, String tipo, int capacidad, int habitaciones, int banios, double precioNoche) {
        this.codAlojam = codAlojam;
        this.nombreAlojamiento = nombreAlojamiento;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.habitaciones = habitaciones;
        this.banios = banios;
        this.precioNoche = precioNoche;
    }

    public int getCodAlojam() {
        return codAlojam;
    }

    public void setCodAlojam(int codAlojam) {
        this.codAlojam = codAlojam;
    }

    public String getNombreAlojamiento() {
        return nombreAlojamiento;
    }

    public void setNombreAlojamiento(String nombreAlojamiento) {
        this.nombreAlojamiento = nombreAlojamiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getBanios() {
        return banios;
    }

    public void setBanios(int banios) {
        this.banios = banios;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    
    
    
    
}
