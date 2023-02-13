package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.example.DAO.MongoFunctionsDAO;
import org.example.DAO.MongoFunctionsDAOImpl;
import org.example.Database.DBconnection;
import org.example.Model.Metadata;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        String json1 =
                " { \"firstName\": \"Isuru\"," +
                    " \"lastName\": \"Nishadha\", " +
                    " \"signupDate\": \"2023.02.10\" ,"+
                    "\"userVerified\": true ,  " +
                    " \"metadata\" : {" +
                        "\"nic\": {" +
                            "\"verified\" :  true " +
                        " }, " +
                    "\"address\" : {" +
                            "\"verified\" :  false " +
                        " } " +
                    "}"+
                "}";

        String json2 = "{ \"name\": \"isuru\" }";
        String json3 = "{ \"name\": \"nish\" }";


        ObjectMapper mapper = new ObjectMapper();
        Metadata jsonObj = mapper.readValue(json1, Metadata.class);
        System.out.println(jsonObj);

        //Database connection
        DBconnection dbConObj = new DBconnection();
        MongoClient mongoClient = dbConObj.getDatabaseConnetionObj();
        MongoDatabase db = mongoClient.getDatabase("test");

        //using this object we can call the DAO methods
        MongoFunctionsDAO obj = new MongoFunctionsDAOImpl();
            }
}