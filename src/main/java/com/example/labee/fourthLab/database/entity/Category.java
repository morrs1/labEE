package com.example.labee.fourthLab.database.entity;

import lombok.*;

import java.util.LinkedHashMap;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Category implements Displayable {
    private int id;
    private String name;
    private String description;

    @Override
    public LinkedHashMap<String, String> getDisplayInfo() {
        var map = new LinkedHashMap<String, String>();
        map.put("ID", String.valueOf(id));
        map.put("Название", name);
        map.put("Описание", description);

        return map;
    }
}
