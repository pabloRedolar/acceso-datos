package org.iesch.ad.Ej2.services;

import org.iesch.ad.Ej2.models.Persona;
import org.iesch.ad.Ej2.models.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PersonasService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Object personas() {
        return mongoTemplate.findAll(Persona.class);
    }

    public Object personasPorId(String id) {
        return mongoTemplate.findById(id, Persona.class);
    }

    public Object annadirPersonas(Persona persona) {

        persona.setPassword(passwordEncoder.encode(persona.getPassword()));

        return mongoTemplate.save(persona);
    }

    public Object actualizarPersonaPorId(String id, Persona persona) {

        if (mongoTemplate.exists(Query.query(Criteria.where("id").is(id)), Persona.class)) {
            persona.setId(id);
            return mongoTemplate.save(persona);

        }
        return false;

    }

    public Object borrarPersona(String id) {
        return mongoTemplate.findAndRemove(Query.query(Criteria.where("id").is(id)), Persona.class);
    }

    public List<Vehiculo> vehiculosPersonaPorId(String id) {

        Persona persona = mongoTemplate.findById(id, Persona.class);

        if (persona != null) {
            return persona.getVehiculos();
        } else throw new UsernameNotFoundException("El usuario no exisite");
    }

    // Perdirle a la ia que me diga si hay alguna manera mas optima
    public Object crearVehiculoPersonaPorId(String id, Vehiculo vehiculo) {

        List<Persona> personas = mongoTemplate.findAll(Persona.class);

        List<String> matriculas = new ArrayList<>();

        personas.forEach(persona1 -> persona1.getVehiculos().forEach(vehiculo1 ->
                matriculas.add(vehiculo1.getMatricula())));

        if (!matriculas.contains(vehiculo.getMatricula())) {
            Persona persona = mongoTemplate.findById(id, Persona.class);

            if (persona != null) {
                List<Vehiculo> vehiculos = persona.getVehiculos();

                vehiculos.add(vehiculo);
                persona.setVehiculos(vehiculos);

                return mongoTemplate.save(persona);

            } else throw new UsernameNotFoundException("El usuario no existe");

        } else return null;

    }

    public Boolean eliminarVechiculoDePersonaPorMatriculaId(String id, String matricula) {

        Persona persona = mongoTemplate.findById(id, Persona.class);
        if (persona != null) {

            persona.getVehiculos().removeIf(vehiculo -> vehiculo.getMatricula().equals(matricula));

            mongoTemplate.save(persona);

            return true;
        }

        return false;

    }

    public Object sacarPotenciaFiscal(String matricula) {

        Persona persona = mongoTemplate.findOne(Query.query(Criteria.where("vehiculos.matricula").is(matricula)), Persona.class);
        if (persona != null) {

//            persona.getVehiculos().forEach(vehiculo -> {
//
//                if (vehiculo.getMatricula().equals(matricula)) {
//                    return Math.pow(((double) vehiculo.getCilindrada() / vehiculo.getNumero_cilindros()), 0.6) * 0.08 * vehiculo.getNumero_cilindros();
//                }
//
//            });

            Vehiculo vehiculo = persona.getVehiculos().stream().filter(vehiculo1 -> vehiculo1.getMatricula().equals(matricula)).findFirst().orElseThrow(() -> new RuntimeException("aaaa"));

            double potencia = Math.pow(((double) vehiculo.getCilindrada() / vehiculo.getNumero_cilindros()), 0.6) * 0.08 * vehiculo.getNumero_cilindros();

            HashMap<String, String> a = new HashMap<>();

            a.put("matricula", vehiculo.getMatricula());
            a.put("potencia fiscal", String.valueOf(potencia));

            return a;

        }

        return null;

    }
}
