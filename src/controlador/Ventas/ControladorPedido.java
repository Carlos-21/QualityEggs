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
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.dao.dato.Ventas.Pedido;
import modelo.dao.diseño.Ventas.IPedidoDAO;
import vista.SistemaVentas.FormularioPedido;

/**
 *
 * @author CARLOS
 */
public class ControladorPedido implements ActionListener, KeyListener{
    private FormularioPedido vista;
    private IPedidoDAO modelo;

    public ControladorPedido(FormularioPedido vista, IPedidoDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
            
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonFormulario())){
            if(vista.getBotonFormulario().getText().equals("Registrar")){
                String dniCliente = vista.getCliente().getDNI();
                String nombreCliente = vista.getTextoCliente().getText();
                Date fechaRegistro = vista.getFechaPedido().getDate();
                int cantidadPaquetes = Integer.parseInt(vista.getTextoCantidad().getText());
                String importe = vista.getTextoImporteTotal().getText().replace(",", ".");
                double importeTotal = Double.parseDouble(importe);
                
                Pedido pedido = new Pedido();
                pedido.setDniCliente(dniCliente);
                pedido.setNombreCliente(nombreCliente);
                pedido.setFechaRegistro(fechaRegistro);
                pedido.setCantidadPaquetes(cantidadPaquetes);
                pedido.setImporteTotal(importeTotal);
                
                boolean resultado = modelo.insertarPedido(pedido);
                boolean stock = modelo.actualizarStock(cantidadPaquetes);
                
                if(resultado && stock){
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                }
            }
            
            if(vista.getBotonFormulario().getText().equals("Actualizar")){
                
            }
        }
        
        if(evento.getSource().equals(vista.getBotonConsultar())){
            try{
                int cantidadPaquetes = Integer.parseInt(vista.getTextoCantidad().getText());

                boolean resultado = modelo.consultarAlmacen(cantidadPaquetes);

                if (resultado) {
                    JOptionPane.showMessageDialog(null, "Se tiene productos necesarios");
                } else {
                    JOptionPane.showMessageDialog(null, "Se necesita pedir más productos al proveedor");
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "No se ha escrito la cantidad");
            }
            
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
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent evento) {
        if(evento.getSource().equals(vista.getTextoCantidad())){
            DecimalFormat formato = new DecimalFormat("#.00");
            try{
                int cantidad = Integer.parseInt(vista.getTextoCantidad().getText());
                vista.getTextoImporteTotal().setText(formato.format(cantidad * modelo.tarifaPaquetes()));
            }
            catch(NumberFormatException exception){
                vista.getTextoImporteTotal().setText("0");
            }
        }
    }
    
}
