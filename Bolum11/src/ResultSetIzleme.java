import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ResultSet izleme: imlec ilk satirin onunde baslar; her next() bir satir ilerler,
// satir kalmayinca false doner.
public class ResultSetIzleme {
	public static void main(String[] args) throws SQLException, IOException {
		String url = "jdbc:sqlite:okuma.db";

		// Eklendi: okuma.db'de iki kullanici hazirla
		try (Connection conn = DriverManager.getConnection(url);
				Statement st = conn.createStatement()) {
			st.execute("DROP TABLE IF EXISTS users");
			st.execute("CREATE TABLE users (id INTEGER PRIMARY KEY, name TEXT, email TEXT)");
			st.executeUpdate("INSERT INTO users(name, email) VALUES "
					+ "('Ahmet Yilmaz', 'ahmet@example.com'), ('Ayse Demir', 'ayse@example.com')");
		}

		String sql = "SELECT * FROM users";
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String ad = rs.getString("name");
				System.out.println(id + " - " + ad);
			}
			System.out.println("Okuma bitti.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// 1 - Ahmet Yilmaz
		// 2 - Ayse Demir
		// Okuma bitti.

		Files.deleteIfExists(Path.of("okuma.db"));
	}
}

/* Beklenen cikti:
1 - Ahmet Yilmaz
2 - Ayse Demir
Okuma bitti.
*/
