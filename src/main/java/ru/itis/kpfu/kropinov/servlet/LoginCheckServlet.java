package ru.itis.kpfu.kropinov.servlet;

import ru.itis.kpfu.kropinov.service.UserService;
import ru.itis.kpfu.kropinov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/check/login")
public class LoginCheckServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        if (!userService.checkLoginUnique(login)) {
            resp.setContentType("text/plain");
            resp.getWriter().write("This login already exists! Please choose another one.");
        }
    }
}
