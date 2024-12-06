package objects;

import java.util.ArrayList;
import java.util.List;

public class Ogrenci {
	
    private String ad;
    private int numara;
    private List<String> dersler;
    private List<Double> notlar;

    // Constructor: ogrenci adi, numarasi ve dersler listesi
    public Ogrenci(String ad, int numara) {
        this.ad = ad;
        this.numara = numara;
        this.dersler = new ArrayList<>();
        this.notlar = new ArrayList<>();
    }

    // Selam verme metodu
    public void selamVer() {
        System.out.println("Merhaba, ben " + this.ad + ". Numaram: " + this.numara);
    }

    // ogrenciye ders ekleme metodu
    public void dersEkle(String dersAdi, double notu) {
        dersler.add(dersAdi);
        notlar.add(notu);
        System.out.println(dersAdi + " dersi ve " + notu + " notu eklendi.");
    }

    // ogrencinin basari durumunu kontrol etme
    public void basariDurumu() {
        double ortalama = 0;
        for (double not : notlar) {
            ortalama += not;
        }
        ortalama /= notlar.size();

        System.out.println(ad + " adli ogrencinin not ortalamasi: " + ortalama);

        if (ortalama >= 60) {
            System.out.println(ad + " basarili.");
        } else {
            System.out.println(ad + " basarisiz.");
        }
    }

    // ogrencinin derslerinin ve notlarinin listesini yazdirma
    public void dersleriYazdir() {
        System.out.println(ad + " adli ogrencinin dersleri ve notlari:");
        for (int i = 0; i < dersler.size(); i++) {
            System.out.println(dersler.get(i) + " - Not: " + notlar.get(i));
        }
    }

    // toString metodunu ozellestirme
    @Override
    public String toString() {
        return "Ogrenci [ad=" + ad + ", numara=" + numara + ", dersler=" + dersler + ", notlar=" + notlar + "]";
    }

    // Ana metod (main method) içinde kullanimi
    public static void main(String[] args) {

        // Ogrenci nesneleri olusturuluyor
        Ogrenci ogrenci1 = new Ogrenci("Ali", 20122273);
        Ogrenci ogrenci2 = new Ogrenci("Ayse", 20132272);

        // Ders ve not ekleme
        ogrenci1.dersEkle("Matematik", 75.0);
        ogrenci1.dersEkle("Fizik", 82.0);
        ogrenci1.dersEkle("Kimya", 90.0);

        ogrenci2.dersEkle("Matematik", 65.0);
        ogrenci2.dersEkle("Fizik", 58.0);
        ogrenci2.dersEkle("Kimya", 72.0);

        // ogrencilerin selam vermesi
        ogrenci1.selamVer();
        ogrenci2.selamVer();

        // ogrencilerin derslerini ve basari durumlarini yazdirma
        ogrenci1.dersleriYazdir();
        ogrenci2.dersleriYazdir();

        // ogrencilerin basari durumlarini kontrol etme
        ogrenci1.basariDurumu();
        ogrenci2.basariDurumu();

        // ogrencilerin genel bilgilerini yazdirma
        System.out.println(ogrenci1);
        System.out.println(ogrenci2);
    }
}
