package Frames;

import ClassDAO.CategoriaDAO;
import ClassDAO.ProductoDAO;
import ClassDAO.SubcategoriaDAO;
import ClassVO.CategoriaVO;
import ClassVO.ProductoVO;
import ClassVO.SubcategoriaVO;
import Tables.TablaProducto;
import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Productos extends javax.swing.JFrame {

    private ProductoVO encontrado = new ProductoVO();

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

    private void clean() {
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtImagen.setText("");
        txtBuscar.setText("");
        comboCategoria.setSelectedIndex(0);
        comboSubCat.setSelectedIndex(0);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
    }

    private void cargarTabla() {
        TablaProducto.cargarProductos(tDatos);
    }

    public Productos() {
        initComponents();
        setLocationRelativeTo(null); //Centra la vantana en la pantalla
        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        AWTUtilities.setWindowShape(this, forma);
        cargarTabla();
        cargarCategorias();
        clean();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDatos = new javax.swing.JTable();
        btnIngresar4 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        txtImagen = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtId2 = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtId6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        comboSubCat = new javax.swing.JComboBox<>();
        comboCategoria = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();

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
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 40, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_minus_50px.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 35, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 40));

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(238, 238, 238));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(103, 65, 114));
        jLabel16.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(103, 65, 114));
        jLabel16.setText("Descripción");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel21.setBackground(new java.awt.Color(103, 65, 114));
        jLabel21.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(103, 65, 114));
        jLabel21.setText("Precio");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        jSeparator16.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 360, 10));

        jSeparator17.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 170, 10));

        jSeparator18.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 170, 10));

        jLabel22.setBackground(new java.awt.Color(103, 65, 114));
        jLabel22.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(103, 65, 114));
        jLabel22.setText("Imagen");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jSeparator19.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 270, 10));

        jLabel33.setBackground(new java.awt.Color(103, 65, 114));
        jLabel33.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(103, 65, 114));
        jLabel33.setText("Buscar");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(1, 50, 67));
        btnEliminar.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(1, 50, 67));
        btnEliminar.setText("Eliminar");
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
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 110, 40));

        jLabel17.setBackground(new java.awt.Color(103, 128, 159));
        jLabel17.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(103, 128, 159));
        jLabel17.setText("Producto");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        tDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 360, 440));

        btnIngresar4.setBackground(new java.awt.Color(1, 50, 67));
        btnIngresar4.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnIngresar4.setForeground(new java.awt.Color(1, 50, 67));
        btnIngresar4.setText("Guardar");
        btnIngresar4.setBorderPainted(false);
        btnIngresar4.setContentAreaFilled(false);
        btnIngresar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar4.setFocusPainted(false);
        btnIngresar4.setRequestFocusEnabled(false);
        btnIngresar4.setVerifyInputWhenFocusTarget(false);
        btnIngresar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar4ActionPerformed(evt);
            }
        });
        btnIngresar4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnIngresar4KeyPressed(evt);
            }
        });
        jPanel1.add(btnIngresar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 110, 40));

        btnModificar.setBackground(new java.awt.Color(1, 50, 67));
        btnModificar.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(1, 50, 67));
        btnModificar.setText("Modificar");
        btnModificar.setBorderPainted(false);
        btnModificar.setContentAreaFilled(false);
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setFocusPainted(false);
        btnModificar.setRequestFocusEnabled(false);
        btnModificar.setVerifyInputWhenFocusTarget(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnModificarKeyPressed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 110, 40));

        txtImagen.setBackground(new java.awt.Color(238, 238, 238));
        txtImagen.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtImagen.setForeground(new java.awt.Color(1, 50, 67));
        txtImagen.setBorder(null);
        jPanel1.add(txtImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 240, 30));

        txtPrecio.setBackground(new java.awt.Color(238, 238, 238));
        txtPrecio.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(1, 50, 67));
        txtPrecio.setBorder(null);
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 140, 30));

        txtId2.setEditable(false);
        txtId2.setBackground(new java.awt.Color(238, 238, 238));
        txtId2.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtId2.setForeground(new java.awt.Color(1, 50, 67));
        txtId2.setBorder(null);
        jPanel1.add(txtId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 140, 30));

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
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 330, 30));

        txtDescripcion.setBackground(new java.awt.Color(238, 238, 238));
        txtDescripcion.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(1, 50, 67));
        txtDescripcion.setBorder(null);
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 140, 30));

        txtId6.setBackground(new java.awt.Color(238, 238, 238));
        txtId6.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtId6.setForeground(new java.awt.Color(1, 50, 67));
        txtId6.setBorder(null);
        jPanel1.add(txtId6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 140, 30));

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, -1, -1));

        jLabel1.setText("Atrás");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 200, 70));

        jLabel23.setBackground(new java.awt.Color(103, 65, 114));
        jLabel23.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(103, 65, 114));
        jLabel23.setText("Categoría");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel24.setBackground(new java.awt.Color(103, 65, 114));
        jLabel24.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(103, 65, 114));
        jLabel24.setText("Subcategoría");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));

        comboSubCat.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        comboSubCat.setForeground(new java.awt.Color(1, 50, 67));
        comboSubCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubCatActionPerformed(evt);
            }
        });
        jPanel1.add(comboSubCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 160, -1));

        comboCategoria.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        comboCategoria.setForeground(new java.awt.Color(1, 50, 67));
        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(comboCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 160, -1));

        btnLimpiar.setBackground(new java.awt.Color(1, 50, 67));
        btnLimpiar.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(1, 50, 67));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setRequestFocusEnabled(false);
        btnLimpiar.setVerifyInputWhenFocusTarget(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        btnLimpiar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLimpiarKeyPressed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 560, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 810, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void cerrar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "Salir", dialog);

        if (result == 0) {
            System.exit(0);
        } else {
        }
    }

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        this.setState(Menu.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarKeyPressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (deseaEliminar() == 0) {
            if (ProductoDAO.eliminar(encontrado) > 0) {
                JOptionPane.showMessageDialog(this, "El producto " + encontrado.getId() + " : " + encontrado.getDescripcion() + " ha sido eliminado con éxito");
                clean();
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido eliminar el producto");
            }
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private int deseaEliminar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el producto " + encontrado.getId() + " : " + encontrado.getDescripcion() + " ?", "Eliminar", dialog));
    }

    private void btnIngresar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar4ActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnIngresar4ActionPerformed

    private void guardar() {
        int mensaje = registrar();
        if (mensaje > 0) {
            JOptionPane.showMessageDialog(this, "Producto registrado");
            cargarTabla();
            clean();
        } else {
            JOptionPane.showMessageDialog(this, "No se ha podido registrar el producto");
        }
    }

    private void cargarCamposCon(ProductoVO producto) {
        txtDescripcion.setText(producto.getDescripcion());
        txtPrecio.setText(producto.getPrecio() + "");
        txtImagen.setText("");
    }

    private int registrar() {
        if (datosValidos()) {
            ProductoVO producto = obtenerDatos();
            return (ProductoDAO.insertar(producto));
        }
        return 0;
    }

    private boolean datosValidos() {
        return fotoValida() && camposLlenados() && precioIsDouble() && comboCategoria.getSelectedIndex() != 0 && comboSubCat.getSelectedIndex() != 0;
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
        return txtDescripcion.getText().length() != 0 && txtPrecio.getText().length() != 0 && txtImagen.getText().length() != 0;
    }

    private boolean precioIsDouble() {
        try {
            double precio = Double.parseDouble(txtPrecio.getText());
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    private void btnIngresar4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIngresar4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresar4KeyPressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (deseaModificar() == 0) {
            if (txtImagen.getText().length() != 0) { //En caso de que también se haya modificado la imagen
                int mensaje = modificar();
                if (mensaje > 0) {
                    JOptionPane.showMessageDialog(this, "El producto ha sido modificado");
                    cargarTabla();
                    clean();
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha podido modificar el producto");
                }
            } else {
                int mensaje = modificarNoImagen();
                if (mensaje > 0) {
                    JOptionPane.showMessageDialog(this, "El producto ha sido modificado");
                    cargarTabla();
                    clean();
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha podido modificar el producto");
                }
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private int deseaModificar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea modificar el producto " + encontrado.getId() + " : " + encontrado.getDescripcion() + " ?", "Modificar", dialog));
    }

    private int modificarNoImagen() {
        if (datosValidosMinusImage()) {
            ProductoVO producto = obtenerDatosMinusImage();
            int fila = tDatos.getSelectedRow();
            producto.setId(Integer.parseInt(tDatos.getValueAt(fila, 0).toString()));
            return (ProductoDAO.actualizar(producto, false));
        }
        return 0;

    }

    private ProductoVO obtenerDatosMinusImage() {
        CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
        SubcategoriaVO subcatCombo = SubcategoriaDAO.encontrar(catCombo.getId(), comboSubCat.getSelectedItem() + "");
        ProductoVO producto = new ProductoVO();
        producto.setDescripcion(txtDescripcion.getText());
        producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
        producto.setIdSubcategoria(subcatCombo.getId());
        return producto;

    }

    private boolean datosValidosMinusImage() {
        return camposLlenadosMinusImage() && precioIsDouble() && comboCategoria.getSelectedIndex() != 0 && comboSubCat.getSelectedIndex() != 0;
    }

    private boolean camposLlenadosMinusImage() {
        return txtDescripcion.getText().length() != 0 && txtPrecio.getText().length() != 0;
    }

    private int modificar() {
        if (datosValidos()) {
            ProductoVO producto = obtenerDatos();
            int fila = tDatos.getSelectedRow();
            producto.setId(Integer.parseInt(tDatos.getValueAt(fila, 0).toString()));
            return (ProductoDAO.actualizar(producto, true));
        }
        return 0;
    }

    private void btnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        int s = j.showOpenDialog(this);
        if (s == JFileChooser.APPROVE_OPTION) {
            String ruta = j.getSelectedFile().getAbsolutePath();
            txtImagen.setText(ruta);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void tDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDatosMouseClicked
        // TODO add your handling code here:
        ProductoVO enTabla = obtenerElementoDePosicion(tDatos.getSelectedRow());
        encontrado = ProductoDAO.encontrar(enTabla.getId());
        SubcategoriaVO subcatFound = SubcategoriaDAO.encontrar(encontrado.getIdSubcategoria());
        CategoriaVO catFound = CategoriaDAO.encontrar(subcatFound.getIdCategoria());

        txtDescripcion.setText(encontrado.getDescripcion());
        txtPrecio.setText(encontrado.getPrecio() + "");
        comboCategoria.setSelectedItem(catFound.getNombre());
        comboSubCat.setSelectedItem(subcatFound.getNombre());

        btnEliminar.setEnabled(true);
        btnModificar.setEnabled(true);
        //comboCategoria.setSelectedItem();
    }//GEN-LAST:event_tDatosMouseClicked

    private void comboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaActionPerformed
        // TODO add your handling code here:
        if (comboCategoria.getSelectedIndex() != 0) {
            CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
            cargarSubcategorias(catCombo.getId());
        } else {
            cargarSubcategorias(-1);
        }
    }//GEN-LAST:event_comboCategoriaActionPerformed

    private void comboSubCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubCatActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_comboSubCatActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        clean();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnLimpiarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLimpiarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarKeyPressed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        if(txtBuscar.getText().length()!=0){
            cargarBusqueda();
        }
        else{
            cargarTabla();
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void cargarBusqueda(){
            TablaProducto.cargarProductos(tDatos,txtBuscar.getText());
    }
    
    private ProductoVO obtenerElementoDePosicion(int fila) {
        ProductoVO producto = new ProductoVO();
        producto.setId(Integer.parseInt(tDatos.getValueAt(fila, 0).toString()));
        producto.setDescripcion(tDatos.getValueAt(fila, 1).toString());
        producto.setPrecio(Double.parseDouble(tDatos.getValueAt(fila, 2).toString()));
        return producto;
    }

    private ProductoVO obtenerDatos() {
        CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
        SubcategoriaVO subcatCombo = SubcategoriaDAO.encontrar(catCombo.getId(), comboSubCat.getSelectedItem() + "");
        ProductoVO producto = new ProductoVO();
        producto.setDescripcion(txtDescripcion.getText());
        producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar4;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboSubCat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JTable tDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId2;
    private javax.swing.JTextField txtId6;
    private javax.swing.JTextField txtImagen;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
