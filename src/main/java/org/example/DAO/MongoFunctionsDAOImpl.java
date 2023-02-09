package org.example.DAO;

import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.example.DAO.MongoFunctionsDAO;
import org.example.Database.DBconnection;

import java.util.ArrayList;

public class MongoFunctionsDAOImpl implements MongoFunctionsDAO {

    DBconnection dbConObj = new DBconnection();
    MongoClient mongoClient = dbConObj.getDatabaseConnetionObj();

    @Override
    public ArrayList<String> getDatabases() {
        ArrayList<String> databases = new ArrayList<>();
        MongoCursor<String> dbsCursor = mongoClient.listDatabaseNames().iterator();
        while(dbsCursor.hasNext()) {
            databases.add(String.valueOf(dbsCursor.next()));
        }
        return databases.isEmpty() ? null : databases;
    }

    @Override
    public MongoDatabase useDatabase(String dbname) {
        MongoDatabase db = mongoClient.getDatabase(dbname);
        return db;
    }

    @Override
    public void dropDatabase(String dbname) {
        mongoClient.dropDatabase(dbname);
    }

    public void dropCollection(String collectionName, MongoDatabase dbObj) {
        dbObj.getCollection(collectionName).drop();
    }

    @Override
    public void insertDocument(String collectionName, String json, MongoDatabase dbObj) {
        Document doc = Document.parse(json);
        MongoCollection<Document> collection = dbObj.getCollection(collectionName);
        collection.insertOne(doc);
    }

    public void updateDocument(String collectionName, String jsonQuery, String newJsonQuery, MongoDatabase dbObj){
        Document doc = Document.parse(jsonQuery);
        Document newDoc = Document.parse(newJsonQuery);

        MongoCollection<Document> collection = dbObj.getCollection(collectionName);

        Document result = (Document) collection.find(doc).first();
        if (result == null){
            System.out.println("No user found");
            return;
        }
        Bson updateOperation = new Document("$set", newDoc);
        collection.updateOne(result, updateOperation);
        System.out.println("User updated");
    }

    @Override
    public void deleteDocument(String jsonQuery, String collectionName, MongoDatabase dbObj) {
        Document doc = Document.parse(jsonQuery);
        MongoCollection<Document> collection = dbObj.getCollection(collectionName);
        DeleteResult result = collection.deleteOne(doc);

        if (result.getDeletedCount() == 0) {
            System.out.println("No records found");
        } else {
            System.out.println("Record deleted");
        }
    }

    @Override
    public void getAllDocuments(String collectionName, MongoDatabase dbObj)  {
        MongoCollection<Document> collection = dbObj.getCollection(collectionName);

        for (Document doc : collection.find()){
            System.out.println(doc.toJson());
        }
    }

    @Override
    public void findOne(String jsonQuery, String collectionName, MongoDatabase dbObj) {
        Document doc = Document.parse(jsonQuery);
        MongoCollection<Document> collection = dbObj.getCollection(collectionName);
        Document result = (Document) collection.find(doc).first();
        System.out.println(result);
    }

    @Override
    public void findOne(String key, Object value, String collectionName, MongoDatabase dbObj) {
        MongoCollection<Document> collection = dbObj.getCollection(collectionName);
        Document result = (Document) collection.find(new Document(key, value)).first();
        System.out.println(result);
    }
}
