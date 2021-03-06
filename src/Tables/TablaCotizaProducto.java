package Tables;

import ClassDAO.CotizaProductoDAO;
import ClassDAO.ProductoDAO;
import ClassVO.CotizaProductoVO;
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

public class TablaCotizaProducto {

    public static void cargarProductos(JTable tabla, int idCotizacion) {

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
        dt.addColumn("Imagen");

        ProductoVO producto = new ProductoVO();
        ArrayList<CotizaProductoVO> list = CotizaProductoDAO.encontrar(idCotizacion);

        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[5];
            producto = ProductoDAO.encontrar(list.get(i).getIdProducto());
            fila[0] = producto.getId();
            fila[1] = producto.getDescripcion();
            fila[2] = producto.getPrecio();
            fila[3] = list.get(i).getCantidad();
            try {
                byte[] bi = producto.getImagen();
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                fila[4] = new JLabel(imgi);
            } catch (Exception ex) {
                fila[4] = new JLabel("No imagen");
            }
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
