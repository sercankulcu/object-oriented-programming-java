import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Veri ekleme: executeUpdate ile INSERT; donus degeri etkilenen satir sayisidir.
public class VeriEkle {

	static void calistir() {
		String url = "jdbc:sqlite:sample.db";
		String sql = "INSERT INTO users(name, email) "
				+ "VALUES('Ahmet Yilmaz', 'ahmet@example.com')";
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {
			// Veri tabanina veri ekleniyor.
			int sayi = stmt.executeUpdate(sql);
			System.out.println("Veri eklendi! (" + sayi + " satir)");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		TabloOlustur.calistir();   // Tablo olusturuldu!
		calistir();                // Veri eklendi! (1 satir)
		Baglan.dosyayiSil();
	}
}
