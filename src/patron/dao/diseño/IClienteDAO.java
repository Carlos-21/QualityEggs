/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron.dao.diseño;

import dominio.Cliente;

/**
 *
 * @author CARLOS
 */
public interface IClienteDAO {
    public abstract boolean insertarCliente(Cliente cliente);
    public abstract boolean actualizarCliente(Cliente cliente);
    public abstract boolean eliminarCliente(String RUC);
}
