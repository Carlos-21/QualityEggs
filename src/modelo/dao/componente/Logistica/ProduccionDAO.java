/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.componente.Logistica;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import modelo.dao.Conexion.DataBaseConexion;
import modelo.dao.dato.Logistica.Produccion;
import modelo.dao.diseño.Logistica.IProduccionDAO;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author CARLOS
 */
public class ProduccionDAO implements IProduccionDAO{

    @Override
    public boolean insertarProduccion(Produccion produccion) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Produccion").count();
        
        Document dato = new Document();
        dato.append("Codigo", produccion.getCodigo());
        dato.append("NombreAlmacen", produccion.getNombreAlmacen());
        dato.append("FechaIngreso", produccion.getFechaIngreso());
        dato.append("Peso", produccion.getPeso());
        dato.append("Stock", produccion.getStock());

        base.getCollection("Produccion").insertOne(dato);
        
        long cantidadFinal = base.getCollection("Produccion").count();
        
        if(cantidadInicial < cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean actualizarProduccion(Produccion produccion, String codigo) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Produccion").count();
        
        Bson filtro = new Document("Codigo", codigo);
        
        Document dato = new Document();
        dato.append("Codigo", produccion.getCodigo());
        dato.append("NombreAlmacen", produccion.getNombreAlmacen());
        dato.append("FechaIngreso", produccion.getFechaIngreso());
        dato.append("Peso", produccion.getPeso());
        dato.append("Stock", produccion.getStock());

        base.getCollection("Produccion").replaceOne(filtro, dato);
        
        long cantidadFinal = base.getCollection("Produccion").count();
        
        if(cantidadInicial == cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean eliminarProduccion(String codigo) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Produccion").count();
        
        Bson filtro = new Document("Codigo", codigo); 
        
        base.getCollection("Produccion").deleteOne(filtro);
        
        long cantidadFinal = base.getCollection("Produccion").count();
        
        if(cantidadInicial > cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public ArrayList<Produccion> listarProduccion(String busqueda, int categoria) {
        ArrayList<Produccion> producciones = new ArrayList<Produccion>();
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        MongoCollection coleccion = base.getCollection("Produccion");
        
        BasicDBObject filtro = new BasicDBObject();
        
        switch(categoria){
            case 1 : filtro = new BasicDBObject("Codigo", new BasicDBObject("$regex", busqueda));   
                     break;
            case 2 : filtro = new BasicDBObject("NombreAlmacen", new BasicDBObject("$regex", busqueda));
                     break;
            case 3 : filtro = new BasicDBObject("FechaIngreso", new BasicDBObject("$regex", busqueda));
                     break;          
            case 4 : filtro = new BasicDBObject("Peso", new BasicDBObject("$regex", Double.parseDouble(busqueda)));
                     break;          
            case 5 : filtro = new BasicDBObject("Stock", new BasicDBObject("$regex", Integer.parseInt(busqueda)));
                     break;          
        }

        FindIterable<Document> documentos = coleccion.find(filtro); 
        
        for (Document doc : documentos) {
            Produccion produccion = new Produccion();
            produccion.setCodigo(doc.getString("Codigo"));
            produccion.setNombreAlmacen(doc.getString("NombreAlmacen"));
            produccion.setFechaIngreso(doc.getDate("FechaIngreso"));
            produccion.setPeso(doc.getDouble("Peso"));
            produccion.setStock(doc.getInteger("Stock"));
            
            producciones.add(produccion);
        }
        
        return producciones;
    }
    
}
