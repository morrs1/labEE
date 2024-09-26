package com.example.labee.fourthLab.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashMap;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product implements Displayable {
    private int productId;
    private String name;
    private String description;
    private double price;
    private int categoryId;
    private int manufacturerId;

    @Override
    public LinkedHashMap<String, String> getDisplayInfo() {
        var map = new LinkedHashMap<String, String>();
        map.put("ID", String.valueOf(productId));
        map.put("Название", name);
        map.put("Описание", description);
        map.put("Цена", String.valueOf(price));
        map.put("ID категории", String.valueOf(categoryId));
        map.put("ID производителя", String.valueOf(manufacturerId));
        return map;
    }
}
