package com.example.labee.fourthLab.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

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
    public Map<String, String> getDisplayInfo() {
        return Map.of("ID", String.valueOf(productId),
                "Название", name,
                "Описание", description,
                "Цена", String.valueOf(price),
                "ID категории", String.valueOf(categoryId),
                "ID производителя", String.valueOf(manufacturerId)
        );
    }
}
