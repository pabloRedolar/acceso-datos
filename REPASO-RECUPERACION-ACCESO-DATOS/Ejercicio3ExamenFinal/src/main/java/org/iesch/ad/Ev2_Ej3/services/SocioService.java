package org.iesch.ad.Ev2_Ej3.services;

import org.iesch.ad.Ev2_Ej3.models.Libro;
import org.iesch.ad.Ev2_Ej3.models.Prestamo;
import org.iesch.ad.Ev2_Ej3.models.Socio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SocioService {

    @Autowired
    MongoTemplate mongoTemplate;


    public Object crearSocio(Socio socio) {
        return mongoTemplate.save(socio);
    }

    public Boolean prestarLibro(String dni, String isbn) {

        Socio socioBD = mongoTemplate.findOne(Query.query(Criteria.where("dni").is(dni)), Socio.class);
        if (socioBD == null) return false;

        List<Socio> socios = mongoTemplate.findAll(Socio.class);

        Libro libro = mongoTemplate.findOne(Query.query(Criteria.where("isbn").is(isbn)), Libro.class);
        if (libro == null) return false;

        if (socios.stream().anyMatch(socio ->
                socio.getPrestamos().stream().anyMatch(prestamo ->
                        prestamo.getIdLibro().equals(libro.getId())))) {
            return false;
        } else {
            Prestamo prestamo = new Prestamo(libro.getId(), LocalDate.now(), LocalDate.now().plusMonths(1));
            socioBD.getPrestamos().add(prestamo);
            mongoTemplate.save(socioBD);
            return true;
        }

    }
}
