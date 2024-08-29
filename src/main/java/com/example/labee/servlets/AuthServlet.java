package com.example.labee.servlets;

import com.example.labee.model.core.helpers.JSONParser;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> parameterMap = JSONParser.parse(request.getReader());
        parameterMap.forEach((k, v) -> System.out.println(k + " " + v));

        Cookie verifyCookie = new Cookie("verify", "true");
        verifyCookie.setPath("/");

        response.addCookie(verifyCookie);
        response.sendRedirect("/");
    }

}
