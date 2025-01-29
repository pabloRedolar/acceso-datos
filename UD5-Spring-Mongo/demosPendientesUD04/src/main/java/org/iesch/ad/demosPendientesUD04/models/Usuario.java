package org.iesch.ad.demosPendientesUD04.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    private String username;

    @NotNull
    @Size(min = 5, max = 100)
    private String password;

    @NotBlank
    @Size(min = 5, max = 100)
    private String passwordConfirm;

    @Email
    @NotNull
    private String email;

    public Usuario() {
    }

    public Usuario(Long id, String username, String password, String passwordConfirm, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Size(min = 1, max = 50) String getUsername() {
        return username;
    }

    public void setUsername(@NotNull @Size(min = 1, max = 50) String username) {
        this.username = username;
    }

    public @NotNull @Size(min = 1, max = 100) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @Size(min = 1, max = 100) String password) {
        this.password = password;
    }

    public @NotBlank String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(@NotBlank String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public @Email @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotNull String email) {
        this.email = email;
    }
}
