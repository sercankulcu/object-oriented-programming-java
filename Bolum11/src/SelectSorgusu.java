import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// SELECT sorgusu: WHERE suzer, ORDER BY siralar, LIMIT ilk satirlari alir.
// skorlar tablosu: ada 72, can 95, ece 58, efe 95, naz 81.
public class SelectSorgusu {
	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:")) {
			try (Statement st = conn.createStatement()) {
				st.execute("CREATE TABLE skorlar (oyuncu TEXT, puan INTEGER)");
				st.executeUpdate("INSERT INTO skorlar VALUES ('ada', 72), ('can', 95), "
						+ "('ece', 58), ('efe', 95), ('naz', 81)");
			}

			String sql = "SELECT oyuncu, puan FROM skorlar "
					+ "WHERE puan > 70 "
					+ "ORDER BY oyuncu DESC LIMIT 2";
			try (Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(sql)) {
				while (rs.next()) {
					System.out.println(rs.getString("oyuncu") + " "
							+ rs.getInt("puan"));
				}
			}
			// naz 81
			// efe 95

			// Sunumdaki tablodaki diger sorgular
			yazdir(conn, "SELECT oyuncu, puan FROM skorlar WHERE puan < 90 ORDER BY puan DESC");
			// naz 81, ada 72, ece 58
			yazdir(conn, "SELECT oyuncu, puan FROM skorlar ORDER BY puan DESC, oyuncu LIMIT 3");
			// can 95, efe 95, naz 81
			yazdir(conn, "SELECT oyuncu, puan FROM skorlar WHERE oyuncu LIKE 'e%'");
			// ece 58, efe 95
			yazdir(conn, "SELECT COUNT(*), AVG(puan), MAX(puan) FROM skorlar WHERE puan >= 60");
			// 4, 85.75, 95
		}
	}

	// Eklendi: sorgunun butun satirlarini "a b, c d" biciminde tek satira yazar
	static void yazdir(Connection conn, String sql) throws SQLException {
		try (Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			int n = rs.getMetaData().getColumnCount();
			StringBuilder sb = new StringBuilder();
			while (rs.next()) {
				if (sb.length() > 0) sb.append(", ");
				for (int i = 1; i <= n; i++)
					sb.append(i > 1 ? (n > 2 ? ", " : " ") : "").append(rs.getString(i));
			}
			System.out.println(sb);
		}
	}
}

/* Beklenen cikti:
naz 81
efe 95
naz 81, ada 72, ece 58
can 95, efe 95, naz 81
ece 58, efe 95
4, 85.75, 95
*/
