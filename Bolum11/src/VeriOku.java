import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Veri okuma: executeQuery ile SELECT; ResultSet satir satir next() ile gezilir.
public class VeriOku {

	static void calistir() {
		String url = "jdbc:sqlite:sample.db";
		String sql = "SELECT * FROM users";
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			// Satirlar tek tek okunup yazdiriliyor.
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id")
						+ ", Ad: " + rs.getString("name")
						+ ", E-posta: " + rs.getString("email"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		TabloOlustur.calistir();   // Tablo olusturuldu!
		VeriEkle.calistir();       // Veri eklendi! (1 satir)
		calistir();                // ID: 1, Ad: Ahmet Yilmaz, E-posta: ahmet@example.com
		Baglan.dosyayiSil();
	}
}

/* Beklenen cikti:
Tablo olusturuldu!
Veri eklendi! (1 satir)
ID: 1, Ad: Ahmet Yilmaz, E-posta: ahmet@example.com
*/
