package com.example.labee.thirdLab.servlets;

import com.example.labee.thirdLab.model.helpers.DAOCreator;
import com.example.labee.thirdLab.schemas.AudioFileDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteAudioFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AudioFileDAO audioFileDAO = new DAOCreator().createAudiFileDAO();
        audioFileDAO.deleteAudioFile(request.getParameter("id"));
        new DAOCreator().serialize(audioFileDAO);
        System.out.println("Удаление прошло успешно");
        request.getRequestDispatcher("thirdLab/main-page-third-lab.jsp").forward(request, response);

    }
}

