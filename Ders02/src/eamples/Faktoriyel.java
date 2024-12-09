package eamples;
import java.util.Scanner; // Kullanicidan veri girisi almak icin Scanner sinifini ice aktarir.

public class Faktoriyel { // Ana sinif

    public static void main(String[] args) {

        // Kullanicidan bir sayi almak icin Scanner nesnesi olusturur.
        Scanner scanner = new Scanner(System.in);

        // Kullanicidan faktoriyelini hesaplamak icin bir sayi girmesini ister.
        System.out.println("Bir sayi giriniz:");
        int sayi = scanner.nextInt(); // Girilen sayiyi okur ve 'sayi' degiskenine atar.

        // Faktoriyel hesaplamasi icin baslangic degeri 1 olan 'faktoriyel' degiskeni tanimlanir.
        int faktoriyel = 1;

        // Kullanicinin girdigi sayiyi ekrana yazdirir.
        // Ornegin, "5" girdiyse, ekrana "5" yazdirir.
        System.out.print(sayi);

        // Faktoriyel hesaplamak icin 'while' dongusu baslatilir.
        // Dongu, sayi 0'dan buyuk oldugu surece devam eder.
        // Faktoriyel, 1'den baslayarak sayiya kadar olan tum sayilarin carpimina esitttir.
        while(sayi > 0) {

            // 'faktoriyel' degeri, her adimda o anki 'sayi' degeri ile carpilir.
            faktoriyel *= sayi;

            // Sayiyi 1 azaltarak bir sonraki sayiya gecilir.
            sayi--;
        }

        // Faktoriyel hesaplandiktan sonra sonucu ekrana yazdirir.
        // Ornegin, "5! = 120" seklinde cikti verecektir.
        System.out.println("! = " + faktoriyel);

        // Scanner nesnesini kapatir. Kaynak yonetimi acisindan onemli bir adimdir.
        scanner.close();
    }
}
