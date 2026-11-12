package nesnesinif;

// Metot turleri: ornege ait metotlar nesne uzerinden, sinifa ait
// (static) metot sinif adi uzerinden cagrilir.
public class CepTelefonu {
	private String model;
	private static String isletimSistemi = "Surum 1";

	// Ornege ait metot
	public void aramaYap(String numara) {
		System.out.println(model + " ariyor: " + numara);
	}

	// Ornege ait metot
	public void mesajGonder(String alici, String mesaj) {
		System.out.println(alici + " <- " + mesaj);
	}

	// Sinifa ait metot (static)
	public static void sistemiGuncelle(String yeniSurum) {
		isletimSistemi = yeniSurum;
	}

	public static void main(String[] args) {
		CepTelefonu t = new CepTelefonu();
		t.model = "Model X";
		t.aramaYap("5551234567");              // Model X ariyor: 5551234567
		t.mesajGonder("Ayse", "Merhaba");      // Ayse <- Merhaba
		System.out.println(isletimSistemi);    // Surum 1
		CepTelefonu.sistemiGuncelle("Surum 2");
		System.out.println(isletimSistemi);    // Surum 2
	}
}

/* Beklenen cikti:
Model X ariyor: 5551234567
Ayse <- Merhaba
Surum 1
Surum 2
*/
