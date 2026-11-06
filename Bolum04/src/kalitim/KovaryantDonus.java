package kalitim;

// Kovaryant donus tipi: gecersiz kilan metot alt tip dondurebilir.
// private metotlar gecersiz kilinmaz: alt siniftaki ayni adli metot yeni bir metottur.
public class KovaryantDonus {

	static class Hayvan {
		Hayvan yavrula() { return new Hayvan(); }
		public String toString() { return "Hayvan"; }
	}

	static class Kedi extends Hayvan {
		@Override
		Kedi yavrula() { return new Kedi(); }  // alt tip
		void miyavla() { System.out.println("miyav"); }
		public String toString() { return "Kedi"; }

		// String yavrula() { ... }
		// derleme hatasi: yavrula() in Kedi cannot override
		//   yavrula() in Hayvan
		//   return type String is not compatible with Hayvan
	}

	// private Metotlar Gecersiz Kilinmaz
	static class Ust {
		private void selam() { System.out.println("Ust.selam"); }
		void cagir() { selam(); }
	}

	static class Alt extends Ust {
		void selam() { System.out.println("Alt.selam"); } // yeni
	}

	public static void main(String[] args) {
		Kedi k = new Kedi();
		k.yavrula().miyavla();   // miyav   (donusum gerekmez)
		Hayvan h = k;
		System.out.println(h.yavrula());   // Kedi

		Alt a = new Alt();
		a.cagir();   // Ust.selam
		a.selam();   // Alt.selam
	}
}
