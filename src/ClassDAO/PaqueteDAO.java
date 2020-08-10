package ClassDAO;

import ClassVO.PaqueteVO;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaqueteDAO {

    private static final String SQL_SELECT = "SELECT * "
            + " FROM paquete";

    private static final String SQL_SELECT_BY_ID = "SELECT * "
            + " FROM paquete WHERE id = ?";

    private static final String SQL_INSERT = "INSERT INTO paquete(descripcion, suma, descuento, precio "
            + " VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE paquete "
            + " SET descripcion=?, suma=?, descuento=?, precio = ? WHERE id=?";

    private static final String SQL_DELETE = "DELETE FROM paquete WHERE id = ?";

 

    
    public static ArrayList<PaqueteVO> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PaqueteVO paquete = null;
        ArrayList<PaqueteVO> paquetes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                double suma = rs.getDouble("suma");
                int descuento = rs.getInt("descuento");
                double precio = rs.getDouble("precio");

                paquete = new PaqueteVO(idP, descripcion, suma, descuento, precio);
                paquetes.add(paquete);
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

    public static ArrayList<PaqueteVO> encontrar(String nombre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PaqueteVO paquete = null;
        ArrayList<PaqueteVO> paquetes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("select * from paquete where descripcion like '%" + nombre + "%'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                double suma = rs.getDouble("suma");
                int descuento = rs.getInt("descuento");
                double precio = rs.getDouble("precio");

                paquete = new PaqueteVO(idP, descripcion, suma, descuento, precio);
                paquetes.add(paquete);
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

    public static PaqueteVO encontrar(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PaqueteVO paquete = new PaqueteVO();
        paquete.setId(-1);
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            int idP = rs.getInt("id");
            String descripcion = rs.getString("descripcion");
            double suma = rs.getDouble("suma");
            int descuento = rs.getInt("descuento");
            double precio = rs.getDouble("precio");

            paquete = new PaqueteVO(idP, descripcion, suma, descuento, precio);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return paquete;
    }

  
    public static int insertar(PaqueteVO paquete) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, paquete.getDescripcion());
            stmt.setDouble(2, paquete.getSuma());
            stmt.setInt(3, paquete.getDescuento());
            stmt.setDouble(4, paquete.getPrecio());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public static int actualizar(PaqueteVO paquete) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, paquete.getDescripcion());
            stmt.setDouble(2, paquete.getSuma());
            stmt.setInt(3, paquete.getDescuento());
            stmt.setDouble(4, paquete.getPrecio());
            stmt.setInt(5, paquete.getId());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public static int eliminar(PaqueteVO paquete) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, paquete.getId());

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
