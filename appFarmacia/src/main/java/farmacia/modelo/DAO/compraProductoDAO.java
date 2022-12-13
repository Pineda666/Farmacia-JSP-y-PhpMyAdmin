
package farmacia.modelo.DAO;

import farmacia.modelo.bean.compraProducto;
import farmacia.modelo.bean.ventaProducto;
import farmaciaConexion.CONEXION;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class compraProductoDAO {
    
    public static ArrayList<compraProducto> listar() {

        ArrayList<compraProducto> productosC = new ArrayList<>();
        compraProducto proC = null;

        String sql = "SELECT*FROM COMPRAPRODUCTO";
        Connection cn = CONEXION.abrir();

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               proC = new compraProducto(rs.getInt("IDCOMPRAPRODUCTO"), rs.getInt("CANTIDAD"), rs.getFloat("TOTALMONETARIO"), rs.getDate("FECHA"), rs.getInt("IDPRODUCTO"));
               productosC.add(proC);
            }
            
            cn.close();
            ps.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e);
        }

        return productosC;

    }
    
    public static void agregar(compraProducto proC) {

        String sql = "INSERT INTO COMPRAPRODUCTO (CANTIDAD, TOTALMONETARIO, FECHA, IDPRODUCTO) VALUES (?,?,?,?)";
        

        try {
            Connection cn = CONEXION.abrir();
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, proC.getCANTIDAD());
            ps.setFloat(2, proC.getTOTALMONETARIO());
            ps.setDate(3, proC.getFECHA());
            ps.setInt(4, proC.getIDPRODUCTO());

            ps.executeUpdate();

            ps.close();
            cn.close();

        } catch (Exception e) {
        }
    }
}
