package com.example.labee.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/check-auth")
public class CheckAuthServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object sessionAttribute = request.getSession().getAttribute("logInAttempts");
        int logInAttempts = sessionAttribute == null ? 0 : (Integer) sessionAttribute;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        if(logInAttempts == 0){
            response.getWriter().write("{\"logInMessage\": \"Success at " + formattedDateTime + "\"}");
//            response.sendRedirect("/");
        } else if (logInAttempts < 3) {
            response.getWriter().write("{\"logInMessage\": \"Failed\", \"logInAttempts\": " + logInAttempts + "}");
//            response.sendRedirect("/auth-page");
        } else {
            response.getWriter().write("{\"logInMessage\": \"Forbidden\"}");
//            response.sendRedirect("/auth-page");
        }

    }

}
