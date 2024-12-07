package functions; 
import java.util.Scanner;  // Kullanicidan girdi almak icin Scanner sinifini ice aktar

public class Faktoriyel {

    // 'faktoriyelAl' metodu, verilen sayinin faktoriyelini hesaplar
    int faktoriyelAl(int sayi) {
        int sonuc = 1;  // Faktoriyel sonucunu tutacak degisken, baslangicta 1 olmali
        // Sayi 0'dan buyuk oldugu surece dongu devam eder
        while(sayi > 0) {
            // Sonuc degiskenini her adimda sayi ile carp
            sonuc *= sayi;
            // Sayi her seferinde 1 azaltilir
            sayi--;
        }
        // Faktoriyel hesaplandiktan sonra sonuc dondurulur
        return sonuc;
    }

    public static void main(String[] args) {
        
        // Kullanicidan girdi almak icin Scanner nesnesi olustur
        Scanner okuyucu = new Scanner(System.in);
        
        // Kullanicidan bir sayi girmesini iste
        System.out.println("Lutfen bir sayi giriniz");
        int sayi = okuyucu.nextInt();  // Kullanicinin girdigi sayiyi al
        
        // Faktoriyel sinifindan bir nesne olustur
        Faktoriyel bulucu = new Faktoriyel();
        
        // 'faktoriyelAl' metodunu cagirarak sayinin faktoriyelini hesapla
        int sonuc = bulucu.faktoriyelAl(sayi);
        
        // Hesaplanan faktoriyel sonucunu ekrana yazdir
        System.out.println("Sonuc = " + sonuc);
        
        // Scanner nesnesini kapat
        okuyucu.close();
    }
}
