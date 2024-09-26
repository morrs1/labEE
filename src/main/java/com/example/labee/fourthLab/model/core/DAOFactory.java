package com.example.labee.fourthLab.model.core;

import com.example.labee.fourthLab.database.dao.*;
import com.example.labee.fourthLab.database.entity.Displayable;

public class DAOFactory {
    public static BaseDAO<Displayable> getDAO(String typeOfTable) {
        switch (typeOfTable) {
            case "Производители":
                return new ManufacturerDAO();
            case "Товары":
                return new ProductDAO();
            case "Категории":
                return new CategoryDAO();
            case "Инвентарь":
                return new InventoryDAO();
            case "Склады":
                return new WarehouseDAO();

            default:
                throw new IllegalArgumentException("Unknown type of table: " + typeOfTable);
        }
    }
}
