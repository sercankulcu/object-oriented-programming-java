// Kare sinifi, Sekil sinifini genisletir
package polymorphism;

public class Kare extends Sekil {
	private double kenar;

	// Yapilandirici
	public Kare(double kenar) {
		super("Kare");
		this.kenar = kenar;
	}

	// Kenar alani icin getter ve setter metodu
	public double getKenar() {
		return kenar;
	}

	public void setKenar(double kenar) {
		this.kenar = kenar;
	}

	// alanHesapla metodu override edilir
	@Override
	public double alanHesapla() {
		return kenar * kenar;
	}

	// cevreHesapla metodu override edilir
	@Override
	public double cevreHesapla() {
		return 4 * kenar;
	}

	// ciz metodu override edilir
	@Override
	public void ciz() {
		System.out.println("Kare ciziliyor: Kenar uzunlugu " + kenar);
	}
}