package nesnesinif;

// Ornek problem 5: record equals icerigi, == referansi karsilastirir;
// Integer icin equals her zaman guvenlidir.
public class Problem5 {

	record Para(int lira) { }

	public static void main(String[] args) {
		Para p1 = new Para(10);
		Para p2 = new Para(10);
		Integer i1 = 1000, i2 = 1000;
		System.out.println(p1.equals(p2));   // true
		System.out.println(p1 == p2);        // false
		System.out.println(i1.equals(i2));   // true
		System.out.println(p1);              // Para[lira=10]
	}
}

/* Beklenen cikti:
true
false
true
Para[lira=10]
*/
