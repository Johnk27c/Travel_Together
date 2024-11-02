
package Persistencia;

import Entidades.Pasaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
    
    public void buscarPasaje(int codPasaje){
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
                
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla pasaje");
        }
    }
    
    public void modificarPasaje(){
        String sql = "INSERT into pasaje ()";
    }
    public void eliminarPasaje(){
        String sql = "DELETE FROM pasaje WHERE codPasaje = ?";
        
        try {
            PreparedStatement ps =conexion.prepareStatement(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla pasaje");
        }
                
    }
}
