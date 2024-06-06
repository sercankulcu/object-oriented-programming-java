import java.util.Scanner;

public class FaktoriyelHesaplama {

	public static long faktoriyel(int sayi) 
	{
		long faktoriyel = 1;

		if (sayi < 0) {
			System.out.println("Negatif sayının faktoriyeli hesaplanamaz.");
		} else if (sayi == 0) {
			System.out.println("0! = 1");
		} else {
			for (int i = 1; i <= sayi; i++) {
				faktoriyel *= i;
			}
			System.out.println(sayi + "! = " + faktoriyel);
		}
		return faktoriyel;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Bir sayı girin: ");
		int sayi = scanner.nextInt();
		scanner.close();

		FaktoriyelHesaplama.faktoriyel(sayi);
	}
}
