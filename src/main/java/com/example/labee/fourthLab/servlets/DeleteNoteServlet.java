package com.example.labee.fourthLab.servlets;

import com.example.labee.fourthLab.model.core.DAOFactory;
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

@WebServlet("/delete-note")
public class DeleteNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println(Integer.parseInt(request.getParameter("id")));
            DAOFactory.getDAO(request.getParameter("typeOfTable"))
                    .delete(Integer.parseInt(request.getParameter("id")));
            System.out.println(Integer.parseInt(request.getParameter("id")));
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
