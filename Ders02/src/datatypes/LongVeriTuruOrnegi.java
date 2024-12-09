package datatypes;

public class LongVeriTuruOrnegi {

    public static void main(String[] args) {

        // long, short ve int veri turlerini kullanarak degiskenler tanimla
        long uzunSayi = 2147483648L; // long veri turu "L" ile belirtilir
        short kisaSayi = 32000;
        int tamSayi = 2147483647;

        // Degerleri yazdir
        System.out.println("Uzun Sayi: " + uzunSayi);
        System.out.println("Kisa Sayi: " + kisaSayi);
        System.out.println("Tam Sayi: " + tamSayi);

        // short ve int veri turlerini topla
        // Sonuc otomatik olarak int turune donusecektir
        int toplam = kisaSayi + tamSayi;
        System.out.println("Toplam: " + toplam);

        // long turunden int turune ve int turunden short turune acik donusum yapilabilir (casting)
        long uzunSayi2 = 50000;
        int tamSayi2 = (int) uzunSayi2; // long'dan int'e donusum (casting)
        short kisaSayi2 = (short) tamSayi2; // int'ten short'a donusum (casting)

        System.out.println("Uzun Sayi 2: " + uzunSayi2);
        System.out.println("Tam Sayi 2: " + tamSayi2);
        System.out.println("Kisa Sayi 2: " + kisaSayi2);

        // Maksimum ve minimum degerler
        System.out.println("Long veri turunun maksimum degeri: " + Long.MAX_VALUE);
        System.out.println("Long veri turunun minimum degeri: " + Long.MIN_VALUE);
        System.out.println("Short veri turunun maksimum degeri: " + Short.MAX_VALUE);
        System.out.println("Short veri turunun minimum degeri: " + Short.MIN_VALUE);
        System.out.println("Int veri turunun maksimum degeri: " + Integer.MAX_VALUE);
        System.out.println("Int veri turunun minimum degeri: " + Integer.MIN_VALUE);

        // Long veri turu ile aritmetik islemler
        long fark = uzunSayi - uzunSayi2;
        long carpim = uzunSayi * uzunSayi2;
        long bolum = uzunSayi / uzunSayi2; // Tam sayi bolmesi
        long kalan = uzunSayi % uzunSayi2; // Modulus islemi

        // Aritmetik islemler sonuclarini yazdir
        System.out.println("Long'tan Long'a Fark: " + fark);
        System.out.println("Long'tan Long'a Carpim: " + carpim);
        System.out.println("Long'tan Long'a Bolum: " + bolum);
        System.out.println("Long'tan Long'a Kalan: " + kalan);
    }
}
