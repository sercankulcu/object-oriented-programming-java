package objects;

public class Telefon {
	
	String numara;  // Telefon numarasini tutan alan

	// Telefon sinifinin yapici metodu, telefon numarasini alir
	public Telefon(String numara) {
		this.numara = numara;  // Telefon numarasini baslatir
	}
	
	// Arama islemi yapan metod
	public void aramaYap(Telefon telefon) {
		// Verilen telefon numarasina arama yapma islemi
		System.out.println(this.numara + " numarali telefon " + telefon.numara + " numarasina arama yapiyor.");
	}
	
	// Mesaj gonderme islemi yapan metod
	public void mesajGonder(Telefon telefon, String mesaj) {
		// Verilen telefona mesaj gonderme islemi
		System.out.println(this.numara + " numarali telefon, " + telefon.numara + " numarasina mesaj gonderdi: " + mesaj);
	}
	
	// Kamera acma islemi yapan metod
	public void kameraAc() {
		// Kamerayi acma islemi
		System.out.println(this.numara + " numarali telefon kamerasini acti.");
	}
	
	// Telefonun sarj durumunu kontrol eden metod
	public void sarjDurumunuKontrolEt() {
		// Telefonun sarj durumunu simule etme
		System.out.println(this.numara + " numarali telefonun sarj durumu %85.");
	}

	// Arama gecmisi tutan metod
	public void aramaGecmisiGoster() {
		// Arama gecmisi simule etme
		System.out.println(this.numara + " numarali telefonun arama gecmisi gosteriliyor.");
	}

	// Ana metod (main method) icinde kullanimi
	public static void main(String[] args) {
		// iki telefon nesnesi olusturuluyor
		Telefon telefon1 = new Telefon("5551234567");  // Telefon 1
		Telefon telefon2 = new Telefon("5051234567");  // Telefon 2

		// Telefon 1, Telefon 2'ye arama yapar
		telefon1.aramaYap(telefon2);
		
		// Telefon 2, Telefon 1'e mesaj gonderir
		telefon2.mesajGonder(telefon1, "Merhaba!");
		
		// Telefon 1 kamerasini acar
		telefon1.kameraAc();
		
		// Telefon 1 sarj durumunu kontrol eder
		telefon1.sarjDurumunuKontrolEt();
		
		// Telefon 2'nin arama gecmisi goruntulenir
		telefon2.aramaGecmisiGoster();
	}
}
