package collections;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    // Fibonacci dizisini iteratif olarak bulan metod
    public static int fibonacci(int sayi) {
        // Fibonacci sayilarini tutacak liste olustur
        List<Integer> liste = new ArrayList<>();
        // Ilk iki Fibonacci sayisini listeye ekle
        liste.add(0);
        liste.add(1);
        // Fibonacci dizisini iteratif olarak hesapla
        for (int i = 2; i < sayi + 1; i++) {
            // Önceki iki sayinin toplamini listeye ekle
            liste.add(liste.get(i - 2) + liste.get(i - 1));
        }
        // Istenen Fibonacci sayisini geri dondur
        return liste.get(sayi);
    }
    
    public static void main(String[] args) {
        
        // 10. Fibonacci sayisini hesapla
        int sonuc = fibonacci(10);
        // Sonucu ekrana yazdir
        System.out.println(sonuc);
    }
}
