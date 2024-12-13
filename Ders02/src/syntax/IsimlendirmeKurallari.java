package syntax;

public class IsimlendirmeKurallari {

    public static void main(String[] args) {

        // Java'daki isimlendirme kurallarina uyarak degiskenler tanimla
        int yas; // Gecerli: Basit bir degisken adi
        String isimSoyisim; // Gecerli: Degisken adi birden fazla kelime icerebilir
        double maasHesabi; // Gecerli: Degisken adi birden fazla kelime icerebilir ve anlamli olmalidir
        boolean evliMi; // Gecerli: Degisken adi anlamlidir
        char cinsiyet; // Gecerli: Degisken adi anlamlidir
        long telefonNumarasi; // Gecerli: Basit uzun bir sayi degiskeni

        // Sabit degiskenler icin tum harfler buyuk yazilir
        final double PI = 3.14159; // Gecerli: Sabit degiskenler buyuk harf ile yazilir

        // Java'da degisken isimlerinde ozel karakterler ve bosluk kullanilamaz
        // int 2yas; // Gecersiz: Degisken adi sayi ile baslayamaz
        // String @isimSoyisim; // Gecersiz: Degisken adi ozel karakter ile baslayamaz
        // double maas hesabi; // Gecersiz: Degisken adi bosluk iceremez
        // boolean evli mi; // Gecersiz: Degisken adi bosluk iceremez

        // Degisken isimleri anlamsiz olamaz, her zaman anlamli olmalidir
        String sehirAdi = "Istanbul"; // Gecerli: Anlamli bir degisken adi
        int ogrenciSayisi = 100; // Gecerli: Anlamli ve basit bir degisken adi
        
        // Java'da degisken isimleri buyuk harf ile baslamamalidir
        // String IsimSoyisim; // Gecersiz: Degisken adi buyuk harf ile baslamaz

        // Java'da degisken isimleri genellikle camelCase ile yazilir
        String ogrenciAdSoyad = "Ali Veli"; // Gecerli: Camel case kurallarina uygun
        double toplamMaas = 5000.0; // Gecerli: Camel case ile yazilan degisken ismi

        // Ancak bazi durumlarda, sabit degiskenler icin buyuk harf kullanilir
        final int MAX_SAYI = 100; // Gecerli: Sabit degiskenler buyuk harf ile yazilir
    }
}
