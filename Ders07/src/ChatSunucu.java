import java.net.*;
import java.io.*;

public class ChatSunucu {

    public static void main(String[] args) throws IOException {
        try (// Bir sunucu soketi olustur
		ServerSocket sunucuSoketi = new ServerSocket(8000)) {
			System.out.println("Sunucu baslatildi");

			// Bir baglanti istegi bekle
			Socket soket = sunucuSoketi.accept();

			// Veri alisverisi icin girdi ve cikti akislari olustur
			DataInputStream istemcidenGelenVeri = new DataInputStream(soket.getInputStream());
			DataOutputStream istemciyeGidenVeri = new DataOutputStream(soket.getOutputStream());

			while (true) {
			    // Istemciden bir mesaj oku
			    String mesaj = istemcidenGelenVeri.readUTF();

			    // Mesaji geri gonder
			    istemciyeGidenVeri.writeUTF(mesaj);
			}
		}
    }
}
