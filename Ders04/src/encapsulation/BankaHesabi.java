package encapsulation;

// BankaHesabi sinifi
public class BankaHesabi {

	private int hesapNumarasi; // Hesap numarasi
	private double bakiye; // Hesap bakiyesi
	private String hesapTuru; // Hesap turu (örn. "Vadesiz", "Vadeli")

	// BankaHesabi sinifinin yapici metodu
	public BankaHesabi(int hesapNumarasi, double bakiye, String hesapTuru) {
		this.hesapNumarasi = hesapNumarasi;
		this.bakiye = bakiye;
		this.hesapTuru = hesapTuru;
	}

	// Hesap numarasini dönduren metod
	public int getHesapNumarasi() {
		return hesapNumarasi;
	}

	// Hesap bakiyesini dönduren metod
	public double getBakiye() {
		return bakiye;
	}

	// Hesap turunu dönduren metod
	public String getHesapTuru() {
		return hesapTuru;
	}

	// Para yatirma islemi
	public void paraYatir(double miktar) {
		if (miktar > 0) {
			bakiye += miktar;
			System.out.println(miktar + " TL yatirildi. Yeni bakiye: " + bakiye);
		} else {
			System.out.println("Yatirilan miktar gecersiz.");
		}
	}

	// Para cekme islemi
	public void paraCek(double miktar) {
		if (miktar <= bakiye && miktar > 0) {
			bakiye -= miktar;
			System.out.println(miktar + " TL cekildi. Kalan bakiye: " + bakiye);
		} else if (miktar > bakiye) {
			System.out.println("Yetersiz bakiye.");
		} else {
			System.out.println("cekilen miktar gecersiz.");
		}
	}

	// Faiz ekleme islemi (Vadeli hesap icin)
	public void faizEkle(double oran) {
		if (hesapTuru.equals("Vadeli") && oran > 0) {
			double faiz = bakiye * oran / 100;
			bakiye += faiz;
			System.out.println("Faiz ekleniyor: " + faiz + " TL. Yeni bakiye: " + bakiye);
		} else if (!hesapTuru.equals("Vadeli")) {
			System.out.println("Faiz yalnizca vadeli hesaplarda uygulanabilir.");
		} else {
			System.out.println("Gecersiz faiz orani.");
		}
	}

	// Baska bir hesaba transfer islemi
	public void transfer(BankaHesabi hedefHesap, double miktar) {
		if (miktar <= bakiye && miktar > 0) {
			bakiye -= miktar;
			hedefHesap.paraYatir(miktar);
			System.out.println(miktar + " TL transfer edildi. Yeni bakiye: " + bakiye);
		} else {
			System.out.println("Yetersiz bakiye veya gecersiz miktar.");
		}
	}
}

