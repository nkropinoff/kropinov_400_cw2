package ru.itis.kpfu.kropinov.servlet;

import ru.itis.kpfu.kropinov.dao.UserDao;
import ru.itis.kpfu.kropinov.entity.User;
import ru.itis.kpfu.kropinov.repostiory.UserRepository;
import ru.itis.kpfu.kropinov.service.UserService;
import ru.itis.kpfu.kropinov.service.impl.UserServiceImpl;
import ru.itis.kpfu.kropinov.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUp", urlPatterns = "/sign_up")
public class SignUpServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("sign_up.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        userService.signUp(name, lastname, login, password);
        resp.sendRedirect("login");
    }
}