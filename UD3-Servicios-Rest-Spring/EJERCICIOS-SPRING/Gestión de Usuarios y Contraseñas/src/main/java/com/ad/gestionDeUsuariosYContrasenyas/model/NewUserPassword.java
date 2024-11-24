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
public class NewUserPassword {

    String email;
    String password;
    String newPassword;
}