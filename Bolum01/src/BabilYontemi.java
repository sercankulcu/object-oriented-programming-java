// Babil Yontemi: karekoku art arda tahminlerle bulur (x = 16, y0 = 1).
public class BabilYontemi {
	public static void main(String[] args) {
		double x = 16;   // karekoku aranan sayi
		double y = 1;    // baslangic tahmini y0
		while (Math.abs(y * y - x) > 0.001) {
			y = (y + x / y) / 2;   // yeni tahmin
			System.out.println(y);
		}
		// 8.5
		// 5.1911764705882355
		// 4.136664722546242
		// 4.002257524798522
		// 4.000000636692939
		System.out.println("Karekok ~ " + y);  // Karekok ~ 4.000000636692939
	}
}
