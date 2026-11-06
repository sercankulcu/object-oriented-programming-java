import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// SQLite'a baglanma: jdbc:sqlite:sample.db adresi; dosya yoksa bos olarak olusturulur.
// Derleme ve calistirma (surucu jar'i classpath'te olmali):
//     javac Baglan.java
//     java -cp ".;sqlite-jdbc-3.40.0.0.jar" Baglan
public class Baglan {

	static void calistir() {
		// Veri tabani dosyasinin yolu (baglanti adresi)
		String url = "jdbc:sqlite:sample.db";
		try (Connection conn = DriverManager.getConnection(url)) {
			// Baglanti basariliysa mesaj yazdirilir.
			if (conn != null) {
				System.out.println("Baglanti basarili!");
			}
		} catch (SQLException e) {
			// Baglanti hatasi olursa hata mesaji yazdirilir.
			System.out.println(e.getMessage());
		}
	}

	// Eklendi: orneklerin olusturdugu sample.db dosyasini siler
	static void dosyayiSil() {
		try {
			Files.deleteIfExists(Path.of("sample.db"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		calistir();      // Baglanti basarili!
		dosyayiSil();
	}
}
