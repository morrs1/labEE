package com.example.labee.fourthLab.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Category {
    private int id;
    private String name;
    private String description;
}
