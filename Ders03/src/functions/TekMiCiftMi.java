package functions; 
import java.util.Scanner;  // Kullanicidan giris almak icin Scanner sinifini ice aktar

public class TekMiCiftMi {

    // 'tekMiCiftMi' metodu, verilen sayinin tek mi yoksa cift mi oldugunu kontrol eder
    void tekMiCiftMi(int sayi) {
        // Eger sayinin 2'ye bolumunden kalan 0 ise sayi ciftir
        if(sayi % 2 == 0) {
            System.out.println("sayi cift");  // Sonuc olarak cift oldugu ekrana yazdirilir
        }
        // Aksi halde sayi tek olacaktir
        else {
            System.out.println("sayi tek");  // Sonuc olarak tek oldugu ekrana yazdirilir
        }
    }

    public static void main(String[] args) {

        // TekMiCiftMi sinifindan bir nesne olustur
        TekMiCiftMi nesne = new TekMiCiftMi();
        
        // Kullanicidan giris almak icin Scanner nesnesi olustur
        Scanner okuyucu = new Scanner(System.in);
        
        // Kullanicinin bir sayi girmesini iste
        System.out.println("Lutfen bir sayi giriniz:");
        int sayi = okuyucu.nextInt();  // Kullanicinin girdigi sayi alinir
        
        // 'tekMiCiftMi' metodunu cagirarak sayinin tek mi yoksa cift mi oldugunu kontrol et
        nesne.tekMiCiftMi(sayi);
        
        okuyucu.close();  // Kaynak sızıntılarını onlemek icin Scanner nesnesi kapatilir
    }
}
