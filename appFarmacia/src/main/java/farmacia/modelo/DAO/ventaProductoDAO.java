
package farmacia.modelo.DAO;

import farmacia.modelo.bean.producto;
import farmacia.modelo.bean.proveedor;
import farmacia.modelo.bean.ventaProducto;
import farmaciaConexion.CONEXION;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ventaProductoDAO {

    public static float sumaTotal(){

        String sql = "SELECT SUM(TOTALMONETARIO) FROM ventaproducto";
        float Total = 0;

        try {
            Connection cn = CONEXION.abrir();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

        if(rs.next()){
            Total = rs.getFloat("SUM(TOTALMONETARIO)");
        }
            ps.close();
            cn.close();

        } catch (Exception e) {
        }

        return Total;
    }


    public static void eliminar(int id) {

        String sql = "DELETE FROM VENTAPRODUCTO WHERE IDVENTAPRODUCTO =?";

        Connection cn = CONEXION.abrir();

        try {
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            cn.close();

        } catch (Exception e) {
        }
    }

    public static void editar(int idpro, int cantidad, float pago){
        String sql = "update ventaproducto set CANTIDAD=?, TOTALMONETARIO = ? where IDVENTAPRODUCTO=?";
        
        try {
            Connection cn = CONEXION.abrir();
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, cantidad);
            ps.setFloat(2, pago);
            ps.setInt(3, idpro);
            
            ps.executeUpdate();
            
            cn.close();
            ps.close();
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }


    
    public static ventaProducto buscar(int id) {
        String sql = "select*from ventaProducto where IDVENTAPRODUCTO=?";
        ventaProducto product = null;

        try {

            Connection cn = CONEXION.abrir();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                product = new ventaProducto();
                product.setIDVENTAPRODUCTO(rs.getInt("IDVENTAPRODUCTO"));
                product.setIDPRODUCTO(rs.getInt("IDPRODUCTO"));
                product.setCANTIDAD(rs.getInt("CANTIDAD"));
                product.setTOTALMONETARIO(rs.getFloat("PRECIO_VENTA"));
                product.setIDUSUARIO(rs.getInt("IDUSUARIO"));
                product.setFECHA(rs.getDate("FECHA"));
            }
            
            cn.close();
            ps.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e);
        }

        return product;
    }


    public static void agregar(ventaProducto proV) {

        String sql = "INSERT INTO VENTAPRODUCTO (IDPRODUCTO, CANTIDAD, TOTALMONETARIO, IDUSUARIO, FECHA) VALUES (?,?,?,?,?)";
        

        try {
            Connection cn = CONEXION.abrir();
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, proV.getIDPRODUCTO());
            ps.setInt(2, proV.getCANTIDAD());
            ps.setFloat(3, proV.getTOTALMONETARIO());
            ps.setInt(4, proV.getIDUSUARIO());
            ps.setDate(5, proV.getFECHA());

            ps.executeUpdate();

            ps.close();
            cn.close();

        } catch (Exception e) {
        }
    }

public static ArrayList<ventaProducto> listar() {

        ArrayList<ventaProducto> productosV = new ArrayList<>();
        ventaProducto proV = null;

        String sql = "SELECT*FROM VENTAPRODUCTO";
        Connection cn = CONEXION.abrir();

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               proV = new ventaProducto(rs.getInt("IDVENTAPRODUCTO"), rs.getInt("IDPRODUCTO"), rs.getInt("CANTIDAD"), rs.getFloat("TOTALMONETARIO"), rs.getInt("IDUSUARIO"), rs.getDate("FECHA"));
               productosV.add(proV);
            }
            
            cn.close();
            ps.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e);
        }

        return productosV;

    }


}
