
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
            + " FROM subcategoria WHERE id = ?";

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
/*
    public static ClienteVO encontrar(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ClienteVO cliente = new ClienteVO();
        cliente.setId("not found");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String idCliente = rs.getString("id");
            String nombres = rs.getString("nombres");
            String apellidos = rs.getString("apellidos");
            String telefono = rs.getString("telefono");
            Date f_nac = null;
            try {
                f_nac = Conexion.aSqlDate(Conexion.stringADate(rs.getString("f_nac")));
            } catch (ParseException ex) {
                Logger.getLogger(MembresiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            char sexo = rs.getString("sexo").charAt(0);
            String correo = rs.getString("correo");

            cliente = new ClienteVO(idCliente, nombres, apellidos, telefono, f_nac, sexo, correo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }
*/
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

    public static int eliminar(ClienteVO cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, cliente.getId());

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
}
