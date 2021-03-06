/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Seguridad;

import controlador.Seguridad.ControladorSeguridad;
import java.awt.Image;
import java.awt.Toolkit;
import vista.propiedad.Directorio;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import vista.propiedad.Propiedad;

/**
 *
 * @author CARLOS
 */
public class VentanaLogin extends javax.swing.JFrame {

    /**
     * Creates new form VentanaLogin
     */
    public VentanaLogin() {
        initComponents();
        ponerImagenes();
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }

    public JButton getBotonLogin() {
        return botonLogin;
    }

    public JPasswordField getTextoContraseña() {
        return textoContraseña;
    }

    public JTextField getTextoUsuario() {
        return textoUsuario;
    }

    public JCheckBox getCheckMostrarContraseña() {
        return checkMostrarContraseña;
    }

    public void setControlador(ControladorSeguridad c) {
        botonSalir.addActionListener(c);
        botonLogin.addActionListener(c);
        textoContraseña.addActionListener(c);
        checkMostrarContraseña.addActionListener(c);
    }

    private void ponerImagenes() {
        Propiedad.ponerImagenLabel(labelLogin, Directorio.login);
        Propiedad.ponerImagenLabel(fondo, Directorio.fondoLogin);
        Propiedad.ponerImagenBoton(botonSalir, Directorio.botonSalir);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(Directorio.logo));

        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelLogin = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JTextField();
        textoContraseña = new javax.swing.JPasswordField();
        botonSalir = new javax.swing.JButton();
        botonLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        checkMostrarContraseña = new javax.swing.JCheckBox();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(595, 482));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(labelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 135, 135));
        getContentPane().add(textoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 210, 29));
        getContentPane().add(textoContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 210, 29));

        botonSalir.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonSalir.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 60, 60));
        botonSalir.setOpaque(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setBorderPainted(false);

        botonLogin.setBackground(new java.awt.Color(37, 40, 80));
        botonLogin.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonLogin.setForeground(new java.awt.Color(255, 255, 255));
        botonLogin.setText("Ingresar");
        getContentPane().add(botonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        checkMostrarContraseña.setForeground(new java.awt.Color(255, 255, 255));
        checkMostrarContraseña.setText("Mostrar contreseña");
        getContentPane().add(checkMostrarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, -1, -1));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 595, 482));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonLogin;
    public javax.swing.JButton botonSalir;
    private javax.swing.JCheckBox checkMostrarContraseña;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelLogin;
    public javax.swing.JPasswordField textoContraseña;
    public javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables
}
