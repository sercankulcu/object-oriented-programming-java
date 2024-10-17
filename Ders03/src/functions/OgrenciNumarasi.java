package functions;
import java.util.Scanner;  // Kullanıcıdan giriş almak için Scanner sınıfını içe aktarıyoruz

public class OgrenciNumarasi {

    // 'kayitYili' metodu, öğrenci numarasının ilk iki hanesine bakarak kayıt yılını hesaplar
    int kayitYili(int sayi) {
        // Öğrenci numarasının ilk iki hanesini (numaranın başındaki iki rakamı) alır ve 2000 yılına ekler
        return (sayi / 10000000) + 2000;
    }

    // 'kayitSirasi' metodu, öğrenci numarasının son üç hanesine bakarak kayıt sırasını döndürür
    int kayitSirasi(int sayi) {
        // Numaranın son üç rakamını almak için 1000'e göre mod işlemi yapılır
        return sayi % 1000;
    }

    // 'bolumu' metodu, öğrenci numarasındaki belirli bir haneye bakarak öğrencinin bölümünü bulur
    String bolumu(int sayi) {
        // Numaranın bölüm bilgisini tutan kısmı alıyoruz (numaranın sondan dördüncü hanesi)
        int bolum = (sayi / 1000) % 10;
        
        // Bölüm numarasına göre hangi bölümde okuduğunu kontrol ediyoruz
        if(bolum == 7) {
            return "Elektrik Elektronik";
        } else if(bolum == 6) {
            return "Bilgisayar";
        } else if(bolum == 5) {
            return "Makina";
        } else {
            return "Bilinmiyor";  // Belirtilen numaraya uymayan bir değer için bilinmiyor sonucu döner
        }
    }

    public static void main(String[] args) {

        // Kullanıcıdan giriş almak için Scanner nesnesi oluşturuyoruz
        Scanner okuyucu = new Scanner(System.in);
        
        // Kullanıcıdan okul numarasını girmesini isteriz
        System.out.println("Lütfen okul numaranızı giriniz");
        int numara = okuyucu.nextInt();  // Kullanıcının girdiği okul numarası alınır
        
        // OgrenciNumarasi sınıfından bir nesne oluşturuyoruz
        OgrenciNumarasi bulucu = new OgrenciNumarasi();
        
        // Öğrencinin kayıt yılı ekrana yazdırılır
        System.out.println("Kayıt yılı: " + bulucu.kayitYili(numara));
        
        // Öğrencinin kayıt sırası ekrana yazdırılır
        System.out.println("Kayıt sırası: " + bulucu.kayitSirasi(numara));
        
        // Öğrencinin bölümü ekrana yazdırılır
        System.out.println("Bölüm: " + bulucu.bolumu(numara));
        
        // Scanner nesnesini kapatıyoruz
        okuyucu.close();
    }
}
