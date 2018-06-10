/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author CARLOS
 */
public class DataBaseConexion {
    private static MongoClient cliente = null;    
    private static MongoDatabase baseDatos = null;      
    private final String host = "localhost";
    private final int puerto = 27017;
    private final String nombreBaseDatos = "QualityEggs";
    
    //Constructor
    private DataBaseConexion(){
        cliente = new MongoClient(host, puerto);
        baseDatos = cliente.getDatabase(nombreBaseDatos);
    }
    
    //Devuelve la base de datos
    public static MongoDatabase getBaseDatos(){
        if(cliente == null){
            new DataBaseConexion();
        }
        return baseDatos;
    }
}
