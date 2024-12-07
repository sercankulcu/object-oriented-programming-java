package ifcondition;
import java.util.Scanner;

public class PozitifNegatif {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sayı girin: ");
        double sayi = scanner.nextDouble();

        if (sayi > 0) {
            System.out.println("Girdiğiniz sayı pozitif.");
        } else if (sayi < 0) {
            System.out.println("Girdiğiniz sayı negatif.");
        } else {
            System.out.println("Girdiğiniz sayı sıfır.");
        }

        scanner.close();
    }
}
