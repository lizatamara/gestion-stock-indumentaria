
package BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    //Variable para abrir la conexión
    private static Connection con;
    //Credenciales
    private String usuario = "PROYECTO_MODA";
    private String password = "PROYECTO_MODA";
    //Host de tu servidor
    private String url = "jdbc:oracle:thin:"+usuario+"/"+password+
            "@localhost:1521:xe";
    // Cambiar de orcl a xe y viceversa ^
    
    //Constructor para conectarnos a la BD
    public Conexion() {
        try {
            //Cargar la librería del OJDBC para contar a ORACLE
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            this.con = DriverManager.getConnection(url,usuario,password);
        } catch (Exception e) {
            System.out.println("Error de Conexión :( "+e.getMessage());
        }
    }
    
    //get de la conexión
    public static Connection obtenerConexion() {
        return con;
    }
    
    
    
}
