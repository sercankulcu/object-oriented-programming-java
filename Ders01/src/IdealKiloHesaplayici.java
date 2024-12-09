import java.util.Scanner;

public class IdealKiloHesaplayici {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Kullanicidan boyunu metre cinsinden girmesini iste
		System.out.print("Boyunuzu metre cinsinden giriniz: ");
		double boy = scanner.nextDouble();
		scanner.close();

		// Kullanıcının boyuna gore ideal kilosunu hesapla
		double idealKilo = 0;
		if (boy > 1.5) {
			idealKilo = (boy - 1.5) * 90 + 50;
		} else {
			idealKilo = 50;
		}

		// Ideal kiloyu yazdir
		System.out.println("Ideal kilonuz: " + idealKilo + " kilogram");
	}
}
