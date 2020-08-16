package Frames;

import ClassDAO.CategoriaDAO;
import ClassDAO.EmpaquetadoDAO;
import ClassDAO.PaqueteDAO;
import ClassDAO.ProductoDAO;
import ClassDAO.SubcategoriaDAO;
import ClassVO.CategoriaVO;
import ClassVO.PaqueteVO;
import ClassVO.ProductoVO;
import ClassVO.SubcategoriaVO;
import Tables.TablaProducto;
import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class PaquetesCreation extends javax.swing.JFrame {

    private PaqueteVO modificar;
    private PaqueteVO nuevo;
    private boolean editar;

    public void setModificar(PaqueteVO modificar) {
        this.modificar = modificar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
        if (editar) {
            cargarProductos(modificar.getId());
            llenarCampos(modificar);
            calcularPrecios();
        } else {//Si se va a crear un nuevo paquete
            nuevo = new PaqueteVO(0, "nuevoTemporal123", 0, 0, 0);
            System.out.println(PaqueteDAO.insertar(nuevo) + "");
            nuevo = encontrarCreado();
        }
    }

    public PaquetesCreation() {
        initComponents();
        setLocationRelativeTo(null); //Centra la vantana en la pantalla
        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        AWTUtilities.setWindowShape(this, forma);
        cargarCategorias();
        TablaProducto.cargarProductos(tBusqueda);
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtSubtotal.setEditable(false);
        txtPrecio.setEditable(false);
    }

    private void calcularPrecios() {
        if (hayEnTabla()) {
            if (esNumeroPorcentaje()) {
                txtSubtotal.setText(sumarColumnas() + "");
                txtPrecio.setText(Double.parseDouble(txtSubtotal.getText()) * (1 - Double.parseDouble(txtDescuento.getText()) / 100) + "");
            } else {
                txtSubtotal.setText(sumarColumnas() + "");
                txtPrecio.setText(txtSubtotal.getText() + "");
            }
        } else {
            txtSubtotal.setText(sumarColumnas() + "");
            txtPrecio.setText(txtSubtotal.getText() + "");
        }
    }

    private boolean hayEnTabla() {
        if (TAgregados.getRowCount() > 0) {
            return true;
        }
        return false;
    }

    private boolean esNumeroPorcentaje() {
        try {
            Double.parseDouble(txtDescuento.getText());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private double sumarColumnas() {
        double suma = 0;
        if (TAgregados.getRowCount() != 0) {
            for (int i = 0; i < TAgregados.getRowCount(); i++) {
                suma += Double.parseDouble(TAgregados.getValueAt(i, 2).toString());
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
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TAgregados = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        txtSubtotal = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtId6 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        txtPrecio = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtId7 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        comboSubCat = new javax.swing.JComboBox<>();
        comboCategoria = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tBusqueda = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();

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
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, -1, -1));

        jLabel21.setBackground(new java.awt.Color(103, 65, 114));
        jLabel21.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(103, 65, 114));
        jLabel21.setText("Subtotal");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, -1, -1));

        jSeparator16.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 370, 10));

        jSeparator17.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, 170, 10));

        jSeparator18.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, 170, 10));

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
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 570, 110, 40));

        jLabel17.setBackground(new java.awt.Color(103, 128, 159));
        jLabel17.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(103, 128, 159));
        jLabel17.setText("Paquete");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, -1, -1));

        TAgregados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TAgregadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TAgregados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 340, 440));

        btnCancelar.setBackground(new java.awt.Color(1, 50, 67));
        btnCancelar.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(1, 50, 67));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setRequestFocusEnabled(false);
        btnCancelar.setVerifyInputWhenFocusTarget(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 570, 110, 40));

        txtSubtotal.setBackground(new java.awt.Color(238, 238, 238));
        txtSubtotal.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtSubtotal.setForeground(new java.awt.Color(1, 50, 67));
        txtSubtotal.setBorder(null);
        jPanel1.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 140, 30));

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
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 340, 30));

        txtDescripcion.setBackground(new java.awt.Color(238, 238, 238));
        txtDescripcion.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(1, 50, 67));
        txtDescripcion.setBorder(null);
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 140, 30));

        txtId6.setBackground(new java.awt.Color(238, 238, 238));
        txtId6.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtId6.setForeground(new java.awt.Color(1, 50, 67));
        txtId6.setBorder(null);
        jPanel1.add(txtId6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 140, 30));

        jLabel18.setBackground(new java.awt.Color(103, 65, 114));
        jLabel18.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(103, 65, 114));
        jLabel18.setText("Descuento (%)");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 320, -1, -1));

        jLabel22.setBackground(new java.awt.Color(103, 65, 114));
        jLabel22.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(103, 65, 114));
        jLabel22.setText("Precio");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 420, -1, -1));

        jSeparator19.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 380, 170, 10));

        jSeparator20.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 480, 170, 10));

        txtPrecio.setBackground(new java.awt.Color(238, 238, 238));
        txtPrecio.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(1, 50, 67));
        txtPrecio.setBorder(null);
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 450, 140, 30));

        txtDescuento.setBackground(new java.awt.Color(238, 238, 238));
        txtDescuento.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtDescuento.setForeground(new java.awt.Color(1, 50, 67));
        txtDescuento.setBorder(null);
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
        });
        jPanel1.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 350, 140, 30));

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

        btnNuevo.setBackground(new java.awt.Color(1, 50, 67));
        btnNuevo.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(1, 50, 67));
        btnNuevo.setText("Guardar");
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
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 510, 110, 40));

        tBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tBusquedaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tBusqueda);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 370, 440));

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
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 570, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 950, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        if (editar) {
            if (TAgregados.getRowCount() != 0) {
                cerrar();
            }
        } else {
            if (deseaSalir() == 0) {
                PaqueteDAO.eliminar(nuevo);
                System.exit(0);
            }
        }
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
        String descripcion = txtDescripcion.getText();
        double suma = Double.parseDouble(txtSubtotal.getText());
        int descuento = 0;
        if (txtDescuento.getText().length() != 0) {
            descuento = Integer.parseInt(txtDescuento.getText());
        }
        double precio = Double.parseDouble(txtPrecio.getText());
        return new PaqueteVO(idPaquete, descripcion, suma, descuento, precio);
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

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        if (editar) {
            if (TAgregados.getRowCount() != 0) {
                regresar();
            }
        } else {
            PaqueteDAO.eliminar(nuevo);
            regresar();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            if (editar) {
                if (EmpaquetadoDAO.desempaquetar(obtenido, modificar) != 0) {
                    cargarProductos(modificar.getId());

                } else {
                    cargarProductos(0);
                }
            } else {
                if (EmpaquetadoDAO.desempaquetar(obtenido, nuevo) != 0) {
                    cargarProductos(nuevo.getId());
                } else {
                    cargarProductos(0);
                }
            }
            calcularPrecios();
        } else {
            btnEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        if (datosValidos()) {
            if (editar) {
                if (guardar(modificar.getId()) > 0) {
                    JOptionPane.showMessageDialog(this, "El paquete ha sido actualizado correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error al actualizar el paquete");
                }
            } else if (guardar(nuevo.getId()) > 0) {
                JOptionPane.showMessageDialog(this, "El paquete ha sido creado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error al crear el paquete");
            }
            Paquetes paquetes = new Paquetes();
            paquetes.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private boolean datosValidos() {

        try {
            int descuento = 200;
            double subtotal = Double.parseDouble(txtSubtotal.getText());
            double total = Double.parseDouble(txtPrecio.getText());
            if (txtDescuento.getText().length() != 0) {
                descuento = Integer.parseInt(txtDescuento.getText());
            } else {
                descuento = 0;
            }
            return txtDescripcion.getText().length() != 0 && total != 0 && subtotal != 0 && descuento <= 100 && descuento >= 0;
        } catch (Exception e) {
            return false;
        }
    }

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void tBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBusquedaMouseClicked
        // TODO add your handling code here:
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_tBusquedaMouseClicked


    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        ProductoVO obtenido = obtenerElementoDeFila(tBusqueda.getSelectedRow());
        if (editar) {
            PaqueteVO actual = modificar;
            System.out.println(EmpaquetadoDAO.empaquetar(obtenido, actual));
            cargarProductos(modificar.getId());
        } else {
            System.out.println(EmpaquetadoDAO.empaquetar(obtenido, nuevo));
            cargarProductos(nuevo.getId());
        }
        calcularPrecios();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private PaqueteVO encontrarCreado() {
        return PaqueteDAO.encontrar("nuevoTemporal123").get(0);
    }


    private void btnAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarKeyPressed

    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
        // TODO add your handling code here:
        calcularPrecios();
    }//GEN-LAST:event_txtDescuentoKeyReleased

    private void cargarProductos(int idPaquete) {
        TablaProducto.cargarProductos(TAgregados, idPaquete);
    }

    private void cargarBusqueda() {
        /*if (TablaPaquete.cargarPaquetes(tPaquetes, txtBuscar.getText()) <= 0) {//retornar entero si hay datos y hacer if para saber si cargar o no productos
            cargarProductos(0);
        }*/
    }

    private void llenarCampos(PaqueteVO paquete) {
        txtDescripcion.setText(paquete.getDescripcion());
        txtDescuento.setText(paquete.getDescuento() + "");
        txtSubtotal.setText(paquete.getSuma() + "");
        txtPrecio.setText(paquete.getPrecio() + "");
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
            java.util.logging.Logger.getLogger(PaquetesCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaquetesCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaquetesCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaquetesCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PaquetesCreation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TAgregados;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboSubCat;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JTable tBusqueda;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtId6;
    private javax.swing.JTextField txtId7;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSubtotal;
    // End of variables declaration//GEN-END:variables
}
