package org.iesch.ad.demoMongo_Spring.repositories;

import org.iesch.ad.demoMongo_Spring.models.Trabajador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepo extends MongoRepository<Trabajador, String> {
    public static void main(String[] args) {

    }
}
