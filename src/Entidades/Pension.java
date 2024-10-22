/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Franco
 */
public class Pension {   
    private int codAdicional;
    private String nombre;
    private double porcentaje;

    public Pension(int codAdicional, String nombre, double porcentaje) {
        this.codAdicional = codAdicional;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public int getCodAdicional() {
        return codAdicional;
    }

    public void setCodAdicional(int codAdicional) {
        this.codAdicional = codAdicional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}
