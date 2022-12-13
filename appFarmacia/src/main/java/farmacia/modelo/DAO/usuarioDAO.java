package farmacia.modelo.DAO;

import farmacia.modelo.bean.usuario;
import farmaciaConexion.CONEXION;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class usuarioDAO {

    public static usuario validar(String us, String cl) {

        usuario user = null;

        String sql = "SELECT *FROM USUARIO WHERE USUARIO = ? AND PASSWORD =?";

        Connection cn = CONEXION.abrir();

        try {
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, us);
            ps.setString(2, cl);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new usuario(rs.getInt("IDUSUARIO"), rs.getString("NOMBRE"), rs.getString("APEPATERNO"), rs.getString("APEMATERNO"), rs.getString("USUARIO"), rs.getString("PASSWORD"), rs.getString("GMAIL"), rs.getInt("IDRANGO"));
            }

            ps.close();
            rs.close();

        } catch (Exception e) {
        }

        return user;
    }

    public static usuario buscar(int id) {

        usuario user = null;
        String sql = "SELECT *FROM USUARIO WHERE IDUSUARIO =?";
        Connection cn = CONEXION.abrir();

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new usuario(rs.getInt("IDUSUARIO"), rs.getString("NOMBRE"), rs.getString("APEPATERNO"), rs.getString("APEMATERNO"), rs.getString("USUARIO"), rs.getString("PASSWORD"), rs.getString("GMAIL"), rs.getInt("IDRANGO"));
            }

            ps.close();
            rs.close();

        } catch (Exception e) {
        }

        return user;
    }

}
