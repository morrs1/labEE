package com.example.labee.fourthLab.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashMap;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Inventory implements Displayable {
    private int inventoryId;
    private int productId;
    private int warehouseId;
    private int quantity;

    @Override
    public LinkedHashMap<String, String> getDisplayInfo() {
        var map = new LinkedHashMap<String, String>();
        map.put("ID", String.valueOf(inventoryId));
        map.put("ID товара", String.valueOf(productId));
        map.put("ID склада", String.valueOf(warehouseId));
        map.put("Количество", String.valueOf(quantity));

        return map;
    }
}
