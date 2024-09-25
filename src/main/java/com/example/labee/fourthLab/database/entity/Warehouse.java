package com.example.labee.fourthLab.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Warehouse {
    private int id;
    private String name;
    private String location;
}
