package farmacia.modelo.DAO;

import farmacia.modelo.bean.producto;
import farmaciaConexion.CONEXION;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class productoDAO {


    public static void modificarCantidad(int idpro, int canti){
        String sql = "update producto SET CANTIDAD=? where IDPRODUCTO=?";
        
        try {
            Connection cn = CONEXION.abrir();
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, canti);
            ps.setInt(2, idpro);
            
            
            ps.executeUpdate();
            
            cn.close();
            ps.close();
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }


    public static ArrayList<producto> listar() {

        ArrayList<producto> productos = new ArrayList<>();
        producto pro = null;

        String sql = "SELECT*FROM PRODUCTO";
        Connection cn = CONEXION.abrir();

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pro = new producto(rs.getInt("IDPRODUCTO"), rs.getString("NOMBRE"), rs.getInt("CANTIDAD"), rs.getFloat("PRECIO_VENTA"), rs.getFloat("PRECIO_COMPRA"));
                productos.add(pro);
            }
            
            cn.close();
            ps.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e);
        }

        return productos;

    }

    public static producto buscar(int id) {
        String sql = "select*from producto where IDPRODUCTO=?";
        producto product = null;

        try {

            Connection cn = CONEXION.abrir();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                product = new producto();
                product.setIDPRODUCTO(rs.getInt("IDPRODUCTO"));
                product.setNOMBRE(rs.getString("NOMBRE"));
                product.setCANTIDAD(rs.getInt("CANTIDAD"));
                product.setPRECIO_VENTA(rs.getFloat("PRECIO_VENTA"));
                product.setPRECIO_COMPRA(rs.getFloat("PRECIO_COMPRA"));

            }
            
            cn.close();
            ps.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e);
        }

        return product;
    }

    public static void insertar(producto product) {
        String sql = "insert into producto(NOMBRE, CANTIDAD, PRECIO_VENTA, PRECIO_COMPRA) values(?,?,?,?)";

        try {
            Connection cn = CONEXION.abrir();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, product.getNOMBRE());
            ps.setInt(2, product.getCANTIDAD());
            ps.setFloat(3, product.getPRECIO_VENTA());
            ps.setFloat(4, product.getPRECIO_COMPRA());

            ps.executeUpdate();//para insert, delete, update

            cn.close();
            ps.close();

        } catch (Exception e) {
            System.err.println(e);
        }

    }
    
    public static void editar(producto product){
        String sql = "update producto set NOMBRE=?, CANTIDAD=?, PRECIO_VENTA=?, PRECIO_COMPRA=? where IDPRODUCTO=?";
        
        try {
            Connection cn = CONEXION.abrir();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, product.getNOMBRE());
            ps.setInt(2, product.getCANTIDAD());
            ps.setFloat(3, product.getPRECIO_VENTA());
            ps.setFloat(4, product.getPRECIO_COMPRA());
            ps.setInt(5, product.getIDPRODUCTO());
            
            ps.executeUpdate();
            
            cn.close();
            ps.close();
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static void eliminar(int id){
        String sql = "delete from producto where IDPRODUCTO=?";
        
        try {
            Connection cn = CONEXION.abrir();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            cn.close();
            ps.close();
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
