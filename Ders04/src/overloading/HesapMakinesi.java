// package tanimlamasi
package overloading;

// HesapMakinesi sinifini tanimla
public class HesapMakinesi {

    int hafiza = 0; // Bellek degiskeni, son islemin sonucunu tutar

    // iki tamsayiyi topla
    public int topla(int sayi1, int sayi2) {
        hafiza = sayi1 + sayi2; // Hafizaya sonucu kaydet
        return hafiza; // Sonucu dondur
    }

    // iki double sayiyi topla
    public double topla(double sayi1, double sayi2) {
        return sayi1 + sayi2; // Sonucu direkt dondur
    }

    // uc tamsayiyi topla
    public int topla(int sayi1, int sayi2, int sayi3) {
        return sayi1 + sayi2 + sayi3; // Sonucu direkt dondur
    }

    // Bir tamsayi dizisinin elemanlarini topla
    public int topla(int[] sayilar) {
        int toplam = 0;
        for (int sayi : sayilar) {
            toplam += sayi; // Dizideki her elemani toplama ekle
        }
        return toplam; // Toplam sonucu dondur
    }

    // iki tamsayiyi cikar
    public int cikar(int sayi1, int sayi2) {
        return sayi1 - sayi2; // Sonucu dondur
    }

    // iki double sayiyi cikar
    public double cikar(double sayi1, double sayi2) {
        return sayi1 - sayi2; // Sonucu dondur
    }

    // iki tamsayiyi carp
    public int carp(int sayi1, int sayi2) {
        return sayi1 * sayi2; // Sonucu dondur
    }

    // iki double sayiyi carp
    public double carp(double sayi1, double sayi2) {
        return sayi1 * sayi2; // Sonucu dondur
    }

    // iki tamsayiyi bol
    public int bol(int sayi1, int sayi2) {
        if (sayi2 == 0) {
            throw new ArithmeticException("Bolme islemi icin bolen sifir olamaz!"); // Hata durumu
        }
        return sayi1 / sayi2; // Sonucu dondur
    }

    // iki double sayiyi bol
    public double bol(double sayi1, double sayi2) {
        if (sayi2 == 0.0) {
            throw new ArithmeticException("Bolme islemi icin bolen sifir olamaz!"); // Hata durumu
        }
        return sayi1 / sayi2; // Sonucu dondur
    }

    // Ana metot (main method)
    public static void main(String[] args) {
        // HesapMakinesi sinifindan nesne olustur
        HesapMakinesi hesapMakinesi = new HesapMakinesi();

        // Overloading kullanimi
        int sonuc1 = hesapMakinesi.topla(5, 3); // iki tamsayi toplama
        double sonuc2 = hesapMakinesi.topla(3.5, 2.7); // iki double sayi toplama
        int sonuc3 = hesapMakinesi.topla(4, 6, 8); // uc tamsayi toplama

        int[] sayilar = {1, 2, 3, 4, 5};
        int sonuc4 = hesapMakinesi.topla(sayilar); // Tamsayi dizisi toplama

        int sonuc5 = hesapMakinesi.cikar(10, 4); // iki tamsayi cikarma
        double sonuc6 = hesapMakinesi.cikar(7.8, 2.4); // iki double sayi cikarma

        int sonuc7 = hesapMakinesi.carp(3, 5); // iki tamsayi carpma
        double sonuc8 = hesapMakinesi.carp(2.5, 4.0); // iki double sayi carpma

        int sonuc9 = hesapMakinesi.bol(20, 4); // iki tamsayi bolme
        double sonuc10 = hesapMakinesi.bol(9.0, 3.0); // iki double sayi bolme

        // Sonuclari ekrana yazdir
        System.out.println("Sonuc 1: " + sonuc1);
        System.out.println("Sonuc 2: " + sonuc2);
        System.out.println("Sonuc 3: " + sonuc3);
        System.out.println("Sonuc 4 (Dizi toplama): " + sonuc4);
        System.out.println("Sonuc 5 (cikarma): " + sonuc5);
        System.out.println("Sonuc 6 (Double cikarma): " + sonuc6);
        System.out.println("Sonuc 7 (carpma): " + sonuc7);
        System.out.println("Sonuc 8 (Double carpma): " + sonuc8);
        System.out.println("Sonuc 9 (Bolme): " + sonuc9);
        System.out.println("Sonuc 10 (Double bolme): " + sonuc10);
    }
}
