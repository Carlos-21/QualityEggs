/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.TalentoHumano;


import com.toedter.calendar.JDateChooser;
import controlador.TalentoHumano.ControladorTrabajador;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelo.dao.dato.TalentoHumano.Empleado;
import vista.propiedad.Colores;
import vista.propiedad.Directorio;
import vista.propiedad.Propiedad;


/**
 *
 * @author CARLOS
 */
public class FormularioTrabajador extends javax.swing.JFrame {
    private VentanaPrincipal ventana;
    
    public FormularioTrabajador() {
        initComponents();
        this.getContentPane().setBackground(Colores.fondoFormulario);
        ponerImagenes();
    }

    public JButton getBotonFormulario() {
        return botonFormulario;
    }

    public JDateChooser getFechaIngreso() {
        return fechaIngreso;
    }

    public JComboBox<String> getListadoCargo() {
        return listadoCargo;
    }

    public JTextField getTextoApellido() {
        return textoApellido;
    }

    public JPasswordField getTextoContraseña() {
        return textoContraseña;
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

    public JTextField getTextoUsuario() {
        return textoUsuario;
    }

    public VentanaPrincipal getVentana() {
        return ventana;
    }

    public JButton getBotonAtras() {
        return botonAtras;
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }

    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }
    
    public void setControlador(ControladorTrabajador c){
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
        listadoCargo = new javax.swing.JComboBox<>();
        fechaIngreso = new com.toedter.calendar.JDateChooser();
        textoUsuario = new javax.swing.JTextField();
        botonFormulario = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        textoContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 102));
        setMinimumSize(new java.awt.Dimension(500, 630));
        setPreferredSize(new java.awt.Dimension(500, 630));
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
        label5.setText("Cargo");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        label6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label6.setText("Fecha de ingreso");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        label7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label7.setText("Usuario");
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        label8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label8.setText("Contraseña");
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, -1, -1));
        getContentPane().add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 63, 60));
        botonAtras.setOpaque(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setBorderPainted(false);

        getContentPane().add(textoDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 194, 27));
        getContentPane().add(textoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 194, 27));
        getContentPane().add(textoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 194, 27));
        getContentPane().add(textoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 194, 27));

        listadoCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Encargado de ventas", "Encargado de almacén" }));
        getContentPane().add(listadoCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 194, 27));

        fechaIngreso.setOpaque(false);
        getContentPane().add(fechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 194, 27));
        getContentPane().add(textoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 194, 27));

        botonFormulario.setBackground(new java.awt.Color(255, 127, 0));
        botonFormulario.setText("Registrar");
        getContentPane().add(botonFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 520, -1, -1));
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 63, 60));
        botonSalir.setOpaque(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setBorderPainted(false);

        getContentPane().add(textoContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 194, 27));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ponerImagenes(){
        Propiedad.ponerImagenBoton(botonAtras, Directorio.botonAtras);
        Propiedad.ponerImagenBoton(botonSalir, Directorio.botonSalir);
    }
    
    public void llenarFormulario(Empleado trabajador){
        textoDNI.setText(trabajador.getDNI());
        textoNombre.setText(trabajador.getNombre());
        textoApellido.setText(trabajador.getApellido());
        textoDireccion.setText(trabajador.getDireccion());
        
        listadoCargo.setSelectedItem(trabajador.getCargo());
        fechaIngreso.setDate(trabajador.getFechIngreso());
        
        textoUsuario.setText(trabajador.getUsuario());
        textoContraseña.setText(trabajador.getContraseña());
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
            java.util.logging.Logger.getLogger(FormularioTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioTrabajador().setVisible(true);
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
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JComboBox<String> listadoCargo;
    private javax.swing.JTextField textoApellido;
    private javax.swing.JPasswordField textoContraseña;
    private javax.swing.JTextField textoDNI;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables
}
