package cokbicimlilik;

// Ornek: sekil hiyerarsisi. Soyut Sekil, alt siniflarin ortak arayuzunu verir;
// dizideki her nesne kendi alanHesapla() ve ciz() surumunu calistirir.
public class SekilHiyerarsisi {

	abstract static class Sekil {
		private String isim;

		public Sekil(String isim) {
			this.isim = isim;
		}

		public String getIsim() {
			return isim;
		}

		public abstract double alanHesapla();

		public abstract double cevreHesapla();

		public void ciz() {
			System.out.println(isim + " ciziliyor.");
		}
	}

	static class Kare extends Sekil {
		private double kenar;
		public Kare(double kenar) {
			super("Kare");
			this.kenar = kenar;
		}
		@Override
		public double alanHesapla() {
			return kenar * kenar;
		}
		@Override
		public double cevreHesapla() {
			return 4 * kenar;
		}
		@Override
		public void ciz() {
			System.out.println("Kare ciziliyor: kenar " + kenar);
		}
	}

	static class Dikdortgen extends Sekil {
		private double genislik;
		private double yukseklik;
		public Dikdortgen(double genislik, double yukseklik) {
			super("Dikdortgen");
			this.genislik = genislik;
			this.yukseklik = yukseklik;
		}
		@Override
		public double alanHesapla() {
			return genislik * yukseklik;
		}
		@Override
		public double cevreHesapla() {
			return 2 * (genislik + yukseklik);
		}
		// ciz() ezilmedi -> Sekil'inki kullanilir
	}

	static class Cember extends Sekil {
		private double yaricap;
		public Cember(double yaricap) {
			super("Cember");
			this.yaricap = yaricap;
		}
		@Override
		public double alanHesapla() {
			return Math.PI * yaricap * yaricap;
		}
		@Override
		public double cevreHesapla() {
			return 2 * Math.PI * yaricap;
		}
		@Override
		public void ciz() {
			System.out.println("Cember ciziliyor: yaricap " + yaricap);
		}
	}

	// Neden Cok Bicimlilik? Kotu yol: her tur icin ayri dal
	static double alanKotu(Sekil s) {
		double alan;
		if (s instanceof Kare) {
			alan = ((Kare) s).alanHesapla();
		} else if (s instanceof Dikdortgen) {
			alan = ((Dikdortgen) s).alanHesapla();
		} else if (s instanceof Cember) {
			alan = ((Cember) s).alanHesapla();
		} else {
			alan = 0; // yeni tur unutuldu!
		}
		return alan;
	}

	// Iyi yol: dinamik baglama
	static double toplamAlan(Sekil[] dizi) {
		double toplam = 0;
		for (Sekil sekil : dizi) {
			// her nesne kendi alanini
			toplam += sekil.alanHesapla();
		}
		return toplam;
	}

	public static void main(String[] args) {
		Sekil[] sekiller = new Sekil[3];
		sekiller[0] = new Kare(5);
		sekiller[1] = new Dikdortgen(4, 6);
		sekiller[2] = new Cember(7);

		for (Sekil sekil : sekiller) {
			System.out.println(sekil.getIsim()
				+ " alani: " + sekil.alanHesapla());
			sekil.ciz();
		}
		// Kare alani: 25.0
		// Kare ciziliyor: kenar 5.0
		// Dikdortgen alani: 24.0
		// Dikdortgen ciziliyor.
		// Cember alani: 153.93804002589985
		// Cember ciziliyor: yaricap 7.0

		System.out.println(alanKotu(sekiller[1]));     // 24.0
		System.out.println(toplamAlan(sekiller));      // 202.93804002589985
		System.out.println(sekiller[0].cevreHesapla() + " " + sekiller[1].cevreHesapla());   // 20.0 20.0
	}
}
