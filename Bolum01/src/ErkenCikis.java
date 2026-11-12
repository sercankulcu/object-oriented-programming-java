import java.util.Scanner;

// Donguden Erken Cikis: ilk negatif sayinin sirasini bulur.
// Iki surum: bayrakli (tek cikisli) ve break'li. Girdi: 4 9 -2.
public class ErkenCikis {

	// Tek cikisli, yapisal surum: bayrak
	static void bayrakli(Scanner giris) {
		int bulunan = 0;
		boolean bulundu = false;
		for (int i = 1; i <= 5 && !bulundu; i++) {
			int x = giris.nextInt();
			if (x < 0) {
				bulunan = i;
				bulundu = true;
			}
		}
		System.out.println("Sira: " + bulunan);
	}

	// break ile ikinci cikis
	static void breakli(Scanner giris) {
		int bulunan = 0;
		for (int i = 1; i <= 5; i++) {
			int x = giris.nextInt();
			if (x < 0) {
				bulunan = i;
				break;
			}
		}
		System.out.println("Sira: " + bulunan);
	}

	public static void main(String[] args) {
		bayrakli(new Scanner("4 9 -2"));  // Sira: 3
		breakli(new Scanner("4 9 -2"));   // Sira: 3
	}
}

/* Beklenen cikti:
Sira: 3
Sira: 3
*/
