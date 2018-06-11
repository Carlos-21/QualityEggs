/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modelo.dao.componente.EmpleadoDAO;
import modelo.dao.componente.PersonaDAO;
import modelo.vistas.ModeloTalentoHumano;
import vista.TalentoHumano.FormularioTrabajador;
import vista.TalentoHumano.VentanaPrincipal;

/**
 *
 * @author CARLOS
 */
public class ControladorTalentoHumano implements ActionListener, KeyListener{
    private VentanaPrincipal vista;
    private ModeloTalentoHumano modelo;

    public ControladorTalentoHumano(VentanaPrincipal vista, ModeloTalentoHumano modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonTrabajador())){
            modelo.opcionesTrabajador(vista, vista.getPosicion1(), vista.getPosicion2(), vista.getTamaño(), vista.isBandera());
        }
        if(evento.getSource().equals(vista.getBotonAñadir())){
            vista.dispose();
            
            FormularioTrabajador vista = new FormularioTrabajador();
            PersonaDAO modelo1 = new PersonaDAO();
            EmpleadoDAO modelo2 = new EmpleadoDAO();
            
            ControladorTrabajador controlador = new ControladorTrabajador(vista, modelo1, modelo2);
            vista.setControlador(controlador);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
            
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
