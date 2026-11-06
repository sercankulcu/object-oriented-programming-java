import java.util.Arrays;
import java.util.Scanner;

// OrtancaDegerHesaplama: dizi siralanir; tek sayida elemanda ortadaki, cift sayida
// ortadaki iki elemanin ortalamasi alinir. Girdiler sabit dizgilerden okunur.
public class OrtancaDegerHesaplama {

	static void calistir(String girdi) {
		// boyut ve dizi, OrtalamaHesaplama'daki gibi okunur
		Scanner scanner = new Scanner(girdi);
		int boyut = scanner.nextInt();
		double[] dizi = new double[boyut];
		for (int i = 0; i < boyut; i++) {
			dizi[i] = scanner.nextDouble();
		}
		scanner.close();

		Arrays.sort(dizi); // Diziyi sirala
		System.out.print("Elemanlar (sirali):");
		for (double d : dizi) {
			System.out.print(" " + d);
		}
		System.out.println();
		double ortanca;
		if (boyut % 2 == 0) { // Cift sayida eleman
			int orta1 = boyut / 2 - 1;
			int orta2 = boyut / 2;
			ortanca = (dizi[orta1] + dizi[orta2]) / 2;
		} else { // Tek sayida eleman
			ortanca = dizi[boyut / 2];
		}
		System.out.println("Ortanca Deger: " + ortanca);
	}

	public static void main(String[] args) {
		calistir("5 7 3 9 5 1");   // girilenler: 7 3 9 5 1
		// Elemanlar (sirali): 1.0 3.0 5.0 7.0 9.0
		// Ortanca Deger: 5.0
		calistir("4 7 3 9 5");     // cift sayida eleman
		// Elemanlar (sirali): 3.0 5.0 7.0 9.0
		// Ortanca Deger: 6.0
	}
}
