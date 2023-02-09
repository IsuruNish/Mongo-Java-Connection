package org.example.DAO;

import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

public interface MongoFunctionsDAO {

    public ArrayList<String> getDatabases();
    public MongoDatabase useDatabase(String dbname);
    public void dropDatabase(String dbname);
    public void dropCollection(String collectionName, MongoDatabase dbObj);

    public void insertDocument(String collectionName, String json, MongoDatabase dbObj);
    public void updateDocument(String collectionName, String jsonQuery, String newJsonQuery, MongoDatabase dbObj);
    public void deleteDocument(String jsonQuery, String collectionName, MongoDatabase dbObj);
    public void getAllDocuments(String collectionName, MongoDatabase dbObj) ;
    public void findOne(String jsonQuery, String collectionName, MongoDatabase dbObj);

    //additional functions
    public void findOne(String key, Object value, String collectionName, MongoDatabase dbObj);
}
