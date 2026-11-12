import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Yabanci anahtar ve iliskiler: bolumler ve ogrenciler tablolari; ogrenciler.bolum_id
// bolumler.id'ye isaret eder. Diger ornekler bu tablolari olustur() ile kurar.
public class OkulVeritabani {

	static void olustur(Connection conn) throws SQLException {
		try (Statement st = conn.createStatement()) {
			st.execute("CREATE TABLE bolumler (\n"
					+ "  id INTEGER PRIMARY KEY,\n"
					+ "  ad TEXT NOT NULL)");
			st.execute("CREATE TABLE ogrenciler (\n"
					+ "  id INTEGER PRIMARY KEY,\n"
					+ "  ad TEXT NOT NULL,\n"
					+ "  bolum_id INTEGER REFERENCES bolumler(id))");
			st.executeUpdate("INSERT INTO bolumler(ad) VALUES ('Bilgisayar'), ('Elektrik'), ('Makine')");
			st.executeUpdate("INSERT INTO ogrenciler(ad, bolum_id) VALUES "
					+ "('Ada', 1), ('Bora', 2), ('Cem', 1), ('Deniz', NULL)");
		}
	}

	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:");
				Statement st = conn.createStatement()) {
			olustur(conn);
			try (ResultSet rs = st.executeQuery("SELECT id, ad, bolum_id FROM ogrenciler")) {
				while (rs.next())
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			// 1 Ada 1
			// 2 Bora 2
			// 3 Cem 1
			// 4 Deniz null
		}
	}
}

/* Beklenen cikti:
1 Ada 1
2 Bora 2
3 Cem 1
4 Deniz null
*/
