// Dikdortgen sinifi, Sekil sinifini genisletir
package polymorphism;

public class Dikdortgen extends Sekil {
	private double genislik;
	private double yukseklik;

	// Yapilandirici
	public Dikdortgen(double genislik, double yukseklik) {
		super("Dikdortgen");
		this.genislik = genislik;
		this.yukseklik = yukseklik;
	}

	// Genislik ve yukseklik icin getter ve setter metodlari
	public double getGenislik() {
		return genislik;
	}

	public void setGenislik(double genislik) {
		this.genislik = genislik;
	}

	public double getYukseklik() {
		return yukseklik;
	}

	public void setYukseklik(double yukseklik) {
		this.yukseklik = yukseklik;
	}

	// alanHesapla metodu override edilir
	@Override
	public double alanHesapla() {
		return genislik * yukseklik;
	}

	// cevreHesapla metodu override edilir
	@Override
	public double cevreHesapla() {
		return 2 * (genislik + yukseklik);
	}

	// ciz metodu override edilir
	@Override
	public void ciz() {
		System.out.println("Dikdortgen ciziliyor: Genislik " + genislik + ", Yukseklik " + yukseklik);
	}
}