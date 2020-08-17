package Frames;

import ClassDAO.UsuarioDAO;
import ClassVO.UsuarioVO;
import javax.swing.JOptionPane;

public class pnlRegistrar extends javax.swing.JPanel {

    UsuarioVO usuario = new UsuarioVO();

    public pnlRegistrar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtPass = new javax.swing.JPasswordField();
        jSeparator4 = new javax.swing.JSeparator();
        txtRePass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(232, 236, 241));
        setForeground(new java.awt.Color(189, 195, 199));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(1, 50, 67));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 50, 67));
        jLabel1.setText("Usuario");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel2.setBackground(new java.awt.Color(1, 50, 67));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 50, 67));
        jLabel2.setText("Contraseña");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel3.setBackground(new java.awt.Color(1, 50, 67));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 50, 67));
        jLabel3.setText("Confirmar  contraseña");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 240, 60));

        jLabel4.setBackground(new java.awt.Color(1, 50, 67));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 50, 67));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Guardar");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 110, 90));

        txtUsuario.setBackground(new java.awt.Color(232, 236, 241));
        txtUsuario.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(1, 50, 67));
        txtUsuario.setBorder(null);
        add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 210, 30));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 250, 10));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 250, 10));

        txtPass.setBackground(new java.awt.Color(232, 236, 241));
        txtPass.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtPass.setForeground(new java.awt.Color(1, 50, 67));
        txtPass.setBorder(null);
        add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 210, 30));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 250, 10));

        txtRePass.setBackground(new java.awt.Color(232, 236, 241));
        txtRePass.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtRePass.setForeground(new java.awt.Color(1, 50, 67));
        txtRePass.setBorder(null);
        add(txtRePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 210, 30));

        jLabel5.setBackground(new java.awt.Color(189, 195, 199));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_rectangular_127px_1.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 120, 90));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_password_32px.png"))); // NOI18N
        jLabel11.setText("i");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 30, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_password_32px.png"))); // NOI18N
        jLabel9.setText("i");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 30, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_user_32px.png"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 30, 30));

        jLabel6.setBackground(new java.awt.Color(1, 50, 67));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 50, 67));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Guardar");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 110, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void registrar() {
        if (verificarDatos()) {
            obtenerDatos();
            if (UsuarioDAO.insertar(usuario)==1) {
                JOptionPane.showMessageDialog(this, "Usuario registrado con éxito");
            } else {
                JOptionPane.showMessageDialog(this, "El usuario ya existe");
            }
            limpiar();
        }
    }

    private boolean verificarDatos() {
        if (txtPass.getText().length() != 0 && txtUsuario.getText().length() != 0 && txtRePass.getText().length() != 0) {
            if (txtPass.getText().equals(txtRePass.getText())) {
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
                txtPass.setText("");
                txtRePass.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese sus datos");
        }
        return false;
    }

    private void obtenerDatos() {
        usuario.setUsr(txtUsuario.getText());
        usuario.setPass(txtPass.getText());
    }

    private void limpiar() {
        txtUsuario.setText("");
        txtPass.setText("");
        txtRePass.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtRePass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
