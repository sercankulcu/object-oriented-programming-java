import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// Kontrol edilen istisnalar: FileNotFoundException, IOException, SQLException,
// ParseException, ClassNotFoundException. Okunacak dosya gecici klasorde
// olusturulur ve sonda silinir; MySQL sunucusu yok, baglanti hatasi yakalanir.
public class DosyaIstisnalari {

	// FileNotFoundException
	static void dosyaBulunamadi() {
		try {
			FileReader fileReader = new FileReader("dosya.txt");
		} catch (FileNotFoundException e) {
			// Dosya bulunamadi durumuyla ilgili islemler
			System.out.println(e);   // java.io.FileNotFoundException: dosya.txt (The system cannot find the file specified)
		}
	}

	// IOException
	static void dosyaOku(String path) {
		try {
			BufferedReader reader =
				new BufferedReader(new FileReader(path));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);   // birinci satir  ikinci satir
			}
			reader.close();
		} catch (IOException e) {
			// IOException durumuyla ilgili islemler
			e.printStackTrace();
		}

		// try-with-resources ile ayni is
		try (BufferedReader okuyucu =
				new BufferedReader(new FileReader(path))) {
			String satir;
			while ((satir = okuyucu.readLine()) != null) {
				System.out.println(satir);  // birinci satir  ikinci satir
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// SQLException (MySQL surucusu/sunucusu yok: baglanti kurulamaz)
	static void sqlOrnegi() {
		try {
			Connection connection =
				DriverManager.getConnection("jdbc:mysql://localhost/okul");
			PreparedStatement preparedStatement =
				connection.prepareStatement("SELECT user_id FROM users");
			// Sorguyu calistirma ve sonuclari alip isleme
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// Sonuclari isleme
				System.out.println("User ID: " + resultSet.getInt("user_id"));
			}
			// Baglantiyi kapatma
			connection.close();
		} catch (SQLException e) {
			// SQLException durumuyla ilgili islemler
			System.out.println(e);   // java.sql.SQLException: No suitable driver found for jdbc:mysql://localhost/okul
			System.out.println("(MySQL sunucusu yok: baglanti kurulamadi)");
		}
	}

	// ParseException ve ClassNotFoundException
	static void parseVeClassNotFound() {
		try {
			SimpleDateFormat form =
				new SimpleDateFormat("dd/MM/yy");
			Date date = form.parse("01-01-2022");
		} catch (ParseException e) {
			// Ayristirma hatasiyla ilgili islemler
			System.out.println(e);   // java.text.ParseException: Unparseable date: "01-01-2022"
		}

		try {
			Class.forName("java.util.Scanner");
			System.out.println("Scanner yuklendi");   // Scanner yuklendi
			// Var olmayan bir sinifi yuklemeye calisma
			Class.forName("com.example.NonExistentClass");
		} catch (ClassNotFoundException e) {
			System.out.println(e);   // java.lang.ClassNotFoundException: com.example.NonExistentClass
		}
	}

	public static void main(String[] args) throws IOException {
		dosyaBulunamadi();

		Path gecici = Files.createTempFile("bolum06_", ".txt");
		try {
			Files.write(gecici, List.of("birinci satir", "ikinci satir"));
			String path = gecici.toString();
			dosyaOku(path);
		} finally {
			Files.deleteIfExists(gecici);
		}

		sqlOrnegi();
		parseVeClassNotFound();
	}
}
