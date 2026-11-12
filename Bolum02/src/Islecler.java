// Islecler: karsilastirma, mantiksal, kisa devre, uclu (?:) ve ic ice uclu.
public class Islecler {

	// Karsilastirma Islecleri (x = 10, y = 20)
	static void karsilastirma() {
		int x = 10, y = 20;
		boolean buyukMu = y > x;
		System.out.println((x == y) + " " + (x != y) + " " + buyukMu + " "
				+ (x < y) + " " + (x >= 30) + " " + (x <= y));  // false true true true false true
		// derleme hatasi: if (x = 5) { ... }
		// error: incompatible types: int cannot be converted to boolean
	}

	// Mantiksal Islecler
	static void mantiksal() {
		int x = 10, y = 20, z = 30;
		System.out.println(x < y && y < z);  // true
		System.out.println(x > y || y < z);  // true
		System.out.println(!(x < y));        // false
		int yas = 20;
		boolean ehliyet = true;
		System.out.println(yas >= 18 && ehliyet);  // true
	}

	// Kisa Devre: sol taraf false ise sag taraf (sifira bolme) hic hesaplanmaz
	static void kisaDevre() {
		int bolen = 0;
		int sayi = 10;
		if (bolen != 0 && sayi / bolen > 1) {
			System.out.println("Oran 1'den buyuk");
		} else {
			System.out.println("Bolunemez ya da kucuk");  // Bolunemez ya da kucuk
		}
	}

	// Uclu Islec: sonuc = (kosul) ? deger1 : deger2;
	static void ucluIslec() {
		int sayi = -5;
		String sonuc = (sayi > 0) ? "Pozitif" : "Negatif";
		System.out.println("Sayi " + sonuc);  // Sayi Negatif
	}

	// Ayni karar if-else ile
	static void ifElseIle() {
		int sayi = -5;
		String sonuc;
		if (sayi > 0) {
			sonuc = "Pozitif";
		} else {
			sonuc = "Negatif";
		}
		System.out.println("Sayi " + sonuc);  // Sayi Negatif
	}

	// Ic Ice Uclu Islec: sunumdaki tablo (0, 7, -5)
	static void icIceUclu(int sayi) {
		String sonuc = (sayi == 0) ? "Sifir" : (sayi > 0) ? "Pozitif" : "Negatif";
		System.out.println("Sayi " + sonuc);
	}

	public static void main(String[] args) {
		karsilastirma();
		mantiksal();
		kisaDevre();
		ucluIslec();
		ifElseIle();
		icIceUclu(-5);  // Sayi Negatif
		icIceUclu(0);   // Sayi Sifir
		icIceUclu(7);   // Sayi Pozitif
	}
}

/* Beklenen cikti:
false true true true false true
true
true
false
true
Bolunemez ya da kucuk
Sayi Negatif
Sayi Negatif
Sayi Negatif
Sayi Sifir
Sayi Pozitif
*/
