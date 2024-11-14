/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Paquete;
import Entidades.Turista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
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
    private PensionData accesoPension = new PensionData();
    private EstadiaData accesoEstadia = new EstadiaData();
    
    
    
    public PaqueteData() {
        conexion = Conexion.getConexion();
    }

    public void guardarPaquete(Paquete paquete) {

        String sql = "INSERT INTO paquete (fechaIni, fechaFin, fechaCompra, boleto, temporada, estadia, regimen, dniTurista, dniComprador, montofinal, precioTraslado, tipo) "
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

        String sql = "UPDATE paquete SET boleto = ?, estadia = ?, regimen = ?, montofinal = ?, precioTraslado = ? "
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
    
    public Paquete buscarPaquete(int codPaquete){
        String sql = "SELECT codPaquete, fechaIni, fechaFin, fechaCompra, boleto, temporada, estadia, regimen, dniTurista, dniComprador, montofinal, precioTraslado, tipo "
                + "FROM paquete WHERE codPaquete = ?";
       
        Paquete paquete = new Paquete();
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, codPaquete);           
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                paquete.setCodPaquete(rs.getInt("codPaquete"));
                paquete.setFechaIni(rs.getDate("fechaIni").toLocalDate());
                paquete.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                paquete.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                paquete.setBoleto(accesoPasaje.buscarPasaje(rs.getInt("boleto")));
                paquete.setTemporada(rs.getString("temporada"));
                paquete.setEstadia(accesoEstadia.buscarEstadiaPorCodigo(rs.getInt("estadia")));
                paquete.setRegimen(accesoPension.buscarPorCodigo(rs.getInt("regimen")));
                paquete.setTurista(accesoTurista.buscarTuristaPorDNI(rs.getInt("dniTurista")));
                paquete.setComprador(accesoTurista.buscarTuristaPorDNI(rs.getInt("dniComprador")));
                paquete.setMontoFinal(rs.getDouble("montoFinal"));
                paquete.setPrecioTraslados(rs.getDouble("precioTraslado"));
                paquete.setTipo(rs.getString("tipo"));
                
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla paquete");
        }
        return paquete;
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
    public void agregarTuristaAlPaquete(Paquete paquete, Turista turista) {
    String sql = "UPDATE paquete SET dniTurista = ? WHERE codPaquete = ?";

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, turista.getDni());  
        ps.setInt(2, paquete.getCodPaquete()); 

        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "El turista ha sido agregado al paquete exitosamente.");
        ps.close();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al acceder a tabla paquete");
    }
}
    
    
    
}
