package com.example.labee.fourthLab.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Category implements Displayable {
    private int id;
    private String name;
    private String description;

    @Override
    public Map<String, String> getDisplayInfo() {
        return Map.of("ID", String.valueOf(id), "Название", name, "Описание", description);
    }
}
