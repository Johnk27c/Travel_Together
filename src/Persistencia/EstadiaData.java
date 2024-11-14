package Persistencia;

import Entidades.Estadia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Jara
 */
public class EstadiaData {

    private Connection conexion = null;

    public EstadiaData() {
        conexion = Conexion.getConexion();
    }

    public void guardarEstadia(Estadia estadia) {

        String sql = "INSERT INTO estadia (fechaHoraChekin, fechaHoraCheckout, monto, idAlojamiento, vigencia) "
                + "VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, Timestamp.valueOf(estadia.getFechaHoraCheckin()));
            ps.setTimestamp(2, Timestamp.valueOf(estadia.getFechaHoraCheckout()));
            ps.setDouble(3, estadia.getMonto());
            ps.setInt(4, estadia.getAlojamiento().getCodAlojam());
            ps.setBoolean(5, estadia.isVigencia());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                estadia.setCodEstadia(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se ha generado una estadia.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla estadia de la base de datos.");
        }
    }

    public void modificarEstadia(Estadia estadia) {
        String sql = "UPDATE estadia SET monto = ?, idAlojamiento = ? "
                + "WHERE codEstadia = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDouble(1, estadia.getMonto());
            ps.setInt(2, estadia.getAlojamiento().getCodAlojam());
            ps.setInt(3, estadia.getCodEstadia());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se ha modificado la estadía correctamente.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla estadia de la base de datos.");
        }
    }

    public void eliminarEstadia(Estadia estadia) {
        String sql = "UPDATE estadia SET vigencia = 0 "
                + "WHERE codEstadia = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, estadia.getCodEstadia());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se ha dado de baja la estadía");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla estadía.");
        }
    }

    public Estadia buscarEstadiaPorCodigo(int codEstadia) {
        String sql = "SELECT fechaHoraChekin, fechaHoraCheckout, monto, idAlojamiento, vigencia FROM estadia "
                + "WHERE codEstadia = ? AND vigencia = 1";

        Estadia estadia = null;

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, codEstadia);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estadia = new Estadia();
                estadia.setCodEstadia(codEstadia);
                estadia.setFechaHoraCheckin(rs.getTimestamp("fechaHoraChekin").toLocalDateTime());
                estadia.setFechaHoraCheckout(rs.getTimestamp("fechaHoraCheckout").toLocalDateTime());
                estadia.setMonto(rs.getDouble("monto"));
                //estadia.setAlojamiento(); //Debe buscar un alojamiento por el código del alojamiento obtenido del ResultSet
                estadia.setVigencia(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró estadía con el código indicado");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla estadia de la base de datos.");
        }
        return estadia;
    }
}
