// Adres sinifi
package objects;

public class Adres {

	private String sokakAdresi;
	private String sehir;
	private String postakodu;
	private String ulke;

	public Adres(String sokakAdresi, String sehir, String postakodu, String ulke) {
		this.sokakAdresi = sokakAdresi;
		this.sehir = sehir;
		this.postakodu = postakodu;
		this.ulke = ulke;
	}

	public String getSokakAdresi() {
		return sokakAdresi;
	}

	public String getSehir() {
		return sehir;
	}

	public String getPostakodu() {
		return postakodu;
	}

	public String getUlke() {
		return ulke;
	}

	public void adresiYazdir() {
		System.out.println(sokakAdresi + ", " + sehir + ", " + postakodu + ", " + ulke);
	}
}