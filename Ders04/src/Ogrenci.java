
public class Ogrenci {
	private String ad;

	public Ogrenci(String ad) {
		this.ad = ad; // "this" kullanarak alanı (field) ayırt ediyoruz
	}

	public void selamVer() {
		System.out.println("Merhaba, ben " + this.ad); // "this" ile alanı (field) kullanma
	}

	// Ana metod (main method) içinde kullanımı
	public static void main(String[] args) {
		Ogrenci ogrenci1 = new Ogrenci("Ali");
		Ogrenci ogrenci2 = new Ogrenci("Ayşe");

		ogrenci1.selamVer(); // "this" kullanarak nesne içindeki alanı (field) kullanma
		ogrenci2.selamVer();
	}
}
