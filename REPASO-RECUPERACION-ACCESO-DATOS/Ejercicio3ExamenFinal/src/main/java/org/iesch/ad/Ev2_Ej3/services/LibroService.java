package org.iesch.ad.Ev2_Ej3.services;

import org.iesch.ad.Ev2_Ej3.models.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired
    MongoTemplate mongoTemplate;

    public Object crearLibro(Libro libro) {
        return mongoTemplate.save(libro);
    }
}
