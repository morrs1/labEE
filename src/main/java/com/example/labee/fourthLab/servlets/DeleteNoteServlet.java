package com.example.labee.fourthLab.servlets;

import com.example.labee.fourthLab.model.core.DAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete-note")
public class DeleteNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DAOFactory.getDAO(request.getParameter("typeOfTable"))
                    .delete(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("fourthLab/fourth-lab-index.html").include(request, response);
//        response.sendRedirect("fourthLab/fourth-lab-crud.jsp");
    }
}
