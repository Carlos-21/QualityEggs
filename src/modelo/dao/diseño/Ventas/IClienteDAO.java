/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.diseño.Ventas;

import java.util.ArrayList;
import modelo.dao.dato.Ventas.Cliente;

/**
 *
 * @author CARLOS
 */
public interface IClienteDAO {
    public abstract boolean insertarCliente(Cliente cliente);
    public abstract boolean actualizarCliente(Cliente cliente, String dni);
    public abstract boolean eliminarCliente(String dni);
    public abstract ArrayList<Cliente> listarCliente(String busqueda, int categoria);
}
