import java.util.Scanner;

// Kosullu akis: if (K) { P } else { Q }. Sayinin tek mi cift mi oldugu.
// Akis Diyagrami Araclari slaytindaki Mermaid diyagrami da bu programi cizer.
public class TekMiCiftMi {
	public static void main(String[] args) {
		Scanner giris = new Scanner("7");
		System.out.print("Sayi: ");  // Sayi: (sunumda 7 klavyeden yansir)
		int sayi = giris.nextInt();
		int sonuc = sayi % 2;
		if (sonuc == 0) {
			System.out.println("cift");
		} else {
			System.out.println("tek");  // tek
		}
		giris.close();
	}
}

/* Beklenen cikti:
Sayi: tek
*/
