package com.example.labee.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

@WebServlet("/check-registration")
public class CheckRegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        AtomicBoolean flagOfRegistration = new AtomicBoolean(false);

        Arrays.asList(request.getCookies()).forEach(cookie -> {
            if (cookie.getName().equals("verify")) {
                flagOfRegistration.set(true);
            }
        });
        if (flagOfRegistration.get()) {
            response.getWriter().write("{\"RegistrationMessage\": \"Success at " + formattedDateTime + "\"}");
        }else{
            response.getWriter().write("{\"RegistrationMessage\": \"Fail at " + formattedDateTime + "\"}");
        }


    }
}
