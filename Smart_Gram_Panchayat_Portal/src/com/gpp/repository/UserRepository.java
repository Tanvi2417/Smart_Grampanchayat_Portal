package com.gpp.repository;

import com.gpp.entity.User;
import com.gpp.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private DatabaseConnection databaseConnection = new DatabaseConnection();

    // CREATE
    public void addUser(User user) {

        String sql = "INSERT INTO users " +
                "(role_id, full_name, email, mobile_number, password, " +
                "date_of_birth, gender, address, is_active) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, user.getRoleId());
            statement.setString(2, user.getFullName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getMobileNumber());
            statement.setString(5, user.getPassword());

            if (user.getDateOfBirth() != null) {

                statement.setDate(6,Date.valueOf(user.getDateOfBirth()));

            } else {
                statement.setNull(6, Types.DATE);
            }

            statement.setString(7, user.getGender());
            statement.setString(8, user.getAddress());
            statement.setBoolean(9, user.isActive());

            int result = statement.executeUpdate();

            if (result > 0) {
                System.out.println("User Added Successfully");
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ ALL
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                User user = convertToUser(resultSet);
                users.add(user);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // READ BY ID
    public User getUserById(int userId) {

        String sql =
                "SELECT * FROM users WHERE user_id = ?";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                User user = convertToUser(resultSet);

                resultSet.close();
                statement.close();
                connection.close();
                return user;
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // UPDATE
    public void updateUser(User user) {

        String sql =
                "UPDATE users SET " +
                "role_id = ?, " +
                "full_name = ?, " +
                "email = ?, " +
                "mobile_number = ?, " +
                "password = ?, " +
                "date_of_birth = ?, " +
                "gender = ?, " +
                "address = ?, " +
                "is_active = ? " +
                "WHERE user_id = ?";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, user.getRoleId());
            statement.setString(2, user.getFullName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getMobileNumber());
            statement.setString(5, user.getPassword());

            if (user.getDateOfBirth() != null) {

                statement.setDate(6, Date.valueOf(user.getDateOfBirth()));

            } else {
                statement.setNull(6, Types.DATE);
            }

            statement.setString(7, user.getGender());
            statement.setString(8, user.getAddress());
            statement.setBoolean(9, user.isActive());
            statement.setInt(10, user.getUserId());

            int result = statement.executeUpdate();

            if (result > 0) {
                System.out.println("User Updated Successfully");
            } else {
                System.out.println("User Not Found");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteUser(int userId) {

        String sql =
                "DELETE FROM users WHERE user_id = ?";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, userId);

            int result = statement.executeUpdate();

            if (result > 0) {
                System.out.println("User Deleted Successfully");
            } else {
                System.out.println("User Not Found");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // RESULTSET TO USER
    private User convertToUser(ResultSet resultSet) throws SQLException {

        User user = new User();

        user.setUserId(resultSet.getInt("user_id"));
        user.setRoleId(resultSet.getInt("role_id"));
        user.setFullName(resultSet.getString("full_name"));
        user.setEmail(resultSet.getString("email"));
        user.setMobileNumber(resultSet.getString("mobile_number"));
        user.setPassword(resultSet.getString("password"));

        Date date = resultSet.getDate("date_of_birth");

        if (date != null) {

            user.setDateOfBirth(date.toLocalDate());
        }

        user.setGender(resultSet.getString("gender"));
        user.setAddress(resultSet.getString("address"));
        user.setActive(resultSet.getBoolean("is_active"));
        user.setCreatedAt(resultSet.getTimestamp("created_at"));
        user.setUpdatedAt(resultSet.getTimestamp("updated_at"));
        return user;
    }
}