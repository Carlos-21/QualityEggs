/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame.propiedad;

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
public class Directorio {
    public static String login = "src/frame/imagenes/seguridad/login.png";
    public static String fondoLogin = "src/frame/imagenes/seguridad/fondoLogin.jpg";
    public static String botonAtras = "src/frame/imagenes/iconos/retroceso.png";
    public static String botonSalir = "src/frame/imagenes/iconos/salir.png";
    public static String botonActualizar = "src/frame/imagenes/iconos/actualizar.png";
    
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
}
