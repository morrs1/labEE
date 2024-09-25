package com.example.labee.fourthLab.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Inventory {
    private int inventoryId;
    private int productId;
    private int warehouseId;
    private int quantity;
}
