package Frames;

import ClassDAO.CotizacionDAO;
import ClassDAO.PaqueteDAO;
import ClassVO.CotizacionVO;
import ClassVO.PaqueteVO;
import Conexion.Conexion;
import Tables.TablaCotizaPaquete;
import Tables.TablaCotizaProducto;
import Tables.TablaPaquete;
import Tables.TablaProducto;
import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;

public class HacerCotizacion extends javax.swing.JFrame {
    
    private boolean haSidoCreado = false;
    private CotizacionVO creado = new CotizacionVO();
    private double totalProductos = 0;
    private double totalPaquetes = 0;
    
    private void clean() {
        txtDescripcion.setText("");
        txtLugar.setText("");
        txtSubtotal.setText("");
        txtTotal.setText("");
        txtIva.setText("");
        deshabilitarBotones();
        cargarProductos(0);
        txtSubtotal.setEditable(false);
        txtTotal.setEditable(false);
    }
    
    public void calcularPreciosProducto() {
        if (hayEnProductos()) {
            totalProductos = sumarColumnasProductos();
            txtSubtotal.setText((totalPaquetes + totalProductos) + "");
        } else {
            txtSubtotal.setText(totalPaquetes + "");
        }
        calcularTotal();
    }
    
    public void calcularPreciosPaquete() {
        if (hayEnPaquetes()) {
            totalPaquetes = sumarColumnasPaquetes();
            txtSubtotal.setText((totalPaquetes + totalProductos) + "");
        } else {
            txtSubtotal.setText(totalProductos + "");
        }
        calcularTotal();
    }
    
    private void calcularTotal() {
        if (txtSubtotal.getText().length() != 0) {
            if (txtIva.getText().length() == 0) {
                Double total = Double.parseDouble(txtSubtotal.getText());
                total *= (1 + Double.parseDouble("16") / 100);
                txtTotal.setText(total + "");
            } else {
                txtTotal.setText(Double.parseDouble(txtSubtotal.getText()) * (1 + Double.parseDouble(txtIva.getText()) / 100) + "");
            }
        }
        modificarWithoutAsk();
    }
    
    private void modificarWithoutAsk() {
        if (haSidoCreado) {
            creado.setDescripcion(txtDescripcion.getText());
            creado.setLugar(txtLugar.getText());
            creado.setFecha(Conexion.aSqlDate(dateFecha.getDate()));
            creado.setSubtotal(Double.parseDouble(txtSubtotal.getText()));
            creado.setTotal(Double.parseDouble(txtTotal.getText()));
            if (CotizacionDAO.actualizar(creado) > 0) {
                System.out.println("Actualizado satisfactoriamente");
            } else {
                System.out.println("No se ha podido actualizar la cotizacion");
            }
        }
    }
    
    private double sumarColumnasProductos() {
        double suma = 0;
        if (tProductos.getRowCount() != 0) {
            for (int i = 0; i < tProductos.getRowCount(); i++) {
                suma += (Double.parseDouble(tProductos.getValueAt(i, 2).toString()) * Double.parseDouble(tProductos.getValueAt(i, 3).toString()));
            }
        }
        
        return suma;
    }
    
    private double sumarColumnasPaquetes() {
        double suma = 0;
        if (tPaquetes.getRowCount() != 0) {
            for (int i = 0; i < tPaquetes.getRowCount(); i++) {
                suma += (Double.parseDouble(tPaquetes.getValueAt(i, 2).toString()) * Double.parseDouble(tPaquetes.getValueAt(i, 3).toString()));
            }
        }
        
        return suma;
    }
    
    private boolean hayEnProductos() {
        if (tProductos.getRowCount() > 0) {
            return true;
        }
        return false;
    }
    
    private boolean hayEnPaquetes() {
        if (tPaquetes.getRowCount() > 0) {
            return true;
        }
        return false;
    }
    
    public void cargarProductos(int idCotizacion) {
        TablaCotizaProducto.cargarProductos(tProductos, idCotizacion);
    }
    
    public void cargarPaquetes(int idCotizacion) {
        TablaCotizaPaquete.cargarPaquetes(tPaquetes, idCotizacion);
    }
    
