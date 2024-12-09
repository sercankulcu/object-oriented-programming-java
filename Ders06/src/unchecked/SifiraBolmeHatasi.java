package unchecked;

public class SifiraBolmeHatasi {

    public static void main(String[] args) {

        // Giris argumanlarini simule eden bir dizi tanimlandi
        String[] girisDizisi = {"10", "0"}; // Burada farkli degerlerle denenebilir

        try {
            // Diziden degerleri al ve tamsayi olarak ayristir
            int x = Integer.parseInt(girisDizisi[0]);
            int y = Integer.parseInt(girisDizisi[1]);

            // Iki sayiyi bol ve sonucu yazdir
            int z = x / y;
            System.out.println("Sonuc: " + z);

        } catch (NumberFormatException e) {
            // Eger girilen veri tamsayi degilse bu istisna firlatilir
            System.out.println("Gecersiz giris: Lutfen sadece tamsayi giriniz.");
            System.out.println("Istisna mesaji: " + e.getMessage());
            e.printStackTrace(); // Istisna izini yazdir

        } catch (ArithmeticException e) {
            // Eger bolme islemi sifira bolme icermisse bu istisna firlatilir
            System.out.println("Sifira bolme hatasi olustu!");
            System.out.println("Istisna mesaji: " + e.getMessage());
            e.printStackTrace(); // Istisna izini yazdir

        } catch (ArrayIndexOutOfBoundsException e) {
            // Eger dizi eksikse bu istisna firlatilir
            System.out.println("Eksik giris: Lutfen iki sayi giriniz.");
            System.out.println("Istisna mesaji: " + e.getMessage());
            e.printStackTrace(); // Istisna izini yazdir

        } finally {
            // Bu blok her zaman calisir
            System.out.println("Finally bloguna girildi!");
        }

        // Ek bir ornek: Istisna firlatmayan normal bir akisi test et
        try {
            basariliAkisTesti();
        } catch (Exception e) {
            System.out.println("Beklenmeyen bir hata: " + e.getMessage());
        }
    }

    /**
     * Basarili bir akis senaryosunu test eder.
     */
    public static void basariliAkisTesti() {
        System.out.println("Basarili akis testi calisiyor.");
        int a = 10;
        int b = 5;
        int sonuc = a / b;
        System.out.println("10 / 5 = " + sonuc);
        System.out.println("Her sey yolunda, istisna firlatilmadi!");
    }
}
