package sarmalama;

// Bilgi saklama: Ana yalnizca veriEkle'yi cagirir; baglanti nesnesi
// ve baglan/ekle/kapat adimlari VeriIslemleri icinde gizlidir.
public class BilgiSaklama {

	// Ekrana yazan basit bir benzetim; gercek bir surucu olsaydi da Ana degismezdi.
	static class VeritabaniBaglantisi {
		void baglan() {
			System.out.println("Baglanti acildi");
		}
		void veriEkle(String veri) {
			System.out.println("Eklendi: " + veri);
		}
		void kapat() {
			System.out.println("Baglanti kapatildi");
		}
	}

	static class VeriIslemleri {
		private VeritabaniBaglantisi baglanti;
		// metodun ic yapisi bilinmeden de kullanilabilir.
		public void veriEkle(String veri) {
			baglanti = new VeritabaniBaglantisi();
			baglanti.baglan();
			baglanti.veriEkle(veri);
			baglanti.kapat();
		}
	}

	static class Ana {
		public static void main(String[] args) {
			VeriIslemleri islem = new VeriIslemleri();
			islem.veriEkle("Ayse");
			// Baglanti acildi
			// Eklendi: Ayse
			// Baglanti kapatildi
		}
	}

	public static void main(String[] args) {
		Ana.main(args);
	}
}
