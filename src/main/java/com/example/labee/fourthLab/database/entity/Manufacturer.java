package com.example.labee.fourthLab.database.entity;

import lombok.*;

import java.util.LinkedHashMap;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Manufacturer implements Displayable {
    private int id;
    private String name;
    private String country;

    @Override
    public LinkedHashMap<String, String> getDisplayInfo() {
        var map = new LinkedHashMap<String, String>();
        map.put("ID", String.valueOf(id));
        map.put("Название", name);
        map.put("Страна", country);

        return map;
    }
}
