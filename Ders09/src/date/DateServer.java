package date; 
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Date;

public class DateServer {
	
    public static void main(String[] args) throws IOException {
    	
        try (var listener = new ServerSocket(59090)) { // ServerSocket nesnesi olustur, 59090 portunda dinler
            System.out.println("Tarih sunucusu calisiyor..."); // Serverin calistigini ekrana yazdir
            
            while (true) { // Sonsuz dongu, her yeni baglanti icin islem yapacak
                try (var socket = listener.accept()) { // Bir client baglantisi kabul et
                    var out = new PrintWriter(socket.getOutputStream(), true); // Cikti akisini olustur
                    out.println(new Date().toString()); // Client'a bugunun tarihini gonder
                }
            }
        }
    }
}
