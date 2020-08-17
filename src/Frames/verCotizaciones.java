package Frames;

import ClassDAO.CotizacionDAO;
import ClassVO.CotizacionVO;
import Conexion.Conexion;
import Tables.TablaCotizaciones;
import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.Date;
import javax.swing.JOptionPane;

public class verCotizaciones extends javax.swing.JFrame {
    
    private Date fecha = Conexion.getFechaActual();
    private Menu menu = null;
    private CotizacionVO seleccionado = new CotizacionVO();
    
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    public verCotizaciones() {
        initComponents();
        setLocationRelativeTo(null); //Centra la vantana en la pantalla
        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        AWTUtilities.setWindowShape(this, forma);
        dateFecha.setDate(fecha);
        btnVer.setEnabled(false);
        deshabilitarCampos();
    }
    
    private void deshabilitarCampos(){
        txtDescripcionF.setEditable(false);
        txtSubtotal.setEditable(false);
        txtTotal.setEditable(false);
        txtIva.setEditable(false);
        txtLugarF.setEditable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        dateFecha = new com.toedter.calendar.JDateChooser();
        btnVer = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        txtDescripcion = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        txtLugar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCotizaciones = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        txtSubtotal = new javax.swing.JTextField();
        txtDescripcionF = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        txtTotal = new javax.swing.JTextField();
        txtLugarF = new javax.swing.JTextField();
        txtId7 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jSeparator23 = new javax.swing.JSeparator();
        txtIva = new javax.swing.JTextField();
        txtId8 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        dateFechaF = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(129, 207, 224));
        jPanel1.setForeground(new java.awt.Color(129, 207, 224));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 50));

        dateFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateFechaPropertyChange(evt);
            }
        });
        jPanel1.add(dateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 150, 40));

        btnVer.setBackground(new java.awt.Color(1, 50, 67));
        btnVer.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnVer.setForeground(new java.awt.Color(1, 50, 67));
        btnVer.setText("Ver");
        btnVer.setBorderPainted(false);
        btnVer.setContentAreaFilled(false);
        btnVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVer.setFocusPainted(false);
        btnVer.setRequestFocusEnabled(false);
        btnVer.setVerifyInputWhenFocusTarget(false);
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        btnVer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnVerKeyPressed(evt);
            }
        });
        jPanel1.add(btnVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, 90, 70));

        jLabel52.setBackground(new java.awt.Color(103, 65, 114));
        jLabel52.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(103, 65, 114));
        jLabel52.setText("Fecha");
        jPanel1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, 20));

        jLabel21.setBackground(new java.awt.Color(103, 65, 114));
        jLabel21.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(103, 65, 114));
        jLabel21.setText("Descripcion");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        jSeparator18.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 240, 10));

        txtDescripcion.setBackground(new java.awt.Color(129, 207, 224));
        txtDescripcion.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(1, 50, 67));
        txtDescripcion.setBorder(null);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 210, 30));

        jLabel22.setBackground(new java.awt.Color(103, 65, 114));
        jLabel22.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(103, 65, 114));
        jLabel22.setText("Lugar");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, -1, -1));

        jSeparator19.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 230, 10));

        txtLugar.setBackground(new java.awt.Color(129, 207, 224));
        txtLugar.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtLugar.setForeground(new java.awt.Color(1, 50, 67));
        txtLugar.setBorder(null);
        txtLugar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLugarKeyReleased(evt);
            }
        });
        jPanel1.add(txtLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 200, 30));

        tCotizaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tCotizacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tCotizaciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 560, 500));

        jLabel16.setBackground(new java.awt.Color(103, 65, 114));
        jLabel16.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(103, 65, 114));
        jLabel16.setText("Descripción");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, -1, -1));

        jLabel23.setBackground(new java.awt.Color(103, 65, 114));
        jLabel23.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(103, 65, 114));
        jLabel23.setText("Subtotal");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, -1, -1));

        jSeparator17.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 350, 10));

        jSeparator20.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, 160, 10));

        txtSubtotal.setBackground(new java.awt.Color(129, 207, 224));
        txtSubtotal.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtSubtotal.setForeground(new java.awt.Color(1, 50, 67));
        txtSubtotal.setBorder(null);
        txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalActionPerformed(evt);
            }
        });
        jPanel1.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, 130, 30));

        txtDescripcionF.setBackground(new java.awt.Color(129, 207, 224));
        txtDescripcionF.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtDescripcionF.setForeground(new java.awt.Color(1, 50, 67));
        txtDescripcionF.setBorder(null);
        txtDescripcionF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionFKeyReleased(evt);
            }
        });
        jPanel1.add(txtDescripcionF, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 320, 30));

        jLabel18.setBackground(new java.awt.Color(103, 65, 114));
        jLabel18.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(103, 65, 114));
        jLabel18.setText("Negocio o familia");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, -1, -1));

        jLabel24.setBackground(new java.awt.Color(103, 65, 114));
        jLabel24.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(103, 65, 114));
        jLabel24.setText("Total");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, -1, -1));

        jSeparator21.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, 350, 10));

        jSeparator22.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 170, 10));

        txtTotal.setBackground(new java.awt.Color(129, 207, 224));
        txtTotal.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(1, 50, 67));
        txtTotal.setBorder(null);
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 140, 30));

        txtLugarF.setBackground(new java.awt.Color(129, 207, 224));
        txtLugarF.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtLugarF.setForeground(new java.awt.Color(1, 50, 67));
        txtLugarF.setBorder(null);
        txtLugarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLugarFActionPerformed(evt);
            }
        });
        txtLugarF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLugarFKeyReleased(evt);
            }
        });
        jPanel1.add(txtLugarF, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, 320, 30));

        txtId7.setBackground(new java.awt.Color(238, 238, 238));
        txtId7.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtId7.setForeground(new java.awt.Color(1, 50, 67));
        txtId7.setBorder(null);
        jPanel1.add(txtId7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 140, 30));

        jLabel25.setBackground(new java.awt.Color(103, 65, 114));
        jLabel25.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(103, 65, 114));
        jLabel25.setText("I.V.A.");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, -1, -1));

        jSeparator23.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 380, 170, 10));

        txtIva.setBackground(new java.awt.Color(129, 207, 224));
        txtIva.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtIva.setForeground(new java.awt.Color(1, 50, 67));
        txtIva.setBorder(null);
        txtIva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIvaKeyReleased(evt);
            }
        });
        jPanel1.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 350, 140, 30));

        txtId8.setBackground(new java.awt.Color(238, 238, 238));
        txtId8.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtId8.setForeground(new java.awt.Color(1, 50, 67));
        txtId8.setBorder(null);
        jPanel1.add(txtId8, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 350, 140, 30));

        jLabel33.setBackground(new java.awt.Color(103, 65, 114));
        jLabel33.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(103, 65, 114));
        jLabel33.setText("Fecha");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, -1, -1));

        dateFechaF.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                dateFechaFComponentAdded(evt);
            }
        });
        dateFechaF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dateFechaFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateFechaFFocusLost(evt);
            }
        });
        dateFechaF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateFechaFMouseClicked(evt);
            }
        });
        dateFechaF.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateFechaFPropertyChange(evt);
            }
        });
        jPanel1.add(dateFechaF, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 170, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGOSAD200.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 220, 90));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_rounded_rectangle_stroked_127px_1.png"))); // NOI18N
        jLabel14.setText("jLabel2");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 130, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1000, 660));

        jPanel2.setBackground(new java.awt.Color(52, 73, 94));
        jPanel2.setForeground(new java.awt.Color(52, 73, 94));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_multiply_30px.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 38, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_minus_50px.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 35, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_jLabel1MouseClicked
    
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

    private void dateFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateFechaPropertyChange
        // TODO add your handling code here:
        evaluar();

    }//GEN-LAST:event_dateFechaPropertyChange
    
    private boolean fechaValida() {
        try {
            Date fecha = Conexion.aSqlDate(dateFecha.getDate());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnVerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnVerKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerKeyPressed

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        // TODO add your handling code here:
        evaluar();

    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void txtLugarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLugarKeyReleased
        // TODO add your handling code here:
        evaluar();
    }//GEN-LAST:event_txtLugarKeyReleased

    private void tCotizacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tCotizacionesMouseClicked
        // TODO add your handling code here:
        if (tCotizaciones.getSelectedRow() != -1) {
            seleccionado = CotizacionDAO.encontrar(Integer.parseInt(tCotizaciones.getValueAt(tCotizaciones.getSelectedRow(), 0).toString()));
            llenar();
            btnVer.setEnabled(true);
        }
    }//GEN-LAST:event_tCotizacionesMouseClicked

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void txtDescripcionFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionFKeyReleased
        // TODO add your handling code here:
      
    }//GEN-LAST:event_txtDescripcionFKeyReleased

    private void txtLugarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLugarFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLugarFActionPerformed

    private void txtLugarFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLugarFKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtLugarFKeyReleased

    private void txtIvaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIvaKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtIvaKeyReleased

    private void dateFechaFComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_dateFechaFComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFechaFComponentAdded

    private void dateFechaFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFechaFFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFechaFFocusGained

    private void dateFechaFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFechaFFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFechaFFocusLost

    private void dateFechaFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateFechaFMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFechaFMouseClicked

    private void dateFechaFPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateFechaFPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_dateFechaFPropertyChange

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked
    
    private void llenar(){
    txtDescripcionF.setText(seleccionado.getDescripcion());
    txtSubtotal.setText(seleccionado.getSubtotal()+"");
    txtTotal.setText(seleccionado.getTotal()+"");
    txtLugarF.setText(seleccionado.getLugar());
    dateFechaF.setDate(seleccionado.getFecha());
    txtIva.setText((seleccionado.getTotal()/seleccionado.getSubtotal()-1)*100+"");
    }
    
    private void evaluar() {
        if (txtDescripcion.getText().length() != 0) {
            if (txtLugar.getText().length() != 0) {
                if (fechaValida()) {
                    ///Por los tres
                    TablaCotizaciones.cargarCotizacionesPorTres(tCotizaciones, Conexion.aSqlDate(dateFecha.getDate()), txtDescripcion.getText(), txtLugar.getText());
                } else {
                    //Por descripcion y lugar
                    TablaCotizaciones.cargarCotizacionesPorDescripcionLugar(tCotizaciones, txtDescripcion.getText(), txtLugar.getText());
                }
            } else {
                if (fechaValida()) {
                    //Por descripcion y fecha
                    TablaCotizaciones.cargarCotizacionesPorFechaDescripcion(tCotizaciones, Conexion.aSqlDate(dateFecha.getDate()), txtDescripcion.getText());
                } else {
                    //Por pura descripcion
                    TablaCotizaciones.cargarCotizacionesPorDescripcion(tCotizaciones, txtDescripcion.getText());
                }
            }
        } else {
            if (txtLugar.getText().length() != 0) {
                if (fechaValida()) {
                    ///Por lugar y fecha
                    TablaCotizaciones.cargarCotizacionesPorFechaLugar(tCotizaciones, Conexion.aSqlDate(dateFecha.getDate()), txtLugar.getText());
                } else {
                    //Por puro lugar
                    TablaCotizaciones.cargarCotizacionesPorLugar(tCotizaciones, txtLugar.getText());
                }
            } else {
                if (fechaValida()) {
                    //Por pura fecha
                    TablaCotizaciones.cargarCotizacionesPorFecha(tCotizaciones, Conexion.aSqlDate(dateFecha.getDate()));
                } else {
                    //Todo
                    TablaCotizaciones.cargarCotizaciones(tCotizaciones);
                }
            }
        }
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
            java.util.logging.Logger.getLogger(verCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verCotizaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVer;
    private com.toedter.calendar.JDateChooser dateFecha;
    private com.toedter.calendar.JDateChooser dateFechaF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JTable tCotizaciones;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDescripcionF;
    private javax.swing.JTextField txtId7;
    private javax.swing.JTextField txtId8;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtLugar;
    private javax.swing.JTextField txtLugarF;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
