package nesnesinif;

// Alan tanimlamalari: ornege ait, sinifa ait (static), sabit (final)
// alanlar ve erisim belirleyicileri.
public class Alanlar {
	public int a;                         // genel
	int b = 1, c = 2;                     // varsayilan (paket)
	private double x;                     // ozel
	private static int xx;                // statik, ozel
	public static int y;                  // statik, genel
	public final int CONST1 = 5;          // degistirilemez
	private static final int CONST2 = 6;  // statik sabit

	static class Kitap {
		// Ornege ait alanlar
		private String baslik;
		private String yazar;
		private int sayfaSayisi;
		// Sinifa ait alan
		private static int toplamKitapSayisi;
		// final tanimlanmis bir alan (sabit)
		public static final double PI = 3.14159265359;
	}

	public static void main(String[] args) {
		Kitap k = new Kitap();
		System.out.println(k.baslik + " " + k.yazar + " " + k.sayfaSayisi);  // null null 0
		System.out.println(Kitap.toplamKitapSayisi + " " + Kitap.PI);       // 0 3.14159265359

		Alanlar n = new Alanlar();
		System.out.println(n.a + " " + n.b + " " + n.c + " " + n.x);         // 0 1 2 0.0
		System.out.println(xx + " " + y + " " + n.CONST1 + " " + CONST2);    // 0 0 5 6
	}
}
