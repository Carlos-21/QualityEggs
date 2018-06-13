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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.componente.EmpleadoDAO;
import modelo.dao.componente.PersonaDAO;
import modelo.dao.dato.Empleado;
import modelo.dao.diseño.IPersonaDAO;
import modelo.vistas.ModeloTalentoHumano;
import vista.TalentoHumano.FormularioTrabajador;
import vista.TalentoHumano.VentanaPrincipal;

/**
 *
 * @author CARLOS
 */
public class ControladorTalentoHumano implements ActionListener, KeyListener, MouseListener{
    private  ArrayList<Empleado> a; //esto se debe eliminar
    int fila;//esto se debe eliminar
    private VentanaPrincipal vista;
    private ModeloTalentoHumano modelo1;
    private IPersonaDAO modelo2;

    public ControladorTalentoHumano(VentanaPrincipal vista, ModeloTalentoHumano modelo1, IPersonaDAO modelo2) {
        this.vista = vista;
        this.modelo1 = modelo1;
        this.modelo2 = modelo2;
        mostrarDatos("", 0);
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
        if(evento.getSource().equals(vista.getBotonActualizar())){
            vista.dispose();
            
            FormularioTrabajador vista = new FormularioTrabajador();
            vista.getBotonFormulario().setText("Actualizar");
            vista.llenarFormulario(a.get(fila));
            PersonaDAO modelo1 = new PersonaDAO();
            EmpleadoDAO modelo2 = new EmpleadoDAO();
            
            ControladorTrabajador controlador = new ControladorTrabajador(vista, modelo1, modelo2);
            vista.setControlador(controlador);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
            
        }
        
        if(evento.getSource().equals(vista.getBotonEliminar())){
            PersonaDAO modelo1 = new PersonaDAO();
            modelo1.eliminarPersona(a.get(fila).getDNI());
            EmpleadoDAO modelo2 = new EmpleadoDAO(); 
            modelo2.eliminarEmpleado(a.get(fila).getUsuario());
            JOptionPane.showMessageDialog(null, "Empleado eliminado");
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
        if(evento.getSource().equals(vista.getBusquedaNombre())){
            String busqueda = vista.getBusquedaNombre().getText();
            
            mostrarDatos(busqueda, 2);
        }
    }
    
    private void mostrarDatos(String busqueda, int categoria) {
        EmpleadoDAO em = new EmpleadoDAO();
        ArrayList<Empleado> empleado = em.listarEmpleado(busqueda, categoria);
        a = empleado;
        if (empleado != null) {
            String[] columnas = {"DNI", "Nombre", "Cargo"};

            String[][] filas = new String[empleado.size()][3];

            for (int i = 0; i < empleado.size(); i++) {
                Empleado auxiliar = empleado.get(i);

                filas[i][0] = auxiliar.getDNI();
                filas[i][1] = auxiliar.getNombre();
                filas[i][2] = auxiliar.getCargo();
            }

            DefaultTableModel tabla = new DefaultTableModel(filas, columnas);

            vista.getTablaTrabajadores().setModel(tabla);
            vista.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        fila = vista.getTablaTrabajadores().rowAtPoint(evento.getPoint());
    }

    @Override
    public void mousePressed(MouseEvent evento) {
    }

    @Override
    public void mouseReleased(MouseEvent evento) {
    }

    @Override
    public void mouseEntered(MouseEvent evento) {
    }

    @Override
    public void mouseExited(MouseEvent evento) {
    }
}
