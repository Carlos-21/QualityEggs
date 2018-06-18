/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Logistica;


import com.toedter.calendar.JDateChooser;
import controlador.Logistica.ControladorProduccion;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import modelo.dao.dato.Logistica.Produccion;
import vista.propiedad.Colores;
import vista.propiedad.Directorio;
import vista.propiedad.Propiedad;


/**
 *
 * @author CARLOS
 */
public class FormularioProduccion extends javax.swing.JFrame {
    private VentanaPrincipalProduccion ventana;
    
    public FormularioProduccion() {
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

    public JDateChooser getFechaIngreso() {
        return fechaIngreso;
    }

    public JTextField getTextoAlmacen() {
        return textoAlmacen;
    }

    public JTextField getTextoCodigo() {
        return textoCodigo;
    }

    public JTextField getTextoPeso() {
        return textoPeso;
    }

    public JTextField getTextoStock() {
        return textoStock;
    }

    public VentanaPrincipalProduccion getVentana() {
        return ventana;
    }

    public void setVentana(VentanaPrincipalProduccion ventana) {
        this.ventana = ventana;
    }
     
    public void setControlador(ControladorProduccion c){
        botonSalir.addActionListener(c);
        botonAtras.addActionListener(c);
        botonFormulario.addActionListener(c);
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(Directorio.logo));

        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        botonAtras = new javax.swing.JButton();
        textoCodigo = new javax.swing.JTextField();
        textoAlmacen = new javax.swing.JTextField();
        textoPeso = new javax.swing.JTextField();
        textoStock = new javax.swing.JTextField();
        fechaIngreso = new com.toedter.calendar.JDateChooser();
        botonFormulario = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 102));
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(500, 485));
        setPreferredSize(new java.awt.Dimension(500, 485));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label1.setText("Código");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 134, -1, -1));

        label2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label2.setText("Nombre de Almacén");
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 195, -1, -1));

        label3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label3.setText("Fecha de ingreso");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 233, -1, -1));

        label4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label4.setText("Peso");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        label5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label5.setText("Stock");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 333, -1, -1));
        getContentPane().add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 63, 60));
        botonAtras.setOpaque(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setBorderPainted(false);

        getContentPane().add(textoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 194, 27));
        getContentPane().add(textoAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 194, 27));
        getContentPane().add(textoPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 194, 27));
        getContentPane().add(textoStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 194, 27));

        fechaIngreso.setOpaque(false);
        getContentPane().add(fechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 194, 27));

        botonFormulario.setBackground(new java.awt.Color(255, 127, 0));
        botonFormulario.setText("Registrar");
        getContentPane().add(botonFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, -1, -1));
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 63, 60));
        botonSalir.setOpaque(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setBorderPainted(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ponerImagenes(){
        Propiedad.ponerImagenBoton(botonAtras, Directorio.botonAtras);
        Propiedad.ponerImagenBoton(botonSalir, Directorio.botonSalir);
    }
    
    public void llenarFormulario(Produccion produccion){
        textoCodigo.setText(produccion.getCodigo());
        
        textoAlmacen.setText(produccion.getNombreAlmacen());
        fechaIngreso.setDate(produccion.getFechaIngreso());
        
        textoPeso.setText(String.valueOf(produccion.getPeso()));
        textoStock.setText(String.valueOf(produccion.getStock()));      
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
            java.util.logging.Logger.getLogger(FormularioProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioProduccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonFormulario;
    private javax.swing.JButton botonSalir;
    private com.toedter.calendar.JDateChooser fechaIngreso;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JTextField textoAlmacen;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoPeso;
    private javax.swing.JTextField textoStock;
    // End of variables declaration//GEN-END:variables
}
