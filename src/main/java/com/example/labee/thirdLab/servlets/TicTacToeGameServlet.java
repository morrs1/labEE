package com.example.labee.thirdLab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/tictactoe")
public class TicTacToeGameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Перенаправляем запрос на JSP-страницу
        request.getRequestDispatcher("thirdLab/tic-tac-toe.jsp").forward(request, response);
    }
}
