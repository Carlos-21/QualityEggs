/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.propiedad;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author CARLOS
 */
public class Propiedad {
        
    public static void ponerImagenLabel(JLabel label, String ruta){
        ImageIcon icon = new ImageIcon(ruta);
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono); 
    }
    
    public static void ponerImagenBoton(JButton boton, String ruta){
        boton.setOpaque(false);
        boton.setContentAreaFilled(false); 
        boton.setBorderPainted(false);
        ImageIcon icon = new ImageIcon(ruta);
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_DEFAULT));
        boton.setIcon(icono); 
    }
    
    public static void ponerImagenBoton(JButton boton, String ruta, String texto, Color color){
        ImageIcon icon = new ImageIcon(ruta);
        Icon icono = new ImageIcon(icon.getImage());
        boton.setIcon(icono); 
        boton.setText(texto);
        boton.setBackground(color);
    }
    
    public static void ponerImagenBotonOpciones(JButton boton, String ruta){
        ImageIcon icon = new ImageIcon(ruta);
        Icon icono = new ImageIcon(icon.getImage());
        boton.setIcon(icono); 
    }
    
}
