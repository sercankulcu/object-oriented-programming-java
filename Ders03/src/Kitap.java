
public class Kitap {
	String baslik;
	String yazar;
	int sayfaSayisi;

	public Kitap() {
		
	}
	
	public Kitap(String baslik) {
		this.baslik = baslik;
	}

	public Kitap(String baslik, String yazar) {
		this(baslik);  // Constructor chaining
		this.yazar = yazar;
	}

	public Kitap(String baslik, String yazar, int sayfaSayisi) {
		this(baslik, yazar);  // Constructor chaining
		this.sayfaSayisi = sayfaSayisi;
	}
	
	private void kitapBilgisiGoster() {
		System.out.println(baslik + " " + yazar + " " + sayfaSayisi);
	}

	public static void main(String[] args) {
		//Bir Kitap nesnesi oluşturalım
		Kitap kitap = new Kitap();

		//Kitap nesnesinin özelliklerine erişim
		kitap.baslik = "Java Programlama";
		kitap.yazar = "John Doe";

		//Kitap nesnesinin metotlarına erişim
		kitap.kitapBilgisiGoster();
	}
}