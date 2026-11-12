import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JOIN ile tablolari birlestirme ve NULL degerler: INNER JOIN yalnizca esi olan satirlari,
// LEFT JOIN soldaki butun satirlari verir; getInt NULL icin 0 doner, wasNull() ayirt eder.
public class JoinSorgusu {
	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:");
				Statement stmt = conn.createStatement()) {
			OkulVeritabani.olustur(conn);

			String sql = "SELECT o.ad AS ogrenci, b.ad AS bolum "
					+ "FROM ogrenciler o JOIN bolumler b "
					+ "ON o.bolum_id = b.id ORDER BY o.id";
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					System.out.println(rs.getString("ogrenci") + " - "
							+ rs.getString("bolum"));
				}
			}
			// Ada - Bilgisayar
			// Bora - Elektrik
			// Cem - Bilgisayar

			// LEFT JOIN: Deniz de gelir, bolumu null
			try (ResultSet rs = stmt.executeQuery("SELECT o.ad AS ogrenci, b.ad AS bolum "
					+ "FROM ogrenciler o LEFT JOIN bolumler b ON o.bolum_id = b.id ORDER BY o.id")) {
				while (rs.next())
					System.out.println(rs.getString("ogrenci") + " - " + rs.getString("bolum"));
			}
			// Ada - Bilgisayar
			// Bora - Elektrik
			// Cem - Bilgisayar
			// Deniz - null

			// NULL Degerler
			sql = "SELECT ad, bolum_id FROM ogrenciler "
					+ "WHERE id >= 3";
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					int b = rs.getInt("bolum_id");
					boolean bos = rs.wasNull();
					System.out.println(rs.getString("ad") + " " + b
							+ (bos ? " (NULL)" : ""));
				}
			}
			// Cem 1
			// Deniz 0 (NULL)
		}
	}
}

/* Beklenen cikti:
Ada - Bilgisayar
Bora - Elektrik
Cem - Bilgisayar
Ada - Bilgisayar
Bora - Elektrik
Cem - Bilgisayar
Deniz - null
Cem 1
Deniz 0 (NULL)
*/
