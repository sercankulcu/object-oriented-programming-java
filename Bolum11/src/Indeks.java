import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Indeks: EXPLAIN QUERY PLAN, sorgunun tabloyu bastan sona mi taradigini (SCAN)
// yoksa indeksle mi aradigini (SEARCH) gosterir.
public class Indeks {

	static void plan(Statement st, String sql) throws SQLException {
		try (ResultSet rs = st.executeQuery("EXPLAIN QUERY PLAN " + sql)) {
			while (rs.next())
				System.out.println(rs.getString("detail"));
		}
	}

	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:");
				Statement st = conn.createStatement()) {
			OkulVeritabani.olustur(conn);
			plan(st, "SELECT * FROM ogrenciler WHERE ad = 'Cem'");   // SCAN ogrenciler
			st.execute("CREATE INDEX idx_ogr_ad ON ogrenciler(ad)");
			plan(st, "SELECT * FROM ogrenciler WHERE ad = 'Cem'");   // SEARCH ogrenciler USING INDEX idx_ogr_ad (ad=?)
			plan(st, "SELECT * FROM ogrenciler WHERE id = 3");       // SEARCH ogrenciler USING INTEGER PRIMARY KEY (rowid=?)
			plan(st, "SELECT * FROM ogrenciler WHERE ad LIKE '%em'"); // SCAN ogrenciler
		}
	}
}
