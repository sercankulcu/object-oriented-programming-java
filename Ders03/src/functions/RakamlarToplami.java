package functions;
import java.util.Scanner;  // Kullanıcıdan giriş almak için Scanner sınıfını içe aktarıyoruz

public class RakamlarToplami {

    // 'rakamlarToplaminiBul' metodu, verilen sayının rakamlarının toplamını hesaplar
    int rakamlarToplaminiBul(int sayi) {
        int rakamlarToplami = 0;  // Rakamların toplamını tutacak değişken
        
        // Sayı 0'dan büyük olduğu sürece döngü devam eder
        while(sayi > 0) {
            // Sayının son rakamını almak için 10'a göre mod işlemi yapılır
            int rakam = sayi % 10;
            // Rakamlar toplamına bu rakamı ekleriz
            rakamlarToplami += rakam;
            // Sayıyı her seferinde 10'a bölerek bir basamağını eksiltiriz
            sayi = sayi / 10;
        }
        
        // Tüm rakamlar toplandıktan sonra sonucu döndürür
        return rakamlarToplami;
    }

    public static void main(String[] args) {
        
        // Kullanıcıdan giriş almak için Scanner nesnesi oluşturuyoruz
        Scanner okuyucu = new Scanner(System.in);
        
        // Kullanıcının bir sayı girmesini isteriz
        System.out.println("Lütfen bir sayı giriniz:");
        int sayi = okuyucu.nextInt();  // Kullanıcının girdiği sayı alınır
        
        // RakamlarToplami sınıfından bir nesne oluşturuyoruz
        RakamlarToplami bulucu = new RakamlarToplami();
        
        // 'rakamlarToplaminiBul' metodunu çağırarak girilen sayının rakamlarının toplamını hesaplıyoruz
        int sonuc = bulucu.rakamlarToplaminiBul(sayi);
        
        // Hesaplanan rakamlar toplamını ekrana yazdırıyoruz
        System.out.println("Rakamlar Toplamı = " + sonuc);
        
        // Scanner nesnesini kapatıyoruz
        okuyucu.close();
    }
}
