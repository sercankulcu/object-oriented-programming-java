import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

// Toplu islem: addBatch ile 1000 INSERT biriktirilir, executeBatch ile tek seferde
// gonderilir ve tek commit ile kalici yapilir.
public class TopluIslem {
	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:")) {
			try (Statement st = conn.createStatement()) {
				st.execute("CREATE TABLE olcumler (id INTEGER PRIMARY KEY, deger INTEGER)");
			}

			conn.setAutoCommit(false);
			try (PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO olcumler(deger) VALUES(?)")) {
				for (int i = 1; i <= 1000; i++) {
					ps.setInt(1, i);
					ps.addBatch();
				}
				int[] sonuc = ps.executeBatch();
				conn.commit();
				System.out.println(sonuc.length + " komut, ilki "
						+ sonuc[0] + " satir etkiledi");   // 1000 komut, ilki 1 satir etkiledi
			} catch (SQLException e) {
				conn.rollback();
			}
			conn.setAutoCommit(true);
		}
	}
}
