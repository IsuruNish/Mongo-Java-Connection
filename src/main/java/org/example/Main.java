package org.example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.DAO.MongoFunctionsDAO;
import org.example.DAO.MongoFunctionsDAOImpl;
import org.example.Database.DBconnection;


public class Main {
    public static void main(String[] args) {

        String json = "{ \"name\": \"isuru\", \"age\": 43, \"courses\": {\"cname\": \"dsa\", \"credits\":3   } }";
        String djson = "{ \"name\": \"isuru\" }";
        String njson = "{ \"name\": \"nish\" }";


        //Database connection
        DBconnection dbConObj = new DBconnection();
        MongoClient mongoClient = dbConObj.getDatabaseConnetionObj();
        MongoDatabase db = mongoClient.getDatabase("zzz");

        //using this object we can call the DAO methods
        MongoFunctionsDAO obj = new MongoFunctionsDAOImpl();

        obj.getDatabases();
        obj.insertDocument("zzz",json, db);
//        obj.deleteDocument(djson, "TestCol", db);
//        obj.dropCollection("uni work", db);
//        MongoCollection<Document> collection= db.getCollection("test");
//        Document doc =new Document("name","Isuru").append("age", "23");

        obj.findOne(djson, "zzz",db);
//        obj.updateDocument("zzz", djson, njson,db );

//        obj.findALL(djson, "zzz", db);

//        obj.findOne("age",23, "zzz",db);

    }
}