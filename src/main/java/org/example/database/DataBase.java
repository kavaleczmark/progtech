package org.example.database;

import java.sql.*;

public class DataBase {

    private Connection con;
    static final String DB_URL = "jdbc:mysql://localhost:3306/wumpus";
    static final String USER = "root";
    static final String PASS = "";

    public DataBase() {
        this.con = createConnection();
    }

    private Connection createConnection() {
        try{
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void fetchPlayers() {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM players");
            System.out.println("NÉV\t\t\t"+"PONT");
            while (rs.next()) {
                System.out.print(rs.getString("name")+"\t\t");
                System.out.print(rs.getInt("score")+"\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePlayers(String userName) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String sql = "INSERT INTO players (name) VALUES ('"+userName+"') ON DUPLICATE KEY UPDATE score=score+1";
            stmt.executeUpdate(sql);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
