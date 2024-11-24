package com.ad.gestionDeUsuariosYContrasenyas.configuration;

import com.ad.gestionDeUsuariosYContrasenyas.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class UserConfiguration {

    @Bean
    public Map<Integer, User> usersMap() {
        Map<Integer, User> users = new HashMap<>();

        users.put(1, User.builder().id(1).email("user1@example.com").password("password1")
                .passwords(Arrays.asList("passwordA1", "passwordB1", "passwordC1")).build());

        users.put(2, User.builder().id(2).email("user2@example.com").password("password2")
                .passwords(Arrays.asList("passwordA2", "passwordB2", "passwordC2")).build());

        users.put(3, User.builder().id(3).email("user3@example.com").password("password3")
                .passwords(Arrays.asList("passwordA3", "passwordB3", "passwordC3")).build());

        users.put(4, User.builder().id(4).email("user4@example.com").password("password4")
                .passwords(Arrays.asList("passwordA4", "passwordB4", "passwordC4")).build());

        users.put(5, User.builder().id(5).email("user5@example.com").password("password5")
                .passwords(Arrays.asList("passwordA5", "passwordB5", "passwordC5")).build());

        return users;
    }
}