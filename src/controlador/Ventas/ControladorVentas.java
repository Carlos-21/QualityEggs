/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.dato.Ventas.Cliente;
import modelo.dao.dato.Ventas.Pedido;
import modelo.dao.dato.Ventas.Tarifa;
import modelo.dao.diseño.Ventas.IClienteDAO;
import modelo.dao.diseño.Ventas.IPagoDAO;
import modelo.dao.diseño.Ventas.IPedidoDAO;
import modelo.dao.diseño.Ventas.ITarifaDAO;
import vista.SistemaVentas.FormularioCliente;
import vista.SistemaVentas.FormularioPago;
import vista.SistemaVentas.FormularioTarifa;
import vista.SistemaVentas.ListaClientes;
import vista.SistemaVentas.VentanaPrincipalVentas;
import vista.propiedad.Colores;
import vista.propiedad.Directorio;
import vista.propiedad.Propiedad;

/**
 *
 * @author CARLOS
 */
public class ControladorVentas implements ActionListener, KeyListener, MouseListener{
    private VentanaPrincipalVentas vista;
    private IClienteDAO modelo1;
    private ITarifaDAO modelo2;
    private IPedidoDAO modelo3;
    private IPagoDAO modelo4;

    public ControladorVentas(VentanaPrincipalVentas vista, IClienteDAO modelo1, ITarifaDAO modelo2, IPedidoDAO modelo3, IPagoDAO modelo4) {
        this.vista = vista;
        this.modelo1 = modelo1;
        this.modelo2 = modelo2;
        this.modelo3 = modelo3;
        this.modelo4 = modelo4;
        mostrarDatosCliente("", 0);
        mostrarDatosPedido("", 0);
        mostrarDatosTarifa("", 0);
        mostrarDatosPedidoPendientes("", 0);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonCliente())){
            mostrarDatosCliente("", 0);
        }
        
        if(evento.getSource().equals(vista.getBotonAñadirCliente())){
            this.vista.dispose();
            
            FormularioCliente vista = new FormularioCliente();
            vista.setVentana(this.vista);
            vista.setTitle("Registrar cliente");
            Propiedad.ponerImagenBoton(vista.getBotonFormulario(), Directorio.botonRegistrar, "Registrar", Colores.botonRegistrar);
            
            ControladorCliente controlador = new ControladorCliente(vista, modelo1);
            vista.setControlador(controlador);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);  
        }
        
        if(evento.getSource().equals(vista.getBotonActualizarCliente())){
            this.vista.dispose();
            
            FormularioCliente vista = new FormularioCliente();
            vista.setVentana(this.vista);
            vista.llenarFormulario(this.vista.getClientes().get(this.vista.getFilaCliente()));
            vista.setTitle("Actualizar cliente");
            Propiedad.ponerImagenBoton(vista.getBotonFormulario(), Directorio.botonActualizar, "Actualizar", Colores.botonActualizar);
            
            ControladorCliente controlador = new ControladorCliente(vista, modelo1);
            vista.setControlador(controlador);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);  
        }
        
        if(evento.getSource().equals(vista.getBotonEliminarCliente())){
            boolean resultado = modelo1.eliminarCliente(vista.getClientes().get(vista.getFilaCliente()).getDNI());
            
            if(resultado){
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
            }
        }
        
        
        if(evento.getSource().equals(vista.getBotonPedido())){
            
        }
        
        if(evento.getSource().equals(vista.getBotonAñadirPedido())){
            this.vista.dispose();
            
            ListaClientes vista = new ListaClientes();
            vista.setVentana(this.vista);
            vista.setTitle("Lista de clientes disponibles");
            
            ControladorListadoCliente controlador = new ControladorListadoCliente(vista, modelo1);
            vista.setControlador(controlador);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null); 
        }
        
        
        if(evento.getSource().equals(vista.getBotonTarifa())){
            mostrarDatosTarifa("", 0);
        }
        
        if(evento.getSource().equals(vista.getBotonAñadirTarifa())){
            this.vista.dispose();
            
            FormularioTarifa vista = new FormularioTarifa();
            vista.setVentana(this.vista);
            vista.setTitle("Registrar tarifa");
            Propiedad.ponerImagenBoton(vista.getBotonFormulario(), Directorio.botonRegistrar, "Registrar", Colores.botonRegistrar);
            
            ControladorTarifa controlador = new ControladorTarifa(vista, modelo2);
            vista.setControlador(controlador);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);  
        }
        
        if(evento.getSource().equals(vista.getBotonActualizarTarifa())){
            this.vista.dispose();
            
            FormularioTarifa vista = new FormularioTarifa();
            vista.llenarFormulario(this.vista.getTarifas().get(this.vista.getFilaTarifa()));
            vista.setVentana(this.vista);
            vista.setTitle("Actualizar tarifa");
            Propiedad.ponerImagenBoton(vista.getBotonFormulario(), Directorio.botonActualizar, "Actualizar", Colores.botonActualizar);
            
            ControladorTarifa controlador = new ControladorTarifa(vista, modelo2);
            vista.setControlador(controlador);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);  
        }
        
        
        if(evento.getSource().equals(vista.getBotonPago())){
            mostrarDatosPedidoPendientes("", 0);
        }
        
        if(evento.getSource().equals(vista.getBotonAñadirPago())){
            this.vista.dispose();
            
            FormularioPago vista = new FormularioPago();
            vista.setVentana(this.vista);
            vista.setTitle("Registrar pago");
            vista.llenarFormulario(this.vista.getPedidosPendiente().get(this.vista.getFilaPedidoPendiente()));
            Propiedad.ponerImagenBoton(vista.getBotonFormulario(), Directorio.botonRegistrar, "Registrar", Colores.botonRegistrar);
            
            ControladorPago controlador = new ControladorPago(vista, modelo4);
            vista.setControlador(controlador);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
        }
        
        if(evento.getSource().equals(vista.getBotonSalir())){
            vista.getLogin().setVisible(true);
            vista.getLogin().setLocationRelativeTo(null);
            
            vista.dispose();
        }
        
        mostrarDatosCliente("", 0);
        mostrarDatosTarifa("", 0);
        mostrarDatosPedido("", 0);
        mostrarDatosPedidoPendientes("", 0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent evento) {
    }

    @Override
    public void keyReleased(KeyEvent evento) {
        //Búqueda en la tabla Clientes
        if(evento.getSource().equals(vista.getBusquedaDNI())){
            String busqueda = vista.getBusquedaDNI().getText().trim();
            
            mostrarDatosCliente(busqueda, 1);
        }
        if(evento.getSource().equals(vista.getBusquedaNombre())){
            String busqueda = vista.getBusquedaNombre().getText().trim();
            
            mostrarDatosCliente(busqueda, 2);
        }
        if(evento.getSource().equals(vista.getBusquedaRazonSocial())){
            String busqueda = vista.getBusquedaRazonSocial().getText().trim();
            
            mostrarDatosCliente(busqueda, 3);
        }
        
        
        //Búsqueda en la tabla Pedidos
        if(evento.getSource().equals(vista.getBusquedaCodigo())){
            String busqueda = vista.getBusquedaCodigo().getText().trim();
            
            mostrarDatosPedido(busqueda, 1);
        }
        
        if(evento.getSource().equals(vista.getBusquedaCliente())){
            String busqueda = vista.getBusquedaCliente().getText().trim();
            
            mostrarDatosPedido(busqueda, 2);
        }
        
        if(evento.getSource().equals(vista.getBusquedaFecha())){
            String busqueda = vista.getBusquedaFecha().getText().trim();
            
            mostrarDatosPedido(busqueda, 3);
        }
        
        if(evento.getSource().equals(vista.getBusquedaImporte())){
            String busqueda = vista.getBusquedaCodigo().getText().trim();
            
            mostrarDatosPedido(busqueda, 4);
        }
        
        if(evento.getSource().equals(vista.getBusquedaEstado())){
            String busqueda = vista.getBusquedaEstado().getText().trim();
            
            mostrarDatosPedido(busqueda, 5);
        }
       
        
        //Búqueda en la tabla Tarifas
        if(evento.getSource().equals(vista.getBusquedaSemana())){
            String busqueda = vista.getBusquedaSemana().getText().trim();
            
            mostrarDatosTarifa(busqueda, 1);
        }
        
        if(evento.getSource().equals(vista.getBusquedaPrecio())){
            String busqueda = vista.getBusquedaPrecio().getText().trim();
            
            mostrarDatosTarifa(busqueda, 2);
        }
        
        if(evento.getSource().equals(vista.getBusquedaFechaInicio())){
            String busqueda = vista.getBusquedaFechaInicio().getText().trim();
            
            mostrarDatosTarifa(busqueda, 3);
        }
        
        if(evento.getSource().equals(vista.getBusquedaFechaFin())){
            String busqueda = vista.getBusquedaFechaFin().getText().trim();
            
            mostrarDatosTarifa(busqueda, 4);
        }
        
        //Búsqueda en la tabla Pagos
        if(evento.getSource().equals(vista.getBusquedaCodigoPago())){
            String busqueda = vista.getBusquedaCodigoPago().getText().trim();
            
            mostrarDatosPedidoPendientes(busqueda, 1);
        }
        
        if(evento.getSource().equals(vista.getBusquedaClientePago())){
            String busqueda = vista.getBusquedaClientePago().getText().trim();
            
            mostrarDatosPedidoPendientes(busqueda, 2);
        }
        
        if(evento.getSource().equals(vista.getBusquedaFechaPago())){
            String busqueda = vista.getBusquedaFechaPago().getText().trim();
            
            mostrarDatosPedidoPendientes(busqueda, 3);
        }
        
        if(evento.getSource().equals(vista.getBusquedaImportePago())){
            String busqueda = vista.getBusquedaImportePago().getText().trim();
            
            mostrarDatosPedidoPendientes(busqueda, 4);
        }
        
        if(evento.getSource().equals(vista.getBusquedaEstadoPago())){
            String busqueda = vista.getBusquedaEstadoPago().getText().trim();
            
            mostrarDatosPedidoPendientes(busqueda, 5);
        }
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        if(evento.getSource().equals(vista.getTablaCliente())){
            vista.setFilaCliente(vista.getTablaCliente().rowAtPoint(evento.getPoint()));
        }
        
        if(evento.getSource().equals(vista.getTablaTarifa())){
            vista.setFilaTarifa(vista.getTablaTarifa().rowAtPoint(evento.getPoint()));
        }   
        
        if(evento.getSource().equals(vista.getTablaPago())){
            vista.setFilaPedidoPendiente(vista.getTablaPago().rowAtPoint(evento.getPoint()));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    private void mostrarDatosCliente(String busqueda, int categoria) {       
        vista.setClientes(modelo1.listarCliente(busqueda, categoria));

        if (vista.getClientes() != null) {
            String[] columnas = {"DNI", "Nombre", "Razón Social"};

            String[][] filas = new String[vista.getClientes().size()][3];

            for (int i = 0; i < vista.getClientes().size(); i++) {
                Cliente auxiliar = vista.getClientes().get(i);

                filas[i][0] = auxiliar.getDNI();
                filas[i][1] = auxiliar.getNombre();
                filas[i][2] = auxiliar.getRazonSocial();
            }

            DefaultTableModel tabla = new DefaultTableModel(filas, columnas);

            vista.getTablaCliente().setModel(tabla);
            vista.repaint();
        }
    }
    
    private void mostrarDatosPedido(String busqueda, int categoria) {      
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        vista.setPedidos(modelo3.listarPedido(busqueda, categoria));

        if (vista.getPedidos() != null) {
            String[] columnas = {"Código", "Cliente", "Fecha", "Importe total", "Estado"};

            String[][] filas = new String[vista.getPedidos().size()][5];

            for (int i = 0; i < vista.getPedidos().size(); i++) {
                Pedido auxiliar = vista.getPedidos().get(i);

                filas[i][0] = auxiliar.getCodigoPedido();
                filas[i][1] = auxiliar.getNombreCliente();
                filas[i][2] = formato.format(auxiliar.getFechaRegistro());
                filas[i][3] = String.valueOf(auxiliar.getImporteTotal());
                filas[i][4] = auxiliar.getEstado();
            }

            DefaultTableModel tabla = new DefaultTableModel(filas, columnas);

            vista.getTablaPedido().setModel(tabla);
            vista.repaint();
        }
    }
    
    private void mostrarDatosTarifa(String busqueda, int categoria) {      
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        vista.setTarifas(modelo2.listarTarifa(busqueda, categoria));

        if (vista.getTarifas() != null) {
            String[] columnas = {"Nº Semana", "Precio", "Fecha de Inicio", "Fechade de Fin"};

            String[][] filas = new String[vista.getTarifas().size()][4];

            for (int i = 0; i < vista.getTarifas().size(); i++) {
                Tarifa auxiliar = vista.getTarifas().get(i);

                filas[i][0] = String.valueOf(auxiliar.getNumeroSemana());
                filas[i][1] = String.valueOf(auxiliar.getPrecioUnitario());
                filas[i][2] = formato.format(auxiliar.getFechaInicio());
                filas[i][3] = formato.format(auxiliar.getFechaFin());
            }

            DefaultTableModel tabla = new DefaultTableModel(filas, columnas);

            vista.getTablaTarifa().setModel(tabla);
            vista.repaint();
        }
    }
    
    private void mostrarDatosPedidoPendientes(String busqueda, int categoria) {      
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        vista.setPedidosPendiente(modelo3.listarPedidoPendiente(busqueda, categoria));

        
        if (vista.getPedidosPendiente()!= null) {
            String[] columnas = {"Código", "Cliente", "Fecha", "Importe total", "Estado"};

            String[][] filas = new String[vista.getPedidosPendiente().size()][5];

            for (int i = 0; i < vista.getPedidosPendiente().size(); i++) {
                Pedido auxiliar = vista.getPedidosPendiente().get(i);

                filas[i][0] = auxiliar.getCodigoPedido();
                filas[i][1] = auxiliar.getNombreCliente();
                filas[i][2] = formato.format(auxiliar.getFechaRegistro());
                filas[i][3] = String.valueOf(auxiliar.getImporteTotal());
                filas[i][4] = auxiliar.getEstado();
            }

            DefaultTableModel tabla = new DefaultTableModel(filas, columnas);

            vista.getTablaPago().setModel(tabla);
            vista.repaint();
        }
    }
    
}
