import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Veri silme: executeUpdate ile DELETE; silinecek satir yoksa 0 doner.
public class VeriSil {

	static void calistir() {
		String url = "jdbc:sqlite:sample.db";
		String sql = "DELETE FROM users WHERE id = 1";
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {
			// Veri tabanindaki veri siliniyor.
			int sayi = stmt.executeUpdate(sql);
			System.out.println("Veri silindi! (" + sayi + " satir)");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		TabloOlustur.calistir();   // Tablo olusturuldu!
		VeriEkle.calistir();       // Veri eklendi! (1 satir)
		calistir();                // Veri silindi! (1 satir)
		calistir();                // Veri silindi! (0 satir)
		Baglan.dosyayiSil();
	}
}
