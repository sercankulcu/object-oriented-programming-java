package nesnesinif;

// Referans atama: araba2 = araba1 yeni nesne olusturmaz; iki
// degisken ayni nesneyi gosterir.
public class ReferansAtama {

	static class Araba {
		private String marka;

		public Araba(String marka) {
			this.marka = marka;
		}

		public String getMarka() {
			return marka;
		}

		public void setMarka(String marka) {
			this.marka = marka;
		}
	}

	public static void main(String[] args) {
		Araba araba1 = new Araba("Toyota");
		Araba araba2 = araba1;
		System.out.println("Araba 1: " + araba1.getMarka());   // Araba 1: Toyota
		System.out.println("Araba 2: " + araba2.getMarka());   // Araba 2: Toyota
		araba2.setMarka("Ford");
		System.out.println("Araba 1: " + araba1.getMarka());   // Araba 1: Ford
		araba1 = null;
		System.out.println("Araba 2: " + araba2.getMarka());   // Araba 2: Ford
	}
}

/* Beklenen cikti:
Araba 1: Toyota
Araba 2: Toyota
Araba 1: Ford
Araba 2: Ford
*/
