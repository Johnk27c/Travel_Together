
package Persistencia;

import Entidades.Ciudad;
import Entidades.Pasaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Santiago Lara
 */
public class PasajeData {
    
    private Connection conexion = null;
    
    public  PasajeData(){
        conexion = Conexion.getConexion();
    }
    
    public Pasaje buscarPasaje(int codPasaje){
        String sql = "SELECT codPasaje, fechaHora, idCiudad_Origen, idCiudad_Destino, asiento, transporte, precio "
                + "FROM pasaje WHERE codPasaje = ?";
        Pasaje pasaje = null;
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, codPasaje);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                pasaje = new Pasaje();
                pasaje.setCodPasaje(rs.getInt("codPasaje"));
                pasaje.setFechaHora(rs.getTimestamp("fecharHora").toLocalDateTime());
                Ciudad ciudadOrigen = new Ciudad();
                ciudadOrigen.setCodCiudad(rs.getInt("idCiudad_Origen"));
                pasaje.setCiudadOrigen(ciudadOrigen);

                Ciudad ciudadDestino = new Ciudad();
                ciudadDestino.setCodCiudad(rs.getInt("idCiudad_Destino"));
                pasaje.setCiudadDestino(ciudadDestino);
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setTransporte(rs.getString("transporte"));
                pasaje.setPrecio(rs.getDouble("precio"));
                
            } else{
                JOptionPane.showMessageDialog(null, "No se encontró pasaje con el codigo ingresado");
                        }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla pasaje");
        }
        return pasaje;
    }
    
    public void modificarPasaje(Pasaje pasaje){
        String sql = "UPDATE pasaje SET fechaHora = ?, idCiudad_Origen = ?, idCiudad_Destino = ?, asiento = ?, transporte = ?,"
                + " precio = ? WHERE codPasaje = ?";
        try{
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setTimestamp(1, Timestamp.valueOf(pasaje.getFechaHora()));
        ps.setInt(2, pasaje.getCiudadOrigen().getCodCiudad());
        ps.setInt(3, pasaje.getCiudadDestino().getCodCiudad());
        ps.setInt(4, pasaje.getAsiento());
        ps.setString(5, pasaje.getTransporte());
        ps.setDouble(6, pasaje.getPrecio());
            int exito = ps.executeUpdate();
            if (exito > 0) {
                JOptionPane.showMessageDialog(null, "El alojamiento ha sido modificado con éxito.");
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pasaje");
        }
    }
    public void eliminarPasaje(int codPasaje){
        String sql = "DELETE FROM pasaje WHERE codPasaje = ?";
        
        try {
            PreparedStatement ps =conexion.prepareStatement(sql);
            ps.setInt(1,codPasaje);
            
             int fila = ps.executeUpdate();
             if(fila >0 ){
                 JOptionPane.showMessageDialog(null, "Pasaje eliminado correctamente");
             }else{
                 JOptionPane.showMessageDialog(null, "No se ha encontró pasaje con el codigo ingresado");
             }
             ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla pasaje");
        }
                
    }
}
