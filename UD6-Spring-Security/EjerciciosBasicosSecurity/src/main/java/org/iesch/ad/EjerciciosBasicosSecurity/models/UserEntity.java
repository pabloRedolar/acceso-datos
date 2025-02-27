package org.iesch.ad.EjerciciosBasicosSecurity.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
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

    private LocalDateTime inicionSesiada;

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

    public UserEntity(Long id, String username, String password, Set<UserRole> roles, LocalDateTime creaccionUsuario, LocalDateTime inicionSesiada) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", creaccionUsuario=" + creaccionUsuario +
                ", inicionSesiada=" + inicionSesiada +
                '}';
    }
}
