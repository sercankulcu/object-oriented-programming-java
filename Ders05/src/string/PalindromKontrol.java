package string; 
import java.util.Scanner;

public class PalindromKontrol {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Kullanicidan bir kelime veya cumle girmesini iste
        System.out.print("Bir kelime veya cumle girin: ");
        String metin = scanner.nextLine();

        scanner.close(); // Scanner'i kapat

        // Metni temizleme: Harf olmayan karakterleri kaldir ve kucuk harfe donustur
        metin = metin.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Metni ters cevirme islemini bir dongu ile yap
        String tersMetin = "";
        for (int i = metin.length() - 1; i >= 0; i--) {
            tersMetin += metin.charAt(i); // Metindeki karakterleri sondan basa dogru ekle
        }

        // Palindrom kontrolu
        if (metin.equals(tersMetin)) {
            // Eger metin ile tersMetin ayniysa palindromdur
            System.out.println("Girdi bir palindromdur.");
        } else {
            // Eger metin ile tersMetin farkliysa palindrom degildir
            System.out.println("Girdi bir palindrom degildir.");
        }
    }
}
