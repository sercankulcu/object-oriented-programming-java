// Digital Root: Bir sayinin basamaklarini tekrarli olarak toplar ve tek bir basamak kalana kadar devam eder.
package whileloop;

import java.util.Scanner;

public class DijitalKok {
	
    public static void main(String[] args) {
    	
        // Kullanicidan bir sayi girdisi al
        Scanner tarayici = new Scanner(System.in);
        System.out.print("Bir sayi giriniz: ");
        int sayi = tarayici.nextInt();

        // Dijital kok hesaplama
        int dijitalKok = sayi;

        // Tek basamak kalana kadar dongu
        while (dijitalKok >= 10) {
            int gecici = dijitalKok; // Gecici degisken
            int toplam = 0; // Basamak toplami

            // Basamaklari toplama islemi
            while (gecici > 0) {
                toplam += gecici % 10; // Son basamagi toplama ekle
                gecici /= 10; // Son basamagi cikar
            }

            dijitalKok = toplam; // Yeni dijital kok degerini guncelle
        }

        // Sonuc yazdir
        System.out.println("Dijital kok: " + dijitalKok);

        tarayici.close(); // Kaynaklari serbest birak
    }
}
