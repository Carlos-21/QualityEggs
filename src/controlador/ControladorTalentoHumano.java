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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.dao.componente.EmpleadoDAO;
import modelo.dao.componente.PersonaDAO;
import modelo.dao.dato.Persona;
import modelo.dao.diseño.IPersonaDAO;
import modelo.vistas.ModeloTalentoHumano;
import vista.TalentoHumano.FormularioTrabajador;
import vista.TalentoHumano.VentanaPrincipal;

/**
 *
 * @author CARLOS
 */
public class ControladorTalentoHumano implements ActionListener, KeyListener{
    private VentanaPrincipal vista;
    private ModeloTalentoHumano modelo1;
    private IPersonaDAO modelo2;

    public ControladorTalentoHumano(VentanaPrincipal vista, ModeloTalentoHumano modelo1, IPersonaDAO modelo2) {
        this.vista = vista;
        this.modelo1 = modelo1;
        this.modelo2 = modelo2;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonTrabajador())){
            modelo1.opcionesTrabajador(vista, vista.getPosicion1(), vista.getPosicion2(), vista.getTamaño(), vista.isBandera());
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
    public void keyTyped(KeyEvent evento) {
        
    }

    @Override
    public void keyPressed(KeyEvent evento) {
        
    }

    @Override
    public void keyReleased(KeyEvent evento) {
        if(evento.getSource().equals(vista.getBusquedaDNI())){
            String busqueda = vista.getBusquedaDNI().getText();
            
            mostrarDatos(busqueda, 1);
        }
    }
    
    private void mostrarDatos(String busqueda, int categoria) {
        ArrayList<Persona> personas = modelo2.listarPersona(busqueda, categoria);

        System.out.println("Cantidad : "+personas.size());
        if (personas != null) {
            String[] columnas = {"DNI", "Nombre", "Comisión"};

            String[][] filas = new String[personas.size()][3];

            for (int i = 0; i < personas.size(); i++) {
                Persona auxiliar = personas.get(i);

                filas[i][0] = auxiliar.getDNI();
                filas[i][1] = auxiliar.getNombre();
                filas[i][2] = " ";
            }

            DefaultTableModel tabla = new DefaultTableModel(filas, columnas);

            vista.getTablaTrabajadores().setModel(tabla);
        }
    }
}
