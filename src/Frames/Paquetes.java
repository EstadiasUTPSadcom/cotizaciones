package Frames;

import ClassDAO.PaqueteDAO;
import ClassVO.PaqueteVO;
import Tables.TablaPaquete;
import Tables.TablaProducto;
import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;

public class Paquetes extends javax.swing.JFrame {

    private void clean() {
        txtDescripcion.setText("");
        txtDescuento.setText("");
        txtSubtotal.setText("");
        txtPrecio.setText("");
        txtBuscar.setText("");
        deshabilitarBotones();
        
        txtDescripcion.setEditable(false);
        txtDescuento.setEditable(false);
        txtSubtotal.setEditable(false);
        txtPrecio.setEditable(false);
    }

    private void cargarTabla() {
        TablaPaquete.cargarPaquetes(tPaquetes);
    }

    public Paquetes() {
        initComponents();
        setLocationRelativeTo(null); //Centra la vantana en la pantalla
        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        AWTUtilities.setWindowShape(this, forma);
        cargarTabla();
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
        jLabel33 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TProductos = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        txtSubtotal = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtId6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        txtPrecio = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtId7 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tPaquetes = new javax.swing.JTable();

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

        jLabel16.setBackground(new java.awt.Color(103, 65, 114));
        jLabel16.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(103, 65, 114));
        jLabel16.setText("Descripción");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, -1, -1));

        jLabel21.setBackground(new java.awt.Color(103, 65, 114));
        jLabel21.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(103, 65, 114));
        jLabel21.setText("Subtotal");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, -1, -1));

        jSeparator16.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 370, 10));

        jSeparator17.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 170, 10));

        jSeparator18.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, 170, 10));

        jLabel33.setBackground(new java.awt.Color(103, 65, 114));
        jLabel33.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(103, 65, 114));
        jLabel33.setText("Buscar");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

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
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 550, 110, 40));

        jLabel17.setBackground(new java.awt.Color(103, 128, 159));
        jLabel17.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(103, 128, 159));
        jLabel17.setText("Paquete");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, -1));

        TProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 370, 440));

        btnNuevo.setBackground(new java.awt.Color(1, 50, 67));
        btnNuevo.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(1, 50, 67));
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setRequestFocusEnabled(false);
        btnNuevo.setVerifyInputWhenFocusTarget(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 490, 110, 40));

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
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 490, 110, 40));

        txtSubtotal.setBackground(new java.awt.Color(238, 238, 238));
        txtSubtotal.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtSubtotal.setForeground(new java.awt.Color(1, 50, 67));
        txtSubtotal.setBorder(null);
        jPanel1.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, 140, 30));

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
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 340, 30));

        txtDescripcion.setBackground(new java.awt.Color(238, 238, 238));
        txtDescripcion.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(1, 50, 67));
        txtDescripcion.setBorder(null);
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 140, 30));

        txtId6.setBackground(new java.awt.Color(238, 238, 238));
        txtId6.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtId6.setForeground(new java.awt.Color(1, 50, 67));
        txtId6.setBorder(null);
        jPanel1.add(txtId6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, 140, 30));

        jLabel1.setText("Atrás");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 200, 70));

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
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 550, 110, 40));

        jLabel18.setBackground(new java.awt.Color(103, 65, 114));
        jLabel18.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(103, 65, 114));
        jLabel18.setText("Descuento (%)");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, -1, -1));

        jLabel22.setBackground(new java.awt.Color(103, 65, 114));
        jLabel22.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(103, 65, 114));
        jLabel22.setText("Precio");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, -1, -1));

        jSeparator19.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 170, 10));

        jSeparator20.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 170, 10));

        txtPrecio.setBackground(new java.awt.Color(238, 238, 238));
        txtPrecio.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(1, 50, 67));
        txtPrecio.setBorder(null);
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, 140, 30));

        txtDescuento.setBackground(new java.awt.Color(238, 238, 238));
        txtDescuento.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtDescuento.setForeground(new java.awt.Color(1, 50, 67));
        txtDescuento.setBorder(null);
        jPanel1.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 140, 30));

        txtId7.setBackground(new java.awt.Color(238, 238, 238));
        txtId7.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtId7.setForeground(new java.awt.Color(1, 50, 67));
        txtId7.setBorder(null);
        jPanel1.add(txtId7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, 140, 30));

        tPaquetes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tPaquetesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tPaquetes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 250, 440));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 950, 620));

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
    
    private int deseaEliminar(PaqueteVO encontrado) {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el paquete " + encontrado.getId() + " : " + encontrado.getDescripcion() + " ?", "Eliminar", dialog));
    }
