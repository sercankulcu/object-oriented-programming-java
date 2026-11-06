package nesnesinif;

// Ornek problem 6: equals yazilmamis sinifta Object.equals referans
// karsilastirir; int alanlar == ile deger olarak karsilastirilir.
public class Problem6 {

	static class Nokta {
		int x, y;
		Nokta(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Nokta a = new Nokta(1, 2);
		Nokta b = new Nokta(1, 2);
		System.out.println(a.equals(b));   // false
		System.out.println(a.x == b.x);    // true
	}
}
