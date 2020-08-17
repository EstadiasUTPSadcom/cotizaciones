package Tables;

import ClassDAO.CotizaPaqueteDAO;
import ClassDAO.CotizaProductoDAO;
import ClassDAO.PaqueteDAO;
import ClassDAO.ProductoDAO;
import ClassVO.CotizaPaqueteVO;
import ClassVO.CotizaProductoVO;
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

public class TablaCotizaPaquete {

    public static void cargarPaquetes(JTable tabla, int idCotizacion) {

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
        dt.addColumn("Cantidad");

        PaqueteVO paquete = new PaqueteVO();
        ArrayList<CotizaPaqueteVO> list = CotizaPaqueteDAO.encontrar(idCotizacion);

        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[4];
            paquete = PaqueteDAO.encontrar(list.get(i).getIdPaquete());
            fila[0] = paquete.getId();
            fila[1] = paquete.getDescripcion();
            fila[2] = paquete.getPrecio();
            fila[3] = list.get(i).getCantidad();
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
