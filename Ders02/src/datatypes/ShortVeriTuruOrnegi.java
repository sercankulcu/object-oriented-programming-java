package datatypes;

public class ShortVeriTuruOrnegi {

    public static void main(String[] args) {

        // Bir short degiskeni kullanarak aritmetik islemler 
        short sayi1 = 300;
        short sayi2 = 500;

        // Toplama islemi
        short toplam = (short) (sayi1 + sayi2); // Toplam sonucunu bir short'a donusturmek gerekebilir
        System.out.println("Toplam: " + toplam);

        // Fark islemi
        short fark = (short) (sayi2 - sayi1); // Kucuk sayi cikartma islemi
        System.out.println("Fark: " + fark);

        // Carpma islemi
        short carpim = (short) (sayi1 * sayi2); // Carpma islemi
        System.out.println("Carpim: " + carpim);

        // Bolme islemi
        short bolum = (short) (sayi2 / sayi1); // Bolme islemi
        System.out.println("Bolum: " + bolum);

        // Modulus (kalan) islemi
        short kalan = (short) (sayi2 % sayi1); // Modulus islemi
        System.out.println("Kalan: " + kalan);

        // Short veri turu ile artirma ve azaltma islemleri
        short arttirma = (short) (sayi1 + 1); // 1 ekleyerek sayiyi arttir
        short azaltma = (short) (sayi2 - 1); // 1 cikararak sayiyi azalt

        System.out.println("Arttirilmis Sayi1: " + arttirma);
        System.out.println("Azaltilmis Sayi2: " + azaltma);

        // Short veri turu ile pozitif ve negatif degerleri kontrol etme
        if (sayi1 > 0) {
            System.out.println("Sayi1 pozitif bir degerdir.");
        } else {
            System.out.println("Sayi1 negatif bir degerdir.");
        }

        // Short veri turunun minimum ve maksimum degerlerini yazdir
        System.out.println("\nShort veri turunun minimum degeri: " + Short.MIN_VALUE);
        System.out.println("Short veri turunun maksimum degeri: " + Short.MAX_VALUE);

        // Short veri turunun minimum ve maksimum degerlerine ulasma islemleri
        short maxDeger = Short.MAX_VALUE;
        short minDeger = Short.MIN_VALUE;
        
        // Minimum ve maksimum degerlerin ne kadar farkli oldugunu hesapla
        short farkDegerleri = (short) (maxDeger - minDeger);
        System.out.println("Short veri turunun max ve min degeri arasindaki fark: " + farkDegerleri);

        // Son olarak, normal bir short degeri ile hesaplama yap
        short sayi3 = 1500;
        short sayi4 = 1200;
        short toplamDeger = (short) (sayi3 + sayi4);
        System.out.println("Yeni toplam: " + toplamDeger);
    }
}
