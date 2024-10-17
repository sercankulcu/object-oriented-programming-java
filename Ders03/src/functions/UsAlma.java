package functions;
import java.util.Scanner;  // Kullanıcıdan giriş almak için Scanner sınıfını içe aktarıyoruz

public class UsAlma {

    // 'usAl' metodu, verilen tabanın belirtilen üsse göre üssünü hesaplar
    int usAl(int taban, int us) {
        int sonuc = 1;  // Sonucu başlatıyoruz. 1 ile başlar çünkü herhangi bir sayının 0. kuvveti 1'dir
        
        // Döngü, üs sayısı kadar döner ve her adımda sonucu taban ile çarpar
        for(int i = 0; i < us; i++) {
            sonuc *= taban;  // Sonucu her adımda taban ile çarparak üslü sayı işlemi yapılır
        }
        
        // Hesaplanan sonuç döndürülür
        return sonuc;
    }

    public static void main(String[] args) {

        // Kullanıcıdan giriş almak için Scanner nesnesi oluşturuyoruz
        Scanner okuyucu = new Scanner(System.in);
        
        // Kullanıcıdan taban sayısını girmesini isteriz
        System.out.println("Lütfen tabanı giriniz:");
        int taban = okuyucu.nextInt();  // Kullanıcının girdiği taban sayısı alınır
        
        // Kullanıcıdan üs sayısını girmesini isteriz
        System.out.println("Lütfen üssü giriniz:");
        int us = okuyucu.nextInt();  // Kullanıcının girdiği üs sayısı alınır
        
        // UsAlma sınıfından bir nesne oluşturuyoruz
        UsAlma bulucu = new UsAlma();
        
        // 'usAl' metodunu çağırarak tabanın üssünü hesaplıyoruz
        int sonuc = bulucu.usAl(taban, us);
        
        // Hesaplanan sonucu ekrana yazdırıyoruz
        System.out.println("Sonuç = " + sonuc);
        
        // Scanner nesnesini kapatıyoruz
        okuyucu.close();  // Kaynak sızıntılarını önlemek için Scanner nesnesi kapatılır
    }
}
