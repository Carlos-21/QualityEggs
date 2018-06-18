/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.SistemaVentas;


import controlador.Ventas.ControladorPago;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import modelo.dao.dato.Ventas.Pedido;
import vista.propiedad.Colores;
import vista.propiedad.Directorio;
import vista.propiedad.Propiedad;

/**
 *
 * @author CARLOS
 */
public class FormularioPago extends javax.swing.JFrame {
    private VentanaPrincipalVentas ventana;
    
    public FormularioPago() {
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

    public JTextField getTextoDNICliente() {
        return textoDNICliente;
    }

    public JTextField getTextoCodigoPedido() {
        return textoCodigoPedido;
    }

    public JTextField getTextoImporteTotal() {
        return textoImporteTotal;
    }

    public JTextField getTextoNombreCliente() {
        return textoNombreCliente;
    }

    public VentanaPrincipalVentas getVentana() {
        return ventana;
    }

    public void setVentana(VentanaPrincipalVentas ventana) {
        this.ventana = ventana;
    }
    
    public void setControlador(ControladorPago c){
        botonAtras.addActionListener(c);
        botonSalir.addActionListener(c);
        botonFormulario.addActionListener(c);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        botonAtras = new javax.swing.JButton();
        textoImporteTotal = new javax.swing.JTextField();
        botonFormulario = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        textoCodigoPedido = new javax.swing.JTextField();
        textoNombreCliente = new javax.swing.JTextField();
        textoDNICliente = new javax.swing.JTextField();
        label4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de nuevo Tarifa");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(500, 456));
        setPreferredSize(new java.awt.Dimension(434, 456));
        setResizable(false);
        setSize(new java.awt.Dimension(434, 456));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label1.setText("Código de pedido");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, 27));

        label2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label2.setText("Nombrel del cliente");
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, 27));

        label3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label3.setText("Importe total");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, 27));
        getContentPane().add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 63, 60));
        botonAtras.setOpaque(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setBorderPainted(false);

        getContentPane().add(textoImporteTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 194, 27));

        botonFormulario.setBackground(new java.awt.Color(255, 127, 0));
        botonFormulario.setText("Registrar");
        getContentPane().add(botonFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 63, 60));
        botonSalir.setOpaque(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setBorderPainted(false);

        getContentPane().add(textoCodigoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 194, 27));
        getContentPane().add(textoNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 194, 27));
        getContentPane().add(textoDNICliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 194, 27));

        label4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label4.setText("DNI del cliente");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, 27));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ponerImagenes(){
        Propiedad.ponerImagenBoton(botonAtras, Directorio.botonAtras);
        Propiedad.ponerImagenBoton(botonSalir, Directorio.botonSalir);
    }
    
    public void llenarFormulario(Pedido pedido){
        textoCodigoPedido.setText(pedido.getCodigoPedido());
        textoDNICliente.setText(pedido.getDniCliente());
        textoNombreCliente.setText(pedido.getNombreCliente());
        textoImporteTotal.setText(String.valueOf(pedido.getImporteTotal()));
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
            java.util.logging.Logger.getLogger(FormularioPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FormularioPago().setVisible(true);
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
    private javax.swing.JTextField textoCodigoPedido;
    private javax.swing.JTextField textoDNICliente;
    private javax.swing.JTextField textoImporteTotal;
    private javax.swing.JTextField textoNombreCliente;
    // End of variables declaration//GEN-END:variables
}
