package org.iesch.ad.EjemploBusquedasFeching.servicios;

import jakarta.transaction.Transactional;
import org.iesch.ad.EjemploBusquedasFeching.model.Autor;
import org.iesch.ad.EjemploBusquedasFeching.model.Libro;
import org.iesch.ad.EjemploBusquedasFeching.repositorios.AutorRepository;
import org.iesch.ad.EjemploBusquedasFeching.repositorios.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    LibroRepository libroRepository;
    @Autowired
    AutorRepository autorRepository;


    public void crearDatos() {
        Autor autor = new Autor();
        autor.setNombre("Sheakespeare");
        autorRepository.save(autor);

        Libro libro1 = new Libro();
        libro1.setAutor(autor);
        libro1.setTitulo("La cenicienta");
        libroRepository.save(libro1);

        Libro libro2 = new Libro();
        libro2.setAutor(autor);
        libro2.setTitulo("La rosa negra");
        libroRepository.save(libro2);

        Libro libro3 = new Libro();
        libro3.setAutor(autor);
        libro3.setTitulo("La vida y la muerte");
        libroRepository.save(libro3);

    }


    @Transactional
    public void testLazy() {
        System.out.println("Mostrar tos libros");
        libroRepository.findAll().forEach(libro -> {
            System.out.println("Titulo del libro: " + libro.getTitulo());

            try {
                System.out.println("Me duelmo mimimimimim");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Autor: " + libro.getAutor().getNombre());
        });
    }
}
