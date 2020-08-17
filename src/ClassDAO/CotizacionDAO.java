package ClassDAO;

import ClassVO.CotizacionVO;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CotizacionDAO {

    private static final String SQL_SELECT = "SELECT * "
            + " FROM cotizacion";

    private static final String SQL_INSERT = "INSERT INTO cotizacion(descripcion, fecha, subtotal, total, lugar, comprado) "
            + " VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE = "DELETE FROM cotizacion WHERE id = ?";

    private static final String SQL_UPDATE = "UPDATE cotizacion "
            + " SET descripcion=?, fecha=?, subtotal=?, total = ?, lugar = ?, comprado = ? WHERE id=?";

    private static final String SQL_SELECT_BY_ID = "SELECT * "
            + " FROM cotizacion WHERE id = ?";

    private static final String SQL_SELECT_BY_NEW = "SELECT * " // DESCRIPCION, FECHA Y LUGAR
            + " FROM cotizacion WHERE descripcion = ? and fecha = ? and lugar = ?";

    public static ArrayList<CotizacionVO> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CotizacionVO cotizacion = null;
        ArrayList<CotizacionVO> cotizaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                String fecha = rs.getString("fecha");
                Double subtotal = rs.getDouble("subtotal");
                Double total = rs.getDouble("total");
                String lugar = rs.getString("lugar");
                boolean comprado = rs.getBoolean("comprado");

                try {
                    cotizacion = new CotizacionVO(idP, descripcion, Conexion.aSqlDate(Conexion.stringADate(fecha)), subtotal, total, lugar, comprado);
                } catch (ParseException ex) {
                    Logger.getLogger(CotizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                cotizaciones.add(cotizacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cotizaciones;
    }

    public static ArrayList<CotizacionVO> encontrar(Date fecha, String descripcion, String lugar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CotizacionVO cotizacion = null;
        ArrayList<CotizacionVO> cotizaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("select * from cotizacion where fecha = ? and descripcion like '%" + descripcion+ "%' and lugar like '%" + lugar+"%'");
            stmt.setDate(1, fecha);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("id");
                String descripcionF = rs.getString("descripcion");
                String fechaF = rs.getString("fecha");
                Double subtotal = rs.getDouble("subtotal");
                Double total = rs.getDouble("total");
                String lugarF = rs.getString("lugar");
                boolean comprado = rs.getBoolean("comprado");

                try {
                    cotizacion = new CotizacionVO(idP, descripcionF, Conexion.aSqlDate(Conexion.stringADate(fechaF)), subtotal, total, lugarF, comprado);
                } catch (ParseException ex) {
                    Logger.getLogger(CotizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                cotizaciones.add(cotizacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cotizaciones;
    }
    
    public static ArrayList<CotizacionVO> encontrar(String descripcion, String lugar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CotizacionVO cotizacion = null;
        ArrayList<CotizacionVO> cotizaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("select * from cotizacion where descripcion like '%" + descripcion+ "%' and lugar like '%" + lugar+"%'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                 int idP = rs.getInt("id");
                String descripcionF = rs.getString("descripcion");
                String fechaF = rs.getString("fecha");
                Double subtotal = rs.getDouble("subtotal");
                Double total = rs.getDouble("total");
                String lugarF = rs.getString("lugar");
                boolean comprado = rs.getBoolean("comprado");

                try {
                    cotizacion = new CotizacionVO(idP, descripcionF, Conexion.aSqlDate(Conexion.stringADate(fechaF)), subtotal, total, lugarF, comprado);
                } catch (ParseException ex) {
                    Logger.getLogger(CotizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                cotizaciones.add(cotizacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cotizaciones;
    }
    
    public static ArrayList<CotizacionVO> encontrarLugar(String lugar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CotizacionVO cotizacion = null;
        ArrayList<CotizacionVO> cotizaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("select * from cotizacion where lugar like '%" + lugar+"%'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("id");
                String descripcionF = rs.getString("descripcion");
                String fechaF = rs.getString("fecha");
                Double subtotal = rs.getDouble("subtotal");
                Double total = rs.getDouble("total");
                String lugarF = rs.getString("lugar");
                boolean comprado = rs.getBoolean("comprado");

                try {
                    cotizacion = new CotizacionVO(idP, descripcionF, Conexion.aSqlDate(Conexion.stringADate(fechaF)), subtotal, total, lugarF, comprado);
                } catch (ParseException ex) {
                    Logger.getLogger(CotizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                cotizaciones.add(cotizacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cotizaciones;
    }
    
    public static ArrayList<CotizacionVO> encontrarDescripcion(String descripcion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CotizacionVO cotizacion = null;
        ArrayList<CotizacionVO> cotizaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("select * from cotizacion where descripcion like '%" + descripcion+"%'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("id");
                String descripcionF = rs.getString("descripcion");
                String fechaF = rs.getString("fecha");
                Double subtotal = rs.getDouble("subtotal");
                Double total = rs.getDouble("total");
                String lugarF = rs.getString("lugar");
                boolean comprado = rs.getBoolean("comprado");

                try {
                    cotizacion = new CotizacionVO(idP, descripcionF, Conexion.aSqlDate(Conexion.stringADate(fechaF)), subtotal, total, lugarF, comprado);
                } catch (ParseException ex) {
                    Logger.getLogger(CotizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                cotizaciones.add(cotizacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cotizaciones;
    }
    
    public static ArrayList<CotizacionVO> encontrarFecha(Date fecha) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CotizacionVO cotizacion = null;
        ArrayList<CotizacionVO> cotizaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("select * from cotizacion where fecha = ?");
            stmt.setDate(1, fecha);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("id");
                String descripcionF = rs.getString("descripcion");
                String fechaF = rs.getString("fecha");
                Double subtotal = rs.getDouble("subtotal");
                Double total = rs.getDouble("total");
                String lugarF = rs.getString("lugar");
                boolean comprado = rs.getBoolean("comprado");

                try {
                    cotizacion = new CotizacionVO(idP, descripcionF, Conexion.aSqlDate(Conexion.stringADate(fechaF)), subtotal, total, lugarF, comprado);
                } catch (ParseException ex) {
                    Logger.getLogger(CotizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                cotizaciones.add(cotizacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cotizaciones;
    }
    
    public static ArrayList<CotizacionVO> encontrar(Date fecha, String descripcion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CotizacionVO cotizacion = null;
        ArrayList<CotizacionVO> cotizaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("select * from cotizacion where fecha = ? and descripcion like '%" + descripcion+ "%'");
            stmt.setDate(1, fecha);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("id");
                String descripcionF = rs.getString("descripcion");
                String fechaF = rs.getString("fecha");
                Double subtotal = rs.getDouble("subtotal");
                Double total = rs.getDouble("total");
                String lugarF = rs.getString("lugar");
                boolean comprado = rs.getBoolean("comprado");

                try {
                    cotizacion = new CotizacionVO(idP, descripcionF, Conexion.aSqlDate(Conexion.stringADate(fechaF)), subtotal, total, lugarF, comprado);
                } catch (ParseException ex) {
                    Logger.getLogger(CotizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                cotizaciones.add(cotizacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cotizaciones;
    }
    
    public static ArrayList<CotizacionVO> encontrarFechaLugar(Date fecha, String lugar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CotizacionVO cotizacion = null;
        ArrayList<CotizacionVO> cotizaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("select * from cotizacion where fecha = ? and lugar like '%" + lugar+ "%'");
            stmt.setDate(1, fecha);
            rs = stmt.executeQuery();
            while (rs.next()) {
                 int idP = rs.getInt("id");
                String descripcionF = rs.getString("descripcion");
                String fechaF = rs.getString("fecha");
                Double subtotal = rs.getDouble("subtotal");
                Double total = rs.getDouble("total");
                String lugarF = rs.getString("lugar");
                boolean comprado = rs.getBoolean("comprado");

                try {
                    cotizacion = new CotizacionVO(idP, descripcionF, Conexion.aSqlDate(Conexion.stringADate(fechaF)), subtotal, total, lugarF, comprado);
                } catch (ParseException ex) {
                    Logger.getLogger(CotizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                cotizaciones.add(cotizacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cotizaciones;
    }
    
    
    
    public static int insertar(CotizacionVO cotizacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cotizacion.getDescripcion());
            stmt.setDate(2, cotizacion.getFecha());
            stmt.setDouble(3, cotizacion.getSubtotal());
            stmt.setDouble(4, cotizacion.getTotal());
            stmt.setString(5, cotizacion.getLugar());
            stmt.setBoolean(6, cotizacion.isComprado());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public static CotizacionVO encontrar(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CotizacionVO cotizacion = new CotizacionVO();
        cotizacion.setId(-1);
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            int idP = rs.getInt("id");
            String descripcion = rs.getString("descripcion");
            String fecha = rs.getString("fecha");
            Double subtotal = rs.getDouble("subtotal");
            Double total = rs.getDouble("total");
            String lugar = rs.getString("lugar");
            boolean comprado = rs.getBoolean("comprado");

            try {
                cotizacion = new CotizacionVO(idP, descripcion, Conexion.aSqlDate(Conexion.stringADate(fecha)), subtotal, total, lugar, comprado);
            } catch (ParseException ex) {
                Logger.getLogger(CotizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cotizacion;
    }

    public static CotizacionVO encontrar(String descripcion, Date fecha, String lugar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CotizacionVO cotizacion = new CotizacionVO();
        cotizacion.setId(-1);
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_NEW);
            stmt.setString(1, descripcion);
            stmt.setDate(2, fecha);
            stmt.setString(3, lugar);
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            int idP = rs.getInt("id");
            String descripcionF = rs.getString("descripcion");
            String fechaF = rs.getString("fecha");
            Double subtotal = rs.getDouble("subtotal");
            Double total = rs.getDouble("total");
            String lugarF = rs.getString("lugar");
            boolean comprado = rs.getBoolean("comprado");

            try {
                cotizacion = new CotizacionVO(idP, descripcionF, Conexion.aSqlDate(Conexion.stringADate(fechaF)), subtotal, total, lugarF, comprado);
            } catch (ParseException ex) {
                Logger.getLogger(CotizacionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cotizacion;
    }

    public static int actualizar(CotizacionVO cotizacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cotizacion.getDescripcion());
            stmt.setDate(2, cotizacion.getFecha());
            stmt.setDouble(3, cotizacion.getSubtotal());
            stmt.setDouble(4, cotizacion.getTotal());
            stmt.setString(5, cotizacion.getLugar());
            stmt.setBoolean(6, cotizacion.isComprado());
            stmt.setInt(7, cotizacion.getId());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public static int eliminar(CotizacionVO cotizacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cotizacion.getId());

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
