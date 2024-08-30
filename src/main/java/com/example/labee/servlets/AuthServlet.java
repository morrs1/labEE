package com.example.labee.servlets;

import com.example.labee.model.core.Auth;
import com.example.labee.model.core.helpers.JSONParser;
import com.example.labee.model.schemas.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> parameterMap = JSONParser.parse(request.getReader());
        Auth auth =
                new Auth(
                        new User(
                                parameterMap.get("login"),
                                parameterMap.get("password")
                        ),
                        new File(
                                new File(
                                        getServletContext().getRealPath("/")
                                ).getParentFile().getParentFile().getAbsolutePath()
                                        + "/src/main/java/com/example/labee/resources/xml/accounting-information.xml"
                        )

                );

        Integer logInAttempts =(Integer) request.getSession().getAttribute("logInAttempts");
        if (logInAttempts == null) {
            logInAttempts = 0; // Инициализация счетчика попыток
        }
        if (auth.logIn()) {
            Cookie verifyCookie = new Cookie("verify", "true");
            request.getSession().removeAttribute("logInAttempts");
            response.getWriter().write("Login successful!");
            verifyCookie.setPath("/");
            response.addCookie(verifyCookie);
            response.sendRedirect("/");
            System.out.println("успех");
        }else {
            logInAttempts++;
            request.getSession().setAttribute("logInAttempts", logInAttempts);

            if (logInAttempts > 3) {
                System.out.println("Было превышено количество попыток входа: " + logInAttempts);
                response.getWriter().write("Слишком много неудачных попыток входа. Попробуйте позже.");
            } else {
                response.getWriter().write("Неверное имя пользователя или пароль. Попытка " + logInAttempts);
                System.out.println("Попыток входа: " + logInAttempts);
            }
            response.sendRedirect("/auth-page");
            System.out.println("не успех");
        }


    }

}
