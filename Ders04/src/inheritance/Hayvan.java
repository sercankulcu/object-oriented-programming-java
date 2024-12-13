// Hayvan sinifi
package inheritance;

public class Hayvan {

	private String isim;  // Hayvanin ismi
	private int yas;      // Hayvanin yasi
	private double saglik;  // Hayvanin saglik durumu

	// Hayvan sinifi kurucusu (constructor)
	public Hayvan(String isim, int yas) {
		this.isim = isim;
		this.yas = yas;
		this.saglik = 100.0; // Varsayilan saglik degeri 100
	}

	// Hayvanin ismini almak icin getter metodu
	public String getIsim() {
		return isim;
	}

	// Hayvanin yasini almak icin getter metodu
	public int getYas() {
		return yas;
	}

	// Hayvanin sagligini almak icin getter metodu
	public double getSaglik() {
		return saglik;
	}

	// Hayvani konusturma metodu
	public void konus() {
		System.out.println("Bu hayvan konusur.");
	}

	// Hayvani yemek yedirme metodu
	public void yemekYe(double miktar) {
		if (miktar > 0) {
			saglik += miktar;  // Saglik miktar kadar artar
			System.out.println(isim + " yemek yedi. Saglik: " + saglik);
		} else {
			System.out.println("Gecersiz miktar.");
		}
	}

	// Hayvani uyutma metodu
	public void uyu() {
		saglik += 5;  // Uyuma saglik uzerine artirma
		System.out.println(isim + " uyudu. Saglik: " + saglik);
	}

	// Hayvanin yasini gosterme
	public void yasHesapla() {
		System.out.println(isim + " " + yas + " yasinda.");
	}

	// ToString metodu - Hayvanin ozelliklerini string olarak dondurur
	@Override
	public String toString() {
		return "Hayvan Ismi: " + isim + ", Yas: " + yas + ", Saglik Durumu: " + saglik;
	}
}
