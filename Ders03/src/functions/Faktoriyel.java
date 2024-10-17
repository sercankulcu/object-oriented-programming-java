package functions;
import java.util.Scanner;  // Kullanıcıdan giriş almak için Scanner sınıfını içe aktarıyoruz

public class Faktoriyel {

    // 'faktoriyelAl' metodu, verilen sayının faktöriyelini hesaplar
    int faktoriyelAl(int sayi) {
        int sonuc = 1;  // Faktöriyel sonucunu tutacak değişken, başlangıçta 1 olmalı
        // Sayı 0'dan büyük olduğu sürece döngü devam eder
        while(sayi > 0) {
            // Sonuç değişkenini her adımda sayi ile çarparak faktöriyel hesaplarız
            sonuc *= sayi;
            // Sayı her seferinde 1 azaltılır
            sayi--;
        }
        // Faktöriyel hesaplandıktan sonra sonuç döndürülür
        return sonuc;
    }

    public static void main(String[] args) {
        
        // Kullanıcıdan giriş almak için Scanner nesnesi oluşturuyoruz
        Scanner okuyucu = new Scanner(System.in);
        
        // Kullanıcıdan bir sayı girmesini isteriz
        System.out.println("Lütfen bir sayı giriniz");
        int sayi = okuyucu.nextInt();  // Kullanıcının girdiği sayı alınır
        
        // Faktoriyel sınıfından bir nesne oluşturuyoruz
        Faktoriyel bulucu = new Faktoriyel();
        
        // 'faktoriyelAl' metodunu çağırarak sayının faktöriyelini hesaplıyoruz
        int sonuc = bulucu.faktoriyelAl(sayi);
        
        // Hesaplanan faktöriyel sonucunu ekrana yazdırıyoruz
        System.out.println("Sonuç = " + sonuc);
        
        // Scanner nesnesini kapatıyoruz
        okuyucu.close();
    }
}
