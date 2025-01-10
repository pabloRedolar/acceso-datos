package org.iesch.ad.Ej2.services;

import org.iesch.ad.Ej2.exceptions.RepresentanteException;
import org.iesch.ad.Ej2.models.Representante;
import org.iesch.ad.Ej2.repositories.RepresentanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RepresentanteService {
    @Autowired
    RepresentanteRepository representanteRepository;

    public List<Representante> getRepresentantes() {
        return representanteRepository.findAll();
    }


    public Object getRepresentantePorId(Long id) {
        if (representanteRepository.existsById(id)) {
            return representanteRepository.findById(id);
        }
        throw new RepresentanteException("Representante no encontrado");
    }


    public Boolean postRepresentante(List<Representante> representantes) {
        representanteRepository.saveAll(representantes);

        //            throw new RepresentanteException("Representante no añadido");
//        return representanteRepository.existsById(representante.getId());
        return true;
    }


    public Boolean deleteRepresentante(Long id) {
        if (representanteRepository.existsById(id)) {
            representanteRepository.deleteById(id);
            return true;
        } else {
            throw new RepresentanteException("Representante no encontrado");
        }
    }


    public Object putRepresentante(Long id, Representante representante) {
        if (representanteRepository.existsById(id)) {
            representanteRepository.save(representante);

            return representanteRepository.findById(id);
        }
        throw new RepresentanteException("Representante no encontrado");

    }


    public Object getRepresentantesPorNombre(String nombre) {
        return representanteRepository.findByNombre(nombre);
    }
}
