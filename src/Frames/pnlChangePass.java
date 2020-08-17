package Frames;

import ClassDAO.UsuarioDAO;
import ClassVO.UsuarioVO;
import javax.swing.JOptionPane;

public class pnlChangePass extends javax.swing.JPanel {

    UsuarioVO usuario = new UsuarioVO();
    UsuarioVO anterior;
    
    public pnlChangePass() {
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
        txtOldPass = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txtNewPass = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtReNewPass = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(232, 236, 241));
        setForeground(new java.awt.Color(232, 236, 241));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(1, 50, 67));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 50, 67));
        jLabel1.setText("Usuario");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel2.setBackground(new java.awt.Color(1, 50, 67));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 50, 67));
        jLabel2.setText("Contraseña anterior");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel3.setBackground(new java.awt.Color(1, 50, 67));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 50, 67));
        jLabel3.setText("Contraseña nueva");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 240, 60));

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
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 110, 90));

        txtUsuario.setBackground(new java.awt.Color(232, 236, 241));
        txtUsuario.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(1, 50, 67));
        txtUsuario.setBorder(null);
        add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 210, 30));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 250, 10));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 250, 10));

        txtOldPass.setBackground(new java.awt.Color(232, 236, 241));
        txtOldPass.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtOldPass.setForeground(new java.awt.Color(1, 50, 67));
        txtOldPass.setBorder(null);
        add(txtOldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 210, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_user_32px.png"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 30, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_password_32px.png"))); // NOI18N
        jLabel9.setText("i");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 30, 30));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 250, 10));

        txtNewPass.setBackground(new java.awt.Color(232, 236, 241));
        txtNewPass.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtNewPass.setForeground(new java.awt.Color(1, 50, 67));
        txtNewPass.setBorder(null);
        add(txtNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 210, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_password_32px.png"))); // NOI18N
        jLabel10.setText("i");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 30, 30));

        jLabel5.setBackground(new java.awt.Color(189, 195, 199));
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 120, 90));

        jLabel6.setBackground(new java.awt.Color(1, 50, 67));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 50, 67));
        jLabel6.setText("Confirmar contraseña");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 260, 60));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 250, 10));

        txtReNewPass.setBackground(new java.awt.Color(232, 236, 241));
        txtReNewPass.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtReNewPass.setForeground(new java.awt.Color(1, 50, 67));
        txtReNewPass.setBorder(null);
        add(txtReNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 210, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_password_32px.png"))); // NOI18N
        jLabel12.setText("i");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 30, 30));

        jLabel7.setBackground(new java.awt.Color(189, 195, 199));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_rectangular_127px_1.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 120, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void editar() {
        if (verificarDatos()) {
            obtenerDatos();
            anterior = UsuarioDAO.encontrar(usuario.getUsr()).get(0);
            if (anterior.getPass().equals(txtOldPass.getText())) {
                if (UsuarioDAO.actualizar(usuario) > 0) {
                    JOptionPane.showMessageDialog(this, "Contraseña cambiada satisfactoriamente");
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha podido cambiar la contraseña");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sus credenciales de acceso son erróneas");
            }
            limpiar();
        }
    }

    private boolean verificarDatos() {
        if (txtUsuario.getText().length() != 0 && txtNewPass.getText().length() != 0 && txtOldPass.getText().length() != 0 && txtReNewPass.getText().length() != 0) {
            if (txtNewPass.getText().equals(txtReNewPass.getText())) {
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
                txtNewPass.setText("");
                txtReNewPass.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese sus datos");
        }
        return false;
    }

    private void obtenerDatos() {
        usuario.setUsr(txtUsuario.getText());
        usuario.setPass(txtNewPass.getText());
    }

    private void limpiar() {
        txtUsuario.setText("");
        txtOldPass.setText("");
        txtReNewPass.setText("");
        txtNewPass.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPasswordField txtNewPass;
    private javax.swing.JPasswordField txtOldPass;
    private javax.swing.JPasswordField txtReNewPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
