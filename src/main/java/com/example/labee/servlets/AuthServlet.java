package com.example.labee.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getParameter("login"));
        System.out.println(request.getParameter("firstname"));
        System.out.println(request.getParameter("lastname"));
        System.out.println(request.getParameter("password"));
        response.sendRedirect("/");
    }

}
