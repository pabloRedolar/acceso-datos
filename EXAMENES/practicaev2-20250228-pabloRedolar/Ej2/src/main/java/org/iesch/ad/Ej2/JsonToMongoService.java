package org.iesch.ad.Ej2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class JsonToMongoService {

	private final MongoTemplate mongoTemplate;
	private final ObjectMapper objectMapper;

	public JsonToMongoService(MongoTemplate mongoTemplate, ObjectMapper objectMapper) {
		this.mongoTemplate = mongoTemplate;
		this.objectMapper = objectMapper;
	}

	public void insertFromJsonFile(String filePath, String collectionName) throws IOException {
		// Lee el archivo desde la carpeta "resources"
		ClassPathResource resource = new ClassPathResource(filePath);

		// Parsea el JSON a una lista de Document (documentos genéricos de MongoDB)
		List<Document> documents = Arrays.asList(
				objectMapper.readValue(resource.getInputStream(), Document[].class)
		);

		// Obtiene la colección de MongoDB
		MongoCollection<Document> collection = mongoTemplate.getCollection(collectionName);

		// Inserta los documentos en la colección
		collection.insertMany(documents);
	}
}
