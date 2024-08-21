package com.example.labee.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/mainPage")
public class MainPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Cookie cookieOfVerify = new Cookie("verify", "false");
//        Cookie cookieOfTry = new Cookie("try", "0");
//        response.addCookie(cookieOfTry);
//        response.addCookie(cookieOfVerify);
        request.getRequestDispatcher("mainPage.html").forward(request, response);
    }
}
