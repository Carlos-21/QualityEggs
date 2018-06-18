/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.SistemaVentas;


import com.toedter.calendar.JDateChooser;
import controlador.Ventas.ControladorTarifa;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import modelo.dao.dato.Ventas.Tarifa;
import vista.propiedad.Colores;
import vista.propiedad.Directorio;
import vista.propiedad.Propiedad;

/**
 *
 * @author CARLOS
 */
public class FormularioTarifa extends javax.swing.JFrame {
    private VentanaPrincipalVentas ventana;
    
    public FormularioTarifa() {
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

    public JDateChooser getFechaFin() {
        return fechaFin;
    }

    public JDateChooser getFechaInicio() {
        return fechaInicio;
    }

    public JTextField getTextoPrecioUnitario() {
        return textoPrecioUnitario;
    }

    public VentanaPrincipalVentas getVentana() {
        return ventana;
    }

    public void setVentana(VentanaPrincipalVentas ventana) {
        this.ventana = ventana;
    }
    
    public void setControlador(ControladorTarifa c){
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
        textoPrecioUnitario = new javax.swing.JTextField();
        botonFormulario = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        fechaFin = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de nuevo Tarifa");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(500, 420));
        setPreferredSize(new java.awt.Dimension(500, 420));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label1.setText("Precio unitario");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 152, -1, -1));

        label2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label2.setText("Fecha de inicio");
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        label3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label3.setText("Fecha de fin");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 264, -1, -1));
        getContentPane().add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 63, 60));
        botonAtras.setOpaque(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setBorderPainted(false);

        getContentPane().add(textoPrecioUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 194, 27));

        botonFormulario.setBackground(new java.awt.Color(255, 127, 0));
        botonFormulario.setText("Registrar");
        getContentPane().add(botonFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 63, 60));
        botonSalir.setOpaque(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setBorderPainted(false);

        fechaInicio.setOpaque(false);
        getContentPane().add(fechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 194, 27));

        fechaFin.setOpaque(false);
        getContentPane().add(fechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 194, 27));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ponerImagenes(){
        Propiedad.ponerImagenBoton(botonAtras, Directorio.botonAtras);
        Propiedad.ponerImagenBoton(botonSalir, Directorio.botonSalir);
    }
    
    public void llenarFormulario(Tarifa tarifa){
        textoPrecioUnitario.setText(String.valueOf(tarifa.getPrecioUnitario()));
        fechaInicio.setDate(tarifa.getFechaInicio());
        fechaFin.setDate(tarifa.getFechaFin());
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
            java.util.logging.Logger.getLogger(FormularioTarifa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioTarifa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioTarifa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioTarifa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new FormularioTarifa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonFormulario;
    private javax.swing.JButton botonSalir;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JTextField textoPrecioUnitario;
    // End of variables declaration//GEN-END:variables
}
