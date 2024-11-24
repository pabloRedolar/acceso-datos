package com.ad.gestionDeUsuariosYContrasenyas.service;

import com.ad.gestionDeUsuariosYContrasenyas.exceptions.*;
import com.ad.gestionDeUsuariosYContrasenyas.model.NewUserPassword;
import com.ad.gestionDeUsuariosYContrasenyas.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDate;
import java.util.Map;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

@Service
public class UserService {

    Boolean loginStatus = false;

    @Autowired
    Map<Integer, User> users;

    public String hashedPassword(String password) {
        return DigestUtils.md5DigestAsHex((password + "mamasita").getBytes());
    }

    public Boolean isValid(String password) {
        return password.length() > 7 && password.chars().anyMatch(Character::isUpperCase)
                && password.chars().anyMatch(Character::isDigit);
    }

    public Boolean returnOneUser(String email, String password) {
        return users.values().stream().anyMatch(u -> u.getPassword().equals(password)
                && u.getEmail().equals(email));
    }

    public Map<Integer, User> userRegister(User user) {
        boolean isNotInside = returnOneUser(user.getEmail(), user.getPassword());
        int id = RandomGenerator.getDefault().nextInt(100);
        if (!isNotInside) {
            if (isValid(user.getPassword())) {
                users.put(id, User.builder().email(user.getEmail()).password(user.getPassword()).build());
            } else {
                throw new PasswordIsNotValidException("la contaseña no es valida");
            }
        } else {
            throw new UserIsInsideException("el usuario ya esta creado");
        }
        return users;
    }
    
    public Boolean userLogin(String email, String password) {
        if (returnOneUser(email, password)) {
            loginStatus = true;
        } else {
            throw new UserNotFoundException("no se encontro el usuario");
        }
        return loginStatus;
    }

    public Stream<LocalDate> paswordValidity(String email, User user) {
        return users.values().stream().filter(u -> u.getEmail().equals(email) && u.getPassword().equals(user.getPassword())).map(User::getPasswordValidity);
    }

    public Boolean deleterUser(User user) {
        if (returnOneUser(user.getEmail(), user.getPassword()) && loginStatus) {
            return users.values().removeIf(u -> u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword()));
        } else {
            throw new DeleteUserException("o no te logueaste o introdujiste mal lo atributos");
        }
    }

    public Map<Integer, User> returnUsers() {
        return users;
    }

    public Boolean updatePassword(NewUserPassword newUserPassword) {
        if (!userLogin(newUserPassword.getEmail(), newUserPassword.getPassword()))  {
            throw new UserNotFoundException("usuario no logueado");
        }

        if (!isValid(newUserPassword.getNewPassword())) {
            throw new PasswordIsNotSure("contraseña no segura");
        }

        User user = users.values().stream().filter(u -> u.getEmail().equals(newUserPassword.getEmail())).findFirst()
                .orElseThrow(() -> new DeleteUserException("palomo"));

        if (user.getPasswords().contains(newUserPassword.getNewPassword())) {
            throw new IsOnTheListException("ya esta en la lista");
        }

        if (user.getPasswords().size() == 3) {
            user.getPasswords().remove(0);
        }
        user.getPasswords().add(user.getPassword());
        user.setPassword(newUserPassword.getNewPassword());

        return true;
    }
}