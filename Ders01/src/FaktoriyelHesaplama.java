import java.util.Scanner;

public class FaktoriyelHesaplama {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Faktoriyelini hesaplamak istediğiniz sayıyı girin: ");
		int sayi = scanner.nextInt();

		scanner.close();

		long faktoriyel = 1;

		if (sayi < 0) {
			System.out.println("Negatif bir sayının faktoriyeli hesaplanamaz.");
		} else if (sayi == 0) {
			System.out.println("0! = 1");
		} else {
			for (int i = 1; i <= sayi; i++) {
				faktoriyel *= i;
			}
			System.out.println(sayi + "! = " + faktoriyel);
		}
	}
}
