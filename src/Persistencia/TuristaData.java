package Persistencia;

import Entidades.Turista;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Jara
 */
public class TuristaData {
     private Connection conexion = null;

    public TuristaData() {
        conexion = Conexion.getConexion();
    }
    
    public void guardarTurista(Turista turista) {

        String sql = "INSERT INTO turista (dni, apellido, nombre, FechaNac)"
                + "VALUES(?, ?, ?, ? )";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, turista.getDni());
            ps.setString(2, turista.getApellido());
            ps.setString(3, turista.getNombre()); 
            ps.setDate(4, java.sql.Date.valueOf(turista.getFechaNac()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El turista ha sido cargado con éxito.");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla turista de la base de datos.");
        }
    }
    
    public void modificarTurista(Turista turista) {
        String sql = "UPDATE turista SET nombre = ?, apellido = ?, FechaNac = ? "
                + "WHERE dni = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
             ps.setString(1, turista.getNombre());
             ps.setString(2, turista.getApellido());
             ps.setDate(3, java.sql.Date.valueOf(turista.getFechaNac()));
             ps.setInt(4, turista.getDni());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El turista ha sido modificado con éxito.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla turista de la base de datos.");
        }
    }
    
    public void eliminarTurista(int dni) {
        String sql = "DELETE FROM turista WHERE dni = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            int exito = ps.executeUpdate();
            if (exito == 1){
            JOptionPane.showMessageDialog(null, "El turista ha sido eliminado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado turista con el DNI indicado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla turista de la base de datos.");
        }
    }
    
    public Turista buscarTuristaPorDNI(int dni) {
        String sql = "SELECT dni, nombre, apellido, FechaNac FROM turista WHERE  dni = ? ";
        Turista turista = null;
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                turista = new Turista();
                turista.setDni(rs.getInt("dni"));
                turista.setApellido(rs.getString("apellido"));
                turista.setNombre(rs.getString("nombre"));
                turista.setFechaNac(rs.getDate("FechaNac").toLocalDate());
            } else {
                JOptionPane.showMessageDialog(null, "No existe un turista con el DNI indicado");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla turista de la base de datos.");
        }
        return turista;
    }
}
