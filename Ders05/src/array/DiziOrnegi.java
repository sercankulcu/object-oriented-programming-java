// Java'da dizi kullanımını gosteren basit bir program
package array;

public class DiziOrnegi {

    public static void main(String[] args) {
        // Dizi olustur ve elemanlariyla birlikte tanimla
        int[] sayiDizisi = {1, 2, 3, 4, 5};

        // Diziyi ekrana yazdir
        System.out.println("Dizi Elemanlari:");
        for (int i = 0; i < sayiDizisi.length; i++) {
            System.out.print(sayiDizisi[i] + " "); // Her elemani yazdir
        }
        System.out.println();

        // Dizi elemanlarini topla
        int toplam = 0;
        for (int i = 0; i < sayiDizisi.length; i++) {
            toplam += sayiDizisi[i]; // Her elemani toplama ekle
        }

        // Toplami ekrana yazdir
        System.out.println("Dizi Elemanlarinin Toplami: " + toplam);

        // Dizi elemanlarini guncelle
        sayiDizisi[2] = 10; // 3. elemani 10 olarak guncelle

        // Guncellenmis diziyi ekrana yazdir
        System.out.println("Guncellenmis Dizi Elemanlari:");
        for (int i = 0; i < sayiDizisi.length; i++) {
            System.out.print(sayiDizisi[i] + " "); // Guncellenmis diziyi yazdir
        }
    }
}
