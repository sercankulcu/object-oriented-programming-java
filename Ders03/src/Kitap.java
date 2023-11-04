
public class Kitap {
	String ad;
	String yazar;
	int sayfaSayisi;

	public Kitap(String ad) {
		this.ad = ad;
	}

	public Kitap(String ad, String yazar) {
		this(ad);  // Constructor chaining
		this.yazar = yazar;
	}

	public Kitap(String ad, String yazar, int sayfaSayisi) {
		this(ad, yazar);  // Constructor chaining
		this.sayfaSayisi = sayfaSayisi;
	}
}
