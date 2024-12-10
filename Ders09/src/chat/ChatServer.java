package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.Executors;

public class ChatServer {

    // Tum client isimlerini saklar, boylece tekrar eden isimler engellenebilir.
    private static Set<String> names = new HashSet<>();

    // Tum client'lar icin PrintWriter'lari saklar, yayini yapmak icin kullanilir.
    private static Set<PrintWriter> writers = new HashSet<>();

    // Main metod, server'i baslatir
    public static void main(String[] args) throws Exception {
        System.out.println("Chat server calisiyor...");
        var pool = Executors.newFixedThreadPool(500); // 500 thread'lik bir havuz olusturur
        
        try (var listener = new ServerSocket(59001)) { // Sunucuyu dinlemeye baslar
            System.out.println(listener.getInetAddress().toString());
            while (true) {
                // Her client baglantisi icin yeni bir thread baslatir
                pool.execute(new Handler(listener.accept()));
            }
        }
    }

    // Handler sinifi, her client icin yeni bir thread olarak calisir
    private static class Handler implements Runnable {
        private String name; // Client'in adi
        private Socket socket; // Client ile baglanti icin socket
        private PrintWriter out; // Client'a mesaj gondermek icin PrintWriter

        public Handler(Socket socket) {
            this.socket = socket;
        }

        // Her bir client icin run metodu calistirilir
        public void run() {
            try (var in = new Scanner(socket.getInputStream())) { // Client'tan gelen veriyi okur
                out = new PrintWriter(socket.getOutputStream(), true); // Client'a veri gondermek icin cikti stream'i

                // Kullanicidan benzersiz bir isim alana kadar istek yapmaya devam et.
                while (true) {
                    out.println("SUBMITNAME"); // isim iste
                    name = in.nextLine(); // Kullanicinin ismini al
                    if (name == null) {
                        return; // isim bossa cik
                    }
                    synchronized (names) { // Erisim kontrolu icin synchronized
                        // Eger isim bos degilse ve daha once alinmamissa, ismi kabul et
                        if (!name.isBlank() && !names.contains(name)) {
                            names.add(name); // isimleri ekle
                            break; // Donguden cik
                        }
                    }
                }

                out.println("NAMEACCEPTED " + name); // isim kabul edildi mesajini gonder
                // Tum client'lara, yeni bir kullanicinin katildigini bildir
                for (PrintWriter writer : writers) {
                    writer.println("MESSAGE " + name + " katildi");
                }
                writers.add(out); // Yeni client'in PrintWriter'ini ekle

                // Client'tan gelen mesajlari al ve yayini yap.
                while (true) {
                    String input = in.nextLine(); // Client'tan mesaj al
                    if (input.toLowerCase().startsWith("/quit")) { // "/quit" komutunu gorurse cik
                        return;
                    }
                    // Mesaji tum client'lara yayinla
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + ": " + input);
                    }
                }
            } catch (Exception e) {
                System.out.println(e); // Hata mesajini yazdir
            } finally {
                // Baglanti sonlandiginda kaynaklari temizle
                if (out != null) {
                    writers.remove(out); // cikis yapan client'in PrintWriter'ini listeden cikar
                }
                if (name != null) {
                    System.out.println(name + " ayriliyor"); // Client'in ayrildigini konsola yaz
                    names.remove(name); // isimler listesinden cikar
                    // Tum client'lara, bu kullanicinin ayrildigini bildir
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + " ayrildi");
                    }
                }
                try {
                    socket.close(); // Socket'i kapat
                } catch (IOException e) {
                    System.out.println("Socket kapatilirken hata: " + e.getMessage()); // Socket kapanirken hata olursa mesaj yaz
                }
            }
        }
    }
}
