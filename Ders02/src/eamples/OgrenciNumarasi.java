package eamples;
import java.util.Scanner; // Kullanicidan veri girisi almak icin Scanner sinifini ice aktarir.

public class OgrenciNumarasi { // Ana sinif

    public static void main(String[] args) {
        
        // Kullanicidan ogrenci numarasini almak icin Scanner nesnesi olusturur.
        Scanner scanner = new Scanner(System.in);
        
        // Kullanicidan bir ogrenci numarasi girmesini ister.
        System.out.println("Ogrenci numarasini giriniz:");
        int numara = scanner.nextInt(); // Girilen ogrenci numarasini okur ve 'numara' degiskenine atar.
        
        // Ogrenci numarasinin ilk iki hanesi kayit yilini belirler. Bu iki hane 10000000'e bolunerek elde edilir.
        // 2000 yilina eklenerek ogrenci numarasindaki yil bilgisi cozulur.
        int kayityili = (numara / 10000000) + 2000;
        
        // Ogrencinin kayit yili ekrana yazdirilir.
        System.out.println("Kayit yili: " + kayityili);
        
        // Ogrenci numarasinin son uc hanesi, ogrencinin kayit sirasini gosterir.
        // Mod 1000 islemi ile bu uc hane alinir.
        int kayitsirasi = numara % 1000;
        
        // Kayit sirasi ekrana yazdirilir.
        System.out.println("Kayit sirasi: " + kayitsirasi);
        
        // Ogrenci numarasinin 5. hanesi ogrencinin bolumunu gosterir.
        // 100000'e bolunerek ilgili hane alinir ve mod 10 islemi ile bu hane elde edilir.
        int bolumu = (numara / 100000) % 10;
        
        // Bolum numarasina gore ogrencinin hangi bolumde oldugu belirlenir ve ekrana yazar.
        if(bolumu == 7) {
            // Eger bolum numarasi 7 ise Elektrik Elektronik bolumu yazdirilir.
            System.out.println("Bolum: Elektrik Elektronik");
        } else if (bolumu == 6) {
            // Eger bolum numarasi 6 ise Bilgisayar Muhendisligi bolumu yazdirilir.
            System.out.println("Bolum: Bilgisayar");
        } else if (bolumu == 5) {
            // Eger bolum numarasi 5 ise Makina Muhendisligi bolumu yazdirilir.
            System.out.println("Bolum: Makina");
        } else {
            // Eger bolum numarasi 5, 6 veya 7 degilse, bolum tanimlanmaz.
            System.out.println("Bilinmeyen bolum");
        }
        
        // Scanner nesnesini kapatir. Kaynak yonetimi acisindan onemli bir adimdir.
        scanner.close(); 
    }
}
