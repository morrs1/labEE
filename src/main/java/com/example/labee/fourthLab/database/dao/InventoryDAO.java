package com.example.labee.fourthLab.database.dao;

import com.example.labee.fourthLab.database.entity.Inventory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO extends BaseDAO<Inventory> {
    @Override
    protected String getCreateQuery() {
        return "INSERT INTO inventory (inventory_id, product_id, warehouse_id, quantity) VALUES (?,?,?,?)";
    }

    @Override
    protected String getReadQuery() {
        return "SELECT * FROM inventory WHERE inventory_id = ?";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE inventory SET product_id = ?, warehouse_id = ?, quantity = ? WHERE inventory_id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM inventory WHERE inventory_id = ?";
    }

    @Override
    protected String getReadAllQuery() {
        return "SELECT * FROM inventory";
    }

    @Override
    protected void setCreateParameters(PreparedStatement statement, Inventory entity) throws SQLException {
        statement.setInt(1, entity.getInventoryId());
        statement.setInt(2, entity.getProductId());
        statement.setInt(3, entity.getWarehouseId());
        statement.setInt(4, entity.getQuantity());
    }

    @Override
    protected void setUpdateParameters(PreparedStatement statement, Inventory entity) throws SQLException {
        statement.setInt(1, entity.getProductId());
        statement.setInt(2, entity.getWarehouseId());
        statement.setInt(3, entity.getQuantity());
        statement.setInt(4, entity.getInventoryId());
    }

    @Override
    protected Inventory mapRowToEntity(ResultSet resultSet) throws SQLException {
        return new Inventory(
                resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getInt(3),
                resultSet.getInt(4)
        );
    }

    @Override
    protected List<Inventory> mapRowToListOfEntity(ResultSet resultSet) throws SQLException {
        ArrayList<Inventory> inventory = new ArrayList<>();
        while(resultSet.next()) {
            inventory.add(mapRowToEntity(resultSet));
        }
        return inventory;
    }
}
