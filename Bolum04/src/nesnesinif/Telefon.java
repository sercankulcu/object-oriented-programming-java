package nesnesinif;

// Nokta isleci: nesnenin alanina ve metotlarina nokta ile erisilir;
// metot baska bir Telefon nesnesini parametre olarak alir.
public class Telefon {
	String numara;
	public Telefon(String numara) {
		this.numara = numara;
	}
	public void aramaYap(Telefon telefon) {
		System.out.println(numara + " ariyor: " + telefon.numara);
	}
	public void mesajGonder(Telefon telefon, String mesaj) {
		System.out.println(telefon.numara + " <- " + mesaj);
	}
	public void kameraAc() {
		System.out.println(numara + " kamera acti.");
	}
	public static void main(String[] args) {
		Telefon telefon1 = new Telefon("5551234567");
		Telefon telefon2 = new Telefon("5051234567");
		telefon1.aramaYap(telefon2);                // 5551234567 ariyor: 5051234567
		telefon2.mesajGonder(telefon1, "Merhaba!"); // 5551234567 <- Merhaba!
		telefon1.kameraAc();                        // 5551234567 kamera acti.
	}
}

/* Beklenen cikti:
5551234567 ariyor: 5051234567
5551234567 <- Merhaba!
5551234567 kamera acti.
*/
