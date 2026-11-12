import java.util.Locale;
import java.util.Scanner;

// Dizgi (String) temelleri: olusturma, birlestirme sirasi, indisleme, yararli metotlar,
// degistirilemezlik, Turkce harfler ve yerel ayar, StringBuilder.
// Turkce harfler ASCII kaynak icin unicode kacislariyla yazilir.
public class DizgiTemelleri {

	// Dizgi (String) Nedir?
	static void dizgiNedir() {
		String ad = "Tarkan";
		String adSoyad = "Mustafa Sandal";
		String nokta = "(" + 3 + ", " + 5 + ")";
		System.out.println(ad);                                // Tarkan
		System.out.println(adSoyad);                           // Mustafa Sandal
		System.out.println(nokta);                             // (3, 5)
	}

	// Olusturma ve Birlestirme
	static void olusturmaVeBirlestirme() {
		String s0 = "Giresun";            // deyim
		char[] harfler = {'J', 'a', 'v', 'a'};
		String s1 = new String(harfler);  // char[]
		String s2 = String.valueOf(42);   // sayidan
		String s3 = "Giresun".concat(" \u00dcni.");
		System.out.println(s0);                                // Giresun
		System.out.println(s1 + " " + s2 + " " + s3);          // Java 42 Giresun Uni.

		System.out.println("Toplam: " + 3 + 5);                // Toplam: 35
		System.out.println("Toplam: " + (3 + 5));              // Toplam: 8
		System.out.println(3 + 5 + " elma");                   // 8 elma
		System.out.println('a' + 'b' + "c");                   // 195c
		System.out.println("" + 'a' + 'b');                    // ab
	}

	// Birlestirme Sirasi: Kod Izleme
	static void birlestirmeSirasi() {
		int a = 4, b = 2;
		String s1 = "Sonu\u00e7: " + a + b;
		String s2 = "Sonu\u00e7: " + (a + b);
		String s3 = a + b + " kalem";
		String s4 = 'x' + 'y' + "z";
		String s5 = "" + 'x' + 'y';
		System.out.println(s1 + " | " + s2);                   // Sonuc: 42 | Sonuc: 6
		System.out.println(s3 + " | " + s4 + " | " + s5);      // 6 kalem | 241z | xy
	}

	// Indisleme
	static void indisleme() {
		String isim = "Tarkan";
		System.out.println(isim.length());                     // 6
		System.out.println(isim.charAt(0));                    // T
		System.out.println(isim.charAt(isim.length() - 1));    // n
		char c = isim.charAt(2);
		System.out.println(c + 1);                             // 115
		System.out.println((char) (c + 1));                    // s

		String s = "Java";
		try {
			System.out.println(s.charAt(4));
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println(e);
			// java.lang.StringIndexOutOfBoundsException: Index 4 out of bounds for length 4
		}
	}

	// Karakterlerde Gezinmek: Adim Adim (girdi: Giresun)
	static void karakterlerdeGezinmek(String girdi) {
		Scanner scanner = new Scanner(girdi);
		System.out.print("Bir kelime giriniz: ");
		String kelime = scanner.nextLine();
		for (int i = 0; i < kelime.length(); i += 2) {
			char harf = kelime.charAt(i);
			System.out.println((i + 1) + ". harf: " + harf);
		}
		// Bir kelime giriniz: 1. harf: G / 3. harf: r / 5. harf: s / 7. harf: n
		scanner.close();
	}

	// Metotlar: Adim Adim
	static void metotlar() {
		String str = "Java Programlama";
		int indeks = str.indexOf("Programlama");
		int uzunluk = str.length();
		String alt = str.substring(5, 12);
		String son = str.substring(5);
		String kucuk = str.toLowerCase();
		String buyuk = str.toUpperCase();
		System.out.println(indeks + " " + uzunluk);            // 5 16
		System.out.println(alt + " | " + son);                 // Program | Programlama
		System.out.println(kucuk + " | " + buyuk);             // java programlama | JAVA PROGRAMLAMA
	}

