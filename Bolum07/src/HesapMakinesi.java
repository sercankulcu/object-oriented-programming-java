// Elle ve JUnit ile test edilecek basit hesap makinesi.
public class HesapMakinesi {
	public int topla(int a, int b) {
		return a + b;
	}

	public int carp(int a, int b) {
		return a * b;
	}

	public static void main(String[] args) {
		HesapMakinesi hm = new HesapMakinesi();
		System.out.println(hm.topla(2, 3));   // 5
		System.out.println(hm.carp(2, -3));   // -6
	}
}

/* Beklenen cikti:
5
-6
*/
