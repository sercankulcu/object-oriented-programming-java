package forloop;

import java.util.Random;

public class RastgeleSayiUret {

    public static void main(String[] args) {

        // Random nesnesi olusturulur
        Random rastgele = new Random();

        // 35'ten kucuk ve buyuk sayilarin sayilari icin sayaclar
        int otuzbesdenkucukler = 0;
        int otuzbesdenbuyukler = 0;

        // 10,000 rastgele sayi uretilecek dongu
        for (int i = 0; i < 10000; i++) {
            // 0 ile 99 arasinda rastgele bir sayi uret
            int sayi = rastgele.nextInt(100);

            // Uretilen sayiyi ekrana yazdir
            System.out.println(sayi + " ");

            // Sayi 35'ten kucukse, sayaci bir artir
            if (sayi < 35) {
                otuzbesdenkucukler++;
            } else {
                // Sayi 35 veya daha buyukse, sayaci bir artir
                otuzbesdenbuyukler++;
            }
        }

        // Sonuclari ekrana yazdir
        System.out.println("\nKucukler: " + otuzbesdenkucukler + 
                           " Buyukler: " + otuzbesdenbuyukler);
    }
}
