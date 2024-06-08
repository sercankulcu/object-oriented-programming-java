package objects;

public class Telefon {
	
	String numara;
	
	public Telefon(String numara) {
		this.numara = numara;
	}
	// Örnek Metotlar
	public void aramaYap(Telefon telefon) {
		// Arama işlemleri
	}
	public void mesajGonder(Telefon telefon, String mesaj) {
		// Mesaj gönderme işlemleri
	}
	public void kameraAc() {
		// Kamera açma işlemleri
	}

	// Ana metod (main method) içinde kullanımı
	public static void main(String[] args) {
		Telefon telefon1 = new Telefon("5551234567");
		Telefon telefon2 = new Telefon("5051234567");

		telefon1.aramaYap(telefon2);
		telefon2.mesajGonder(telefon1, "Merhaba!");
		telefon1.kameraAc();
	}
}
