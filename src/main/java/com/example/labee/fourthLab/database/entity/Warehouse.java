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
public class Warehouse implements Displayable {
    private int id;
    private String name;
    private String location;

    @Override
    public Map<String, String> getDisplayInfo() {
        return Map.of("ID", String.valueOf(id), "Название", name, "Местонахождение", location);
    }
}
