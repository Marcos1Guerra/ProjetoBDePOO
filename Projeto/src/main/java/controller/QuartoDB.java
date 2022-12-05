package controller;

import java.sql.*;
import java.util.ArrayList;

import Model.Quarto;

public class QuartoDB extends Database {
    private boolean check = false;

    public boolean insertQuarto(Quarto quarto) {
        connect();
        String sql = "INSERT INTO Quarto (Prioridade, Numero) VALUES (?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, quarto.getPrioridade());
            pst.setInt(2, quarto.getNumero());
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

    public ArrayList<Quarto> selectQuarto() {
        connect();
        ArrayList<Quarto> quartos = new ArrayList<>();
        String sql = "SELECT * FROM Quarto;";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Quarto quarto = new Quarto(result.getInt("Numero"), result.getString("Prioridade"));
                quartos.add(quarto);
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
        return quartos;
    }

    public boolean updateQuarto(String Prioridade, int Numero) {
        connect();
        String sql = "UPDATE Quarto SET Prioridade = ? WHERE Numero = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, Prioridade);
            pst.setInt(2, Numero);
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

    public boolean deleteQuarto(int Numero) {
        connect();
        String sql = "DELETE FROM Quarto WHERE Numero = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, Numero);
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