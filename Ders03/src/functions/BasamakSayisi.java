package functions;
import java.util.Scanner;  // Kullanıcıdan giriş almak için Scanner sınıfını içe aktarıyoruz

public class BasamakSayisi {

    // 'basamakSayisiBul' metodu verilen sayının kaç basamaktan oluştuğunu bulur
    int basamakSayisiBul(int sayi) {
        int basamakSayisi = 0;  // Basamak sayısını tutacak değişken
        // Sayı 0'dan büyük olduğu sürece döngü devam eder
        while(sayi > 0) {
            // Sayı her döngüde 10'a bölünerek bir basamak eksiltilir
            sayi = sayi / 10;
            // Her bölme işleminde bir basamak olduğu için sayacımızı arttırırız
            basamakSayisi++;
        }
        // Basamak sayısını döndürür
        return basamakSayisi;
    }

    public static void main(String[] args) {
        
        // Kullanıcıdan giriş almak için Scanner nesnesi oluşturuyoruz
        Scanner okuyucu = new Scanner(System.in);
        // Kullanıcının girdiği sayıyı alıyoruz
        int sayi = okuyucu.nextInt();
        
        // BasamakSayisi sınıfından bir nesne oluşturuyoruz
        BasamakSayisi bulucu = new BasamakSayisi();
        
        // 'basamakSayisiBul' metodunu çağırarak sayının basamak sayısını hesaplıyoruz
        int sonuc = bulucu.basamakSayisiBul(sayi);
        
        // Sonucu ekrana yazdırıyoruz
        System.out.println(sonuc);
        
        // Scanner nesnesini kapatıyoruz
        okuyucu.close();
    }
}
