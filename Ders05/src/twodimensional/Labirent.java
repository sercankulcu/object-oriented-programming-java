package twodimensional;

import java.util.Random;

/*
 * Rastgele bir labirent olusturur:
 * 
 * Program, iki boyutlu bir diziyi rastgele olarak duvarlar ('#') ve yollar ('.') ile doldurarak bir labirent olusturur. 
 */

public class Labirent {
    private static final int GENISLIK = 10; // Labirentin genisligi
    private static final int YUKSEKLIK = 10; // Labirentin yuksekligi
    private static final char DUVAR = '#'; // Duvarlari temsil eden karakter
    private static final char YOL = '.'; // Yollari temsil eden karakter

    private static char[][] labirent; // Labirenti tutan iki boyutlu dizi
    
    public static void main(String[] args) {
        // Rastgele labirent olustur
        labirent = labirentOlustur();
        
        // Labirenti yazdir
        labirentiYazdir();
    }

    // Rastgele bir labirent olusturan metod
    private static char[][] labirentOlustur() {
        Random rastgele = new Random(); // Rastgele sayi uretici
        char[][] labirent = new char[YUKSEKLIK][GENISLIK];

        // Her hucreyi rastgele olarak duvar ya da yol yap
        for (int y = 0; y < YUKSEKLIK; y++) {
            for (int x = 0; x < GENISLIK; x++) {
                labirent[y][x] = rastgele.nextDouble() < 0.3 ? DUVAR : YOL; // %30 ihtimalle duvar
            }
        }

        return labirent;
    }

    // Labirenti ekrana yazdiran metod
    private static void labirentiYazdir() {
        for (int y = 0; y < YUKSEKLIK; y++) {
            for (int x = 0; x < GENISLIK; x++) {
                System.out.print(labirent[y][x] + " ");
            }
            System.out.println(); // Her satirdan sonra yeni bir satir baslat
        }
    }
}
