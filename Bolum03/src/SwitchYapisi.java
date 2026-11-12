// switch-case: mevsim bulma, break unutulunca asagi dusme, char ve String ile switch,
// switch kurallari (derleme hatalari yorumda) ve Java 14+ switch ifadesi.
public class SwitchYapisi {

	// switch-case Yapisi: genel kalip, degisken yerine somut bir int
	static void genelKalip(int degisken) {
		switch (degisken) {  // kontrol edilen deger
			case 1:          // her case bir deger
				System.out.println("Islemler 1");
				break;
			case 2:
				System.out.println("Islemler 2");
				break;
			default:         // hicbiri eslesmezse
				System.out.println("Varsayilan islemler");
		}
	}

	// Ornek: Mevsim Belirleme
	static void mevsimBelirleme() {
		int ay = 4;
		String mevsim;
		switch (ay) {
			case 3: case 4: case 5:
				mevsim = "Ilkbahar";
				break;
			case 6: case 7: case 8:
				mevsim = "Yaz";
				break;
			case 9: case 10: case 11:
				mevsim = "Sonbahar";
				break;
			case 12: case 1: case 2:
				mevsim = "Kis";
				break;
			default:
				mevsim = "Bilinmiyor";
		}
		System.out.println(ay + ". ay: " + mevsim);            // 4. ay: Ilkbahar
	}

	// break Unutulursa: Asagi Dusme (fallthrough uyarisi bilincli)
	@SuppressWarnings("fallthrough")
	static void asagiDusme() {
		int gun = 2;
		switch (gun) {
			case 1:
				System.out.println("Pazartesi");
			case 2:
				System.out.println("Sali");                    // Sali
			case 3:
				System.out.println("Carsamba");                // Carsamba
				break;
			default:
				System.out.println("Diger gun");
		}
		System.out.println("switch bitti");                    // switch bitti
	}

	// switch: char
	static void charSwitch() {
		int a = 12, b = 4;
		char islem = '*';
		int sonuc;
		switch (islem) {
			case '+':  sonuc = a + b;  break;
			case '-':  sonuc = a - b;  break;
			case '*':  sonuc = a * b;  break;
			case '/':  sonuc = a / b;  break;
			default:
				System.out.println("Gecersiz islem");
				sonuc = 0;
		}
		System.out.println(a + " " + islem + " " + b
				+ " = " + sonuc);                              // 12 * 4 = 48
	}

	// switch: String
	static void stringSwitch() {
		String komut = "dur";
		switch (komut) {
			case "basla":
				System.out.println("Motor calisti");
				break;
			case "dur":
				System.out.println("Motor durdu");             // Motor durdu
				break;
			default:
				System.out.println("Bilinmeyen komut");
		}
	}

	// switch Kurallari: uc ornek de derlenmez
	static void switchKurallari() {
		double d = 2.5;
		// switch (d) { ... }
		// derleme hatasi: selector type double is not allowed
		int a = 1;
		int b = 2;
		// switch (a) { case b: break; }
		// derleme hatasi: constant expression required
		// switch (a) { case 1: break; case 1: break; }
		// derleme hatasi: duplicate case label

		// Duzeltilmis halleri: secici int, etiketler sabit ve farkli
		final int B = 2;
		switch ((int) d) {
			case 1: break;
			case B: System.out.println("(int) d = " + (int) d); break;   // (int) d = 2
		}
		switch (a) {
			case 1: System.out.println("a = " + a); break;               // a = 1
			case 2: break;
		}
		System.out.println("b = " + b);                                  // b = 2
	}

	// Yeni switch (Java 14+)
	static void yeniSwitch() {
		int ay = 11;
		String mevsim = switch (ay) {
			case 3, 4, 5 -> "Ilkbahar";
			case 6, 7, 8 -> "Yaz";
			case 9, 10, 11 -> "Sonbahar";
			case 12, 1, 2 -> "Kis";
			default -> "Bilinmiyor";
		};
		System.out.println(mevsim);                            // Sonbahar
	}

	public static void main(String[] args) {
		genelKalip(2);                                         // Islemler 2
		genelKalip(9);                                         // Varsayilan islemler
		mevsimBelirleme();
		asagiDusme();
		charSwitch();
		stringSwitch();
		switchKurallari();
		yeniSwitch();
	}
}

/* Beklenen cikti:
Islemler 2
Varsayilan islemler
4. ay: Ilkbahar
Sali
Carsamba
switch bitti
12 * 4 = 48
Motor durdu
(int) d = 2
a = 1
b = 2
Sonbahar
*/
