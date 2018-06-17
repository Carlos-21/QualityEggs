/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.SistemaVentas;

import com.placeholder.PlaceHolder;
import controlador.Ventas.ControladorVentas;
import vista.propiedad.Directorio;
import modelo.dao.dato.Ventas.Cliente;
import modelo.dao.dato.Ventas.Tarifa;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import modelo.dao.dato.Ventas.Pedido;
import vista.Seguridad.VentanaLogin;
import vista.propiedad.Propiedad;

/**
 *
 * @author CARLOS
 */
public class VentanaPrincipalVentas extends javax.swing.JFrame {
    private final Point posicion1;
    private final Point posicion2;
    private final Point posicion3;
    private final Point posicion4;
    private final Dimension tamaño;
    private boolean bandera;
    private boolean bandera2;
    private boolean bandera3;
    private boolean bandera4;
    private Dimension tamañoPanel;
    private VentanaLogin login;
    private ArrayList<Cliente> clientes;
    private int filaCliente;
    private ArrayList<Pedido> pedidos;
    private int filaPedido;
    private ArrayList<Pedido> pedidosPendiente;
    private int filaPedidoPendiente;
    private ArrayList<Tarifa> tarifas;
    private int filaTarifa;
    
    public VentanaPrincipalVentas() {
        initComponents();
        
        posicion1 = botonCliente.getLocation();
        posicion2 = botonPedido.getLocation();
        posicion3 = botonTarifa.getLocation();
        posicion4 = botonPago.getLocation();
        tamaño = botonCliente.getPreferredSize();
        
        bandera = true;
        bandera2 = true;
        bandera3 = true;
        bandera4 = true;
        
        tamañoPanel = new Dimension(620, 510);
        ponerImagenes();
    }

    public JButton getBotonActualizarCliente() {
        return botonActualizarCliente;
    }

    public JButton getBotonActualizarPedido() {
        return botonActualizarPedido;
    }

    public JButton getBotonActualizarTarifa() {
        return botonActualizarTarifa;
    }

    public JButton getBotonAñadirCliente() {
        return botonAñadirCliente;
    }

    public JButton getBotonAñadirPedido() {
        return botonAñadirPedido;
    }

    public JButton getBotonAñadirTarifa() {
        return botonAñadirTarifa;
    }

    public JButton getBotonEliminarCliente() {
        return botonEliminarCliente;
    }

    public JButton getBotonEliminarPedido() {
        return botonEliminarPedido;
    }

    public JButton getBotonEliminarTarifa() {
        return botonEliminarTarifa;
    }

    public JButton getBotonAñadirPago() {
        return botonAñadirPago;
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }

    public JTextField getBusquedaCliente() {
        return busquedaCliente;
    }

    public JTextField getBusquedaCodigo() {
        return busquedaCodigo;
    }

    public JTextField getBusquedaDNI() {
        return busquedaDNI;
    }

    public JTextField getBusquedaEstado() {
        return busquedaEstado;
    }

    public JTextField getBusquedaFecha() {
        return busquedaFecha;
    }

    public JTextField getBusquedaFechaFin() {
        return busquedaFechaFin;
    }

    public JTextField getBusquedaFechaInicio() {
        return busquedaFechaInicio;
    }

    public JTextField getBusquedaImporte() {
        return busquedaImporte;
    }

    public JTextField getBusquedaNombre() {
        return busquedaNombre;
    }

    public JTextField getBusquedaPrecio() {
        return busquedaPrecio;
    }

    public JTextField getBusquedaRazonSocial() {
        return busquedaRazonSocial;
    }

    public JTextField getBusquedaClientePago() {
        return busquedaClientePago;
    }

    public JTextField getBusquedaCodigoPago() {
        return busquedaCodigoPago;
    }

    public JTextField getBusquedaEstadoPago() {
        return busquedaEstadoPago;
    }

    public JTextField getBusquedaFechaPago() {
        return busquedaFechaPago;
    }

    public JTextField getBusquedaImportePago() {
        return busquedaImportePago;
    }
    
