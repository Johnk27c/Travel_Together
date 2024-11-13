/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Paquete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jon_kevin27
 */
public class PaqueteData {
    private Connection conexion = null;

    public PaqueteData() {
        conexion = Conexion.getConexion();
    }

    public void guardarPaquete(Paquete paquete) {

        String sql = "INSERT INTO paquete (codPaquete, fechaIni, fechaFin, fechaCompra, boleto, temporada, estadia, regimen, dniTurista, dniComprador, montofinal, precioTraslados)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, paquete.getCodPaquete());
            ps.setString(2, paquete.getFechaFin().toString());
            ps.setString(3, paquete.getFechaFin().toString());
            ps.setString(4, paquete.getFechaCompra().toString());            
            ps.setInt(5, paquete.getBoleto().getCodPasaje());
            ps.setString(6, paquete.getTemporada());           
            ps.setInt(7, paquete.getEstadia().getCodEstadia());
            ps.setInt(8, paquete.getRegimen().getCodAdicional());
            ps.setInt(9, paquete.getTurista().getDni());
            ps.setInt(10, paquete.getComprador().getDni());
            ps.setDouble(11, paquete.getMontoFinal());
            ps.setDouble(12, paquete.getPrecioTraslados());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El paquete ha sido cargado con éxito.");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paquete de la base de datos.");
        }
    }
    
    public void modificarPaquete(Paquete paquete) {    

        String sql = "UPDATE paquete SET codPaquete  = ?, fechaIni = ?, fechaFin = ?, fechaCompra = ?, boleto = ?, temporada = ?, estadia = ?, regimen = ?, dniTurista = ?, dniComprador = ?, montofinal = ?, precioTraslados = ? "
                + "WHERE codPaquete = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, paquete.getCodPaquete());
            ps.setString(2, paquete.getFechaFin().toString());
            ps.setString(3, paquete.getFechaFin().toString());
            ps.setString(4, paquete.getFechaCompra().toString());            
            ps.setInt(5, paquete.getBoleto().getCodPasaje());
            ps.setString(6, paquete.getTemporada());           
            ps.setInt(7, paquete.getEstadia().getCodEstadia());
            ps.setInt(8, paquete.getRegimen().getCodAdicional());
            ps.setInt(9, paquete.getTurista().getDni());
            ps.setInt(10, paquete.getComprador().getDni());
            ps.setDouble(11, paquete.getMontoFinal());
            ps.setDouble(12, paquete.getPrecioTraslados());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El paquete ha sido cargado con éxito.");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paquete de la base de datos.");
        }
    }
    
    public void eliminarPaquete(int codPaquete) {

        String sql = "DELETE FROM paquete WHERE codPaquete = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, codPaquete);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El paquete ha sido eliminado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado un paquete con el código indicado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paquete de la base de datos.");
        }
    }
    
    public void buscarPaquete(int codPaquete){
        String sql = "SELECT codPaquete, fechaIni, fechaFin, boleto, estadia, regimen, dniTurista, dniComprador, montofinal, precioTraslados "
                + "FROM paquete WHERE codPaquete = ?";
        Paquete paquete = null;
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, codPaquete);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                paquete = new Paquete();
                paquete.setCodPaquete(rs.getInt("codPaquete"));
                
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla paquete");
        }
    }
}
