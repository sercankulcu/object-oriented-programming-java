package kalitim;

// Hayvan ve Kopek: Kopek ortak nitelikleri Hayvan'dan alir, konus()'u
// gecersiz kilar ve yalnizca kendine ozgu topOyna()'yi ekler.
public class HayvanKopek {

	public static class Hayvan {
		private String isim;     // ortak nitelikler
		private int yas;
		private double saglik;

		public Hayvan(String isim, int yas) {
			this.isim = isim;
			this.yas = yas;
			this.saglik = 100.0;
		}
		public String getIsim() { return isim; }   // private isim'e erisim yolu
		public int getYas() { return yas; }
		public void konus() {
			System.out.println("Bu hayvan konusur.");
		}
		public void uyu() {
			saglik += 5;
			System.out.println(isim + " uyudu. Saglik: " + saglik);
		}
	}

	public static class Kopek extends Hayvan {
		public Kopek(String isim, int yas) {
			super(isim, yas);   // ust sinif yapicisi alanlari doldurur
		}
		@Override
		public void konus() {   // miras alinan davranisi degistirir
			System.out.println(getIsim() + " havlar.");
		}
		public void topOyna() { // yalnizca Kopek'te olan davranis
			System.out.println(getIsim() + " top oynuyor!");
		}
	}

	public static void main(String[] args) {
		Kopek kopek = new Kopek("Karabas", 4);
		kopek.konus();     // Karabas havlar.          (Kopek'in surumu)
		kopek.topOyna();   // Karabas top oynuyor!     (Kopek'e ozgu)
		kopek.uyu();       // Karabas uyudu. Saglik: 105.0   (Hayvan'dan miras)

		new Hayvan("Pamuk", 2).konus();   // Bu hayvan konusur.
	}
}

/* Beklenen cikti:
Karabas havlar.
Karabas top oynuyor!
Karabas uyudu. Saglik: 105.0
Bu hayvan konusur.
*/
