package com.example.labee.thirdLab.servlets;

import com.example.labee.thirdLab.model.helpers.DAOCreator;
import com.example.labee.thirdLab.schemas.AudioFileDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@WebServlet("/open")
public class OpenAudioFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AudioFileDAO audioFileDAO = new DAOCreator().createAudiFileDAO();
        var id = request.getParameter("id");
        System.out.println(audioFileDAO.getAudioFile(id).getPath());
        String filePath = audioFileDAO.getAudioFile(id).getPath().replace("\"", ""); // Замените на ваш путь
        File audioFile = new File(filePath);

        // Проверяем, поддерживает ли Desktop API
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                // Открываем файл в стандартном приложении
                desktop.open(audioFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Desktop is not supported on this platform.");
        }
        request.getRequestDispatcher("thirdLab/main-page-third-lab.jsp").forward(request, response);
    }
}
