package Tables;

import ClassDAO.CotizaProductoDAO;
import ClassDAO.CotizacionDAO;
import ClassDAO.ProductoDAO;
import ClassVO.CotizaProductoVO;
import ClassVO.CotizacionVO;
import ClassVO.ProductoVO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.TableColumnModel;

public class TablaCotizaciones {

    public static void cargarCotizaciones(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Id");
        dt.addColumn("Descripcion");
        dt.addColumn("Fecha");
        dt.addColumn("Subtotal");
        dt.addColumn("Total");
        dt.addColumn("Lugar");

        CotizacionVO cotizacion = new CotizacionVO();
        ArrayList<CotizacionVO> list = CotizacionDAO.listar();

        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[6];
            fila[0] = list.get(i).getId();
            fila[1] = list.get(i).getDescripcion();
            fila[2] = list.get(i).getFecha();
            fila[3] = list.get(i).getSubtotal();
            fila[4] = list.get(i).getTotal();
            fila[5] = list.get(i).getLugar();
            dt.addRow(fila);
        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(60);

    }

    public static void cargarCotizacionesPorTres(JTable tabla, Date fecha, String descripcion, String lugar) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Id");
        dt.addColumn("Descripcion");
        dt.addColumn("Fecha");
        dt.addColumn("Subtotal");
        dt.addColumn("Total");
        dt.addColumn("Lugar");

        CotizacionVO cotizacion = new CotizacionVO();
        ArrayList<CotizacionVO> list = CotizacionDAO.encontrar(fecha, descripcion, lugar);

       for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[6];
            fila[0] = list.get(i).getId();
            fila[1] = list.get(i).getDescripcion();
            fila[2] = list.get(i).getFecha();
            fila[3] = list.get(i).getSubtotal();
            fila[4] = list.get(i).getTotal();
            fila[5] = list.get(i).getLugar();
            dt.addRow(fila);
        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(60);

    }
    
    public static void cargarCotizacionesPorFecha(JTable tabla, Date fecha) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Id");
        dt.addColumn("Descripcion");
        dt.addColumn("Fecha");
        dt.addColumn("Subtotal");
        dt.addColumn("Total");
        dt.addColumn("Lugar");

        CotizacionVO cotizacion = new CotizacionVO();
        ArrayList<CotizacionVO> list = CotizacionDAO.encontrarFecha(fecha);

       for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[6];
            fila[0] = list.get(i).getId();
            fila[1] = list.get(i).getDescripcion();
            fila[2] = list.get(i).getFecha();
            fila[3] = list.get(i).getSubtotal();
            fila[4] = list.get(i).getTotal();
            fila[5] = list.get(i).getLugar();
            dt.addRow(fila);
        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(60);

    }
    
    public static void cargarCotizacionesPorDescripcion(JTable tabla, String descripcion) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Id");
        dt.addColumn("Descripcion");
        dt.addColumn("Fecha");
        dt.addColumn("Subtotal");
        dt.addColumn("Total");
        dt.addColumn("Lugar");

        CotizacionVO cotizacion = new CotizacionVO();
        ArrayList<CotizacionVO> list = CotizacionDAO.encontrarDescripcion(descripcion);

       for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[6];
            fila[0] = list.get(i).getId();
            fila[1] = list.get(i).getDescripcion();
            fila[2] = list.get(i).getFecha();
            fila[3] = list.get(i).getSubtotal();
            fila[4] = list.get(i).getTotal();
            fila[5] = list.get(i).getLugar();
            dt.addRow(fila);
        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(60);

    }
    
    public static void cargarCotizacionesPorLugar(JTable tabla, String lugar) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Id");
        dt.addColumn("Descripcion");
        dt.addColumn("Fecha");
        dt.addColumn("Subtotal");
        dt.addColumn("Total");
        dt.addColumn("Lugar");

        CotizacionVO cotizacion = new CotizacionVO();
        ArrayList<CotizacionVO> list = CotizacionDAO.encontrarLugar(lugar);

       for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[6];
            fila[0] = list.get(i).getId();
            fila[1] = list.get(i).getDescripcion();
            fila[2] = list.get(i).getFecha();
            fila[3] = list.get(i).getSubtotal();
            fila[4] = list.get(i).getTotal();
            fila[5] = list.get(i).getLugar();
            dt.addRow(fila);
        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(60);

    }
    
    public static void cargarCotizacionesPorFechaDescripcion(JTable tabla, Date fecha, String descripcion) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Id");
        dt.addColumn("Descripcion");
        dt.addColumn("Fecha");
        dt.addColumn("Subtotal");
        dt.addColumn("Total");
        dt.addColumn("Lugar");

        CotizacionVO cotizacion = new CotizacionVO();
        ArrayList<CotizacionVO> list = CotizacionDAO.encontrar(fecha, descripcion);

        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[6];
            fila[0] = list.get(i).getId();
            fila[1] = list.get(i).getDescripcion();
            fila[2] = list.get(i).getFecha();
            fila[3] = list.get(i).getSubtotal();
            fila[4] = list.get(i).getTotal();
            fila[5] = list.get(i).getLugar();
            dt.addRow(fila);
        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(60);

    }
    
    public static void cargarCotizacionesPorFechaLugar(JTable tabla, Date fecha, String lugar) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Id");
        dt.addColumn("Descripcion");
        dt.addColumn("Fecha");
        dt.addColumn("Subtotal");
        dt.addColumn("Total");
        dt.addColumn("Lugar");

        CotizacionVO cotizacion = new CotizacionVO();
        ArrayList<CotizacionVO> list = CotizacionDAO.encontrarFechaLugar(fecha, lugar);

        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[6];
            fila[0] = list.get(i).getId();
            fila[1] = list.get(i).getDescripcion();
            fila[2] = list.get(i).getFecha();
            fila[3] = list.get(i).getSubtotal();
            fila[4] = list.get(i).getTotal();
            fila[5] = list.get(i).getLugar();
            dt.addRow(fila);
        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(60);

    }
    
    public static void cargarCotizacionesPorDescripcionLugar(JTable tabla,String descripcion, String lugar) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Id");
        dt.addColumn("Descripcion");
        dt.addColumn("Fecha");
        dt.addColumn("Subtotal");
        dt.addColumn("Total");
        dt.addColumn("Lugar");

        CotizacionVO cotizacion = new CotizacionVO();
        ArrayList<CotizacionVO> list = CotizacionDAO.encontrar(descripcion, lugar);

        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[6];
            fila[0] = list.get(i).getId();
            fila[1] = list.get(i).getDescripcion();
            fila[2] = list.get(i).getFecha();
            fila[3] = list.get(i).getSubtotal();
            fila[4] = list.get(i).getTotal();
            fila[5] = list.get(i).getLugar();
            dt.addRow(fila);
        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(60);

    }
}
