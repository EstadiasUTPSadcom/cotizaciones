package Tables;

import ClassDAO.SubcategoriaDAO;
import ClassVO.SubcategoriaVO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class TablaSubcategoria {
    
    public static void cargarCategorias(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        dt.addColumn("Id");
        dt.addColumn("Categoria");
        dt.addColumn("Nombre");

        SubcategoriaVO subcategoria = new SubcategoriaVO();
        ArrayList<SubcategoriaVO> list = SubcategoriaDAO.listar();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[5];
                subcategoria = list.get(i);
                fila[0] = subcategoria.getId();
                fila[1] = subcategoria.getIdCategoria();
                fila[2] = subcategoria.getNombre();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
            TableColumnModel columnModel = tabla.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(20);
            columnModel.getColumn(1).setPreferredWidth(20);
            columnModel.getColumn(2).setPreferredWidth(50);
        }
    }
 
    public static void cargarCategorias(JTable tabla, int idCategoria) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        dt.addColumn("Id");
        dt.addColumn("Nombre");

        SubcategoriaVO subcategoria = new SubcategoriaVO();
        ArrayList<SubcategoriaVO> list = SubcategoriaDAO.obtenerDeCategoria(idCategoria);

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[5];
                subcategoria = list.get(i);
                fila[0] = subcategoria.getId();
                fila[1] = subcategoria.getNombre();
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
