
package ClassDAO;

import ClassVO.ProductoVO;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO {
    
     private static final String SQL_SELECT = "SELECT * "
            + " FROM producto";

    private static final String SQL_SELECT_BY_ID = "SELECT * "
            + " FROM producto WHERE id = ?";

    private static final String SQL_INSERT = "INSERT INTO producto(descripcion, precio, imagen, id_subcategoria) "
            + " VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE producto "
            + " SET descripcion=?, precio=?, imagen=? WHERE id=?";

    private static final String SQL_DELETE = "DELETE FROM producto WHERE id = ?";

    public static ArrayList<ProductoVO> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ProductoVO producto = null;
        ArrayList<ProductoVO> productos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                byte[] imagen = rs.getBytes("imagen");
                int subcategoria = rs.getInt("id_subcategoria");
                
                producto = new ProductoVO(idP, descripcion, precio, imagen, subcategoria);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return productos;
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
    public static int insertar(ProductoVO producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getDescripcion());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setBytes(3, producto.getImagen());
           stmt.setInt(4, producto.getIdSubcategoria());
           
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
