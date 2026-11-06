package sarmalama;

// Sozlesme: on kosul bozuksa veriEkle false doner; basarili
// eklemede kayitSayisi bir artar (son kosul).
public class Sozlesme {

	static class VeriIslemleri {
		private int kayitSayisi = 0;

		/**
		 * Veri tabanina bir kayit ekler.
		 * On kosul: veri null degil ve bos degil.
		 * Son kosul: eklendiyse true doner,
		 *            kayitSayisi 1 artar.
		 */
		public boolean veriEkle(String veri) {
			if (veri == null || veri.isEmpty()) {
				return false;   // on kosul bozuk
			}
			// ... veriyi veri tabanina ekle ...
			kayitSayisi++;
			return true;        // son kosul saglandi
		}

		public int getKayitSayisi() {
			return kayitSayisi;
		}
	}

	public static void main(String[] args) {
		// Tam ornek
		VeriIslemleri islem = new VeriIslemleri();
		System.out.println(islem.veriEkle("Ali"));     // true
		System.out.println(islem.veriEkle(""));        // false
		System.out.println(islem.veriEkle(null));      // false
		System.out.println(islem.getKayitSayisi());    // 1

		// Kod izleme
		VeriIslemleri islem2 = new VeriIslemleri();
		System.out.println(islem2.veriEkle("Ayse"));   // true
		System.out.println(islem2.veriEkle(null));     // false
		System.out.println(islem2.veriEkle(""));       // false
		System.out.println(islem2.veriEkle("Can"));    // true
		System.out.println(islem2.getKayitSayisi());   // 2
	}
}
