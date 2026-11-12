import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

// executeUpdate donus degerleri: her INSERT 1, UPDATE kosula uyan satir sayisi,
// hic satira uymayan DELETE 0 dondurur.
public class ExecuteUpdateDonus {
	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:");
				Statement stmt = conn.createStatement()) {
			stmt.execute("CREATE TABLE malzeme (id INTEGER PRIMARY KEY, ad TEXT, stok INTEGER)");

			String[] adlar = {"zimba", "makas", "bant"};
			int[] stok = {40, 0, 15};
			PreparedStatement ek = conn.prepareStatement(
					"INSERT INTO malzeme(ad, stok) VALUES(?, ?)");
			for (int i = 0; i < adlar.length; i++) {
				ek.setString(1, adlar[i]);
				ek.setInt(2, stok[i]);
				ek.executeUpdate();
			}
			ek.close();
			int g = stmt.executeUpdate(
					"UPDATE malzeme SET stok = stok + 10 WHERE stok < 20");
			int s = stmt.executeUpdate("DELETE FROM malzeme WHERE stok > 100");
			System.out.println(g + " guncellendi, " + s + " silindi");   // 2 guncellendi, 0 silindi
		}
	}
}

/* Beklenen cikti:
2 guncellendi, 0 silindi
*/
