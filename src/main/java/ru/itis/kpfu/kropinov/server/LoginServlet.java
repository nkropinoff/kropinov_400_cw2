package ru.itis.kpfu.kropinov.server;

import ru.itis.kpfu.kropinov.repostiory.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        for (Map.Entry<String, String> e : UserRepository.getAllUsers().entrySet()) {
            if (e.getKey().equalsIgnoreCase(login) && e.getValue().equalsIgnoreCase(password)) {

                // session
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("user", login);
                httpSession.setMaxInactiveInterval(60 * 60);

                // cookie
                Cookie cookie = new Cookie("user", login);
                cookie.setMaxAge(24 * 60 * 60);

                resp.addCookie(cookie);

                resp.sendRedirect("main.jsp");
                return;
            }
        }
        resp.sendRedirect("login.html");

    }

}