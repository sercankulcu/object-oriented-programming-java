package eamples;
import java.util.Scanner;

public class Toplama {
	
    public static void main(String[] args) {
        // Kullanicidan veri almak icin Scanner nesnesi olusturur.
        Scanner scanner = new Scanner(System.in);

        // Birinci sayiyi girmesini ister.
        System.out.print("Birinci sayiyi girin: ");
        double sayi1 = scanner.nextDouble(); // Kullanicinin girdigi ilk sayiyi okur.

        // Ikinci sayiyi girmesini ister.
        System.out.print("Ikinci sayiyi girin: ");
        double sayi2 = scanner.nextDouble(); // Kullanicinin girdigi ikinci sayiyi okur.

        // Iki sayinin toplamini hesaplar.
        double toplam = sayi1 + sayi2;

        // Sonucu ekrana yazdirir.
        System.out.println("Sonuc: " + toplam);

        // Scanner nesnesini kapatir. Kaynaklari serbest birakir.
        scanner.close();
    }
}
