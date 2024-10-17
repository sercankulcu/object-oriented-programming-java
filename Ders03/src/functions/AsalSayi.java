package functions;
import java.util.Scanner;  // Kullanıcıdan girdi almak için Scanner sınıfını projeye aktar.

public class AsalSayi {
    
    // 'asalMi' metodu bir sayının asal olup olmadığını kontrol eder.
    boolean asalMi(int sayi) {
        // 2'den başlayarak sayının kendisinden bir küçük sayıya kadar tam bölünebilir olup olmadığını kontrol et.
        for(int i = 2; i < sayi; i++) {
            // Eğer sayı herhangi bir 'i' değerine tam bölünüyorsa, asal değildir.
            if(sayi % i == 0) {
                return false;  // Sayı asal değil, false döner
            }
        }
        // Eğer döngü sonunda hiç bölünen olmadıysa, sayı asaldır.
        return true;
    }

    public static void main(String[] args) {
        
        // Kullanıcıdan girdi almak için Scanner sınıfından nesne oluştur
        Scanner okuyucu = new Scanner(System.in);
        System.out.println("Lütfen bir sayı giriniz");  // Kullanıcıdan sayı girmesini iste
        int sayi = okuyucu.nextInt();  // Kullanıcının girdiği sayı alınır
        
        // AsalSayi sınıfından bir nesne oluştur
        AsalSayi bulucu = new AsalSayi();
        
        // Girilen sayıdan sonraki ilk asal sayıyı bulana kadar döngü devam eder
        while(bulucu.asalMi(++sayi) == false) {
            // Burada herhangi bir işlem yapılmıyor, sadece sayi değeri bir arttırılıp tekrar kontrol ediliyor
        }
        
        // İlk asal sayı bulunduğunda ekrana yazdırılır
        System.out.println(sayi);
        
        // Scanner nesnesini kapat, kaynakları işletim sistemine geri ver.
        okuyucu.close();
    }
}
