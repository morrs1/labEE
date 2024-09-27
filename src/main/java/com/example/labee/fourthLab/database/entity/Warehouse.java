package com.example.labee.fourthLab.database.entity;

import lombok.*;

import java.util.LinkedHashMap;


@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Warehouse implements Displayable {
    private int id;
    private String name;
    private String location;

    @Override
    public LinkedHashMap<String, String> getDisplayInfo() {
        var map = new LinkedHashMap<String, String>();
        map.put("ID", String.valueOf(id));
        map.put("Название", name);
        map.put("Местонахождение", location);
        return map;
    }
}
