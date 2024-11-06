package org.iesch.ad.proyectoPassword.service;

import org.iesch.ad.proyectoPassword.exceptions.PasswordNotStrongException;
import org.iesch.ad.proyectoPassword.model.Usuario;
import org.iesch.ad.proyectoPassword.model.usuarioDTO.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    List<Usuario> usuarios;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public LocalDateTime addUsuario(UsuarioDTO usuarioDTO) {
        if (compruebaContrasenna(usuarioDTO.getPassword())) {
            Usuario usuario = new Usuario(usuarioDTO.getUsername(), usuarioDTO.getPassword());
            usuarios.add(usuario);
            return usuario.getValidoHasta();
        } else {
            throw new PasswordNotStrongException("La contraseña no es compleja");
        }
    }

    private boolean compruebaContrasenna(String password) {
        return password.length() > 8 && password.matches(".*[A-Za-z].*");
    }

    public boolean login(UsuarioDTO usuarioDTO) {
        String hashPass = DigestUtils.md5DigestAsHex((usuarioDTO.getPassword() + "a36sf").getBytes());
        usuarios.stream().anyMatch(usuario -> usuario.getUsername().equals(usuarioDTO.getUsername().equals(usuario.getUsername()) && usuario.getPassword().equals(hashPass)));
        return false;

    }
}
