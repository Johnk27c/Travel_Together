package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Jara
 */
public class Conexion {
    private static final String URL= "jdbc:mariadb://localhost/";
    private static final String DB= "Travel_Together";
    private static final String USUARIO= "root";
    private static final String PASSWORD= "";
    private static Connection conexion;

    public Conexion() {
    }
    
    public static Connection getConexion (){
        if (conexion==null){
            try{                
            Class.forName("org.mariadb.jdbc.Driver");
            conexion= DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexión exitosa");
            
            }catch (ClassNotFoundException e){
                JOptionPane.showMessageDialog(null, "Error al cargar Drivers");
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
            }
        }
        return conexion;
    }
}
