package ru.itis.kpfu.kropinov.servlet;

import ru.itis.kpfu.kropinov.dao.UserDao;
import ru.itis.kpfu.kropinov.dao.impl.UserDaoImpl;
import ru.itis.kpfu.kropinov.dto.UserDto;
import ru.itis.kpfu.kropinov.entity.User;
import ru.itis.kpfu.kropinov.service.UserService;
import ru.itis.kpfu.kropinov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "User", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    // later use DI
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDto> users = userService.getAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("users.ftl").forward(req, resp);
    }
}