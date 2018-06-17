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
import modelo.dao.dato.Ventas.Tarifa;
import modelo.dao.diseño.Ventas.ITarifaDAO;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author CARLOS
 */
public class TarifaDAO implements ITarifaDAO{

    @Override
    public boolean insertarTarifa(Tarifa tarifa) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Tarifa").count();
        
        Document datoTarifa = new Document();     
        datoTarifa.append("NumeroSemana", (int)cantidadInicial+1);
        datoTarifa.append("PrecioUnitario", tarifa.getPrecioUnitario());
        datoTarifa.append("FechaInicio", tarifa.getFechaInicio());
        datoTarifa.append("FechaFin", tarifa.getFechaFin());        
        
        base.getCollection("Tarifa").insertOne(datoTarifa);
        
        long cantidadFinal = base.getCollection("Tarifa").count();
        
        if(cantidadInicial < cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean actualizarTarifa(Tarifa tarifa, int semana) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Tarifa").count();
        
        Bson filtro = new Document("NumeroSemana", semana);
        
        Document datoTarifa = new Document();     
        datoTarifa.append("NumeroSemana", tarifa.getNumeroSemana());
        datoTarifa.append("PrecioUnitario", tarifa.getPrecioUnitario());
        datoTarifa.append("FechaInicio", tarifa.getFechaInicio());
        datoTarifa.append("FechaFin", tarifa.getFechaFin());        
        
        base.getCollection("Tarifa").replaceOne(filtro, datoTarifa);
        
        long cantidadFinal = base.getCollection("Tarifa").count();
        
        if(cantidadInicial == cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean eliminarTarifa(int numeroSemana) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Tarifa").count();
        
        Bson filtro = new Document("NumeroSemana", numeroSemana);  
        
        base.getCollection("Tarifa").deleteOne(filtro);
        
        long cantidadFinal = base.getCollection("Tarifa").count();
        
        if(cantidadInicial > cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public ArrayList<Tarifa> listarTarifa(String busqueda, int categoria) {
        ArrayList<Tarifa> tarifas = new ArrayList<Tarifa>();
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        MongoCollection coleccion = base.getCollection("Tarifa");
        
        BasicDBObject filtro = new BasicDBObject();
        
        switch(categoria){
            case 1 : filtro = new BasicDBObject("NumeroSemana", new BasicDBObject("$regex", Integer.parseInt(busqueda)));   
                     break;
            case 2 : filtro = new BasicDBObject("PrecioUnitario", new BasicDBObject("$regex", Double.parseDouble(busqueda)));
                     break;
            case 3 : filtro = new BasicDBObject("FechaInicio", new BasicDBObject("$regex", busqueda));
                     break;   
            case 4 : filtro = new BasicDBObject("FechaInicio", new BasicDBObject("$regex", busqueda));
                     break;                
        }

        FindIterable<Document> documentos = coleccion.find(filtro); 
        
        for (Document doc : documentos) {
            Tarifa tarifa = new Tarifa();
            tarifa.setNumeroSemana(doc.getInteger("NumeroSemana"));
            tarifa.setPrecioUnitario(doc.getDouble("PrecioUnitario"));
            tarifa.setFechaInicio(doc.getDate("FechaInicio"));
            tarifa.setFechaFin(doc.getDate("FechaFin"));
            
            tarifas.add(tarifa);
        }
        
        return tarifas;
    }
    
}
