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
            + " SET descripcion=?, precio=?, imagen=?, id_subcategoria = ? WHERE id=?";
    
    private static final String SQL_UPDATE_WITHOUT_IMAGE = "UPDATE producto "
            + " SET descripcion=?, precio=?,  id_subcategoria = ? WHERE id=?";

    private static final String SQL_DELETE = "DELETE FROM producto WHERE id = ?";
    
    private static final String SQL_SELECT_BY_PACKAGE = "SELECT id, descripcion, precio, imagen, id_subcategoria "
            + " FROM empaquetado join producto on empaquetado.id_producto = producto.id WHERE id_paquete = ?";

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

    public static ArrayList<ProductoVO> encontrar(String nombre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ProductoVO producto = null;
        ArrayList<ProductoVO> productos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("select * from producto where descripcion like '%" + nombre + "%'");
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
    
    public static ArrayList<ProductoVO> encontrarEnPaquete(int idPaquete) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ProductoVO producto = null;
        ArrayList<ProductoVO> productos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_PACKAGE);
            stmt.setInt(1, idPaquete);
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
    
    public static ProductoVO encontrar(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ProductoVO producto = new ProductoVO();
        producto.setId(-1);
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            int idP = rs.getInt("id");
            String descripcion = rs.getString("descripcion");
            double precio = rs.getDouble("precio");
            byte[] imagen = rs.getBytes("imagen");
            int subcategoria = rs.getInt("id_subcategoria");
            producto = new ProductoVO(idP, descripcion, precio, imagen, subcategoria);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return producto;
    }

    
    
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

    public static int actualizar(ProductoVO producto, boolean imagen) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            if (imagen) {
                conn = Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_UPDATE);
                stmt.setString(1, producto.getDescripcion());
                stmt.setDouble(2, producto.getPrecio());
                stmt.setBytes(3, producto.getImagen());
                stmt.setInt(4, producto.getIdSubcategoria());
                stmt.setInt(5, producto.getId());

                rows = stmt.executeUpdate();
            } else {
                conn = Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_UPDATE_WITHOUT_IMAGE);
                stmt.setString(1, producto.getDescripcion());
                stmt.setDouble(2, producto.getPrecio());
                stmt.setInt(3, producto.getIdSubcategoria());
                stmt.setInt(4, producto.getId());

                rows = stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public static int eliminar(ProductoVO producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getId());

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
