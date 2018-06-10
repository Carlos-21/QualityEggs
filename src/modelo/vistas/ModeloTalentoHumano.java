/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vistas;

import java.awt.Dimension;
import java.awt.Point;
import vista.TalentoHumano.VentanaPrincipal;

/**
 *
 * @author CARLOS
 */
public class ModeloTalentoHumano {
    
    public void opcionesTrabajador(VentanaPrincipal ventana, Point posicion1, Point posicion2, Dimension tamaño, boolean bandera){
        int posicionX = posicion1.x;
        int posicionY = posicion1.y;
        
        if(bandera){
            ventana.getBotonAñadir().setBounds(posicionX + 10, posicionY + 30, tamaño.width - 20, tamaño.height);
            ventana.add(ventana.getBotonAñadir());

            ventana.getBotonActualizar().setBounds(posicionX + 10, posicionY + 60, tamaño.width - 20, tamaño.height);
            ventana.add(ventana.getBotonActualizar());

            ventana.getBotonEliminar().setBounds(posicionX + 10, posicionY + 90, tamaño.width - 20, tamaño.height);
            ventana.add(ventana.getBotonEliminar());

            ventana.getBotonReporte().setBounds(posicionX, posicionY + 140, tamaño.width, tamaño.height);
            ventana.add(ventana.getBotonReporte());
            
            bandera = false;
        } 
        else{
            ventana.remove(ventana.getBotonAñadir());
            ventana.remove(ventana.getBotonActualizar());
            ventana.remove(ventana.getBotonEliminar());

            ventana.getBotonReporte().setBounds(posicionX, posicion2.y, tamaño.width, tamaño.height);
            ventana.add(ventana.getBotonReporte());
            
            bandera = true;
        }
    }
}
