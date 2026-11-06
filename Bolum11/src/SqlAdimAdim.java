import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// SQL adim adim: CREATE TABLE ve veri tipleri/kisitlar, INSERT, UPDATE, DELETE, SELECT.
// Bellekteki gecici veri tabaninda calisir.
public class SqlAdimAdim {
	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:");
				Statement st = conn.createStatement()) {

			// CREATE TABLE ve Veri Tipleri
			st.execute("CREATE TABLE IF NOT EXISTS uyeler (\n"
					+ "  id    INTEGER PRIMARY KEY,   -- benzersiz\n"
					+ "  name  TEXT NOT NULL,         -- bos olamaz\n"
					+ "  email TEXT UNIQUE,           -- tekrar edemez\n"
					+ "  yas   INTEGER CHECK (yas >= 0)\n"
					+ ")");
			st.executeUpdate("INSERT INTO uyeler(name, email, yas) VALUES ('Ali', 'ali@example.com', 20)");
			String[] hatali = {
				"INSERT INTO uyeler(name, email, yas) VALUES (NULL, 'x@example.com', 1)",
				"INSERT INTO uyeler(name, email, yas) VALUES ('Can', 'ali@example.com', 1)",
				"INSERT INTO uyeler(name, email, yas) VALUES ('Ece', 'ece@example.com', -3)"
			};
			for (String s : hatali) {
				try {
					st.executeUpdate(s);
				} catch (SQLException e) {
					System.out.println("kisit ihlali");   // kisit ihlali (uc kez: NOT NULL, UNIQUE, CHECK)
				}
			}

			// SQL Adim Adim
			st.execute("CREATE TABLE users (id INTEGER PRIMARY KEY,\n"
					+ "                    name TEXT, email TEXT)");
			st.executeUpdate("INSERT INTO users(name, email)\n"
					+ "  VALUES('Ahmet Yilmaz', 'ahmet@example.com')");
			st.executeUpdate("INSERT INTO users(name, email)\n"
					+ "  VALUES('Ayse Demir', 'ayse@example.com')");
			st.executeUpdate("UPDATE users SET name = 'Mehmet Akdeniz'\n"
					+ "  WHERE id = 1");
			st.executeUpdate("DELETE FROM users WHERE id = 1");
			try (ResultSet rs = st.executeQuery("SELECT * FROM users")) {
				while (rs.next())
					System.out.println(rs.getInt("id") + " " + rs.getString("name")
							+ " " + rs.getString("email"));   // 2 Ayse Demir ayse@example.com
			}
		}
	}
}
