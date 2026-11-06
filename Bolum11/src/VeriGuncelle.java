import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Veri guncelleme: executeUpdate ile UPDATE ... WHERE.
public class VeriGuncelle {

	static void calistir() {
		String url = "jdbc:sqlite:sample.db";
		String sql = "UPDATE users SET name = 'Mehmet Akdeniz' WHERE id = 1";
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {
			// Veri tabanindaki veri guncelleniyor.
			int sayi = stmt.executeUpdate(sql);
			System.out.println("Veri guncellendi! (" + sayi + " satir)");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		TabloOlustur.calistir();   // Tablo olusturuldu!
		VeriEkle.calistir();       // Veri eklendi! (1 satir)
		calistir();                // Veri guncellendi! (1 satir)
		VeriOku.calistir();        // ID: 1, Ad: Mehmet Akdeniz, E-posta: ahmet@example.com
		Baglan.dosyayiSil();
	}
}
