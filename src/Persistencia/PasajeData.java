
package Persistencia;

import Entidades.Pasaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.swing.JOptionPane;


/**
 * @author Santiago Lara
 */
public class PasajeData {
    
    private Connection conexion = null;
    private CiudadData accesoCiudad = new CiudadData();
    
    public  PasajeData(){
        conexion = Conexion.getConexion();
    }
    
    public void guardarPasaje(Pasaje pasaje) {
        String sql = "INSERT INTO pasaje (fechaHora, idCiudad_Origen, idCiudad_Destino, transporte, precio )"
                + "VALUES (? , ? , ? , ? , ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, Timestamp.valueOf(pasaje.getFechaHora()));
            ps.setInt(2, pasaje.getCiudadOrigen().getCodCiudad());
            ps.setInt(3, pasaje.getCiudadDestino().getCodCiudad());
            ps.setString(4, pasaje.getTransporte());
            ps.setDouble(5,pasaje.getPrecio());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                pasaje.setCodPasaje(rs.getInt(1));
            JOptionPane.showMessageDialog(null, "El pasaje ha sido cargada con exito");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasaje");
        }
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
                pasaje.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                
                pasaje.setCiudadOrigen(accesoCiudad.buscarCiudadPorID(rs.getInt("idCiudad_Origen")));
                pasaje.setCiudadDestino(accesoCiudad.buscarCiudadPorID(rs.getInt("idCiudad_Destino")));
                
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
