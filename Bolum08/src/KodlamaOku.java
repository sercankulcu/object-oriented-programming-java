import java.io.*;
import java.nio.charset.StandardCharsets;

// Karakter kodlamasini belirtmek: UTF-8 yazilan dosya ISO-8859-1 ile okunursa Turkce harfler bozulur.
// Metin Turkce harfleri gostermek icin unicode kacislariyla yazildi.
public class KodlamaOku {
	public static void main(String[] args) throws IOException {
		File dosya = new File("turkce.txt");
		try (BufferedWriter yazici = new BufferedWriter(
				new FileWriter(dosya, StandardCharsets.UTF_8))) {    // Java 11+
			yazici.write("I\u015f\u0131k, \u015fim\u015fek, \u00e7i\u011f, \u00f6\u011frenci, \u00dcnye");
		}
		try (BufferedReader dogru = new BufferedReader(
				new FileReader(dosya, StandardCharsets.UTF_8))) {
			System.out.println(dogru.readLine());    // Turkce harfleriyle dogru metin: Isik, simsek, cig, ogrenci, Unye
		}
		try (BufferedReader yanlis = new BufferedReader(
				new FileReader(dosya, StandardCharsets.ISO_8859_1))) {
			System.out.println(yanlis.readLine());   // bozuk metin: her Turkce harf iki Latin-1 karakteri olur
		}
		dosya.delete();
	}
}

/* Beklenen cikti:
Işık, şimşek, çiğ, öğrenci, Ünye
IÅÄ±k, ÅimÅek, Ã§iÄ, Ã¶Ärenci, Ãnye
*/
