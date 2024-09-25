package com.example.labee.fourthLab.database.dao;

import com.example.labee.fourthLab.model.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T> {
    protected Connection connection;

    public BaseDAO() {
        connection = ConnectionManager.get();
    }

    public void create(T entity) throws SQLException {
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            setCreateParameters(statement, entity);
            statement.executeUpdate();
        }
    }

    public T read(int id) {
        String sql = getReadQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapRowToEntity(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<T> readAll() throws SQLException {
        String sql = getReadAllQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            return mapRowToListOfEntity(resultSet);
        }
    }

    public void update(T entity) throws SQLException {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            setUpdateParameters(statement, entity);
            statement.executeUpdate();
        }
    }

    // Метод для удаления записи
    public void delete(int id) throws SQLException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    protected abstract String getCreateQuery();

    protected abstract String getReadQuery();

    protected abstract String getUpdateQuery();

    protected abstract String getDeleteQuery();

    protected abstract String getReadAllQuery();

    protected abstract void setCreateParameters(PreparedStatement statement, T entity) throws SQLException;

    protected abstract void setUpdateParameters(PreparedStatement statement, T entity) throws SQLException;

    protected abstract T mapRowToEntity(ResultSet resultSet) throws SQLException;

    protected abstract List<T> mapRowToListOfEntity(ResultSet resultSet) throws SQLException;
}
