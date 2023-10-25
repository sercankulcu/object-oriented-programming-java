import java.util.Scanner;

public class MevsimHesaplamaIfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir ay girin (1-12): ");
        int ay = scanner.nextInt();

        String mevsim;

        if (ay >= 3 && ay <= 5) {
            mevsim = "İlkbahar";
        } else if (ay >= 6 && ay <= 8) {
            mevsim = "Yaz";
        } else if (ay >= 9 && ay <= 11) {
            mevsim = "Sonbahar";
        } else if (ay == 12 || ay == 1 || ay == 2) {
            mevsim = "Kış";
        } else {
            mevsim = "Geçersiz ay";
        }

        System.out.println("Girdiğiniz ayın mevsimi: " + mevsim);

        scanner.close();
    }
}
