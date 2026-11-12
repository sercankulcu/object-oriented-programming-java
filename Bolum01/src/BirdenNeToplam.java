import java.util.Scanner;

// Uygulama: 1'den n'e toplam (biriktirici). Sunumdaki n = 5 ve
// "Diyagrami Sinamak" test durumlari (0, 1, 4, -3) ile calisir.
public class BirdenNeToplam {

	static void calistir(Scanner giris) {
		System.out.print("n: ");
		int n = giris.nextInt();
		int toplam = 0;
		int i = 1;
		while (i <= n) {
			toplam += i;
			i += 1;
		}
		System.out.println("Toplam: " + toplam);
	}

	public static void main(String[] args) {
		calistir(new Scanner("5"));   // n: Toplam: 15
		calistir(new Scanner("0"));   // n: Toplam: 0
		calistir(new Scanner("1"));   // n: Toplam: 1
		calistir(new Scanner("4"));   // n: Toplam: 10
		calistir(new Scanner("-3"));  // n: Toplam: 0
	}
}

/* Beklenen cikti:
n: Toplam: 15
n: Toplam: 0
n: Toplam: 1
n: Toplam: 10
n: Toplam: 0
*/
