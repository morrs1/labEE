package com.example.labee.servlets;

import com.example.labee.model.core.helpers.HashPassword;
import com.example.labee.model.core.helpers.JSONParser;
import com.example.labee.model.core.helpers.XMLParser;
import com.example.labee.model.schemas.User;
import com.example.labee.model.schemas.XMLUsers;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private XMLUsers users;
    private File xmlFile;

    @Override
    public void init() {
        xmlFile = new File(
                new File(
                        getServletContext().getRealPath("/")
                ).getParentFile().getParentFile().getAbsolutePath()
                        + "/src/main/java/com/example/labee/resources/xml/accounting-information.xml"
        );
        users = (XMLUsers) XMLParser.deserialize(xmlFile, new XMLUsers());
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> requestParameters = JSONParser.parse(request.getReader());
        System.out.println(requestParameters);
        String regex = "^\\+7\\d{10}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(requestParameters.get("number"));

        if (matcher.matches()) {
            if (users.getByLogin(requestParameters.get("login")) == null) {
                users.getUsersList().add(new User(
                                requestParameters.get("login"),
                                HashPassword.hashPassword(requestParameters.get("password"))
                        )
                );
                XMLParser.serialize(xmlFile, users);
                response.addCookie(new Cookie("verify", "true"));
                response.sendRedirect("/");
            }
        } else {
            response.sendRedirect("/registration-page");
        }

        System.out.println(users.getUsersList());
    }

}