/*
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

    private int deseaModificar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea modificar el producto " + encontrado.getId() + " : " + encontrado.getDescripcion() + " ?", "Modificar", dialog));
    }

    private int modificarNoImagen() {
        if (datosValidosMinusImage()) {
            ProductoVO producto = obtenerDatosMinusImage();
            int fila = TProductos.getSelectedRow();
            producto.setId(Integer.parseInt(TProductos.getValueAt(fila, 0).toString()));
            return (ProductoDAO.actualizar(producto, false));
        }
        return 0;

    }

    private ProductoVO obtenerDatosMinusImage() {
        CategoriaVO catCombo = CategoriaDAO.encontrar(comboCategoria.getSelectedItem() + "");
        SubcategoriaVO subcatCombo = SubcategoriaDAO.encontrar(catCombo.getId(), comboSubCat.getSelectedItem() + "");
        ProductoVO producto = new ProductoVO();
        producto.setDescripcion(txtDescripcion.getText());
        producto.setPrecio(Double.parseDouble(txtSubtotal.getText()));
        producto.setIdSubcategoria(subcatCombo.getId());
        return producto;

    }

    private boolean datosValidosMinusImage() {
        return camposLlenadosMinusImage() && precioIsDouble() && comboCategoria.getSelectedIndex() != 0 && comboSubCat.getSelectedIndex() != 0;
    }

    private boolean camposLlenadosMinusImage() {
        return txtDescripcion.getText().length() != 0 && txtSubtotal.getText().length() != 0;
    }

    private int modificar() {
        if (datosValidos()) {
            ProductoVO producto = obtenerDatos();
            int fila = TProductos.getSelectedRow();
            producto.setId(Integer.parseInt(TProductos.getValueAt(fila, 0).toString()));
            return (ProductoDAO.actualizar(producto, true));
        }
        return 0;
    }
     */
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked


    private void TProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TProductosMouseClicked
        // TODO add your handling code here:
        /*ProductoVO enTabla = obtenerElementoDePosicion(TProductos.getSelectedRow());
        encontrado = ProductoDAO.encontrar(enTabla.getId());
        SubcategoriaVO subcatFound = SubcategoriaDAO.encontrar(encontrado.getIdSubcategoria());
        CategoriaVO catFound = CategoriaDAO.encontrar(subcatFound.getIdCategoria());

        txtDescripcion.setText(encontrado.getDescripcion());
        txtSubtotal.setText(encontrado.getPrecio() + "");
        comboCategoria.setSelectedItem(catFound.getNombre());
        comboSubCat.setSelectedItem(subcatFound.getNombre());

        btnEliminar.setEnabled(true);
        btnModificar.setEnabled(true);
        //comboCategoria.setSelectedItem();*/
    }//GEN-LAST:event_TProductosMouseClicked

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
            cargarProductos(0);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarKeyPressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        /*if (deseaModificar() == 0) {
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
        }*/
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        //guardar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarKeyPressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        PaqueteVO seleccionado = obtenerElementoDeFila(tPaquetes.getSelectedRow());
         if (deseaEliminar(seleccionado) == 0) {
            if (PaqueteDAO.eliminar(seleccionado) > 0) {
                JOptionPane.showMessageDialog(this, "El paquete " + seleccionado.getId() + " : " + seleccionado.getDescripcion() + " ha sido eliminado con éxito");
                clean();
                cargarTabla();
                cargarProductos(0);
            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido eliminar el paquete");
            }
        }
         
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tPaquetesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPaquetesMouseClicked
        // TODO add your handling code here:
        cargarProductos(Integer.parseInt(tPaquetes.getValueAt(tPaquetes.getSelectedRow(), 0).toString()));
        PaqueteVO seleccionado = obtenerElementoDeFila(tPaquetes.getSelectedRow());
        llenarCampos(seleccionado);
        habilitarBotones();
    }//GEN-LAST:event_tPaquetesMouseClicked
    
    private void cargarProductos(int idPaquete){
        TablaProducto.cargarProductos(TProductos, idPaquete);
    }
    
    private void habilitarBotones(){
        btnEliminar.setEnabled(true);
        btnModificar.setEnabled(true);
    }
    
    private void deshabilitarBotones(){
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
    }
    
    private void cargarBusqueda(){
        TablaPaquete.cargarPaquetes(tPaquetes,txtBuscar.getText()); //retornar entero si hay datos y hacer if para saber si cargar o no productos
    }
     
    private void llenarCampos(PaqueteVO paquete) {
        txtDescripcion.setText(paquete.getDescripcion());
        txtDescuento.setText(paquete.getDescuento()+"");
        txtSubtotal.setText(paquete.getSuma()+"");
        txtPrecio.setText(paquete.getPrecio()+ "");
    }

    private PaqueteVO obtenerElementoDeFila(int fila) {
        int idPaquete = Integer.parseInt(tPaquetes.getValueAt(fila, 0).toString());
        return PaqueteDAO.encontrar(idPaquete);
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
            java.util.logging.Logger.getLogger(Paquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Paquetes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TProductos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JTable tPaquetes;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtId6;
    private javax.swing.JTextField txtId7;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSubtotal;
    // End of variables declaration//GEN-END:variables
}