/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron.factoria;

import patron.dao.componente.PersonaDAO;
import patron.dao.diseño.IPersonaDAO;

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
}
