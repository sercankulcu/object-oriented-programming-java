
public class Dikdortgen {
	private double uzunluk;      // Dikdörtgenin uzunluk özelliği
	private double genislik;     // Dikdörtgenin genişlik özelliği

	public Dikdortgen(double uzunluk, double genislik) {
		this.uzunluk = uzunluk;   // Yapıcı metot: Dikdörtgen nesnesini başlatır ve uzunluk ve genişlik özelliklerini ayarlar
		this.genislik = genislik;
	}

	public double alanHesapla() {
		return uzunluk * genislik; // Alanı hesaplayan metot
	}

	public double cevreHesapla() {
		return 2 * (uzunluk + genislik); // Çevreyi hesaplayan metot
	}

	public static void main(String[] args) {
		Dikdortgen dikdortgen = new Dikdortgen(5.0, 3.0); // Dikdörtgen nesnesi oluşturuluyor
		Dikdortgen kare = new Dikdortgen(5.0, 5.0); // Dikdörtgen nesnesi oluşturuluyor

		double alan = dikdortgen.alanHesapla();  // Dikdörtgenin alanı hesaplanıyor
		double cevre = dikdortgen.cevreHesapla(); // Dikdörtgenin çevresi hesaplanıyor

		System.out.println("Dikdörtgen Alanı: " + alan + " Çevresi: " + cevre);
		
		alan = kare.alanHesapla();  // Dikdörtgenin alanı hesaplanıyor
		cevre = kare.cevreHesapla(); // Dikdörtgenin çevresi hesaplanıyor

		System.out.println("Dikdörtgen Alanı: " + alan + " Çevresi: " + cevre);
	}
}
