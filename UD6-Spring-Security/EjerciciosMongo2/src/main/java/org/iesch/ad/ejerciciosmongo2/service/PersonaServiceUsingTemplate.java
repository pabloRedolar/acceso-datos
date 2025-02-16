package org.iesch.ad.ejerciciosmongo2.service;

import org.iesch.ad.ejerciciosmongo2.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceUsingTemplate {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Persona> buscarPorApellidoUltimaLetra(String letra) {
        Query query = new Query(Criteria.where("apellido").regex(letra + "$" , "i"));

        return mongoTemplate.find(query, Persona.class);
    }

    public List<Persona> buscarPorAnnosYCiudadConXLetras(int annos, int cantidadLetras) {
        Query query = new Query(Criteria.where("edad").gte(annos).and("ciudad").regex("^.{" + cantidadLetras + "}$"));

        return mongoTemplate.find(query, Persona.class);
    }

    public List<Persona> buscarPorPalabraEnCalle(String palabra) {
        Query query = new Query(Criteria.where("direccion.calle").regex(palabra));

        return mongoTemplate.find(query, Persona.class);
    }

    public List<Persona> buscarPorInteresSubcadena(String cadena) {
        Query query = new Query(Criteria.where("intereses").regex(cadena, "i"));

        return mongoTemplate.find(query, Persona.class);
    }

    public List<Persona> buscarPorNombreContieneCadena(String cadena) {
        Query query = new Query(Criteria.where("nombre").regex(cadena, "i"));

        return mongoTemplate.find(query, Persona.class);

    }
}
