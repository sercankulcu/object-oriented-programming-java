import java.util.Scanner;

public class FaktoriyelHesaplama {
	
	public static int faktoriyel(int sayi) {
		int sonuc = 1;
		for (int i = 1; i <= sayi; i++) {
			sonuc *= i;
		}
		return sonuc;
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Faktoriyelini hesaplamak istediğiniz sayıyı girin: ");
		int sayi = scanner.nextInt();
		System.out.println(sayi + " sayısının faktoriyeli: " + faktoriyel(sayi));

		scanner.close();
	}
}
