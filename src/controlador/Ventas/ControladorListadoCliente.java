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
import javax.swing.table.DefaultTableModel;
import modelo.dao.dato.Ventas.Cliente;
import modelo.dao.diseño.Ventas.IClienteDAO;
import modelo.dao.diseño.Ventas.IPedidoDAO;
import modelo.factoria.FabricaDAO;
import vista.SistemaVentas.FormularioPedido;
import vista.SistemaVentas.ListaClientes;
import vista.propiedad.Colores;
import vista.propiedad.Directorio;
import vista.propiedad.Propiedad;

/**
 *
 * @author CARLOS
 */
public class ControladorListadoCliente implements ActionListener, KeyListener, MouseListener{
    private ListaClientes vista;
    private IClienteDAO modelo;

    public ControladorListadoCliente(ListaClientes vista, IClienteDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
        mostrarDatosCliente("", 0);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonContinuar())){
            this.vista.dispose();
            
            FormularioPedido vista = new FormularioPedido();
            vista.setVentana(this.vista);
            vista.setTitle("Registrar pedido");
            Propiedad.ponerImagenBoton(vista.getBotonFormulario(), Directorio.botonRegistrar, "Registrar", Colores.botonRegistrar);
            
            IPedidoDAO modelo = FabricaDAO.instanciar().getPedidoDAO();
            
            ControladorPedido controlador = new ControladorPedido(vista, modelo);
            
            Cliente auxiliar = this.vista.getClientes().get(this.vista.getFilaCliente());
            System.out.println("DNI : "+auxiliar.getDNI());
            vista.setCliente(auxiliar);
            vista.getTextoCliente().setText(auxiliar.getNombre() + " " +auxiliar.getApellido());
            vista.setControlador(controlador);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
            
        }
        
        if(evento.getSource().equals(vista.getBotonAtras())){
            vista.dispose();
            
            vista.getVentana().repaint();
            vista.getVentana().setVisible(true);
            vista.getVentana().setLocationRelativeTo(null);
        }
        
        if(evento.getSource().equals(vista.getBotonSalir())){
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent evento) {
        if(evento.getSource().equals(vista.getBusquedaDNI())){
            String busqueda = vista.getBusquedaDNI().getText();
            System.out.println("asfs : "+busqueda);
            mostrarDatosCliente(busqueda, 1);
        }
        if(evento.getSource().equals(vista.getBusquedaNombre())){
            String busqueda = vista.getBusquedaNombre().getText();
            
            mostrarDatosCliente(busqueda, 2);
        }
        if(evento.getSource().equals(vista.getBusquedaRazonSocial())){
            String busqueda = vista.getBusquedaRazonSocial().getText();
            
            mostrarDatosCliente(busqueda, 3);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        if(evento.getSource().equals(vista.getTablaCliente())){
            vista.setFilaCliente(vista.getTablaCliente().rowAtPoint(evento.getPoint()));
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
        vista.setClientes(modelo.listarCliente(busqueda, categoria));

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
    
}
