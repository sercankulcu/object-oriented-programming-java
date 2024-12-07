package functions; 
import java.util.Scanner;  // Kullanicidan giris almak icin Scanner sinifini ice aktar

public class OgrenciNumarasi {

    // 'kayitYili' metodu, ogrenci numarasinin ilk iki hanesine bakarak kayit yilini hesaplar
    int kayitYili(int sayi) {
        // Ogrenci numarasinin ilk iki hanesini (numaranin basindaki iki rakami) alir ve 2000 ekler
        return (sayi / 10000000) + 2000;
    }

    // 'kayitSirasi' metodu, ogrenci numarasinin son uc hanesine bakarak kayit sirasi'ni dondurur
    int kayitSirasi(int sayi) {
        // Numaranin son uc rakamini almak icin 1000'e gore mod islemi yapilir
        return sayi % 1000;
    }

    // 'bolumu' metodu, ogrenci numarasindaki belirli bir haneye bakarak ogrencinin bolumunu bulur
    String bolumu(int sayi) {
        // Numaranin bolum bilgisini tutan kisimi al (numaranin sondan dorduncu hanesi)
        int bolum = (sayi / 1000) % 10;
        
        // Bolum numarasina gore hangi bolumde okudugunu kontrol et
        if(bolum == 7) {
            return "Elektrik Elektronik";
        } else if(bolum == 6) {
            return "Bilgisayar";
        } else if(bolum == 5) {
            return "Makina";
        } else {
            return "Bilinmiyor";  // Belirtilen numaraya uymayan bir deger icin bilinmiyor sonucu doner
        }
    }

    public static void main(String[] args) {

        // Kullanicidan giris almak icin Scanner nesnesi olustur
        Scanner okuyucu = new Scanner(System.in);
        
        // Kullanicidan okul numarasini girmesini iste
        System.out.println("Lutfen okul numaranizi giriniz");
        int numara = okuyucu.nextInt();  // Kullanicinin girdigi okul numarasi alinir
        
        numara = 230707123;
        
        // OgrenciNumarasi sinifindan bir nesne olustur
        OgrenciNumarasi bulucu = new OgrenciNumarasi();
        
        // Ogrencinin kayit yili ekrana yazdirilir
        System.out.println("Kayit yili: " + bulucu.kayitYili(numara));
        
        // Ogrencinin kayit sirasi ekrana yazdirilir
        System.out.println("Kayit sirasi: " + bulucu.kayitSirasi(numara));
        
        // Ogrencinin bolumu ekrana yazdirilir
        System.out.println("Bolum: " + bulucu.bolumu(numara));
        
        // Scanner nesnesini kapatiyoruz
        okuyucu.close();
    }
}
