// Hesaplamanin Yapi Taslari: matematik, mantik ve karar.
public class Hesaplama {
	public static void main(String[] args) {
		int a = 7, b = 3;
		int toplam = a + b;     // matematik
		int carpim = a * b;     // matematik
		boolean gunesli = true; // mantik
		System.out.println("Toplam: " + toplam);  // Toplam: 10
		System.out.println("Carpim: " + carpim);  // Carpim: 21
		if (gunesli) {          // karar
			System.out.println("Disari cik");     // Disari cik
		}
	}
}
