
package ClassDAO;

import ClassVO.CotizaPaqueteVO;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CotizaPaqueteDAO {
    
    private static final String SQL_SELECT_BY_ID = "SELECT * "
            + " FROM cotiza_paquete WHERE id_cotizacion = ?";

    private static final String SQL_INSERT = "INSERT INTO cotiza_paquete(id_paquete, id_cotizacion, cantidad) "
            + " VALUES(?, ?, ?)";

    private static final String SQL_DELETE = "DELETE FROM cotiza_paquete WHERE id_paquete = ? and id_cotizacion = ? and cantidad = ?";
    
    public static ArrayList<CotizaPaqueteVO> encontrar(int idCotizacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CotizaPaqueteVO cotizacion = null;
        ArrayList<CotizaPaqueteVO> paquetes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, idCotizacion);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPaquete = rs.getInt("id_paquete");
                int idCotizacionF = rs.getInt("id_cotizacion");
                int cantidad = rs.getInt("cantidad");

                cotizacion = new CotizaPaqueteVO(idPaquete, idCotizacionF, cantidad);
                paquetes.add(cotizacion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return paquetes;
    }
    
    public static int insertar(CotizaPaqueteVO cotizado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, cotizado.getIdPaquete());
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

    public static int eliminar(CotizaPaqueteVO paquete) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, paquete.getIdPaquete());
            stmt.setInt(2, paquete.getIdCotizacion());
            stmt.setInt(3, paquete.getCantidad());

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
