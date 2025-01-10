package org.iesch.ad.Ej2.services;

import org.iesch.ad.Ej2.models.Tenista;
import org.iesch.ad.Ej2.repositories.TenistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenistaService {
    @Autowired
    TenistaRepository tenistaRepository;

    public Object getTenistas() {
        return tenistaRepository.findAll();
    }


    public Object getTenistasPorId(Long id) {
        return tenistaRepository.findById(id);
    }


    public Object postTenista(List<Tenista> tenistas) {
        return tenistaRepository.saveAll(tenistas);
    }


    public Object putTenistaPorId(Long id, Tenista tenista) {
        if (tenistaRepository.existsById(id)) {
            tenistaRepository.save(tenista);
            return true;
        }
        return false;

    }


    public Object deleteTenistaById(Long id) {
        if (tenistaRepository.existsById(id)) {
            tenistaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
