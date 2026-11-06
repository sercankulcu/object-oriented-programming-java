package sarmalama;

import java.util.Scanner;
import static java.lang.Math.sqrt;

// Ice aktarma (import): sinif importu, static import ve tam adla
// (java.util.Random) kullanim. Scanner sabit "49" dizgisinden okur.
public class ImportOrnek {
	public static void main(String[] args) {
		Scanner giris = new Scanner("49");   // girdi: 49 (System.in yerine)
		int sayi = giris.nextInt();
		java.util.Random rastgele =
				new java.util.Random(42);
		System.out.println(sqrt(sayi) + " "
				+ Math.max(sayi, 10) + " "
				+ rastgele.nextInt(100));    // 7.0 49 30
		giris.close();
	}
}
