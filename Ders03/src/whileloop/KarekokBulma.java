
package whileloop;

public class KarekokBulma {

    // Bu metod, verilen bir sayinin karekokunu iterative olarak hesaplar
    public static double karekokBul(double sayi) {
        double dusuk = 0.0; // Aramanin alt siniri
        double yuksek = sayi; // Aramanin ust siniri
        double tolerans = 0.00001; // Kabul edilebilir hata payi
        while (yuksek - dusuk > tolerans) {
            double orta = (dusuk + yuksek) / 2; // Ortadaki deger
            double ortaKare = orta * orta; // Ortadaki degerin karesi
            if (ortaKare > sayi) {
                yuksek = orta; // Aralik yukari dogru daraltilir
            } else {
                dusuk = orta; // Aralik asagi dogru daraltilir
            }
        }
        return (dusuk + yuksek) / 2; // Sonuc olarak ortalama deger dondurulur
    }

    public static void main(String[] args) {
        // Ornek sayilarin karekoklerini hesaplama
        double sayi = 10.0;
        double karekok = karekokBul(sayi);
        System.out.println(sayi + " sayisinin karekoku: " + karekok);

        sayi = 16.0;
        karekok = karekokBul(sayi);
        System.out.println(sayi + " sayisinin karekoku: " + karekok);

        sayi = 100.0;
        karekok = karekokBul(sayi);
        System.out.println(sayi + " sayisinin karekoku: " + karekok);
    }
}