	// Diger Yararli Metotlar
	static void digerMetotlar() {
		String s = "  Merhaba D\u00fcnya  ";
		System.out.println("[" + s.trim() + "]");              // [Merhaba Dunya]
		System.out.println("[" + s.replace('a', 'e') + "]");   // [  Merhebe Dunye  ]
		String[] meyveler = "elma,armut,kiraz".split(",");
		System.out.println(meyveler.length);                   // 3
		System.out.println(meyveler[1]);                       // armut
		System.out.println(String.join(" - ", meyveler));      // elma - armut - kiraz
		System.out.println("ab".repeat(3));       // Java 11+     ababab
		System.out.println("".isEmpty());                      // true
		System.out.println("   ".isBlank());      // Java 11+     true
		char[] dizi = "Java".toCharArray();
		System.out.println(dizi.length + " " + dizi[0]);       // 4 J
		System.out.println("Giresun".replace("sun", "SUN"));   // GireSUN
		System.out.println(String.valueOf(3.5) + 1);           // 3.51
		System.out.println(Integer.parseInt("42") + 1);        // 43
	}

	// Degistirilemez (Immutable): toUpperCase yeni dizgi dondurur
	static void degistirilemez() {
		String s = "Giresun \u00dcniversitesi";
		s.toUpperCase();      // sonuc kaybolur
		System.out.println(s);                                 // Giresun Universitesi
		s = s.toUpperCase();  // sonuc s'ye atanir
		System.out.println(s);                                 // GIRESUN UNIVERSITESI (Turkce noktali I ile)
	}

	// Turkce Harfler ve Yerel Ayar: varsayilan yerel ayar tr-TR
	static void turkceHarfler() {
		String s = "Giresun \u00dcniversitesi";
		System.out.println(s.toUpperCase());                   // GIRESUN UNIVERSITESI (noktali I)
		System.out.println(s.toUpperCase(Locale.ROOT));        // GIRESUN UNIVERSITESI (noktasiz I)
		System.out.println("TITLE".toLowerCase());             // title (noktasiz i ile)
		System.out.println("TITLE".toLowerCase().equals("title"));   // false
		System.out.println("TITLE".toLowerCase(Locale.ROOT));  // title
	}

	// StringBuilder
	static void stringBuilder() {
		String sonuc = "";
		for (int i = 1; i <= 5; i++) {
			sonuc += i + " ";   // her turda yeni String
		}
		System.out.println(sonuc);                             // 1 2 3 4 5

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 5; i++) {
			sb.append(i).append(' ');   // ayni nesne buyur
		}
		String metin = sb.toString();
		System.out.println(metin);                             // 1 2 3 4 5

		StringBuilder ters = new StringBuilder("Giresun");
		ters.reverse();
		System.out.println(ters);                              // nuseriG
		StringBuilder k = new StringBuilder("Java");
		k.insert(0, ">> ").append('!');
		k.setCharAt(3, 'j');
		System.out.println(k + " " + k.length());              // >> java! 8
	}

	// StringBuilder: Kod Izleme
	static void stringBuilderIzleme() {
		StringBuilder sb = new StringBuilder("Java");
		sb.append(' ').append(8);
		sb.insert(0, ">> ");
		sb.setCharAt(3, 'j');
		sb.deleteCharAt(sb.length() - 1);
		sb.append("programlama dili");
		String s = sb.toString();
		System.out.println(s + " " + sb.length() + " " + sb.capacity());   // >> java programlama dili 24 42
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.forLanguageTag("tr-TR"));   // sunumdaki ciktilar Turkce yerel ayarla
		dizgiNedir();
		olusturmaVeBirlestirme();
		birlestirmeSirasi();
		indisleme();
		karakterlerdeGezinmek("Giresun");
		metotlar();
		digerMetotlar();
		degistirilemez();
		turkceHarfler();
		stringBuilder();
		stringBuilderIzleme();
	}
}

/* Beklenen cikti:
Tarkan
Mustafa Sandal
(3, 5)
Giresun
Java 42 Giresun Üni.
Toplam: 35
Toplam: 8
8 elma
195c
ab
Sonuç: 42 | Sonuç: 6
6 kalem | 241z | xy
6
T
n
115
s
java.lang.StringIndexOutOfBoundsException: Index 4 out of bounds for length 4
Bir kelime giriniz: 1. harf: G
3. harf: r
5. harf: s
7. harf: n
5 16
Program | Programlama
java programlama | JAVA PROGRAMLAMA
[Merhaba Dünya]
[  Merhebe Dünye  ]
3
armut
elma - armut - kiraz
ababab
true
true
4 J
GireSUN
3.51
43
Giresun Üniversitesi
GİRESUN ÜNİVERSİTESİ
GİRESUN ÜNİVERSİTESİ
GIRESUN ÜNIVERSITESI
tıtle
false
title
1 2 3 4 5
1 2 3 4 5
nuseriG
>> java! 8
>> java programlama dili 24 42
*/
