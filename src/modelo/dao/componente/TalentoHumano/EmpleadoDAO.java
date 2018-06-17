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
import org.bson.Document;
import org.bson.conversions.Bson;
import modelo.dao.Conexion.DataBaseConexion;
import modelo.dao.dato.TalentoHumano.Empleado;
import modelo.dao.diseño.TalentoHumano.IEmpleadoDAO;

/**
 *
 * @author CARLOS
 */
public class EmpleadoDAO implements IEmpleadoDAO{

    @Override
    public boolean insertarEmpleado(Empleado empleado) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Empleado").count();
        
        Document datoEmpleado = new Document();     
        datoEmpleado.append("Usuario", empleado.getUsuario());
        datoEmpleado.append("Contraseña", empleado.getContraseña());
        datoEmpleado.append("Cargo", empleado.getCargo());
        datoEmpleado.append("FechaIngreso", empleado.getFechIngreso());
        
        Document datoPersona = new Document();
        datoPersona.append("DNI", empleado.getDNI());
        datoPersona.append("Nombre", empleado.getNombre());
        datoPersona.append("Apellido", empleado.getApellido());
        datoPersona.append("Direccion", empleado.getDireccion());
        datoPersona.append("Trabajador", datoEmpleado);
        
        
        base.getCollection("Empleado").insertOne(datoPersona);
        
        long cantidadFinal = base.getCollection("Empleado").count();
        
        if(cantidadInicial < cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean actualizarEmpleado(Empleado empleado, String dni) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Empleado").count();
        
        Bson filtro = new Document("DNI", dni); 

        Document datoEmpleado = new Document();     
        datoEmpleado.append("Usuario", empleado.getUsuario());
        datoEmpleado.append("Contraseña", empleado.getContraseña());
        datoEmpleado.append("Cargo", empleado.getCargo());
        datoEmpleado.append("FechaIngreso", empleado.getFechIngreso());
        
        Document datoPersona = new Document();
        datoPersona.append("DNI", empleado.getDNI());
        datoPersona.append("Nombre", empleado.getNombre());
        datoPersona.append("Apellido", empleado.getApellido());
        datoPersona.append("Direccion", empleado.getDireccion());
        datoPersona.append("Trabajador", datoEmpleado);

        base.getCollection("Empleado").replaceOne(filtro, datoPersona);
        
        long cantidadFinal = base.getCollection("Empleado").count();
        
        if(cantidadInicial == cantidadFinal){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(String dni) {
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        
        long cantidadInicial = base.getCollection("Empleado").count();
        
        Bson filtro = new Document("DNI", dni);  
        
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
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        MongoCollection coleccion = base.getCollection("Empleado");
        
        BasicDBObject filtro = new BasicDBObject();
        
        switch(categoria){
            case 1 : filtro = new BasicDBObject("DNI", new BasicDBObject("$regex", busqueda));   
                     break;
            case 2 : filtro = new BasicDBObject("Nombre", new BasicDBObject("$regex", busqueda));
                     break;
            case 3 : filtro = new BasicDBObject("Trabajador.Cargo", new BasicDBObject("$regex", busqueda));
                     break;          
        }

        FindIterable<Document> documentos = coleccion.find(filtro); 
        
        for (Document doc : documentos) {
            Empleado empleado = new Empleado();
            empleado.setDNI(doc.getString("DNI"));
            empleado.setNombre(doc.getString("Nombre"));
            empleado.setApellido(doc.getString("Apellido"));
            empleado.setDireccion(doc.getString("Direccion"));           
            
            Document trabajadador = (Document) doc.get("Trabajador");
            empleado.setUsuario(trabajadador.getString("Usuario"));
            empleado.setContraseña(trabajadador.getString("Contraseña"));
            empleado.setCargo(trabajadador.getString("Cargo"));
            empleado.setFechIngreso(trabajadador.getDate("FechaIngreso"));
            
            empleados.add(empleado);
        }
        
        return empleados;
    }
    
}
