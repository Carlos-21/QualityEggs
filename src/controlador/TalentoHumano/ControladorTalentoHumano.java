/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.TalentoHumano;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.componente.EmpleadoDAO;
import modelo.dao.componente.PersonaDAO;
import modelo.dao.dato.Empleado;
import modelo.dao.diseño.IEmpleadoDAO;
import vista.TalentoHumano.FormularioTrabajador;
import vista.TalentoHumano.VentanaPrincipal;
import vista.propiedad.Colores;
import vista.propiedad.Directorio;
import vista.propiedad.Propiedad;

/**
 *
 * @author CARLOS
 */
public class ControladorTalentoHumano implements ActionListener, KeyListener, MouseListener{
    private VentanaPrincipal vista;
    private IEmpleadoDAO modelo;

    public ControladorTalentoHumano(VentanaPrincipal vista, IEmpleadoDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
        mostrarDatos("", 0);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonAñadir())){
            vista.dispose();
            
            FormularioTrabajador vista = new FormularioTrabajador();
            vista.setVentana(this.vista);
            vista.setTitle("Registrar trabajador");
            Propiedad.ponerImagenBoton(vista.getBotonFormulario(), Directorio.botonRegistrar, "Registrar", Colores.botonRegistrar);
            
            ControladorTrabajador controlador = new ControladorTrabajador(vista, modelo);
            vista.setControlador(controlador);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
            
        }
        if(evento.getSource().equals(vista.getBotonActualizar())){
            this.vista.dispose();
            
            FormularioTrabajador vista = new FormularioTrabajador();
            vista.setVentana(this.vista);
            vista.llenarFormulario(this.vista.getEmpleados().get(this.vista.getFila()));
            vista.setTitle("Actualizar trabajador");
            Propiedad.ponerImagenBoton(vista.getBotonFormulario(), Directorio.botonActualizar, "Actualizar", Colores.botonActualizar);
            
            ControladorTrabajador controlador = new ControladorTrabajador(vista, modelo);
            vista.setControlador(controlador);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
            
        }
        
        if(evento.getSource().equals(vista.getBotonEliminar())){
            //Verificar
            PersonaDAO modelo1 = new PersonaDAO();
            //modelo1.eliminarPersona(a.get(fila).getDNI());
            EmpleadoDAO modelo2 = new EmpleadoDAO(); 
            //modelo2.eliminarEmpleado(a.get(fila).getUsuario());
            JOptionPane.showMessageDialog(null, "Empleado eliminado");
        }
        
        if(evento.getSource().equals(vista.getBotonSalir())){
            vista.getLogin().setVisible(true);
            vista.getLogin().setLocationRelativeTo(null);
            
            vista.dispose();
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
        if(evento.getSource().equals(vista.getBusquedaCargo())){
            String busqueda = vista.getBusquedaCargo().getText();
            
            mostrarDatos(busqueda, 3);
        }
    }
    
    private void mostrarDatos(String busqueda, int categoria) {
        vista.setEmpleados(modelo.listarEmpleado(busqueda, categoria));

        if (vista.getEmpleados() != null) {
            String[] columnas = {"DNI", "Nombre", "Cargo"};

            String[][] filas = new String[vista.getEmpleados().size()][3];

            for (int i = 0; i < vista.getEmpleados().size(); i++) {
                Empleado auxiliar = vista.getEmpleados().get(i);

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
        vista.setFila(vista.getTablaTrabajadores().rowAtPoint(evento.getPoint()));
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
