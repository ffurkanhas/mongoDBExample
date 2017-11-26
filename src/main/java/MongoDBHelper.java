import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.UnknownHostException;

public class MongoDBHelper {

    private MongoClient mongoClient;
    private DB database;

    public MongoDBHelper(String databaseName){
        connect();
        getClient();
        database = getDatabase(databaseName);
    }

    public void connect(){
        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public MongoClient getClient(){
        try {
            mongoClient = new MongoClient();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return mongoClient;
    }

    public DB getDatabase(String databaseName){
        return mongoClient.getDB(databaseName);
    }

    public DBCollection getDbCollection(String collectionName){
        return database.getCollection(collectionName);
    }

}
