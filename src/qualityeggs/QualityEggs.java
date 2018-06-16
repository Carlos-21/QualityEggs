/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qualityeggs;

import controlador.Seguridad.ControladorSeguridad;
import modelo.dao.diseño.IEmpleadoDAO;
import modelo.factoria.FabricaDAO;
import vista.Seguridad.VentanaLogin;

/**
 *
 * @author CARLOS
 */
public class QualityEggs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        } 
        
        VentanaLogin vista = new VentanaLogin();
        
        IEmpleadoDAO modelo = FabricaDAO.instanciar().getEmpleadoDAO();
        
        ControladorSeguridad controlador = new ControladorSeguridad(vista, modelo);
        
        vista.setControlador(controlador);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
}
