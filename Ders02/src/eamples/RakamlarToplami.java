package eamples;
import java.util.Scanner; // Kullanicidan veri girisi almak icin Scanner sinifini ice aktarir.

public class RakamlarToplami { // Ana sinif

    public static void main(String[] args) {

        // Kullanicidan giris almak icin Scanner nesnesi olusturur.
        Scanner scanner = new Scanner(System.in);

        // Kullanicidan bir sayi girmesini ister.
        System.out.println("Bir sayi giriniz:");

        // Kullanicinin girdigi sayiyi okur ve 'sayi' degiskenine atar.
        int sayi = scanner.nextInt();

        // Rakamlarin toplamini tutmak icin 'rakamlarToplami' adinda bir degisken olusturur, baslangic degeri 0'dir.
        int rakamlarToplami = 0;

        // Sayinin basamaklarini tek tek almak icin bir dongu baslatir.
        // Dongu, 'sayi' 0'dan buyuk oldugu surece devam eder.
        while(sayi > 0) {

            // Sayinin son basamagini almak icin 10'a gore mod (kalan) islemi yapilir.
            int rakam = sayi % 10;

            // Alinan basamak degeri 'rakamlarToplami' degiskenine eklenir.
            rakamlarToplami += rakam;

            // Sayinin son basamagini silmek icin sayi 10'a bolunur.
            // Bu islemlerle sayinin bir basamagi eksilir.
            sayi = sayi / 10;
        }

        // Sonuc olarak rakamlarin toplamini ekrana yazdirir.
        System.out.println("Rakamlar toplami: " + rakamlarToplami);

        // Scanner nesnesini kapatir. Kaynak yonetimi acisindan onemli bir adimdir.
        scanner.close(); 
    }
}
