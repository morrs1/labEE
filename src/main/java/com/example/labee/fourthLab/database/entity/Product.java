package com.example.labee.fourthLab.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product {
    private int productId;
    private String name;
    private String description;
    private double price;
    private int categoryId;
    private int manufacturerId;
}
