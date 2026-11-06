package nesnesinif;

// Varsayilan yapici: hic yapici yazilmayan sinifta alanlar
// varsayilan degerlerini (0, 0.0, false, bos karakter, null) alir.
public class Varsayilan {

	static class Nokta3 {
		int x;
		double agirlik;
		boolean gorunur;
		char harf;
		String ad;
	}

	public static void main(String[] args) {
		Nokta3 n = new Nokta3();   // varsayilan yapici
		System.out.println(n.x + " " + n.agirlik);     // 0 0.0
		System.out.println(n.gorunur + " " + n.ad);    // false null
		System.out.println((int) n.harf);              // 0
	}
}
