package org.iesch.ad.ejemploExcepciones.service;

import org.iesch.ad.ejemploExcepciones.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    List<Usuario> usuarioList;

    public List<Usuario> buscarTodo(){
        return usuarioList;
    }

    public Optional<Usuario> buscarPorId(long id){
        return usuarioList.stream().filter(usuario -> usuario.getId() == id).findFirst();

    }

}
