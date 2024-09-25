package com.example.labee.fourthLab.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private int productId;
    private String name;
    private String description;
    private double price;
    private int categoryId;
    private int manufacturerId;
}
