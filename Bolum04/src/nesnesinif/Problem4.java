package nesnesinif;

// Ornek problem 4: metot referansin kopyasini alir; nesneyi
// degistirebilir ama cagirandaki degiskeni degistiremez.
public class Problem4 {

	static class Kutu { int deger; }

	static void degistir(Kutu k) {
		k.deger = 100;
		k = new Kutu();
		k.deger = 7;
	}

	public static void main(String[] args) {
		Kutu x = new Kutu();
		x.deger = 1;
		degistir(x);
		System.out.println(x.deger);   // 100
	}
}

/* Beklenen cikti:
100
*/
