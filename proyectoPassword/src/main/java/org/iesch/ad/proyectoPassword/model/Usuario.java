package org.iesch.ad.proyectoPassword.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class Usuario {
    private String username;
    private String password;
    private ArrayList<String> oldPassword;
    private LocalDateTime validoHasta;
//    @Value("${rest.password}")
//    private String salt = "a36sd";

    public Usuario(){
        this.oldPassword = new ArrayList<>(3);
    }

    public Usuario(String username, String password) {
        this.oldPassword = new ArrayList<>(3);
        this.validoHasta = LocalDateTime.now().plusDays(180);
        this.username = username;
        this.password = DigestUtils.md5DigestAsHex((password+"a36sf").getBytes());
    }
}
