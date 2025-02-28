package org.iesch.ad.LoginYJWT.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
//Para actualizar el usuario al hacer cualquier accion que este anotada como tal
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER) //Para que carguen los roles al cargar el usuario
    @Enumerated(EnumType.STRING) //Para que guarde el nombre del enumerate en base datos
    private Set<UserRole> roles;

    @CreatedDate
    private LocalDateTime creaccionUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(userRole -> new SimpleGrantedAuthority("ROLE_" + userRole.name())).toList();
    }
}
