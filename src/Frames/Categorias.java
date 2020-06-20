package Frames;

import ClassDAO.CategoriaDAO;
import ClassDAO.ProductoDAO;
import ClassDAO.SubcategoriaDAO;
import ClassVO.CategoriaVO;
import ClassVO.ProductoVO;
import ClassVO.SubcategoriaVO;
import Tables.TablaCategoria;
import Tables.TablaProducto;
import Tables.TablaSubcategoria;
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

public class Categorias extends javax.swing.JFrame {

    private void clean(){
        txtSub.setText("");
        comboCategoria.setSelectedIndex(0);
    }
    
    private void cargarCategorias() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (CategoriaVO categoria : CategoriaDAO.listar()) {
                combo.addItem(categoria.getNombre() + "");
            }
            comboCategoria.setModel(combo.getModel());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void cargarTabla() {
        TablaCategoria.cargarCategoria(tCategorias);
    }

    private void cargarSubcategoria(CategoriaVO categoria) {
        TablaSubcategoria.cargarCategorias(tSubcategorias, categoria.getId());
    }

    public Categorias() {
        initComponents();
        setLocationRelativeTo(null); //Centra la vantana en la pantalla
        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        AWTUtilities.setWindowShape(this, forma);
        cargarTabla();
        cargarCategorias();
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
        jSeparator18 = new javax.swing.JSeparator();
        btnIngresar3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCategorias = new javax.swing.JTable();
        btnIngresar4 = new javax.swing.JButton();
        txtSub = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tSubcategorias = new javax.swing.JTable();
        comboCategoria = new javax.swing.JComboBox<>();
        btnIngresar5 = new javax.swing.JButton();

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(238, 238, 238));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(103, 65, 114));
        jLabel16.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(103, 65, 114));
        jLabel16.setText("Categoría");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel21.setBackground(new java.awt.Color(103, 65, 114));
        jLabel21.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(103, 65, 114));
        jLabel21.setText("Subcategoría");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jSeparator18.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 170, 10));

        btnIngresar3.setBackground(new java.awt.Color(1, 50, 67));
        btnIngresar3.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnIngresar3.setForeground(new java.awt.Color(1, 50, 67));
        btnIngresar3.setText("Limpiar");
        btnIngresar3.setBorderPainted(false);
        btnIngresar3.setContentAreaFilled(false);
        btnIngresar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar3.setFocusPainted(false);
        btnIngresar3.setRequestFocusEnabled(false);
        btnIngresar3.setVerifyInputWhenFocusTarget(false);
        btnIngresar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar3ActionPerformed(evt);
            }
        });
        btnIngresar3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnIngresar3KeyPressed(evt);
            }
        });
        jPanel1.add(btnIngresar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 110, 40));

        jLabel17.setBackground(new java.awt.Color(103, 128, 159));
        jLabel17.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(103, 128, 159));
        jLabel17.setText("Categorías");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, -1));

        tCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tCategorias);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 230, 360));

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
        jPanel1.add(btnIngresar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 110, 40));

        txtSub.setBackground(new java.awt.Color(238, 238, 238));
        txtSub.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtSub.setForeground(new java.awt.Color(1, 50, 67));
        txtSub.setBorder(null);
        jPanel1.add(txtSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 140, 30));

        jButton1.setText("Nueva");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        jLabel1.setText("Atrás");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 200, 70));

        jLabel18.setBackground(new java.awt.Color(103, 128, 159));
        jLabel18.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(103, 128, 159));
        jLabel18.setText("Subcategorias");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, -1));

        tSubcategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tSubcategoriasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tSubcategorias);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 230, 360));

        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(comboCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 190, 30));

        btnIngresar5.setBackground(new java.awt.Color(1, 50, 67));
        btnIngresar5.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnIngresar5.setForeground(new java.awt.Color(1, 50, 67));
        btnIngresar5.setText("Eliminar");
        btnIngresar5.setBorderPainted(false);
        btnIngresar5.setContentAreaFilled(false);
        btnIngresar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar5.setFocusPainted(false);
        btnIngresar5.setRequestFocusEnabled(false);
        btnIngresar5.setVerifyInputWhenFocusTarget(false);
        btnIngresar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar5ActionPerformed(evt);
            }
        });
        btnIngresar5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnIngresar5KeyPressed(evt);
            }
        });
        jPanel1.add(btnIngresar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 800, 460));

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

    private void btnIngresar3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIngresar3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresar3KeyPressed

    private void btnIngresar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar3ActionPerformed
        // TODO add your handling code here:
        clean();
    }//GEN-LAST:event_btnIngresar3ActionPerformed

    private void btnIngresar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar4ActionPerformed
        // TODO add your handling code here:
        if (comboCategoria.getSelectedIndex() != 0 && txtSub.getText().length() != 0) {
            CategoriaVO seleccionada = buscarSeleccionada(); //Busca en bd categoria 
            SubcategoriaVO subcategoria = obtenerDatos(seleccionada);
            if (insertar(subcategoria) > 0) {
                JOptionPane.showMessageDialog(this, "Guardado correctamente");
                cargarSubcategoria(seleccionada);
                clean();
            }
        }
    }//GEN-LAST:event_btnIngresar4ActionPerformed

    private int insertar(SubcategoriaVO subcategoria) {
        return SubcategoriaDAO.insertar(subcategoria);
    }

    private CategoriaVO buscarSeleccionada() {
        //System.out.println(comboCategoria.getSelectedItem().toString());
        return CategoriaDAO.encontrar(comboCategoria.getSelectedItem().toString());
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

    
    private void cargarCamposCon(ProductoVO producto){
        
        txtSubCat.setText(producto.getPrecio() + "");
        
    }
     */

 /*
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
        return txtDescripcion.getText().length() != 0 && txtSubCat.getText().length() != 0 && txtImagen.getText().length() != 0;
    }

    private boolean precioIsDouble() {
        try {
            double precio = Double.parseDouble(txtSubCat.getText());
            return true;
        } catch (Exception e) {
        }
        return false;
    }

     */
    private void btnIngresar4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIngresar4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresar4KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CategoriaVO auxiliar = null;
        String nuevo = JOptionPane.showInputDialog(
                this,
                "Ingrese el nombre de la categoría a registrar",
                "Nueva categoría",
                JOptionPane.INFORMATION_MESSAGE
        );

        if (nuevo != null && nuevo.length() != 0) {
            auxiliar = new CategoriaVO();
            auxiliar.setId(1);
            auxiliar.setNombre(nuevo);
            if (!(CategoriaDAO.insertar(auxiliar) > 0)) {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error");
            } else {
                cargarCategorias();
                cargarTabla();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void tCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tCategoriasMouseClicked
        // TODO add your handling code here:
        CategoriaVO seleccionada = obtenerElementoDePosicion(tCategorias.getSelectedRow());
        cargarSubcategoria(seleccionada);
        comboCategoria.setSelectedItem(seleccionada.getNombre());
    }//GEN-LAST:event_tCategoriasMouseClicked

    private void tSubcategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tSubcategoriasMouseClicked
        // TODO add your handling code here:
        int fila = tSubcategorias.getSelectedRow();
        txtSub.setText(tSubcategorias.getValueAt(fila, 1).toString());
        
    }//GEN-LAST:event_tSubcategoriasMouseClicked

    private void comboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoriaActionPerformed

    private void btnIngresar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresar5ActionPerformed

    private void btnIngresar5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIngresar5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresar5KeyPressed

    private CategoriaVO obtenerElementoDePosicion(int fila) {
        CategoriaVO categoriaElemento = new CategoriaVO();
        categoriaElemento.setId(Integer.parseInt(tCategorias.getValueAt(fila, 0).toString()));
        categoriaElemento.setNombre(tCategorias.getValueAt(fila, 1).toString());
        //txtRuta.setText(tColonias.getValueAt(fila, 2).toString())
        return categoriaElemento;
    }

    private SubcategoriaVO obtenerDatos(CategoriaVO categoria) {
        SubcategoriaVO subcategoria = new SubcategoriaVO();
        subcategoria.setIdCategoria(categoria.getId());
        subcategoria.setNombre(txtSub.getText());
        return subcategoria;
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
            java.util.logging.Logger.getLogger(Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Categorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar3;
    private javax.swing.JButton btnIngresar4;
    private javax.swing.JButton btnIngresar5;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JTable tCategorias;
    private javax.swing.JTable tSubcategorias;
    private javax.swing.JTextField txtSub;
    // End of variables declaration//GEN-END:variables
}
