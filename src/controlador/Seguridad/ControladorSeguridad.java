/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Seguridad;

import controlador.Logistica.ControladorLogistica;
import controlador.TalentoHumano.ControladorTalentoHumano;
import controlador.Ventas.ControladorVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.dao.dato.TalentoHumano.Empleado;
import modelo.dao.diseño.Logistica.IProduccionDAO;
import modelo.dao.diseño.Ventas.IClienteDAO;
import modelo.dao.diseño.TalentoHumano.IEmpleadoDAO;
import modelo.dao.diseño.Ventas.IPagoDAO;
import modelo.dao.diseño.Ventas.IPedidoDAO;
import modelo.dao.diseño.Ventas.ITarifaDAO;
import modelo.factoria.FabricaDAO;
import vista.Seguridad.VentanaLogin;
import vista.TalentoHumano.VentanaPrincipal;
import vista.Logistica.VentanaPrincipalProduccion;
import vista.SistemaVentas.VentanaPrincipalVentas;

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
                            
                            VentanaPrincipal vista1 = new VentanaPrincipal();
                            
                            IEmpleadoDAO modelo1 = FabricaDAO.instanciar().getEmpleadoDAO();
                            
                            ControladorTalentoHumano controlador = new ControladorTalentoHumano(vista1, modelo1);
                            
                            vista1.setLogin(this.vista);
                            vista1.setControlador(controlador);
                            vista1.setVisible(true);
                            vista1.setLocationRelativeTo(null);
                            break;
                            
                case 2 :    JOptionPane.showMessageDialog(null, "Acceso concedido.");   
                            this.vista.dispose();
                            
                            VentanaPrincipalVentas vista2 = new VentanaPrincipalVentas();
                            
                            IClienteDAO modelo2 = FabricaDAO.instanciar().getClienteDAO();
                            ITarifaDAO modelo3 = FabricaDAO.instanciar().getTarifaDAO();
                            IPedidoDAO modelo4 = FabricaDAO.instanciar().getPedidoDAO();
                            IPagoDAO modelo5 = FabricaDAO.instanciar().getPagoDAO();
                            
                            ControladorVentas controlador2 = new ControladorVentas(vista2, modelo2, modelo3, modelo4, modelo5);
                            
                            vista2.setLogin(this.vista);
                            vista2.setControlador(controlador2);
                            vista2.setVisible(true);
                            vista2.setLocationRelativeTo(null);
                            break;
                         
                case 3 :    JOptionPane.showMessageDialog(null, "Acceso concedido.");   
                            this.vista.dispose();
                            
                            VentanaPrincipalProduccion vista3 = new VentanaPrincipalProduccion();
                            
                            IProduccionDAO modelo6 = FabricaDAO.instanciar().getProduccionDAO();
                            IPedidoDAO modelo7 = FabricaDAO.instanciar().getPedidoDAO();
                            
                            ControladorLogistica controlador3 = new ControladorLogistica(vista3, modelo6, modelo7);
                            
                            vista3.setLogin(this.vista);
                            vista3.setControlador(controlador3);
                            vista3.setVisible(true);
                            vista3.setLocationRelativeTo(null);
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
        
        if(evento.getSource().equals(vista.getBotonSalir())){
            System.exit(0);
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
                
                if(empleado.getCargo().equals("Encargado de almacén")){
                    return 3;
                }
            }
        }
        
        return 0;
    }
}
