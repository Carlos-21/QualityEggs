/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.diseño.Ventas;

import java.util.ArrayList;
import modelo.dao.dato.Ventas.Tarifa;

/**
 *
 * @author CARLOS
 */
public interface ITarifaDAO {
    public abstract boolean insertarTarifa(Tarifa tarifa);
    public abstract boolean actualizarTarifa(Tarifa tarifa, int semana);
    public abstract boolean eliminarTarifa(int numeroSemana);
    public abstract ArrayList<Tarifa> listarTarifa(String busqueda, int categoria);
}
