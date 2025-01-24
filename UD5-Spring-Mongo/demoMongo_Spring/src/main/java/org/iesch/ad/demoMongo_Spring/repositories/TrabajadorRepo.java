package org.iesch.ad.demoMongo_Spring.repositories;

import org.iesch.ad.demoMongo_Spring.models.Trabajador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepo extends MongoRepository<Trabajador, String> {

    @Query(value = "{nombre: ?0}", count = true)
    public Long contarPorNombre(String nombre);

}
