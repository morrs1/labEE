package com.example.labee.fourthLab.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Category {
    private int id;
    private String name;
    private String description;
}
