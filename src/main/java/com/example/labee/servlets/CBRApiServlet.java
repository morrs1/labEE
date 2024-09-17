package com.example.labee.servlets;

import com.example.labee.model.core.helpers.JSONParser;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@WebServlet("/cbr-api")
public class CBRApiServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> parameterMap = JSONParser.parse(request.getReader());
        System.out.println(parameterMap);

        String apiUrl = "https://www.cbr.ru/scripts/xml_metall.asp?date_req1=02/07/2021&date_req2=01/08/2021";
        // Создание HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // Создание запроса
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET() // Используем метод GET
                .build();
        // Выполнение запроса
        try {
            HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Проверка кода ответа
            if (httpResponse.statusCode() == 200) { // 200 OK
                // Установка типа контента и отправка ответа обратно клиенту
                response.setContentType("application/xml"); // Установите нужный тип контента
                PrintWriter out = response.getWriter();
                out.print(httpResponse.body());
                out.flush();
            } else {
                response.sendError(httpResponse.statusCode(), "Ошибка при получении данных с API: " + httpResponse.body());
            }
        } catch (IOException | InterruptedException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ошибка сервера: " + e.getMessage());
        }
    }
}
