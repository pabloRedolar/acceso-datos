package com.ad.gestionDeUsuariosYContrasenyas.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode
public class User {

    int id;
    String email;
    String password;
    @Builder.Default
    List<String> passwords = new LinkedList<>();
    @Builder.Default
    LocalDate passwordValidity = LocalDate.now().plusMonths(6);
}