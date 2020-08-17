package ClassDAO;

import ClassVO.CotizaProductoVO;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CotizaProductoDAO {

    private static final String SQL_SELECT_BY_ID = "SELECT * "
            + " FROM cotiza_producto WHERE id_cotizacion = ?";

    private static final String SQL_INSERT = "INSERT INTO cotiza_producto(id_producto, id_cotizacion, cantidad) "
            + " VALUES(?, ?, ?)";

    private static final String SQL_DELETE = "DELETE FROM cotiza_producto WHERE id_producto = ? and id_cotizacion = ? and cantidad = ?";

    public static ArrayList<CotizaProductoVO> encontrar(int idCotizacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CotizaProductoVO cotizacion = null;
        ArrayList<CotizaProductoVO> productos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, idCotizacion);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                int idCotizacionF = rs.getInt("id_cotizacion");
                int cantidad = rs.getInt("cantidad");

                cotizacion = new CotizaProductoVO(idProducto, idCotizacionF, cantidad);
                productos.add(cotizacion);
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

    public static int insertar(CotizaProductoVO cotizado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, cotizado.getIdProducto());
            stmt.setInt(2, cotizado.getIdCotizacion());
            stmt.setInt(3, cotizado.getCantidad());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public static int eliminar(CotizaProductoVO producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getIdProducto());
            stmt.setInt(2, producto.getIdCotizacion());
            stmt.setInt(3, producto.getCantidad());

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
