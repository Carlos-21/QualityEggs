/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.componente;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;
import modelo.dao.DataBaseConexion;
import modelo.dao.dato.Empleado;
import modelo.dao.dato.Persona;
import modelo.dao.diseño.IEmpleadoDAO;

/**
 *
 * @author CARLOS
 */
public class EmpleadoDAO implements IEmpleadoDAO{

    @Override
    public boolean insertarEmpleado(Empleado empleado) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Empleado").count();
        
        Document dato = new Document();
        dato.append("DNI", empleado.getDNI());
        dato.append("Usuario", empleado.getUsuario());
        dato.append("Contraseña", empleado.getContraseña());
        dato.append("Cargo", empleado.getCargo());
        dato.append("FechaIngreso", empleado.getFechIngreso());

        base.getCollection("Empleado").insertOne(dato);
        
        long cantidadFinal = base.getCollection("Empleado").count();
        
        if(cantidadInicial < cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean actualizarEmpleado(Empleado empleado) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Empleado").count();
        
        Bson filtro = new Document("DNI", empleado.getDNI()); 
        System.out.println("asf"+filtro);
        Document dato = new Document();
        dato.append("DNI", empleado.getDNI());
        dato.append("Usuario", empleado.getUsuario());
        dato.append("Contraseña", empleado.getContraseña());
        dato.append("Cargo", empleado.getCargo());
        dato.append("FechaIngreso", empleado.getFechIngreso());

        base.getCollection("Empleado").replaceOne(filtro, dato);
        
        long cantidadFinal = base.getCollection("Empleado").count();
        System.out.println("cat "+cantidadInicial+" "+cantidadFinal);
        if(cantidadInicial == cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(String usuario) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Empleado").count();
        
        Bson filtro = new Document("Usuario", usuario); 
        
        base.getCollection("Empleado").deleteOne(filtro);
        
        long cantidadFinal = base.getCollection("Empleado").count();
        
        if(cantidadInicial > cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public ArrayList<Empleado> listarEmpleado(String busqueda, int categoria) {
        PersonaDAO per = new PersonaDAO();
        ArrayList<Persona> personas =  per.listarPersona(busqueda, categoria);
        int i = 0;
        
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        MongoCollection coleccion = base.getCollection("Empleado");
        
        BasicDBObject filtro = new BasicDBObject();
        
        switch(categoria){
            case 1 : filtro = new BasicDBObject("DNI", new BasicDBObject("$regex", busqueda));   
                     break;
            case 2 : filtro = new BasicDBObject("Nombre", new BasicDBObject("$regex", busqueda));
                     break;                  
        }
  
        FindIterable<Document> documentos = coleccion.find(filtro); 
        for (Document doc : documentos) {
            Empleado empleado = new Empleado();
            empleado.setDNI(doc.getString("DNI"));
            empleado.setUsuario(doc.getString("Usuario"));
            empleado.setContraseña(doc.getString("Contraseña"));
            empleado.setCargo(doc.getString("Cargo"));
            empleado.setFechIngreso(doc.getDate("FechaIngreso"));
            
            for (Persona persona : personas){
                if(persona.getDNI().equals(empleado.getDNI())){
                    empleado.setNombre(persona.getNombre());
                    empleado.setApellido(persona.getApellido());
                    empleado.setDireccion(persona.getDireccion());
                }
            }
          
            empleados.add(empleado);
            i++;
        }
        
        return empleados;
    }
    
}
