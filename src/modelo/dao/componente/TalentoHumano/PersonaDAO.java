/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.componente.TalentoHumano;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import modelo.dao.dato.TalentoHumano.Persona;
import org.bson.Document;
import org.bson.conversions.Bson;
import modelo.dao.Conexion.DataBaseConexion;
import modelo.dao.diseño.TalentoHumano.IPersonaDAO;

/**
 *
 * @author CARLOS
 */
public class PersonaDAO implements IPersonaDAO {

    @Override
    public boolean insertarPersona(Persona persona) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Persona").count();
        
        Document dato = new Document();
        dato.append("DNI", persona.getDNI());
        dato.append("Nombre", persona.getNombre());
        dato.append("Apellido", persona.getApellido());
        dato.append("Direccion", persona.getDireccion());

        base.getCollection("Persona").insertOne(dato);
        
        long cantidadFinal = base.getCollection("Persona").count();
        
        if(cantidadInicial < cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean actualizarPersona(Persona persona) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Persona").count();
        
        Bson filtro = new Document("DNI", persona.getDNI()); 
        
        Document dato = new Document();
        dato.append("DNI", persona.getDNI());
        dato.append("Nombre", persona.getNombre());
        dato.append("Apellido", persona.getApellido());
        dato.append("Direccion", persona.getDireccion());

        base.getCollection("Persona").replaceOne(filtro, dato);
        
        long cantidadFinal = base.getCollection("Persona").count();
        
        if(cantidadInicial == cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean eliminarPersona(String DNI) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Persona").count();
        
        Bson filtro = new Document("DNI", DNI); 
        
        base.getCollection("Persona").deleteOne(filtro);
        
        long cantidadFinal = base.getCollection("Persona").count();
        
        if(cantidadInicial > cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public ArrayList<Persona> listarPersona(String busqueda, int categoria) {
        ArrayList<Persona> personas = new ArrayList<Persona>();
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        MongoCollection coleccion = base.getCollection("Persona");
        
        BasicDBObject filtro = new BasicDBObject();
        
        switch(categoria){
            case 1 : filtro = new BasicDBObject("DNI", new BasicDBObject("$regex", busqueda));   
                     break;
            case 2 : filtro = new BasicDBObject("Nombre", new BasicDBObject("$regex", busqueda));
                     break;                  
        }

        FindIterable<Document> documentos = coleccion.find(filtro);
        for (Document doc : documentos) {
            Persona persona = new Persona();   
            persona.setDNI(doc.getString("DNI"));
            persona.setNombre(doc.getString("Nombre"));
            persona.setApellido(doc.getString("Apellido"));
            persona.setDireccion(doc.getString("Direccion"));
            personas.add(persona);
        }
        return personas;
    }

}
