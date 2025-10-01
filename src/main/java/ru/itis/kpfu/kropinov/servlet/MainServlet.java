package ru.itis.kpfu.kropinov.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String cookieUser = "";
        String sessionId = "";
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("user".equalsIgnoreCase(c.getName())) {
                    cookieUser = c.getValue();
                } else if ("jsessionid".equalsIgnoreCase(c.getName())) {
                    sessionId = c.getValue();
                }
            }
        } else {
            sessionId = session.getId();
        }

        req.setAttribute("cookieUser", cookieUser);
        req.setAttribute("sessionId", sessionId);
        req.setAttribute("sessionUser", session.getAttribute("user"));
        req.getRequestDispatcher("main.ftl").forward(req, resp);
    }
}
