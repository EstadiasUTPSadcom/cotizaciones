package Tables;

import ClassDAO.SubcategoriaDAO;
import ClassVO.SubcategoriaVO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TablaSubcategoria {


    public static void cargarSubcategorias(JTable tabla, int idCategoria) {

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
                Object fila[] = new Object[2];
                subcategoria = list.get(i);
                fila[0] = subcategoria.getId();
                fila[1] = subcategoria.getNombre();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
            TableColumnModel columnModel = tabla.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(50);
            columnModel.getColumn(1).setPreferredWidth(200);
        } else {
            Object fila[] = new Object[2];
            fila[0] = "";
            fila[1] = "";
            dt.addRow(fila);
             tabla.setModel(dt);
            tabla.setRowHeight(60);
            TableColumnModel columnModel = tabla.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(20);
            columnModel.getColumn(1).setPreferredWidth(200);
        }
    }

}
