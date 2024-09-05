package com.example.labee.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/check-auth")
public class CheckAuthServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object sessionAttribute = request.getSession().getAttribute("logInAttempts");
        int logInAttempts = sessionAttribute == null ? 0 : (Integer) sessionAttribute ;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"logInAttempts\": " + logInAttempts + "}");
    }

}
