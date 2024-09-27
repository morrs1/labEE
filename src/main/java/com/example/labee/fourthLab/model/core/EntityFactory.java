package com.example.labee.fourthLab.model.core;


import com.example.labee.fourthLab.database.dao.*;
import com.example.labee.fourthLab.database.entity.*;
import jakarta.servlet.http.HttpServletRequest;

import java.net.http.HttpRequest;

public class EntityFactory {
    public static Displayable create(String entityType, HttpServletRequest request) {
        switch (entityType) {
            case "Производители": {
                return new Manufacturer(
                        Integer.parseInt(request.getParameter("ID")),
                        request.getParameter("Название"),
                        request.getParameter("Страна")
                );
            }
            case "Товары":
                return new Product(
                        Integer.parseInt(request.getParameter("ID")),
                        request.getParameter("Название"),
                        request.getParameter("Описание"),
                        Double.parseDouble(request.getParameter("Цена")),
                        Integer.parseInt(request.getParameter("ID категории")),
                        Integer.parseInt(request.getParameter("ID производителя"))
                );
            case "Категории":
                return new Category(
                        Integer.parseInt(request.getParameter("ID")),
                        request.getParameter("Название"),
                        request.getParameter("Описание")
                );
            case "Инвентарь":
                return new Inventory(
                        Integer.parseInt(request.getParameter("ID")),
                        Integer.parseInt(request.getParameter("ID товара")),
                        Integer.parseInt(request.getParameter("ID склада")),
                        Integer.parseInt(request.getParameter("Количество"))
                );
            case "Склады":
                return new Warehouse(
                        Integer.parseInt(request.getParameter("ID")),
                        request.getParameter("Название"),
                        request.getParameter("Местонахождение")
                );

            default:
                throw new IllegalArgumentException("Unknown type of table: " + entityType);
        }
    }
}
