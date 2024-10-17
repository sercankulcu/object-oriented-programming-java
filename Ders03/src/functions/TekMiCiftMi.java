package functions;
import java.util.Scanner;  // Kullanıcıdan giriş almak için Scanner sınıfını içe aktarıyoruz

public class TekMiCiftMi {

    // 'tekMiCiftMi' metodu, verilen sayının tek mi yoksa çift mi olduğunu kontrol eder
    void tekMiCiftMi(int sayi) {
        // Eğer sayının 2'ye bölümünden kalan 0 ise sayı çifttir
        if(sayi % 2 == 0) {
            System.out.println("sayı çift");  // Sonuç olarak çift olduğu ekrana yazdırılır
        }
        // Aksi halde sayı tek olacaktır
        else {
            System.out.println("sayı tek");  // Sonuç olarak tek olduğu ekrana yazdırılır
        }
    }

    public static void main(String[] args) {

        // TekMiCiftMi sınıfından bir nesne oluşturuyoruz
        TekMiCiftMi nesne = new TekMiCiftMi();
        
        // Kullanıcıdan giriş almak için Scanner nesnesi oluşturuyoruz
        Scanner okuyucu = new Scanner(System.in);
        
        // Kullanıcının bir sayı girmesini isteriz
        System.out.println("Lütfen bir sayı giriniz:");
        int sayi = okuyucu.nextInt();  // Kullanıcının girdiği sayı alınır
        
        // 'tekMiCiftMi' metodunu çağırarak sayının tek mi yoksa çift mi olduğunu kontrol ediyoruz
        nesne.tekMiCiftMi(sayi);
        
        // Scanner nesnesini kapatmayı unutmamak için Scanner kapatılabilir
        okuyucu.close();  // Kaynak sızıntılarını önlemek için Scanner nesnesi kapatılır
    }
}
