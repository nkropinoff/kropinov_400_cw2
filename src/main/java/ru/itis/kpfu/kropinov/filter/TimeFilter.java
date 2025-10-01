package ru.itis.kpfu.kropinov.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

public class TimeFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        LocalTime now = LocalTime.now();
        LocalTime dayStart = LocalTime.of(10, 45);
        LocalTime dayEnd = LocalTime.of(23, 45);

        if (now.isAfter(dayEnd) && now.isBefore(dayStart)) {
            res.sendRedirect("login");
        }
        chain.doFilter(req, res);
    }
}
