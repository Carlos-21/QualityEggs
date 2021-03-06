/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.SistemaVentas;


import controlador.Ventas.ControladorCliente;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import modelo.dao.dato.Ventas.Cliente;
import vista.propiedad.Colores;
import vista.propiedad.Directorio;
import vista.propiedad.Propiedad;


/**
 *
 * @author CARLOS
 */
public class FormularioCliente extends javax.swing.JFrame {
    private VentanaPrincipalVentas ventana;
    
    public FormularioCliente() {
        initComponents();
        this.getContentPane().setBackground(Colores.fondoFormulario);
        ponerImagenes();
    }

    public JButton getBotonAtras() {
        return botonAtras;
    }

    public JButton getBotonFormulario() {
        return botonFormulario;
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }

    public JComboBox<String> getListadoDistrito() {
        return listadoDistrito;
    }

    public JTextField getTextoApellido() {
        return textoApellido;
    }

    public JTextField getTextoDNI() {
        return textoDNI;
    }

    public JTextField getTextoDireccion() {
        return textoDireccion;
    }

    public JTextField getTextoNombre() {
        return textoNombre;
    }

    public JTextField getTextoRUC() {
        return textoRUC;
    }

    public JTextField getTextoRazonSocial() {
        return textoRazonSocial;
    }

    public JTextField getTextoTelefono() {
        return textoTelefono;
    }

    public VentanaPrincipalVentas getVentana() {
        return ventana;
    }

    public void setVentana(VentanaPrincipalVentas ventana) {
        this.ventana = ventana;
    }
    
    public void setControlador(ControladorCliente c){
        botonFormulario.addActionListener(c);
        botonAtras.addActionListener(c);
        botonSalir.addActionListener(c);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        botonAtras = new javax.swing.JButton();
        textoDNI = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        textoApellido = new javax.swing.JTextField();
        textoDireccion = new javax.swing.JTextField();
        listadoDistrito = new javax.swing.JComboBox<>();
        textoRUC = new javax.swing.JTextField();
        textoRazonSocial = new javax.swing.JTextField();
        botonFormulario = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        textoTelefono = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(500, 610));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label1.setText("DNI");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        label2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label2.setText("Nombres");
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        label3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label3.setText("Apellidos");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        label4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label4.setText("Dirección");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        label5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label5.setText("Distrito");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        label6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label6.setText("Teléfono");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        label7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label7.setText("R.U.C.");
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        label8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label8.setText("Razón social");
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, -1, -1));
        getContentPane().add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 63, 60));
        botonAtras.setOpaque(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setBorderPainted(false);

        getContentPane().add(textoDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 194, 27));
        getContentPane().add(textoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 194, 27));
        getContentPane().add(textoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 194, 27));
        getContentPane().add(textoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 194, 27));

        listadoDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ate", "San Juan de Lurigancho", " " }));
        getContentPane().add(listadoDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 194, 27));
        getContentPane().add(textoRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 194, 27));
        getContentPane().add(textoRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 194, 27));

        botonFormulario.setBackground(new java.awt.Color(255, 127, 0));
        botonFormulario.setText("Registrar");
        getContentPane().add(botonFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, -1, -1));
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 63, 60));
        botonSalir.setOpaque(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setBorderPainted(false);

        getContentPane().add(textoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 194, 27));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ponerImagenes(){
        Propiedad.ponerImagenBoton(botonAtras, Directorio.botonAtras);
        Propiedad.ponerImagenBoton(botonSalir, Directorio.botonSalir);
    }
    
    public void llenarFormulario(Cliente cliente){
        textoDNI.setText(cliente.getDNI());
        textoNombre.setText(cliente.getNombre());
        textoApellido.setText(cliente.getApellido());
        textoDireccion.setText(cliente.getDireccion());
        listadoDistrito.setSelectedItem(cliente.getDistrito());
        textoTelefono.setText(cliente.getTelefono());
        
        textoRUC.setText(cliente.getRUC());
        textoRazonSocial.setText(cliente.getRazonSocial());        
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(Directorio.logo));

        return retValue;
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
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonFormulario;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JComboBox<String> listadoDistrito;
    private javax.swing.JTextField textoApellido;
    private javax.swing.JTextField textoDNI;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoRUC;
    private javax.swing.JTextField textoRazonSocial;
    private javax.swing.JTextField textoTelefono;
    // End of variables declaration//GEN-END:variables
}
