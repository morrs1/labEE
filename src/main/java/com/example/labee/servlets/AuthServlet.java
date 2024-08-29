package com.example.labee.servlets;

import com.example.labee.model.core.Auth;
import com.example.labee.model.core.helpers.HashPassword;
import com.example.labee.model.core.helpers.JSONParser;
import com.example.labee.model.core.helpers.XMLParser;
import com.example.labee.model.schemas.User;
import com.example.labee.model.schemas.XMLUsers;
import jakarta.servlet.ServletContext;
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
                                parameterMap.get("firstname"),
                                parameterMap.get("lastname"),
                                parameterMap.get("password")
                        ),
                        new File(
                                new File(
                                        getServletContext().getRealPath("/")
                                ).getParentFile().getParentFile().getAbsolutePath()
                                        + "/src/main/java/com/example/labee/resources/xml/accounting-information.xml"
                        )

                );


        if (auth.logIn()) {
            Cookie verifyCookie = new Cookie("verify", "true");
            verifyCookie.setPath("/");
            response.addCookie(verifyCookie);
            response.sendRedirect("/");
            System.out.println("успех");
        }else {
            //добавить логику 3 попыток аутентификации
            response.sendRedirect("/auth-page");
            System.out.println("не успех");
        }


    }

}
