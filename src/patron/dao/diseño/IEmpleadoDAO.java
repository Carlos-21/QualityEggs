/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron.dao.diseño;

import patron.dao.dato.Empleado;

/**
 *
 * @author CARLOS
 */
public interface IEmpleadoDAO {
    public abstract boolean insertarEmpleado(Empleado empleado);
    public abstract boolean actualizarEmpleado(Empleado empleado);
    public abstract boolean eliminarEmpleado(String usuario);
}
