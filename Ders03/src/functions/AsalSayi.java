package functions; 
import java.util.Scanner;  // Kullanicidan girdi almak icin Scanner sinifini projeye aktar.

public class AsalSayi {
    
    // 'asalMi' metodu bir sayinin asal olup olmadigini kontrol eder.
    boolean asalMi(int sayi) {
        // 2'den baslayarak sayinin kendisinden bir kucuk sayiya kadar tam bolunebilir olup olmadigini kontrol et.
        for(int i = 2; i < sayi; i++) {
            // Eger sayi herhangi bir 'i' degerine tam bolunuyorsa, asal degildir.
            if(sayi % i == 0) {
                return false;  // Sayi asal degil, false doner
            }
        }
        // Eger dongu sonunda hic bolunen olmadiysa, sayi asaldir.
        return true;
    }

    // 'sonrakiAsalSayi' metodu, kullanicinin girdigi sayidan sonraki ilk asal sayiyi bulur.
    int sonrakiAsalSayi(int sayi) {
        // Sayiyi bir arttir, ve asal olup olmadigini kontrol et.
        while(!asalMi(++sayi)) {
            // Asal degilse, bir arttirip tekrar kontrol et.
        }
        return sayi;  // Sonraki asal sayi bulunur ve doner.
    }
    
    // 'oncekiAsalSayi' metodu, kullanicinin girdigi sayidan onceki ilk asal sayiyi bulur.
    int oncekiAsalSayi(int sayi) {
        // Sayiyi bir azalt, ve asal olup olmadigini kontrol et.
        while(!asalMi(--sayi)) {
            // Asal degilse, bir azaltip tekrar kontrol et.
        }
        return sayi;  // Onceki asal sayi bulunur ve doner.
    }

    public static void main(String[] args) {
        
        // Kullanicidan girdi almak icin Scanner sinifindan nesne olustur
        Scanner okuyucu = new Scanner(System.in);
        
        // Kullanicidan bir sayi girmesini iste
        System.out.println("Lutfen bir sayi giriniz");
        int sayi = okuyucu.nextInt();  // Kullanicinin girdigi sayi alinir
        
        // AsalSayi sinifindan bir nesne olustur
        AsalSayi bulucu = new AsalSayi();
        
        // Girilen sayinin asal olup olmadigini kontrol et ve sonucu yazdir
        if (bulucu.asalMi(sayi)) {
            System.out.println(sayi + " sayisi asaldir.");
        } else {
            System.out.println(sayi + " sayisi asal degildir.");
        }
        
        // Girilen sayidan sonraki ilk asal sayiyi bul ve yazdir
        System.out.println("Sonraki asal sayi: " + bulucu.sonrakiAsalSayi(sayi));
        
        // Girilen sayidan onceki ilk asal sayiyi bul ve yazdir
        System.out.println("Onceki asal sayi: " + bulucu.oncekiAsalSayi(sayi));
        
        // Scanner nesnesini kapat, kaynaklari isletim sistemine geri ver.
        okuyucu.close();
    }
}
