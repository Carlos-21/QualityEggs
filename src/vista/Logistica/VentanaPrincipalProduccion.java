/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Logistica;

import com.placeholder.PlaceHolder;
import controlador.Logistica.ControladorLogistica;
import vista.propiedad.Directorio;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import modelo.dao.dato.Logistica.Produccion;
import modelo.dao.dato.Ventas.Pedido;
import vista.Seguridad.VentanaLogin;
import vista.propiedad.Propiedad;

/**
 *
 * @author CARLOS
 */
public class VentanaPrincipalProduccion extends javax.swing.JFrame {
    private final Point posicion1;
    private final Point posicion2;
    private final Dimension tamaño;
    private final Dimension tamaño2;
    private boolean bandera;
    private boolean bandera2;
    private Dimension tamañoPanel;
    private int fila;
    private ArrayList<Produccion> producciones;
    private VentanaLogin login;
    private ArrayList<Pedido> pedidosPagados;
    private int filaPedidoPagado;
    
    public VentanaPrincipalProduccion() {
        initComponents();
        
        bandera = true;
        bandera2 = true;
        
        tamañoPanel = new Dimension(670, 500);
        
        ponerImagenes();
        
        posicion1 = botonEntrega.getLocation();
        posicion2 = botonProduccion.getLocation();
        tamaño = botonEntrega.getPreferredSize();
        tamaño2 = botonEntrega.getPreferredSize();
    }

    public JButton getBotonActualizarProduccion() {
        return botonActualizarProduccion;
    }

    public JButton getBotonAñadirProduccion() {
        return botonAñadirProduccion;
    }

    public JButton getBotonEliminarProduccion() {
        return botonEliminarProduccion;
    }

    public JButton getBotonEntrega() {
        return botonEntrega;
    }

    public JButton getBotonFacturar() {
        return botonFacturar;
    }

    public JButton getBotonGuiaRemision() {
        return botonGuiaRemision;
    }

    public JButton getBotonTransporte() {
        return botonTransporte;
    }

    public JTextField getBusquedaClientePedido() {
        return busquedaClientePedido;
    }

    public JTextField getBusquedaCodigoPedido() {
        return busquedaCodigoPedido;
    }

    public JTextField getBusquedaEstadoPedido() {
        return busquedaEstadoPedido;
    }

    public JTextField getBusquedaFechaPedido() {
        return busquedaFechaPedido;
    }

    public JTextField getBusquedaImportePedido() {
        return busquedaImportePedido;
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }

    public JTextField getBusquedaAlmacen() {
        return busquedaAlmacen;
    }

    public JTextField getBusquedaCodigo() {
        return busquedaCodigo;
    }

    public JTextField getBusquedaFecha() {
        return busquedaFecha;
    }

    public JTextField getBusquedaPeso() {
        return busquedaPeso;
    }

    public JTextField getBusquedaStock() {
        return busquedaStock;
    }

    public JTable getTablaMostrar() {
        return tablaMostrar;
    }

