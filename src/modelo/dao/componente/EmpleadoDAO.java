/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.componente;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;
import modelo.dao.DataBaseConexion;
import modelo.dao.dato.Empleado;
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
        dato.append("Usuario", empleado.getUsuario());
        dato.append("Contraseña", empleado.getContraseña());
        dato.append("Cargo", empleado.getContraseña());
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
        
        Bson filtro = new Document("Usuario", empleado.getUsuario()); 
        
        Document dato = new Document();
        dato.append("Usuario", empleado.getUsuario());
        dato.append("Contraseña", empleado.getContraseña());
        dato.append("Cargo", empleado.getContraseña());
        dato.append("FechaIngreso", empleado.getFechIngreso());

        base.getCollection("Empleado").replaceOne(filtro, dato);
        
        long cantidadFinal = base.getCollection("Empleado").count();
        
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
    public ArrayList<Empleado> listarEmpleado() {
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        MongoDatabase base = DataBaseConexion.getBaseDatos();
        MongoCollection coleccion = base.getCollection("Empleado");
        
        FindIterable<Document> documentos = coleccion.find(); 
        for (Document doc : documentos) {
            Empleado empleado = new Empleado();
            empleado.setUsuario(doc.getString("Usuario"));
            empleado.setContraseña(doc.getString("Contraseña"));
            empleado.setCargo(doc.getString("Cargo"));
            empleado.setFechIngreso(doc.getDate("FechaIngreso"));
            empleados.add(empleado);
        }
        return empleados;
    }
    
}
