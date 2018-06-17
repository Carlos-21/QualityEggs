/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.componente.Ventas;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import modelo.dao.Conexion.DataBaseConexion;
import modelo.dao.dato.Ventas.Pago;
import modelo.dao.diseño.Ventas.IPagoDAO;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author CARLOS
 */
public class PagoDAO implements IPagoDAO{

    @Override
    public boolean insertarPago(Pago pago) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Pago").count();
        
        Document datoPago = new Document();
        datoPago.append("DNICliente", pago.getDniCliente());
        datoPago.append("NombreCliente", pago.getNombreCliente());
        datoPago.append("CodigoPedido", pago.getCodigoPedido());       
        datoPago.append("ImporteTotal", pago.getImporteTotal());
        
        base.getCollection("Pago").insertOne(datoPago);
        
        long cantidadFinal = base.getCollection("Pago").count();
        
        if(cantidadInicial < cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean cambiarEstado(String codigoPedido) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        MongoCollection coleccion = base.getCollection("Pedido");
        
        long cantidadInicial = base.getCollection("Pedido").count();
        
        Bson filtro = new Document("Codigo", codigoPedido);
        BasicDBObject dato = new BasicDBObject("$set", new BasicDBObject("Estado", "pagado"));
        
        coleccion.updateOne(filtro, dato);
        
        long cantidadFinal = base.getCollection("Pedido").count();
        
        if(cantidadInicial == cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }
    
}
