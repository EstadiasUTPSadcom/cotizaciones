package Frames;

import ClassDAO.CategoriaDAO;
import ClassDAO.CotizaProductoDAO;
import ClassDAO.PaqueteDAO;
import ClassDAO.ProductoDAO;
import ClassDAO.SubcategoriaDAO;
import ClassVO.CategoriaVO;
import ClassVO.CotizaProductoVO;
import ClassVO.CotizacionVO;
import ClassVO.PaqueteVO;
import ClassVO.ProductoVO;
import ClassVO.SubcategoriaVO;
import Tables.TablaCotizaProducto;
import Tables.TablaProducto;
import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CotizarProducto extends javax.swing.JFrame {

    private HacerCotizacion padre;
    private CotizacionVO cotizacion;

    public void setPadre(HacerCotizacion padre) {
        this.padre = padre;
    }

    public void setCotizacion(CotizacionVO cotizacion) {
        this.cotizacion = cotizacion;
    }

    public CotizarProducto() {
        initComponents();
        setLocationRelativeTo(null); //Centra la vantana en la pantalla
        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        AWTUtilities.setWindowShape(this, forma);
        cargarCategorias();
        TablaProducto.cargarProductos(tBusqueda);
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtSubtotal.setEditable(false);
    }

    public void calcularPrecios() {
        if (hayEnTabla()) {
            txtSubtotal.setText(sumarColumnas() + "");
        } else {
            txtSubtotal.setText(0 + "");
        }
    }

    private boolean hayEnTabla() {
        if (TAgregados.getRowCount() > 0) {
            return true;
        }
        return false;
    }

    private double sumarColumnas() {
        double suma = 0;
        if (TAgregados.getRowCount() != 0) {
            for (int i = 0; i < TAgregados.getRowCount(); i++) {
                suma += (Double.parseDouble(TAgregados.getValueAt(i, 2).toString()) * Double.parseDouble(TAgregados.getValueAt(i, 3).toString()));
            }
        }

        return suma;
    }

    private ProductoVO obtenerElementoDeFila(int fila) {
        int idProducto = Integer.parseInt(tBusqueda.getValueAt(fila, 0).toString());
        return ProductoDAO.encontrar(idProducto);
    }

    private ProductoVO obtenerElementoDeAgregados(int fila) {
        if (TAgregados.getSelectedRow() != -1) {
            int idProducto = Integer.parseInt(TAgregados.getValueAt(fila, 0).toString());
            return ProductoDAO.encontrar(idProducto);
        }
        ProductoVO temp = new ProductoVO();
        temp.setId(-1);
        return temp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TAgregados = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        txtSubtotal = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        txtId6 = new javax.swing.JTextField();
        txtId7 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        comboSubCat = new javax.swing.JComboBox<>();
        comboCategoria = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tBusqueda = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(1, 50, 67));
        jPanel2.setForeground(new java.awt.Color(1, 50, 67));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_multiply_30px.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 40, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_minus_50px.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 35, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 40));

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(238, 238, 238));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setBackground(new java.awt.Color(103, 65, 114));
        jLabel21.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(103, 65, 114));
        jLabel21.setText("Subtotal");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, -1, -1));

        jSeparator16.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 370, 10));

        jSeparator18.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, 170, 10));

        jLabel33.setBackground(new java.awt.Color(103, 65, 114));
        jLabel33.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(103, 65, 114));
        jLabel33.setText("Buscar");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(1, 50, 67));
        btnEliminar.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(1, 50, 67));
        btnEliminar.setText("Quitar");
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setRequestFocusEnabled(false);
        btnEliminar.setVerifyInputWhenFocusTarget(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarKeyPressed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 550, 100, 70));

        jLabel17.setBackground(new java.awt.Color(103, 128, 159));
        jLabel17.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(103, 128, 159));
        jLabel17.setText("Cotizacion");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, -1, -1));

        TAgregados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TAgregadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TAgregados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 340, 440));

        btnGuardar.setBackground(new java.awt.Color(1, 50, 67));
        btnGuardar.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(1, 50, 67));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setRequestFocusEnabled(false);
        btnGuardar.setVerifyInputWhenFocusTarget(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, 110, 70));

        txtSubtotal.setBackground(new java.awt.Color(238, 238, 238));
        txtSubtotal.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtSubtotal.setForeground(new java.awt.Color(1, 50, 67));
        txtSubtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSubtotal.setBorder(null);
        jPanel1.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 140, 30));

        txtBuscar.setBackground(new java.awt.Color(238, 238, 238));
        txtBuscar.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(1, 50, 67));
        txtBuscar.setBorder(null);
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 330, 30));

        txtId6.setBackground(new java.awt.Color(238, 238, 238));
        txtId6.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtId6.setForeground(new java.awt.Color(1, 50, 67));
        txtId6.setBorder(null);
        jPanel1.add(txtId6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 140, 30));

        txtId7.setBackground(new java.awt.Color(238, 238, 238));
        txtId7.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtId7.setForeground(new java.awt.Color(1, 50, 67));
        txtId7.setBorder(null);
        jPanel1.add(txtId7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 450, 140, 30));

        jLabel23.setBackground(new java.awt.Color(103, 65, 114));
        jLabel23.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(103, 65, 114));
        jLabel23.setText("Categoría");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        jLabel24.setBackground(new java.awt.Color(103, 65, 114));
        jLabel24.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(103, 65, 114));
        jLabel24.setText("Subcategoría");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        comboSubCat.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        comboSubCat.setForeground(new java.awt.Color(1, 50, 67));
        comboSubCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubCatActionPerformed(evt);
            }
        });
        jPanel1.add(comboSubCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 160, -1));

        comboCategoria.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        comboCategoria.setForeground(new java.awt.Color(1, 50, 67));
        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(comboCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 160, -1));

        tBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tBusquedaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tBusqueda);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 370, 440));

        btnAgregar.setBackground(new java.awt.Color(1, 50, 67));
        btnAgregar.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(1, 50, 67));
        btnAgregar.setText("Agregar");
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setFocusPainted(false);
        btnAgregar.setRequestFocusEnabled(false);
        btnAgregar.setVerifyInputWhenFocusTarget(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        btnAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarKeyPressed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, -1, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_sigma_32px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, -1, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_rounded_rectangle_stroked_127px_1.png"))); // NOI18N
        jLabel4.setText("jLabel2");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 120, 90));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_rounded_rectangle_stroked_127px_1.png"))); // NOI18N
        jLabel6.setText("jLabel2");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 120, 90));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_rounded_rectangle_stroked_127px_1.png"))); // NOI18N
        jLabel7.setText("jLabel2");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 540, 120, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_search_32px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 950, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void cerrar() {
        if (deseaSalir() == 0) {
            System.exit(0);
        } else {
        }
    }

    private int deseaSalir() {
        int dialog = JOptionPane.YES_NO_OPTION;
        return JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "Salir", dialog);
    }

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        this.setState(Menu.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

    private int guardar(int idPaquete) {
        PaqueteVO paquete = obtenerLlenado(idPaquete);
        return PaqueteDAO.actualizar(paquete);
    }

    private PaqueteVO obtenerLlenado(int idPaquete) {
        return null;
    }

    /*
    private void cargarCamposCon(ProductoVO producto) {
        txtDescripcion.setText(producto.getDescripcion());
        txtSubtotal.setText(producto.getPrecio() + "");
        txtImagen.setText("");
    }

    private int registrar() {
        if (datosValidos()) {
            ProductoVO producto = obtenerDatos();
            return (ProductoDAO.insertar(producto));
        }
        return 0;
    }
   
    private boolean fotoValida() {
        try {
            File ruta = new File(txtImagen.getText());
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            return true;
        } catch (Exception ex) {
        }
        return false;
    }

    private boolean camposLlenados() {
        return txtDescripcion.getText().length() != 0 && txtSubtotal.getText().length() != 0 && txtImagen.getText().length() != 0;
    }

    private boolean precioIsDouble() {
        try {
            double precio = Double.parseDouble(txtSubtotal.getText());
            return true;
        } catch (Exception e) {
        }
        return false;
    }
     */
    private int deseaModificar(PaqueteVO encontrado) {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea modificar el paquete " + encontrado.getId() + " : " + encontrado.getDescripcion() + " ?", "Modificar", dialog));
    }

    private void modificar(PaqueteVO paquete) {

    }

    private void regresar() {
        Paquetes paquetes = new Paquetes();
        paquetes.setVisible(true);
        dispose();
    }

    private void TAgregadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TAgregadosMouseClicked
        // TODO add your handling code here:
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_TAgregadosMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        if (txtBuscar.getText().length() != 0) {
            if (comboCategoria.getSelectedIndex() != 0 && comboSubCat.getSelectedIndex() != 0) { //Si hay categoria seleccionada y subcategoria
                //Cargar por subcategoria y texto
                CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
                SubcategoriaVO subcatCombo = SubcategoriaDAO.encontrar(catCombo.getId(), comboSubCat.getSelectedItem() + "");
                TablaProducto.cargarPorSubcategoria(tBusqueda, subcatCombo.getId(), txtBuscar.getText());
            } else if (comboCategoria.getSelectedIndex() != 0) { //Solo categoria
                //Cargar por categoria y texto
                CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
                TablaProducto.cargarPorCategoriaYTexto(tBusqueda, catCombo.getId(), txtBuscar.getText());
            } else {//No hay categoria seleccionada, tampoco subcategoría, cargar solo texto
                TablaProducto.cargarProductos(tBusqueda, txtBuscar.getText());
            }
        } else {//Verificar los otros campos de búsqueda
            if (comboCategoria.getSelectedIndex() != 0 && comboSubCat.getSelectedIndex() != 0) { //Si hay categoria seleccionada y subcategoria
                //Cargar por subcategoría
                CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
                SubcategoriaVO subcatCombo = SubcategoriaDAO.encontrar(catCombo.getId(), comboSubCat.getSelectedItem() + "");
                TablaProducto.cargarPorSubcategoria(tBusqueda, subcatCombo.getId());

            } else if (comboCategoria.getSelectedIndex() != 0) { //Solo categoria
                //Cargar por categoria
                CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
                TablaProducto.cargarPorCategoria(tBusqueda, catCombo.getId());
            } else {//Cargar todo
                TablaProducto.cargarProductos(tBusqueda);
            }
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        padre.setVisible(true);
        padre.cargarProductos(cotizacion.getId());
        padre.calcularPreciosProducto();
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void comboSubCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubCatActionPerformed
        // TODO add your handling code here:
        if (txtBuscar.getText().length() != 0) {
            if (comboCategoria.getSelectedIndex() != 0 && comboSubCat.getSelectedIndex() != 0) { //Si hay categoria seleccionada y subcategoria
                //Cargar por subcategoria y texto
                CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
                SubcategoriaVO subcatCombo = SubcategoriaDAO.encontrar(catCombo.getId(), comboSubCat.getSelectedItem() + "");
                TablaProducto.cargarPorSubcategoria(tBusqueda, subcatCombo.getId(), txtBuscar.getText());
            } else if (comboCategoria.getSelectedIndex() != 0) { //Solo categoria
                //Cargar por categoria y texto
                CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
                TablaProducto.cargarPorCategoriaYTexto(tBusqueda, catCombo.getId(), txtBuscar.getText());
            } else {//No hay categoria seleccionada, tampoco subcategoría, cargar solo texto
                TablaProducto.cargarProductos(tBusqueda, txtBuscar.getText());
            }
        } else {//Verificar los otros campos de búsqueda
            if (comboCategoria.getSelectedIndex() != 0 && comboSubCat.getSelectedIndex() != 0) { //Si hay categoria seleccionada y subcategoria
                //Cargar por subcategoría
                CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
                SubcategoriaVO subcatCombo = SubcategoriaDAO.encontrar(catCombo.getId(), comboSubCat.getSelectedItem() + "");
                TablaProducto.cargarPorSubcategoria(tBusqueda, subcatCombo.getId());

            } else if (comboCategoria.getSelectedIndex() != 0) { //Solo categoria
                //Cargar por categoria
                CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
                TablaProducto.cargarPorCategoria(tBusqueda, catCombo.getId());
            } else {//Cargar todo
                TablaProducto.cargarProductos(tBusqueda);
            }
        }

    }//GEN-LAST:event_comboSubCatActionPerformed

    private void comboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaActionPerformed
        // TODO add your handling code here:
        if (comboCategoria.getSelectedIndex() != 0) {
            CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
            cargarSubcategorias(catCombo.getId());
        } else {
            cargarSubcategorias(-1);
        }

        if (txtBuscar.getText().length() != 0) {
            if (comboCategoria.getSelectedIndex() != 0 && comboSubCat.getSelectedIndex() != 0) { //Si hay categoria seleccionada y subcategoria
                //Cargar por subcategoria y texto
                CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
                SubcategoriaVO subcatCombo = SubcategoriaDAO.encontrar(catCombo.getId(), comboSubCat.getSelectedItem() + "");
                TablaProducto.cargarPorSubcategoria(tBusqueda, subcatCombo.getId(), txtBuscar.getText());
            } else if (comboCategoria.getSelectedIndex() != 0) { //Solo categoria
                //Cargar por categoria y texto
                CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
                TablaProducto.cargarPorCategoriaYTexto(tBusqueda, catCombo.getId(), txtBuscar.getText());
            } else {//No hay categoria seleccionada, tampoco subcategoría, cargar solo texto
                TablaProducto.cargarProductos(tBusqueda, txtBuscar.getText());
            }
        } else {//Verificar los otros campos de búsqueda
            if (comboCategoria.getSelectedIndex() != 0 && comboSubCat.getSelectedIndex() != 0) { //Si hay categoria seleccionada y subcategoria
                //Cargar por subcategoría
                CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
                SubcategoriaVO subcatCombo = SubcategoriaDAO.encontrar(catCombo.getId(), comboSubCat.getSelectedItem() + "");
                TablaProducto.cargarPorSubcategoria(tBusqueda, subcatCombo.getId());

            } else if (comboCategoria.getSelectedIndex() != 0) { //Solo categoria
                //Cargar por categoria
                CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
                TablaProducto.cargarPorCategoria(tBusqueda, catCombo.getId());
            } else {//Cargar todo
                TablaProducto.cargarProductos(tBusqueda);
            }
        }
    }//GEN-LAST:event_comboCategoriaActionPerformed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarKeyPressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        ProductoVO obtenido = obtenerElementoDeAgregados(TAgregados.getSelectedRow());
        if (obtenido.getId() != -1) {
            CotizaProductoVO temp = new CotizaProductoVO();
            temp.setIdProducto(obtenido.getId());
            temp.setIdCotizacion(cotizacion.getId());
            temp.setCantidad(Integer.parseInt(TAgregados.getValueAt(TAgregados.getSelectedRow(), 3).toString()));
            if (CotizaProductoDAO.eliminar(temp) != 0) {
                cargarProductos(cotizacion.getId());
            }
            calcularPrecios();
        } else {
            btnEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    private void tBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBusquedaMouseClicked
        // TODO add your handling code here:
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_tBusquedaMouseClicked


    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (tBusqueda.getSelectedRow() != -1) {
            ProductoVO obtenido = obtenerElementoDeFila(tBusqueda.getSelectedRow());
            try {
                CotizaProductoVO cotizarProducto = new CotizaProductoVO();
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad"));
                if (cantidad > 0) {
                    cotizarProducto.setIdCotizacion(cotizacion.getId());
                    cotizarProducto.setIdProducto(obtenido.getId());
                    cotizarProducto.setCantidad(cantidad);
                    System.out.println(CotizaProductoDAO.insertar(cotizarProducto));
                    cargarProductos(cotizacion.getId());
                    calcularPrecios();
                }
            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private PaqueteVO encontrarCreado() {
        return PaqueteDAO.encontrar("nuevoTemporal123").get(0);
    }


    private void btnAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarKeyPressed

    public void cargarProductos(int idCotizacion) {
        TablaCotizaProducto.cargarProductos(TAgregados, idCotizacion);
    }

    private void cargarBusqueda() {
        /*if (TablaPaquete.cargarPaquetes(tPaquetes, txtBuscar.getText()) <= 0) {//retornar entero si hay datos y hacer if para saber si cargar o no productos
            cargarProductos(0);
        }*/
    }

    private void cargarCategorias() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (CategoriaVO categoria : CategoriaDAO.listar()) {
                combo.addItem(categoria.getNombre());
            }
            comboCategoria.setModel(combo.getModel());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void cargarSubcategorias(int idCategoria) {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (SubcategoriaVO categoria : SubcategoriaDAO.obtenerDeCategoria(idCategoria)) {
                combo.addItem(categoria.getNombre());
            }
            comboSubCat.setModel(combo.getModel());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*
    private ProductoVO obtenerDatos() {
        CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
        SubcategoriaVO subcatCombo = SubcategoriaDAO.encontrar(catCombo.getId(), comboSubCat.getSelectedItem() + "");
        ProductoVO producto = new ProductoVO();
        producto.setDescripcion(txtDescripcion.getText());
        producto.setPrecio(Double.parseDouble(txtSubtotal.getText()));
        producto.setIdSubcategoria(subcatCombo.getId());
        try {
            File ruta = new File(txtImagen.getText());
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            producto.setImagen(icono);
        } catch (Exception ex) {
            producto.setImagen(null);
        }
        return producto;
    }
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CotizarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CotizarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CotizarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CotizarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CotizarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TAgregados;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboSubCat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JTable tBusqueda;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtId6;
    private javax.swing.JTextField txtId7;
    private javax.swing.JTextField txtSubtotal;
    // End of variables declaration//GEN-END:variables
}
