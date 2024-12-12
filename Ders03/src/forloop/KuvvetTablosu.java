package forloop;

public class KuvvetTablosu {
	
    public static void main(String[] args) {
    	
        // Tablo basligini yazdir
        System.out.printf("%8s %8s %8s %8s %8s %8s%n", "Sayi", "^1", "^2", "^3", "^4", "^5");
        // Baslik altina bir ayirac cizgisi ekle
        System.out.println("-------------------------------------------------------");

        // 1'den 10'a kadar olan sayilar icin dongu
        for (int sayi = 1; sayi <= 10; sayi++) {
            // Sayiyi yazdir
            System.out.printf("%9d", sayi);
            // 1'den 5. kuvvete kadar olan degerleri hesaplamak icin ic dongu
            for (int kuvvet = 1; kuvvet <= 5; kuvvet++) {
                // Kuvvet degerini hesapla ve yazdir
                System.out.printf("%9d", (int) Math.pow(sayi, kuvvet));
            }
            // Her sayinin hesaplamasi tamamlandiktan sonra bir alt satira gec
            System.out.println();
        }
    }
}
