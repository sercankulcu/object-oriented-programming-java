import java.util.Scanner;

public class FaktoriyelHesaplama {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Faktoriyelini hesaplamak istediğiniz sayıyı girin: ");
		int sayi = scanner.nextInt();

		int faktoriyel = 1;

		for (int i = 1; i <= sayi; i++) {
			faktoriyel *= i;
		}

		System.out.println(sayi + " sayısının faktoriyeli: " + faktoriyel);

		scanner.close();
	}
}
