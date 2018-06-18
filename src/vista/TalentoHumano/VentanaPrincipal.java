/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.TalentoHumano;

import com.placeholder.PlaceHolder;
import controlador.TalentoHumano.ControladorTalentoHumano;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import modelo.dao.dato.TalentoHumano.Empleado;
import vista.Seguridad.VentanaLogin;
import vista.propiedad.Directorio;
import vista.propiedad.Propiedad;

/**
 *
 * @author CARLOS
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    private final Point posicion1;
    private final Point posicion2;
    private final Dimension tamaño;
    private boolean bandera;
    private int fila;
    private ArrayList<Empleado> empleados;
    private VentanaLogin login;
    
    public VentanaPrincipal() {
        initComponents();
        posicion1 = botonTrabajador.getLocation();
        posicion2 = botonReporte.getLocation();
        tamaño = botonTrabajador.getSize();
        bandera = true;
        ponerImagenes();
    }

    public Point getPosicion1() {
        return posicion1;
    }

    public Point getPosicion2() {
        return posicion2;
    }

    public Dimension getTamaño() {
        return tamaño;
    }

    public boolean isBandera() {
        return bandera;
    }

    public JButton getBotonActualizar() {
        return botonActualizar;
    }

    public JButton getBotonAñadir() {
        return botonAñadir;
    }

    public JButton getBotonEliminar() {
        return botonEliminar;
    }

    public JButton getBotonGenerarReporte() {
        return botonGenerarReporte;
    }

    public JButton getBotonReporte() {
        return botonReporte;
    }

    public JTextField getBusquedaCargo() {
        return busquedaCargo;
    }

    public JTextField getBusquedaDNI() {
        return busquedaDNI;
    }

    public JTextField getBusquedaNombre() {
        return busquedaNombre;
    }

    public JTable getTablaTrabajadores() {
        return tablaTrabajadores;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }

    public VentanaLogin getLogin() {
        return login;
    }

    public void setLogin(VentanaLogin login) {
        this.login = login;
    }
    
    public void setControlador(ControladorTalentoHumano c){
        botonSalir.addActionListener(c);
        botonAñadir.addActionListener(c);
        botonActualizar.addActionListener(c);
        botonEliminar.addActionListener(c);
        busquedaDNI.addKeyListener(c);
        busquedaCargo.addKeyListener(c);
        busquedaNombre.addKeyListener(c);
        tablaTrabajadores.addMouseListener(c);
    }
    
    private void ponerImagenes(){
        Propiedad.ponerImagenBoton(botonSalir, Directorio.botonSalir);
        Propiedad.ponerImagenBotonOpciones(botonTrabajador, Directorio.botonTrabajador);
        Propiedad.ponerImagenBotonOpciones(botonReporte, Directorio.botonReporte);
        
        Propiedad.ponerImagenBotonOpciones(botonAñadir, Directorio.opcionAñadir);
        Propiedad.ponerImagenBotonOpciones(botonActualizar, Directorio.opcionActualizar);
        Propiedad.ponerImagenBotonOpciones(botonEliminar, Directorio.opcionEliminar);
        
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(Directorio.logo));

        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAñadir = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonGenerarReporte = new javax.swing.JButton();
        panelListados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTrabajadores = new javax.swing.JTable();
        busquedaDNI = new javax.swing.JTextField();
        PlaceHolder texto = new PlaceHolder(busquedaDNI, "DNI");
        busquedaNombre = new javax.swing.JTextField();
        PlaceHolder texto2 = new PlaceHolder(busquedaNombre, "Nombre");
        busquedaCargo = new javax.swing.JTextField();
        PlaceHolder texto3 = new PlaceHolder(busquedaCargo, "Cargo");
        panelBotones = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        botonReporte = new javax.swing.JButton();
        botonTrabajador = new javax.swing.JButton();

        botonAñadir.setBackground(new java.awt.Color(255, 169, 26));
        botonAñadir.setForeground(new java.awt.Color(0, 0, 0));
        botonAñadir.setText("Añadir");

        botonActualizar.setBackground(new java.awt.Color(255, 169, 26));
        botonActualizar.setForeground(new java.awt.Color(0, 0, 0));
        botonActualizar.setText("Actualizar");

        botonEliminar.setBackground(new java.awt.Color(255, 169, 26));
        botonEliminar.setForeground(new java.awt.Color(0, 0, 0));
        botonEliminar.setText("Eliminar");

        botonGenerarReporte.setText("Generar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelListados.setMinimumSize(new java.awt.Dimension(451, 361));
        panelListados.setPreferredSize(new java.awt.Dimension(451, 361));
        panelListados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTrabajadores);

        panelListados.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 388, 231));
        panelListados.add(busquedaDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 110, -1));
        panelListados.add(busquedaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 110, -1));
        panelListados.add(busquedaCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 120, -1));

        getContentPane().add(panelListados, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 0, 510, 479));

        panelBotones.setBackground(new java.awt.Color(0, 204, 204));
        panelBotones.setForeground(new java.awt.Color(255, 153, 0));

        botonReporte.setBackground(new java.awt.Color(255, 169, 26));
        botonReporte.setForeground(new java.awt.Color(0, 0, 0));
        botonReporte.setText("Reportes");
        botonReporte.setPreferredSize(new java.awt.Dimension(143, 42));

        botonTrabajador.setBackground(new java.awt.Color(255, 169, 26));
        botonTrabajador.setForeground(new java.awt.Color(0, 0, 0));
        botonTrabajador.setText("Trabajadores");
        botonTrabajador.setPreferredSize(new java.awt.Dimension(143, 42));
        botonTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTrabajadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(botonTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(botonReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(botonTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(botonReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        botonSalir.setOpaque(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setBorderPainted(false);

        getContentPane().add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTrabajadorActionPerformed
        int posicionX = posicion1.x;
        int posicionY = posicion1.y;
        
        if(bandera){
            getBotonAñadir().setBounds(posicionX + 15, posicionY + 47, tamaño.width - 30, tamaño.height - 13);
            panelBotones.add(this.getBotonAñadir());

            getBotonActualizar().setBounds(posicionX + 15, posicionY + 77, tamaño.width - 30, tamaño.height - 13);
            panelBotones.add(this.getBotonActualizar());

            getBotonEliminar().setBounds(posicionX + 15, posicionY + 107, tamaño.width - 30, tamaño.height - 13);
            panelBotones.add(this.getBotonEliminar());

            getBotonReporte().setBounds(posicionX, posicionY + 150, tamaño.width, tamaño.height);
            panelBotones.add(this.getBotonReporte());
            
            bandera = false;
        } 
        else{
            panelBotones.remove(this.getBotonAñadir());
            panelBotones.remove(this.getBotonActualizar());
            panelBotones.remove(this.getBotonEliminar());

            getBotonReporte().setBounds(posicionX, posicion2.y, tamaño.width, tamaño.height);
            panelBotones.add(this.getBotonReporte());
            
            bandera = true;
        }
    }//GEN-LAST:event_botonTrabajadorActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAñadir;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGenerarReporte;
    private javax.swing.JButton botonReporte;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonTrabajador;
    private javax.swing.JTextField busquedaCargo;
    private javax.swing.JTextField busquedaDNI;
    private javax.swing.JTextField busquedaNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelListados;
    private javax.swing.JTable tablaTrabajadores;
    // End of variables declaration//GEN-END:variables
}
