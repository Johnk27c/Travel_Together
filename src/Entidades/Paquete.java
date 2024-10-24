package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Jara
 */
public class Paquete {
    private int codPaquete;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private Pasaje boleto;
    private Estadia estadia;
    private Pension regimen;
    private ArrayList<Turista> turistas;
    double montoFinal;
    double precioTraslados;

    public Paquete (int codPaquete, LocalDate fechaIni, LocalDate fechaFin, Pasaje boleto, Estadia estadia, Pension regimen, ArrayList<Turista> turistas, double montoFinal, double precioTraslados) {
        this.codPaquete = codPaquete;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.boleto = boleto;
        this.estadia = estadia;
        this.regimen = regimen;
        this.turistas = turistas;
        this.montoFinal = montoFinal;
        this.precioTraslados = precioTraslados;
    }

    public int getCodPaquete() {
        return codPaquete;
    }

    public void setCodPaquete(int codPaquete) {
        this.codPaquete = codPaquete;
    }

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Pasaje getBoleto() {
        return boleto;
    }

    public void setBoleto(Pasaje boleto) {
        this.boleto = boleto;
    }

    public Estadia getEstadia() {
        return estadia;
    }

    public void setEstadia(Estadia estadia) {
        this.estadia = estadia;
    }

    public Pension getRegimen() {
        return regimen;
    }

    public void setRegimen(Pension regimen) {
        this.regimen = regimen;
    }

    public ArrayList<Turista> getTuristas() {
        return turistas;
    }

    public void setTuristas(ArrayList<Turista> turistas) {
        this.turistas = turistas;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public double getPrecioTraslados() {
        return precioTraslados;
    }

    public void setPrecioTraslados(double precioTraslados) {
        this.precioTraslados = precioTraslados;
    }
    
    
}
