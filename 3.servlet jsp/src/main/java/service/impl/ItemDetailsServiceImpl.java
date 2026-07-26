package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.Item;
import model.ItemDetails;
import service.ItemDetailsService;

public class ItemDetailsServiceImpl implements ItemDetailsService {

    private DataSource dataSource;

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public ItemDetailsServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // =================== Helper Methods =======================

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

    // =================== CRUD Methods =======================

    @Override
    public boolean addItemDetails(ItemDetails itemDetails) {

        try {

            openConnection();

            String query =
                    "INSERT INTO ITEM_DETAILS (ITEM_ID, DESCRIPTION, WARRANTY_MONTHS) "
                  + "VALUES (?, ?, ?)";

            statement = connection.prepareStatement(query);

            statement.setInt(1, itemDetails.getItem().getId());
            statement.setString(2, itemDetails.getDescription());
            statement.setInt(3, itemDetails.getWarrantyMonths());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean updateItemDetails(ItemDetails itemDetails) {

        try {

            openConnection();

            String query =
                    "UPDATE ITEM_DETAILS "
                  + "SET DESCRIPTION = ?, WARRANTY_MONTHS = ? "
                  + "WHERE ITEM_ID = ?";

            statement = connection.prepareStatement(query);

            statement.setString(1, itemDetails.getDescription());
            statement.setInt(2, itemDetails.getWarrantyMonths());
            statement.setInt(3, itemDetails.getItem().getId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean removeItemDetailsByItemId(int itemId) {

        try {

            openConnection();

            String query =
                    "DELETE FROM ITEM_DETAILS WHERE ITEM_ID = ?";

            statement = connection.prepareStatement(query);

            statement.setInt(1, itemId);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public ItemDetails getItemDetailsByItemId(int itemId) {

        try {

            openConnection();

            String query =
                    "SELECT ID, ITEM_ID, DESCRIPTION, WARRANTY_MONTHS "
                  + "FROM ITEM_DETAILS "
                  + "WHERE ITEM_ID = ?";

            statement = connection.prepareStatement(query);

            statement.setInt(1, itemId);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Item item = new Item();
                item.setId(resultSet.getInt("ITEM_ID"));

                ItemDetails itemDetails = new ItemDetails();

                itemDetails.setId(resultSet.getInt("ID"));
                itemDetails.setItem(item);
                itemDetails.setDescription(resultSet.getString("DESCRIPTION"));
                itemDetails.setWarrantyMonths(resultSet.getInt("WARRANTY_MONTHS"));

                return itemDetails;
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

}