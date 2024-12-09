package datatypes;

public class IntVeriTuruOrnegi {

    public static void main(String[] args) {

        // short ve int veri turlerini kullanarak degiskenler tanimla
        short kisaSayi = 32000;
        int tamSayi = 2147483647;

        // Degerleri yazdir
        System.out.println("Kisa Sayi: " + kisaSayi);
        System.out.println("Tam Sayi: " + tamSayi);

        // Bir short ve bir int degiskenini toplama islemi 
        // Sonuc otomatik olarak int turune donusecektir
        int toplam = kisaSayi + tamSayi;
        System.out.println("Toplam: " + toplam);

        // short turunden int turune acik bir donusum yapilabilir (casting)
        short kisaSayi2 = 30000;
        int toplam2 = kisaSayi2 + kisaSayi2; // Donusum (casting)
        System.out.println("Toplam 2: " + toplam2);

        // Int veri tipi ile aritmetik islemler
        int fark = tamSayi - kisaSayi;
        int carpim = tamSayi * kisaSayi;
        int bolum = tamSayi / kisaSayi; // Tam sayi bolmesi
        int kalan = tamSayi % kisaSayi; // Modulus islemi

        // Aritmetik islemler sonuclarini yazdir
        System.out.println("Fark: " + fark);
        System.out.println("Carpim: " + carpim);
        System.out.println("Bolum: " + bolum);
        System.out.println("Kalan: " + kalan);

        // Maksimum ve minimum degerler
        System.out.println("Short veri turunun maksimum degeri: " + Short.MAX_VALUE);
        System.out.println("Short veri turunun minimum degeri: " + Short.MIN_VALUE);
        System.out.println("Int veri turunun maksimum degeri: " + Integer.MAX_VALUE);
        System.out.println("Int veri turunun minimum degeri: " + Integer.MIN_VALUE);

    }
}
