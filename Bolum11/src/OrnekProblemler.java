import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Ornek problemler: (1) silinen id'den sonra INTEGER PRIMARY KEY'in verdigi yeni id;
// (2) birlestirilmis SQL ile giris kontrolu enjeksiyonla atlatilir.
public class OrnekProblemler {
	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:");
				Statement stmt = conn.createStatement()) {
			// Ornek Problemler 1
			stmt.execute("CREATE TABLE users (id INTEGER PRIMARY KEY, name TEXT)");
			stmt.executeUpdate("INSERT INTO users(name) VALUES ('Ali')");
			stmt.executeUpdate("INSERT INTO users(name) VALUES ('Can')");
			stmt.executeUpdate("DELETE FROM users WHERE id = 2");
			stmt.executeUpdate("INSERT INTO users(name) VALUES ('Ece')");
			stmt.executeUpdate("UPDATE users SET name = 'Efe' WHERE id = 1");
			try (ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
				while (rs.next())
					System.out.println(rs.getInt("id") + " " + rs.getString("name"));
			}
			// 1 Efe
			// 2 Ece   (en buyuk id + 1; AUTOINCREMENT olsaydi 3)

			// Ornek Problemler 2
			stmt.execute("CREATE TABLE kisiler (ad TEXT, sifre TEXT)");
			stmt.executeUpdate("INSERT INTO kisiler VALUES ('Ali', 'gizli123')");
			String ad = "x";
			String sifre = "x' OR '1'='1";   // saldirganin yazdigi sifre
			String sql = "SELECT * FROM kisiler WHERE ad = '" + ad
					+ "' AND sifre = '" + sifre + "'";
			ResultSet rs = stmt.executeQuery(sql);
			boolean girisBasarili = rs.next();
			rs.close();
			System.out.println(girisBasarili);   // true  (AND, OR'dan once baglanir: kosul hep dogru)
		}
	}
}

/* Beklenen cikti:
1 Efe
2 Ece
true
*/
