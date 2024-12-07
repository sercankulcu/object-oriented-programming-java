package polymorphism;

// Soyut sinif: Sekil
abstract class Sekil {
	private String isim;

	// Yapilandirici
	public Sekil(String isim) {
		this.isim = isim;
	}

	// Isim alani icin getter metodu
	public String getIsim() {
		return isim;
	}

	// Isim alani icin setter metodu
	public void setIsim(String isim) {
		this.isim = isim;
	}

	// Soyut metot: Seklin alanini hesapla (alt siniflar override etmek zorunda)
	public abstract double alanHesapla();

	// Soyut metot: Seklin cevresini hesapla (alt siniflar override etmek zorunda)
	public abstract double cevreHesapla();

	// Somut metot: Sekli ciz (alt siniflar istege bagli override edebilir)
	public void ciz() {
		System.out.println(isim + " ciziliyor.");
	}

	public static void main(String[] args) {
		// Sekil nesnelerini diziye koyuyoruz
		Sekil[] sekiller = new Sekil[3];
		sekiller[0] = new Kare(5);          // Kare nesnesi
		sekiller[1] = new Dikdortgen(4, 6); // Dikdortgen nesnesi
		sekiller[2] = new Cember(7);        // Cember nesnesi

		// Dizideki her bir Sekil nesnesi icin alan ve cevre hesaplamalari
		for (Sekil sekil : sekiller) {
			System.out.println(sekil.getIsim() + " alani: " + sekil.alanHesapla());
			System.out.println(sekil.getIsim() + " cevresi: " + sekil.cevreHesapla());
			sekil.ciz();
		}
	}
}
