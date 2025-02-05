package org.iesch.ad.demoFiltros_ModeloUsuario.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorizationManager -> authorizationManager
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/public/**")
                .permitAll()
                .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults()); //Todo lo q no se haga en la lambda pasa por aqui

        return httpSecurity.build();
    }

}
