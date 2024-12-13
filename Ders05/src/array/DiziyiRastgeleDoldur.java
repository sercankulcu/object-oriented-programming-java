package array;
import java.util.Arrays;
import java.util.Random;

public class DiziyiRastgeleDoldur {

    public static void main(String[] args) {
        // Dizi boyutu belirle
        int diziBoyutu = 20;

        // Rastgele sayilar olusturmak icin Random sinifini kullan
        Random random = new Random();

        // Rastgele degerlerle bir dizi olustur
        int[] rastgeleDizi = new int[diziBoyutu];

        // Diziyi doldur ve ekrana yazdir
        System.out.print("Rastgele Dizi Elemanlari: ");
        for (int i = 0; i < diziBoyutu; i++) {
            // Rastgele bir sayi olustur ve dizinin ilgili elemanina ata
            rastgeleDizi[i] = random.nextInt(20); // 0 ile 100 arasinda rastgele bir sayi
            System.out.print(rastgeleDizi[i] + " ");
        }

        // Dizinin toplamini ekrana yazdir
        int toplam = dizininToplaminiBul(rastgeleDizi);
        System.out.println("\nDizinin Toplami: " + toplam);

        // Dizinin ortalamasini ekrana yazdir
        double ortalama = dizininOrtalamasi(rastgeleDizi);
        System.out.println("Dizinin Ortalamasi: " + ortalama);

        // Dizinin ortancasini ekrana yazdir
        double ortanca = dizininOrtancasiniBul(rastgeleDizi);
        System.out.println("Dizinin Ortancasi: " + ortanca);

        // Dizinin modunu ekrana yazdir
        int mod = dizininModunuBul(rastgeleDizi);
        System.out.println("Dizinin Modu: " + mod);
    }

    // Dizinin toplamini bulan fonksiyon
    public static int dizininToplaminiBul(int[] dizi) {
        int toplam = 0;
        for (int i = 0; i < dizi.length; i++) {
            toplam += dizi[i];
        }
        return toplam;
    }

    // Dizinin ortalamasini bulan fonksiyon
    public static double dizininOrtalamasi(int[] dizi) {
        int toplam = dizininToplaminiBul(dizi);
        return (double) toplam / dizi.length;
    }

    // Dizinin ortancasini bulan fonksiyon
    public static double dizininOrtancasiniBul(int[] dizi) {
        // Diziyi kucukten buyuge sirala
        Arrays.sort(dizi);
        
        System.out.println("Sirali Dizi Elemanlari: " + Arrays.toString(dizi));

        // Eger dizi cift sayida elemandan olusuyorsa, ortanca iki ortadaki sayinin ortalamasidir
        if (dizi.length % 2 == 0) {
            return (dizi[dizi.length / 2 - 1] + dizi[dizi.length / 2]) / 2.0;
        } else {
            return dizi[dizi.length / 2];
        }
    }

    // Dizinin modunu bulan fonksiyon
    public static int dizininModunuBul(int[] dizi) {
        // Diziyi kucukten buyuge sirala
        Arrays.sort(dizi);

        // Modu bulmak icin degiskenler
        int mod = dizi[0];
        int maksimumFrekans = 1;
        int mevcutFrekans = 1;

        // Sirali dizide tek dongu ile elemanlari kontrol et
        for (int i = 1; i < dizi.length; i++) {
            if (dizi[i] == dizi[i - 1]) {
                mevcutFrekans++;  // Ayni elemanla karsilasildiginda frekansi artir
            } else {
                mevcutFrekans = 1;  // Yeni bir elemanla karsilasildiginda frekansi sifirla
            }

            // Eger mevcut frekans, en yuksek frekanstan buyukse, modu guncelle
            if (mevcutFrekans > maksimumFrekans) {
                maksimumFrekans = mevcutFrekans;
                mod = dizi[i];
            }
        }

        return mod;
    }
}
