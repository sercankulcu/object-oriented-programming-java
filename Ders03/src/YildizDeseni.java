
import java.util.Scanner;

public class YildizDeseni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Satır sayısını girin: ");
        int satirSayisi = scanner.nextInt();

        for (int i = 1; i <= satirSayisi; i++) {
            for (int j = 1; j <= satirSayisi - i; j++) {
                System.out.print(" "); // Boşlukları ekrana yazdır
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*"); // Yıldızları ekrana yazdır
            }
            System.out.println(); // Yeni satıra geç
        }

        scanner.close();
    }
}
