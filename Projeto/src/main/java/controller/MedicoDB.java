package controller;

import java.sql.*;
import java.util.ArrayList;
import Model.Medico;

public class MedicoDB extends Database {
    private boolean check = false;

    public boolean insertMedico(Medico medico) {
        connect();
        String sql = "INSERT INTO Medico (CRM, Nome, Funcao) VALUES (?, ?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, medico.getCRM());
            pst.setString(2, medico.getNome());
            pst.setString(3, medico.getFuncao());
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

    public ArrayList<Medico> selectMedico() {
        connect();
        ArrayList<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM Medico;";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Medico medico = new Medico();
                medico.setNome(result.getString("Nome"));
                medico.setCRM(result.getInt("CRM"));
                medico.setFuncao(result.getString("Funcao"));

                System.out.println("Nome = "+ medico.getNome());
                System.out.println("CRM = "+ medico.getCRM());
                System.out.println("Funcao = "+ medico.getFuncao());
                medicos.add(medico);
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
        return medicos;
    }

    public boolean updateMedico(String Nome, int CRM) {
        connect();
        String sql = "UPDATE Medico SET Nome = ? WHERE CRM = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, Nome);
            pst.setInt(2, CRM);
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

    public boolean deleteMedico(int CRM) {
        connect();
        String sql = "DELETE FROM Medico WHERE CRM = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, CRM);
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