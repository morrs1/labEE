package com.example.labee.servlets;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/signOut")
public class SignOutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie verifyCookie = new Cookie("verify", "");
        verifyCookie.setMaxAge(0);
        response.addCookie(verifyCookie);
        response.sendRedirect("/");
    }
}
