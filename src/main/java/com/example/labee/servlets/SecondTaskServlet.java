package com.example.labee.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/second-task")
public class SecondTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        System.out.println(request.getSession().getAttribute("amountOfRequest"));

        if (request.getSession().getAttribute("amountOfRequest") == null) {
            request.getSession().setAttribute("amountOfRequest", 1);
        } else {
            request.getSession().setAttribute(
                    "amountOfRequest", ((Integer) request.getSession().getAttribute("amountOfRequest")) + 1
            );
        }

        response.setContentType("text/html");
        String sessionId = request.getParameter("id_session");
        String serverTime = request.getParameter("server_time");
        String amountOfRequest = request.getParameter("request_amount");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Second Task</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Second Task</h1>");
        if (sessionId != null) {
            out.println("<h2>Session ID: " + request.getSession().getId() + "</h2>");
        }
        if (serverTime != null) {
            out.println("<h2>Server Time: " + formattedDateTime + "</h2>");
        }
        if (amountOfRequest != null) {
            out.println("<h2>Request Amount: " + request.getSession().getAttribute("amountOfRequest") + "</h2>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
