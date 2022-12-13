package farmacia.modelo.DAO;

import farmacia.modelo.bean.proveedor;
import farmaciaConexion.CONEXION;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class proveedoresDAO {

    public static void eliminar(int id) {

        String sql = "DELETE FROM PROVEEDOR WHERE IDPROVEEDOR =?";

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

    public static void modificar(proveedor pro) {

        String sql = "UPDATE PROVEEDOR SET NOMBRE = ?, CODIGO = ? WHERE IDPROVEEDOR = ?";

        Connection cn = CONEXION.abrir();

        try {
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, pro.getNOMBRE());
            ps.setString(2, pro.getCODIGO());
            ps.setInt(3, pro.getIDPROVEEDOR());

            ps.executeUpdate();

            ps.close();
            cn.close();

        } catch (Exception e) {
        }
    }

    public static proveedor buscar(int id) {

        proveedor pro = null;

        String sql = "SELECT *FROM PROVEEDOR WHERE IDPROVEEDOR = ?";
        Connection cn = CONEXION.abrir();

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pro = new proveedor(rs.getInt("IDPROVEEDOR"), rs.getString("NOMBRE"), rs.getString("CODIGO"));
            }

        } catch (Exception e) {
        }

        return pro;
    }

    public static void agregar(proveedor pro) {

        String sql = "INSERT INTO PROVEEDOR (NOMBRE, CODIGO) VALUES (?,?)";
        Connection cn = CONEXION.abrir();

        try {
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, pro.getNOMBRE());
            ps.setString(2, pro.getCODIGO());

            ps.executeUpdate();

            ps.close();
            cn.close();

        } catch (Exception e) {
        }
    }

    public static ArrayList<proveedor> listar() {

        ArrayList<proveedor> proveedores = new ArrayList<>();
        proveedor pro = null;

        String sql = "SELECT *FROM PROVEEDOR";
        Connection cn = CONEXION.abrir();

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pro = new proveedor(rs.getInt("IDPROVEEDOR"), rs.getString("NOMBRE"), rs.getString("CODIGO"));
                proveedores.add(pro);
            }

            ps.close();
            rs.close();

        } catch (Exception e) {
        }

        return proveedores;

    }

}
