import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Otomatik anahtar: RETURN_GENERATED_KEYS ile eklenen satirin veri tabaninin verdigi id'si okunur.
public class OtomatikAnahtar {
	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:")) {
			OkulVeritabani.olustur(conn);   // 4 ogrenci var

			String sql = "INSERT INTO ogrenciler(ad, bolum_id) "
					+ "VALUES(?, ?)";
			try (PreparedStatement ps = conn.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS)) {
				ps.setString(1, "Ece");
				ps.setInt(2, 3);
				ps.executeUpdate();
				try (ResultSet k = ps.getGeneratedKeys()) {
					if (k.next()) {
						System.out.println("Yeni id: " + k.getInt(1));   // Yeni id: 5
					}
				}
			}
		}
	}
}
