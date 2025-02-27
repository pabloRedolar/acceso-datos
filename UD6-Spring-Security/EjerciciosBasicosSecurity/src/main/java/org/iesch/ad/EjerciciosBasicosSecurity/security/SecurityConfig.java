package org.iesch.ad.EjerciciosBasicosSecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationManager -> authorizationManager
                                .requestMatchers("/user/**").permitAll()
                                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.GET).permitAll()
//                .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
//                                .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
//                .requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
                                .anyRequest().authenticated()
                ).httpBasic(sec -> sec.authenticationEntryPoint(customBasicAuthenticationEntryPoint)); //To lo q no se haga en la lambda pasa por aqui

//        httpSecurity.exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAutenticationEntryPoint));

        return httpSecurity.build();
    }

}
