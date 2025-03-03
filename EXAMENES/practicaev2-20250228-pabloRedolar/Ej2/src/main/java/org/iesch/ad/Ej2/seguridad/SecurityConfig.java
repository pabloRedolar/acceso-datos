package org.iesch.ad.Ej2.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/public/**").permitAll()
                                .requestMatchers(HttpMethod.DELETE).authenticated()
                                .requestMatchers(HttpMethod.POST).authenticated()
                                .requestMatchers(HttpMethod.PUT).authenticated()
                                .requestMatchers(HttpMethod.GET).permitAll()
                                .anyRequest().authenticated())
                .httpBasic(sec -> sec.authenticationEntryPoint(customBasicAuthenticationEntryPoint));//Todo lo que no esté dentro de lambda x defecto.
            return http.build();
    }

}
