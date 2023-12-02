package org.example.database;

import org.example.map.Map;
import org.example.objects.*;

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
        try {
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
        Statement stmt = null; //le fog futni
        ResultSet rs = null; //eredmeny
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM players;");
            System.out.println("NÉV\t\t\t" + "PONT");
            while (rs.next()) {
                System.out.print(rs.getString("name") + "\t\t");
                System.out.print(rs.getInt("score") + "\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePlayers(String userName) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String sql = "INSERT INTO players (name) VALUES ('" + userName + "') ON DUPLICATE KEY UPDATE score=score+1;";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveMap(Map map, String mapName) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String sql = "INSERT INTO maps (name,size) VALUES ('" + mapName + "'," + map.getSize() + ");";
            String sql2 = "SELECT LAST_INSERT_ID();";
            stmt.executeUpdate(sql);
            rs = stmt.executeQuery(sql2);
            int mapId = 0;
            while (rs.next()) {
                mapId = rs.getInt(1);
            }
            int mapSize = map.getSize();
            String sql3;
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    sql3 = "INSERT INTO objects (mapID,type,x,y) VALUES (" + mapId + ",'" + map.getMap()[i][j].getSaveAbleName() + "'," + i + "," + j + ");";
                    stmt.executeUpdate(sql3);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Map loadMap(String mapName) {
        Statement stmt = null;
        ResultSet rs = null;
        Map map = null;
        GameObject[][] object = null;
        try {
            stmt = con.createStatement();
            String sql = "SELECT id,size FROM maps WHERE name = '" + mapName + "';";
            rs = stmt.executeQuery(sql);
            int mapId = 0;
            int mapSize = 0;
            while (rs.next()) {
                mapId = rs.getInt("id");
                mapSize = rs.getInt("size");
            }
            map = new Map(mapSize);
            object = new GameObject[mapSize][mapSize];
            String sql2 = "SELECT type,x,y FROM objects WHERE mapID = " + mapId + ";";
            rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                String type = rs.getString("type");
                int i = rs.getInt("x");
                int j = rs.getInt("y");
                switch (type) {
                    case "EMPTY" -> object[i][j] = new GameObject();
                    case "GOLD" -> object[i][j] = new Gold(i, j);
                    case "HERO|E" -> object[i][j] = new Hero(i, j, 'E');
                    case "HERO|S" -> object[i][j] = new Hero(i, j, 'S');
                    case "HERO|N" -> object[i][j] = new Hero(i, j, 'N');
                    case "HERO|W" -> object[i][j] = new Hero(i, j, 'W');
                    case "PIT" -> object[i][j] = new Pit();
                    case "WALL" -> object[i][j] = new Wall();
                    case "WUMPUS" -> object[i][j] = new Wumpus(i, j);
                }
            }
            map.setMap(object);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    public void fetchMapNames() {
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT name FROM maps;";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println("-----ELÉRHETŐ PÁLYÁK-----");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
