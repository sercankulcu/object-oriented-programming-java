import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Bu kod basit bir bilgi yarismasi oyunudur. Sorular ve cevaplar bir metin dosyasindan 
 * okunur (sorular.txt). Oyuncuya sorular sorulur ve dogru cevabi tahmin etmesi 
 * beklenir. Oyuncunun her soru icin 3 deneme hakki vardir. Oyun sonunda oyuncunun 
 * dogru ve yanlis cevap sayisi ekrana yazdirilir.
 *
 * questions.txt dosyasinda her soru ve cevap, iki nokta ust uste (:) ile ayrilmalidir.
 */

public class BilgiYarismasi {

    public static void main(String[] args) {

        int toplamSoruSayisi = 0;
        int dogruCevaplar = 0;

        // Sorulari ve cevaplari metin dosyasindan oku
        try (BufferedReader reader = new BufferedReader(new FileReader("sorular.txt"))) {
            String satir;
            Scanner scanner = new Scanner(System.in);

            while ((satir = reader.readLine()) != null) {
                toplamSoruSayisi++;

                // Soruyu ve cevabi iki nokta ust uste (:) ile ayir
                String[] parcalar = satir.split(":");
                String soru = parcalar[0];
                String cevap = parcalar[1];

                // Oyuncudan tahmin yapmasini iste
                System.out.println(soru);
                for (int i = 0; i < 3; i++) { // 3 tahmin hakki
                    System.out.print("Tahmininizi girin: ");
                    String tahmin = scanner.nextLine();

                    if (tahmin.equalsIgnoreCase(cevap)) { // Dogru cevabi kontrol et
                        System.out.println("Dogru!");
                        dogruCevaplar++;
                        break;
                    } else {
                        if(i == 2) { // son hak
                        	System.out.println("Dogru cevap: " + cevap);	
                        } else {
                        	System.out.println("Yanlis. Tekrar deneyin.");
                        }
                    }
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Dosyadan okuma sirasinda hata: " + e.getMessage());
        }

        // Oyuncunun skorunu ekrana yazdir
        System.out.println("Dogru cevaplar: " + dogruCevaplar);
        System.out.println("Yanlis cevaplar: " + (toplamSoruSayisi - dogruCevaplar));
    }
}
