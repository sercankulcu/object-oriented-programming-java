package kalitim;

// is-a (kalitim) ve has-a (olusum): Araba bir Arac'tir ve bir Motor'a sahiptir.
// Coklu kalitim: Java'da tek sinif extends edilir, arayuz ise birden fazla uygulanabilir.
public class IsAHasA {

	public static class Arac {
		protected int hiz;
		public void hizlan(int miktar) {
			hiz += miktar;
		}
	}

	public static class Motor {
		private int beygirGucu;
		public Motor(int beygirGucu) { this.beygirGucu = beygirGucu; }
		public void calistir() {
			System.out.println("Motor calisti: " + beygirGucu + " BG");
		}
	}

	// Is-a iliskisi (kalitim)
	public static class Araba extends Arac {
		// Has-a iliskisi (olusum)
		private Motor motor;

		public Araba(int beygirGucu) {
			motor = new Motor(beygirGucu);
		}
		public void yolaCik() {
			motor.calistir();   // Motor'a devret
			hizlan(50);         // Arac'tan miras
			System.out.println("Hiz: " + hiz
							   + " km/sa");
		}
	}

	// Coklu Kalitim
	// class D extends B, C { }   // gecersiz
	// derleme hatasi: '{' expected

	interface Sarj { void sarjEt(); }

	static class ElektrikliAraba extends Araba
						  implements Sarj {
		ElektrikliAraba(int beygirGucu) { super(beygirGucu); }
		@Override
		public void sarjEt() {
			System.out.println("Sarj ediliyor.");
		}
	}

	public static void main(String[] args) {
		new Araba(110).yolaCik();
		// Motor calisti: 110 BG
		// Hiz: 50 km/sa

		ElektrikliAraba e = new ElektrikliAraba(150);
		e.sarjEt();    // Sarj ediliyor.
		e.yolaCik();
		// Motor calisti: 150 BG
		// Hiz: 50 km/sa
	}
}

/* Beklenen cikti:
Motor calisti: 110 BG
Hiz: 50 km/sa
Sarj ediliyor.
Motor calisti: 150 BG
Hiz: 50 km/sa
*/
