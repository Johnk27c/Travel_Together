
package Entidades;

import java.time.LocalDateTime;

/**
 *
 * @author Franco
 */
public class Estadia {
    
    private int codEstadia;
    private LocalDateTime fechaHoraCheckin;
    private LocalDateTime fechaHoraCheckout;
    private Alojamiento Alojamiento;
    private double monto;
    private boolean vigencia;

    public Estadia(int codEstadia, LocalDateTime fechaHoraCheckin, LocalDateTime fechaHoraCheckout, Alojamiento Alojamiento, double monto, boolean vigencia) {
        this.codEstadia = codEstadia;
        this.fechaHoraCheckin = fechaHoraCheckin;
        this.fechaHoraCheckout = fechaHoraCheckout;
        this.Alojamiento = Alojamiento;
        this.monto = monto;
        this.vigencia = vigencia;
    }

    public int getCodEstadia() {
        return codEstadia;
    }

    public void setCodEstadia(int codEstadia) {
        this.codEstadia = codEstadia;
    }

    public LocalDateTime getFechaHoraCheckin() {
        return fechaHoraCheckin;
    }

    public void setFechaHoraCheckin(LocalDateTime fechaHoraCheckin) {
        this.fechaHoraCheckin = fechaHoraCheckin;
    }

    public LocalDateTime getFechaHoraCheckout() {
        return fechaHoraCheckout;
    }

    public void setFechaHoraCheckout(LocalDateTime fechaHoraCheckout) {
        this.fechaHoraCheckout = fechaHoraCheckout;
    }

    public Alojamiento getAlojamiento() {
        return Alojamiento;
    }

    public void setAlojamiento(Alojamiento Alojamiento) {
        this.Alojamiento = Alojamiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }
    
   
}
