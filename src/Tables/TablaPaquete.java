package Tables;

import ClassDAO.PaqueteDAO;
import ClassDAO.ProductoDAO;
import ClassVO.PaqueteVO;
import ClassVO.ProductoVO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.TableColumnModel;

public class TablaPaquete {

    public static void cargarPaquetes(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Id");
        dt.addColumn("Descripcion");
        dt.addColumn("Precio");

        PaqueteVO paquete = new PaqueteVO();
        ArrayList<PaqueteVO> list = PaqueteDAO.listar();

        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[3];
            paquete = list.get(i);
            fila[0] = paquete.getId();
            fila[1] = paquete.getDescripcion();
            fila[2] = paquete.getPrecio();
            dt.addRow(fila);
        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(190);
        columnModel.getColumn(2).setPreferredWidth(50);

    }
    
    public static void cargarPaquetes(JTable tabla, String descripcion) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Id");
        dt.addColumn("Descripcion");
        dt.addColumn("Precio");

        PaqueteVO paquete = new PaqueteVO();
        ArrayList<PaqueteVO> list = PaqueteDAO.encontrar(descripcion);

        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[3];
            paquete = list.get(i);
            fila[0] = paquete.getId();
            fila[1] = paquete.getDescripcion();
            fila[2] = paquete.getPrecio();
            dt.addRow(fila);
        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(190);
        columnModel.getColumn(2).setPreferredWidth(50);

    }
    
    
}
