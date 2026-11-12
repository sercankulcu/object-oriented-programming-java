import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Tablo olusturma: Statement.execute ile CREATE TABLE IF NOT EXISTS.
public class TabloOlustur {

	static void calistir() {
		String url = "jdbc:sqlite:sample.db";
		String sql = "CREATE TABLE IF NOT EXISTS users "
				+ "(id INTEGER PRIMARY KEY, name TEXT, email TEXT)";
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {
			// Tablo olusturuluyor.
			stmt.execute(sql);
			System.out.println("Tablo olusturuldu!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		calistir();             // Tablo olusturuldu!
		Baglan.dosyayiSil();
	}
}

/* Beklenen cikti:
Tablo olusturuldu!
*/
