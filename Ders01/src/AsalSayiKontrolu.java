import java.util.Scanner;

public class AsalSayiKontrolu {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Kullanicidan bir sayi alinmasi
        System.out.print("Bir sayi girin: ");
        int sayi = scanner.nextInt();

        // Girilen sayi 1 veya daha kucukse, kullanicidan tekrar dogru bir sayi istenir
        while (sayi <= 1) {
            System.out.println("Lutfen 2'den buyuk bir pozitif sayi girin.");
            sayi = scanner.nextInt();
        }
        
        scanner.close(); // Scanner kaynaginin kapatilmasi

        boolean asal = true; // Asal olup olmadigini kontrol eden degisken

        // Asallik kontrolu icin dongu
        for (int i = 2; i <= sayi / 2; i++) {
            if (sayi % i == 0) { // Sayi, i'ye tam bolunuyorsa asal degildir
                asal = false;
                break; // Kontrolu sonlandir
            }
        }

        // Asallik durumunun yazdirilmasi
        if (asal) {
            System.out.println(sayi + " asal sayidir.");
        } else {
            System.out.println(sayi + " asal sayi degildir.");
        }
    }
}
