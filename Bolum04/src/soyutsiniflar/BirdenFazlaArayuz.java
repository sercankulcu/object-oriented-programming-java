package soyutsiniflar;

// Birden fazla arayuz: Ordek bir siniftan turer ve iki arayuzu uygular.
// Ayni nesneyi farkli arayuz referanslari farkli yonleriyle gorur.
public class BirdenFazlaArayuz {

	static class Hayvan {
		String isim;
		Hayvan(String isim) { this.isim = isim; }
	}

	interface Ucabilir { void uc(); }
	interface Yuzebilir { void yuz(); }

	static class Ordek extends Hayvan implements Ucabilir, Yuzebilir {
		Ordek(String isim) { super(isim); }
		public void uc() { System.out.println(isim + " ucuyor"); }
		public void yuz() { System.out.println(isim + " yuzuyor"); }
	}

	// Hangisini Secmeli? Ortak durum soyut sinifta, yetenekler arayuzlerde
	static class Secim {
		interface Sesli { String ses(); }
		abstract static class Hayvan implements Sesli {
			String isim;
			Hayvan(String isim) { this.isim = isim; }
		}
		static class Ordek extends Hayvan implements Ucabilir, Yuzebilir {
			Ordek(String isim) { super(isim); }
			public String ses() { return "vak"; }
			public void uc() { System.out.println(isim + " ucuyor"); }
			public void yuz() { System.out.println(isim + " yuzuyor"); }
		}
	}

	public static void main(String[] args) {
		Ordek o = new Ordek("Donald");
		Ucabilir u = o;
		Yuzebilir y = o;
		u.uc();                        // Donald ucuyor
		y.yuz();                       // Donald yuzuyor
		// u.yuz();   derleme hatasi!
		System.out.println(o.isim);    // Donald
		System.out.println(u == o);    // true

		Secim.Hayvan h = new Secim.Ordek("Daisy");
		System.out.println(h.isim + ": " + h.ses());   // Daisy: vak
	}
}
