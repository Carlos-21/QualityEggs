/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.TalentoHumano;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.dao.dato.Empleado;
import modelo.dao.diseño.IEmpleadoDAO;
import vista.TalentoHumano.FormularioTrabajador;

/**
 *
 * @author CARLOS
 */
public class ControladorTrabajador implements ActionListener{
    private FormularioTrabajador vista;
    private IEmpleadoDAO modelo;

    public ControladorTrabajador(FormularioTrabajador vista, IEmpleadoDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonFormulario())){
            if(vista.getBotonFormulario().getText() == "Registrar"){
                Empleado empleado = new Empleado();
                String dni = vista.getTextoDNI().getText();
                String nombre = vista.getTextoNombre().getText();
                String apellido = vista.getTextoApellido().getText(); 
                String direccion = vista.getTextoDireccion().getText();             
                String usuario = vista.getTextoUsuario().getText();
                String contraseña = vista.getTextoContraseña().getText();
                Date fechIngreso = vista.getFechaIngreso().getDate();
                String cargo = String.valueOf(vista.getListadoCargo().getSelectedItem());
                
                empleado.setDNI(dni);
                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setDireccion(direccion);
                empleado.setUsuario(usuario);
                empleado.setContraseña(contraseña);
                empleado.setFechIngreso(fechIngreso);
                empleado.setCargo(cargo);
                
                boolean resultado = modelo.insertarEmpleado(empleado);
                
                if(resultado){
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                }
            }
            if(vista.getBotonFormulario().getText() == "Actualizar"){
                Empleado empleado = new Empleado();
                String dni = vista.getTextoDNI().getText();
                String nombre = vista.getTextoNombre().getText();
                String apellido = vista.getTextoApellido().getText(); 
                String direccion = vista.getTextoDireccion().getText();             
                String usuario = vista.getTextoUsuario().getText();
                String contraseña = vista.getTextoContraseña().getText();
                Date fechIngreso = vista.getFechaIngreso().getDate();
                String cargo = String.valueOf(vista.getListadoCargo().getSelectedItem());
                
                empleado.setDNI(dni);
                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setDireccion(direccion);
                empleado.setUsuario(usuario);
                empleado.setContraseña(contraseña);
                empleado.setFechIngreso(fechIngreso);
                empleado.setCargo(cargo);
                
                boolean resultado = modelo.actualizarEmpleado(empleado);
                
                if(resultado){
                    JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
                }
            }
        }
        
        if(evento.getSource().equals(vista.getBotonAtras())){
            vista.dispose();
            vista.getVentana().setVisible(true);
            vista.getVentana().setLocationRelativeTo(null);
        }
    }
    
    
}
