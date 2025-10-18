package ru.itis.kpfu.kropinov.service.impl;

import ru.itis.kpfu.kropinov.dao.UserDao;
import ru.itis.kpfu.kropinov.dao.impl.UserDaoImpl;
import ru.itis.kpfu.kropinov.dto.UserDto;
import ru.itis.kpfu.kropinov.entity.User;
import ru.itis.kpfu.kropinov.service.UserService;
import ru.itis.kpfu.kropinov.util.PasswordUtil;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();
    private static final String DIR_PATH = "/profile-images";
    private static final int DIRECTORIES_COUNT = 100;

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll().stream()
                .map(u -> new UserDto(u.getName(), u.getLogin()))
                .toList();
    }

    @Override
    public void signUp(String name, String lastname, String login, String password, Part imagePart, String uploadPath) {
        String filename = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
        String shortPath = Math.abs(filename.hashCode() % DIRECTORIES_COUNT) + File.separator + filename;
        String dbPath = DIR_PATH + File.separator + shortPath;

        String fullFilePath = uploadPath + File.separator + shortPath;

        userDao.save(new User(name, lastname, login, PasswordUtil.encrypt(password), dbPath));
        uploadFile(imagePart, fullFilePath);
    }

    private void uploadFile(Part part, String filePath) {
        File file = new File(filePath);
        file.getParentFile().mkdirs();

        try (InputStream content = part.getInputStream();
             FileOutputStream outputStream = new FileOutputStream(file)) {
            file.createNewFile();

            byte[] buffer = new byte[content.available()];
            content.read(buffer);

            outputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed file upload", e);
        }
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
