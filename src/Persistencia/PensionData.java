/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import Entidades.Pension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Franco
 */
public class PensionData {
 
    private Connection conexion = null;

    public PensionData() {
        conexion = Conexion.getConexion();
    }

    
    
    public void buscarPorCodigo(int codAdicional){
        String sql = "SELECT codAdicional, nombre, porcentaje FROM pension where codAdicional = ? ";
        Pension pension = null;
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, codAdicional);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pension = new Pension();
                pension.setCodAdicional(rs.getInt("codAdicional"));
                pension.setNombre(rs.getString("nombre"));
                pension.setPorcentaje(rs.getDouble("porcentaje"));
                                           
            }else{
                JOptionPane.showMessageDialog(null, "No existe una pension con el codigo ingresado.");
            }
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pension.");
        }       
    }
    
    
    
    public void modificarPension(Pension pension){
        String sql = "UPDATE pension SET nombre = ?, porcentaje = ? "
                + "WHERE codAdicional = ? ";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, pension.getNombre());
            ps.setDouble(2, pension.getCodAdicional());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "La pension ha sido modificada con exito.");
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pension en la base de datos.,");
        }
    }
    
    
    
    public void guardarPension(Pension pension){
        String sql = "INSERT into pension (codAdicional, nombre, porcentaje) "
                + "VALUES(?, ?, ?)";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, pension.getCodAdicional());
            ps.setString(2, pension.getNombre());
            ps.setDouble(3, pension.getPorcentaje());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "La pension se guardo con exito.");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pension.");
        }
    }
         
    
    
    
    public void eliminarPension(int codAdicional){
        String sql = "DELETE FROM turista Where codAdicional = ? ";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, codAdicional);
            int exito = ps.executeUpdate();
            if (exito == 1){
                JOptionPane.showMessageDialog(null, "Pension eliminada con exito.");
            }else{
                JOptionPane.showConfirmDialog(null, "No existe una pension con el codigo ingresado");
            }
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pension.");
        }
    }
    
    public HashSet<String> listarPensiones() {
        HashSet<String>listaPensiones = new HashSet();
        String sql = "SELECT nombre FROM pension ";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listaPensiones.add(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pension");
        }
        return listaPensiones;
    }
       
}
