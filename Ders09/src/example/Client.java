package example;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public static void main(String args[]) {
        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;
        BufferedReader reader = null;

        try {
            // Sunucuya baglanmaya calis
            System.out.println("Sunucuya baglanmaya calisiliyor...");
            socket = new Socket("localhost", 4444);
            System.out.println("Sunucuya basariyla baglanildi!");

            // Sunucudan ve kullanicidan veri almak icin
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(System.in));

            String str = ""; // Kullanici tarafindan gonderilecek mesaj
            String str2 = ""; // Sunucudan alinan mesaj

            // Kullanici "stop" yazana kadar donguyu devam ettir
            while (!str.equals("stop")) {
                System.out.print("Sunucuya gondermek icin bir mesaj girin: ");
                str = reader.readLine(); // Kullanici girdisini oku
                output.writeUTF(str); // Sunucuya mesaj gonder
                output.flush(); // Gonderilen mesajlari temizle

                // Sunucudan mesaj al
                str2 = input.readUTF();
                System.out.println("Sunucudan gelen mesaj: " + str2);
            }

        } catch (Exception e) {
            System.err.println("Bir hata olustu: " + e.getMessage());
            e.printStackTrace(); // Hata detaylarini konsola yazdir
        } finally {
            try {
                // Kaynaklari kapat
                if (input != null) 
                	input.close();
                if (output != null) 
                	output.close();
                if (reader != null) 
                	reader.close();
                if (socket != null) 
                	socket.close();
                System.out.println("Baglanti kapatildi.");
            } catch (Exception e) {
                System.err.println("Kaynaklar kapatilirken bir hata olustu: " + e.getMessage());
            }
        }
    }
}
