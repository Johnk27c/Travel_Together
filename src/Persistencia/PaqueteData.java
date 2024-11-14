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
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Jon_kevin27
 */
public class PaqueteData {
    private Connection conexion = null;
    private TuristaData accesoTurista = new TuristaData();
    private PasajeData accesoPasaje = new PasajeData();
    
    
    public PaqueteData() {
        conexion = Conexion.getConexion();
    }

    public void guardarPaquete(Paquete paquete) {

        String sql = "INSERT INTO paquete (fechaIni, fechaFin, fechaCompra, boleto, temporada, estadia, regimen, dniTurista, dniComprador, montofinal, precioTraslados, tipo) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setString(1, paquete.getFechaFin().toString());
            ps.setString(2, paquete.getFechaFin().toString());
            ps.setString(3, paquete.getFechaCompra().toString());            
            ps.setInt(4, paquete.getBoleto().getCodPasaje());
            ps.setString(5, paquete.getTemporada());           
            ps.setInt(6, paquete.getEstadia().getCodEstadia());
            ps.setInt(7, paquete.getRegimen().getCodAdicional());
            ps.setInt(8, paquete.getTurista().getDni());
            ps.setInt(9, paquete.getComprador().getDni());
            ps.setDouble(10, paquete.getMontoFinal());
            ps.setDouble(11, paquete.getPrecioTraslados());
            ps.setString(12, paquete.getTipo());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El paquete ha sido cargado con éxito.");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paquete de la base de datos.");
        }
    }
    
    public void modificarPaquete(Paquete paquete) {    

        String sql = "UPDATE paquete SET boleto = ?, estadia = ?, regimen = ?, montofinal = ?, precioTraslados = ? "
                + "WHERE codPaquete = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, paquete.getBoleto().getCodPasaje());
            ps.setInt(2, paquete.getEstadia().getCodEstadia());
            ps.setInt(3, paquete.getRegimen().getCodAdicional());
            ps.setDouble(4, paquete.getMontoFinal());
            ps.setDouble(5, paquete.getPrecioTraslados());
            ps.setInt(6, paquete.getCodPaquete());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El paquete ha sido cargado con éxito.");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paquete de la base de datos.");
        }
    }
    
   
    
    
    public void eliminarPaquete(int codPaquete) {

        String sql = "DELETE FROM paquete WHERE codPaquete = ? ";

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
        String sql = "SELECT codPaquete, fechaIni, fechaFin, fechaCompra, boleto, temporada, estadia, regimen, dniTurista, dniComprador, montofinal, precioTraslados, tipo "
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
    
    public ArrayList<Paquete> buscarCompradorDni(int dniComprador){
        
        String sql = "SELECT codPaquete, dniTurista, tipo, boleto, fechaCompra "
                + "FROM paquete WHERE dniComprador = ?";
        
        ArrayList<Paquete> listaDePaquetes = new ArrayList();
        try{
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, dniComprador);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Paquete paquete = new Paquete();
            paquete.setCodPaquete(rs.getInt("codPaquete"));
            paquete.setTurista(accesoTurista.buscarTuristaPorDNI(rs.getInt("dniTurista")));
            paquete.setTipo(rs.getString("tipo"));
            paquete.setBoleto(accesoPasaje.buscarPasaje(rs.getInt("boleto")));
            paquete.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
            listaDePaquetes.add(paquete);
            
        }
        
        }catch (SQLException ex){
             JOptionPane.showMessageDialog(null, "Error al acceder a tabla paquete");
        }
        return listaDePaquetes;
        
    }
    
    
    
    
}
