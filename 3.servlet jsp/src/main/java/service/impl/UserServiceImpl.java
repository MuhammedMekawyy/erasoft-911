package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.Users;
import service.UserService;

public class UserServiceImpl implements UserService {

    private DataSource dataSource;

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public UserServiceImpl(DataSource dataSource) {
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

    // ================= CRUD Methods =================

    @Override
    public boolean createUser(Users user) {

        try {

            openConnection();

            String query =
                    "INSERT INTO USERS (USERNAME, EMAIL, USER_PASSWORD) "
                  + "VALUES (?, ?, ?)";

            statement = connection.prepareStatement(query);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean userExist(Users user) {

        try {

            openConnection();

            String query =
                    "SELECT * FROM USERS "
                  + "WHERE USERNAME = ? AND USER_PASSWORD = ?";

            statement = connection.prepareStatement(query);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

            resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean userExistsByUsername(String username) {

        try {

            openConnection();

            String query =
                    "SELECT 1 FROM USERS WHERE USERNAME = ?";

            statement = connection.prepareStatement(query);

            statement.setString(1, username);

            resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean deleteUserByUsername(String username) {

        try {

            openConnection();

            String query =
                    "DELETE FROM USERS WHERE USERNAME = ?";

            statement = connection.prepareStatement(query);

            statement.setString(1, username);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean updateUserPassword(String username, String newPassword) {

        try {

            openConnection();

            String query =
                    "UPDATE USERS "
                  + "SET USER_PASSWORD = ? "
                  + "WHERE USERNAME = ?";

            statement = connection.prepareStatement(query);

            statement.setString(1, newPassword);
            statement.setString(2, username);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

}