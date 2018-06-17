/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.diseño.Ventas;

import modelo.dao.dato.Ventas.Pago;

/**
 *
 * @author CARLOS
 */
public interface IPagoDAO {
    public abstract boolean insertarPago(Pago pago);
    public abstract boolean cambiarEstado(String codigoPedido);
}
