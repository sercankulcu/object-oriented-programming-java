package evcil;     // baska paket

import canli.Hayvan;

// protected: baska paketteki alt sinif, kalitilan isim alanini ve
// saglikEkle metodunu kullanir; Hayvan tipindeki baska bir nesnenin
// protected alanina ise erisemez.
public class Kedi extends Hayvan {
	public Kedi(String isim) { super(isim); }
	public void uyu() {
		// protected alan: izin var
		System.out.println(isim + " uyuyor.");
		// saglik += 5;  // private: hata
		// derleme hatasi: saglik has private access in Hayvan
		saglikEkle(5);   // protected metot
		System.out.println("Saglik: "
						   + getSaglik());
	}

	void karsilastir(Kedi k, Hayvan h) {
		System.out.println(isim);    // kendi alani
		System.out.println(k.isim);  // Kedi uzerinden
		// System.out.println(h.isim);  // Hayvan uzerinden
		// evcil/Kedi.java:8: error: isim has protected access in Hayvan
		System.out.println(h.getSaglik());
	}

	public static void main(String[] args) {
		Kedi kedi = new Kedi("Mavi");
		kedi.uyu();
		// Mavi uyuyor.
		// Saglik: 105.0
		kedi.karsilastir(new Kedi("Tekir"), new Hayvan("Karabas"));
		// Mavi
		// Tekir
		// 100.0
	}
}
