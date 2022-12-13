package farmaciaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CONEXION {

    private static String url = "jdbc:mysql://localhost/bdfarmacia";
    private static String usuario = "root";
    private static String clave = "";
    private static Connection cn = null;

    public static Connection abrir() {
        try {
            //registar driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //abri la conexion a la base de datos tienda
            cn = DriverManager.getConnection(url, usuario, clave);

        } catch (Exception ex) {
            Logger.getLogger(CONEXION.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }
}
