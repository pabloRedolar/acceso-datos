package org.iesch.ad.ProyectoConsultasAutomoviles.services;

import org.iesch.ad.ProyectoConsultasAutomoviles.model.Coche;
import org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO.CocheDTO;
import org.iesch.ad.ProyectoConsultasAutomoviles.repositories.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public class CocheService {
    @Autowired
    CocheRepository cocheRepository;

    public List<Object> getCochesConMenosRevisiones() {
        return cocheRepository.cochesConMenosRevisiones();
    }

    public List<Object> getCochesMatriculaYRevisiones() {
        return cocheRepository.cochesMatriculaRevisiones();
    }
}
