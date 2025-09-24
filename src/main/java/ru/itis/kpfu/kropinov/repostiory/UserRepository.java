package ru.itis.kpfu.kropinov.repostiory;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static Map<String, String> users = new HashMap<>();

    public static void signUpUser(String login, String password) {
        users.put(login, password);
    }

    public static Map<String, String> getAllUsers() {
        return users;
    }

}
