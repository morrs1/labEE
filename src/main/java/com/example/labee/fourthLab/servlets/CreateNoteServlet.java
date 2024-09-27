package com.example.labee.fourthLab.servlets;

import com.example.labee.fourthLab.database.entity.Displayable;
import com.example.labee.fourthLab.model.core.DAOFactory;
import com.example.labee.fourthLab.model.core.EntityFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

@WebServlet("/add-note")
public class CreateNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Displayable newEntity = EntityFactory.create(request.getParameter("typeOfTable"), request);
        try {
            DAOFactory.getDAO(request.getParameter("typeOfTable")).create(newEntity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            String typeOfTable = URLEncoder.encode(request.getParameter("typeOfTable"), StandardCharsets.UTF_8);
            response.sendRedirect("main-page-fourth-lab?typeOfTable=" + typeOfTable);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(); // Обработка исключения
        }
    }
}
