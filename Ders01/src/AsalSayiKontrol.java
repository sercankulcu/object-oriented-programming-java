import java.util.Scanner;

public class AsalSayiKontrol {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Bir sayı girin: ");
		int sayi = scanner.nextInt();

		while (sayi <= 1) {
			System.out.println("Lütfen 2'den büyük bir pozitif sayı girin.");
			sayi = scanner.nextInt();
		}
		
		scanner.close();

		boolean asal = true;

		for (int i = 2; i <= sayi / 2; i++) {
			if (sayi % i == 0) {
				asal = false;
				break;
			}
		}

		if (asal) {
			System.out.println(sayi + " asal sayıdır.");
		} else {
			System.out.println(sayi + " asal sayı değildir.");
		}
	}
}
