package sqlite;
import java.sql.*;

/*
 * Here is a code sample for a simple game using SQLite in Java:
 * 
 * This code initializes a SQLite database and creates a table for storing high scores. 
 * It then inserts a new score into the table and retrieves the top 10 high scores.
 * 
 * */

public class Game {
	
    private static final String DB_URL = "jdbc:sqlite:game.db";
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS scores (name TEXT, score INTEGER)";
    private static final String INSERT_SCORE_SQL = "INSERT INTO scores (name, score) VALUES (?, ?)";
    private static final String SELECT_HIGH_SCORES_SQL = "SELECT * FROM scores ORDER BY score DESC LIMIT ?";
    
    public static void main(String[] args) {
        // Initialize the database and create the scores table
        try (Connection conn = DriverManager.getConnection(DB_URL);
        		Statement stmt = conn.createStatement()) {
            stmt.execute(CREATE_TABLE_SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Insert a new score into the database
        try (Connection conn = DriverManager.getConnection(DB_URL);
        		PreparedStatement pstmt = conn.prepareStatement(INSERT_SCORE_SQL)) {
            pstmt.setString(1, "player1");
            pstmt.setInt(2, 100);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
     // Insert a new score into the database
        try (Connection conn = DriverManager.getConnection(DB_URL);
        		PreparedStatement pstmt = conn.prepareStatement(INSERT_SCORE_SQL)) {
            pstmt.setString(1, "player2");
            pstmt.setInt(2, 90);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
     // Insert a new score into the database
        try (Connection conn = DriverManager.getConnection(DB_URL);
        		PreparedStatement pstmt = conn.prepareStatement(INSERT_SCORE_SQL)) {
            pstmt.setString(1, "player3");
            pstmt.setInt(2, 80);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Retrieve the top 10 high scores from the database
        try (Connection conn = DriverManager.getConnection(DB_URL);
        		PreparedStatement pstmt = conn.prepareStatement(SELECT_HIGH_SCORES_SQL)) {
            pstmt.setInt(1, 10);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int score = rs.getInt("score");
                System.out.println(name + ": " + score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
