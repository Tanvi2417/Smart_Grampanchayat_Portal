package com.gpp.repository;

import com.gpp.entity.Role;
import com.gpp.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {

    private DatabaseConnection databaseConnection = new DatabaseConnection();

    // CREATE
    public void addRole(Role role) {

        String sql =
                "INSERT INTO role (role_name, description) " +
                "VALUES (?, ?)";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, role.getRoleName());
            statement.setString(2, role.getDescription());

            int result = statement.executeUpdate();

            if (result > 0) {
                System.out.println("Role Added Successfully");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ ALL
    public List<Role> getAllRoles() {

        List<Role> roles = new ArrayList<>();

        String sql = "SELECT * FROM role";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Role role = convertToRole(resultSet);
                roles.add(role);
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    // READ BY ID
    public Role getRoleById(int roleId) {

        String sql =
                "SELECT * FROM role WHERE role_id = ?";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, roleId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Role role = convertToRole(resultSet);

                resultSet.close();
                statement.close();
                connection.close();
                return role;
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
    public void updateRole(Role role) {

        String sql =
                "UPDATE role SET " +
                "role_name = ?, " +
                "description = ? " +
                "WHERE role_id = ?";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, role.getRoleName());
            statement.setString(2, role.getDescription());
            statement.setInt(3, role.getRoleId());

            int result = statement.executeUpdate();

            if (result > 0) {

                System.out.println("Role Updated Successfully");

            } else {
                System.out.println("Role Not Found");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteRole(int roleId) {

        String sql =
                "DELETE FROM role WHERE role_id = ?";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, roleId);

            int result = statement.executeUpdate();

            if (result > 0) {

                System.out.println("Role Deleted Successfully");

            } else {
                System.out.println("Role Not Found");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // RESULTSET TO ROLE OBJECT
    private Role convertToRole(ResultSet resultSet) throws SQLException {

        Role role = new Role();

        role.setRoleId(resultSet.getInt("role_id"));
        role.setRoleName(resultSet.getString("role_name"));
        role.setDescription(resultSet.getString("description"));
        return role;
    }
}