package com.example.labee.fourthLab.database.dao;

import com.example.labee.fourthLab.database.entity.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends BaseDAO<Product> {
    @Override
    protected String getCreateQuery() {
        return "INSERT INTO products " +
                "(product_id, product_name, product_description, price, category_id, manufacturer_id) VALUES (?,?,?,?,?,?)";
    }

    @Override
    protected String getReadQuery() {
        return "SELECT * FROM products WHERE product_id = ?";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE products SET " +
                "product_name = ?, product_description = ?, price=?, category_id = ?, manufacturer_id = ?" +
                " WHERE product_id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM products WHERE product_id = ?";
    }

    @Override
    protected String getReadAllQuery() {
        return "SELECT * FROM products";
    }

    @Override
    protected void setCreateParameters(PreparedStatement statement, Product entity) throws SQLException {
        statement.setInt(1, entity.getProductId());
        statement.setString(2, entity.getName());
        statement.setString(3, entity.getDescription());
        statement.setDouble(4, entity.getPrice());
        statement.setInt(5, entity.getCategoryId());
        statement.setInt(6, entity.getManufacturerId());
    }

    @Override
    protected void setUpdateParameters(PreparedStatement statement, Product entity) throws SQLException {
        statement.setInt(6, entity.getProductId());
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getDescription());
        statement.setDouble(3, entity.getPrice());
        statement.setInt(4, entity.getCategoryId());
        statement.setInt(5, entity.getManufacturerId());
    }

    @Override
    protected Product mapRowToEntity(ResultSet resultSet) throws SQLException {
        return new Product(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getDouble(4),
                resultSet.getInt(5),
                resultSet.getInt(6)
        );
    }

    @Override
    protected List<Product> mapRowToListOfEntity(ResultSet resultSet) throws SQLException {
        ArrayList<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            products.add(mapRowToEntity(resultSet));
        }
        return products;
    }
}
