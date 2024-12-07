package eamples;
import java.util.Scanner;

public class Toplama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Birinci sayıyı girin: ");
        double sayi1 = scanner.nextDouble();

        System.out.print("İkinci sayıyı girin: ");
        double sayi2 = scanner.nextDouble();

        double toplam = sayi1 + sayi2;

        System.out.println("Sonuç: " + toplam);

        scanner.close();
    }
}
