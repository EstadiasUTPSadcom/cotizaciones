package ClassDAO;

import ClassVO.CategoriaVO;
import ClassVO.ProductoVO;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO {

    private static final String SQL_SELECT = "SELECT * "
            + " FROM categoria";

    private static final String SQL_SELECT_BY_ID = "SELECT * "
            + " FROM categoria WHERE id = ?";

    private static final String SQL_SELECT_BY_NAME = "SELECT * "
            + " FROM categoria WHERE nombre = ?";

    private static final String SQL_INSERT = "INSERT INTO categoria(nombre) "
            + " VALUES(?)";

    private static final String SQL_DELETE = "DELETE FROM categoria WHERE id = ?";

    public static ArrayList<CategoriaVO> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CategoriaVO categoria = null;
        ArrayList<CategoriaVO> categorias = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("id");
                String nombre = rs.getString("nombre");

                categoria = new CategoriaVO(idP, nombre);
                categorias.add(categoria);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return categorias;
    }

    public static CategoriaVO encontrar(String nombre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CategoriaVO categoria = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_NAME);
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            if (rs.next()) {
                int idP = rs.getInt("id");
                String nombreP = rs.getString("nombre");

                categoria = new CategoriaVO(idP, nombreP);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return categoria;
    }

    public static int insertar(CategoriaVO categoria) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, categoria.getNombre());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    /*
    public static int actualizar(ClienteVO cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombres());
            stmt.setString(2, cliente.getApellidos());
            stmt.setString(3, cliente.getTelefono());
            stmt.setDate(4, cliente.getF_nac());
            stmt.setString(5, String.valueOf(cliente.getSexo()));
            stmt.setString(6, cliente.getCorreo());
            stmt.setString(7, cliente.getId());
            
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
*/
    
    public static int eliminar(CategoriaVO categoria) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, categoria.getId());

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
