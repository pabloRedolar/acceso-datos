package org.iesch.ad.EjJPA02.services;

import org.iesch.ad.EjJPA02.repositories.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CocheService {
    @Autowired
    CocheRepository cocheRepository;

    public Object getCochesMenosRevs() {
        return cocheRepository.findTopByOrderByRevisionesAsc();
    }
}
