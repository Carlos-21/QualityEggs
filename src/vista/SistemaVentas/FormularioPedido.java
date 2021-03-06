/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.SistemaVentas;


import com.toedter.calendar.JDateChooser;
import controlador.Ventas.ControladorPedido;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JTextField;
import modelo.dao.dato.Ventas.Cliente;
import vista.propiedad.Colores;
import vista.propiedad.Directorio;
import vista.propiedad.Propiedad;


/**
 *
 * @author CARLOS
 */
public class FormularioPedido extends javax.swing.JFrame {
    private ListaClientes ventana;
    private Cliente cliente;
    
    public FormularioPedido() {
        initComponents();
        this.getContentPane().setBackground(Colores.fondoFormulario);
        ponerImagenes();
    }

    public JButton getBotonAtras() {
        return botonAtras;
    }

    public JButton getBotonConsultar() {
        return botonConsultar;
    }

    public JButton getBotonFormulario() {
        return botonFormulario;
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }

    public JDateChooser getFechaPedido() {
        return fechaPedido;
    }

    public JTextField getTextoCantidad() {
        return textoCantidad;
    }

    public JTextField getTextoCliente() {
        return textoCliente;
    }

    public JTextField getTextoImporteTotal() {
        return textoImporteTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ListaClientes getVentana() {
        return ventana;
    }

    public void setVentana(ListaClientes ventana) {
        this.ventana = ventana;
    }
    
    public void setControlador(ControladorPedido c){
        botonAtras.addActionListener(c);
        botonConsultar.addActionListener(c);
        botonFormulario.addActionListener(c);
        botonSalir.addActionListener(c);
        
        textoCantidad.addKeyListener(c);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        botonAtras = new javax.swing.JButton();
        textoCliente = new javax.swing.JTextField();
        textoCantidad = new javax.swing.JTextField();
        textoImporteTotal = new javax.swing.JTextField();
        botonFormulario = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonConsultar = new javax.swing.JButton();
        fechaPedido = new com.toedter.calendar.JDateChooser();
        Calendar calendario = new GregorianCalendar();
        fechaPedido.setCalendar(calendario);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(500, 480));
        setPreferredSize(new java.awt.Dimension(500, 480));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label1.setText("Cliente");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        label2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label2.setText("Fecha");
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 214, -1, -1));

        label3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label3.setText("<html><p>Cantidad de</p><p>paquetes</p></html>");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 257, -1, -1));

        label4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label4.setText("Importe total");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 313, -1, -1));
        getContentPane().add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 63, 60));
        botonAtras.setOpaque(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setBorderPainted(false);

        textoCliente.setEnabled(false);
        getContentPane().add(textoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 220, 30));
        getContentPane().add(textoCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 100, 30));

        textoImporteTotal.setEnabled(false);
        getContentPane().add(textoImporteTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 220, 30));

        botonFormulario.setBackground(new java.awt.Color(255, 127, 0));
        botonFormulario.setText("Registrar");
        getContentPane().add(botonFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 360, -1, -1));
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 20, 63, 60));
        botonSalir.setOpaque(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setBorderPainted(false);

        botonConsultar.setBackground(new java.awt.Color(255, 127, 0));
        botonConsultar.setText("Consultar");
        getContentPane().add(botonConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 259, -1, 32));

        fechaPedido.setOpaque(false);
        getContentPane().add(fechaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 220, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ponerImagenes(){
        Propiedad.ponerImagenBoton(botonAtras, Directorio.botonAtras);
        Propiedad.ponerImagenBoton(botonSalir, Directorio.botonSalir);
        
        Propiedad.ponerImagenBotonOpciones(botonConsultar, Directorio.botonConsultar);
    }
    
    public void llenarFormulario(Cliente cliente){
        Propiedad.ponerImagenBoton(botonFormulario, Directorio.botonActualizar, "Actualizar", Colores.botonActualizar);
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
            java.util.logging.Logger.getLogger(FormularioPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FormularioPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonFormulario;
    private javax.swing.JButton botonSalir;
    private com.toedter.calendar.JDateChooser fechaPedido;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JTextField textoCantidad;
    private javax.swing.JTextField textoCliente;
    private javax.swing.JTextField textoImporteTotal;
    // End of variables declaration//GEN-END:variables
}
