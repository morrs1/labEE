package com.example.labee.fourthLab.servlets;

import com.example.labee.fourthLab.database.dao.ProductDAO;
import com.example.labee.fourthLab.database.entity.Displayable;
import com.example.labee.fourthLab.database.entity.Product;
import com.example.labee.fourthLab.model.core.DAOFactory;
import jakarta.servlet.RequestDispatcher;
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
import java.util.List;

@WebServlet("/filter-products")
public class FilterProductsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO(); // Предположим, что у вас есть конструктор по умолчанию
        List<Displayable> filteredProducts;

        filteredProducts =  productDAO.filter(); // Ваш метод фильтрации
        request.setAttribute("filteredProducts", filteredProducts);
        request.setAttribute("typeOfTable", "Товары");
        RequestDispatcher dispatcher = request.getRequestDispatcher("fourthLab/fourth-lab-crud.jsp"); // Замените на ваше имя JSP
        dispatcher.forward(request, response);
    }
}

