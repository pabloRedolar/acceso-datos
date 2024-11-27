package org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.services;

import org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CocheService {
    @Autowired
    CocheRepository cocheRepository;

    public Object getAll() {
        return cocheRepository.findAll();
    }

    public Object getAllById(Long id) {
        return cocheRepository.findByClienteId(id);
    }
}

