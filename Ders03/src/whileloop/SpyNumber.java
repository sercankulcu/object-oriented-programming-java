// Spy Numbers: Basamaklarinin toplami, basamaklarinin carpimina esit olan sayilardir.
package whileloop;

import java.util.Scanner;

public class SpyNumber {
	
    public static void main(String[] args) {
    	
        // Kullanicidan bir sayi girdisi al
        Scanner tarayici = new Scanner(System.in);
        System.out.print("Bir sayi giriniz: ");
        int sayi = tarayici.nextInt();

        // Basamak toplami ve carpimi icin degiskenler
        int basamakToplami = 0;
        int basamakCarpimi = 1;
        int gecici = sayi; // Sayiyi gecici bir degiskende tut

        // Sayinin basamaklarini ayristir
        while (gecici > 0) {
            int basamak = gecici % 10; // Son basamagi al
            basamakToplami += basamak; // Basamaklari toplama ekle
            basamakCarpimi *= basamak; // Basamaklari carpima ekle
            gecici /= 10; // Son basamagi cikar
        }

        // Spy Number kontrolu yap
        if (basamakToplami == basamakCarpimi) {
            System.out.println(sayi + " bir Spy Number'dir.");
        } else {
            System.out.println(sayi + " bir Spy Number degildir.");
        }

        tarayici.close(); // Kaynaklari serbest birak
    }
}
