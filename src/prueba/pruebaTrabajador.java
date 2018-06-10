/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import controlador.ControladorTalentoHumano;
import modelo.vistas.ModeloTalentoHumano;
import vista.TalentoHumano.VentanaPrincipal;

/**
 *
 * @author CARLOS
 */
public class pruebaTrabajador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VentanaPrincipal vista = new VentanaPrincipal();
        
        ModeloTalentoHumano modelo = new ModeloTalentoHumano();
        
        ControladorTalentoHumano controlador = new ControladorTalentoHumano(vista, modelo);
        
        vista.setControlador(controlador);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
}
