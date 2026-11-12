// Derlenmeyen ornekler: soz dizimi ve statik anlam hatalari. Her hatali
// satir yorumda, derleyicinin mesajiyla birlikte; altinda duzeltilmis hali.
public class DerlemeHatalari {

	// Temel Yapilar ve Soz Dizimi
	static void sozDizimi() {
		int x = 5;
		// derleme hatasi: int = x 5;
		// Hata.java:3: error: not a statement ... 4 errors
		System.out.println(x);  // 5
	}

	// Statik Anlam: soz dizimi dogru, tipler uyumsuz
	static void statikAnlam() {
		// derleme hatasi: double sonuc = 2.3 / "abc";
		// error: bad operand types for binary operator '/'
		double sonuc = 2.3 / Double.parseDouble("2.3");
		System.out.println(sonuc);  // 1.0
		// derleme hatasi: int x = "bes";
		// error: incompatible types: String cannot be converted to int
		int x = Integer.parseInt("5");
		System.out.println(x);  // 5
	}

	// Dinamik ve Statik Tipleme
	// Python (dinamik):  x = 5; x = "bes"; print(x + 1) -> calisirken TypeError
	static void statikTipleme() {
		int x = 5;
		// derleme hatasi: x = "bes";
		// error: incompatible types: String cannot be converted to int
		String y = "bes";
		System.out.println(x + " " + y);  // 5 bes
	}

	// Ifadeler, Deyimler ve Programlar
	static void ifadelerDeyimler() {
		double pi = Math.PI;
		// derleme hatasi: double d = 3 + System.out.println(pi);
		// error: 'void' type not allowed here
		System.out.println(pi);  // 3.141592653589793
		double d = 3 + pi;
		// derleme hatasi: 3 + 4;      // deger uretir ama etkisi yok
		// error: not a statement
		int yedi = 3 + 4;
		System.out.println(d + " " + yedi);  // 6.141592653589793 7
	}

	// Gecerli mi? Ad rakamla baslayamaz
	static void gecerliMi() {
		// derleme hatasi: int 2yas = 20;
		// Tanim.java:3: error: not a statement / error: ';' expected (2 errors)
		int yas2 = 20;
		System.out.println(yas2);  // 20
	}

	// Anahtar Sozcukler: ayrilmis sozcuk degisken adi olamaz
	static void anahtarSozcukler() {
		// derleme hatasi: int new = 5;
		// Anahtar.java:3: error: not a statement ... (toplam 4 hata)
		int yeni = 5;
		System.out.println(yeni);  // 5
	}

	// Ilk Deger: yerel degisken kullanilmadan once deger almali
	static void ilkDeger() {
		int sayac;
		// derleme hatasi: System.out.println(sayac);
		// Ilk.java:4: error: variable sayac might not have been initialized
		sayac = 0;
		System.out.println(sayac);  // 0
	}

	// Karsilastirma Islecleri: = atamadir, == karsilastirmadir
	static void atamaKarsilastirma() {
		int x = 10;
		// derleme hatasi: if (x = 5) { ... }
		// error: incompatible types: int cannot be converted to boolean
		if (x == 5) {
			System.out.println("bes");
		} else {
			System.out.println("bes degil");  // bes degil
		}
	}

	public static void main(String[] args) {
		sozDizimi();
		statikAnlam();
		statikTipleme();
		ifadelerDeyimler();
		gecerliMi();
		anahtarSozcukler();
		ilkDeger();
		atamaKarsilastirma();
	}
}

/* Beklenen cikti:
5
1.0
5
5 bes
3.141592653589793
6.141592653589793 7
20
5
0
bes degil
*/
