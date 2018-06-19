/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import controlador.TalentoHumano.ControladorTalentoHumano;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.dao.componente.Ventas.PedidoDAO;
import modelo.dao.diseño.TalentoHumano.IEmpleadoDAO;
import modelo.factoria.FabricaDAO;
import vista.TalentoHumano.VentanaPrincipal;

/**
 *
 * @author CARLOS
 */
public class pruebaTrabajador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VentanaPrincipal vista = new VentanaPrincipal();
        
        IEmpleadoDAO modelo = FabricaDAO.instanciar().getEmpleadoDAO();
        
        ControladorTalentoHumano controlador = new ControladorTalentoHumano(vista, modelo);
        
        vista.setControlador(controlador);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        Date d = new Date();
//        System.out.println("as : "+d);
//        System.out.println("Fecha : "+formato.format(d));
//        
//        PedidoDAO pedido = new PedidoDAO();
//        System.out.println("Tarifa : " + pedido.tarifaPaquetes());
    }
    
}
