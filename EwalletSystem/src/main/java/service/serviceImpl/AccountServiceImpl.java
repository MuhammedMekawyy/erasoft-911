package service.serviceImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.Account;
import service.AccountService;

public class AccountServiceImpl implements AccountService {

    private DataSource dataSource;

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public AccountServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

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

    @Override
    public boolean createAccount(Account account) {

        try {

            openConnection();

            String query =
                    "INSERT INTO ACCOUNTS(USERNAME, USER_PASSWORD, BALANCE, PHONE_NUMBER, AGE) "
                  + "VALUES(?,?,?,?,?)";

            statement = connection.prepareStatement(query);

            statement.setString(1, account.getUsername());
            statement.setString(2, account.getPassword());
            statement.setDouble(3, account.getBalance());
            statement.setString(4, account.getPhoneNumber());
            statement.setFloat(5, account.getAge());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean accountExist(Account account) {

        try {

            openConnection();

            String query =
                    "SELECT * FROM ACCOUNTS WHERE USERNAME=? AND USER_PASSWORD=?";

            statement = connection.prepareStatement(query);

            statement.setString(1, account.getUsername());
            statement.setString(2, account.getPassword());

            resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean accountExistsByUsername(String username) {

        try {

            openConnection();

            String query =
                    "SELECT 1 FROM ACCOUNTS WHERE USERNAME=?";

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
    public boolean deleteAccountByUsername(String username) {

        try {

            openConnection();

            String query =
                    "DELETE FROM ACCOUNTS WHERE USERNAME=?";

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
    public boolean updateAccountPassword(String username, String newPassword) {

        try {

            openConnection();

            String query =
                    "UPDATE ACCOUNTS SET USER_PASSWORD=? WHERE USERNAME=?";

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
    
    
    @Override
    public Account login(Account account) {

    	String sql =
    		    "SELECT ACCOUNT_ID, USERNAME, BALANCE, PHONE_NUMBER, AGE " +
    		    "FROM ACCOUNTS " +
    		    "WHERE USERNAME = ? AND USER_PASSWORD = ?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

            	Account loggedInAccount = new Account();

            	loggedInAccount.setId(rs.getInt("ACCOUNT_ID"));
            	loggedInAccount.setUsername(rs.getString("USERNAME"));
            	loggedInAccount.setBalance(rs.getDouble("BALANCE"));
            	loggedInAccount.setPhoneNumber(rs.getString("PHONE_NUMBER"));
            	loggedInAccount.setAge(rs.getFloat("AGE"));

            	return loggedInAccount;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}