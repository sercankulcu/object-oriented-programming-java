package string;

import java.util.Random;
import java.util.Scanner;

public class RastgeleKarakterYazdirma {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Kullanicidan bir kelime girmesini iste
        System.out.println("Bir kelime giriniz:");
        String kelime = scanner.nextLine();

        // Eger kelime bossa hata mesaji yazdir ve programi sonlandir
        if (kelime.isEmpty()) {
            System.out.println("Kelime bos olamaz.");
            scanner.close();
            return;
        }

        // Kullanicidan kac karakter secilecegini sor
        System.out.println("Kac rastgele karakter secmek istersiniz?");
        int karakterSayisi = scanner.nextInt();
        
        scanner.close();

        // Eger kullanicidan girilen sayi gecersizse hata mesaji yazdir
        if (karakterSayisi <= 0 || karakterSayisi > kelime.length()) {
            System.out.println("Gecersiz karakter sayisi. 1 ile " + kelime.length() + " arasinda bir sayi giriniz.");
            return;
        }

        // Rastgele karakterleri sec ve ekrana yazdir
        System.out.println("Secilen rastgele karakterler:");
        boolean[] secilenindeksler = new boolean[kelime.length()];
        for (int i = 0; i < karakterSayisi; i++) {
            int indeks;
            // Ayni karakterin tekrar secilmemesi icin döngu
            do {
                indeks = random.nextInt(kelime.length());
            } while (secilenindeksler[indeks]);

            secilenindeksler[indeks] = true;
            System.out.println("indeks " + indeks + ": " + kelime.charAt(indeks));
        }

        // Kullaniciya istatistik göster
        System.out.println("\nKelimenin uzunlugu: " + kelime.length());
        System.out.println("Secilen karakter sayisi: " + karakterSayisi);
    }
}
