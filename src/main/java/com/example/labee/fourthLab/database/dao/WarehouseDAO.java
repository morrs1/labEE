package com.example.labee.fourthLab.database.dao;

import com.example.labee.fourthLab.database.entity.Warehouse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDAO extends BaseDAO<Warehouse> {
    @Override
    protected String getCreateQuery() {
        return "INSERT INTO warehouses (warehouse_id, warehouse_name, warehouse_location) VALUES(?,?,?)";
    }

    @Override
    protected String getReadQuery() {
        return "SELECT * FROM warehouses WHERE warehouse_id = ?";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE warehouses SET warehouse_name = ?, warehouse_location = ? WHERE warehouse_id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM warehouses WHERE warehouse_id = ?";
    }

    @Override
    protected String getReadAllQuery() {
        return "SELECT * FROM warehouses";
    }

    @Override
    protected void setCreateParameters(PreparedStatement statement, Warehouse entity) throws SQLException {
        statement.setInt(1, entity.getId());
        statement.setString(2, entity.getName());
        statement.setString(3, entity.getLocation());
    }

    @Override
    protected void setUpdateParameters(PreparedStatement statement, Warehouse entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getLocation());
        statement.setInt(3, entity.getId());
    }

    @Override
    protected Warehouse mapRowToEntity(ResultSet resultSet) throws SQLException {

        return new Warehouse(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3)
        );
    }

    @Override
    protected List<Warehouse> mapRowToListOfEntity(ResultSet resultSet) throws SQLException {

        ArrayList<Warehouse> warehouses = new ArrayList<>();
        while (resultSet.next()) {
            warehouses.add(mapRowToEntity(resultSet));
        }
        return warehouses;
    }
}
