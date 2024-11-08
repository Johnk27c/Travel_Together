/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class CiudadData {

    private Connection conexion = null;

    public CiudadData() {
        conexion = Conexion.getConexion();
    }

    public void guardarCiudad(Ciudad ciudad) {
        String sql = "INSERT INTO ciudad (codCiudad , nombre )"
                + "VALUES (?,?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, ciudad.getCodCiudad());
            ps.setString(2, ciudad.getNombre());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "La ciudad ha sido cargada con exito");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ciudad");
        }
    }

    public void modificarCiudad(Ciudad ciudad) {
        String sql = "UPDATE ciudad SET nombre = ? "
                + "WHERE codCiudad = ? ";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, ciudad.getNombre());
            ps.setInt(2, ciudad.getCodCiudad());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "La ciudad ha sido modificada con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ciudad");
        }
    }

    public void eliminarCiudad(int codCiudad) {
        String sql = "DELETE FROM ciudad WHERE codCiudad = ? ";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, codCiudad);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "La ciudad ha sido eliminada con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro ciudad con el Codigo indicado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ciudad");

        }
    }
    
    public ArrayList<Integer> listarCiudades() {
        ArrayList<Integer> ListaCiudades = new ArrayList();
        String sql = "SELECT codCiudad FROM ciudad ";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
          
            while (rs.next()) {
                ListaCiudades.add(rs.getInt("codCiudad"));
                 } 
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ciudad");
        }
        return ListaCiudades;
    } 
}
