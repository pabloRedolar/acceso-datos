package org.iesch.ad.Ej2.seguridad;

import org.iesch.ad.Ej2.filtro.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    JwtAutenticationEntryPoint jwtAutenticationEntryPoint;
    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Al usar JWT las csrf se pueden o deben deshabilitar por que al trabajar con tokens jwt no hay riesgos de ataque
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(authorizeRequests -> {
            authorizeRequests.requestMatchers("/api/auth/**").permitAll();
            authorizeRequests.requestMatchers("/web/**").permitAll();
            authorizeRequests.requestMatchers(HttpMethod.GET).permitAll();
            authorizeRequests.requestMatchers(HttpMethod.POST).authenticated();
            authorizeRequests.requestMatchers(HttpMethod.PUT).authenticated();
            authorizeRequests.requestMatchers(HttpMethod.DELETE).authenticated();
            authorizeRequests.anyRequest().authenticated();
        });

//               .httpBasic(Customizer.withDefaults());

        http.exceptionHandling(exception -> exception
                .authenticationEntryPoint(jwtAutenticationEntryPoint));


        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
