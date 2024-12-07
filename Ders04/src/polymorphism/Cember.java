// Cember sinifi, Sekil sinifini genisletir
package polymorphism;

public class Cember extends Sekil {
	private double yaricap;

	// Yapilandirici
	public Cember(double yaricap) {
		super("Cember");
		this.yaricap = yaricap;
	}

	// Yaricap alani icin getter ve setter metodlari
	public double getYaricap() {
		return yaricap;
	}

	public void setYaricap(double yaricap) {
		this.yaricap = yaricap;
	}

	// alanHesapla metodu override edilir
	@Override
	public double alanHesapla() {
		return Math.PI * yaricap * yaricap;
	}

	// cevreHesapla metodu override edilir
	@Override
	public double cevreHesapla() {
		return 2 * Math.PI * yaricap;
	}

	// ciz metodu override edilir
	@Override
	public void ciz() {
		System.out.println("Cember ciziliyor: Yaricap " + yaricap);
	}
}