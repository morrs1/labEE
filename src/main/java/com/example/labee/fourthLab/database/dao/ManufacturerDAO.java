package com.example.labee.fourthLab.database.dao;

import com.example.labee.fourthLab.database.entity.Displayable;
import com.example.labee.fourthLab.database.entity.Manufacturer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDAO extends BaseDAO<Displayable> {
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
    protected void setCreateParameters(PreparedStatement statement, Displayable entity) throws SQLException {
        statement.setInt(1, ((Manufacturer)entity).getId());
        statement.setString(2, ((Manufacturer)entity).getName());
        statement.setString(3, ((Manufacturer)entity).getCountry());
    }

    @Override
    protected void setUpdateParameters(PreparedStatement statement, Displayable entity) throws SQLException {
        statement.setString(1, ((Manufacturer)entity).getName());
        statement.setString(2, ((Manufacturer)entity).getCountry());
        statement.setInt(3, ((Manufacturer)entity).getId());
    }

    @Override
    protected Displayable mapRowToEntity(ResultSet resultSet) throws SQLException {
        return new Manufacturer(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3)
        );
    }

    @Override
    protected List<Displayable> mapRowToListOfEntity(ResultSet resultSet) throws SQLException {
        ArrayList<Displayable> manufacturers = new ArrayList<>();
        while (resultSet.next()) {
            manufacturers.add(mapRowToEntity(resultSet));
        }
        return manufacturers;
    }
}
