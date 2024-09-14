package com.example.labee.servlets;

import com.example.labee.model.core.helpers.XMLParser;
import com.example.labee.model.schemas.XMLUsers;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    XMLUsers users;
    @Override
    public void init(){
        users = (XMLUsers) XMLParser.deserialize(new File(
                new File(
                        getServletContext().getRealPath("/")
                ).getParentFile().getParentFile().getAbsolutePath()
                        + "/src/main/java/com/example/labee/resources/xml/accounting-information.xml"
        ), new XMLUsers());
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
       if (users.getByLogin(req.getParameter("login")) == null){
           System.out.println(req.getParameter("login"));
       }
    }

}
