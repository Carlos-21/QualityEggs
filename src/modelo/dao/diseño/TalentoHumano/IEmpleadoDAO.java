/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.diseño.TalentoHumano;

import java.util.ArrayList;
import modelo.dao.dato.TalentoHumano.Empleado;

/**
 *
 * @author CARLOS
 */
public interface IEmpleadoDAO {
    public abstract boolean insertarEmpleado(Empleado empleado);
    public abstract boolean actualizarEmpleado(Empleado empleado, String dni);
    public abstract boolean eliminarEmpleado(String dni);
    public abstract ArrayList<Empleado> listarEmpleado(String busqueda, int categoria);
}
