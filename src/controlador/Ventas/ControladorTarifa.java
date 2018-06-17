/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.dao.dato.Ventas.Tarifa;
import modelo.dao.diseño.Ventas.ITarifaDAO;
import vista.SistemaVentas.FormularioTarifa;

/**
 *
 * @author CARLOS
 */
public class ControladorTarifa implements ActionListener{
    private FormularioTarifa vista;
    private ITarifaDAO modelo;

    public ControladorTarifa(FormularioTarifa vista, ITarifaDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonFormulario())){
            if(vista.getBotonFormulario().getText().equals("Registrar")){
                double precioUnitario = Double.parseDouble(vista.getTextoPrecioUnitario().getText());
                Date fechaInicio = vista.getFechaInicio().getDate();
                Date fechaFin = vista.getFechaFin().getDate();
                
                Tarifa tarifa = new Tarifa();
                tarifa.setPrecioUnitario(precioUnitario);
                tarifa.setFechaInicio(fechaInicio);
                tarifa.setFechaFin(fechaFin);
                
                boolean resultado = modelo.insertarTarifa(tarifa);
                
                if(resultado){
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                }
            }
            if(vista.getBotonFormulario().getText().equals("Actualizar")){
                double precioUnitario = Double.parseDouble(vista.getTextoPrecioUnitario().getText());
                Date fechaInicio = vista.getFechaInicio().getDate();
                Date fechaFin = vista.getFechaFin().getDate();
                
                Tarifa tarifa = new Tarifa();
                tarifa.setPrecioUnitario(precioUnitario);
                tarifa.setFechaInicio(fechaInicio);
                tarifa.setFechaFin(fechaFin);
                
                boolean resultado = modelo.actualizarTarifa(tarifa, vista.getVentana().getTarifas().get(vista.getVentana().getFilaTarifa()).getNumeroSemana());
                
                if(resultado){
                    JOptionPane.showMessageDialog(null, "Actualización exitosa");
                }
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
