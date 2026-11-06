import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// SQL enjeksiyonu: kullanici girdisi SQL metnine yapistirilirsa kosul degisir ve butun satirlar
// doner; PreparedStatement girdiyi yalnizca deger olarak gonderir.
public class SqlEnjeksiyonu {

	static int say(ResultSet rs) throws SQLException {
		int n = 0;
		while (rs.next()) n++;
		rs.close();
		return n;
	}

	// SQL Enjeksiyonu
	static void enjeksiyon(Connection conn, Statement stmt) throws SQLException {
		String girdi = "x' OR '1'='1";   // kullanicinin yazdigi "ad"

		// TEHLIKELI: girdi SQL metnine yapistiriliyor
		String sql = "SELECT ad FROM kisiler WHERE ad = '"
				+ girdi + "'";
		System.out.println(sql);
		ResultSet rs1 = stmt.executeQuery(sql);
		System.out.println("Birlestirme: " + say(rs1) + " satir");

		// GUVENLI: girdi yalnizca deger olarak gonderiliyor
		PreparedStatement ps = conn.prepareStatement(
				"SELECT ad FROM kisiler WHERE ad = ?");
		ps.setString(1, girdi);
		ResultSet rs2 = ps.executeQuery();
		System.out.println("PreparedStatement: " + say(rs2) + " satir");
		ps.close();
		// SELECT ad FROM kisiler WHERE ad = 'x' OR '1'='1'
		// Birlestirme: 3 satir
		// PreparedStatement: 0 satir
	}

	// SQL Enjeksiyonu: Kod Izleme
	static void izleme(Connection conn, Statement stmt) throws SQLException {
		String girdi = "x' OR '1'='1";
		String sql = "SELECT ad FROM kisiler WHERE ad = '"
				+ girdi + "'";
		int n = 0;
		try (ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) n++;
		}
		System.out.println("Birlestirme: " + n + " satir");
		PreparedStatement ps = conn.prepareStatement(
				"SELECT ad FROM kisiler WHERE ad = ?");
		ps.setString(1, girdi);
		n = 0;
		try (ResultSet rs = ps.executeQuery()) { while (rs.next()) n++; }
		System.out.println("PreparedStatement: " + n + " satir");
		ps.close();
		// Birlestirme: 3 satir
		// PreparedStatement: 0 satir
	}

	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:");
				Statement stmt = conn.createStatement()) {
			stmt.execute("CREATE TABLE kisiler (id INTEGER PRIMARY KEY, ad TEXT)");
			stmt.executeUpdate("INSERT INTO kisiler(ad) VALUES ('Ali'), ('Ayse'), ('Can')");
			enjeksiyon(conn, stmt);
			izleme(conn, stmt);
		}
	}
}