    public HacerCotizacion() {
        initComponents();
        setLocationRelativeTo(null); //Centra la vantana en la pantalla
        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        AWTUtilities.setWindowShape(this, forma);
        deshabilitarBotones();
        dateFecha.setDate(Conexion.getFechaActual());
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
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPaquetes = new javax.swing.JTable();
        txtSubtotal = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        txtTotal = new javax.swing.JTextField();
        txtLugar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tProductos = new javax.swing.JTable();
        dateFecha = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JSeparator();
        txtIva = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnProductos = new javax.swing.JButton();
        btnPaquetes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnVer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

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
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, 40, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_minus_50px.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 35, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 40));

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(238, 238, 238));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(103, 65, 114));
        jLabel16.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(103, 65, 114));
        jLabel16.setText("Descripción");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel21.setBackground(new java.awt.Color(103, 65, 114));
        jLabel21.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(103, 65, 114));
        jLabel21.setText("Subtotal");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jSeparator17.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 390, 10));

        jSeparator18.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 110, 10));

        jLabel33.setBackground(new java.awt.Color(103, 65, 114));
        jLabel33.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(103, 65, 114));
        jLabel33.setText("Fecha");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        tPaquetes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tPaquetesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tPaquetes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 350, 580));

        txtSubtotal.setBackground(new java.awt.Color(238, 238, 238));
        txtSubtotal.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtSubtotal.setForeground(new java.awt.Color(1, 50, 67));
        txtSubtotal.setBorder(null);
        txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalActionPerformed(evt);
            }
        });
        jPanel1.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 80, 30));

        txtDescripcion.setBackground(new java.awt.Color(238, 238, 238));
        txtDescripcion.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(1, 50, 67));
        txtDescripcion.setBorder(null);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 350, 30));

        jLabel18.setBackground(new java.awt.Color(103, 65, 114));
        jLabel18.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(103, 65, 114));
        jLabel18.setText("Negocio o familia");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel22.setBackground(new java.awt.Color(103, 65, 114));
        jLabel22.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(103, 65, 114));
        jLabel22.setText("Total");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        jSeparator19.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 390, 10));

        jSeparator20.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 140, 10));

        txtTotal.setBackground(new java.awt.Color(238, 238, 238));
        txtTotal.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(1, 50, 67));
        txtTotal.setBorder(null);
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 100, 30));

        txtLugar.setBackground(new java.awt.Color(238, 238, 238));
        txtLugar.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtLugar.setForeground(new java.awt.Color(1, 50, 67));
        txtLugar.setBorder(null);
        txtLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLugarActionPerformed(evt);
            }
        });
        txtLugar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLugarKeyReleased(evt);
            }
        });
        jPanel1.add(txtLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 350, 30));

        tProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tProductos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 360, 580));

        dateFecha.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                dateFechaComponentAdded(evt);
            }
        });
        dateFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dateFechaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateFechaFocusLost(evt);
            }
        });
        dateFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateFechaMouseClicked(evt);
            }
        });
        dateFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateFechaPropertyChange(evt);
            }
        });
        jPanel1.add(dateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 170, 30));

        jLabel23.setBackground(new java.awt.Color(103, 65, 114));
        jLabel23.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(103, 65, 114));
        jLabel23.setText("I.V.A.");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

        jSeparator21.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 100, 10));

        txtIva.setBackground(new java.awt.Color(238, 238, 238));
        txtIva.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtIva.setForeground(new java.awt.Color(1, 50, 67));
        txtIva.setBorder(null);
        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });
        txtIva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIvaKeyReleased(evt);
            }
        });
        jPanel1.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 60, 30));

        jLabel19.setBackground(new java.awt.Color(103, 128, 159));
        jLabel19.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(103, 128, 159));
        jLabel19.setText("Paquetes");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        jPanel3.setBackground(new java.awt.Color(238, 238, 238));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(103, 65, 114))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, 70));

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
        jPanel3.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 70));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_rounded_rectangle_stroked_127px_1.png"))); // NOI18N
        jLabel7.setText("jLabel2");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, 90));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_rounded_rectangle_stroked_127px_1.png"))); // NOI18N
        jLabel3.setText("jLabel2");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, 90));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 150, 250));

        jPanel4.setBackground(new java.awt.Color(238, 238, 238));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(103, 65, 114))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProductos.setBackground(new java.awt.Color(1, 50, 67));
        btnProductos.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(1, 50, 67));
        btnProductos.setText("Productos");
        btnProductos.setBorderPainted(false);
        btnProductos.setContentAreaFilled(false);
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.setFocusPainted(false);
        btnProductos.setRequestFocusEnabled(false);
        btnProductos.setVerifyInputWhenFocusTarget(false);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        btnProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnProductosKeyPressed(evt);
            }
        });
        jPanel4.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, 70));

        btnPaquetes.setBackground(new java.awt.Color(1, 50, 67));
        btnPaquetes.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnPaquetes.setForeground(new java.awt.Color(1, 50, 67));
        btnPaquetes.setText("Paquetes");
        btnPaquetes.setBorderPainted(false);
        btnPaquetes.setContentAreaFilled(false);
        btnPaquetes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPaquetes.setFocusPainted(false);
        btnPaquetes.setRequestFocusEnabled(false);
        btnPaquetes.setVerifyInputWhenFocusTarget(false);
        btnPaquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaquetesActionPerformed(evt);
            }
        });
        btnPaquetes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPaquetesKeyPressed(evt);
            }
        });
        jPanel4.add(btnPaquetes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_rounded_rectangle_stroked_127px_1.png"))); // NOI18N
        jLabel4.setText("jLabel2");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, 90));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_rounded_rectangle_stroked_127px_1.png"))); // NOI18N
        jLabel6.setText("jLabel2");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, 90));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 150, 250));

        jLabel20.setBackground(new java.awt.Color(103, 128, 159));
        jLabel20.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(103, 128, 159));
        jLabel20.setText("Productos");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

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
        jPanel1.add(btnVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 100, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGOSAD200.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 220, 90));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_rounded_rectangle_stroked_127px_1.png"))); // NOI18N
        jLabel9.setText("jLabel2");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 120, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_average_2_32px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_list_32px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 138, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_map_marker_32px.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_plus_math_32px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_percentage_32px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1230, 660));

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
    
    private int deseaEliminar(CotizacionVO encontrado) {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar la cotizacion " + encontrado.getDescripcion() + " : " + encontrado.getLugar() + " ?", "Eliminar", dialog));
    }
    
    private void guardar() {
        
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
    private int deseaModificar(CotizacionVO encontrado) {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea modificar la cotizacion " + encontrado.getDescripcion() + " : " + encontrado.getLugar() + " ?", "Modificar", dialog));
    }
    
    private void modificar(PaqueteVO paquete) {
        PaquetesCreation modificacion = new PaquetesCreation();
        modificacion.setModificar(paquete);
        modificacion.setEditar(true);
        modificacion.setVisible(true);
        dispose();
    }
    

    private void tPaquetesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPaquetesMouseClicked
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
    }//GEN-LAST:event_tPaquetesMouseClicked

    private void btnPaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaquetesActionPerformed
        // TODO add your handling code here:
        if (!haSidoCreado) {
            crear();
            encontrarCreado();
            habilitarBotones();
        }
        CotizarPaquete cotizarPaquete = new CotizarPaquete();
        cotizarPaquete.setCotizacion(creado);
        cotizarPaquete.cargarPaquetes(creado.getId());
        cotizarPaquete.calcularPrecios();
        cotizarPaquete.setPadre(this);
        cotizarPaquete.setVisible(true);
    }//GEN-LAST:event_btnPaquetesActionPerformed

    private void btnPaquetesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPaquetesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPaquetesKeyPressed

    private void btnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarKeyPressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        modificar();
    }//GEN-LAST:event_btnModificarActionPerformed
    
    private void modificar() {
        if (haSidoCreado && deseaModificar(creado) == 0) {
            creado.setDescripcion(txtDescripcion.getText());
            creado.setLugar(txtLugar.getText());
            creado.setFecha(Conexion.aSqlDate(dateFecha.getDate()));
            if (CotizacionDAO.actualizar(creado) > 0) {
                JOptionPane.showMessageDialog(this, "Actualizado satisfactoriamente");
            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido actualizar la cotizacion");
                
            }
        }
    }

    private void btnProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnProductosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductosKeyPressed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
        if (!haSidoCreado) {
            crear();
            encontrarCreado();
            habilitarBotones();
        }
        CotizarProducto cotizarProducto = new CotizarProducto();
        cotizarProducto.setCotizacion(creado);
        cotizarProducto.cargarProductos(creado.getId());
        cotizarProducto.calcularPrecios();
        cotizarProducto.setPadre(this);
        cotizarProducto.setVisible(true);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarKeyPressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (haSidoCreado && deseaEliminar(creado) == 0) {
            encontrarCreado();
            if (CotizacionDAO.eliminar(creado) > 0) {
                JOptionPane.showMessageDialog(this, "Eliminado satisfactoriamente");
                haSidoCreado = false;
                clean();
            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido eliminar la cotizacion");
                
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    
    private void encontrarCreado() {
        creado = CotizacionDAO.encontrar(txtDescripcion.getText(), Conexion.aSqlDate(dateFecha.getDate()), txtLugar.getText());
    }

    private void tProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tProductosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tProductosMouseClicked

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        // TODO add your handling code here:
        if (datosValidos()) {
            habilitarBotones();
        }
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void txtLugarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLugarKeyReleased
        // TODO add your handling code here:
        if (datosValidos()) {
            habilitarBotones();
        }
    }//GEN-LAST:event_txtLugarKeyReleased

    private void txtIvaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIvaKeyReleased
        // TODO add your handling code here:
        if (txtIva.getText().length() == 0) {
            calcularTotal();
        } else if (ivaEsNumero()) {
            calcularTotal();
        }
    }//GEN-LAST:event_txtIvaKeyReleased
    
    private boolean ivaEsNumero() {
        try {
            int iva = Integer.parseInt(txtIva.getText());
            return iva >= 0;
        } catch (Exception e) {
            return false;
        }
    }

    private void dateFechaComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_dateFechaComponentAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_dateFechaComponentAdded

    private void dateFechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFechaFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_dateFechaFocusLost

    private void dateFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFechaFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_dateFechaFocusGained

    private void dateFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateFechaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_dateFechaMouseClicked

    private void dateFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateFechaPropertyChange
        // TODO add your handling code here:
        if (datosValidos()) {
            habilitarBotones();
        }

    }//GEN-LAST:event_dateFechaPropertyChange

    private void txtLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLugarActionPerformed

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnVerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnVerKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerKeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaActionPerformed
    
    private void crear() {
        if (!haSidoCreado) {
            creado.setId(0);
            creado.setDescripcion(txtDescripcion.getText());
            creado.setFecha(Conexion.aSqlDate(dateFecha.getDate()));
            creado.setSubtotal(0);
            creado.setTotal(0);
            creado.setLugar(txtLugar.getText());
            creado.setComprado(false);
            System.out.println(CotizacionDAO.insertar(creado));
            haSidoCreado = true;
        }
    }
    
    private boolean datosValidos() {
        if (txtDescripcion.getText().length() == 0) {
            return false;
        }
        if (txtLugar.getText().length() == 0) {
            return false;
        }
        if (isNotNumberIva()) {
            return false;
        }
        try {
            if (dateFecha.getDate().toString().length() == 0) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    private boolean isNotNumberIva() {
        try {
            if (txtIva.getText().length() == 0) {
                return false;
            }
            Double.parseDouble(txtIva.getText());
            return false;
        } catch (Exception e) {
            return true;
        }
        
    }
    
    private void habilitarBotones() {
        if (haSidoCreado) {
            btnEliminar.setEnabled(true);
            btnModificar.setEnabled(true);
        }
        btnProductos.setEnabled(true);
        btnPaquetes.setEnabled(true);
    }
    
    private void deshabilitarBotones() {
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnProductos.setEnabled(false);
        btnPaquetes.setEnabled(false);
    }
    
    private void cargarBusqueda() {
        /*  if (TablaPaquete.cargarPaquetes(tPaquetes, txtBuscar.getText()) <= 0) {//retornar entero si hay datos y hacer if para saber si cargar o no productos
            cargarProductos(0);
        }*/
    }
    
    private void llenarCampos(PaqueteVO paquete) {
        txtDescripcion.setText(paquete.getDescripcion());
        txtLugar.setText(paquete.getDescuento() + "");
        txtSubtotal.setText(paquete.getSuma() + "");
        txtTotal.setText(paquete.getPrecio() + "");
    }
    
    private PaqueteVO obtenerElementoDeFila(int fila) {
        int idPaquete = Integer.parseInt(tProductos.getValueAt(fila, 0).toString());
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
            java.util.logging.Logger.getLogger(HacerCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HacerCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HacerCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HacerCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HacerCotizacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnPaquetes;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnVer;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JTable tPaquetes;
    private javax.swing.JTable tProductos;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtLugar;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
