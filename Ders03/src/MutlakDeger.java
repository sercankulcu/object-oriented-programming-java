import java.util.Scanner;

public class MutlakDeger {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Bir sayı girin: ");
		double sayi = scanner.nextDouble();

		double mutlakDeger;

		if (sayi < 0) {
			mutlakDeger = -sayi;
		} else {
			mutlakDeger = sayi;
		}

		System.out.println("Girdiğiniz sayının mutlak değeri: " + mutlakDeger);

		scanner.close();
	}
}
