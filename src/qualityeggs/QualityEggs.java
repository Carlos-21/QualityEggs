/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qualityeggs;


import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;


/**
 *
 * @author CARLOS
 */
public class QualityEggs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MongoClient mongoClient =  new MongoClient(new ServerAddress("localhost", 27017));
        MongoDatabase db = mongoClient.getDatabase("test");
    }
    
}
