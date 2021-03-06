package Tables;

import ClassDAO.ProductoDAO;
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

public class TablaProducto {

    public static void cargarProductos(JTable tabla) {

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
        dt.addColumn("Imagen");

        ProductoVO producto = new ProductoVO();
        ArrayList<ProductoVO> list = ProductoDAO.listar();

        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[5];
            producto = list.get(i);
            fila[0] = producto.getId();
            fila[1] = producto.getDescripcion();
            fila[2] = producto.getPrecio();
            try {
                byte[] bi = producto.getImagen();
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                fila[3] = new JLabel(imgi);
            } catch (Exception ex) {
                fila[3] = new JLabel("No imagen");
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
    
    public static void cargarProductos(JTable tabla, String nombre) {

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
        dt.addColumn("Imagen");

        ProductoVO producto = new ProductoVO();
        ArrayList<ProductoVO> list = ProductoDAO.encontrar(nombre);

        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[5];
            producto = list.get(i);
            fila[0] = producto.getId();
            fila[1] = producto.getDescripcion();
            fila[2] = producto.getPrecio();
            try {
                byte[] bi = producto.getImagen();
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                fila[3] = new JLabel(imgi);
            } catch (Exception ex) {
                fila[3] = new JLabel("No imagen");
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
    
    public static void cargarProductos(JTable tabla, int idPaquete) {

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
        dt.addColumn("Imagen");

        ProductoVO producto = new ProductoVO();
        ArrayList<ProductoVO> list = ProductoDAO.encontrarEnPaquete(idPaquete);

        
        if(idPaquete!=0){
        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[4];
            producto = list.get(i);
            fila[0] = producto.getId();
            fila[1] = producto.getDescripcion();
            fila[2] = producto.getPrecio();
            try {
                byte[] bi = producto.getImagen();
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                fila[3] = new JLabel(imgi);
            } catch (Exception ex) {
                fila[3] = new JLabel("No imagen");
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
        else{
            Object fila[] = new Object[4];
            fila[0] = "";
            fila[1] = "";
            fila[2] = "";
            fila[3] = "";
            dt.addRow(fila);
 
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(60);

        }
    }
    
    public static void cargarPorCategoriaYTexto(JTable tabla, int idCategoria, String nombre) {

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
        dt.addColumn("Imagen");

        ProductoVO producto = new ProductoVO();
        ArrayList<ProductoVO> list = ProductoDAO.encontrarEnCategoria(idCategoria, nombre);

        
        if(idCategoria !=0){
        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[4];
            producto = list.get(i);
            fila[0] = producto.getId();
            fila[1] = producto.getDescripcion();
            fila[2] = producto.getPrecio();
            try {
                byte[] bi = producto.getImagen();
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                fila[3] = new JLabel(imgi);
            } catch (Exception ex) {
                fila[3] = new JLabel("No imagen");
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
        else{
            Object fila[] = new Object[4];
            fila[0] = "";
            fila[1] = "";
            fila[2] = "";
            fila[3] = "";
            dt.addRow(fila);
 
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(60);

        }
    }
    
    public static void cargarPorCategoria(JTable tabla, int idCategoria) {

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
        dt.addColumn("Imagen");

        ProductoVO producto = new ProductoVO();
        ArrayList<ProductoVO> list = ProductoDAO.encontrarEnCategoria(idCategoria);

        
        if(idCategoria !=0){
        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[4];
            producto = list.get(i);
            fila[0] = producto.getId();
            fila[1] = producto.getDescripcion();
            fila[2] = producto.getPrecio();
            try {
                byte[] bi = producto.getImagen();
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                fila[3] = new JLabel(imgi);
            } catch (Exception ex) {
                fila[3] = new JLabel("No imagen");
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
        else{
            Object fila[] = new Object[4];
            fila[0] = "";
            fila[1] = "";
            fila[2] = "";
            fila[3] = "";
            dt.addRow(fila);
 
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(60);

        }
    }
    
    public static void cargarPorSubcategoria(JTable tabla, int idSubcategoria){

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
        dt.addColumn("Imagen");

        ProductoVO producto = new ProductoVO();
        ArrayList<ProductoVO> list = ProductoDAO.encontrarEnSubcategoria(idSubcategoria);

        
        if(idSubcategoria !=0){
        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[4];
            producto = list.get(i);
            fila[0] = producto.getId();
            fila[1] = producto.getDescripcion();
            fila[2] = producto.getPrecio();
            try {
                byte[] bi = producto.getImagen();
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                fila[3] = new JLabel(imgi);
            } catch (Exception ex) {
                fila[3] = new JLabel("No imagen");
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
        else{
            Object fila[] = new Object[4];
            fila[0] = "";
            fila[1] = "";
            fila[2] = "";
            fila[3] = "";
            dt.addRow(fila);
 
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(60);
        }
    }
        
    
    public static void cargarPorSubcategoria(JTable tabla, int idSubcategoria, String nombre){

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
        dt.addColumn("Imagen");

        ProductoVO producto = new ProductoVO();
        ArrayList<ProductoVO> list = ProductoDAO.encontrarEnSubcategoria(idSubcategoria, nombre);

        
        if(idSubcategoria !=0){
        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[4];
            producto = list.get(i);
            fila[0] = producto.getId();
            fila[1] = producto.getDescripcion();
            fila[2] = producto.getPrecio();
            try {
                byte[] bi = producto.getImagen();
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                fila[3] = new JLabel(imgi);
            } catch (Exception ex) {
                fila[3] = new JLabel("No imagen");
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
        else{
            Object fila[] = new Object[4];
            fila[0] = "";
            fila[1] = "";
            fila[2] = "";
            fila[3] = "";
            dt.addRow(fila);
 
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(60);
        }
    }
    
    
    
}
