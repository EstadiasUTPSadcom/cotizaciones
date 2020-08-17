package ClassDAO;

import ClassVO.UsuarioVO;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT * "
            + " FROM usuario";

    private static final String SQL_SELECT_BY_ALIAS = "SELECT * "
            + " FROM usuario WHERE usr = ?";

    private static final String SQL_INSERT = "INSERT INTO usuario(usr, pass) "
            + " VALUES(?, ?)";

    private static final String SQL_UPDATE = "UPDATE usuario "
            + " SET pass = ? WHERE usr = ?";

    private static final String SQL_DELETE = "DELETE FROM usuario WHERE usr = ?";

    public static List<UsuarioVO> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioVO usuario = null;
        List<UsuarioVO> usuarios = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String alias = rs.getString("usr");
                String passwd = rs.getString("pass");

                usuario = new UsuarioVO(alias, passwd);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarios;
    }

    public static ArrayList<UsuarioVO> encontrar(String alias) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioVO usuario = null;
        ArrayList<UsuarioVO> usuarios = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ALIAS);
            stmt.setString(1, alias);
            rs = stmt.executeQuery();
            // rs.absolute(1);//nos posicionamos en el primer registro devuelto

            while (rs.next()) {
                String aliase = rs.getString("usr");
                String passwd = rs.getString("pass");

                usuario = new UsuarioVO(aliase, passwd);
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarios;
    }

    public static int insertar(UsuarioVO usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsr());
            stmt.setString(2, usuario.getPass());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public static int actualizar(UsuarioVO usuario) {
        System.out.println(usuario.getUsr() + " " + usuario.getPass());
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(2, usuario.getUsr());
            stmt.setString(1, usuario.getPass());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public static int eliminar(UsuarioVO usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, usuario.getUsr());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
