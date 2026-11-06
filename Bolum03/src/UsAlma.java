import java.util.Scanner;

// Us Alma (for): taban^us degerini dongu ile ve Math.pow ile hesaplar.
// Girdi (3 4) klavye yerine sabit dizgiden okunur.
public class UsAlma {
	public static void main(String[] args) {
		Scanner tarayici = new Scanner("3 4");
		System.out.print("Taban ve us girin: ");
		int taban = tarayici.nextInt();
		int us = tarayici.nextInt();
		long sonuc = 1;
		for (int i = 1; i <= us; i++) {
			sonuc = sonuc * taban;
		}
		System.out.println("Sonuc: " + sonuc);                 // Taban ve us girin: Sonuc: 81
		System.out.println("Math.pow: " + Math.pow(taban, us)); // Math.pow: 81.0
		tarayici.close();
	}
}
