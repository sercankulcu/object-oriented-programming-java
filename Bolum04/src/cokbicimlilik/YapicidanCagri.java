package cokbicimlilik;

// Yapicidan gecersiz kilinabilir metot cagirmak: ust sinif yapicisi alt sinifin
// metodunu, alt sinifin alanlari henuz atanmadan calistirir (metin hala null).
public class YapicidanCagri {

	static class Bilesen {
		Bilesen() {
			System.out.println("Bilesen kuruluyor");
			ciz();
		}
		void ciz() { System.out.println("bos bilesen"); }
	}

	static class Etiket extends Bilesen {
		private String metin = "Merhaba";
		Etiket() { System.out.println("Etiket kuruldu"); }
		@Override void ciz() {
			System.out.println("Etiket: " + metin);
		}
	}

	// ciz() icinde metin.length() kullanilsaydi
	static class Cokme {
		static class Bilesen {
			Bilesen() { ciz(); }
			void ciz() { }
		}
		static class Etiket extends Bilesen {
			private String metin = "Merhaba";
			@Override void ciz() {
				System.out.println(metin.length());
			}
		}
	}

	public static void main(String[] args) {
		Etiket e = new Etiket();
		e.ciz();
		// Bilesen kuruluyor
		// Etiket: null
		// Etiket kuruldu
		// Etiket: Merhaba

		try {
			new Cokme.Etiket();
		} catch (NullPointerException ex) {
			System.out.println("java.lang.NullPointerException: " + ex.getMessage());
			// java.lang.NullPointerException: Cannot invoke "String.length()" because "this.metin" is null
		}
	}
}

/* Beklenen cikti:
Bilesen kuruluyor
Etiket: null
Etiket kuruldu
Etiket: Merhaba
java.lang.NullPointerException: Cannot invoke "String.length()" because "this.metin" is null
*/