    public JTable getTablaPedido() {
        return tablaPedido;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public ArrayList<Produccion> getProducciones() {
        return producciones;
    }

    public void setProducciones(ArrayList<Produccion> producciones) {
        this.producciones = producciones;
    }    

    public ArrayList<Pedido> getPedidosPagados() {
        return pedidosPagados;
    }

    public void setPedidosPagados(ArrayList<Pedido> pedidosPagados) {
        this.pedidosPagados = pedidosPagados;
    }

    public int getFilaPedidoPagado() {
        return filaPedidoPagado;
    }

    public void setFilaPedidoPagado(int filaPedidoPagado) {
        this.filaPedidoPagado = filaPedidoPagado;
    }

    public VentanaLogin getLogin() {
        return login;
    }

    public void setLogin(VentanaLogin login) {
        this.login = login;
    }
    
    public void setControlador(ControladorLogistica c){
        botonSalir.addActionListener(c);
        botonEntrega.addActionListener(c);
        
        botonAñadirProduccion.addActionListener(c);
        botonActualizarProduccion.addActionListener(c);
        botonEliminarProduccion.addActionListener(c);
        
        botonFacturar.addActionListener(c);
        botonGuiaRemision.addActionListener(c);
        botonTransporte.addActionListener(c);
        
        
        busquedaCodigo.addKeyListener(c);
        busquedaAlmacen.addKeyListener(c);
        busquedaFecha.addKeyListener(c);
        busquedaPeso.addKeyListener(c);
        busquedaStock.addKeyListener(c);
        
        busquedaCodigoPedido.addKeyListener(c);
        busquedaClientePedido.addKeyListener(c);
        busquedaFechaPedido.addKeyListener(c);
        busquedaImportePedido.addKeyListener(c);
        busquedaEstadoPedido.addKeyListener(c);
        
        
        tablaMostrar.addMouseListener(c);
        tablaPedido.addMouseListener(c);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAñadirProduccion = new javax.swing.JButton();
        botonActualizarProduccion = new javax.swing.JButton();
        botonEliminarProduccion = new javax.swing.JButton();
        botonFacturar = new javax.swing.JButton();
        botonGuiaRemision = new javax.swing.JButton();
        botonTransporte = new javax.swing.JButton();
        panelMostrarProduccion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMostrar = new javax.swing.JTable();
        busquedaCodigo = new javax.swing.JTextField();
        PlaceHolder texto = new PlaceHolder(busquedaCodigo, "Código");
        busquedaFecha = new javax.swing.JTextField();
        PlaceHolder texto3 = new PlaceHolder(busquedaFecha, "Fecha");
        busquedaAlmacen = new javax.swing.JTextField();
        PlaceHolder texto2 = new PlaceHolder(busquedaAlmacen, "Almacén");
        busquedaStock = new javax.swing.JTextField();
        PlaceHolder texto5 = new PlaceHolder(busquedaStock, "Stock");
        busquedaPeso = new javax.swing.JTextField();
        PlaceHolder texto4 = new PlaceHolder(busquedaPeso, "Peso");
        panelMostrarPedido = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPedido = new javax.swing.JTable();
        busquedaEstadoPedido = new javax.swing.JTextField();
        PlaceHolder texto10 = new PlaceHolder(busquedaEstadoPedido, "Estado");
        busquedaCodigoPedido = new javax.swing.JTextField();
        PlaceHolder texto6 = new PlaceHolder(busquedaCodigoPedido, "Código");
        busquedaClientePedido = new javax.swing.JTextField();
        PlaceHolder texto7 = new PlaceHolder(busquedaClientePedido, "Cliente");
        busquedaFechaPedido = new javax.swing.JTextField();
        PlaceHolder texto8 = new PlaceHolder(busquedaFechaPedido, "Fecha");
        busquedaImportePedido = new javax.swing.JTextField();
        PlaceHolder texto9 = new PlaceHolder(busquedaImportePedido, "Importe");
        contenedorBotones = new javax.swing.JPanel();
        botonEntrega = new javax.swing.JButton();
        botonProduccion = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        panelMostrar = new javax.swing.JLayeredPane();

        botonAñadirProduccion.setBackground(new java.awt.Color(255, 169, 26));
        botonAñadirProduccion.setForeground(new java.awt.Color(0, 0, 0));
        botonAñadirProduccion.setText("Añadir");

        botonActualizarProduccion.setBackground(new java.awt.Color(255, 169, 26));
        botonActualizarProduccion.setForeground(new java.awt.Color(0, 0, 0));
        botonActualizarProduccion.setText("Actualizar");

        botonEliminarProduccion.setBackground(new java.awt.Color(255, 169, 26));
        botonEliminarProduccion.setForeground(new java.awt.Color(0, 0, 0));
        botonEliminarProduccion.setText("Eliminar");

        botonFacturar.setBackground(new java.awt.Color(255, 169, 26));
        botonFacturar.setForeground(new java.awt.Color(0, 0, 0));
        botonFacturar.setText("Factura");

        botonGuiaRemision.setBackground(new java.awt.Color(255, 169, 26));
        botonGuiaRemision.setForeground(new java.awt.Color(0, 0, 0));
        botonGuiaRemision.setText("Guía de remisión");

        botonTransporte.setBackground(new java.awt.Color(255, 169, 26));
        botonTransporte.setForeground(new java.awt.Color(0, 0, 0));
        botonTransporte.setText("Transporte");

        tablaMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Almacén", "Fecha", "Peso", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaMostrar);

        javax.swing.GroupLayout panelMostrarProduccionLayout = new javax.swing.GroupLayout(panelMostrarProduccion);
        panelMostrarProduccion.setLayout(panelMostrarProduccionLayout);
        panelMostrarProduccionLayout.setHorizontalGroup(
            panelMostrarProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMostrarProduccionLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(panelMostrarProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMostrarProduccionLayout.createSequentialGroup()
                        .addComponent(busquedaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(busquedaAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(busquedaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(busquedaPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(busquedaStock, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelMostrarProduccionLayout.setVerticalGroup(
            panelMostrarProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMostrarProduccionLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(panelMostrarProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(busquedaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaStock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelMostrarPedido.setPreferredSize(new java.awt.Dimension(670, 500));

        tablaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "Fecha", "Importe Total", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaPedido);

        javax.swing.GroupLayout panelMostrarPedidoLayout = new javax.swing.GroupLayout(panelMostrarPedido);
        panelMostrarPedido.setLayout(panelMostrarPedidoLayout);
        panelMostrarPedidoLayout.setHorizontalGroup(
            panelMostrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMostrarPedidoLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(panelMostrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMostrarPedidoLayout.createSequentialGroup()
                        .addComponent(busquedaCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(busquedaClientePedido, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(busquedaFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(busquedaImportePedido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(busquedaEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMostrarPedidoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        panelMostrarPedidoLayout.setVerticalGroup(
            panelMostrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMostrarPedidoLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(panelMostrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(busquedaClientePedido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaImportePedido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(920, 470));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedorBotones.setBackground(new java.awt.Color(0, 204, 204));
        contenedorBotones.setForeground(new java.awt.Color(255, 153, 0));

        botonEntrega.setBackground(new java.awt.Color(255, 169, 26));
        botonEntrega.setForeground(new java.awt.Color(0, 0, 0));
        botonEntrega.setText("Entrega");
        botonEntrega.setPreferredSize(new java.awt.Dimension(143, 42));
        botonEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntregaActionPerformed(evt);
            }
        });

        botonProduccion.setBackground(new java.awt.Color(255, 169, 26));
        botonProduccion.setForeground(new java.awt.Color(0, 0, 0));
        botonProduccion.setText("Producción");
        botonProduccion.setPreferredSize(new java.awt.Dimension(143, 42));
        botonProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProduccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenedorBotonesLayout = new javax.swing.GroupLayout(contenedorBotones);
        contenedorBotones.setLayout(contenedorBotonesLayout);
        contenedorBotonesLayout.setHorizontalGroup(
            contenedorBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorBotonesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorBotonesLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(contenedorBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        contenedorBotonesLayout.setVerticalGroup(
            contenedorBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorBotonesLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(botonProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(botonEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(contenedorBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 500));

        javax.swing.GroupLayout panelMostrarLayout = new javax.swing.GroupLayout(panelMostrar);
        panelMostrar.setLayout(panelMostrarLayout);
        panelMostrarLayout.setHorizontalGroup(
            panelMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        panelMostrarLayout.setVerticalGroup(
            panelMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(panelMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 670, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEntregaActionPerformed
        int posicionX = posicion1.x;
        int posicionY = posicion1.y;
        
        if(bandera){       
            panelMostrar.removeAll();
            panelMostrarPedido.setBounds(0, 0 ,tamañoPanel.width, tamañoPanel.height);
            panelMostrar.add(panelMostrarPedido);
            
            botonFacturar.setBounds(posicionX + 15, posicionY + 47, tamaño.width, tamaño.height-13);
            contenedorBotones.add(botonFacturar);

            botonGuiaRemision.setBounds(posicionX + 15, posicionY + 77, tamaño.width, tamaño.height-13);
            contenedorBotones.add(botonGuiaRemision);

            botonTransporte.setBounds(posicionX + 15, posicionY + 107, tamaño.width, tamaño.height-13);
            contenedorBotones.add(botonTransporte);         
            
            bandera = false;
        } 
        else{
            contenedorBotones.remove(botonFacturar);
            contenedorBotones.remove(botonGuiaRemision);
            contenedorBotones.remove(botonTransporte);            
            
            bandera = true;
        }
        
        this.repaint();
    }//GEN-LAST:event_botonEntregaActionPerformed

    private void botonProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProduccionActionPerformed
        int posicionX = posicion2.x;
        int posicionY = posicion2.y;
        
        if(bandera2){
            panelMostrar.removeAll();
            panelMostrarProduccion.setBounds(0, 0 ,tamañoPanel.width, tamañoPanel.height);
            panelMostrar.add(panelMostrarProduccion);
            
            botonAñadirProduccion.setBounds(posicionX + 15, posicionY + 47, tamaño2.width - 25, tamaño2.height - 13);
            contenedorBotones.add(botonAñadirProduccion);

            botonActualizarProduccion.setBounds(posicionX + 15, posicionY + 77, tamaño2.width - 25, tamaño2.height - 13);
            contenedorBotones.add(botonActualizarProduccion);

            botonEliminarProduccion.setBounds(posicionX + 15, posicionY + 107, tamaño2.width - 25, tamaño2.height - 13);
            contenedorBotones.add(botonEliminarProduccion);
            
            botonEntrega.setBounds(posicion1.x, posicion1.y + 70, tamaño.width + 24, tamaño.height);
            contenedorBotones.add(botonEntrega);
            
            bandera2 = false;
        } 
        else{
            contenedorBotones.remove(botonAñadirProduccion);
            contenedorBotones.remove(botonActualizarProduccion);
            contenedorBotones.remove(botonEliminarProduccion);
            
            botonEntrega.setBounds(posicion1.x, posicion1.y, tamaño.width + 24, tamaño.height);
            contenedorBotones.add(botonEntrega);
            
            bandera2 = true;
        }
    }//GEN-LAST:event_botonProduccionActionPerformed

    private void ponerImagenes(){
        Propiedad.ponerImagenBoton(botonSalir, Directorio.botonSalir);
        
        Propiedad.ponerImagenBotonOpciones(botonProduccion, Directorio.botonProduccion);
        Propiedad.ponerImagenBotonOpciones(botonEntrega, Directorio.botonEntrega);
        
        Propiedad.ponerImagenBotonOpciones(botonAñadirProduccion, Directorio.opcionAñadir);
        Propiedad.ponerImagenBotonOpciones(botonActualizarProduccion, Directorio.opcionActualizar);
        Propiedad.ponerImagenBotonOpciones(botonEliminarProduccion, Directorio.opcionEliminar);
        
        Propiedad.ponerImagenBotonOpciones(botonFacturar, Directorio.botonFactura);
        Propiedad.ponerImagenBotonOpciones(botonGuiaRemision, Directorio.botonGuia);
        Propiedad.ponerImagenBotonOpciones(botonTransporte, Directorio.botonTransporte);
        
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
            java.util.logging.Logger.getLogger(VentanaPrincipalProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VentanaPrincipalProduccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarProduccion;
    private javax.swing.JButton botonAñadirProduccion;
    private javax.swing.JButton botonEliminarProduccion;
    private javax.swing.JButton botonEntrega;
    private javax.swing.JButton botonFacturar;
    private javax.swing.JButton botonGuiaRemision;
    private javax.swing.JButton botonProduccion;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonTransporte;
    private javax.swing.JTextField busquedaAlmacen;
    private javax.swing.JTextField busquedaClientePedido;
    private javax.swing.JTextField busquedaCodigo;
    private javax.swing.JTextField busquedaCodigoPedido;
    private javax.swing.JTextField busquedaEstadoPedido;
    private javax.swing.JTextField busquedaFecha;
    private javax.swing.JTextField busquedaFechaPedido;
    private javax.swing.JTextField busquedaImportePedido;
    private javax.swing.JTextField busquedaPeso;
    private javax.swing.JTextField busquedaStock;
    private javax.swing.JPanel contenedorBotones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLayeredPane panelMostrar;
    private javax.swing.JPanel panelMostrarPedido;
    private javax.swing.JPanel panelMostrarProduccion;
    private javax.swing.JTable tablaMostrar;
    private javax.swing.JTable tablaPedido;
    // End of variables declaration//GEN-END:variables
}
