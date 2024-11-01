package Entidades;

import java.time.LocalDate;

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
    private Turista turista;
    private Turista comprador;
    double montoFinal;
    double precioTraslados;

    public Paquete(int codPaquete, LocalDate fechaIni, LocalDate fechaFin, Pasaje boleto, Estadia estadia, Pension regimen, Turista turista, Turista comprador, double montoFinal, double precioTraslados) {
        this.codPaquete = codPaquete;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.boleto = boleto;
        this.estadia = estadia;
        this.regimen = regimen;
        this.turista = turista;
        this.comprador = comprador;
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

    public Turista getTurista() {
        return turista;
    }

    public void setTurista(Turista turista) {
        this.turista = turista;
    }

    public Turista getComprador() {
        return comprador;
    }

    public void setComprador(Turista comprador) {
        this.comprador = comprador;
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
