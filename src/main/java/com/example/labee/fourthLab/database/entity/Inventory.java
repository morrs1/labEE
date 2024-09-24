package com.example.labee.fourthLab.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Inventory {
    private int inventoryId;
    private int productId;
    private int warehouseId;
    private int quantity;
}
