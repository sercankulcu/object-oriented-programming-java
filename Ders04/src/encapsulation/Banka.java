package encapsulation;

public class Banka {

	public static void main(String[] args) {

		// Banka hesaplari olusturuluyor
		BankaHesabi hesap1 = new BankaHesabi(123456, 2000.0, "Vadeli");
		BankaHesabi hesap2 = new BankaHesabi(789012, 1500.0, "Vadesiz");

		// Hesap bilgileri yazdiriliyor
		System.out.println("Hesap 1 numarasi: " + hesap1.getHesapNumarasi());
		System.out.println("Hesap 1 bakiye: " + hesap1.getBakiye());
		System.out.println("Hesap 1 turu: " + hesap1.getHesapTuru());

		System.out.println("\nHesap 2 numarasi: " + hesap2.getHesapNumarasi());
		System.out.println("Hesap 2 bakiye: " + hesap2.getBakiye());
		System.out.println("Hesap 2 turu: " + hesap2.getHesapTuru());

		System.out.println();
		// Para yatirma
		hesap1.paraYatir(500.0); // Hesap 1'e 500 TL yatirildi

		// Para cekme
		hesap2.paraCek(200.0); // Hesap 2'den 200 TL cekildi

		// Faiz ekleme
		hesap1.faizEkle(5.0); // Hesap 1'e %5 faiz eklendi

		// Transfer islemi
		hesap1.transfer(hesap2, 300.0); // Hesap 1'den Hesap 2'ye 300 TL transfer edildi

		// Yeni bakiyeleri yazdirma
		System.out.println("\nHesap 1 yeni bakiye: " + hesap1.getBakiye());
		System.out.println("Hesap 2 yeni bakiye: " + hesap2.getBakiye());
	}
}
