package array;
import java.util.Arrays;
import java.util.Scanner;

public class IkiliArama {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dizi = {5, 7, 10, 13, 12, 9, 9, 21, 22, 11, 17, 6, 5, 2, 44, 3, 14};
        
        System.out.println(Arrays.toString(dizi));
        
        // Sirali bir dizi olustur
        Arrays.sort(dizi);
        
        System.out.println(Arrays.toString(dizi));

        System.out.print("Aranacak degeri girin: ");
        int aranan = scanner.nextInt();

        int sonuc = ikiliArama(dizi, aranan);

        if (sonuc == -1) {
            // Deger bulunamazsa mesaj goster
            System.out.println("Deger bulunamadi.");
        } else {
            // Deger bulunursa indisi yazdir
            System.out.println("Deger bulundu! Indis: " + sonuc);
        }

        scanner.close();
    }

    public static int ikiliArama(int[] dizi, int aranan) {
        int sol = 0;
        int sag = dizi.length - 1;

        // Sol ve sag indeksler arasinda arama yap
        while (sol <= sag) {
            // Ortadaki elemani hesapla
            int orta = sol + (sag - sol) / 2;

            // Ortadaki eleman aranan degere esitse indisi dondur
            if (dizi[orta] == aranan) {
                return orta;
            }

            // Aranan deger ortadaki elemandan buyukse sag tarafina git
            if (dizi[orta] < aranan) {
                sol = orta + 1;
            } else {
                // Aranan deger ortadaki elemandan kucukse sol tarafina git
                sag = orta - 1;
            }
        }

        // Deger bulunamazsa -1 dondur
        return -1;
    }
}
