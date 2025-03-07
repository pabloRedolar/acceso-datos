package org.iesch.ad.demoFiltros_ModeloUsuario.modelo;

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

//No la llamamos User porque ya existe una clase con ese nombre en Spring Security
@Entity
@EntityListeners(AuditingEntityListener.class)  //Para que se actualicen las fechas de creación y modificación
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
    private String username;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)  //Para que se carguen los roles al cargar el usuario
    @Enumerated(EnumType.STRING)    //Para que guarde el nombre del enum en la base de datos
    private Set<UserRole> roles;

    @CreatedDate
    private LocalDateTime createdAt;

    private LocalDateTime lastLogin;


    //private LocalDateTime lastPasswordChangeAt = LocalDateTime.now();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.name()))
                .toList();
    }



    //public boolean isAdmin() {
//    return roles.contains(UserRole.ADMIN);
//}
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", createdAt=" + createdAt +
                ", lastLogin=" + lastLogin +
                '}';
    }
}

