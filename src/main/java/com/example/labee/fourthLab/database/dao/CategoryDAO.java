package com.example.labee.fourthLab.database.dao;

import com.example.labee.fourthLab.database.entity.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends BaseDAO<Category> {
    @Override
    protected String getCreateQuery() {
        return "INSERT INTO categories (category_id, category_name, category_description) VALUES (?, ?, ?)";
    }

    @Override
    protected String getReadQuery() {
        return "SELECT category_id, category_name, category_description FROM categories WHERE category_id = ?";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE categories SET category_name = ?, category_description = ? WHERE category_id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM categories WHERE category_id = ?";
    }

    @Override
    protected String getReadAllQuery() {
        return "SELECT category_id, category_name, category_description FROM categories";
    }

    @Override
    protected void setCreateParameters(PreparedStatement statement, Category entity) throws SQLException {
        statement.setInt(1, entity.getId());
        statement.setString(2, entity.getName());
        statement.setString(3, entity.getDescription());
    }

    @Override
    protected void setUpdateParameters(PreparedStatement statement, Category entity) throws SQLException {
        statement.setInt(3, entity.getId());
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getDescription());
    }

    @Override
    protected Category mapRowToEntity(ResultSet resultSet) throws SQLException {
        return new Category(
                resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)
        );
    }


    @Override
    protected List<Category> mapRowToListOfEntity(ResultSet resultSet) throws SQLException {
        ArrayList<Category> categories = new ArrayList<>();
        while (resultSet.next()) {
            categories.add(mapRowToEntity(resultSet));
        }
        return categories;
    }
}
