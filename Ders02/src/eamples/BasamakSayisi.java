package eamples;
import java.util.Scanner; // Kullanicidan veri girisi almak icin Scanner sinifini ice aktarir.

public class BasamakSayisi { // Ana sinif

    public static void main(String[] args) {

        // Kullanicidan bir sayi almak icin Scanner nesnesi olusturur.
        Scanner scanner = new Scanner(System.in);

        // Kullanicidan bir sayi girmesini ister. Bu sayinin basamak sayisi hesaplanir.
        System.out.println("Bir sayi giriniz:");
        int sayi = scanner.nextInt(); // Kullanicinin girdigi sayiyi okur ve 'sayi' degiskenine atar.

        // Basamak sayisini tutmak icin bir degisken tanimlar ve baslangic degerini 0 olarak belirler.
        int basamakSayisi = 0;

        // 'while' dongusu, sayinin basamaklarini saymak icin kullanilir.
        // Dongu, sayi 0'dan buyuk oldugu surece devam eder.
        while(sayi > 0) {

            // Sayinin son basamagi "sayi / 10" islemiyle silinir (ornegin 1234 -> 123).
            sayi = sayi / 10;

            // Her islemde bir basamak silindigi icin 'basamakSayisi' bir artirilir.
            basamakSayisi++;
        }

        // Sayinin kac basamaktan olustugunu ekrana yazdirir.
        System.out.println("Basamak sayisi: " + basamakSayisi);

        // Scanner nesnesini kapatir. Kaynak yonetimi acisindan onemli bir adimdir.
        scanner.close();
    }
}
