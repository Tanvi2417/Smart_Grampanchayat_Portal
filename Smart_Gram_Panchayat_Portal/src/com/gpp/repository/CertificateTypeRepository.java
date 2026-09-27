package com.gpp.repository;

import com.gpp.entity.CertificateType;
import com.gpp.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CertificateTypeRepository {

    private DatabaseConnection databaseConnection = new DatabaseConnection();

    // CREATE
    public void addCertificateType(CertificateType certificateType) {

        String sql =
                "INSERT INTO certificate_type " +
                "(type_name, description) VALUES (?, ?)";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, certificateType.getTypeName());
            statement.setString(2, certificateType.getDescription());

            int result = statement.executeUpdate();

            if (result > 0) {
                System.out.println("Certificate Type Added Successfully");
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ ALL
    public List<CertificateType> getAllCertificateTypes() {

        List<CertificateType> certificateTypes = new ArrayList<>();

        String sql =
                "SELECT * FROM certificate_type";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                CertificateType certificateType = convertToCertificateType(resultSet);
                certificateTypes.add(certificateType);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return certificateTypes;
    }

    // READ BY ID
    public CertificateType getCertificateTypeById(int certificateTypeId) {

        String sql =
                "SELECT * FROM certificate_type " +
                "WHERE certificate_type_id = ?";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, certificateTypeId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                CertificateType certificateType = convertToCertificateType(resultSet);

                resultSet.close();
                statement.close();
                connection.close();

                return certificateType;
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
    public void updateCertificateType(CertificateType certificateType) {

        String sql =
                "UPDATE certificate_type SET " +
                "type_name = ?, " +
                "description = ? " +
                "WHERE certificate_type_id = ?";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, certificateType.getTypeName());
            statement.setString(2, certificateType.getDescription());
            statement.setInt(3, certificateType.getCertificateTypeId());

            int result = statement.executeUpdate();

            if (result > 0) {

                System.out.println("Certificate Type Updated Successfully");

            } else {
                System.out.println("Certificate Type Not Found");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteCertificateType(int certificateTypeId) {

        String sql =
                "DELETE FROM certificate_type " +
                "WHERE certificate_type_id = ?";

        try {
            Connection connection = databaseConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, certificateTypeId);

            int result = statement.executeUpdate();

            if (result > 0) {

                System.out.println("Certificate Type Deleted Successfully");

            } else {
                System.out.println("Certificate Type Not Found");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // RESULTSET TO CERTIFICATE TYPE OBJECT
    private CertificateType convertToCertificateType(ResultSet resultSet) throws SQLException {

        CertificateType certificateType = new CertificateType();

        certificateType.setCertificateTypeId(resultSet.getInt("certificate_type_id"));
        certificateType.setTypeName(resultSet.getString("type_name"));
        certificateType.setDescription(resultSet.getString("description"));
        return certificateType;
    }
}