package kalitim;

import java.util.Objects;

// == ve equals: == referanslari, equals icerigi karsilastirir.
// equals iki bicimde yazilir: instanceof ile (Nokta) ve getClass ile (Kisi).
public class EqualsMetodu {

	static class Nokta {
		private int x, y;
		Nokta(int x, int y) {
			this.x = x; this.y = y;
		}

		public boolean equals(Object nesne) {
			if (nesne instanceof Nokta) {
				// nesne bir Nokta nesnesidir;
				// donusturup karsilastir
				Nokta diger = (Nokta) nesne;
				return x == diger.x && y == diger.y;
			} else {
				// nesne bir Nokta degildir;
				// esit olamaz
				return false;
			}
		}

		// equals ile birlikte hashCode da yazilir (bkz. HashCodeMetodu)
		@Override public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	public static class Kisi {
		private String ad;
		private int yas;

		public Kisi(String ad, int yas) {
			this.ad = ad;
			this.yas = yas;
		}

		@Override
		public boolean equals(Object obj) {
			// ayni referanssa esittir
			if (this == obj) return true;
			// null ya da farkli sinif: esit degil
			if (obj == null
					|| getClass() != obj.getClass())
				return false;
			// alanlari karsilastir
			Kisi kisi = (Kisi) obj;
			return yas == kisi.yas
				   && ad.equals(kisi.ad);
		}

		// equals ile birlikte hashCode da yazilir (bkz. HashCodeMetodu)
		@Override public int hashCode() {
			return Objects.hash(ad, yas);
		}
	}

	public static void main(String[] args) {
		// == ve equals Izleme
		Kisi k1 = new Kisi("Ali", 25);
		Kisi k2 = new Kisi("Ali", 25);
		Kisi k3 = k1;
		System.out.println(k1 == k2);          // false
		System.out.println(k1 == k3);          // true
		System.out.println(k1.equals(k2));     // true

		// equals Metodunu Yazmak
		Nokta a = new Nokta(3, 4);
		Nokta b = new Nokta(3, 4);
		System.out.println(a == b);            // false
		System.out.println(a.equals(b));       // true
		System.out.println(a.equals("3,4"));   // false
		System.out.println(a.equals(null));    // false

		// equals(): Kod Izleme
		Kisi m1 = new Kisi("Ali", 20);
		Kisi m2 = new Kisi("Ali", 20);
		Kisi m3 = new Kisi("Ali", 21);
		System.out.println(m1.equals(m2));     // true
		System.out.println(m1.equals(m3));     // false
		System.out.println(m1.equals(null));   // false
	}
}

/* Beklenen cikti:
false
true
true
false
true
false
false
true
false
false
*/
