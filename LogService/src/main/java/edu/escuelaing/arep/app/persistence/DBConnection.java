package edu.escuelaing.arep.app.persistence;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.escuelaing.arep.app.model.Message;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;

public class DBConnection {
    MongoClientURI uri;
    MongoClient mongoClient;
    public DBConnection() {
        uri = new MongoClientURI("mongodb://Carlos:1234@192.168.99.100:27017/?serverSelectionTimeoutMS=5000&connectTimeoutMS=10000&authSource=Arep&authMechanism=SCRAM-SHA-1&3t.uriVersion=3");
        mongoClient = new MongoClient(uri);
    }

    public void insertMessage(Message message){
        mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("Arep");
        MongoCollection<Document> collection =database.getCollection("Message");
        Document document=new Document();
        document.put("info",message.getInfo());
        document.put("date",message.getDate());
        collection.insertOne(document);
    }

    public ArrayList<Message> getMessages() {
        MongoDatabase database = mongoClient.getDatabase("Arep");
        MongoCollection<Document> collection = database.getCollection("Message");
        FindIterable findIterable = collection.find();
        ArrayList<Document> documents = new ArrayList<Document>();
        ArrayList<Message> messages = new ArrayList<Message>();
        findIterable.into(documents);
        for (Document doc : documents) {
            if (doc.get("info") != null && doc.get("date") != null) {
                messages.add(new Message((String) doc.get("info"), (Date) doc.get("date")));
            }
        }
        return messages;
    }
}
