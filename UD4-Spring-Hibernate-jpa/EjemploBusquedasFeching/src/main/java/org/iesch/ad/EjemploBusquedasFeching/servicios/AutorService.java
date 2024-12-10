package org.iesch.ad.EjemploBusquedasFeching.servicios;

import org.iesch.ad.EjemploBusquedasFeching.repositorios.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    public Object devuelveTodos() {
        return autorRepository.findAll();
    }
}
