package org.example.DAO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.Model.Metadata;

import java.util.ArrayList;
import java.util.List;

public interface MongoFunctionsDAO {
    public ArrayList<String> getDatabases();
    public MongoDatabase useDatabase(String dbname);
    public void dropDatabase(String dbname);
    public void dropCollection(String collectionName, MongoDatabase dbObj);

    public void insertDocument(String collectionName, Metadata jsonObj, MongoDatabase dbObj) throws JsonProcessingException;
    public void updateDocument(String collectionName, String jsonQuery, String newJsonQuery, MongoDatabase dbObj);
    public void updateDocument(String collectionName, String attributePath, Object oldValue, Object newValue, MongoDatabase dbObj);

    public void deleteDocument(String jsonQuery, String collectionName, MongoDatabase dbObj);
    public void getAllDocuments(String collectionName, MongoDatabase dbObj) ;

    public void findOne(String jsonQuery, String collectionName, MongoDatabase dbObj);
    public List<Document> find(String jsonQuery, String collectionName, MongoDatabase dbObj);
    public Metadata find(String key, Object value, String collectionName, MongoDatabase dbObj) throws JsonProcessingException;

    public Metadata  findOne(String key, Object value, String collectionName, MongoDatabase dbObj) throws JsonProcessingException;
}
