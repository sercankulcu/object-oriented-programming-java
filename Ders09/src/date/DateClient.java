package date; 
import java.util.Scanner;
import java.net.Socket;
import java.io.IOException;

public class DateClient {
    public static void main(String[] args) throws IOException {

        // Sunucuya baglanmak icin "localhost" adresini ve 59090 portunu kullan
        try (var socket = new Socket("localhost", 59090)) { 
            var in = new Scanner(socket.getInputStream()); // Sunucudan gelen veriyi okumak icin Scanner nesnesi
            System.out.println("Sunucu yaniti: " + in.nextLine()); // Sunucudan gelen mesaji ekrana yazdir
        }
    }
}
