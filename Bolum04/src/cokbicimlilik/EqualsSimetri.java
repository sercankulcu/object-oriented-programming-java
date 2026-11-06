package cokbicimlilik;

// equals ve kalitim: simetri tuzagi. RenkliNokta, equals'i instanceof ile
// daraltinca p.equals(k) true, k.equals(p) false olur.
public class EqualsSimetri {

	static class Nokta {
		final int x, y;
		Nokta(int x, int y) { this.x = x; this.y = y; }
		@Override public boolean equals(Object o) {
			if (!(o instanceof Nokta)) return false;
			Nokta n = (Nokta) o;
			return x == n.x && y == n.y;
		}
		@Override public int hashCode() { return 31 * x + y; }
	}

	// hashCode Nokta'dan miras; sunumdaki hatali equals oldugu gibi birakildi
	static class RenkliNokta extends Nokta {
		final String renk;
		RenkliNokta(int x, int y, String renk) {
			super(x, y);
			this.renk = renk;
		}
		@Override public boolean equals(Object o) {
			if (!(o instanceof RenkliNokta)) return false;
			RenkliNokta r = (RenkliNokta) o;
			return super.equals(r) && renk.equals(r.renk);
		}
	}

	public static void main(String[] args) {
		Nokta p = new Nokta(1, 2);
		RenkliNokta k =
			new RenkliNokta(1, 2, "kirmizi");
		System.out.println(p.equals(k)
			+ " " + k.equals(p));   // true false
	}
}
