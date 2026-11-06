package sarmalama;

// Sozlesmeyi Javadoc ile yazmak: @param, @return ve @throws
// etiketleri on kosulu, son kosulu ve hatayi belgeler.
public class JavadocSozlesme {

	static class Hesap {
		private double bakiye;

		Hesap(double bakiye) {
			this.bakiye = bakiye;
		}

		/**
		 * Hesaptan para ceker.
		 * @param miktar cekilecek tutar; {@code 0 < miktar <= bakiye} olmali
		 * @return islemden sonraki bakiye (eski bakiye - miktar)
		 * @throws IllegalArgumentException miktar bu aralikta degilse
		 */
		public double paraCek(double miktar) {
			if (miktar <= 0 || miktar > bakiye)
				throw new IllegalArgumentException("Gecersiz miktar: " + miktar);
			bakiye -= miktar;
			return bakiye;
		}
	}

	public static void main(String[] args) {
		Hesap h = new Hesap(1000.0);
		System.out.println(h.paraCek(300.0));      // 700.0
		try {
			h.paraCek(5000.0);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());    // Gecersiz miktar: 5000.0
		}
	}
}
