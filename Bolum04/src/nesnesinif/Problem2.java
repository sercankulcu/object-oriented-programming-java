package nesnesinif;

// Ornek problem 2: referans atama ayni nesneyi paylastirir;
// == degeri degil referansi karsilastirir.
public class Problem2 {

	static class Kutu { int deger; }

	public static void main(String[] args) {
		Kutu k1 = new Kutu();
		k1.deger = 5;
		Kutu k2 = k1;
		k2.deger = 9;
		Kutu k3 = new Kutu();
		k3.deger = 9;
		System.out.println(k1.deger);     // 9
		System.out.println(k1 == k2);     // true
		System.out.println(k2 == k3);     // false
	}
}

/* Beklenen cikti:
9
true
false
*/
