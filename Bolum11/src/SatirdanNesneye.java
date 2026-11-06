import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Satirlari nesnelere donusturme: sorgu sonucundaki her satirdan bir Ogrenci nesnesi
// olusturulur; metot satir degil List<Ogrenci> dondurur.
public class SatirdanNesneye {

	static class Ogrenci {
		private final int id;
		private final String ad;
		Ogrenci(int id, String ad) {
			this.id = id;
			this.ad = ad;
		}
		public String toString() {
			return "#" + id + " " + ad;
		}
	}

	static List<Ogrenci> bolumdekiler(Connection conn,
			int bolum) throws SQLException {
		List<Ogrenci> liste = new ArrayList<>();
		String sql = "SELECT id, ad FROM ogrenciler "
				+ "WHERE bolum_id = ? ORDER BY id";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, bolum);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					liste.add(new Ogrenci(rs.getInt("id"),
							rs.getString("ad")));
				}
			}
		}
		return liste;
	}

	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:")) {
			OkulVeritabani.olustur(conn);
			// main icinde:
			List<Ogrenci> liste = bolumdekiler(conn, 1);
			for (Ogrenci o : liste) System.out.println(o);
			// #1 Ada
			// #3 Cem
		}
	}
}
