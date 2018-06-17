/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.dato.Ventas.Pago;
import modelo.dao.diseño.Ventas.IPagoDAO;
import vista.SistemaVentas.FormularioPago;

/**
 *
 * @author CARLOS
 */
public class ControladorPago implements ActionListener{
    private FormularioPago vista;
    private IPagoDAO modelo;

    public ControladorPago(FormularioPago vista, IPagoDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonFormulario())){
            String dniCliente = vista.getTextoDNICliente().getText();
            String nombreCliente = vista.getTextoNombreCliente().getText();
            String codigoPedido = vista.getTextoCodigoPedido().getText();
            double importeTotal = Double.parseDouble(vista.getTextoImporteTotal().getText());
            
            Pago pago = new Pago();
            pago.setDniCliente(dniCliente);
            pago.setNombreCliente(nombreCliente);
            pago.setCodigoPedido(codigoPedido);
            pago.setImporteTotal(importeTotal);
            
            boolean resultado = modelo.insertarPago(pago);
            
            boolean estadoPedido = modelo.cambiarEstado(codigoPedido);
            
            if(resultado && estadoPedido){
                JOptionPane.showMessageDialog(null, "Se ha realizado el pago, por favor pase a almacén");
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
    
}
