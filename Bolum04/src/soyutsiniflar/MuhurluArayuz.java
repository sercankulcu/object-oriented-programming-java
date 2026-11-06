package soyutsiniflar;

// Muhurlu (sealed) arayuz: yalnizca permits listesindeki turler uygulayabilir.
// Java 21 switch tum alt turleri kapsadigi icin default dali gerekmez.
public class MuhurluArayuz {

	public sealed interface Hayvan permits Kedi, Kopek {
		void hareketEt();
	}

	static final class Kedi implements Hayvan {
		public void hareketEt() {
			System.out.println("Kedi sessizce yuruyor");
		}
	}

	static non-sealed class Kopek implements Hayvan {
		public void hareketEt() {
			System.out.println("Kopek kosuyor");
		}
	}

	static class Kangal extends Kopek {   // serbest
		public void hareketEt() {
			System.out.println("Kangal suruyu koruyor");
		}
	}

	// Java 21: switch tum alt turleri kapsar,
	// default dali gerekmez
	static String tur(Hayvan h) {
		return switch (h) {
			case Kedi k -> "kedi";
			case Kopek k -> "kopek";
		};
	}

	public static void main(String[] args) {
		Hayvan[] hayvanlar =
			{ new Kedi(), new Kopek(), new Kangal() };
		for (Hayvan h : hayvanlar) {
			h.hareketEt();
			System.out.println(tur(h));
		}
		// Kedi sessizce yuruyor
		// kedi
		// Kopek kosuyor
		// kopek
		// Kangal suruyu koruyor
		// kopek
	}
}
