package ClassDAO;

import ClassVO.PaqueteVO;
import ClassVO.ProductoVO;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpaquetadoDAO {

    private static final String SQL_INSERT = "INSERT INTO empaquetado(id_producto, id_paquete) "
            + " VALUES(?, ?)";

    private static final String SQL_DELETE = "DELETE FROM empaquetado WHERE id_producto = ? and id_paquete = ? limit 1";

    public static int empaquetar(ProductoVO producto, PaqueteVO paquete) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, producto.getId());
            stmt.setInt(2, paquete.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public static int desempaquetar(ProductoVO producto, PaqueteVO paquete) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getId());
            stmt.setInt(2, paquete.getId());

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
