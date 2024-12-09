import java.util.Scanner;

public class ArtanSiraBesSayi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 5 sayiyi saklamak icin degiskenler
        int sayi1, sayi2, sayi3, sayi4, sayi5;

        // Kullanicidan sayilarin alinmasi
        System.out.println("5 adet sayi giriniz:");
        System.out.print("1. sayi: ");
        sayi1 = scanner.nextInt();
        System.out.print("2. sayi: ");
        sayi2 = scanner.nextInt();
        System.out.print("3. sayi: ");
        sayi3 = scanner.nextInt();
        System.out.print("4. sayi: ");
        sayi4 = scanner.nextInt();
        System.out.print("5. sayi: ");
        sayi5 = scanner.nextInt();
        
        scanner.close();

        // Siralama algoritmasi (basit karsilastirmalar)
        if (sayi1 > sayi2) { int gecici = sayi1; sayi1 = sayi2; sayi2 = gecici; }
        if (sayi2 > sayi3) { int gecici = sayi2; sayi2 = sayi3; sayi3 = gecici; }
        if (sayi3 > sayi4) { int gecici = sayi3; sayi3 = sayi4; sayi4 = gecici; }
        if (sayi4 > sayi5) { int gecici = sayi4; sayi4 = sayi5; sayi5 = gecici; }

        if (sayi1 > sayi2) { int gecici = sayi1; sayi1 = sayi2; sayi2 = gecici; }
        if (sayi2 > sayi3) { int gecici = sayi2; sayi2 = sayi3; sayi3 = gecici; }
        if (sayi3 > sayi4) { int gecici = sayi3; sayi3 = sayi4; sayi4 = gecici; }

        if (sayi1 > sayi2) { int gecici = sayi1; sayi1 = sayi2; sayi2 = gecici; }
        if (sayi2 > sayi3) { int gecici = sayi2; sayi2 = sayi3; sayi3 = gecici; }

        if (sayi1 > sayi2) { int gecici = sayi1; sayi1 = sayi2; sayi2 = gecici; }

        // Siralanmis sayilarin yazdirilmasi
        System.out.println("Sayilar kucukten buyuge sirali:");
        System.out.println(sayi1);
        System.out.println(sayi2);
        System.out.println(sayi3);
        System.out.println(sayi4);
        System.out.println(sayi5);
    }
}
