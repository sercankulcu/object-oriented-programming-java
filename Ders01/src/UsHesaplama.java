import java.util.Scanner;

public class UsHesaplama {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Taban sayısını girin: ");
		double taban = scanner.nextDouble();

		System.out.print("Üs sayısını girin: ");
		int us = scanner.nextInt();

		scanner.close();

		double sonuc = usHesapla(taban, us);

		System.out.println(taban + " üzeri " + us + " = " + sonuc);
	}

	public static double usHesapla(double taban, int us) {
		if (us == 0) {
			return 1; // Herhangi bir sayının 0. üssü 1'dir.
		} else if (us < 0) {
			return 1.0 / (taban * usHesapla(taban, -us - 1)); // Negatif üs için hesaplama
		} else {
			double sonuc = 1;
			for (int i = 0; i < us; i++) {
				sonuc *= taban;
			}
			return sonuc;
		}
	}
}
