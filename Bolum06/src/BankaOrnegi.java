// Banka ornegi izleme: bakiye yetersizse paraCek YetersizBakiyeHatasi
// firlatir; sonraki cekim hic denenmez.
public class BankaOrnegi {

	static class Hesap {
		private double bakiye;
		Hesap(double bakiye) { this.bakiye = bakiye; }
		public void paraCek(double miktar)
				throws YetersizBakiyeHatasi {
			if (miktar > bakiye) {
				throw new YetersizBakiyeHatasi(
					"Bakiye yetersiz", miktar - bakiye);
			}
			bakiye -= miktar;
			System.out.println("Kalan: " + bakiye);
		}
	}

	public static void main(String[] args) {
		Hesap hesap = new Hesap(100);
		try {
			hesap.paraCek(30);   // Kalan: 70.0
			hesap.paraCek(90);
			hesap.paraCek(10);
		} catch (YetersizBakiyeHatasi e) {
			System.out.println(e.getMessage()
				+ ", eksik: " + e.getEksik());   // Bakiye yetersiz, eksik: 20.0
		}
	}
}

/* Beklenen cikti:
Kalan: 70.0
Bakiye yetersiz, eksik: 20.0
*/
