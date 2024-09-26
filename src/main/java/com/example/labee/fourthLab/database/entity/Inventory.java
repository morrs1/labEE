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
public class Inventory implements Displayable {
    private int inventoryId;
    private int productId;
    private int warehouseId;
    private int quantity;

    @Override
    public Map<String, String> getDisplayInfo() {
        return Map.of(
                "ID", String.valueOf(inventoryId),
                "ID товара", String.valueOf(productId),
                "ID склада", String.valueOf(warehouseId),
                "Колчество", String.valueOf(quantity)
        );
    }
}
