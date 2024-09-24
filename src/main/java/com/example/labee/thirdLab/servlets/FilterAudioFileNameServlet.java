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
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/filter-name")
public class FilterAudioFileNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        AudioFileDAO audioFileDAO = new DAOCreator().createAudiFileDAO();
        List<AudioFile> audioFiles = audioFileDAO.getAudioFileList();

        List<AudioFile> filteredAudioFiles = audioFiles.stream()
                .filter(audioFile -> audioFile.getName().equals(name))
                .collect(Collectors.toList());

        request.setAttribute("audioFiles", filteredAudioFiles);
        request.getRequestDispatcher("thirdLab/main-page-third-lab.jsp").forward(request, response);
    }
}
