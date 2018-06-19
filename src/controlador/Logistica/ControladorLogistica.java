/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Logistica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.Conexion.ConexionArduino;
import modelo.dao.dato.Logistica.Produccion;
import modelo.dao.dato.Ventas.Pedido;
import modelo.dao.diseño.Logistica.IProduccionDAO;
import modelo.dao.diseño.Ventas.IPedidoDAO;
import vista.Logistica.FormularioProduccion;
import vista.Logistica.FormularioTransporte;
import vista.Logistica.VentanaPrincipalProduccion;
import vista.propiedad.Colores;
import vista.propiedad.Directorio;
import vista.propiedad.Propiedad;

/**
 *
 * @author CARLOS
 */
public class ControladorLogistica implements ActionListener, KeyListener, MouseListener{
    private VentanaPrincipalProduccion vista;
    private IProduccionDAO modelo1;
    private IPedidoDAO modelo2;

    public ControladorLogistica(VentanaPrincipalProduccion vista, IProduccionDAO modelo1, IPedidoDAO modelo2) {
        this.vista = vista;
        this.modelo1 = modelo1;
        this.modelo2 = modelo2;
        mostrarDatosProduccion("", 0);
        mostrarDatosPedidoPagados("", 0);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonAñadirProduccion())){
            this.vista.dispose();
            
            FormularioProduccion vista = new FormularioProduccion();
            vista.setVentana(this.vista);
            vista.setTitle("Registrar producción");
            Propiedad.ponerImagenBoton(vista.getBotonFormulario(), Directorio.botonRegistrar, "Registrar", Colores.botonRegistrar);
            
            ControladorProduccion controlador = new ControladorProduccion(vista, modelo1);
            vista.setControlador(controlador);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);            
        }
        
        if(evento.getSource().equals(vista.getBotonActualizarProduccion())){
            this.vista.dispose();
            
            FormularioProduccion vista = new FormularioProduccion();
            vista.setVentana(this.vista);
            vista.llenarFormulario(this.vista.getProducciones().get(this.vista.getFila()));
            vista.setTitle("Actualizar producción");
            Propiedad.ponerImagenBoton(vista.getBotonFormulario(), Directorio.botonActualizar, "Actualizar", Colores.botonActualizar);
            
            ControladorProduccion controlador = new ControladorProduccion(vista, modelo1);
            vista.setControlador(controlador);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
        }
        
        if(evento.getSource().equals(vista.getBotonEliminarProduccion())){
            boolean resultado = modelo1.eliminarProduccion(vista.getProducciones().get(vista.getFila()).getCodigo());
            
            if(resultado){
                JOptionPane.showMessageDialog(null, "Producción eliminada");
            }
        }
        
        if(evento.getSource().equals(vista.getBotonSalir())){
            vista.getLogin().setVisible(true);
            vista.getLogin().setLocationRelativeTo(null);
            
            vista.dispose();
        }
        
        if(evento.getSource().equals(vista.getBotonEntrega())){
            mostrarDatosPedidoPagados("", 0);
        }
        
        if(evento.getSource().equals(vista.getBotonTransporte())){
            this.vista.dispose();
            
            FormularioTransporte vista = new FormularioTransporte();
            vista.setVentana(this.vista);
            vista.llenarFormulario(this.vista.getPedidosPagados().get(this.vista.getFilaPedidoPagado()));
            vista.setTitle("Transporte de pedido");
            Propiedad.ponerImagenBotonOpciones(vista.getBotonEnviar(), Directorio.botonEnviar);
            
            ConexionArduino modelo = new ConexionArduino();
            
            ControladorTransporte controlador = new ControladorTransporte(vista, modelo);
            vista.setControlador(controlador);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
        }
        
        mostrarDatosProduccion("", 0);
        mostrarDatosPedidoPagados("", 0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent evento) {
        //Búsqueda en la tabla de productos
        if(evento.getSource().equals(vista.getBusquedaCodigo())){
            String busqueda = vista.getBusquedaCodigo().getText();
            
            mostrarDatosProduccion(busqueda, 1);
        }
        if(evento.getSource().equals(vista.getBusquedaAlmacen())){
            String busqueda = vista.getBusquedaAlmacen().getText();
            
            mostrarDatosProduccion(busqueda, 2);
        }
        if(evento.getSource().equals(vista.getBusquedaFecha())){
            String busqueda = vista.getBusquedaFecha().getText();
            
            mostrarDatosProduccion(busqueda, 3);
        }
        if(evento.getSource().equals(vista.getBusquedaPeso())){
            String busqueda = vista.getBusquedaPeso().getText();
            
            mostrarDatosProduccion(busqueda, 4);
        }
        if(evento.getSource().equals(vista.getBusquedaStock())){
            String busqueda = vista.getBusquedaStock().getText();
            
            mostrarDatosProduccion(busqueda, 5);
        }
        
        //Búsqueda en la tabla de pedidos pagados
        if(evento.getSource().equals(vista.getBusquedaCodigoPedido())){
            String busqueda = vista.getBusquedaCodigo().getText();
            
            mostrarDatosPedidoPagados(busqueda, 1);
        }
        if(evento.getSource().equals(vista.getBusquedaClientePedido())){
            String busqueda = vista.getBusquedaClientePedido().getText();
            
            mostrarDatosPedidoPagados(busqueda, 2);
        }
        if(evento.getSource().equals(vista.getBusquedaFechaPedido())){
            String busqueda = vista.getBusquedaFechaPedido().getText();
            
            mostrarDatosPedidoPagados(busqueda, 3);
        }
        if(evento.getSource().equals(vista.getBusquedaImportePedido())){
            String busqueda = vista.getBusquedaImportePedido().getText();
            
            mostrarDatosPedidoPagados(busqueda, 4);
        }
        if(evento.getSource().equals(vista.getBusquedaEstadoPedido())){
            String busqueda = vista.getBusquedaEstadoPedido().getText();
            
            mostrarDatosPedidoPagados(busqueda, 5);
        }
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        if(evento.getSource().equals(vista.getTablaMostrar())){
            vista.setFila(vista.getTablaMostrar().rowAtPoint(evento.getPoint()));
        }
        
        if(evento.getSource().equals(vista.getTablaPedido())){
            vista.setFilaPedidoPagado(vista.getTablaPedido().rowAtPoint(evento.getPoint()));
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
    
    private void mostrarDatosProduccion(String busqueda, int categoria) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        vista.setProducciones(modelo1.listarProduccion(busqueda, categoria));

        if (vista.getProducciones() != null) {
            String[] columnas = {"Código", "Almacén", "Fecha", "Peso", "Stock"};

            String[][] filas = new String[vista.getProducciones().size()][5];

            for (int i = 0; i < vista.getProducciones().size(); i++) {
                Produccion auxiliar = vista.getProducciones().get(i);

                filas[i][0] = auxiliar.getCodigo();
                filas[i][1] = auxiliar.getNombreAlmacen();
                filas[i][2] = formato.format(auxiliar.getFechaIngreso());
                filas[i][3] = String.valueOf(auxiliar.getPeso());
                filas[i][4] = String.valueOf(auxiliar.getStock());
            }

            DefaultTableModel tabla = new DefaultTableModel(filas, columnas);

            vista.getTablaMostrar().setModel(tabla);
            vista.repaint();
        }
    }

    private void mostrarDatosPedidoPagados(String busqueda, int categoria) {      
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        vista.setPedidosPagados(modelo2.listarPedidoPagados(busqueda, categoria));

        
        if (vista.getPedidosPagados()!= null) {
            String[] columnas = {"Código", "Cliente", "Fecha", "Importe total", "Estado"};

            String[][] filas = new String[vista.getPedidosPagados().size()][5];

            for (int i = 0; i < vista.getPedidosPagados().size(); i++) {
                Pedido auxiliar = vista.getPedidosPagados().get(i);

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
    
}
