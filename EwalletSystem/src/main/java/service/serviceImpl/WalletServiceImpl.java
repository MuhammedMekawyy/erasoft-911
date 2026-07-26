package service.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import service.WalletService;

public class WalletServiceImpl implements WalletService {

    private DataSource dataSource;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public WalletServiceImpl(DataSource dataSource) {
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

    private void validateAmount(double amount) {

        if (amount <= 0) {
            throw new RuntimeException("Amount must be greater than zero.");
        }

        if (amount < 100) {
            throw new RuntimeException("Amount must be at least 100.");
        }

        if (amount % 100 != 0) {
            throw new RuntimeException("Amount must be in multiples of 100.");
        }
    }
    
    
    private int getAccountIdByUsername(String username) {

        try {

            openConnection();

            String sql = "SELECT ACCOUNT_ID FROM ACCOUNTS WHERE USERNAME=?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("ACCOUNT_ID");
            }

            return -1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }
    

    private boolean updateBalance(double amount, int accountId, String operation) {

        validateAmount(amount);

        try {

            openConnection();

            String sql =
                "UPDATE ACCOUNTS " +
                "SET BALANCE = BALANCE " + operation + " ? " +
                "WHERE ACCOUNT_ID = ?";

            statement = connection.prepareStatement(sql);

            statement.setDouble(1, amount);
            statement.setInt(2, accountId);

            int rows = statement.executeUpdate();

            if (rows == 0) {
                throw new RuntimeException("Account not found.");
            }

            return true;

        } catch (SQLException e) {

            // Database constraint violations
            if (e.getMessage().contains("CK_ACCOUNT_BALANCE")) {
                throw new RuntimeException("Insufficient balance.");
            }

            throw new RuntimeException(e);

        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean DepositMoney(double money, int id) {
        return updateBalance(money, id, "+");
    }

    @Override
    public boolean WithdrawMoney(double money, int id) {
        return updateBalance(money, id, "-");
    }

    @Override
    public boolean transferMoney(double money, int id, String receiverUsername) {
        int receiverId = getAccountIdByUsername(receiverUsername);

        if (receiverId == -1) {
            throw new RuntimeException("Receiver account not found.");
        }

        if (id == receiverId) {
            throw new RuntimeException("You cannot transfer money to yourself.");
        }

        if (!WithdrawMoney(money, id)) {
            return false;
        }

        if (!DepositMoney(money, receiverId)) {
            return false;
        }

        return true;
    }
}