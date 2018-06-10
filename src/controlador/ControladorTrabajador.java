/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.dao.componente.EmpleadoDAO;
import modelo.dao.componente.PersonaDAO;
import modelo.dao.dato.Empleado;
import modelo.dao.dato.Persona;
import vista.TalentoHumano.FormularioTrabajador;

/**
 *
 * @author CARLOS
 */
public class ControladorTrabajador implements ActionListener{
    private FormularioTrabajador vista;
    private PersonaDAO modelo1;
    private EmpleadoDAO modelo2;

    public ControladorTrabajador(FormularioTrabajador vista, PersonaDAO modelo1, EmpleadoDAO modelo2) {
        this.vista = vista;
        this.modelo1 = modelo1;
        this.modelo2 = modelo2;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonFormulario())){
            if(vista.getBotonFormulario().getText() == "Registrar"){
                Persona persona = new Persona();
                String dni = vista.getTextoDNI().getText();
                String nombre = vista.getTextoNombre().getText();
                String apellido = vista.getTextoApellido().getText(); 
                String direccion = vista.getTextoDireccion().getText();
                persona.setDNI(dni);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setDireccion(direccion);
                boolean resultado = modelo1.insertarPersona(persona);
                
                Empleado empleado = new Empleado();
                String usuario = vista.getTextoUsuario().getText();
                String contraseña = vista.getTextoContraseña().getText();
                Date fechIngreso = vista.getFechaIngreso().getDate();
                String cargo = String.valueOf(vista.getListadoCargo().getSelectedItem()); 
                empleado.setUsuario(usuario);
                empleado.setContraseña(contraseña);
                empleado.setFechIngreso(fechIngreso);
                empleado.setCargo(cargo);
                boolean resultado2 = modelo2.insertarEmpleado(empleado);
                
                if(resultado && resultado2){
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                }
            }
            if(vista.getBotonFormulario().getText() == "Actualizar"){
                
            }
        }
    }
    
    
}
