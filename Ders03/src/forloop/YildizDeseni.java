package forloop;

import java.util.Scanner;

public class YildizDeseni {

    // Birinci desenin cizimi (Piramid)
    public void cizdir1(int satirSayisi) {
        for (int i = 1; i <= satirSayisi; i++) {
            for (int j = 1; j <= satirSayisi - i; j++) {
                System.out.print(" "); // Bosluklari ekrana yazdir
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*"); // Yildizlari ekrana yazdir
            }
            System.out.println(); // Yeni satira gecer
        }
    }

    // ikinci desenin cizimi (Ters Piramit)
    public void cizdir2(int satirSayisi) {
        for (int i = satirSayisi; i > 0; i--) {
            for (int j = 1; j <= satirSayisi - i; j++) {
                System.out.print(" "); // Bosluklari ekrana yazdir
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*"); // Yildizlari ekrana yazdir
            }
            System.out.println(); // Yeni satira gecer
        }
    }

    // ucuncu desenin cizimi (Duz Satir Yildizlari)
    public void cizdir3(int satirSayisi) {
        for (int i = 1; i <= satirSayisi; i++) {
            for (int j = 1; j <= satirSayisi; j++) {
                System.out.print("* "); // Yildizlari ekrana yazdir
            }
            System.out.println(); // Yeni satira gecer
        }
    }

    // Dorduncu desenin cizimi (cift Yonlu Piramit)
    public void cizdir4(int satirSayisi) {
        for (int i = 1; i <= satirSayisi; i++) {
            for (int j = 1; j <= satirSayisi - i; j++) {
                System.out.print(" "); // Bosluklari ekrana yazdir
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*"); // Yildizlari ekrana yazdir
            }
            System.out.println(); // Yeni satira gecer
        }
        for (int i = satirSayisi - 1; i >= 1; i--) {
            for (int j = 1; j <= satirSayisi - i; j++) {
                System.out.print(" "); // Bosluklari ekrana yazdir
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*"); // Yildizlari ekrana yazdir
            }
            System.out.println(); // Yeni satira gecer
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Kullanicidan satir sayisini alma
        System.out.print("Satir sayisini girin: ");
        int satirSayisi = scanner.nextInt();

        // YildizDeseni nesnesi olusturuluyor
        YildizDeseni desen = new YildizDeseni();

        // Birinci desen (Piramid) cizdiriliyor
        System.out.println("Birinci Desen (Piramid):");
        desen.cizdir1(satirSayisi);

        // ikinci desen (Ters Piramit) cizdiriliyor
        System.out.println("ikinci Desen (Ters Piramit):");
        desen.cizdir2(satirSayisi);

        // ucuncu desen (Duz Satir Yildizlari) cizdiriliyor
        System.out.println("Ucuncu Desen (Duz Satir Yildizlari):");
        desen.cizdir3(satirSayisi);

        // Dorduncu desen (Cift Yonlu Piramit) cizdiriliyor
        System.out.println("Dorduncu Desen (Cift Yonlu Piramit):");
        desen.cizdir4(satirSayisi);

        // Scanner nesnesi kapatiliyor
        scanner.close();
    }
}
