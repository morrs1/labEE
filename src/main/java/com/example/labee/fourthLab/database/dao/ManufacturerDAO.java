package com.example.labee.fourthLab.database.dao;

import com.example.labee.fourthLab.database.entity.Manufacturer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDAO extends BaseDAO<Manufacturer> {
    @Override
    protected String getCreateQuery() {
        return "INSERT INTO manufacturers (manufacturer_id, manufacturer_name, manufacturer_country) VALUES (?, ?, ?)";
    }

    @Override
    protected String getReadQuery() {
        return "SELECT * FROM manufacturers WHERE manufacturer_id = ?";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE manufacturers SET manufacturer_name =?, manufacturer_country = ? WHERE manufacturer_id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM manufacturers WHERE manufacturer_id = ?";
    }

    @Override
    protected String getReadAllQuery() {
        return "SELECT * FROM manufacturers";
    }

    @Override
    protected void setCreateParameters(PreparedStatement statement, Manufacturer entity) throws SQLException {
        statement.setInt(1, entity.getId());
        statement.setString(2, entity.getName());
        statement.setString(3, entity.getCountry());
    }

    @Override
    protected void setUpdateParameters(PreparedStatement statement, Manufacturer entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getCountry());
        statement.setInt(3, entity.getId());
    }

    @Override
    protected Manufacturer mapRowToEntity(ResultSet resultSet) throws SQLException {
        return new Manufacturer(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3)
        );
    }

    @Override
    protected List<Manufacturer> mapRowToListOfEntity(ResultSet resultSet) throws SQLException {
        ArrayList<Manufacturer> manufacturers = new ArrayList<>();
        while (resultSet.next()) {
           Manufacturer manufacturer = new Manufacturer(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
            manufacturers.add(manufacturer);
        }
        return manufacturers;
    }
}
