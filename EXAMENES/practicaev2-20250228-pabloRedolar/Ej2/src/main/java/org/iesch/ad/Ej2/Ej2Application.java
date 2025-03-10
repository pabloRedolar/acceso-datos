package org.iesch.ad.Ej2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Ej2Application implements CommandLineRunner {

	private final MongoTemplate mongoTemplate;
	private final ObjectMapper objectMapper;

	// Inyectamos MongoTemplate y ObjectMapper
	public Ej2Application(MongoTemplate mongoTemplate, ObjectMapper objectMapper) {
		this.mongoTemplate = mongoTemplate;
		this.objectMapper = objectMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(Ej2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Ruta del archivo JSON (debe estar en src/main/resources)
		String filePath = "datosEj1.json";
		// Nombre de la colección de MongoDB
		String collectionName = "students";

		try {
			// Lee el archivo desde la carpeta "resources"
			ClassPathResource resource = new ClassPathResource(filePath);
			System.out.println("Buscando archivo en: " + resource.getURI());

			// Parsea el JSON a una lista de Document
			List<Document> documents = Arrays.asList(
					objectMapper.readValue(resource.getInputStream(), Document[].class)
			);

			// Obtiene la colección de MongoDB
			MongoCollection<Document> collection = mongoTemplate.getCollection(collectionName);

			// Inserta los documentos en la colección
			collection.insertMany(documents);

			System.out.println("Datos insertados correctamente en la colección: " + collectionName);
		} catch (IOException e) {
			System.err.println("Error al leer el archivo JSON: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error al insertar datos en MongoDB: " + e.getMessage());
			e.printStackTrace();
		}
	}
}