/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.factoria;

import modelo.dao.componente.EmpleadoDAO;
import modelo.dao.componente.PersonaDAO;
import modelo.dao.diseño.IEmpleadoDAO;
import modelo.dao.diseño.IPersonaDAO;

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
}
