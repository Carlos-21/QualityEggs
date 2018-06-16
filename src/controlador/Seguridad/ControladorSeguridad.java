/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Seguridad;

import controlador.TalentoHumano.ControladorTalentoHumano;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.dao.dato.Empleado;
import modelo.dao.diseño.IEmpleadoDAO;
import modelo.factoria.FabricaDAO;
import vista.Seguridad.VentanaLogin;
import vista.TalentoHumano.VentanaPrincipal;

/**
 *
 * @author CARLOS
 */
public class ControladorSeguridad implements ActionListener{
    private VentanaLogin vista;
    private IEmpleadoDAO modelo;

    public ControladorSeguridad(VentanaLogin vista, IEmpleadoDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(vista.getBotonLogin()) || evento.getSource().equals(vista.getTextoContraseña())){
            int consulta = tipoEmpleado(vista.getTextoUsuario().getText(), String.valueOf(vista.getTextoContraseña().getPassword()));
            
            switch(consulta){
                case 0 :    JOptionPane.showMessageDialog(null, "Usuario no registrado.");
                            break;
                            
                case 1 :    JOptionPane.showMessageDialog(null, "Acceso concedido.");   
                            this.vista.dispose();
                            
                            VentanaPrincipal vista = new VentanaPrincipal();
                            IEmpleadoDAO modelo1 = FabricaDAO.instanciar().getEmpleadoDAO();
                            ControladorTalentoHumano controlador = new ControladorTalentoHumano(vista, modelo1);
                            
                            vista.setLogin(this.vista);
                            vista.setControlador(controlador);
                            vista.setVisible(true);
                            vista.setLocationRelativeTo(null);
                            break;
                            
                case 2 : JOptionPane.showMessageDialog(null, "Usuario no registrado.");
                         break;
                         
                case 3 : JOptionPane.showMessageDialog(null, "Usuario no registrado.");
                         break;
                         
            }
        }
        
        if(evento.getSource().equals(vista.getCheckMostrarContraseña())){
            if(vista.getCheckMostrarContraseña().isSelected()){
                vista.getTextoContraseña().setEchoChar((char)0);
            }
            else{
                vista.getTextoContraseña().setEchoChar('*');
            }
        }
    }
    
    private int tipoEmpleado(String usuario, String contraseña){
        ArrayList<Empleado> empleados = modelo.listarEmpleado("", 0);

        for(Empleado empleado : empleados){
            if(empleado.getUsuario().equals(usuario) && empleado.getContraseña().equals(contraseña)){
                if(empleado.getCargo().equals("Administrador")){
                    return 1;
                }
                
                if(empleado.getCargo().equals("Encargado de ventas")){
                    return 2;
                }
                
                if(empleado.getCargo().equals("Encargado de almacen")){
                    return 3;
                }
            }
        }
        
        return 0;
    }
}
