
public class Ogrenci {
	private String ad;
	private int numara;

	public Ogrenci(String ad, int numara) {
		this.ad = ad; // "this" kullanarak alanı (field) ayırt ediyoruz
		this.numara = numara;
	}

	public void selamVer() {
		System.out.println("Merhaba, ben " + this.ad); // "this" ile alanı (field) kullanma
	}

	public String toString() {
		return "Ogrenci [ad=" + ad + ", numara=" + numara + "]";
	}

	// Ana metod (main method) içinde kullanımı
	public static void main(String[] args) {

		Ogrenci ogrenci1 = new Ogrenci("Ali", 20122273);
		Ogrenci ogrenci2 = new Ogrenci("Ayşe", 20132272);

		ogrenci1.selamVer(); // "this" kullanarak nesne içindeki alanı (field) kullanma
		ogrenci2.selamVer();

		System.out.println(ogrenci1);
		System.out.println(ogrenci2);
	}
}
