package kalitim;

import java.util.HashSet;
import java.util.Objects;

// equals ve hashCode birlikte: esit nesneler ayni hash kodunu vermeli ki
// HashSet onlari ayni kova icinde bulup tekrar eklemesin.
public class HashCodeMetodu {

	public static class Nokta {
		private int x, y;
		public Nokta(int x, int y) {
			this.x = x; this.y = y;
		}
		@Override public boolean equals(Object o) {
			return (o instanceof Nokta n)
				   && x == n.x && y == n.y;
		}
		@Override public int hashCode() {
			return Objects.hash(x, y);
		}
		@Override public String toString() {
			return "Nokta[x=" + x + ", y=" + y + "]";
		}
	}

	// HashSet, equals ve hashCode: Kod Izleme surumu
	static class Izleme {
		static class Nokta {
			private int x, y;
			Nokta(int x, int y) {
				this.x = x; this.y = y;
			}
			public boolean equals(Object o) {
				if (!(o instanceof Nokta)) return false;
				Nokta n = (Nokta) o;
				return x == n.x && y == n.y;
			}
			public int hashCode() {
				return Objects.hash(x, y);  // 31*(31 + x) + y
			}
		}
	}

	public static void main(String[] args) {
		HashSet<Nokta> kume = new HashSet<>();
		kume.add(new Nokta(3, 4));
		kume.add(new Nokta(3, 4));
		System.out.println(kume.size() + " "
			+ kume.contains(new Nokta(3, 4)));   // 1 true

		HashSet<Izleme.Nokta> kume2 = new HashSet<>();
		kume2.add(new Izleme.Nokta(3, 4));
		kume2.add(new Izleme.Nokta(4, 3));
		kume2.add(new Izleme.Nokta(3, 4));
		System.out.println(kume2.size());                              // 2
		System.out.println(kume2.contains(new Izleme.Nokta(4, 3)));    // true
		System.out.println(new Izleme.Nokta(3, 4).hashCode());         // 1058 = 31*(31+3)+4
	}
}
