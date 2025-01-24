import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        // Conectar a mongo

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("miBaseDatos");
        MongoCollection<Document> collection = database.getCollection("miColeccion");

        Document document = new Document("nombre", "Juan")
                .append("edad", 30)
                .append("ciudad", "Madrid");

//        collection.insertOne(document);


        // Update uno
        collection.updateOne(new Document("nombre", "Juan"),
                new Document("$set",
                        new Document("nombre", "Pepe")
                                .append("edad", 21)));

        // Borrar uno

        collection.deleteOne(new Document("nombre", "Pepe"));

        // Listar
        for (Document document1 : collection.find()) {
            System.out.println(document1);
        }

        mongoClient.close();
    }
}
