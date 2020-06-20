package Tables;

import ClassDAO.CategoriaDAO;
import ClassDAO.ProductoDAO;
import ClassVO.CategoriaVO;
import ClassVO.ProductoVO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class TablaCategoria {
    
    public static void cargarCategoria(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Id");
        dt.addColumn("Nombre");

        CategoriaVO categoria = new CategoriaVO();
        ArrayList<CategoriaVO> list = CategoriaDAO.listar();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[2];
                categoria = list.get(i);
                fila[0] = categoria.getId();
                fila[1] = categoria.getNombre();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
            TableColumnModel columnModel = tabla.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(20);
            columnModel.getColumn(1).setPreferredWidth(200);
        }
        
    }
    
}
