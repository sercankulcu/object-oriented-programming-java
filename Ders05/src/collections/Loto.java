package collections;
import java.util.ArrayList;
import java.util.Collections;

public class Loto {

    // Loto cekilisi yapan metod
    public static Integer[] lotoYap(int toplamSayi, int cekilecekSayi) {
        // Sayilari tutacak bir ArrayList olustur
        ArrayList<Integer> sayilar = new ArrayList<Integer>();
        
        // 1'den toplamSayi'ya kadar sayilari listeye ekle
        for (int i = 0; i < toplamSayi; i++) {
            sayilar.add(i + 1);
        }

        // Sayilari karistir
        Collections.shuffle(sayilar);

        // Cekilecek sayi kadar elemani yeni bir Integer dizisine kopyala
        Integer[] cekilenSayilar = new Integer[cekilecekSayi];
        for (int i = 0; i < cekilecekSayi; i++) {
            cekilenSayilar[i] = sayilar.get(i);
        }

        return cekilenSayilar;
    }

    public static void main(String[] args) {
        // 49 sayidan 6 tane cekilis sonucu al
        Integer[] sonuc = lotoYap(49, 6);
        
        // Sonuclari ekrana yazdir
        for (Integer item : sonuc) {
            System.out.print(item + " ");
        }
    }
}
