/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.componente.Ventas;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import modelo.dao.Conexion.DataBaseConexion;
import modelo.dao.dato.Ventas.Pedido;
import modelo.dao.diseño.Ventas.IPedidoDAO;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author CARLOS
 */
public class PedidoDAO implements IPedidoDAO{

    @Override
    public boolean insertarPedido(Pedido pedido) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Pedido").count();
        
        Document datoPedido = new Document();
        datoPedido.append("Codigo", String.valueOf(cantidadInicial+1));
        datoPedido.append("DNICliente", pedido.getDniCliente());
        datoPedido.append("NombreCliente", pedido.getNombreCliente());
        datoPedido.append("FechaRegistro", pedido.getFechaRegistro());
        datoPedido.append("CantidadPaquetes", pedido.getCantidadPaquetes());
        datoPedido.append("ImporteTotal", pedido.getImporteTotal());
        datoPedido.append("Estado", "pendiente");
        
        base.getCollection("Pedido").insertOne(datoPedido);
        
        long cantidadFinal = base.getCollection("Pedido").count();
        
        if(cantidadInicial < cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean consultarAlmacen(int cantidad) {
        int stock = 0;
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        MongoCollection coleccion = base.getCollection("Produccion");

        FindIterable<Document> documentos = coleccion.find(); 
        
        for (Document doc : documentos) {
            stock += doc.getInteger("Stock");
        }
        
        if(cantidad <= stock){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean actualizarStock(int cantidad) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Produccion").count();
        
        MongoCollection coleccion = base.getCollection("Produccion");

        FindIterable<Document> documentos = coleccion.find(); 
        
        Bson filtro;
        BasicDBObject dato;
        int suma = 0;
        for (Document doc : documentos) {
            suma += doc.getInteger("Stock");
            
            filtro = new Document("Codigo", doc.getString("Codigo"));       
            if(suma <= cantidad){
                dato = new BasicDBObject("$set", new BasicDBObject("Stock", 0));
            }
            else{
                dato = new BasicDBObject("$set", new BasicDBObject("Stock", suma - cantidad));
                coleccion.updateOne(filtro, dato);
                return true;
            }
            coleccion.updateOne(filtro, dato);
        }
        
        long cantidadFinal = base.getCollection("Produccion").count();
        
        if(cantidadInicial == cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public double tarifaPaquetes() {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        MongoCollection coleccion = base.getCollection("Tarifa");
        
        BasicDBObject filtro = new BasicDBObject("NumeroSemana",-1);
        
        FindIterable<Document> documentos = coleccion.find().sort(filtro).limit(1);
        
        double tarifa = 0.0;
        for (Document doc : documentos) {
            tarifa = doc.getDouble("PrecioUnitario");
        }
        
        return tarifa;
    }

    @Override
    public ArrayList<Pedido> listarPedido(String busqueda, int categoria) {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        MongoCollection coleccion = base.getCollection("Pedido");
        
        BasicDBObject filtro = new BasicDBObject();
        
        switch(categoria){
            case 1 : filtro = new BasicDBObject("Codigo", new BasicDBObject("$regex", busqueda));   
                     break;
            case 2 : filtro = new BasicDBObject("NombreCliente", new BasicDBObject("$regex", busqueda));
                     break;
            case 3 : filtro = new BasicDBObject("FechaRegistro", new BasicDBObject("$regex", busqueda));
                     break;      
            case 4 : filtro = new BasicDBObject("ImporteTotal", new BasicDBObject("$regex", busqueda));
                     break; 
            case 5 : filtro = new BasicDBObject("Estado", new BasicDBObject("$regex", busqueda));
                     break;          
        }

        FindIterable<Document> documentos = coleccion.find(filtro); 
        
        for (Document doc : documentos) {
            Pedido pedido = new Pedido();
            pedido.setCodigoPedido(doc.getString("Codigo"));
            pedido.setDniCliente(doc.getString("DNICliente"));
            pedido.setNombreCliente(doc.getString("NombreCliente"));
            pedido.setFechaRegistro(doc.getDate("FechaRegistro"));
            pedido.setCantidadPaquetes(doc.getInteger("CantidadPaquetes"));
            pedido.setImporteTotal(doc.getDouble("ImporteTotal"));
            pedido.setEstado(doc.getString("Estado"));
            
            pedidos.add(pedido);
        }
        
        return pedidos;
    }

    @Override
    public ArrayList<Pedido> listarPedidoPendiente(String busqueda, int categoria) {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        MongoCollection coleccion = base.getCollection("Pedido");
        
        BasicDBObject filtro = new BasicDBObject();
        
        switch(categoria){
            case 1 : filtro = new BasicDBObject("Codigo", new BasicDBObject("$regex", busqueda));   
                     break;
            case 2 : filtro = new BasicDBObject("NombreCliente", new BasicDBObject("$regex", busqueda));
                     break;
            case 3 : filtro = new BasicDBObject("FechaRegistro", new BasicDBObject("$regex", busqueda));
                     break;      
            case 4 : filtro = new BasicDBObject("ImporteTotal", new BasicDBObject("$regex", busqueda));
                     break; 
            case 5 : filtro = new BasicDBObject("Estado", new BasicDBObject("$regex", busqueda));
                     break;          
        }
        
        BasicDBObject filtro2 = new BasicDBObject("Estado", "pendiente");
        FindIterable<Document> documentos = coleccion.find(filtro).filter(filtro2); 
        
        for (Document doc : documentos) {
            Pedido pedido = new Pedido();
            pedido.setCodigoPedido(doc.getString("Codigo"));
            pedido.setDniCliente(doc.getString("DNICliente"));
            pedido.setNombreCliente(doc.getString("NombreCliente"));
            pedido.setFechaRegistro(doc.getDate("FechaRegistro"));
            pedido.setCantidadPaquetes(doc.getInteger("CantidadPaquetes"));
            pedido.setImporteTotal(doc.getDouble("ImporteTotal"));
            pedido.setEstado(doc.getString("Estado"));
            
            pedidos.add(pedido);
        }
        
        return pedidos;
    }

    @Override
    public ArrayList<Pedido> listarPedidoPagados(String busqueda, int categoria) {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        MongoCollection coleccion = base.getCollection("Pedido");
        
        BasicDBObject filtro = new BasicDBObject();
        
        switch(categoria){
            case 1 : filtro = new BasicDBObject("Codigo", new BasicDBObject("$regex", busqueda));   
                     break;
            case 2 : filtro = new BasicDBObject("NombreCliente", new BasicDBObject("$regex", busqueda));
                     break;
            case 3 : filtro = new BasicDBObject("FechaRegistro", new BasicDBObject("$regex", busqueda));
                     break;      
            case 4 : filtro = new BasicDBObject("ImporteTotal", new BasicDBObject("$regex", busqueda));
                     break; 
            case 5 : filtro = new BasicDBObject("Estado", new BasicDBObject("$regex", busqueda));
                     break;          
        }
        
        BasicDBObject filtro2 = new BasicDBObject("Estado", "pagado");
        FindIterable<Document> documentos = coleccion.find(filtro).filter(filtro2); 
        
        for (Document doc : documentos) {
            Pedido pedido = new Pedido();
            pedido.setCodigoPedido(doc.getString("Codigo"));
            pedido.setDniCliente(doc.getString("DNICliente"));
            pedido.setNombreCliente(doc.getString("NombreCliente"));
            pedido.setFechaRegistro(doc.getDate("FechaRegistro"));
            pedido.setCantidadPaquetes(doc.getInteger("CantidadPaquetes"));
            pedido.setImporteTotal(doc.getDouble("ImporteTotal"));
            pedido.setEstado(doc.getString("Estado"));
            
            pedidos.add(pedido);
        }
        
        return pedidos;
    }

    @Override
    public boolean cambiarEstado(String codigoPedido) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        MongoCollection coleccion = base.getCollection("Pedido");
        
        long cantidadInicial = base.getCollection("Pedido").count();
        
        Bson filtro = new Document("Codigo", codigoPedido);
        BasicDBObject dato = new BasicDBObject("$set", new BasicDBObject("Estado", "entregado"));
        
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
