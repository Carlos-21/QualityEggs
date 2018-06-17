/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.diseño.TalentoHumano;

import java.util.ArrayList;
import modelo.dao.dato.TalentoHumano.Persona;

/**
 *
 * @author CARLOS
 */
public interface IPersonaDAO {
    public abstract boolean insertarPersona(Persona persona);
    public abstract boolean actualizarPersona(Persona persona);
    public abstract boolean eliminarPersona(String DNI);
    public abstract ArrayList<Persona> listarPersona(String busqueda, int categoria);
}
