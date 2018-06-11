/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.componente;

import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import modelo.dao.dato.Persona;
import org.bson.Document;
import org.bson.conversions.Bson;
import modelo.dao.DataBaseConexion;
import modelo.dao.diseño.IPersonaDAO;

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
    public ArrayList<Persona> listarPersona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
