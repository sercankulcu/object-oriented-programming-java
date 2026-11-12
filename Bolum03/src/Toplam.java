// Sonsuz Ozyineleme: toplam(0) taban durum n == 1'e hic ulasmaz, yigin tasar.
// StackOverflowError yakalanip mesaji yazdirilir.
public class Toplam {
	static int toplam(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n + toplam(n - 1);
		}
	}
	public static void main(String[] args) {
		try {
			System.out.println(toplam(0));
		} catch (StackOverflowError e) {
			System.out.println(e);   // java.lang.StackOverflowError
		}
	}
}

/* Beklenen cikti:
java.lang.StackOverflowError
*/