    public JTextField getBusquedaSemana() {
        return busquedaSemana;
    }

    public JButton getBotonCliente() {
        return botonCliente;
    }

    public JButton getBotonPago() {
        return botonPago;
    }

    public JButton getBotonPedido() {
        return botonPedido;
    }

    public JButton getBotonTarifa() {
        return botonTarifa;
    }
    
    public JTable getTablaCliente() {
        return tablaCliente;
    }

    public JTable getTablaPedido() {
        return tablaPedido;
    }

    public JTable getTablaTarifa() {
        return tablaTarifa;
    }

    public JTable getTablaPago() {
        return tablaPago;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public int getFilaCliente() {
        return filaCliente;
    }

    public void setFilaCliente(int filaCliente) {
        this.filaCliente = filaCliente;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public int getFilaPedido() {
        return filaPedido;
    }

    public void setFilaPedido(int filaPedido) {
        this.filaPedido = filaPedido;
    }

    public ArrayList<Tarifa> getTarifas() {
        return tarifas;
    }

    public void setTarifas(ArrayList<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }

    public int getFilaTarifa() {
        return filaTarifa;
    }

    public void setFilaTarifa(int filaTarifa) {
        this.filaTarifa = filaTarifa;
    }

    public ArrayList<Pedido> getPedidosPendiente() {
        return pedidosPendiente;
    }

    public void setPedidosPendiente(ArrayList<Pedido> pedidosPendiente) {
        this.pedidosPendiente = pedidosPendiente;
    }

    public int getFilaPedidoPendiente() {
        return filaPedidoPendiente;
    }

    public void setFilaPedidoPendiente(int filaPedidoPendiente) {
        this.filaPedidoPendiente = filaPedidoPendiente;
    }

    public VentanaLogin getLogin() {
        return login;
    }

    public void setLogin(VentanaLogin login) {
        this.login = login;
    }
   
    public void setControlador(ControladorVentas c){
        botonAñadirCliente.addActionListener(c);
        botonActualizarCliente.addActionListener(c);
        botonEliminarCliente.addActionListener(c);

        botonAñadirPedido.addActionListener(c);
        botonActualizarPedido.addActionListener(c);
        botonEliminarPedido.addActionListener(c);
        
        botonAñadirTarifa.addActionListener(c);
        botonActualizarTarifa.addActionListener(c);
        botonEliminarTarifa.addActionListener(c);
        
        botonAñadirPago.addActionListener(c);
        
        busquedaDNI.addKeyListener(c);
        busquedaNombre.addKeyListener(c);
        busquedaRazonSocial.addKeyListener(c);
        
        busquedaSemana.addKeyListener(c);
        busquedaPrecio.addKeyListener(c);
        busquedaFechaInicio.addKeyListener(c);
        busquedaFechaFin.addKeyListener(c);
        
        busquedaCodigo.addKeyListener(c);
        busquedaCliente.addKeyListener(c);
        busquedaFecha.addKeyListener(c);
        busquedaImporte.addKeyListener(c);
        busquedaEstado.addKeyListener(c);
        
        tablaCliente.addMouseListener(c);
        tablaPedido.addMouseListener(c);
        tablaTarifa.addMouseListener(c);
        tablaPago.addMouseListener(c);
        
        busquedaCodigoPago.addKeyListener(c);
        busquedaClientePago.addKeyListener(c);
        busquedaFechaPago.addKeyListener(c);
        busquedaImportePago.addKeyListener(c);
        busquedaEstadoPago.addKeyListener(c);
        
        botonSalir.addActionListener(c);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAñadirCliente = new javax.swing.JButton();
        botonActualizarCliente = new javax.swing.JButton();
        botonEliminarCliente = new javax.swing.JButton();
        botonAñadirPedido = new javax.swing.JButton();
        botonActualizarPedido = new javax.swing.JButton();
        botonEliminarPedido = new javax.swing.JButton();
        botonAñadirTarifa = new javax.swing.JButton();
        botonActualizarTarifa = new javax.swing.JButton();
        botonEliminarTarifa = new javax.swing.JButton();
        botonAñadirPago = new javax.swing.JButton();
        panelMostrarPedido = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPedido = new javax.swing.JTable();
        busquedaEstado = new javax.swing.JTextField();
        PlaceHolder texto8 = new PlaceHolder(busquedaEstado, "Estado");
        busquedaCodigo = new javax.swing.JTextField();
        PlaceHolder texto4 = new PlaceHolder(busquedaCodigo, "Código");
        busquedaCliente = new javax.swing.JTextField();
        PlaceHolder texto5 = new PlaceHolder(busquedaCliente, "Cliente");
        busquedaFecha = new javax.swing.JTextField();
        PlaceHolder texto6 = new PlaceHolder(busquedaFecha, "Fecha");
        busquedaImporte = new javax.swing.JTextField();
        PlaceHolder texto7 = new PlaceHolder(busquedaImporte, "Importe");
        panelMostrarCliente = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        busquedaRazonSocial = new javax.swing.JTextField();
        PlaceHolder texto3 = new PlaceHolder(busquedaRazonSocial, "Razón Social");
        busquedaDNI = new javax.swing.JTextField();
        PlaceHolder texto = new PlaceHolder(busquedaDNI, "DNI");
        busquedaNombre = new javax.swing.JTextField();
        PlaceHolder texto2 = new PlaceHolder(busquedaNombre, "Nombre");
        panelMostrarTarifa = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaTarifa = new javax.swing.JTable();
        busquedaSemana = new javax.swing.JTextField();
        PlaceHolder texto9 = new PlaceHolder(busquedaSemana, "N° Semana");
        busquedaPrecio = new javax.swing.JTextField();
        PlaceHolder texto10 = new PlaceHolder(busquedaPrecio, "Precio");
        busquedaFechaInicio = new javax.swing.JTextField();
        PlaceHolder texto11 = new PlaceHolder(busquedaFechaInicio, "Fecha Inicio");
        busquedaFechaFin = new javax.swing.JTextField();
        PlaceHolder texto12 = new PlaceHolder(busquedaFechaFin, "Fecha fin");
        panelMostrarPago = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaPago = new javax.swing.JTable();
        busquedaEstadoPago = new javax.swing.JTextField();
        PlaceHolder texto17 = new PlaceHolder(busquedaEstadoPago, "Estado");
        busquedaCodigoPago = new javax.swing.JTextField();
        PlaceHolder texto13 = new PlaceHolder(busquedaCodigoPago, "Código");
        busquedaClientePago = new javax.swing.JTextField();
        PlaceHolder texto14 = new PlaceHolder(busquedaClientePago, "Cliente");
        busquedaFechaPago = new javax.swing.JTextField();
        PlaceHolder texto15 = new PlaceHolder(busquedaFechaPago, "Fecha");
        busquedaImportePago = new javax.swing.JTextField();
        PlaceHolder texto16 = new PlaceHolder(busquedaImportePago, "Importe");
        contenedorBotones = new javax.swing.JPanel();
        botonCliente = new javax.swing.JButton();
        botonPedido = new javax.swing.JButton();
        botonTarifa = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonPago = new javax.swing.JButton();
        panelMostrar = new javax.swing.JLayeredPane();

        botonAñadirCliente.setBackground(new java.awt.Color(255, 169, 26));
        botonAñadirCliente.setText("Añadir");

        botonActualizarCliente.setBackground(new java.awt.Color(255, 169, 26));
        botonActualizarCliente.setText("Actualizar");

        botonEliminarCliente.setBackground(new java.awt.Color(255, 169, 26));
        botonEliminarCliente.setText("Eliminar");

        botonAñadirPedido.setBackground(new java.awt.Color(255, 169, 26));
        botonAñadirPedido.setText("Añadir");

        botonActualizarPedido.setBackground(new java.awt.Color(255, 169, 26));
        botonActualizarPedido.setText("Actualizar");

        botonEliminarPedido.setBackground(new java.awt.Color(255, 169, 26));
        botonEliminarPedido.setText("Eliminar");

        botonAñadirTarifa.setBackground(new java.awt.Color(255, 169, 26));
        botonAñadirTarifa.setText("Añadir");

        botonActualizarTarifa.setBackground(new java.awt.Color(255, 169, 26));
        botonActualizarTarifa.setText("Actualizar");

        botonEliminarTarifa.setBackground(new java.awt.Color(255, 169, 26));
        botonEliminarTarifa.setText("Eliminar");

        botonAñadirPago.setBackground(new java.awt.Color(255, 169, 26));
        botonAñadirPago.setText("Añadir");

        panelMostrarPedido.setPreferredSize(new java.awt.Dimension(620, 510));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMostrarPedidoLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(panelMostrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMostrarPedidoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(busquedaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(busquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(busquedaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(busquedaImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(busquedaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
        panelMostrarPedidoLayout.setVerticalGroup(
            panelMostrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMostrarPedidoLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(panelMostrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(busquedaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        panelMostrarCliente.setPreferredSize(new java.awt.Dimension(620, 510));

        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "Razón Social"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCliente);

        javax.swing.GroupLayout panelMostrarClienteLayout = new javax.swing.GroupLayout(panelMostrarCliente);
        panelMostrarCliente.setLayout(panelMostrarClienteLayout);
        panelMostrarClienteLayout.setHorizontalGroup(
            panelMostrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMostrarClienteLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(panelMostrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMostrarClienteLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(busquedaDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(busquedaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(busquedaRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
        panelMostrarClienteLayout.setVerticalGroup(
            panelMostrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMostrarClienteLayout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(panelMostrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(busquedaDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );

        panelMostrarTarifa.setPreferredSize(new java.awt.Dimension(620, 510));

        tablaTarifa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Semana", "Precio", "Fecha de Inicio", "Fecha de Fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaTarifa);

        javax.swing.GroupLayout panelMostrarTarifaLayout = new javax.swing.GroupLayout(panelMostrarTarifa);
        panelMostrarTarifa.setLayout(panelMostrarTarifaLayout);
        panelMostrarTarifaLayout.setHorizontalGroup(
            panelMostrarTarifaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMostrarTarifaLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(panelMostrarTarifaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMostrarTarifaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(busquedaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(busquedaPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(busquedaFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(busquedaFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
        panelMostrarTarifaLayout.setVerticalGroup(
            panelMostrarTarifaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMostrarTarifaLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(panelMostrarTarifaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(busquedaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMostrarTarifaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(busquedaFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(busquedaFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(busquedaPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        panelMostrarPago.setPreferredSize(new java.awt.Dimension(620, 510));

        tablaPago.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tablaPago);

        javax.swing.GroupLayout panelMostrarPagoLayout = new javax.swing.GroupLayout(panelMostrarPago);
        panelMostrarPago.setLayout(panelMostrarPagoLayout);
        panelMostrarPagoLayout.setHorizontalGroup(
            panelMostrarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMostrarPagoLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(panelMostrarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMostrarPagoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(busquedaCodigoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(busquedaClientePago, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(busquedaFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(busquedaImportePago, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(busquedaEstadoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
        panelMostrarPagoLayout.setVerticalGroup(
            panelMostrarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMostrarPagoLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(panelMostrarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(busquedaCodigoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaClientePago, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaImportePago, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaEstadoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedorBotones.setBackground(new java.awt.Color(0, 204, 204));
        contenedorBotones.setForeground(new java.awt.Color(255, 153, 0));
        contenedorBotones.setMinimumSize(new java.awt.Dimension(285, 510));
        contenedorBotones.setPreferredSize(new java.awt.Dimension(290, 510));

        botonCliente.setBackground(new java.awt.Color(255, 169, 26));
        botonCliente.setForeground(new java.awt.Color(0, 0, 0));
        botonCliente.setText("Clientes");
        botonCliente.setPreferredSize(new java.awt.Dimension(143, 42));
        botonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonClienteActionPerformed(evt);
            }
        });

        botonPedido.setBackground(new java.awt.Color(255, 169, 26));
        botonPedido.setForeground(new java.awt.Color(0, 0, 0));
        botonPedido.setText("Pedidos");
        botonPedido.setPreferredSize(new java.awt.Dimension(143, 42));
        botonPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedidoActionPerformed(evt);
            }
        });

        botonTarifa.setBackground(new java.awt.Color(255, 169, 26));
        botonTarifa.setForeground(new java.awt.Color(0, 0, 0));
        botonTarifa.setText("Tarifas");
        botonTarifa.setPreferredSize(new java.awt.Dimension(143, 42));
        botonTarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTarifaActionPerformed(evt);
            }
        });

        botonPago.setBackground(new java.awt.Color(255, 169, 26));
        botonPago.setForeground(new java.awt.Color(0, 0, 0));
        botonPago.setText("Pago");
        botonPago.setPreferredSize(new java.awt.Dimension(143, 42));
        botonPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenedorBotonesLayout = new javax.swing.GroupLayout(contenedorBotones);
        contenedorBotones.setLayout(contenedorBotonesLayout);
        contenedorBotonesLayout.setHorizontalGroup(
            contenedorBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorBotonesLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(contenedorBotonesLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(botonPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(contenedorBotonesLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(botonTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(contenedorBotonesLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(botonPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(contenedorBotonesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        contenedorBotonesLayout.setVerticalGroup(
            contenedorBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorBotonesLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        botonSalir.setOpaque(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setBorderPainted(false);

        getContentPane().add(contenedorBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 510));

        javax.swing.GroupLayout panelMostrarLayout = new javax.swing.GroupLayout(panelMostrar);
        panelMostrar.setLayout(panelMostrarLayout);
        panelMostrarLayout.setHorizontalGroup(
            panelMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        panelMostrarLayout.setVerticalGroup(
            panelMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(panelMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 0, 620, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClienteActionPerformed
        int posicionX = posicion1.x;
        int posicionY = posicion1.y;
        
        if(bandera){
            panelMostrar.removeAll();
            panelMostrarCliente.setBounds(0, 0 ,tamañoPanel.width, tamañoPanel.height);
            panelMostrar.add(panelMostrarCliente);
            
            botonAñadirCliente.setBounds(posicionX + 15, posicionY + 47, tamaño.width - 30, tamaño.height-13);
            contenedorBotones.add(botonAñadirCliente);

            botonActualizarCliente.setBounds(posicionX + 15, posicionY + 77, tamaño.width - 30, tamaño.height-13);
            contenedorBotones.add(botonActualizarCliente);

            botonEliminarCliente.setBounds(posicionX + 15, posicionY + 107, tamaño.width - 30, tamaño.height-13);
            contenedorBotones.add(botonEliminarCliente);

            botonPedido.setBounds(posicionX, posicionY + 150, tamaño.width, tamaño.height);
            contenedorBotones.add(botonPedido);
            
            botonTarifa.setBounds(posicionX, posicionY + 200, tamaño.width, tamaño.height);
            contenedorBotones.add(botonTarifa);

            botonPago.setBounds(posicionX, posicionY + 250, tamaño.width, tamaño.height);
            contenedorBotones.add(botonPago);
            
            bandera = false;
        } 
        else{
            contenedorBotones.remove(botonAñadirCliente);
            contenedorBotones.remove(botonActualizarCliente);
            contenedorBotones.remove(botonEliminarCliente);

            botonPedido.setBounds(posicion2.x, posicion2.y, tamaño.width, tamaño.height);
            contenedorBotones.add(botonPedido);
            
            botonTarifa.setBounds(posicion3.x, posicion3.y, tamaño.width, tamaño.height);
            contenedorBotones.add(botonTarifa);            
            
            botonPago.setBounds(posicion4.x, posicion4.y, tamaño.width, tamaño.height);
            contenedorBotones.add(botonPago);            
            
            bandera = true;
        }
    }//GEN-LAST:event_botonClienteActionPerformed

    private void botonPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidoActionPerformed
        int posicionX = posicion2.x;
        int posicionY = posicion2.y;
        
        if(bandera2){
            panelMostrar.removeAll();
            panelMostrarPedido.setBounds(0, 0 ,tamañoPanel.width, tamañoPanel.height);
            panelMostrar.add(panelMostrarPedido);
            
            botonAñadirPedido.setBounds(posicionX + 15, posicionY + 47, tamaño.width - 30, tamaño.height - 13);
            contenedorBotones.add(botonAñadirPedido);

            botonActualizarPedido.setBounds(posicionX + 15, posicionY + 77, tamaño.width - 30, tamaño.height - 13);
            contenedorBotones.add(botonActualizarPedido);

            botonEliminarPedido.setBounds(posicionX + 15, posicionY + 107, tamaño.width - 30, tamaño.height - 13);
            contenedorBotones.add(botonEliminarPedido);

            botonTarifa.setBounds(posicionX, posicionY + 150, tamaño.width, tamaño.height);
            contenedorBotones.add(botonTarifa);
            
            botonPago.setBounds(posicionX, posicionY + 210, tamaño.width, tamaño.height);
            contenedorBotones.add(botonPago);
            
            bandera2 = false;
        } 
        else{
            contenedorBotones.remove(botonAñadirPedido);
            contenedorBotones.remove(botonActualizarPedido);
            contenedorBotones.remove(botonEliminarPedido);

            
            botonTarifa.setBounds(posicion3.x, posicion3.y, tamaño.width, tamaño.height);
            contenedorBotones.add(botonTarifa);
            
            botonPago.setBounds(posicion4.x, posicion4.y, tamaño.width, tamaño.height);
            contenedorBotones.add(botonPago);
            
            bandera2 = true;
        }
       
    }//GEN-LAST:event_botonPedidoActionPerformed

    private void botonTarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTarifaActionPerformed
        int posicionX = posicion3.x;
        int posicionY = posicion3.y;

        if(bandera3){
            panelMostrar.removeAll();
            panelMostrarTarifa.setBounds(0, 0 ,tamañoPanel.width, tamañoPanel.height);
            panelMostrar.add(panelMostrarTarifa);
            
            botonAñadirTarifa.setBounds(posicionX + 15, posicionY + 47, tamaño.width - 30, tamaño.height - 13);
            contenedorBotones.add(botonAñadirTarifa);

            botonActualizarTarifa.setBounds(posicionX + 15, posicionY + 77, tamaño.width - 30, tamaño.height - 13);
            contenedorBotones.add(botonActualizarTarifa);

            botonEliminarTarifa.setBounds(posicionX + 15, posicionY + 107, tamaño.width - 30, tamaño.height - 13);
            contenedorBotones.add(botonEliminarTarifa);
            
            botonPago.setBounds(posicionX, posicionY + 150, tamaño.width, tamaño.height);
            contenedorBotones.add(botonPago);
            
            bandera3 = false;
        } 
        else{
            contenedorBotones.remove(botonAñadirTarifa);
            contenedorBotones.remove(botonActualizarTarifa);
            contenedorBotones.remove(botonEliminarTarifa);
            
            botonPago.setBounds(posicion4.x, posicion4.y, tamaño.width, tamaño.height);
            contenedorBotones.add(botonPago);
            
            bandera3 = true;
        }
    }//GEN-LAST:event_botonTarifaActionPerformed

    private void botonPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPagoActionPerformed
        int posicionX = posicion4.x;
        int posicionY = posicion4.y;
        
        if(bandera4){
            panelMostrar.removeAll();
            panelMostrarPago.setBounds(0, 0 ,tamañoPanel.width, tamañoPanel.height);
            panelMostrar.add(panelMostrarPago);
            
            botonAñadirPago.setBounds(posicionX + 15, posicionY + 47, tamaño.width - 30, tamaño.height - 13);
            contenedorBotones.add(botonAñadirPago);
            
            bandera4 = false;
        }
        else{
            contenedorBotones.remove(botonAñadirPago);
            
            bandera4 = true;
        }
        
        contenedorBotones.repaint();
    }//GEN-LAST:event_botonPagoActionPerformed

    private void ponerImagenes(){
        Propiedad.ponerImagenBoton(botonSalir, Directorio.botonSalir);
        
        Propiedad.ponerImagenBotonOpciones(botonCliente, Directorio.botonCliente);
        Propiedad.ponerImagenBotonOpciones(botonPedido, Directorio.botonPedido);
        Propiedad.ponerImagenBotonOpciones(botonTarifa, Directorio.botonTarifa);
        Propiedad.ponerImagenBotonOpciones(botonPago, Directorio.botonPago);
        
        Propiedad.ponerImagenBotonOpciones(botonAñadirCliente, Directorio.opcionAñadir);
        Propiedad.ponerImagenBotonOpciones(botonActualizarCliente, Directorio.opcionActualizar);
        Propiedad.ponerImagenBotonOpciones(botonEliminarCliente, Directorio.opcionEliminar);
        
        Propiedad.ponerImagenBotonOpciones(botonAñadirPedido, Directorio.opcionAñadir);
        Propiedad.ponerImagenBotonOpciones(botonActualizarPedido, Directorio.opcionActualizar);
        Propiedad.ponerImagenBotonOpciones(botonEliminarPedido, Directorio.opcionEliminar);
        
        Propiedad.ponerImagenBotonOpciones(botonAñadirTarifa, Directorio.opcionAñadir);
        Propiedad.ponerImagenBotonOpciones(botonActualizarTarifa, Directorio.opcionActualizar);
        Propiedad.ponerImagenBotonOpciones(botonEliminarTarifa, Directorio.opcionEliminar);
        
        Propiedad.ponerImagenBotonOpciones(botonAñadirPago, Directorio.opcionAñadir);
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
            java.util.logging.Logger.getLogger(VentanaPrincipalVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipalVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarCliente;
    private javax.swing.JButton botonActualizarPedido;
    private javax.swing.JButton botonActualizarTarifa;
    private javax.swing.JButton botonAñadirCliente;
    private javax.swing.JButton botonAñadirPago;
    private javax.swing.JButton botonAñadirPedido;
    private javax.swing.JButton botonAñadirTarifa;
    private javax.swing.JButton botonCliente;
    private javax.swing.JButton botonEliminarCliente;
    private javax.swing.JButton botonEliminarPedido;
    private javax.swing.JButton botonEliminarTarifa;
    private javax.swing.JButton botonPago;
    private javax.swing.JButton botonPedido;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonTarifa;
    private javax.swing.JTextField busquedaCliente;
    private javax.swing.JTextField busquedaClientePago;
    private javax.swing.JTextField busquedaCodigo;
    private javax.swing.JTextField busquedaCodigoPago;
    private javax.swing.JTextField busquedaDNI;
    private javax.swing.JTextField busquedaEstado;
    private javax.swing.JTextField busquedaEstadoPago;
    private javax.swing.JTextField busquedaFecha;
    private javax.swing.JTextField busquedaFechaFin;
    private javax.swing.JTextField busquedaFechaInicio;
    private javax.swing.JTextField busquedaFechaPago;
    private javax.swing.JTextField busquedaImporte;
    private javax.swing.JTextField busquedaImportePago;
    private javax.swing.JTextField busquedaNombre;
    private javax.swing.JTextField busquedaPrecio;
    private javax.swing.JTextField busquedaRazonSocial;
    private javax.swing.JTextField busquedaSemana;
    private javax.swing.JPanel contenedorBotones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLayeredPane panelMostrar;
    private javax.swing.JPanel panelMostrarCliente;
    private javax.swing.JPanel panelMostrarPago;
    private javax.swing.JPanel panelMostrarPedido;
    private javax.swing.JPanel panelMostrarTarifa;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTable tablaPago;
    private javax.swing.JTable tablaPedido;
    private javax.swing.JTable tablaTarifa;
    // End of variables declaration//GEN-END:variables
}
