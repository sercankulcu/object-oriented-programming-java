package eamples;
import java.util.Scanner; // Kullanicidan veri girisi almak icin Java'nin Scanner sinifini ice aktarir.

public class TekMiCiftMi { // Programin ana sinifi.

    public static void main(String[] args) { // Programin calismaya basladigi ana fonksiyon.

        // Kullanicidan sayi almak icin Scanner nesnesi olusturur.
        Scanner scanner = new Scanner(System.in); 

        // Kullanicidan bir sayi girmesini ister.
        System.out.println("Bir sayi giriniz:");

        // Kullanicinin girdigi sayiyi okur ve 'sayi' degiskenine atar.
        int sayi = scanner.nextInt(); 

        // Girilen sayinin tek mi cift mi oldugunu kontrol eden kosul yapisi.
        // Modulus (%) operatoru ile sayinin 2'ye bolumunden kalan kontrol edilir.
        // Eger kalan 1 ise sayi tektir.
        if(sayi % 2 == 1) {
            // Eger sayi tektir, bu mesaj ekrana yazdirilir.
            System.out.println("Girilen sayi tektir.");
        }
        // Eger sayi teklik sartini saglamazsa, sayi cifttir.
        else {
            // Eger sayi cifttir, bu mesaj ekrana yazdirilir.
            System.out.println("Girilen sayi cifttir.");
        }

        // Scanner objesini kapatir, bu islem kaynaklari serbest birakir.
        scanner.close(); 
    }
}
