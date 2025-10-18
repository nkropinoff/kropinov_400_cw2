package ru.itis.kpfu.kropinov.service;

import ru.itis.kpfu.kropinov.dto.UserDto;
import ru.itis.kpfu.kropinov.entity.User;

import javax.servlet.http.Part;
import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    void signUp(String name, String lastname, String login, String password, Part imagePart, String uploadPath);

    boolean authenticate(String login, String password);

    boolean checkLoginUnique(String login);

    User findByLogin(String login);
}
