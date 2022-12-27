import java.sql.*;

/*
 * Here is a code sample that demonstrates how to use SQLite in Java:
 * 
 * */

public class SQLiteDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// Connect to the database
			String url = "jdbc:sqlite:test2.db";
			conn = DriverManager.getConnection(url);
			
			Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                    + " id INTEGER PRIMARY KEY,\n"
                    + " first_name TEXT NOT NULL,\n"
                    + " last_name TEXT NOT NULL,\n"
                    + " age INTEGER NOT NULL\n"
                    + ");";
            stmt.execute(sql);
            System.out.println("Table created successfully");

			// Insert a new record
			insertRecord(conn, "John", "Doe", 30);
			System.out.println("Table inserted successfully");

			// Update an existing record
			updateRecord(conn, "John", "Smith", 35);
			System.out.println("Table updated successfully");

			// Select all records
			selectAllRecords(conn);
			System.out.println("Table listed successfully");

			// Delete a record
			deleteRecord(conn, "John");
			System.out.println("Table deleted successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void insertRecord(Connection conn, String firstName, String lastName, int age) throws SQLException {
		String sql = "INSERT INTO users(first_name, last_name, age) VALUES(?, ?, ?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, firstName);
		pstmt.setString(2, lastName);
		pstmt.setInt(3, age);
		pstmt.executeUpdate();
	}

	public static void updateRecord(Connection conn, String firstName, String lastName, int age) throws SQLException {
		String sql = "UPDATE users SET last_name = ?, age = ? WHERE first_name = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, lastName);
		pstmt.setInt(2, age);
		pstmt.setString(3, firstName);
		pstmt.executeUpdate();
	}

	public static void selectAllRecords(Connection conn) throws SQLException {
		String sql = "SELECT id, first_name, last_name, age FROM users";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			System.out.println(rs.getInt("id") +  "\t" + 
					rs.getString("first_name") + "\t" +
					rs.getString("last_name") + "\t" +
					rs.getInt("age"));
		}
	}

	public static void deleteRecord(Connection conn, String firstName) throws SQLException {
		String sql = "DELETE FROM users WHERE first_name = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, firstName);
		pstmt.executeUpdate();
	}
}