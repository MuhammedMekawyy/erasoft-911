package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Item;
import service.ItemService;

public class ItemServiceImpl implements ItemService {

    private DataSource dataSource;

    private ResultSet resultSet;
    private Connection connection;
    private PreparedStatement statement;

    public ItemServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // ================= Helper Methods =================

    private void openConnection() throws SQLException {
        connection = dataSource.getConnection();
    }

    private void closeConnection() {

        try {

            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Item createItem(ResultSet rs) throws SQLException {

        return new Item(
                rs.getInt("ID"),
                rs.getString("NAME"),
                rs.getDouble("PRICE"),
                rs.getInt("TOTAL_NUMBER"));
    }

    // ================= CRUD Methods =================

    @Override
    public List<Item> getAllItem() {

        try {

            openConnection();

            List<Item> items = new ArrayList<>();

            String query =
                    "SELECT i.ID, "
                  + "i.NAME, "
                  + "i.PRICE, "
                  + "i.TOTAL_NUMBER, "
                  + "CASE "
                  + "WHEN d.ITEM_ID IS NULL THEN 0 "
                  + "ELSE 1 "
                  + "END AS HAS_DETAILS "
                  + "FROM ITEMS i "
                  + "LEFT JOIN ITEM_DETAILS d "
                  + "ON i.ID = d.ITEM_ID";

            statement = connection.prepareStatement(query);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Item item = createItem(resultSet);

                item.setHasDetails(resultSet.getInt("HAS_DETAILS") == 1);

                items.add(item);
            }

            return items;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public Item getItemById(int id) {

        try {

            openConnection();

            String query =
                    "SELECT * FROM ITEMS WHERE ID = ?";

            statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return createItem(resultSet);
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean addItem(Item item) {

        try {

            openConnection();

            String query =
                    "INSERT INTO ITEMS "
                  + "(NAME, PRICE, TOTAL_NUMBER) "
                  + "VALUES (?, ?, ?)";

            statement = connection.prepareStatement(query);

            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.setInt(3, item.getTotalNumber());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean updateItemById(Item item) {

        try {

            openConnection();

            String query =
                    "UPDATE ITEMS "
                  + "SET NAME = ?, "
                  + "PRICE = ?, "
                  + "TOTAL_NUMBER = ? "
                  + "WHERE ID = ?";

            statement = connection.prepareStatement(query);

            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.setInt(3, item.getTotalNumber());
            statement.setInt(4, item.getId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean removeItemById(int id) {

        try {

            openConnection();

            String query =
                    "DELETE FROM ITEMS WHERE ID = ?";

            statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

}