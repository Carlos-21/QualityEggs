/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.diseño.Logistica;

import java.util.ArrayList;
import modelo.dao.dato.Logistica.Produccion;

/**
 *
 * @author CARLOS
 */
public interface IProduccionDAO {
    public abstract boolean insertarProduccion(Produccion produccion);
    public abstract boolean actualizarProduccion(Produccion produccion, String codigo);
    public abstract boolean eliminarProduccion(String codigo);
    public abstract ArrayList<Produccion> listarProduccion(String busqueda, int categoria);
}
