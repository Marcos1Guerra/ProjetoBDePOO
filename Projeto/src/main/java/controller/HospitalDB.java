package controller;

import java.sql.*;
import java.util.ArrayList;

import Model.Hospital;

public class HospitalDB extends Database {
    private boolean check = false;

    public boolean insertHospital(Hospital hospital) {
        connect();
        String sql = "INSERT INTO Hospital (Nome, Endereco) VALUES (?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, hospital.getNome());
            pst.setString(2, hospital.getEndereco());
            pst.execute();
            check = true;
        } catch (SQLException error) {
            System.out.println("Operation Error: " + error.getMessage());
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException error) {
                System.out.println("Connection Closure Error: " + error.getMessage());
            }
        }
        return check;
    }

    public ArrayList<Hospital> selectHospital() {
        connect();
        ArrayList<Hospital> hospitals = new ArrayList<>();
        String sql = "SELECT * FROM Hospital;";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Hospital hospital = new Hospital(result.getString("Nome"), result.getString("Endereco"));
                hospitals.add(hospital);
            }
        } catch (SQLException error) {
            System.out.println("Operation Error: " + error.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException error) {
                System.out.println("Connection Closure Error: " + error.getMessage());
            }
        }
        return hospitals;
    }
}