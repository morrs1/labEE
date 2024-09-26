package com.example.labee.fourthLab.database.dao;

import com.example.labee.fourthLab.database.entity.Displayable;
import com.example.labee.fourthLab.database.entity.Inventory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO extends BaseDAO<Displayable> {
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
    protected void setCreateParameters(PreparedStatement statement, Displayable entity) throws SQLException {
        statement.setInt(1, ((Inventory) entity).getInventoryId());
        statement.setInt(2, ((Inventory) entity).getProductId());
        statement.setInt(3, ((Inventory) entity).getWarehouseId());
        statement.setInt(4, ((Inventory) entity).getQuantity());
    }

    @Override
    protected void setUpdateParameters(PreparedStatement statement, Displayable entity) throws SQLException {
        statement.setInt(1, ((Inventory) entity).getProductId());
        statement.setInt(2, ((Inventory) entity).getWarehouseId());
        statement.setInt(3, ((Inventory) entity).getQuantity());
        statement.setInt(4, ((Inventory) entity).getInventoryId());
    }

    @Override
    protected Displayable mapRowToEntity(ResultSet resultSet) throws SQLException {
        return new Inventory(
                resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getInt(3),
                resultSet.getInt(4)
        );
    }

    @Override
    protected List<Displayable> mapRowToListOfEntity(ResultSet resultSet) throws SQLException {
        ArrayList<Displayable> inventory = new ArrayList<>();
        while(resultSet.next()) {
            inventory.add(mapRowToEntity(resultSet));
        }
        return inventory;
    }
}
