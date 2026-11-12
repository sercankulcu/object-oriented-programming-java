package nesnesinif;

import java.io.Serializable;

// Siniflar ve tipler: bir nesne, sinifinin, ust siniflarinin ve
// gerceklenen butun arayuzlerin tipine sahiptir.
public class SiniflarVeTipler {

	interface Printable {
		void yazdir();
	}

	interface Runner {
		void kos();
	}

	static class Hayvan implements Printable, Serializable {
		private static final long serialVersionUID = 1L;
		String ad;
		Hayvan(String ad) {
			this.ad = ad;
		}
		public void yazdir() {
			System.out.println("Hayvan: " + ad);
		}
	}

	static class Kopek extends Hayvan implements Runner {
		private static final long serialVersionUID = 1L;
		Kopek(String ad) {
			super(ad);
		}
		public void kos() {
			System.out.println(ad + " kosuyor.");
		}
	}

	public static void main(String[] args) {
		var kazanan = new Kopek("Karabas");
		kazanan.yazdir();      // Hayvan: Karabas
		kazanan.kos();         // Karabas kosuyor.
		System.out.println(kazanan instanceof Hayvan);        // true
		System.out.println(kazanan instanceof Printable);     // true
		System.out.println(kazanan instanceof Runner);        // true
		System.out.println(kazanan instanceof Serializable);  // true
	}
}

/* Beklenen cikti:
Hayvan: Karabas
Karabas kosuyor.
true
true
true
true
*/
