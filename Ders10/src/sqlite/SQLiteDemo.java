package sqlite; 
import java.sql.*;

/* 
 * Bu kod, Java'da SQLite kullanarak bir veritabani islemi yapilmasini gosterir:
 * 
 * - Veritabanina baglanir
 * - Bir tablo olusturur
 * - Veritabanina kayit ekler, gunceller ve siler
 * - Veritabanindaki tum kayitlari listeler
 * 
 * */

public class SQLiteDemo {

    public static void main(String[] args) {

        String url = "jdbc:sqlite:test.db"; // Veritabaninin baglantisi

        try (Connection conn = DriverManager.getConnection(url); 
             Statement stmt = conn.createStatement()) { // Veritabanina baglan

            // Tabloyu olustur
            String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                    + " id INTEGER PRIMARY KEY,\n"
                    + " first_name TEXT NOT NULL,\n"
                    + " last_name TEXT NOT NULL,\n"
                    + " age INTEGER NOT NULL\n"
                    + ");";
            stmt.execute(sql); // SQL komutunu calistir
            System.out.println("Tablo basariyla olusturuldu");

            // Yeni bir kayit ekle
            insertRecord(conn, "John", "Doe", 30);
            System.out.println("Kayit basariyla eklendi");

            // Yeni bir kayit ekle
            insertRecord(conn, "Mike", "Tyson", 40);
            System.out.println("Kayit basariyla eklendi");

            // Tum kayitlari listele
            selectAllRecords(conn);
            System.out.println("Tablo basariyla listelendi");

            // Var olan bir kaydi guncelle
            updateRecord(conn, "John", "Smith", 35);
            System.out.println("Kayit basariyla guncellendi");

            // Tum kayitlari listele
            selectAllRecords(conn);
            System.out.println("Tablo basariyla listelendi");

            // Bir kaydi sil
            deleteRecord(conn, "John");
            System.out.println("Kayit basariyla silindi");

            // Tum kayitlari listele
            selectAllRecords(conn);
            System.out.println("Tablo basariyla listelendi");

        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Hata olursa mesaj yazdir
        }
    }

    // Kayit ekleme metodu
    public static void insertRecord(Connection conn, String firstName, String lastName, int age) throws SQLException {
        String sql = "INSERT INTO users(first_name, last_name, age) VALUES(?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) { // SQL komutunu hazirla
            pstmt.setString(1, firstName); // Oyuncu ismini ayarla
            pstmt.setString(2, lastName);  // Soyadini ayarla
            pstmt.setInt(3, age); // Yasayi ayarla
            pstmt.executeUpdate(); // Kaydi veritabanina ekle
        }
    }

    // Kayit guncelleme metodu
    public static void updateRecord(Connection conn, String firstName, String lastName, int age) throws SQLException {
        String sql = "UPDATE users SET last_name = ?, age = ? WHERE first_name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) { // SQL komutunu hazirla
            pstmt.setString(1, lastName); // Soyadi guncelle
            pstmt.setInt(2, age); // Yasayi guncelle
            pstmt.setString(3, firstName); // Isimle ilgili kaydi bul ve guncelle
            pstmt.executeUpdate(); // Kaydi guncelle
        }
    }

    // Tum kayitlari listeleme metodu
    public static void selectAllRecords(Connection conn) throws SQLException {
        String sql = "SELECT id, first_name, last_name, age FROM users"; // Kayitlari sorgula

        try (Statement stmt = conn.createStatement()) { // SQL komutunu hazirla

            ResultSet rs = stmt.executeQuery(sql); // Sonuclari al

            while (rs.next()) { // Sonuclari gez
                System.out.println(rs.getInt("id") +  "\t" + 
                        rs.getString("first_name") + "\t" +
                        rs.getString("last_name") + "\t" +
                        rs.getInt("age")); // Kayitlari yazdir
            }
        }
    }

    // Kayit silme metodu
    public static void deleteRecord(Connection conn, String firstName) throws SQLException {
        String sql = "DELETE FROM users WHERE first_name = ?"; // Kaydi silmek icin SQL komutu
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) { // SQL komutunu hazirla
            pstmt.setString(1, firstName); // Silinecek oyuncuyu sec
            pstmt.executeUpdate(); // Kaydi sil
        }
    }
}
