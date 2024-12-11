package mysql; 

import java.sql.*;
import java.util.Scanner;

public class MySQLDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // MySQL surucusunu kaydet
        Class.forName("com.mysql.jdbc.Driver");

        // Veritabanina baglanti olustur
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             Scanner scanner = new Scanner(System.in)) {

            // Kullanicidan islem tipi al
            System.out.println("Yapmak istediginiz islemi secin: ");
            System.out.println("1 - Yeni kayit ekle");
            System.out.println("2 - Kayit guncelle");
            System.out.println("3 - Kayit sil");
            System.out.println("4 - Tum kayitlari listele");
            System.out.print("Seciminizi yapin: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Bu satir, 'nextInt' sonrasi gelen '\n' karakterini temizler

            switch (choice) {
                case 1:
                    // Yeni bir kayit ekle
                    System.out.print("Adinizi girin: ");
                    String name = scanner.nextLine();
                    System.out.print("Email adresinizi girin: ");
                    String email = scanner.nextLine();
                    String insertSql = "iNSERT iNTO users (name, email) VALUES (?, ?)";
                    try (PreparedStatement pstmt = connection.prepareStatement(insertSql)) {
                        pstmt.setString(1, name);
                        pstmt.setString(2, email);
                        pstmt.executeUpdate();
                        System.out.println("Yeni kayit basariyla eklendi.");
                    }
                    break;

                case 2:
                    // Var olan bir kaydi guncelle
                    System.out.print("Guncellemek istediginiz kullanicinin iD'sini girin: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // 'nextInt' sonrasi gelen '\n' karakterini temizler
                    System.out.print("Yeni ad girin: ");
                    String newName = scanner.nextLine();
                    System.out.print("Yeni email adresi girin: ");
                    String newEmail = scanner.nextLine();
                    String updateSql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
                    try (PreparedStatement pstmt = connection.prepareStatement(updateSql)) {
                        pstmt.setString(1, newName);
                        pstmt.setString(2, newEmail);
                        pstmt.setInt(3, idToUpdate);
                        int rowsUpdated = pstmt.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println("Kullanici guncellendi.");
                        } else {
                            System.out.println("Kullanici bulunamadi.");
                        }
                    }
                    break;

                case 3:
                    // Bir kaydi sil
                    System.out.print("Silmek istediginiz kullanicinin iD'sini girin: ");
                    int idToDelete = scanner.nextInt();
                    String deleteSql = "DELETE FROM users WHERE id = ?";
                    try (PreparedStatement pstmt = connection.prepareStatement(deleteSql)) {
                        pstmt.setInt(1, idToDelete);
                        int rowsDeleted = pstmt.executeUpdate();
                        if (rowsDeleted > 0) {
                            System.out.println("Kullanici silindi.");
                        } else {
                            System.out.println("Kullanici bulunamadi.");
                        }
                    }
                    break;

                case 4:
                    // Tum kayitlari listele
                    String selectSql = "SELECT * FROM users";
                    try (ResultSet resultSet = statement.executeQuery(selectSql)) {
                        while (resultSet.next()) {
                            int id = resultSet.getInt("id");
                            String userName = resultSet.getString("name");
                            String userEmail = resultSet.getString("email");
                            System.out.println("iD: " + id + ", Name: " + userName + ", Email: " + userEmail);
                        }
                    }
                    break;

                default:
                    System.out.println("Gecersiz secim.");
            }
        }
    }
}
