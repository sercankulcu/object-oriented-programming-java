// Postane sinifi
package objects;

public class Postane {

	private String ad;
	private String telefonNumarasi;

	public Postane(String ad, String telefonNumarasi) {
		this.ad = ad;
		this.telefonNumarasi = telefonNumarasi;
	}

	public String getAd() {
		return ad;
	}

	public String getTelefonNumarasi() {
		return telefonNumarasi;
	}

	public void postaneyiTanit() {
		System.out.println("Postane Adi: " + ad + ", Telefon Numarasi: " + telefonNumarasi);
	}

	public static void main(String[] args) {

		// Sabit degerler ile Kisi, Adres ve Postane nesneleri olusturuluyor
		// Kisi bilgileri
		String isim = "Ahmet";
		int yas = 30;

		// Adres bilgileri
		String sokakAdresi = "Mevlana Caddesi No:5";
		String sehir = "Konya";
		String postakodu = "42030";
		String ulke = "Turkiye";

		// Adres nesnesi olusturuluyor
		Adres adres = new Adres(sokakAdresi, sehir, postakodu, ulke);

		// Kisi nesnesi olusturuluyor
		Kisi kisi = new Kisi(isim, yas, adres);

		// Kisi bilgileri yazdiriliyor
		kisi.kisiyiTanit();

		// Postane bilgileri
		String postaneAdi = "Konya Postanesi";
		String telefonNumarasi = "0332 123 45 67";

		// Postane nesnesi olusturuluyor
		Postane postane = new Postane(postaneAdi, telefonNumarasi);

		// Postane bilgileri yazdiriliyor
		postane.postaneyiTanit();

		// Adres bilgileri yazdiriliyor
		adres.adresiYazdir();

		// Kisi'nin yasini kontrol etme
		System.out.println("Kisinin yasini kontrol edelim. 18 yasindan buyuk mu?");
		if (kisi.getYas() > 18) {
			System.out.println(kisi.getIsim() + " 18 yasindan buyuk.");
		} else {
			System.out.println(kisi.getIsim() + " 18 yasindan kucuk.");
		}
	}
}
