
package ClassDAO;

import ClassVO.CategoriaVO;
import ClassVO.SubcategoriaVO;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SubcategoriaDAO {
    
    private static final String SQL_SELECT = "SELECT * "
            + " FROM subcategoria";

    private static final String SQL_SELECT_BY_ID = "SELECT * "
            + " FROM subcategoria WHERE id_categoria = ? and nombre = ?";

    private static final String SQL_SELECT_BY_CAT = "SELECT * "
            + " FROM subcategoria WHERE id_categoria = ?";
    
    private static final String SQL_INSERT = "INSERT INTO subcategoria(id_categoria, nombre) "
            + " VALUES(?, ?)";

    private static final String SQL_DELETE = "DELETE FROM subcategoria WHERE id = ?";

    public static ArrayList<SubcategoriaVO> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        SubcategoriaVO categoria = null;
        ArrayList<SubcategoriaVO> subcategorias = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("id");
                int idCat = rs.getInt("id_categoria");
                String nombre = rs.getString("nombre");
                
                categoria = new SubcategoriaVO(idP, idCat, nombre);
                subcategorias.add(categoria);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return subcategorias;
    }
    
    public static ArrayList<SubcategoriaVO> obtenerDeCategoria(int categoriaId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        SubcategoriaVO categoria = null;
        ArrayList<SubcategoriaVO> subcategorias = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_CAT);
            stmt.setInt(1, categoriaId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("id");
                int idCat = rs.getInt("id_categoria");
                String nombre = rs.getString("nombre");
                
                categoria = new SubcategoriaVO(idP, idCat, nombre);
                subcategorias.add(categoria);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return subcategorias;
    }

    public static SubcategoriaVO encontrar(int idCategoria, String nombre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        SubcategoriaVO subcat = new SubcategoriaVO();
        subcat.setId(-1);
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, idCategoria);
            stmt.setString(2, nombre);
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            int id = rs.getInt("id");
            int cat = rs.getInt("id_categoria");
            String nombreF = rs.getString("nombre");
            
            subcat = new SubcategoriaVO(id, cat, nombreF);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return subcat;
    }

    
    
    public static int insertar(SubcategoriaVO subcategoria) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, subcategoria.getIdCategoria());
            stmt.setString(2, subcategoria.getNombre());
            
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
    
    public static int eliminar(SubcategoriaVO subcat) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, subcat.getId());

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
