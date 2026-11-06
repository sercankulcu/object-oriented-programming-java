import java.util.Scanner;

// else-if zinciri: sayinin pozitif, negatif ya da sifir oldugunu bulur.
// Sunumdaki uc girdi (4, -2, 0) sabit dizgilerden okunur.
public class PozitifNegatif {

	// Sunumdaki main govdesi; Scanner klavye yerine verilen dizgiden okur
	static void calistir(String girdi) {
		Scanner scanner = new Scanner(girdi);
		System.out.print("Bir sayi girin: ");
		double sayi = scanner.nextDouble();
		if (sayi > 0) {
			System.out.println("Sayi pozitif.");
		} else if (sayi < 0) {
			System.out.println("Sayi negatif.");
		} else {
			System.out.println("Sayi sifir.");
		}
		scanner.close();
	}

	public static void main(String[] args) {
		calistir("4");     // Bir sayi girin: Sayi pozitif.
		calistir("-2");    // Bir sayi girin: Sayi negatif.
		calistir("0");     // Bir sayi girin: Sayi sifir.
	}
}
