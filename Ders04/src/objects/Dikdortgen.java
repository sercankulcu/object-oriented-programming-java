package objects;

public class Dikdortgen {
	
	private double uzunluk;      // Dikdortgenin uzunluk ozelligi
	private double genislik;     // Dikdortgenin genislik ozelligi

	// Yapici metot: Dikdortgen nesnesini baslatir ve uzunluk ve genislik ozelliklerini ayarlar
	public Dikdortgen(double uzunluk, double genislik) {
		this.uzunluk = uzunluk;
		this.genislik = genislik;
	}

	// Alan hesaplama metodu
	public double alanHesapla() {
		return uzunluk * genislik;
	}

	// cevre hesaplama metodu
	public double cevreHesapla() {
		return 2 * (uzunluk + genislik);
	}

	// Alani guncelleyen metot
	public void alanGuncelle(double yeniUzunluk, double yeniGenislik) {
		this.uzunluk = yeniUzunluk;
		this.genislik = yeniGenislik;
	}

	// Nesnenin tum bilgilerini donduren metot
	public String toString() {
		return "Uzunluk: " + uzunluk + ", Genislik: " + genislik + ", Alan: " + alanHesapla() + ", Cevre: " + cevreHesapla();
	}

	// Ana metod (main method) icinde kullanimi
	public static void main(String[] args) {
		
		// Farkli dikdortgenler olusturuluyor
		Dikdortgen dikdortgen1 = new Dikdortgen(10.0, 5.0); // Dikdortgen nesnesi
		Dikdortgen dikdortgen2 = new Dikdortgen(3.0, 7.0); // Diger dikdortgen nesnesi
		Dikdortgen kare = new Dikdortgen(4.0, 4.0); // Bir kare olusturuluyor (uzunluk = genislik)

		// Alan ve cevre hesaplaniyor
		System.out.println("Dikdortgen 1: " + dikdortgen1);  // toString() ile gosterim
		System.out.println("Dikdortgen 2: " + dikdortgen2);
		System.out.println("Kare: " + kare);

		// Dikdortgenin boyutlari guncelleniyor
		dikdortgen1.alanGuncelle(12.0, 6.0);  // Boyutlar guncelleniyor
		System.out.println("Guncellenmis Dikdortgen 1: " + dikdortgen1); // Yeni boyutlari gosteriyoruz

		// Alan ve cevreye ek olarak bazi ozel hesaplamalar yapilabilir
		double diagonal1 = dikdortgen1.hipotenusHesapla();  // Hipotenus (diagonal) hesaplaniyor
		double diagonal2 = dikdortgen2.hipotenusHesapla();
		double diagonalKare = kare.hipotenusHesapla();

		System.out.println("Dikdortgen 1'in Hipotenusu: " + diagonal1);
		System.out.println("Dikdortgen 2'nin Hipotenusu: " + diagonal2);
		System.out.println("Karenin Hipotenusu: " + diagonalKare);

		// Dikdortgenlerin karsilastirilmasi
		if (dikdortgen1.alanHesapla() > dikdortgen2.alanHesapla()) {
			System.out.println("Dikdortgen 1'in alani, Dikdortgen 2'den buyuktur.");
		} else if (dikdortgen1.alanHesapla() < dikdortgen2.alanHesapla()) {
			System.out.println("Dikdortgen 2'nin alani, Dikdortgen 1'den buyuktur.");
		} else {
			System.out.println("Dikdortgen 1 ve Dikdortgen 2'nin alanlari esittir.");
		}
	}

	// Hipotenus hesaplama (dikdortgenin capraz uzunlugu)
	public double hipotenusHesapla() {
		return Math.sqrt(Math.pow(uzunluk, 2) + Math.pow(genislik, 2));  // Pisagor teoremi kullanilarak hipotenus hesaplanir
	}
}
