package sqlite; 
import java.sql.*;
import java.util.Random;
import java.util.Scanner;

/* 
 * Bu kod, bir SQLite veritabanini baslatir ve oyuncu, puan ve basarilarini saklamak icin bir tablo olusturur. 
 * Ardindan tabloya yeni rastgele bir kayit ekler, kullanicidan veri alir ve en yuksek puana sahip 10 oyuncuyu listeler.
 * 
 * */

public class GameResults {
	
    private static final String DB_URL = "jdbc:sqlite:game.db"; // Veritabani URL'si
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS scores (name TEXT, score INTEGER, achievement TEXT)"; // Tablo olusturma SQL sorgusu
    private static final String INSERT_SCORE_SQL = "INSERT INTO scores (name, score, achievement) VALUES (?, ?, ?)"; // Yeni puan ve basari ekleme SQL sorgusu
    private static final String SELECT_HIGH_SCORES_SQL = "SELECT * FROM scores ORDER BY score DESC LIMIT ?"; // Yuksek puanlari sorgulama SQL sorgusu
    private static Random random = new Random(); // Rastgele sayi uretici
    private static Scanner scanner = new Scanner(System.in); // Kullanici girdi alici

    public static void main(String[] args) {
        // Veritabanini baslat ve 'scores' tablosunu olustur
        try (Connection conn = DriverManager.getConnection(DB_URL); // Veritabanina baglan
        		Statement stmt = conn.createStatement()) { // SQL komutlari calistirmak icin statement olustur
            stmt.execute(CREATE_TABLE_SQL); // Tabloyu olustur
        } catch (SQLException e) {
            e.printStackTrace(); // Hata olursa yazdir
        }
        
        // Veritabanina rastgele oyuncu adi, puan ve basari ekle
        for (int i = 0; i < 5; i++) { // 5 oyuncu icin rastgele puanlar ve basarilar ekle
            try (Connection conn = DriverManager.getConnection(DB_URL); // Veritabanina baglan
            		PreparedStatement pstmt = conn.prepareStatement(INSERT_SCORE_SQL)) { // SQL komutunu hazirla
                String name = "player" + (i + 1); // Oyuncu adi ("player1", "player2", ...)
                int score = random.nextInt(100); // Rastgele bir puan (0-99 arasinda)
                String achievement = getRandomAchievement(); // Rastgele bir basari al
                pstmt.setString(1, name); // Oyuncunun adini ayarla
                pstmt.setInt(2, score); // Puani ayarla
                pstmt.setString(3, achievement); // Basariyi ayarla
                pstmt.executeUpdate(); // Veriyi ekle
                System.out.println("Yeni kayit eklendi: " + name + " - Puan: " + score + " - Basari: " + achievement); // Eklenen veriyi yazdir
            } catch (SQLException e) {
                e.printStackTrace(); // Hata olursa yazdir
            }
        }

        // Kullanici yeni oyuncu eklemek isterse
        System.out.print("Yeni oyuncu eklemek ister misiniz? (E/H): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("E")) {
            System.out.print("Oyuncu ismi girin: ");
            String name = scanner.nextLine();
            System.out.print("Puan girin: ");
            int score = scanner.nextInt();
            scanner.nextLine(); // Bosluk karakterini temizle
            String achievement = getRandomAchievement(); // Rastgele basari ekle
            
            try (Connection conn = DriverManager.getConnection(DB_URL); // Veritabanina baglan
            		PreparedStatement pstmt = conn.prepareStatement(INSERT_SCORE_SQL)) { // SQL komutunu hazirla
                pstmt.setString(1, name); // Oyuncu adi
                pstmt.setInt(2, score); // Puan
                pstmt.setString(3, achievement); // Basari
                pstmt.executeUpdate(); // Veriyi ekle
                System.out.println("Yeni oyuncu eklendi: " + name + " - Puan: " + score + " - Basari: " + achievement);
            } catch (SQLException e) {
                e.printStackTrace(); // Hata olursa yazdir
            }
        }
        
        // Veritabanindan en yuksek puanli 10 kayidi al
        try (Connection conn = DriverManager.getConnection(DB_URL); // Veritabanina baglan
        		PreparedStatement pstmt = conn.prepareStatement(SELECT_HIGH_SCORES_SQL)) { // SQL komutunu hazirla
            pstmt.setInt(1, 10); // Sadece 10 kayit al
            ResultSet rs = pstmt.executeQuery(); // Sonuclari al
            System.out.println("\nEn yuksek 10 puan: ");
            while (rs.next()) { // Sonuclar uzerinde don
                String name = rs.getString("name"); // Oyuncunun adini al
                int score = rs.getInt("score"); // Puani al
                String achievement = rs.getString("achievement"); // Basariyi al
                System.out.println(name + ": " + score + " - Basari: " + achievement); // Puan ve basariyi ekrana yazdir
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Hata olursa yazdir
        }
    }
    
    // Rastgele bir basari mesaji
    private static String getRandomAchievement() {
        String[] achievements = {
            "Yeni Baslayan",
            "Buyuk Zafer",
            "Efsane Oyuncu",
            "Hizli Dusunen",
            "Oyun Ustasi"
        };
        return achievements[random.nextInt(achievements.length)]; // Rastgele bir basari sec
    }
}
