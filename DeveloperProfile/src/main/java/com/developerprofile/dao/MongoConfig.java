package com.developerprofile.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConfig {

    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (database == null) {
            String uri = "mongodb+srv://camiloramirezg_db_user:4kMrRgUtaLgEhoZS@cluster0.xgodlkb.mongodb.net/";
            MongoClient client = MongoClients.create(uri);

            database = client.getDatabase("DataDeveloper"); 
        }
        return database;
    }
}
