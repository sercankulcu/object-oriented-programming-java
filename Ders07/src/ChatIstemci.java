import java.net.*;
import java.io.*;
import java.util.Scanner;

/*
 * Bu kod, Java'da soketler kullanarak temel bir sohbet uygulamasının örneğidir:
 * 
 * */

public class ChatIstemci {

    public static void main(String[] args) throws IOException {
        // Bir soket olustur
        Socket soket = new Socket("localhost", 8000);

        // Veri alisverisi icin girdi ve cikti akislari olustur
        DataInputStream sunucudanGelenVeri = new DataInputStream(soket.getInputStream());
        DataOutputStream sunucuyaGidenVeri = new DataOutputStream(soket.getOutputStream());

        // Konsoldan veri okumak icin bir scanner olustur
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Konsoldan bir mesaj oku
            String mesaj = scanner.nextLine();

            // Mesaji sunucuya gonder
            sunucuyaGidenVeri.writeUTF(mesaj);

            // Sunucudan gelen mesajı oku
            mesaj = sunucudanGelenVeri.readUTF();

            // Mesaji ekranda goster
            System.out.println(mesaj);
        }
    }
}
