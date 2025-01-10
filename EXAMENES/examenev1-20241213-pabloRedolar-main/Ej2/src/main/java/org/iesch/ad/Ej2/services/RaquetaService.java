package org.iesch.ad.Ej2.services;

import org.iesch.ad.Ej2.exceptions.RaquetaException;
import org.iesch.ad.Ej2.models.Raqueta;
import org.iesch.ad.Ej2.repositories.RaquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaquetaService {
    @Autowired
    RaquetaRepository raquetaRepository;

    public List<Raqueta> getRaquetas() {
        return raquetaRepository.findAll();
    }


    public Object getRaquetasPorId(Long id) {
        return raquetaRepository.findById(id);
    }


    public Object postRaquetas(List<Raqueta> raquetas) {
        return raquetaRepository.saveAll(raquetas);
    }


    public Object putRaquetas(Long id, Raqueta raqueta) {

        if (raquetaRepository.existsById(id)) {
            raquetaRepository.save(raqueta);

            return raquetaRepository.findById(id);

        }
        throw new RaquetaException("Raqueta no encontrada");
    }


    public Object deleteRaquetas(Long id) {
        if (raquetaRepository.existsById(id)) {
            raquetaRepository.deleteById(id);
            return true;
        }
        throw new RaquetaException("Raqueta no encontrada");
    }


    public List<Raqueta> findRaquetaPorMarca(String marca) {
        return raquetaRepository.findAllByMarca(marca);
    }


    public Object getRepresentanteDeRaquetaPorId(Long id) {
//        return raquetaRepository.getRepresentanteDeRaquetaPorId(id);
       return raquetaRepository.sacarRepresentantePorIdRaqueta(id);
    }
}
