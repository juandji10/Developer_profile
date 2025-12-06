package com.developerprofile.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConfig {

    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (database == null) {
            String uri = System.getenv("MONGO_URI");
            if (uri == null || uri.isEmpty()) {
                throw new RuntimeException("Error: Variable de entorno MONGO_URI no configurada");
            }
            MongoClient client = MongoClients.create(uri);

            database = client.getDatabase("DataDeveloper"); 
        }
        return database;
    }
}
