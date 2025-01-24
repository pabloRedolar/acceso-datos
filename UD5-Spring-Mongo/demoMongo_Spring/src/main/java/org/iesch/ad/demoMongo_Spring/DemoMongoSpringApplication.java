package org.iesch.ad.demoMongo_Spring;

import org.iesch.ad.demoMongo_Spring.models.Trabajador;
import org.iesch.ad.demoMongo_Spring.repositories.TrabajadorRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class DemoMongoSpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoMongoSpringApplication.class, args);

        var repo = context.getBean(TrabajadorRepo.class);

        repo.deleteAll();

        List<Trabajador> trabajadores = List.of(
                new Trabajador(null, "Manuel", "Julve", "manuel@iesch.org", LocalDate.of(2005, 3, 12), 180),
                new Trabajador(null, "Juan", "Julve", "juan@iesch.org", LocalDate.of(2008, 3, 3), 170),
                new Trabajador(null, "Juan", "Julve", "remon@iesch.org", LocalDate.of(2007, 3, 23), 180),
                new Trabajador(null, "Toni", "Julve", "toni@iesch.org", LocalDate.of(2006, 3, 28), 170)
        );

        repo.saveAll(trabajadores);
//		repo.findAll().forEach(System.out::println);

//        System.out.println(repo.contarPorNombre("Manuel"));


        //Plantilla mongo

        var mongoTemplate = context.getBean(MongoTemplate.class);

        Query query = new Query();
        query.addCriteria(Criteria.where("nombre").is("Manuel"));

//        System.out.println("Trabajadores con nombre Manuel: " + mongoTemplate.count(query, Trabajador.class));

        Trabajador trabajador = new Trabajador(null, "Empleado6", "trabajador", "paco@iesch.org", LocalDate.of(1956, 11, 30), 180);
        mongoTemplate.save(trabajador);

        //Mostrar todos

        List<Trabajador> listaCompleta = mongoTemplate.findAll(Trabajador.class);

        listaCompleta.forEach(System.out::println);

        // Buscar por id:

        String id = "67881609d743ed1dd533febb";
//        System.out.println("-----------------------\n Buscando por id: " + mongoTemplate.findById(id, Trabajador.class));

        //Buscando por nombre
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("nombre").is("Juan"));

        //Busqueda con and
        System.out.println("\n-----------");
        Query query2 = new Query();
        query2.addCriteria(Criteria.where("nombre").is("Empleado6").and("email").is("paco@iesch.org"));

//        System.out.println(query2);

        //Busqueda con OR
        //Buscar los que midan 170

        Query query3 = new Query();

        query3.addCriteria(new Criteria().orOperator(Criteria.where("altura").is(170), Criteria.where("nombre").is("Juan")) );
        System.out.println("-------------------------------------");
        List<?> list = mongoTemplate.find(query3, Trabajador.class);
        list.forEach(System.out::println);

        // Expresiones regulares --> Buscamos la pipol que su nombre empiece por J

        Query query4 = new Query();
        query4.addCriteria(Criteria.where("nombre").regex("^J"));
        List<?> list1 = mongoTemplate.find(query4, Trabajador.class);

        System.out.println("--------------------------");
        list1.forEach(System.out::println);

    }
}
