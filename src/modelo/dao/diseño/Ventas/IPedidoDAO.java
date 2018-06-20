/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.diseño.Ventas;

import java.util.ArrayList;
import modelo.dao.dato.Ventas.Pedido;

/**
 *
 * @author CARLOS
 */
public interface IPedidoDAO {
    public abstract boolean insertarPedido(Pedido pedido);
    public abstract ArrayList<Pedido> listarPedido(String busqueda, int categoria);
    public abstract ArrayList<Pedido> listarPedidoPendiente(String busqueda, int categoria);
    public abstract ArrayList<Pedido> listarPedidoPagados(String busqueda, int categoria);
    public abstract boolean consultarAlmacen(int cantidad);
    public abstract boolean actualizarStock(int cantidad);
    public abstract double tarifaPaquetes();
    public abstract boolean cambiarEstado(String codigoPedido);
}
