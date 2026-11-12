// Degiskenler: bildirim, atama, char ve boolean, adlandirma kurallari,
// atama ifadeleri ve bilesik atama.
public class Degiskenler {

	// Adlandirma Kurallari: sinif adi BuyukHarfleBaslar
	static class OgrenciKaydi { }    // sinif

	// Temel Programlama Unsurlari
	static void temelUnsurlar() {
		int sayi = 5;
		if (sayi > 0) {
			System.out.println("Sayi pozitif.");  // Sayi pozitif.
		} else {
			System.out.println("Sayi negatif veya sifir.");
		}
	}

	// Degiskenler: bildirim
	static void bildirim() {
		int numara, cekSayisi, mevcutSayisi;
		double miktar, faizOrani;
		char cevap;
		numara = 1; cekSayisi = 2; mevcutSayisi = 3;
		miktar = 100.0; faizOrani = 0.05;
		cevap = 'E';
		System.out.println(numara + " " + cekSayisi + " " + mevcutSayisi + " "
				+ miktar + " " + faizOrani + " " + cevap);  // 1 2 3 100.0 0.05 E
	}

	// Bildirim ve Atama Izleme
	static void bildirimVeAtama() {
		int yas;
		yas = 25;
		double boy = 1.78;
		yas = yas + 1;
		char harf = 'K';
		System.out.println(yas + " " + boy + " " + harf);  // 26 1.78 K
	}

	// char ve boolean
	static void charVeBoolean() {
		char harf = 'A';
		boolean dogruMu = true;
		System.out.println(harf);      // A
		System.out.println(dogruMu);   // true
		System.out.println(!dogruMu);  // false
	}

	// Adlandirma Kurallari
	static void adlandirma() {
		OgrenciKaydi kayit = new OgrenciKaydi();
		String isimSoyisim;       // degisken
		boolean evliMi;           // evet/hayir
		final int MAX_SAYI = 100; // sabit
		isimSoyisim = "Ali Veli";
		evliMi = false;
		System.out.println(isimSoyisim + " " + evliMi + " " + MAX_SAYI
				+ " " + (kayit != null));  // Ali Veli false 100 true
	}

	// Atama Ifadeleri
	static void atamaIfadeleri() {
		int sayi, sonuc;
		int sayi1 = 4, sayi2 = 6;
		String isim;

		sayi = 10;             // sabit deger
		sonuc = sayi1 + sayi2; // toplam: 10
		isim = "Ahmet";        // metin
		sayi = sayi * 2;       // 10 -> 20
		System.out.println(sayi + " " + sonuc + " " + isim);  // 20 10 Ahmet
	}

	// Bilesik Atama Izleme
	static void bilesikAtama() {
		int x = 5;
		int y = 10;
		x = x + y;
		x -= y;
		x *= 2;
		x /= 4;
		x %= 3;
		System.out.println("x = " + x + ", y = " + y);  // x = 2, y = 10
	}

	public static void main(String[] args) {
		temelUnsurlar();
		bildirim();
		bildirimVeAtama();
		charVeBoolean();
		adlandirma();
		atamaIfadeleri();
		bilesikAtama();
	}
}

/* Beklenen cikti:
Sayi pozitif.
1 2 3 100.0 0.05 E
26 1.78 K
A
true
false
Ali Veli false 100 true
20 10 Ahmet
x = 2, y = 10
*/
