/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.dato.Ventas.Cliente;
import modelo.dao.diseño.Ventas.IClienteDAO;
import vista.SistemaVentas.FormularioCliente;

/**
 *
 * @author CARLOS
 */
public class ControladorCliente implements ActionListener{
    private FormularioCliente vista;
    private IClienteDAO modelo;

    public ControladorCliente(FormularioCliente vista, IClienteDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonFormulario())){
            if(vista.getBotonFormulario().getText().equals("Registrar")){
                String dni = vista.getTextoDNI().getText();
                String nombre = vista.getTextoNombre().getText();
                String apellido = vista.getTextoApellido().getText(); 
                String direccion = vista.getTextoDireccion().getText();             
                String distrito = String.valueOf(vista.getListadoDistrito().getSelectedItem());
                String telefono = vista.getTextoTelefono().getText();
                String RUC = vista.getTextoRUC().getText();
                String razonSocial = vista.getTextoRazonSocial().getText();
                
                Cliente cliente = new Cliente();
                cliente.setDNI(dni);
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setDireccion(direccion);
                cliente.setDistrito(distrito);
                cliente.setTelefono(telefono);
                cliente.setRUC(RUC);
                cliente.setRazonSocial(razonSocial);
                
                boolean resultado = modelo.insertarCliente(cliente);
                
                if(resultado){
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                }
            }
            if(vista.getBotonFormulario().getText().equals("Actualizar")){
                String dni = vista.getTextoDNI().getText();
                String nombre = vista.getTextoNombre().getText();
                String apellido = vista.getTextoApellido().getText(); 
                String direccion = vista.getTextoDireccion().getText();             
                String distrito = String.valueOf(vista.getListadoDistrito().getSelectedItem());
                String telefono = vista.getTextoTelefono().getText();
                String RUC = vista.getTextoRUC().getText();
                String razonSocial = vista.getTextoRazonSocial().getText();
                
                Cliente cliente = new Cliente();
                cliente.setDNI(dni);
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setDireccion(direccion);
                cliente.setDistrito(distrito);
                cliente.setTelefono(telefono);
                cliente.setRUC(RUC);
                cliente.setRazonSocial(razonSocial);
                
                boolean resultado = modelo.actualizarCliente(cliente, vista.getVentana().getClientes().get(vista.getVentana().getFilaCliente()).getDNI());
                
                if(resultado){
                    JOptionPane.showMessageDialog(null, "Actualización exitosa");
                }
            }
        }
        
        if(evento.getSource().equals(vista.getBotonAtras())){
            vista.dispose();
            
            vista.getVentana().repaint();
            vista.getVentana().setVisible(true);
            vista.getVentana().setLocationRelativeTo(null);
        }
        
        if(evento.getSource().equals(vista.getBotonSalir())){            
            System.exit(0);
        }
    }
    
    
}
