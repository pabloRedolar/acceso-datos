package org.iesch.ad.EjerciciosBasicosSecurity.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    @CreatedDate
    private LocalDateTime creaccionUsuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.name())).toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public UserEntity() {
    }

    public UserEntity(Long id, String username, String password, Set<UserRole> roles, LocalDateTime creaccionUsuario) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.creaccionUsuario = creaccionUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRoles() {
        return roles;
    }

    public void setUserRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public LocalDateTime getCreaccionUsuario() {
        return creaccionUsuario;
    }

    public void setCreaccionUsuario(LocalDateTime creaccionUsuario) {
        this.creaccionUsuario = creaccionUsuario;
    }
}
