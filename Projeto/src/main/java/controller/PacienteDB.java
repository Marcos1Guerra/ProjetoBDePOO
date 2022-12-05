package controller;

import java.sql.*;
import java.util.ArrayList;

import Model.Paciente;

public class PacienteDB extends Database {
    private boolean check = false;

    public boolean insertPaciente(Paciente paciente) {
        connect();
        String sql = "INSERT INTO Paciente (Nome, CPF, Idade) VALUES (?, ?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, paciente.getNome());
            pst.setString(2, paciente.getCPF());
            pst.setInt(3, paciente.getIdade());
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

    public ArrayList<Paciente> selectPaciente(String CPF) {
        connect();
        ArrayList<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM Paciente WHERE CPF = '" + CPF + "'";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Paciente pacienteTemp = new Paciente();
                pacienteTemp.setCPF(result.getString("CPF"));
                pacienteTemp.setNome(result.getString("Nome"));
                pacienteTemp.setIdade(result.getInt("Idade"));

                System.out.println("CPF = "+ pacienteTemp.getCPF());
                System.out.println("Nome = "+ pacienteTemp.getNome());
                System.out.println("Idade = "+ pacienteTemp.getIdade());
                pacientes.add(pacienteTemp);
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
        return pacientes;
    }

    public boolean updatePaciente(String Nome, String CPF) {
        connect();
        String sql = "UPDATE Paciente SET Nome = ? WHERE CPF = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, Nome);
            pst.setString(2, CPF);
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

    public boolean deletePaciente(String CPF) {
        connect();
        String sql = "DELETE FROM Paciente WHERE CPF = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, CPF);
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
}