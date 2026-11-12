import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Kisi programi: PreparedStatement ile ekle, guncelle, sil; Statement ile listele.
// kisiler.db dosyasini kullanir ve sonda siler.
public class KisiProgrami {

	static void ekle(Connection conn, String ad, String soyad,
			int yas) throws SQLException {
		String sql = "INSERT INTO kisiler(ad, soyad, yas) "
				+ "VALUES(?, ?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, ad);      // 1. soru isareti
			ps.setString(2, soyad);   // 2. soru isareti
			ps.setInt(3, yas);        // 3. soru isareti
			ps.executeUpdate();
		}
	}

	static void guncelle(Connection conn, String ad, String soyad,
			int yas) throws SQLException {
		String sql = "UPDATE kisiler SET soyad = ?, yas = ? "
				+ "WHERE ad = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, soyad);
			ps.setInt(2, yas);
			ps.setString(3, ad);
			ps.executeUpdate();
		}
	}

	static void sil(Connection conn, String ad) throws SQLException {
		String sql = "DELETE FROM kisiler WHERE ad = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, ad);
			ps.executeUpdate();
		}
	}

	static void listele(Connection conn) throws SQLException {
		String sql = "SELECT id, ad, soyad, yas FROM kisiler";
		try (Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("ad")
						+ " " + rs.getString("soyad") + " " + rs.getInt("yas"));
			}
			System.out.println("---");
		}
	}

	public static void main(String[] args) throws SQLException, IOException {
		Files.deleteIfExists(Path.of("kisiler.db"));   // eklendi: temiz baslangic
		String url = "jdbc:sqlite:kisiler.db";
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {
			stmt.execute("CREATE TABLE IF NOT EXISTS kisiler ("
					+ "id INTEGER PRIMARY KEY, ad TEXT NOT NULL, "
					+ "soyad TEXT NOT NULL, yas INTEGER NOT NULL)");
			ekle(conn, "Ahmet", "Yilmaz", 30);
			ekle(conn, "Ayse", "Demir", 40);
			guncelle(conn, "Ahmet", "Akdeniz", 35);
			listele(conn);
			sil(conn, "Ahmet");
			listele(conn);
		}
		// 1 Ahmet Akdeniz 35
		// 2 Ayse Demir 40
		// ---
		// 2 Ayse Demir 40
		// ---
		Files.deleteIfExists(Path.of("kisiler.db"));   // eklendi: dosyayi sil
	}
}

/* Beklenen cikti:
1 Ahmet Akdeniz 35
2 Ayse Demir 40
---
2 Ayse Demir 40
---
*/
