package org.iesch.ad.Ej1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.iesch.ad.Ej1.models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class Ej1Application implements CommandLineRunner {

    @Autowired
    MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Ej1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Convertir a JSON con formato

        // Imprimir JSON formateado


        estudiantesNombreInicialNotaMayor().forEach(estudiante -> {
            String jsonPretty;
            try {
                jsonPretty = objectMapper.writeValueAsString(estudiante);
                System.out.println(jsonPretty);

            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

    }


    public List<Estudiante> estudiantesNotaMayor90() {
        Query query = new Query(Criteria.where("courses.grades.grade").gt(93));

        return mongoTemplate.find(query, Estudiante.class);
    }

    public List<Estudiante> estudiantesActividadEspecifica() {
        Query query = new Query(Criteria.where("extracurriculars.activity").regex("Basketball"));

        return mongoTemplate.find(query, Estudiante.class);
    }

    public List<Estudiante> estudiantesCiudadEspecifica() {
        Query query = new Query(Criteria.where("address.city").is("Springfield").andOperator(Criteria.where("age").gt(20)));

        return mongoTemplate.find(query, Estudiante.class);
    }

    public List<Estudiante> estudiantesInscritosCurso() {
        Query query = new Query(Criteria.where("courses.courseId").regex("BIO101").andOperator(Criteria.where("courses.grades.grade").gt(85)));

        return mongoTemplate.find(query, Estudiante.class);
    }

    public List<Estudiante> estudiantesPorCiudadEdad() {
        Query query = new Query(Criteria.where("address.city").is("Springfield")
                .andOperator(Criteria.where("age").gt(20)
                        .andOperator(Criteria.where("extracurriculars.activity").regex("Basketball"))));

        return mongoTemplate.find(query, Estudiante.class);
    }

    public List<Estudiante> estudiantesNombreInicialNotaMayor() {
        Query query = new Query(Criteria.where("name").regex("^" + "D", "i").andOperator(Criteria.where("courses.grades.grade").gt(85)));

        return mongoTemplate.find(query, Estudiante.class);
    }


}
