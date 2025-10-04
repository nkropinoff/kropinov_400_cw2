package ru.itis.kpfu.kropinov.dao;

import ru.itis.kpfu.kropinov.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    void save(User user);

    User getById(Integer id);

    User getByLogin(String login);
}
