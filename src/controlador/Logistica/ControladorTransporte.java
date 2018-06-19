/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Logistica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.Conexion.ConexionArduino;
import vista.Logistica.FormularioTransporte;

/**
 *
 * @author CARLOS
 */
public class ControladorTransporte implements ActionListener{
    private FormularioTransporte vista;
    private ConexionArduino modelo;

    public ControladorTransporte(FormularioTransporte vista, ConexionArduino modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.modelo.Conectar();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonEnviar())){
            String cantidad = vista.getTextoCantidad().getText();
            modelo.enviarDatos(cantidad);
            
            JOptionPane.showMessageDialog(null, "Se esta enviando los paquetes de huevo por la banda");
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
