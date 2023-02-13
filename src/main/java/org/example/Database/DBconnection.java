package org.example.Database;

import com.mongodb.MongoClient;

public class DBconnection {
    private static MongoClient mongoClient;
    private String host = "localhost";
    private int port = 27017;

    public DBconnection() {
        mongoClient = new MongoClient( host , port );
    }

    public MongoClient getDatabaseConnetionObj(){
        if(mongoClient == null) mongoClient = new MongoClient();
        return mongoClient;
    }
}




