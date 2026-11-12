import java.util.Scanner;

// Fonksiyonlar: degerle aktarim, dizi parametresi, Math sinifi, yerel degisken ve kapsam,
// yasam suresi, fonksiyonel soyutlama, problemi parcalama ve tekrar eden kodu metoda tasima.
public class Fonksiyonlar {

	// static ve Nesne Uzerinden Cagri: static metot main icinden dogrudan cagrilir
	static int toplama(int sayi1, int sayi2) {
		return sayi1 + sayi2;
	}

	// Deger ile Aktarim: metot kopyayi degistirir, cagiranin degiskeni ayni kalir
	static void arttir(int sayi) {
		sayi = sayi + 10;
		System.out.println("arttir: " + sayi);
	}

	// Dizi Parametresi: referansin kopyasi gelir; dizinin icerigi degisir, x ve d degisimi disari yansimaz
	static void degistir(int[] d, int x) {
		d[0] = 50;
		x = 50;
		d = new int[2];
		d[1] = 50;
	}

	// Yerel Degisken: sonuc yalnizca carpma metodunun icinde vardir
	static class YerelDegisken {
		public int carpma(int sayi1, int sayi2) {
			int sonuc = sayi1 * sayi2; // 'sonuc' bir yerel degiskendir
			return sonuc;
		}
		public void baskaMetot() {
			carpma(2, 3);
			// System.out.println(sonuc);  // HATA
			// derleme hatasi: cannot find symbol, symbol: variable sonuc
			System.out.println(carpma(2, 3));   // duzeltilmis: donen deger kullanilir
		}
	}

	// Isim Cakismasi: ayni metotta ic blokta ayni adla degisken tanimlanamaz
	static class IsimCakismasi {
		public void fonksiyon() {
			int disDegisken = 10;
			{
				// int disDegisken = 5;  // HATA
				// derleme hatasi: variable disDegisken is already defined in method fonksiyon()
				int icDegisken = 5;     // duzeltilmis: farkli ad
				System.out.println(disDegisken + " " + icDegisken);
			}
		}
	}

	// Yasam Suresi Izleme: sinif alani program boyunca, yerel degisken cagri boyunca yasar
	static int cagriSayisi = 0;  // sinif alani
	static int carpma(int sayi1, int sayi2) {
		cagriSayisi++;
		int sonuc = sayi1 * sayi2;
		return sonuc;
	}

	// Fonksiyonel Soyutlama: kullanan yalnizca imzayi bilir; "sayi asal ise true doner"
	static boolean asalMi(int sayi) {
		if (sayi < 2) return false;
		for (int bolen = 2; bolen * bolen <= sayi; bolen++) {
			if (sayi % bolen == 0) return false;
		}
		return true;
	}

	// Problemi Parcalama: okuma, hesaplama ve karar ayri metotlardir
	static int[] notlariOku(Scanner giris, int adet) {
		int[] notlar = new int[adet];
		for (int i = 0; i < adet; i++) {
			notlar[i] = giris.nextInt();
		}
		return notlar;
	}

	static double ortalamaHesapla(int[] notlar) {
		int toplam = 0;
		for (int n : notlar) {
			toplam += n;
		}
		return (double) toplam / notlar.length;
	}

	static String harfNotu(double ort) {
		if (ort >= 90) return "AA";
		if (ort >= 85) return "BA";
		if (ort >= 80) return "BB";
		if (ort >= 75) return "CB";
		if (ort >= 70) return "CC";
		if (ort >= 60) return "DC";
		if (ort >= 50) return "DD";
		return "FF";
	}

	// Ne Zaman Fonksiyon?: tekrar eden formul tek metoda tasinir
	static double ortalama(int a, int b, int c) {
		return (a + b + c) / 3.0;
	}

	public static void main(String[] args) {
		// static ve Nesne Uzerinden Cagri
		// main icinde, dogrudan:
		int sonuc = toplama(5, 3);
		System.out.println(sonuc);                                   // 8

		// Deger ile Aktarim
		int sayi = 5;
		arttir(sayi);                                                // arttir: 15
		System.out.println("main: " + sayi);                         // main: 5

		// Dizi Parametresi: Kod Izleme
		int[] a = {1, 2};
		int x = 1;
		degistir(a, x);
		System.out.println(a[0] + " " + a[1] + " " + x);             // 50 2 1

		// Math Sinifi
		double kareKok = Math.sqrt(16);
		double mutlakDeger = Math.abs(-17.2);
		double maksimum = Math.max(3, 5);
		System.out.println(kareKok);                                 // 4.0
		System.out.println(mutlakDeger);                             // 17.2
		System.out.println(maksimum);                                // 5.0
		System.out.println(Math.pow(2, 10));                         // 1024.0
		System.out.println(Math.round(2.6));                         // 3
		System.out.println(Math.min(-4, 7));                         // -4
		System.out.println(Math.max(3, 5));                          // 5

		// Yerel Degisken ve Isim Cakismasi (duzeltilmis halleri)
		new YerelDegisken().baskaMetot();                            // 6
		new IsimCakismasi().fonksiyon();                             // 10 5

		// Yasam Suresi Izleme
		int ilk = carpma(2, 3);
		{
			int ikinci = carpma(ilk, 4);
			System.out.println(ikinci);                              // 24
		}
		System.out.println(ilk + " " + cagriSayisi);                 // 6 2

		// Fonksiyonel Soyutlama
		System.out.println("Merhaba");                               // Merhaba
		if (asalMi(17)) {
			System.out.println("17 asal");                           // 17 asal
		}

		// Problemi Parcalama (girdi: 70 85 90)
		Scanner giris = new Scanner("70 85 90");
		int[] notlar = notlariOku(giris, 3);
		double ort = ortalamaHesapla(notlar);
		System.out.println("Ortalama: " + ort + " -> " + harfNotu(ort));
		// Ortalama: 81.66666666666667 -> BB
		giris.close();

		// Ne Zaman Fonksiyon?: once tekrar eden formul, sonra metot
		double ort1 = (70 + 80 + 90) / 3.0;
		System.out.println(ort1);                                    // 80.0
		double ort2 = (55 + 60 + 100) / 3.0;
		System.out.println(ort2);                                    // 71.66666666666667
		// formul degisirse her yerde
		// ayri ayri duzeltmek gerekir
		System.out.println(ortalama(70, 80, 90));                    // 80.0
		System.out.println(ortalama(55, 60, 100));                   // 71.66666666666667

		// Degisken Adlandirma
		int ogrenciSayisi = 40; // iyi bir adlandirma
		int b = 40;             // anlamsiz bir isim (sunumda: int a;)
		int yas = 25;
		String isim = "Ahmet";
		double ortalama = 85.5;
		String kitapAdi = "Sefiller";
		System.out.println(ogrenciSayisi + " " + b + " " + yas + " " + isim
				+ " " + ortalama + " " + kitapAdi);                  // 40 40 25 Ahmet 85.5 Sefiller
	}
}

/* Beklenen cikti:
8
arttir: 15
main: 5
50 2 1
4.0
17.2
5.0
1024.0
3
-4
5
6
10 5
24
6 2
Merhaba
17 asal
Ortalama: 81.66666666666667 -> BB
80.0
71.66666666666667
80.0
71.66666666666667
40 40 25 Ahmet 85.5 Sefiller
*/
