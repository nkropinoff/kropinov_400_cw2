package ru.itis.kpfu.kropinov.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import ru.itis.kpfu.kropinov.dao.UserDao;
import ru.itis.kpfu.kropinov.dao.impl.UserDaoImpl;
import ru.itis.kpfu.kropinov.dto.UserDto;
import ru.itis.kpfu.kropinov.entity.User;
import ru.itis.kpfu.kropinov.service.UserService;
import ru.itis.kpfu.kropinov.util.CloudinaryUtil;
import ru.itis.kpfu.kropinov.util.PasswordUtil;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();
    private final Cloudinary cloudinary = CloudinaryUtil.getInstance();
    private static final String DIR_PATH = "/profile-images";
    private static final int DIRECTORIES_COUNT = 100;

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll().stream()
                .map(u -> new UserDto(u.getName(), u.getLogin()))
                .toList();
    }

    @Override
    public void signUp(String name, String lastname, String login, String password, Part imagePart) throws IOException {
        String secure_url = uploadFile(imagePart);
        userDao.save(new User(name, lastname, login, PasswordUtil.encrypt(password), secure_url));
    }


    private String uploadFile(Part part) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(part.getInputStream().readAllBytes(), ObjectUtils.asMap("folder", "profile-images"));
        return (String) uploadResult.get("secure_url");
    }


    @Override
    public boolean authenticate(String login, String password) {
        User user = userDao.getByLogin(login);
        if (user != null) return user.getPassword().equals(PasswordUtil.encrypt(password));
        return false;
    }

    @Override
    public boolean checkLoginUnique(String login) {
        return (userDao.getByLogin(login) == null);
    }

    @Override
    public User findByLogin(String login) {
        return userDao.getByLogin(login);
    }
}
