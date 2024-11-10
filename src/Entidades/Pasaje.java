package Entidades;

import java.time.LocalDateTime;

/**
 *
 * @author Usuario
 */
public class Pasaje {
    private int codPasaje;
    private LocalDateTime fechaHora;
    private Ciudad ciudadOrigen;
    private Ciudad ciudadDestino;
    private int asiento;
    private String transporte;
    private double precio;

    public Pasaje(){
    }
    
    public Pasaje(int codPasaje, LocalDateTime fechaHora, Ciudad ciudadOrigen, Ciudad ciudadDestino, int asiento, String transporte, double precio) {
        this.codPasaje = codPasaje;
        this.fechaHora = fechaHora;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.asiento = asiento;
        this.transporte = transporte;
        this.precio = precio;
    }

    public int getCodPasaje() {
        return codPasaje;
    }

    public void setCodPasaje(int codPasaje) {
        this.codPasaje = codPasaje;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(Ciudad ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
