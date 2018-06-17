/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.factoria;

import modelo.dao.componente.Logistica.ProduccionDAO;
import modelo.dao.componente.Ventas.ClienteDAO;
import modelo.dao.componente.TalentoHumano.EmpleadoDAO;
import modelo.dao.componente.TalentoHumano.PersonaDAO;
import modelo.dao.componente.Ventas.PagoDAO;
import modelo.dao.componente.Ventas.PedidoDAO;
import modelo.dao.componente.Ventas.TarifaDAO;
import modelo.dao.diseño.Logistica.IProduccionDAO;
import modelo.dao.diseño.Ventas.IClienteDAO;
import modelo.dao.diseño.TalentoHumano.IEmpleadoDAO;
import modelo.dao.diseño.TalentoHumano.IPersonaDAO;
import modelo.dao.diseño.Ventas.IPagoDAO;
import modelo.dao.diseño.Ventas.IPedidoDAO;
import modelo.dao.diseño.Ventas.ITarifaDAO;

/**
 *
 * @author CARLOS
 */
public class FabricaDAO {
    private static FabricaDAO fabricaDAO;
    
    static{
        fabricaDAO = new FabricaDAO();
    }
    
    public static FabricaDAO instanciar(){
        return fabricaDAO;
    }
    
    public IPersonaDAO getPersonaDAO(){
        return new PersonaDAO();
    }
    
    public IEmpleadoDAO getEmpleadoDAO(){
        return new EmpleadoDAO();
    }
    
    public IClienteDAO getClienteDAO(){
        return new ClienteDAO();
    }
    
    public IProduccionDAO getProduccionDAO(){
        return new ProduccionDAO();
    }
    
    public ITarifaDAO getTarifaDAO(){
        return new TarifaDAO();
    }
    
    public IPedidoDAO getPedidoDAO(){
        return new PedidoDAO();
    }
    
    public IPagoDAO getPagoDAO(){
        return new PagoDAO();
    }
}
