// Kisi sinifi
package objects;

public class Kisi {

	private String isim;
	private int yas;
	private Adres adres;

	public Kisi(String isim, int yas, Adres adres) {
		this.isim = isim;
		this.yas = yas;
		this.adres = adres;
	}

	public String getIsim() {
		return isim;
	}

	public int getYas() {
		return yas;
	}

	public Adres getAdres() {
		return adres;
	}

	public void kisiyiTanit() {
		System.out.println("Isim: " + isim + ", Yas: " + yas);
		System.out.print("Adres: ");
		adres.adresiYazdir();
	}
}