package org.iesch.ad.EjerciciosBasicosSecurity.models.DTOs;

import org.iesch.ad.EjerciciosBasicosSecurity.models.UserRole;

import java.time.LocalDateTime;
import java.util.Set;

public class UserEntityDTO {

    private Long id;
    private String username;
    private Set<UserRole> roles;
    private LocalDateTime creaccionUsuario;
    private LocalDateTime inicionSesiada;

    public UserEntityDTO() {
    }

    public UserEntityDTO(Long id, String username, Set<UserRole> roles, LocalDateTime creaccionUsuario, LocalDateTime inicionSesiada) {
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.creaccionUsuario = creaccionUsuario;
        this.inicionSesiada = inicionSesiada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public LocalDateTime getCreaccionUsuario() {
        return creaccionUsuario;
    }

    public void setCreaccionUsuario(LocalDateTime creaccionUsuario) {
        this.creaccionUsuario = creaccionUsuario;
    }

    public LocalDateTime getInicionSesiada() {
        return inicionSesiada;
    }

    public void setInicionSesiada(LocalDateTime inicionSesiada) {
        this.inicionSesiada = inicionSesiada;
    }
}
