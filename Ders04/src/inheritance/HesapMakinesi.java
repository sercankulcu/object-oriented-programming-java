package inheritance;

public class HesapMakinesi {

    // Hafiza degiskeni
    private double hafiza;

    // Toplama işlemi yapan metod
    public double topla(int a, int b) {
        hafiza = a + b; // Sonucu hafizada sakla
        return hafiza;
    }

    // Cikarma işlemi yapan metod
    public double cikart(int a, int b) {
        hafiza = a - b; // Sonucu hafizada sakla
        return hafiza;
    }

    // Carpma işlemi yapan metod
    public double carp(int a, int b) {
        hafiza = a * b; // Sonucu hafizada sakla
        return hafiza;
    }

    // Bolme işlemi yapan metod
    public double bol(int a, int b) {
        if (b != 0) {
            hafiza = (double) a / b; // Sonucu hafizada sakla
            return hafiza;
        } else {
            System.out.println("Sifira bolme hatasi!");
            return Double.NaN; // Hata durumu
        }
    }

    // Hafiza degiskeninin degeri donduruluyor
    public double hafizayiGoruntule() {
        return hafiza;
    }

    // Hafizayi sifirla
    public void hafizayiSifirla() {
        hafiza = 0;
    }
    
    public static void main(String[] args) {
        // HesapMakinesi nesnesi olusturuluyor
        HesapMakinesi hesap = new HesapMakinesi();
        
        // Toplama islemi yapiliyor
        double sonuc = hesap.topla(5, 3);
        System.out.println("Toplama Sonucu: " + sonuc); // 8 olarak yazdirir
        
        // Hafizayi goruntuleme
        System.out.println("Hafiza: " + hesap.hafizayiGoruntule()); // 8

        // Hafizayi sifirlama
        hesap.hafizayiSifirla();
        System.out.println("Hafiza sifirlandiktan sonra: " + hesap.hafizayiGoruntule()); // 0

        // Yeni bir islemi yapma
        sonuc = hesap.cikart(10, 4);
        System.out.println("Cikarma Sonucu: " + sonuc); // 6 olarak yazdirir
    }
}
