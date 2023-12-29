
public class Kitap {
	
	private String baslik;
	private String yazar;
	private int sayfaSayisi;

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

	public void kitapBilgisiGoster() {
		System.out.println(baslik + " " + yazar + " " + sayfaSayisi);
	}

	public static void main(String[] args) {
		//Bir Kitap nesnesi oluşturalım
		Kitap kitap = new Kitap();

		//Kitap nesnesinin özelliklerine erişim
		kitap.baslik = "Java Programlama";
		kitap.yazar = "John Doe";
		kitap.sayfaSayisi = 1043;

		//Kitap nesnesinin metotlarına erişim
		kitap.kitapBilgisiGoster();
	}
}