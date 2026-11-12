import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// MySQL'e baglanma: sunucu adresi, kullanici adi ve sifre ile getConnection.
// Bu ortamda MySQL sunucusu ve surucusu yok: baglanti hatasi yakalanip yazdirilir.
public class MySqlBaglanti {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/testdb";
		String kullanici = "root";
		String sifre = "gizli";
		String sql = "SELECT id, name, email FROM users";
		try (Connection conn =
				DriverManager.getConnection(url, kullanici, sifre);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " "
						+ rs.getString("name"));
			}
		} catch (SQLException e) {
			System.out.println("sunucu yok");   // eklendi
			System.out.println(e.getMessage());
		}
		// sunucu yok
		// No suitable driver found for jdbc:mysql://localhost:3306/testdb
	}
}

/* Beklenen cikti:
sunucu yok
No suitable driver found for jdbc:mysql://localhost:3306/testdb
*/
