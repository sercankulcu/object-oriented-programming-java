package nesnesinif;

// Ornek problem 1: static alan butun nesnelerde ortak, ornek alani
// her nesnede ayridir.
public class Problem1 {

	static class Sayac {
		static int toplam = 0;
		int adet = 0;
		void arttir() { toplam++; adet++; }
	}

	public static void main(String[] args) {
		Sayac a = new Sayac(), b = new Sayac();
		a.arttir(); a.arttir(); b.arttir();
		System.out.print(a.adet + " " + b.adet);
		System.out.println(" " + Sayac.toplam);   // 2 1 3
	}
}

/* Beklenen cikti:
2 1 3
*/
