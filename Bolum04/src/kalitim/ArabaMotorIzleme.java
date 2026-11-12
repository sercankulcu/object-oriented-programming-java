package kalitim;

// Araba ve Motor: Kod Izleme. Kalitim (hiz, hizlan) ve olusum (motor)
// ayni sinifta birlikte calisir.
public class ArabaMotorIzleme {

	static class Arac {
		protected int hiz;
		void hizlan(int miktar) { hiz += miktar; }
	}

	static class Motor {
		private int bg;
		Motor(int bg) { this.bg = bg; }
		void calistir() {
			System.out.println("Motor: " + bg + " BG");
		}
	}

	static class Araba extends Arac {        // is-a
		private Motor motor;           // has-a
		Araba(int bg) { motor = new Motor(bg); }
		void yolaCik() {
			motor.calistir();  hizlan(50);
			System.out.println("Hiz: " + hiz);
		}
	}

	public static void main(String[] args) {
		new Araba(90).yolaCik();
		// Motor: 90 BG
		// Hiz: 50
	}
}

/* Beklenen cikti:
Motor: 90 BG
Hiz: 50
*/
