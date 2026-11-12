import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC adimlari: baglan, Statement olustur, sorguyu calistir, sonucu gez; try-with-resources
// kaynaklari ters sirada otomatik kapatir.
public class JdbcAdimlari {
	public static void main(String[] args) {
		String url = "jdbc:sqlite::memory:";
		String sql = "SELECT 6 * 7";
		try (Connection conn = DriverManager.getConnection(url); // 1
				Statement stmt = conn.createStatement();             // 2
				ResultSet rs = stmt.executeQuery(sql)) {             // 3
			while (rs.next()) {                                     // 4
				System.out.println(rs.getInt(1));                   // 42
			}
		} catch (SQLException e) { // 5: rs, stmt, conn ters sirada otomatik kapanir
			System.out.println(e.getMessage());
		}
	}
}

/* Beklenen cikti:
42
*/
