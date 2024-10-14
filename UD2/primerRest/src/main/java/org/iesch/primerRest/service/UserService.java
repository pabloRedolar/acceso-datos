package org.iesch.primerRest.service;

import org.iesch.primerRest.Model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    Map<Integer, User> usuarios = HashMap.newHashMap(1);

    public User getUser(int id){
        usuarios.put(1, new User(1, "Pablo", "Redolar", "16753475C"));
        usuarios.put(2, new User(2, "a", "b", "16753435C"));
        return null;
    }
}
