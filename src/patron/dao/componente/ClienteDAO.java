/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron.dao.componente;

import com.mongodb.client.MongoDatabase;
import dominio.Cliente;
import org.bson.Document;
import org.bson.conversions.Bson;
import patron.dao.DataBaseConexion;
import patron.dao.diseño.IClienteDAO;

/**
 *
 * @author CARLOS
 */
public class ClienteDAO implements IClienteDAO{

    @Override
    public boolean insertarCliente(Cliente cliente) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Cliente").count();
        
        Document dato = new Document();
        dato.append("RUC", cliente.getRUC());
        dato.append("RazonSocial", cliente.getRazonSocial());
        dato.append("Telefono", cliente.getTelefono());
        dato.append("Distrito", cliente.getDistrito());

        base.getCollection("Cliente").insertOne(dato);
        
        long cantidadFinal = base.getCollection("Cliente").count();
        
        if(cantidadInicial < cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Cliente").count();
        
        Bson filtro = new Document("RUC", cliente.getRUC()); 
        
        Document dato = new Document();
        dato.append("RUC", cliente.getRUC());
        dato.append("RazonSocial", cliente.getRazonSocial());
        dato.append("Telefono", cliente.getTelefono());
        dato.append("Distrito", cliente.getDistrito());

        base.getCollection("Cliente").replaceOne(filtro, dato);
        
        long cantidadFinal = base.getCollection("Cliente").count();
        
        if(cantidadInicial == cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean eliminarCliente(String RUC) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Cliente").count();
        
        Bson filtro = new Document("RUC", RUC); 
        
        base.getCollection("Cliente").deleteOne(filtro);
        
        long cantidadFinal = base.getCollection("Cliente").count();
        
        if(cantidadInicial > cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }
    
}
