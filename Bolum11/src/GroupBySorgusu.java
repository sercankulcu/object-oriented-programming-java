import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// GROUP BY ve HAVING: siparisler musteriye gore gruplanir, COUNT ve SUM hesaplanir;
// HAVING gruplari suzer.
public class GroupBySorgusu {
	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:");
				Statement stmt = conn.createStatement()) {
			stmt.execute("CREATE TABLE siparisler (id INTEGER PRIMARY KEY, musteri TEXT, tutar INTEGER)");
			stmt.executeUpdate("INSERT INTO siparisler(musteri, tutar) VALUES "
					+ "('Ali', 120), ('Ece', 80), ('Ali', 50), ('Can', 200), ('Ece', 40), ('Ali', 30)");

			String sql = "SELECT musteri, COUNT(*) AS adet, "
					+ "SUM(tutar) AS toplam FROM siparisler "
					+ "GROUP BY musteri HAVING SUM(tutar) >= 150 "
					+ "ORDER BY toplam DESC, musteri";
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					System.out.println(rs.getString("musteri") + ": "
							+ rs.getInt("adet") + " siparis, "
							+ rs.getInt("toplam") + " TL");
				}
			}
			// Ali: 3 siparis, 200 TL
			// Can: 1 siparis, 200 TL
		}
	}
}
