package com.vinni;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class ConexionBD {
    public static MongoClient connectBD(){
        String connectionString = "mongodb+srv://asanchez:tV94Ihbq2Ddw3pZw@vehiculosbd.vto72g7.mongodb.net/";
        return MongoClients.create(connectionString);
    }
    
}
