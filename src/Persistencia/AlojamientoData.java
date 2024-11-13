/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Alojamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Jon_kevin27
 */
public class AlojamientoData {

    private Connection conexion = null;

    public AlojamientoData() {
        conexion = Conexion.getConexion();
    }

    public void guardarAlojamiento(Alojamiento alojamiento) {

        String sql = "INSERT INTO alojamiento (codAlojamiento, nombreAlojamiento, tipo, direccion, codCiudad, capacidad, habitaciones, banios, precio)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, alojamiento.getCodAlojam());
            ps.setString(2, alojamiento.getNombreAlojamiento());
            ps.setString(3, alojamiento.getTipo());
            ps.setString(4, alojamiento.getDireccion());
            ps.setInt(5, alojamiento.getCiudad().getCodCiudad());
            ps.setInt(6, alojamiento.getCapacidad());
            ps.setInt(7, alojamiento.getHabitaciones());
            ps.setInt(8, alojamiento.getBanios());
            ps.setDouble(9, alojamiento.getPrecioNoche());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El alojamiento ha sido cargado con éxito.");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alojamiento de la base de datos.");
        }
    }

    public void modificarAlojamiento(Alojamiento alojamiento) {

        String sql = "UPDATE alojamiento SET nombreAlojamiento = ?, tipo = ?, direccion = ?, codCiudad = ?, capacidad = ?, habitaciones = ?, banios = ?, precio = ? "
                + "WHERE codAlojamiento = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, alojamiento.getCodAlojam());
            ps.setString(2, alojamiento.getNombreAlojamiento());
            ps.setString(3, alojamiento.getTipo());
            ps.setString(4, alojamiento.getDireccion());
            ps.setInt(5, alojamiento.getCiudad().getCodCiudad());
            ps.setInt(6, alojamiento.getCapacidad());
            ps.setInt(7, alojamiento.getHabitaciones());
            ps.setInt(8, alojamiento.getBanios());
            ps.setDouble(9, alojamiento.getPrecioNoche());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El alojamiento ha sido modificado con éxito.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alojamiento de la base de datos.");
        }
    }

    public void eliminarAlojamiento(int codAlojamiento) {

        String sql = "DELETE FROM alojamiento WHERE codAlojamiento = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, codAlojamiento);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El alojamiento ha sido eliminado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado un alojamiento con el código indicado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alojamiento de la base de datos.");
        }
    }
    
    
    
    public HashSet<Integer> mostrarCiudades() {

        String sql = "SELECT codCiudad FROM alojamiento ";
        
        HashSet<Integer>ciudades= new HashSet <>();
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ResultSet res= ps.executeQuery();
            while (res.next()) {
                ciudades.add(res.getInt("codCiudad"));
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alojamiento de la base de datos.");
        }
        return ciudades;
    }
    
    public Alojamiento buscarAlojamientPorCiudad(int codCiudad) {
        String sql = "SELECT nombreAlojamiento, direccion, capacidad, habitaciones, baños, precios FROM alojamiento "
                + "WHERE codCiudad = ? ";
        Alojamiento alojamiento = null;
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, codCiudad);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alojamiento = new Alojamiento(); 
                alojamiento.setNombreAlojamiento(rs.getString("nombreAlojamiento")); 
                alojamiento.setDireccion(rs.getString("direccion")); 
                alojamiento.setCapacidad(rs.getInt("capacidad")); 
                alojamiento.setHabitaciones(rs.getInt("habitaciones")); 
                alojamiento.setBanios(rs.getInt("baños")); 
                alojamiento.setPrecioNoche(rs.getDouble("precios"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro un alojamiento con ese codigo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alojamiento");
        }
        return alojamiento;
    }
}
