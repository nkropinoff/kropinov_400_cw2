package ru.itis.kpfu.kropinov.service.impl;

import ru.itis.kpfu.kropinov.dao.UserDao;
import ru.itis.kpfu.kropinov.dao.impl.UserDaoImpl;
import ru.itis.kpfu.kropinov.dto.UserDto;
import ru.itis.kpfu.kropinov.entity.User;
import ru.itis.kpfu.kropinov.service.UserService;
import ru.itis.kpfu.kropinov.util.PasswordUtil;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll().stream()
                .map(u -> new UserDto(u.getName(), u.getLogin()))
                .toList();
    }

    @Override
    public void signUp(String name, String lastname, String login, String password) {
        userDao.save(new User(name, lastname, login, PasswordUtil.encrypt(password)));
    }


    @Override
    public boolean authenticate(String login, String password) {
        User user = userDao.getByLogin(login);
        if (user != null) return user.getPassword().equals(PasswordUtil.encrypt(password));
        return false;
    }
}
