package com.example.labee.fourthLab.database.dao;

import com.example.labee.fourthLab.database.entity.Displayable;
import com.example.labee.fourthLab.database.entity.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends BaseDAO<Displayable> {
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
    protected void setCreateParameters(PreparedStatement statement, Displayable entity) throws SQLException {
        statement.setInt(1, ((Product) entity).getProductId());
        statement.setString(2, ((Product) entity).getName());
        statement.setString(3, ((Product) entity).getDescription());
        statement.setDouble(4, ((Product) entity).getPrice());
        statement.setInt(5, ((Product) entity).getCategoryId());
        statement.setInt(6, ((Product) entity).getManufacturerId());
    }

    @Override
    protected void setUpdateParameters(PreparedStatement statement, Displayable entity) throws SQLException {
        statement.setInt(6, ((Product) entity).getProductId());
        statement.setString(1, ((Product) entity).getName());
        statement.setString(2, ((Product) entity).getDescription());
        statement.setDouble(3, ((Product) entity).getPrice());
        statement.setInt(4, ((Product) entity).getCategoryId());
        statement.setInt(5, ((Product) entity).getManufacturerId());
    }

    @Override
    protected Displayable mapRowToEntity(ResultSet resultSet) throws SQLException {
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
    protected List<Displayable> mapRowToListOfEntity(ResultSet resultSet) throws SQLException {
        ArrayList<Displayable> products = new ArrayList<>();
        while (resultSet.next()) {
            products.add(mapRowToEntity(resultSet));
        }
        return products;
    }

    public List<Displayable> filter() {
        String sql = "SELECT * " +
                "FROM products p " +
                "JOIN manufacturers m ON p.manufacturer_id = m.manufacturer_id " +
                "WHERE p.price < 5000 AND m.manufacturer_country = 'China';";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            System.out.println(mapRowToListOfEntity(statement.executeQuery()));
            close(connection);
            return mapRowToListOfEntity(statement.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
