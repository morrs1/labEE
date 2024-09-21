package com.example.labee.thirdLab.servlets;

import com.example.labee.thirdLab.model.helpers.DAOCreator;
import com.example.labee.thirdLab.schemas.AudioFile;
import com.example.labee.thirdLab.schemas.AudioFileDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/add")
public class AddAudioFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var daoCreator = new DAOCreator();
        AudioFileDAO audioFileDAO= daoCreator.createAudiFileDAO();
        var audioFile = new AudioFile(UUID.randomUUID().toString(), request.getParameter("title"), request.getParameter("artist"), request.getParameter("genre"));
        System.out.println(audioFile);
        audioFileDAO.getAudioFileList().add(audioFile);
        daoCreator.serialize(audioFileDAO);
        response.sendRedirect("/third-lab-page");
    }
}

