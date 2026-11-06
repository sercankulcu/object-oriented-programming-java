import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Havale ornegi (islem/transaction): yatirma ve cekme ya birlikte kalici olur (commit)
// ya da ikisi birden geri alinir (rollback). CHECK (bakiye >= 0) eksi bakiyeyi engeller.
public class Havale {
	static final String YATIR =
			"UPDATE hesaplar SET bakiye = bakiye + ? WHERE id = ?";
	static final String CEK =
			"UPDATE hesaplar SET bakiye = bakiye - ? WHERE id = ?";

	static void havale(Connection conn, int kimden, int kime,
			int tutar) throws SQLException {
		conn.setAutoCommit(false);         // islem baslar
		try (PreparedStatement p1 = conn.prepareStatement(YATIR);
				PreparedStatement p2 = conn.prepareStatement(CEK)) {
			p1.setInt(1, tutar);  p1.setInt(2, kime);
			p1.executeUpdate();              // aliciya yatir
			p2.setInt(1, tutar);  p2.setInt(2, kimden);
			p2.executeUpdate();              // gondericiden cek
			conn.commit();                   // kalici yap
			System.out.println(tutar + " TL aktarildi.");
		} catch (SQLException e) {
			conn.rollback();                 // geri al
			System.out.println("Geri alindi: " + tutar + " TL");
		} finally {
			conn.setAutoCommit(true);
		}
	}

	// Eklendi: hesaplari yazdirir
	static void yazdir(Connection conn) throws SQLException {
		try (Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT sahip, bakiye FROM hesaplar ORDER BY id")) {
			while (rs.next())
				System.out.println(rs.getString("sahip") + ": " + rs.getInt("bakiye"));
		}
	}

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:sqlite::memory:";  // bellekte, gecici
		try (Connection conn = DriverManager.getConnection(url);
				Statement st = conn.createStatement()) {
			st.execute("CREATE TABLE hesaplar (id INTEGER PRIMARY KEY, "
					+ "sahip TEXT, bakiye INTEGER CHECK (bakiye >= 0))");
			st.execute("INSERT INTO hesaplar(sahip, bakiye) "
					+ "VALUES ('Ali', 1000), ('Ece', 500)");
			havale(conn, 1, 2, 300);    // Ali -> Ece 300 TL
			havale(conn, 1, 2, 5000);   // Ali'nin parasi yetmez
			yazdir(conn);
		}
		// 300 TL aktarildi.
		// Geri alindi: 5000 TL
		// Ali: 700
		// Ece: 800
	}
}
