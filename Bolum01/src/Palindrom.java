import java.util.Locale;

// Palindrom: metni temizler, ters cevirir ve karsilastirir.
// Sozde koddaki Temizle ve TersCevir alt adimlari metot olarak yazildi.
public class Palindrom {

	// Temizle: kucuk harf, bosluk ve noktalama yok
	static String temizle(String girdiMetin) {
		return girdiMetin.toLowerCase(Locale.forLanguageTag("tr"))
				.replaceAll("[^\\p{L}\\p{N}]", "");
	}

	// TersCevir: metni sondan basa yazar
	static String tersCevir(String temizMetin) {
		return new StringBuilder(temizMetin).reverse().toString();
	}

	static void calistir(String girdiMetin) {
		String temizMetin = temizle(girdiMetin);
		String tersGirdi = tersCevir(temizMetin);
		if (temizMetin.equals(tersGirdi)) {
			System.out.println("Girilen metin bir palindromdur.");
		} else {
			System.out.println("Girilen metin bir palindrom degildir.");
		}
	}

	public static void main(String[] args) {
		calistir("abcba");  // Girilen metin bir palindromdur.
		calistir("Kitap");  // Girilen metin bir palindrom degildir.
	}
}

/* Beklenen cikti:
Girilen metin bir palindromdur.
Girilen metin bir palindrom degildir.
*/
