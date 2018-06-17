/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Logistica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.dao.dato.Logistica.Produccion;
import modelo.dao.diseño.Logistica.IProduccionDAO;
import vista.Logistica.FormularioProduccion;

/**
 *
 * @author CARLOS
 */
public class ControladorProduccion implements ActionListener{
    private FormularioProduccion vista;
    private IProduccionDAO modelo;

    public ControladorProduccion(FormularioProduccion vista, IProduccionDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonFormulario())){
            if(vista.getBotonFormulario().getText() == "Registrar"){
                String codigo = vista.getTextoCodigo().getText();
                String nombreAlmacen = vista.getTextoAlmacen().getText();
                Date fechaIngreso = vista.getFechaIngreso().getDate();
                double peso = Double.valueOf(vista.getTextoPeso().getText());
                int stock = Integer.valueOf(vista.getTextoStock().getText());
                
                Produccion produccion = new Produccion();
                produccion.setCodigo(codigo);
                produccion.setNombreAlmacen(nombreAlmacen);
                produccion.setFechaIngreso(fechaIngreso);
                produccion.setPeso(peso);
                produccion.setStock(stock);
                
                boolean resultado = modelo.insertarProduccion(produccion);
                
                if(resultado){
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                }
            }
            if(vista.getBotonFormulario().getText() == "Actualizar"){
                String codigo = vista.getTextoCodigo().getText();
                String nombreAlmacen = vista.getTextoAlmacen().getText();
                Date fechaIngreso = vista.getFechaIngreso().getDate();
                double peso = Double.valueOf(vista.getTextoPeso().getText());
                int stock = Integer.valueOf(vista.getTextoStock().getText());
                
                Produccion produccion = new Produccion();
                produccion.setCodigo(codigo);
                produccion.setNombreAlmacen(nombreAlmacen);
                produccion.setFechaIngreso(fechaIngreso);
                produccion.setPeso(peso);
                produccion.setStock(stock);
                
                boolean resultado = modelo.actualizarProduccion(produccion, vista.getVentana().getProducciones().get(vista.getVentana().getFila()).getCodigo());
                
                if(resultado){
                    JOptionPane.showMessageDialog(null, "Actualización exitosa");
                }
            }
        }
        
        if(evento.getSource().equals(vista.getBotonAtras())){
            vista.dispose();
            vista.getVentana().setVisible(true);
            vista.getVentana().setLocationRelativeTo(null);
        }
        
        if(evento.getSource().equals(vista.getBotonSalir())){           
            System.exit(0);
        }
    }
    
    
}
