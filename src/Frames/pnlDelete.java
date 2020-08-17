/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import ClassDAO.UsuarioDAO;
import ClassVO.UsuarioVO;
import javax.swing.JOptionPane;

/**
 *
 * @author alanm
 */
public class pnlDelete extends javax.swing.JPanel {

    UsuarioVO usuario = new UsuarioVO();
    UsuarioVO anterior;

    public pnlDelete() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(232, 236, 241));
        setForeground(new java.awt.Color(232, 236, 241));
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

        txtUsuario.setBackground(new java.awt.Color(232, 236, 241));
        txtUsuario.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(1, 50, 67));
        txtUsuario.setBorder(null);
        add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 210, 30));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 250, 10));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 250, 10));

        txtContraseña.setBackground(new java.awt.Color(232, 236, 241));
        txtContraseña.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(1, 50, 67));
        txtContraseña.setBorder(null);
        add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 210, 30));
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 30, 30));

        jLabel9.setText("i");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 30, 30));

        jLabel3.setBackground(new java.awt.Color(1, 50, 67));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 50, 67));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Eliminar");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 110, 90));
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 120, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void eliminar() {
        if (verificarDatos()) {
            obtenerDatos();
            anterior = UsuarioDAO.encontrar(usuario.getUsr()).get(0);
            if (anterior.getPass().equals(txtContraseña.getText())) {
                if (UsuarioDAO.eliminar(usuario) == 1) {
                    JOptionPane.showMessageDialog(this, "Usuario eliminado con éxito");
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha podido eliminar");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sus credenciales de acceso son erróneas");
            }
            limpiar();
        }
    }

    private boolean verificarDatos() {
        if (txtContraseña.getText().length() != 0 && txtUsuario.getText().length() != 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese sus datos");
        }
        return false;
    }

    private void obtenerDatos() {
        usuario.setUsr(txtUsuario.getText());
        usuario.setPass(txtContraseña.getText());
    }

    private void limpiar() {
        txtUsuario.setText("");
        txtContraseña.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
