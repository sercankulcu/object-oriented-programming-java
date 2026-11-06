import java.util.Locale;
import java.util.Scanner;

// Dizgi uygulamalari: palindrom, kelime frekansi, ornek problemler ve alistirmalar.
// Turkce yerel ayar: "Iki" (noktali I) kucuk harfe "iki" olarak cevrilir.
public class DizgiUygulamalari {

	// Palindrom: Adim Adim
	static void palindrom() {
		String metin = "Kayak";
		metin = metin.toLowerCase();
		String ters = "";
		for (int i = metin.length() - 1; i >= 0; i--) {
			ters += metin.charAt(i);
		}
		System.out.println(ters);                              // kayak
		System.out.println(metin.equals(ters));                // true
	}

	// Kelime Frekansi
	static void kelimeFrekansi() {
		String metin = "Bir iki bir \u00fc\u00e7 \u0130ki bir";
		String[] kelimeler = metin.toLowerCase().split(" ");
		boolean[] sayildi = new boolean[kelimeler.length];
		for (int i = 0; i < kelimeler.length; i++) {
			if (sayildi[i]) {
				continue; // bu kelime daha once sayildi
			}
			int frekans = 1;
			for (int j = i + 1; j < kelimeler.length; j++) {
				if (kelimeler[i].equals(kelimeler[j])) {
					frekans++;
					sayildi[j] = true;
				}
			}
			System.out.println(kelimeler[i] + ": " + frekans);
		}
		// bir: 3
		// iki: 2
		// uc: 1
	}

	// Kelime Frekansi: Kod Izleme
	static void kelimeFrekansiIzleme() {
		String metin = "elma Armut elma kiraz ARMUT";
		String[] k = metin.toLowerCase().split(" ");
		boolean[] sayildi = new boolean[k.length];
		for (int i = 0; i < k.length; i++) {
			if (sayildi[i]) continue;
			int frekans = 1;
			for (int j = i + 1; j < k.length; j++) {
				if (k[i].equals(k[j])) {
					frekans++;
					sayildi[j] = true;
				}
			}
			System.out.println(k[i] + ": " + frekans);
		}
		// elma: 2
		// armut: 2
		// kiraz: 1
	}

	// Ornek Problemler (1)
	static void ornekProblemler1() {
		String s = "Karadeniz";
		s.toUpperCase();
		String t = s.substring(2, 5);
		System.out.println(t + " " + t.length());              // rad 3
		System.out.println(s.indexOf("de"));                   // 4
		System.out.println(s.indexOf("x"));                    // -1
		System.out.println(1 + 2 + "3" + 4 + 5);               // 3345

		String a = "ders";
		String b = "de" + "rs";
		String c = new String("ders");
		String d = c;
		System.out.println(a == b);                            // true
		System.out.println(a == c);                            // false
		System.out.println(c == d);                            // true
		System.out.println(a.equals(c));                       // true
	}

	// Ornek Problemler (2)
	public static String bas(String ad, String soyad) {
		return ad.charAt(0) + "." + soyad.charAt(0) + ".";
	}

	static void ornekProblemler2() {
		String ad = "Ali";
		double not1 = 72.456;
		System.out.printf("[%-5s][%3d][%7.2f]%n", ad, 7, not1);   // [Ali  ][  7][  72,46]

		System.out.println(bas("Sercan", "K\u00fclc\u00fc"));       // S.K.
		String e = "ogrenci@giresun.edu.tr";
		int at = e.indexOf('@');
		System.out.println(e.substring(0, at));                   // ogrenci
		System.out.println(e.substring(at + 1));                  // giresun.edu.tr
	}

	// Alistirmalar (1)
	static String tersCevir(String s) {
		String ters = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			ters += s.charAt(i);
		}
		return ters;
	}

	static String basHarfBuyuk(String kelime) {
		return kelime.substring(0, 1).toUpperCase()
				+ kelime.substring(1).toLowerCase();
	}

	static int say(String s, char aranan) {
		int adet = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == aranan) {
				adet++;
			}
		}
		return adet;
	}

	// Alistirmalar (2)
	static void alistirmalar2() {
		String kelime = "Ordu";
		String sesliler = "ae\u0131io\u00f6u\u00fcAEI\u0130O\u00d6U\u00dc";
		int sayac = 0;
		for (int i = 0; i < kelime.length(); i++) {
			char c = kelime.charAt(i);
			if (sesliler.indexOf(c) != -1) {
				sayac++;
			}
		}
		System.out.println("Sesli: " + sayac);                    // Sesli: 2

		Scanner k = new Scanner("20\nAli Veli\n");
		System.out.print("Ya\u015f: ");
		int yas = k.nextInt();
		k.nextLine();   // satir sonunu at
		System.out.print("Ad: ");
		String ad = k.nextLine();
		System.out.printf("Ad: %s, Ya\u015f: %d%n", ad, yas);     // Yas: Ad: Ad: Ali Veli, Yas: 20
		k.close();
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.forLanguageTag("tr-TR"));
		palindrom();
		kelimeFrekansi();
		kelimeFrekansiIzleme();
		ornekProblemler1();
		ornekProblemler2();
		System.out.println(tersCevir("Giresun"));                 // nuseriG
		System.out.println(basHarfBuyuk("jAVA"));                 // Java
		System.out.println(say("Karadeniz", 'a'));                // 2
		alistirmalar2();
	}
}
