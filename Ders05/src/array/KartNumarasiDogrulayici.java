package array;

import java.util.Scanner;

public class KartNumarasiDogrulayici {

    // Bir sayinin rakamlarinin toplamini hesaplayan yontem
    // Ornek: 123 -> 1+2+3 = 6
    static int rakamlarToplami(int sayi) {
        int toplam = 0;
        while (sayi > 0) {
            toplam += sayi % 10; // Sayinin son rakamini toplama ekle
            sayi = sayi / 10; // Sayinin son rakamini at
        }
        return toplam;
    }

    // Bir diziyi ekrana yazdiran yardimci yontem (debug icin kullanilir)
    // Ornek: [1, 2, 3, 4] -> Dizi: 1 2 3 4
    static void ekranaYazdir(int[] dizi) {
        System.out.print("Dizi: ");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + " ");
        }
        System.out.println();
    }

    // Kart numarasini tamsayi dizisine donusturur
    // Ornek: "4532" -> [4, 5, 3, 2]
    static int[] tamsayiDizisineCevir(String kartNumarasi) {
        int[] dizi = new int[kartNumarasi.length()];

        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = Integer.parseInt(kartNumarasi.charAt(i) + ""); // Her karakteri sayiya cevir ve diziye ekle
        }

        // Debug icin diziyi yazdiriyoruz
        ekranaYazdir(dizi);
        return dizi;
    }

    // Her ikinci haneyi (sagdan baslamak uzere) ikiyle carpar
    // Luhn algoritmasina gore islem yapar
    static int[] ciftHaneleriIkiyleCarp(int[] dizi) {
        for (int i = dizi.length - 2; i >= 0; i -= 2) { // Sagdan ikinci elemandan baslayarak sola dogru ilerle
            dizi[i] *= 2; // Elemani ikiyle carp
        }

        // Debug icin diziyi yazdiriyoruz
        ekranaYazdir(dizi);
        return dizi;
    }

    // Bir dizinin tum elemanlarinin toplamini hesaplar
    // Ornek: [1, 2, 3] -> 1+2+3 = 6
    static int elemanlarToplami(int[] dizi) {
        int toplam = 0;
        for (int i = 0; i < dizi.length; i++) {
            toplam += dizi[i]; // Her elemani toplama ekle
        }

        System.out.println("Dizi elemanlar toplami: " + toplam);
        return toplam;
    }

    // Kart numarasini dogrulayan yontem
    // Luhn algoritmasina gore kartin gecerli olup olmadigini kontrol eder
    static boolean kartGecerliMi(String kartNumarasi) {
        int[] dizi = tamsayiDizisineCevir(kartNumarasi); // Kart numarasini tamsayi dizisine cevir
        dizi = ciftHaneleriIkiyleCarp(dizi); // Her ikinci haneyi ikiyle carp

        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = rakamlarToplami(dizi[i]); // Elemanlarin rakamlar toplamini hesapla
        }

        int toplam = elemanlarToplami(dizi); // Elemanlarin toplamini hesapla
        return toplam % 10 == 0; // Toplamin 10'a bolumunden kalan 0 ise gecerlidir
    }

    // Test ve kullanici giris islemleri
    // Ornek kart numaralari ile test islemi yapar ve kullanicidan kart numarasi ister
    static void kartDogrulamaTesti() {
        // Ornek kart numaralari
        String[] kartNumaralari = {"4532015112830366", "6011514433546201", "378282246310005", "1234567890123456", "1111222333334444"};

        for (String kart : kartNumaralari) {
            System.out.println(kart + " -> " + (kartGecerliMi(kart) ? "Gecerli" : "Gecersiz"));
            System.out.println();
        }
    }

    // Kullanicidan kart numarasi alir ve dogrulugunu kontrol eder
    static void kullaniciGirisi() {
        // Kullanicidan kart numarasi isteme
        Scanner klavye = new Scanner(System.in);
        System.out.println("\nKart numaranizi giriniz:");
        String kartNumarasi = klavye.next();

        while (!kartNumarasi.matches("\\d{13,19}")) { // Kart numarasinin 13-19 haneli olup olmadigini kontrol et
            System.out.println("Lutfen gecerli bir kart numarasi giriniz (13-19 hane):");
            kartNumarasi = klavye.next();
        }
        klavye.close();

        // Kartin dogrulugunu kontrol etme
        if (kartGecerliMi(kartNumarasi)) {
            System.out.println("Kart numarasi dogru.");
        } else {
            System.out.println("Kart numarasi yanlis.");
        }
    }

    public static void main(String[] args) {
        kartDogrulamaTesti(); // Ornek kart numaralarini test et
        kullaniciGirisi(); // Kullanicidan kart numarasi al ve dogrulugunu kontrol et
    }
}
