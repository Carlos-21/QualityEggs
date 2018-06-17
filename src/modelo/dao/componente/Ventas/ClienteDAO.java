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
import modelo.dao.dato.Ventas.Cliente;
import org.bson.Document;
import org.bson.conversions.Bson;
import modelo.dao.Conexion.DataBaseConexion;
import modelo.dao.diseño.Ventas.IClienteDAO;

/**
 *
 * @author CARLOS
 */
public class ClienteDAO implements IClienteDAO{

    @Override
    public boolean insertarCliente(Cliente cliente) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Cliente").count();
        
        Document datoCliente = new Document();
        datoCliente.append("RUC", cliente.getRUC());
        datoCliente.append("RazonSocial", cliente.getRazonSocial());
        datoCliente.append("Distrito", cliente.getDistrito());
        datoCliente.append("Telefono", cliente.getTelefono());
        
        Document datoPersona = new Document();
        datoPersona.append("DNI", cliente.getDNI());
        datoPersona.append("Nombre", cliente.getNombre());
        datoPersona.append("Apellido", cliente.getApellido());
        datoPersona.append("Direccion", cliente.getDireccion());
        datoPersona.append("Cliente", datoCliente);        
        
        base.getCollection("Cliente").insertOne(datoPersona);
        
        long cantidadFinal = base.getCollection("Cliente").count();
        
        if(cantidadInicial < cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean actualizarCliente(Cliente cliente, String dni) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Cliente").count();
        
        Bson filtro = new Document("DNI", dni); 
        
        Document datoCliente = new Document();
        datoCliente.append("RUC", cliente.getRUC());
        datoCliente.append("RazonSocial", cliente.getRazonSocial());
        datoCliente.append("Distrito", cliente.getDistrito());
        datoCliente.append("Telefono", cliente.getTelefono());
        
        Document datoPersona = new Document();
        datoPersona.append("DNI", cliente.getDNI());
        datoPersona.append("Nombre", cliente.getNombre());
        datoPersona.append("Apellido", cliente.getApellido());
        datoPersona.append("Direccion", cliente.getDireccion());
        datoPersona.append("Cliente", datoCliente);        

        base.getCollection("Cliente").replaceOne(filtro, datoPersona);
        
        long cantidadFinal = base.getCollection("Cliente").count();
        
        if(cantidadInicial == cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean eliminarCliente(String dni) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Cliente").count();
        
        Bson filtro = new Document("DNI", dni);  
        
        base.getCollection("Cliente").deleteOne(filtro);
        
        long cantidadFinal = base.getCollection("Cliente").count();
        
        if(cantidadInicial > cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public ArrayList<Cliente> listarCliente(String busqueda, int categoria) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        MongoCollection coleccion = base.getCollection("Cliente");
        
        BasicDBObject filtro = new BasicDBObject();
        
        switch(categoria){
            case 1 : filtro = new BasicDBObject("DNI", new BasicDBObject("$regex", busqueda));   
                     break;
            case 2 : filtro = new BasicDBObject("Nombre", new BasicDBObject("$regex", busqueda));
                     break;
            case 3 : filtro = new BasicDBObject("Cliente.RazonSocial", new BasicDBObject("$regex", busqueda));
                     break;          
        }

        FindIterable<Document> documentos = coleccion.find(filtro); 
        
        for (Document doc : documentos) {
            Cliente cliente = new Cliente();
            cliente.setDNI(doc.getString("DNI"));
            cliente.setNombre(doc.getString("Nombre"));
            cliente.setApellido(doc.getString("Apellido"));
            cliente.setDireccion(doc.getString("Direccion"));           
            
            Document consumidor = (Document) doc.get("Cliente");         
            cliente.setRUC(consumidor.getString("RUC"));
            cliente.setRazonSocial(consumidor.getString("RazonSocial"));
             cliente.setDistrito(consumidor.getString("Distrito"));
            cliente.setTelefono(consumidor.getString("Telefono"));           
            
            clientes.add(cliente);
        }
        
        return clientes;
    }
    
}
