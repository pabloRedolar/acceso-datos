package org.iesch.ad.demosPendientesUD04.services;

import org.iesch.ad.demosPendientesUD04.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.OutputBin;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

}
